package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import dataServiceImpl.CreditDataServiceImpl;
import dataServiceImpl.GuestDataServiceImpl;
import dataServiceImpl.HotelDataServiceImpl;
import dataServiceImpl.HotelWorkerDataServiceImpl;
import dataServiceImpl.MarketDataServiceImpl;
import dataServiceImpl.OrderDataServiceImpl;
import dataServiceImpl.PromotionDataServiceImpl;
import dataServiceImpl.WebManagerDataServiceImpl;
import dataServiceImpl.WebMarketerDataServiceImpl;





public class ServerRemoteHelper {

	String url = "rmi://localhost:8889/";
	
	public ServerRemoteHelper() {
		initServer();
	}
	
	public void initServer(){
		try {
			LocateRegistry.createRegistry(8889);
			Naming.bind(url+"GuestDataService", new GuestDataServiceImpl());
			Naming.bind(url+"HotelDataService", new HotelDataServiceImpl());
			Naming.bind(url+"HotelWorkerDataService", new HotelWorkerDataServiceImpl());
			Naming.bind(url+"MarketDataService", new MarketDataServiceImpl());
			Naming.bind(url+"OrderDataService", new OrderDataServiceImpl());
			Naming.bind(url+"PromotionDataService", new PromotionDataServiceImpl());
			Naming.bind(url+"WebManagerDataService", new WebManagerDataServiceImpl());
			Naming.bind(url+"WebMarketerDataService", new WebMarketerDataServiceImpl());
			Naming.bind(url+"CreditDataService", new CreditDataServiceImpl());
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
