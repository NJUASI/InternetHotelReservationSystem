package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataService.creditDataService.CreditDataService;
import dataService.guestDataService.GuestDataService;
import dataService.hotelDataService.HotelDataService;
import dataService.hotelWorkerDataService.HotelWorkerDataService;
import dataService.marketDataService.MarketDataService;
import dataService.orderDataService.OrderDataService;
import dataService.promotionDataService.PromotionDataService;
import dataService.sourceDataService.SourceDataService;
import dataService.webManagerDataService.WebManagerDataService;
import dataService.webMarketerDataService.WebMarketerDataService;

public class ClientRemoteHelper {

	String url = "rmi://localhost:8889/";

	GuestDataService guestDataService;
	HotelDataService hotelDataService;
	HotelWorkerDataService hotelWorkerDataService;
	MarketDataService marketDataService;
	OrderDataService orderDataService;
	PromotionDataService promotionDataService;
	WebManagerDataService webManagerDataService;
	WebMarketerDataService webMarketerDataService;
	CreditDataService creditDataService;
	SourceDataService sourceDataService;

	private static ClientRemoteHelper remoteHelper = new ClientRemoteHelper();

	public static ClientRemoteHelper getInstance(){
		remoteHelper.init();//方便测试用
		return remoteHelper;
	}

	private ClientRemoteHelper() {

	}

	public void init(){
		try {

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

			creditDataService = (CreditDataService)
					Naming.lookup(url+"CreditDataService");
			
			sourceDataService = (SourceDataService)
					Naming.lookup(url+"SourceDataService");

			System.out.println("connect");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
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

	public CreditDataService getCreditDataService(){
		return creditDataService;
	}
	
	public SourceDataService getSourceDataService(){
		return sourceDataService;
	}
}
