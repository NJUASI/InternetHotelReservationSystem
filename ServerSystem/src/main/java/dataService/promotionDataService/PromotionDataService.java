package dataService.promotionDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.AddressPO;
import po.HotelFixedPromotionPO;
import po.SpecialSpanPromotionPO;
import utilities.ResultMessage;

public interface PromotionDataService extends Remote{
	
	public List<HotelFixedPromotionPO> getHotelFixedPromotion(String hotelWorkerID) throws RemoteException;
	
	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionPO hotelFixedPromotionPO) throws RemoteException;

	// 对特定期间策略的操作，get、add、update、delete
	
	public List<SpecialSpanPromotionPO> getHotelSpecialSpanPromotion(String hotelID) throws RemoteException;
	
	public List<SpecialSpanPromotionPO> getWebSpecialSpanPromotion() throws RemoteException;
	
	public ResultMessage addSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO) throws RemoteException;
	
	public ResultMessage updateSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO) throws RemoteException;
	
	public ResultMessage deleteSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO) throws RemoteException;
	
	// 对会员专属商圈策略的操作，get、update、根据城市、商圈直接获得相应的折扣
	
	public List<AddressPO> getSpecialCirclePromotion(String city) throws RemoteException;

	public ResultMessage updateSepecialCirclePromotion(AddressPO addressPO) throws RemoteException;

	public double getSpecialCircleDiscount(String city, String cycle) throws RemoteException;

}
