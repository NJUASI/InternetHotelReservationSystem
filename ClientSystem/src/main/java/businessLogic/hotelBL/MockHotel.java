package businessLogic.hotelBL;

import java.util.Map;

import businessLogic.hotelBL.hotel.Hotel;
import utilities.Operation;
import utilities.ResultMessage;
import utilities.RoomType;
import vo.HotelVO;

public class MockHotel extends Hotel {

	public MockHotel(String hotelWorkerID){
		super(hotelWorkerID);
	}

	@Override
	public ResultMessage addHotel(HotelVO hotelVO) {
		return ResultMessage.SUCCESS;
	}

}
