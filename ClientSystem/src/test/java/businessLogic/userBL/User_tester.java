package businessLogic.userBL;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.verificationException.UserInexistException;
import vo.HotelVO;

public class User_tester {

	
	@Test
	public void test1() {
		//test cooperation with class Hotel
		//test interface addHotel(HotelVO newHotelVO, String hotelID)
		UserController controller = UserController.getInstance();
		
		HotelVO newHotelVO = new HotelVO("", "thisHotel", "NanJing","center", "address", "4",
				5,123, "","allEquipment");
		
		
		try {
			HotelVO hotelVO = controller.addHotel(newHotelVO);
			assertEquals(hotelVO.hotelID, "00001111");
		} catch (UserInexistException e) {
			e.printStackTrace();
		}
		
	}
	
}
