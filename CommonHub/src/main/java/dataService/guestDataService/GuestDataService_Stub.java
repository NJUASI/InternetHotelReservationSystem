package dataService.guestDataService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import po.CreditPO;
import po.GuestPO;
import po.MemberPO;
import utilities.CreditRecord;
import utilities.ResultMessage;

public class GuestDataService_Stub extends UnicastRemoteObject implements GuestDataService{

	
	public GuestDataService_Stub() throws RemoteException {
		super();
	}


	public GuestPO getSingleGuest(String guestID) {
		LocalDate birthday = LocalDate.of(1995, 1, 1);
		
		return new GuestPO("1234567890", birthday, "school", "zhangsan", "xiaosan",
				"000000", "13523456789",100);
	}


	public List<GuestPO> getAllGuest() {
		List<GuestPO> list = new ArrayList<GuestPO>();
		GuestPO a= new GuestPO("1234567890", LocalDate.of(1995, 1, 1), "school", "zhangsan", "xiaosan",
				"000000", "13523456789",100);
		list.add(a);
		return list;
	}


	public List<CreditPO> getAllCreditDetail(String guestID) {
		List<CreditPO> creditDetailList = new LinkedList<CreditPO>();
		creditDetailList.add(new CreditPO("1234567890", LocalDateTime.of(2016, 10, 2, 18, 12), "123420161002", 100, 100, CreditRecord.UNDO_ABNORMAL));
		creditDetailList.add(new CreditPO("1234567890", LocalDateTime.of(2016, 10, 3, 13, 14), "124520161003", 100, 100, CreditRecord.EXECUTE));
		creditDetailList.add(new CreditPO("1234567890", LocalDateTime.of(2016, 10, 4, 15, 22), "244520161004", 100, 300, CreditRecord.EXECUTE));
		return creditDetailList;
	}


	public GuestPO add(GuestPO newGuestPO) {
		LocalDate birthday = LocalDate.of(1995, 1, 1);
		
		return new GuestPO("1234567890", birthday, "school", "zhangsan", "xiaosan",
				"000000", "13523456789",100);
	}


	public ResultMessage modifyMember(MemberPO memberPO) {
		return ResultMessage.SUCCESS;
	}


	public ResultMessage modify(GuestPO guestPO) {
		return ResultMessage.SUCCESS;
	}

}
