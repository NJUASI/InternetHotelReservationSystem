package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataService.guestDataService.GuestDataService;
import dataService.hotelDataService.HotelDataService;
import dataService.hotelWorkerDataService.HotelWorkerDataService;
import dataService.marketDataService.MarketDataService;
import dataService.orderDataService.OrderDataService;
import dataService.promotionDataService.PromotionDataService;
import dataService.webManagerDataService.WebManagerDataService;
import dataService.webMarketerDataService.WebMarketerDataService;

public class RemoteHelper {

	String url = "rmi://localhost:8888/";
	GuestDataService guestDataService;
	HotelDataService hotelDataService;
	HotelWorkerDataService hotelWorkerDataService;
	MarketDataService marketDataService;
	OrderDataService orderDataService;
	PromotionDataService promotionDataService;
	WebManagerDataService webManagerDataService;
	WebMarketerDataService webMarketerDataService;

	private static RemoteHelper remoteHelper;

	public static RemoteHelper getInstance(){
		if(remoteHelper == null){
			remoteHelper = new RemoteHelper();
		}
		return remoteHelper;
	}

	private RemoteHelper() {
		
	}

	public void init(){
		try {

			System.out.println("connect");
			
			guestDataService = (GuestDataService) 
					Naming.lookup(url+"GuestDataService");

			hotelDataService = (HotelDataService) 
					Naming.lookup(url+"HotelDataService");

			hotelWorkerDataService = (HotelWorkerDataService) 
					Naming.lookup(url+"HotelWorkerDataService");

			marketDataService = (MarketDataService) 
					Naming.lookup(url+"MarketDataService");

			orderDataService = (OrderDataService) 
					Naming.lookup(url+"OrderDataService");

			promotionDataService = (PromotionDataService) 
					Naming.lookup(url+"PromotionDataService");

			webManagerDataService = (WebManagerDataService) 
					Naming.lookup(url+"WebManagerDataService");

			webMarketerDataService = (WebMarketerDataService) 
					Naming.lookup(url+"WebMarketerDataService");

		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public GuestDataService getGuestDataService(){
		return guestDataService;
	}

	public HotelDataService getHotelDataService(){
		return hotelDataService;
	}

	public HotelWorkerDataService getHotelWorkerDataService(){
		return hotelWorkerDataService;
	}

	public MarketDataService getMarketDataService(){
		return marketDataService;
	}

	public OrderDataService getOrderDataService(){
		return orderDataService;
	}

	public PromotionDataService getPromotionDataService(){
		return promotionDataService;
	}

	public WebManagerDataService getWebManagerDataService(){
		return webManagerDataService;
	}

	public WebMarketerDataService getWebMarketerDataService(){
		return webMarketerDataService;
	}
}
