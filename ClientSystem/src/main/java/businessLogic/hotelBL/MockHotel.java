package businessLogic.hotelBL;


import businessLogic.hotelBL.hotel.Hotel;
import utilities.Address;
import utilities.ResultMessage;
import vo.HotelVO;

public class MockHotel extends Hotel {

	public MockHotel(String hotelWorkerID){
		super(hotelWorkerID);
	}

	public MockHotel() {
		// TODO 自动生成的构造函数存根
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
	
	public Address getHotelAddress(String hotelID){
		return new Address("南京","仙林");
	}
}
