package dataService.creditDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CreditPO;
import utilities.enums.ResultMessage;

public interface CreditDataService extends Remote{
	/**
	 * @Description:对信用值的操作，获取个人所有的信用值记录，添加一条信用值变化记录
	 * 可以单独提一个dataService，也可以不用
	 * @throws RemoteException
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月5日 下午1:15:46
	 */
	public List<CreditPO> getAllCreditDetail(String guestID) throws RemoteException;

	public ResultMessage addCredit(CreditPO creditPO) throws RemoteException;
	
//	public List<CreditPO> getCreditOfOneOrder(String guestID) throws RemoteException;
}
