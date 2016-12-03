package businessLogic.hotelBL.driver;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import dataService.hotelDataService.HotelDataService_Stub;
import po.HotelPO;
import po.RemainRoomInfoPO;
import utilities.RoomType;

public class HotelDataService_DriverTest {

	@Test
	public void test1() {
		//test interface getHotelDetail
		HotelDataService_Stub stub = new HotelDataService_Stub();
		HotelDataService_Driver driver = new HotelDataService_Driver(stub);
		
		try {
			HotelPO hotelPO = driver.hotelDataService.getHotelDetail("12345678");
			
			assertEquals("12345678", hotelPO.getHotelID());
			assertEquals("thisHotel", hotelPO.getHotelName());
			assertEquals("address", hotelPO.getHotelAddress());
			assertEquals("NanJing", hotelPO.getCity());
			assertEquals("4", hotelPO.getLevel());
			assertEquals(5, hotelPO.getScore(), 0);
			assertEquals("good", hotelPO.getIntroduction());
			assertEquals("allEquipment", hotelPO.getEquipment());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		//test interface getRemainRoomInfo
		HotelDataService_Stub stub = new HotelDataService_Stub();
		HotelDataService_Driver driver = new HotelDataService_Driver(stub);
		try {
			RemainRoomInfoPO remainRoomInfoPO = driver.hotelDataService.getRemainRoomInfo("12345678").get(0);
			assertEquals(RoomType.AMBASSADOR, remainRoomInfoPO.getRoomType());
			assertEquals(2, remainRoomInfoPO.getRoomNumCount());
			assertEquals(200, remainRoomInfoPO.getPrice(), 0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
}


//@Test
//public void test1() {
//	// test method getHotelList(AddressVO addressVO)
//	HotelController hotelController = HotelController.getInstance();
//	
//	HotelGeneralVO hotelGeneralVO = hotelController.getHotelList(
//			new AddressVO("thisHotel", "address", "Nanjing", "center")).get(0);
//	
//	assertEquals(hotelGeneralVO.hotelID, "12345678");
//	assertEquals(hotelGeneralVO.hotelName, "thisHotel");
//	assertEquals(hotelGeneralVO.city, "NanJing");
//	assertEquals(hotelGeneralVO.cycle, "center");
//	assertEquals(hotelGeneralVO.level, "4");
//	assertEquals(hotelGeneralVO.score, 5, 0);
//}
//
//@Test
//public void test2() {
//	// test method getSortedHotels(SortStrategy sortStrategy)
//	HotelController hotelController = HotelController.getInstance();
//	
//	HotelGeneralVO hotelGeneralVO = hotelController.getSortedHotels(
//			new SortStrategy()).get(0);
//	
//	assertEquals(hotelGeneralVO.hotelID, "12345678");
//	assertEquals(hotelGeneralVO.hotelName, "thisHotel");
//	assertEquals(hotelGeneralVO.city, "NanJing");
//	assertEquals(hotelGeneralVO.cycle, "center");
//	assertEquals(hotelGeneralVO.level, "4");
//	assertEquals(hotelGeneralVO.score, 5, 0);
//}
//
//@Test
//public void test4() {
//	// test method getHotelDetail(String hotelID)
//	HotelController hotelController = HotelController.getInstance();
//	
//	HotelVO hotelVO = hotelController.getHotelDetail("12345678");
//	
//	assertEquals(hotelVO.hotelID, "12345678");
//	assertEquals(hotelVO.hotelName, "thisHotel");
//	assertEquals(hotelVO.city, "NanJing");
//	assertEquals(hotelVO.cycle, "center");
//	assertEquals(hotelVO.hotelAddress, "address");
//	assertEquals(hotelVO.level, "4");
//	assertEquals(hotelVO.cycle, "center");
//	assertEquals(hotelVO.score, 5, 0);
//	assertEquals(hotelVO.comment, 5);
//	assertEquals(hotelVO.introduction, "good");
//	assertEquals(hotelVO.equipment, "allEquipment");
//}
//
//@Test
//public void test5() {
//	// test method getUncommentedHotels(String userID)
//	HotelController hotelController = HotelController.getInstance();
//	
//	HotelGeneralVO hotelGeneralVO = hotelController.getUncommentedHotels("123456789012").get(0);
//	
//	assertEquals(hotelGeneralVO.hotelID, "12345678");
//	assertEquals(hotelGeneralVO.hotelName, "thisHotel");
//	assertEquals(hotelGeneralVO.city, "NanJing");
//	assertEquals(hotelGeneralVO.cycle, "center");
//	assertEquals(hotelGeneralVO.level, "4");
//	assertEquals(hotelGeneralVO.score, 5, 0);
//}
//
//
//@Test
//public void test6() {
//	// test method updateEvaluation(EvaluationVO evaluationVO)
//	HotelController hotelController = HotelController.getInstance();
//	
//	assertEquals(hotelController.updateEvaluation(new EvaluationVO(5, "good")), ResultMessage.SUCCESS);
//}
//
//@Test
//public void test7() {
//	// test method getHotelInfo(String userID)
//	HotelController hotelController = HotelController.getInstance();
//	
//	HotelVO hotelVO = hotelController.getHotelDetail("12345678");
//	
//	assertEquals(hotelVO.hotelID, "12345678");
//	assertEquals(hotelVO.hotelName, "thisHotel");
//	assertEquals(hotelVO.city, "NanJing");
//	assertEquals(hotelVO.cycle, "center");
//	assertEquals(hotelVO.hotelAddress, "address");
//	assertEquals(hotelVO.level, "4");
//	assertEquals(hotelVO.cycle, "center");
//	assertEquals(hotelVO.score, 5, 0);
//	assertEquals(hotelVO.comment, 5);
//	assertEquals(hotelVO.introduction, "good");
//	assertEquals(hotelVO.equipment, "allEquipment");
//}
//
//@Test
//public void test8() {
//	// test method updateHotelInfo(HotelVO hotelVO)
//	HotelController hotelController = HotelController.getInstance();
//	
//	assertEquals(hotelController.updateHotelInfo(new HotelVO("12345678","thisHotel", "NanJing", 
//			"center", "address", "4" , 5, 5, "good", "allEquipment")), ResultMessage.SUCCESS);
//}
//
//@Test
//public void test9() {
//	// test method getHotelRoomInfo(String userID)
//	HotelController hotelController = HotelController.getInstance();
//	
//	List<RoomInfoVO> list = hotelController.getHotelRoomInfo("12345678");
//	RoomInfoVO roomInfoVO1 = list.get(0);
//	RoomInfoVO roomInfoVO2 = list.get(1);
//	
//	assertEquals(roomInfoVO1.hotelID, "12345678");
//	assertEquals(roomInfoVO1.roomType, RoomType.SINGLEBED);
//	assertEquals(roomInfoVO1.roomNum, 20);
//	assertEquals(roomInfoVO1.price, 200);
//	
//	assertEquals(roomInfoVO2.hotelID, "12345678");
//	assertEquals(roomInfoVO2.roomType, RoomType.DOUBLEBED);
//	assertEquals(roomInfoVO2.roomNum, 15);
//	assertEquals(roomInfoVO2.price, 300);
//}
//
//@Test
//public void test10() {
//	// test method updateHotelRoomInfo(List<RoomInfoVO> list)
//	HotelController hotelController = HotelController.getInstance();
//	
//	List<RoomInfoVO> list = new LinkedList<RoomInfoVO>();
//	list.add(new RoomInfoVO("12345678", RoomType.SINGLEBED, 20, 200));
//	list.add(new RoomInfoVO("12345678", RoomType.DOUBLEBED, 15, 300));
//	assertEquals(hotelController.updateHotelRoomInfo(list), ResultMessage.SUCCESS);
//}
//
//@Test
//public void test11() {
//	// test method updateCheckIn(String orderID, List<String> roomNum, LocalDataTime inTime, LocalDataTime expectedLeaveTime)
//	HotelController hotelController = HotelController.getInstance();
//	
//	List<String> roomNumberList = new LinkedList<String>();
//	roomNumberList.add("301");
//	LocalDateTime inTime = LocalDateTime.of(2016, 10, 2, 14, 03);
//	LocalDateTime expectedLeaveTime = LocalDateTime.of(2016, 10, 3, 12, 00);
//	
//	assertEquals(hotelController.updateCheckIn("123456789012", roomNumberList, inTime, expectedLeaveTime), ResultMessage.SUCCESS);
//}
//
//@Test
//public void test12() {
//	// test method updateCheckOut(String orderID, LocalDateTime outTime)
//	HotelController hotelController = HotelController.getInstance();
//	
//	LocalDateTime outTime = LocalDateTime.of(2016, 10, 3, 11, 20);
//	
//	assertEquals(hotelController.updateCheckOut("123456789012", outTime), ResultMessage.SUCCESS);
//}
//
//@Test
//public void test13() {
//	// test method getRemainRoomInfo(String hotelWorkerID)
//	HotelController hotelController = HotelController.getInstance();
//	
//	List<RoomInfoVO> remainRoomInfoList = hotelController.getRemainRoomInfo("12345678");
//	RoomInfoVO remainRoonInfoVO1 = remainRoomInfoList.get(0);
//	RoomInfoVO remainRoonInfoVO2 = remainRoomInfoList.get(1);
//	
//	assertEquals(remainRoonInfoVO1.hotelID, "12345678");
//	assertEquals(remainRoonInfoVO1.roomType, RoomType.SINGLEBED);
//	assertEquals(remainRoonInfoVO1.roomNum, 13);
//	assertEquals(remainRoonInfoVO1.price, 200);
//	
//	assertEquals(remainRoonInfoVO2.hotelID, "12345678");
//	assertEquals(remainRoonInfoVO2.roomType, RoomType.DOUBLEBED);
//	assertEquals(remainRoonInfoVO2.roomNum, 6);
//	assertEquals(remainRoonInfoVO2.price, 300);
//}
//
//@Test
//public void test14() {
//	// test method updateRemainRoomInfo(Operation operation, Map<RoomType, Integer> roomInfo)
//	HotelController hotelController = HotelController.getInstance();
//	
//	Map<RoomType, Integer> roomInfo = new HashMap<RoomType, Integer>();
//	roomInfo.put(RoomType.SINGLEBED, 2);
//	roomInfo.put(RoomType.DOUBLEBED, 1);
//	
//	assertEquals(hotelController.updateRemainRoomInfo(Operation.CHECK_IN, roomInfo), ResultMessage.SUCCESS);
//}
//
//@Test
//public void test15() {
//	// test method add(HotelVO hotelVO)
//	HotelController hotelController = HotelController.getInstance();
//	HotelVO hotelVO = new HotelVO("12345678","thisHotel", "NanJing", "center", "address", "4" ,
//			5, 5, "good", "allEquipment");
//	
//	assertEquals(hotelController.add(hotelVO), ResultMessage.SUCCESS);
//}
//}
