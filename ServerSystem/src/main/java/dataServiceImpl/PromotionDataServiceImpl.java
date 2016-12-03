package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataHelper.AddressDataHelper;
import dataHelper.HotelFixedPromotionDataHelper;
import dataHelper.SpecialSpanPromotionDataHelper;
import dataHelperImpl.DataFactoryImpl;
import dataService.promotionDataService.PromotionDataService;
import po.AddressPO;
import po.HotelFixedPromotionPO;
import po.SpecialSpanPromotionPO;
import utilities.ResultMessage;

public class PromotionDataServiceImpl extends UnicastRemoteObject implements PromotionDataService{

	private static final long serialVersionUID = 3434060152387200042L;
	
	private DataFactoryImpl dataFactory;
	private HotelFixedPromotionDataHelper hotelFixedPromotion;
	private SpecialSpanPromotionDataHelper specialSpanPromotion;
	private AddressDataHelper specialCirclePromotion;
	
	public PromotionDataServiceImpl() throws RemoteException {
		super();
		dataFactory = DataFactoryImpl.getInstance();
		hotelFixedPromotion = dataFactory.getHotelFixedPromotionDataHelper();
		specialSpanPromotion = dataFactory.getSpecialSpanPromotionDataHelper();
		specialCirclePromotion = dataFactory.getAddressDataHelper();
	}


	@Override
	public List<HotelFixedPromotionPO> getHotelFixedPromotion(String hotelWorkerID) throws RemoteException {
		return hotelFixedPromotion.getHotelFixedPromotion(hotelWorkerID);
	}


	@Override
	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionPO hotelFixedPromotionPO) throws RemoteException {
		return hotelFixedPromotion.updateHotelFixedPromotion(hotelFixedPromotionPO);
	}


	@Override
	public List<SpecialSpanPromotionPO> getHotelSpecialSpanPromotion(String hotelID) throws RemoteException {
		return specialSpanPromotion.getHotelSpecialSpanPromotion(hotelID);
	}


	@Override
	public List<SpecialSpanPromotionPO> getWebSpecialSpanPromotion() throws RemoteException {
		return specialSpanPromotion.getWebSpecialSpanPromotion();
	}


	@Override
	public ResultMessage addSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO) throws RemoteException {
		return specialSpanPromotion.addSpecialSpanPromotion(specialSpanPromotionPO);
	}


	@Override
	public ResultMessage updateSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO) throws RemoteException {
		return specialSpanPromotion.updateSpecialSpanPromotion(specialSpanPromotionPO);
	}


	@Override
	public ResultMessage deleteSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO) throws RemoteException {
		return specialSpanPromotion.deleteSpecialSpanPromotion(specialSpanPromotionPO);
	}


	@Override
	public List<AddressPO> getSpecialCirclePromotion(String city) throws RemoteException {
		return specialCirclePromotion.getAll(city);
	}


	@Override
	public ResultMessage updateSepecialCirclePromotion(AddressPO addressPO) throws RemoteException {
		return specialCirclePromotion.modifyDiscout(addressPO);
	}


	@Override
	public double getSpecialCircleDiscount(String city, String cycle) throws RemoteException {
		return specialCirclePromotion.getDiscout(city, cycle);
	}


}
