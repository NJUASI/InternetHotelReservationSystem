package dataService.guestDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.GuestPO;
import po.MemberPO;
import utilities.enums.ResultMessage;

/**
 * 
 * @author cuihua
 * @lastChangedBy charles
 * @updateTime 2017/1/1
 * 
 * 对数据库中客户相关的操作
 */
public interface GuestDataService extends Remote {

	public GuestPO getSingleGuest(String guestID) throws RemoteException;

	public List<GuestPO> getAllGuest() throws RemoteException;

	public GuestPO add(GuestPO newGuestPO) throws RemoteException;

	public ResultMessage modifyMember(MemberPO memberPO) throws RemoteException;

	public ResultMessage modify(GuestPO guestPO) throws RemoteException;
	
}
