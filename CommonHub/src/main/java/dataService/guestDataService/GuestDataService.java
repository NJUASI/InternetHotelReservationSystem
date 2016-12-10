package dataService.guestDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import exception.verificationException.UserInexistException;
import po.GuestPO;
import po.MemberPO;
import utilities.enums.ResultMessage;

public interface GuestDataService extends Remote {

	public GuestPO getSingleGuest(String guestID) throws RemoteException, UserInexistException;

	public List<GuestPO> getAllGuest() throws RemoteException;

	public GuestPO add(GuestPO newGuestPO) throws RemoteException;

	public ResultMessage modifyMember(MemberPO memberPO) throws RemoteException;

	public ResultMessage modify(GuestPO guestPO) throws RemoteException;
	
}
