package businessLogic.sourceBL;

import java.util.Iterator;

import businessLogicService.sourceBLService.SourceBLService;
import dataService.sourceDataService.SourceDataService;
import dataService.sourceDataService.SourceDataService_Stub;

public class SourceBLController implements SourceBLService {

	private static SourceBLController sourceBLController = new SourceBLController();
	
	SourceDataService sourceDataService;
	
	private SourceBLController() {
//		sourceDataService = ClientRemoteHelper.getInstance().getSourceDataService();
		sourceDataService = new SourceDataService_Stub();
	}
	
	public static SourceBLController getInstance(){
		return sourceBLController;
	}
	
	@Override
	public Iterator<String> getCities() {
		return sourceDataService.getCities();
	}
	
	@Override
	public Iterator<String> getLevels() {
		return sourceDataService.getLevels();
	}

	@Override
	public Iterator<String> getRoomTypes() {
		return sourceDataService.getRoomTypes();
	}

	@Override
	public Iterator<String> getCircles(String city) {
		return sourceDataService.getCircles(city);
	}

}
