package businessLogic.userBL;

import static org.junit.Assert.*;

import org.junit.Test;

import utilities.ResultMessage;
import vo.HotelVO;

public class User_tester {

	
	@Test
	public void test1() {
		//test cooperation with class Hotel
		//test interface addHotel(HotelVO newHotelVO, String hotelID)
		UserController controller = UserController.getInstance();
		
		HotelVO newHotelVO = new HotelVO("12345678", "thisHotel", "NanJing","center", "address", "4",
				5,123, "good","allEquipment");
		
		assertEquals(ResultMessage.SUCCESS, controller.addHotel(newHotelVO, "12345678"));
		assertEquals(ResultMessage.SUCCESS, controller.addHotel(newHotelVO, "12345679"));
		
	}
	
	
//	@Test
//	public void test1() {
//		//test method getAll(UserType userType)
//		UserController controller = UserController.getInstance();
//		GuestVO userVO1 =(GuestVO)controller.getAll(UserType.GUEST).get(0);
//		GuestVO userVO2 =(GuestVO)controller.getAll(UserType.GUEST).get(1);
//		
//		assertEquals(userVO1.guestID, "1234567890");
//		assertEquals(userVO1.password, "000000");
//		assertEquals(userVO1.birthday, "2016/2/2");
//		assertEquals(userVO1.enterprise, "school");
//		assertEquals(userVO1.name, "zhangsan" );
//		assertEquals(userVO1.nickName, "xiaosan");
//		assertEquals(userVO1.credit, "100");
//		assertEquals(userVO1.phone, "13523456789");
//		
//		
//		assertEquals(userVO2.guestID, "1234567891");
//		assertEquals(userVO2.password, "000000");
//		assertEquals(userVO2.birthday, "2016/2/2");
//		assertEquals(userVO2.enterprise, "school");
//		assertEquals(userVO2.name, "zhangsi" );
//		assertEquals(userVO2.nickName, "xiaosi" );
//		assertEquals(userVO2.credit, "200");
//		assertEquals(userVO2.phone, "13523456799");
//		
//		
//	}
//
//	@Test
//	public void test2() {
//		//test method getSingle(String userID, UserType userType)
//		UserController controller = UserController.getInstance();
//		GuestVO userVO1 =(GuestVO)controller.getSingle("1234567890", UserType.GUEST);
//		
//		assertEquals(userVO1.guestID, "1234567890");
//		assertEquals(userVO1.password, "000000");
//		assertEquals(userVO1.birthday, "2016/2/2");
//		assertEquals(userVO1.enterprise, "school");
//		assertEquals(userVO1.name, "zhangsan" );
//		assertEquals(userVO1.nickName, "xiaosan");
//		assertEquals(userVO1.credit, "100");
//		assertEquals(userVO1.phone, "13523456789");
//		
//	}
//	
//	@Test
//	public void test3() {
//		//test method add(UserVO newUserVO)
//		UserController controller = UserController.getInstance();
//		UserVO guestVO= new GuestVO("1234567890", "2016/2/2", "school", "zhangsan", "xiaosan",
//				"000000", "13523456789", 100);
//		
//		assertEquals(controller.add(guestVO), ResultMessage.SUCCESS);
//		
//	}
//	
//	@Test
//	public void test4() {
//		//test method addHotel(HotelVO newHotelVO, String hotelID)
//		UserController controller = UserController.getInstance();
//		HotelVO hotelVO = new HotelVO("12345678","thisHotel", "NanJing", "center", "address", "4" ,
//				5, 5, "good", "allEquipment");
//		
//		assertEquals(controller.addHotel(hotelVO,"12345678"), ResultMessage.SUCCESS);
//		
//	}
//	
//	@Test
//	public void test5() {
//		//test method modify(UserVO userVO)
//		UserController controller = UserController.getInstance();
//		UserVO guestVO= new GuestVO("1234567890", "2016/2/2", "school", "zhangsan", "xiaosan",
//				"000000", "13523456789", 100);
//		
//		assertEquals(controller.modify(guestVO), ResultMessage.SUCCESS);
//		
//	}
//	
//	@Test
//	public void test6() {
//		//test method modifyCredit(float creditNum) 
//		UserController controller = UserController.getInstance();
//		
//		assertEquals(controller.modifyCredit(100) , ResultMessage.SUCCESS);
//		
//	}
//	
//	@Test
//	public void test7() {
//		//test method getLogInInfo(String userID, UserType userType)
//		UserController controller = UserController.getInstance();
//		
//		assertEquals(controller.getLogInInfo("1234567890", UserType.GUEST) , ResultMessage.SUCCESS);
//		
//	}
	
}
