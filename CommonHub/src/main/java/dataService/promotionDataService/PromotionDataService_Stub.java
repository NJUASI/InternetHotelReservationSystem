package dataService.promotionDataService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import po.AddressPO;
import po.HotelFixedPromotionPO;
import po.SpecialSpanPromotionPO;
import utilities.PromotionType;
import utilities.ResultMessage;

public class PromotionDataService_Stub extends UnicastRemoteObject implements PromotionDataService {


	public PromotionDataService_Stub() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public List<HotelFixedPromotionPO> getHotelFixedPromotion(String hotelWorkerID) throws RemoteException {
		List<HotelFixedPromotionPO> list = new ArrayList<HotelFixedPromotionPO>();
		list.add(new HotelFixedPromotionPO("12345678",PromotionType.HOTEL__BIRTHDAY,0.9));
		list.add(new HotelFixedPromotionPO("12345678",PromotionType.HOTEL__ENTERPRISE,0.8));
		list.add(new HotelFixedPromotionPO("12345678",PromotionType.HOTEL__ROOM_NUM_COUNT_BIGGER_THAN_THREE,0.7));
		return list;
	}

	@Override
	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionPO hotelFixedPromotionPO) throws RemoteException {
		return ResultMessage.SUCCESS;
	}


	@Override
	public List<SpecialSpanPromotionPO> getWebSpecialSpanPromotion() throws RemoteException {
		List<SpecialSpanPromotionPO> list = new ArrayList<SpecialSpanPromotionPO>();
		LocalDate startDate = LocalDate.of(2016, 11, 11);
		LocalDate endDate = LocalDate.of(2016, 11, 12);
		list.add(new SpecialSpanPromotionPO("99999999",PromotionType.HOTEL_HOLIDAY,"双十一折扣",0.9,startDate,endDate));
		list.add(new SpecialSpanPromotionPO("99999999",PromotionType.HOTEL_HOLIDAY,"中秋折扣",0.8,startDate.plusMonths(1),endDate.plusMonths(1)));
		list.add(new SpecialSpanPromotionPO("99999999",PromotionType.HOTEL_HOLIDAY,"元旦折扣",0.7,startDate.plusYears(1),endDate.plusYears(1)));
		return list;
	}


	@Override
	public List<SpecialSpanPromotionPO> getHotelSpecialSpanPromotion(String hotelID) throws RemoteException {
		List<SpecialSpanPromotionPO> list = new ArrayList<SpecialSpanPromotionPO>();
		LocalDate startDate = LocalDate.of(2016, 11, 11);
		LocalDate endDate = LocalDate.of(2016, 11, 12);
		list.add(new SpecialSpanPromotionPO("12345678",PromotionType.HOTEL_HOLIDAY,"双十一折扣",0.9,startDate,endDate));
		list.add(new SpecialSpanPromotionPO("12345678",PromotionType.HOTEL_HOLIDAY,"双十二折扣",0.8,startDate.plusMonths(1),endDate.plusMonths(1)));
		list.add(new SpecialSpanPromotionPO("12345678",PromotionType.HOTEL_HOLIDAY,"春节折扣",0.7,startDate.plusYears(1),endDate.plusYears(1)));
		return list;
	}

	@Override
	public ResultMessage addSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage updateSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<AddressPO> getSpecialCirclePromotion(String city) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}


	@Override
	public ResultMessage updateSepecialCirclePromotion(AddressPO addressPO) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}


	@Override
	public double getSpecialCircleDiscount(String city, String cycle) {
		return 0.9;
	}

	@Override
	public ResultMessage deleteSpecialSpanPromotion(String userID, String promotionName) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
