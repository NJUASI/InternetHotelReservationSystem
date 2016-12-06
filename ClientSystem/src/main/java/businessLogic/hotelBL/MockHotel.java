package businessLogic.hotelBL;


import businessLogic.hotelBL.hotel.Hotel;
import utilities.ResultMessage;
import vo.HotelVO;

public class MockHotel extends Hotel {

	public MockHotel(String hotelWorkerID){
		super(hotelWorkerID);
	}

	@Override
	public ResultMessage addHotelInfo(HotelVO hotelVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public double getLowestPrice() {
		return 100;
	}
	
	

	public ResultMessage scoreUpdate(double score) {
		return ResultMessage.HOTEL_SCORE_UPDATE_SUCCESS;
	}
}
