package businessLogic.sourceBL;

import java.rmi.RemoteException;
import java.util.Iterator;

import businessLogicService.sourceBLService.SourceBLService;
import dataService.sourceDataService.SourceDataService;
import dataService.sourceDataService.SourceDataService_Stub;
import rmi.ClientRemoteHelper;

public class SourceBLController implements SourceBLService {

	private static SourceBLController sourceBLController = new SourceBLController();
	
	SourceDataService sourceDataService;
	
	private SourceBLController() {
		sourceDataService = ClientRemoteHelper.getInstance().getSourceDataService();
//		try {
//			sourceDataService = new SourceDataService_Stub();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}
	
	public static SourceBLController getInstance(){
		return sourceBLController;
	}
	
	@Override
	public Iterator<String> getCities() {
		try {
			return sourceDataService.getCities();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Iterator<String> getLevels() {
		try {
			return sourceDataService.getLevels();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Iterator<String> getRoomTypes() {
		try {
			return sourceDataService.getRoomTypes();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Iterator<String> getCircles(String city) {
		try {
			return sourceDataService.getCircles(city);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
