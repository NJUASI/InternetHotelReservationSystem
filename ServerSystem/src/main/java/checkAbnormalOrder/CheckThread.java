package checkAbnormalOrder;

import java.time.LocalDateTime;
import java.util.List;

import dataHelper.OrderDataHelper;
import dataHelperImpl.DataFactoryImpl;
import po.OrderPO;
import utilities.enums.OrderState;

public class CheckThread implements Runnable {

	OrderDataHelper orderDateHelper;
	
	public CheckThread() {
		orderDateHelper = DataFactoryImpl.getInstance().getOrderDataHelper();
	}
	@Override
	public void run() {
		
		List<OrderPO> unexecutedOrders = orderDateHelper.getUnexecuted();
		
		System.out.println(unexecutedOrders.size()+" "+LocalDateTime.now());
		
		for(int i = 0;i < unexecutedOrders.size();i++){
			OrderPO po = unexecutedOrders.get(i);
			System.out.println(po.getGuestID()+"  "+po.getState());
			if(po.getExpectExecuteTime().isBefore(LocalDateTime.now())){
				System.out.println("有订单异常");
				orderDateHelper.setState(po.getOrderID(), OrderState.ABNORMAL);
			}
		}
		
		try {
			//每10s运行一次
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
