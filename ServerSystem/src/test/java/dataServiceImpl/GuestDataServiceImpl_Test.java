package dataServiceImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import dataService.guestDataService.GuestDataService;
import po.CreditPO;
import po.GuestPO;
import po.MemberPO;
import utilities.ResultMessage;

public class GuestDataServiceImpl_Test {

	@Test
	public void testGetSingleGuest() {
		//test the method GetSingleGuest
		LocalDate birthday = LocalDate.of(1995, 1, 1);
		try {
			GuestDataService guest = new GuestDataServiceImpl();
			GuestPO guestPO  = guest.getSingleGuest("1234567890");
			assertEquals(guestPO.getGuestID(),"1234567890");
			assertEquals(guestPO.getBirthday(),birthday);
			assertEquals(guestPO.getEnterprise(),"school");
			assertEquals(guestPO.getName(),"zhangsan");
			assertEquals(guestPO.getNickName(),"xiaosan");
			assertEquals(guestPO.getPassword(),"000000");
			assertEquals(guestPO.getPhone(),"13523456789");
			assertEquals(guestPO.getCredit(),100,0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllGuest() {
		//test the method GetAllGuest
		LocalDate birthday = LocalDate.of(1995, 1, 1);
		try {
			GuestDataService guest = new GuestDataServiceImpl();
			List<GuestPO> list = guest.getAllGuest();
			GuestPO guestPO  = list.get(0);
			assertEquals(guestPO.getGuestID(),"1234567890");
			assertEquals(guestPO.getBirthday(),birthday);
			assertEquals(guestPO.getEnterprise(),"school");
			assertEquals(guestPO.getName(),"zhangsan");
			assertEquals(guestPO.getNickName(),"xiaosan");
			assertEquals(guestPO.getPassword(),"000000");
			assertEquals(guestPO.getPhone(),"13523456789");
			assertEquals(guestPO.getCredit(),100,0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllCreditDetail() {
		//test the method GetAllCreditDetail
		try {
			GuestDataService guest = new GuestDataServiceImpl();
			List<CreditPO> list = guest.getAllCreditDetail("1234567890");
			CreditPO creditPO  = list.get(0);
			assertEquals(creditPO.getGuestID(),"1234567890");
			assertEquals(creditPO.getTime(),LocalDateTime.of(2016, 10, 2, 18, 12));
			assertEquals(creditPO.getOrderID(),"123420161002");
			assertEquals(creditPO.getCredit(),100,0);
			assertEquals(creditPO.getPreCredit(),100,0);
			assertEquals(creditPO.getReason(),"undo");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAdd() {
		//test the method Add
		LocalDate birthday = LocalDate.of(1995, 1, 1);
		try {
			GuestDataService guest = new GuestDataServiceImpl();
			GuestPO guestPO = new GuestPO("1234567890", birthday, "school", "zhangsan", "xiaosan", "000000", "13523456789", 100);
			assertEquals(guest.add(guestPO),ResultMessage.FAIL);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testModifyMember() {
		//test the method ModifyMember
		LocalDate time = LocalDate.of(1995, 1, 1);
		try {
			GuestDataService guest = new GuestDataServiceImpl();
			MemberPO memberPO = new MemberPO("1234567890",time,"school");
			assertEquals(guest.modifyMember(memberPO),ResultMessage.SUCCESS);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testModify() {
		//test the method Modify
		LocalDate birthday = LocalDate.of(1995, 1, 1);
		try {
			GuestDataService guest = new GuestDataServiceImpl();
			GuestPO guestPO = new GuestPO("1234567890", birthday, "school", "zhangsan", "xiaosan", "000000", "13523456789", 100);
			assertEquals(guest.modify(guestPO),ResultMessage.SUCCESS);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
