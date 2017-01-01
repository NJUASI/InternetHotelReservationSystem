package businessLogic.userBL;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import exception.verificationException.UserInexistException;
import utilities.enums.ResultMessage;
import utilities.enums.UserType;
import vo.GuestVO;
import vo.HotelVO;
import vo.HotelWorkerVO;
import vo.UserVO;
import vo.WebManagerVO;
import vo.WebMarketerVO;

/**
 * 
 * @author 董金玉
 * lastChangedBy 董金玉
 * test the all method of userBL
 * updateTime 2016/11/28
 *
 */
public class UserTest {
	

	@Test
	public void testAdd() {
		//test the method add
		User user= new User();
		
		UserVO guestVO = new GuestVO("1234567890", LocalDate.of(1995, 1, 1), "school", "zhangsan", "xiaosan",
				"000000", "13523456789",100);
		UserVO hotelWorkerVO = new HotelWorkerVO("00001111", "123456","school");
		UserVO webMarketerVO = new WebMarketerVO("000001", "123456");
		UserVO webManagerVO = new WebManagerVO("0001", "123456");
		
		try {
			assertEquals(user.add(guestVO,UserType.GUEST).userID,"1234567890");
			assertEquals(user.add(hotelWorkerVO,UserType.HOTEL_WORKER).userID,"00001111");
			assertEquals(user.add(webMarketerVO,UserType.WEB_MARKETER).userID,"000001");
			assertEquals(user.add(webManagerVO,UserType.WEB_MANAGER).userID,"0001");
		} catch (UserInexistException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testModify() {
		//test the method modify
		User user= new User();
		
		UserVO guestVO = new GuestVO("1234567890", LocalDate.of(1995, 1, 1), "school", "zhangsan", "xiaosan",
				"000000", "13523456789",100);
		UserVO hotelWorkerVO = new HotelWorkerVO("00001111", "123456","school");
		UserVO webMarketerVO = new WebMarketerVO("000001", "123456");
		UserVO webManagerVO = new WebManagerVO("0001", "123456");
		try {
			assertEquals(user.modify(guestVO),ResultMessage.SUCCESS);
			assertEquals(user.modify(hotelWorkerVO),ResultMessage.SUCCESS);
			assertEquals(user.modify(webMarketerVO),ResultMessage.SUCCESS);
			assertEquals(user.modify(webManagerVO),ResultMessage.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	public void testGetSingle() {
		//test the method getSingle
		User user= new User();
		
		try {
			GuestVO guestVO = (GuestVO)user.getSingle("1234567890");
			assertEquals(guestVO.birthday,LocalDate.of(1995, 1, 1));
			assertEquals(guestVO.credit,100,0);
			assertEquals(guestVO.enterprise,"school");
			assertEquals(guestVO.name,"zhangsan");
			assertEquals(guestVO.nickName,"xiaosan");
			assertEquals(guestVO.password,"000000");
			assertEquals(guestVO.phone,"13523456789");
			assertEquals(guestVO.userID,"1234567890");
			
			HotelWorkerVO hotelWorkerVO = (HotelWorkerVO)user.getSingle("00001111");
			assertEquals(hotelWorkerVO.hotelName,"school");
			assertEquals(hotelWorkerVO.password,"123456");
			assertEquals(hotelWorkerVO.userID,"00001111");
			
			WebMarketerVO webMarketerVO = (WebMarketerVO)user.getSingle("000001");
			assertEquals(webMarketerVO.password,"123456");
			assertEquals(webMarketerVO.userID,"000001");
			
			WebManagerVO webManagerVO = (WebManagerVO)user.getSingle("0001");
			assertEquals(webManagerVO.password,"123456");
			assertEquals(webManagerVO.userID,"0001");
		} catch (UserInexistException e) {
			e.printStackTrace();
		}
	
	}
	
	@Ignore
	@Test
	public void testAddHotel() {
		//test the method addHotel
		User user= new User();
		
		HotelVO hotelVO = new HotelVO("12345677", "thisHotel", "NanJing", "center", "address", "4",
				5,123, "good", "allEquipment");
		try {
			assertEquals(user.addHotel(hotelVO).hotelID,"12345677");
		} catch (UserInexistException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAll() {
		//test the method getAll
		User user= new User();
		
		List<UserVO> guest = user.getAll(UserType.GUEST);
		GuestVO guestVO =(GuestVO)guest.get(0);
		assertEquals(guestVO.birthday,LocalDate.of(1995, 1, 1));
		assertEquals(guestVO.credit,100,0);
		assertEquals(guestVO.enterprise,"school");
		assertEquals(guestVO.name,"zhangsan");
		assertEquals(guestVO.nickName,"xiaosan");
		assertEquals(guestVO.password,"000000");
		assertEquals(guestVO.phone,"13523456789");
		assertEquals(guestVO.userID,"1234567890");
	}
	
	@Test
	public void testGetLogInInfo() {
		//test the method getLoginInfo
		User user= new User();
		
		try {
			assertEquals(user.getLogInInfo("1234567890", UserType.GUEST),"000000");
			assertEquals(user.getLogInInfo("00001111", UserType.HOTEL_WORKER),"123456");
			assertEquals(user.getLogInInfo("000001", UserType.WEB_MARKETER),"123456");
			assertEquals(user.getLogInInfo("0001", UserType.WEB_MANAGER),"123456");
		} catch (UserInexistException e) {
			e.printStackTrace();
		}
		
	}
}
