package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataHelper.CreditDataHelper;
import dataHelperImpl.stub.CreditDataHelperImpl_Stub;
import dataService.creditDataService.CreditDataService;
import po.CreditPO;
import utilities.ResultMessage;

public class CreditDataServiceImpl extends UnicastRemoteObject implements CreditDataService{

	
	CreditDataHelper creditDataHelper;
	
	public CreditDataServiceImpl() throws RemoteException {
		super();
		creditDataHelper = new CreditDataHelperImpl_Stub();
//		creditDataHelper = new CreditDataHelperImpl();
	}

	@Override
	public List<CreditPO> getAllCreditDetail(String guestID) throws RemoteException {
		return creditDataHelper.getAllCreditDetail(guestID);
	}

	@Override
	public ResultMessage addCredit(CreditPO creditPO) throws RemoteException {
		return creditDataHelper.addCredit(creditPO);
	}

	@Override
	public List<CreditPO> getCreditOfOneOrder(String guestID) throws RemoteException {
		return creditDataHelper.getCreditOfOneOrder(guestID);
	}

}
