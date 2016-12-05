package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import dataService.creditDataService.CreditDataService_Stub;
import dataService.guestDataService.GuestDataService_Stub;
import dataService.hotelDataService.HotelDataService_Stub;
import dataService.hotelWorkerDataService.HotelWorkerDataService_Stub;
import dataService.marketDataService.MarketDataService_Stub;
import dataService.orderDataService.OrderDataService_Stub;
import dataService.promotionDataService.PromotionDataService_Stub;
import dataService.webManagerDataService.WebManagerDataService_Stub;
import dataService.webMarketerDataService.WebMarketerDataService_Stub;





public class ServerRemoteHelper {

	String url = "rmi://localhost:8889/";
	
	public ServerRemoteHelper() {
		initServer();
	}
	
	public void initServer(){
		try {
			LocateRegistry.createRegistry(8889);
			Naming.bind(url+"GuestDataService", new GuestDataService_Stub());
			Naming.bind(url+"HotelDataService", new HotelDataService_Stub());
			Naming.bind(url+"HotelWorkerDataService", new HotelWorkerDataService_Stub());
			Naming.bind(url+"MarketDataService", new MarketDataService_Stub());
			Naming.bind(url+"OrderDataService", new OrderDataService_Stub());
			Naming.bind(url+"PromotionDataService", new PromotionDataService_Stub());
			Naming.bind(url+"WebManagerDataService", new WebManagerDataService_Stub());
			Naming.bind(url+"WebMarketerDataService", new WebMarketerDataService_Stub());
			Naming.bind(url+"CreditDataService", new CreditDataService_Stub());
			System.out.println("link");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
