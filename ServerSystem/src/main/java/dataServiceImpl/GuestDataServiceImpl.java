package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataHelper.CreditDataHelper;
import dataHelper.GuestDataHelper;
import dataHelperImpl.stub.DataFactoryImpl_Stub;
import dataService.guestDataService.GuestDataService;
import po.CreditPO;
import po.GuestPO;
import po.MemberPO;
import utilities.ResultMessage;

/**
 * 
 * @author 董金玉 lastChangedBy 董金玉 updateTime 2016/12/1
 *
 */
public class GuestDataServiceImpl extends UnicastRemoteObject implements GuestDataService{

	private static final long serialVersionUID = 3434060152387200042L;
	
	private DataFactoryImpl_Stub factory;
	
	private GuestDataHelper guestHelper;
	
	private CreditDataHelper creditHelper;
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1 构造函数，从工厂中获取guestDataHelper,creditDataHlper对象
	 */
	public GuestDataServiceImpl() throws RemoteException {
//		this.factory = DataFactoryImpl.getInstance();
		this.factory = DataFactoryImpl_Stub.getInstance();
		this.guestHelper = this.factory.getGuestDataHelper();
		this.creditHelper = this.factory.getCreditDataHelper();
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param guestID 客户ID
	 * @return GuestPO guestInfo载体
	 */
	public GuestPO getSingleGuest(String guestID) throws RemoteException {
		
		if(guestID==null||guestID==""||guestID.length()!=10){return null;} //传入的ID无效，返回空
		
		GuestPO guestPO = guestHelper.getSingle(guestID);
		//从数据库中得到一个按ID索引的PO，若不存在则为空
		return guestPO;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @return List<GuestPO> 所有guestInfo载体
	 */
	public List<GuestPO> getAllGuest() throws RemoteException {
		List<GuestPO> list = this.guestHelper.getAll();
		//从数据库中得到所有guestPO，若不存在则为空
		if(list.isEmpty()){return null;}
		
		return list;
		}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param guestID 客户ID
	 * @return List<CreditPO> 指定客户ID的所有creditInfo载体
	 */
	public List<CreditPO> getAllCreditDetail(String guestID) throws RemoteException {
		
		if(guestID==null||guestID==""||guestID.length()!=10){return null;} //传入的ID无效，返回空
		
		List<CreditPO> list = this.creditHelper.getAll(guestID);
		// 从数据库中得到所有creditPO，若不存在则为空
		if(list.isEmpty()){return null;}
		
		return list;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/2
	 * @param newGuestPO 需要添加的guestInfo载体
	 * @return List<CreditPO> 指定客户ID的所有creditInfo载体
	 */
	public ResultMessage add(GuestPO newGuestPO) throws RemoteException {
		
		if(newGuestPO==null){return ResultMessage.FAIL;} //传入的参数为空，返回失败
		
		GuestPO guestPO = this.guestHelper.getSingle(newGuestPO.getGuestID());
		//从数据库中得到guestPO，若不存在则为空
		if(guestPO!=null){return ResultMessage.FAIL;} //根据ID索引找到对应ID指定项，则不能添加
		
		return this.guestHelper.add(newGuestPO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param memberPO 需要修改的memberInfo载体
	 * @return ResultMessage 是否成功修改会员信息
	 */
	public ResultMessage modifyMember(MemberPO memberPO) throws RemoteException {
		
		GuestPO guestPO = this.guestHelper.getSingle(memberPO.getGuestID());
		//从数据库中得到guestPO，若不存在则为空
		if(guestPO==null){
			return ResultMessage.FAIL; //为空则返回失败
		}
		
		guestPO.setBirthday(memberPO.getBirthday());
		guestPO.setEnterprise(memberPO.getEnterprise());
		
		return this.guestHelper.modify(guestPO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/2
	 * @param guestPO 需要修改的guestInfo载体
	 * @return ResultMessage 是否成功修改客户信息
	 */
	public ResultMessage modify(GuestPO guestPO) throws RemoteException {
		
		GuestPO tempGuestPO = this.guestHelper.getSingle(guestPO.getGuestID());
		//从数据库中得到guestPO，若不存在则为空
		if(tempGuestPO==null){
			return ResultMessage.FAIL; //为空则返回失败
		}
		
		return this.guestHelper.modify(guestPO);
	}

}
