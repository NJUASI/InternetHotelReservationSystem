package dataService.guestDataService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import po.CreditPO;
import po.GuestPO;
import po.MemberPO;
import utilities.ResultMessage;

public class GuestDataService_Stub implements GuestDataService{

	
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
		creditDetailList.add(new CreditPO("1234567890", LocalDateTime.of(2016, 10, 2, 18, 12), "123420161002", 100, 100, "undo"));
		creditDetailList.add(new CreditPO("1234567890", LocalDateTime.of(2016, 10, 3, 13, 14), "124520161003", 100, 100, "create"));
		creditDetailList.add(new CreditPO("1234567890", LocalDateTime.of(2016, 10, 4, 15, 22), "244520161004", 100, 300, "executed"));
		return creditDetailList;
	}


	public ResultMessage add(GuestPO newGuestPO) {
		return ResultMessage.SUCCESS;
	}


	public ResultMessage modifyMember(MemberPO memberPO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}


	public ResultMessage modify(GuestPO guestPO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
