package checkAbnormalOrder;

import java.time.LocalDateTime;
import java.util.List;

import dataHelper.CreditDataHelper;
import dataHelper.GuestDataHelper;
import dataHelper.OrderDataHelper;
import dataHelperImpl.DataFactoryImpl;
import po.CreditPO;
import po.OrderPO;
import utilities.enums.CreditRecord;
import utilities.enums.OrderState;

public class CheckThread implements Runnable {

	OrderDataHelper orderDateHelper;
	CreditDataHelper creditDataHelper;
	GuestDataHelper guestDataHelper;
	
	public CheckThread() {
		orderDateHelper = DataFactoryImpl.getInstance().getOrderDataHelper();
		creditDataHelper = DataFactoryImpl.getInstance().getCreditDataHelper();
		guestDataHelper = DataFactoryImpl.getInstance().getGuestDataHelper();
	}
	@Override
	public void run() {
		
		List<OrderPO> unexecutedOrders = orderDateHelper.getUnexecuted();
		
		for(int i = 0;i < unexecutedOrders.size();i++){
			OrderPO po = unexecutedOrders.get(i);
			if(timePassed(po)){
				//将该order的状态置为异常
				orderDateHelper.setState(po.getOrderID(), OrderState.ABNORMAL);
				//添加一条异常信用记录
				addAbnormalCredit(po.getGuestID(),po.getOrderID(),po.getPrice());
			}
		}
		try {
			//每5s运行一次
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description:增加一条异常信用记录
	 * void
	 * @author: Harvey Gong
	 * @param guestID 
	 * @param price 
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月14日 下午10:08:13
	 */
	private void addAbnormalCredit(String guestID,String orderID,int price) {
		CreditPO po = new CreditPO();
		po.setCreditRecord(CreditRecord.OVERDUE);
		po.setGuestID(guestID);
		po.setOrderID(orderID);
		
		double preCredit = guestDataHelper.getSingle(guestID).getCredit();
		double afterCredit = preCredit-price;
		
		po.setPreCredit(preCredit);
		po.setAfterCredit(afterCredit);
		po.setTime(LocalDateTime.now());
		
		creditDataHelper.addCredit(po);
	}
	/**
	 * @Description:判断是否超过预期入住时间
	 * @param po
	 * @return
	 * boolean
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月14日 下午10:07:56
	 */
	private boolean timePassed(OrderPO po){
		if(po.getExpectExecuteTime().isBefore(LocalDateTime.now())){
			return true;
		}
		else
		{
			return false;
		}
	}

}
