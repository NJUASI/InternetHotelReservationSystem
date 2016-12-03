package dataService.guestDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CreditPO;
import po.GuestPO;
import po.MemberPO;
import utilities.ResultMessage;

public interface GuestDataService extends Remote{
	
	public GuestPO getSingleGuest(String guestID) throws RemoteException;
	
	public List<GuestPO> getAllGuest() throws RemoteException;

	public List<CreditPO> getAllCreditDetail(String guestID) throws RemoteException;
	
	public ResultMessage add(GuestPO newGuestPO) throws RemoteException;

	public ResultMessage modifyMember(MemberPO memberPO) throws RemoteException;

	public ResultMessage modify(GuestPO guestPO) throws RemoteException;
	
}
