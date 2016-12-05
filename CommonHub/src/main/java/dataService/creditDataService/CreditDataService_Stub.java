package dataService.creditDataService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import po.CreditPO;
import utilities.ResultMessage;

public class CreditDataService_Stub extends UnicastRemoteObject implements CreditDataService {

	public CreditDataService_Stub() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public List<CreditPO> getAllCreditDetail(String guestID) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage addCredit(CreditPO creditPO) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<CreditPO> getCreditOfOneOrder(String guestID) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
