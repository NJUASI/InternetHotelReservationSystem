package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataHelper.CreditDataHelper;
import dataService.creditDataService.CreditDataService;
import po.CreditPO;
import utilities.ResultMessage;

public class CreditDataServiceImpl extends UnicastRemoteObject implements CreditDataService{

	
	public CreditDataServiceImpl() throws RemoteException {
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
