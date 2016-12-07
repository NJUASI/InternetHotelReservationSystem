package businessLogicService.creditBLService;

import java.rmi.RemoteException;
import java.util.List;

import dataService.creditDataService.CreditDataService;
import po.CreditPO;
import utilities.ResultMessage;

public class CreditDataService_Stub implements CreditDataService {

	@Override
	public List<CreditPO> getAllCreditDetail(String guestID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage addCredit(CreditPO creditPO) throws RemoteException {
		return null;
	}

	@Override
	public List<CreditPO> getCreditOfOneOrder(String orderID) throws RemoteException {
		return null;
	}

}
