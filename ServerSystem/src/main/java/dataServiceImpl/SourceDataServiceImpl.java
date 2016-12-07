package dataServiceImpl;

import java.util.Iterator;

import dataHelper.AddressDataHelper;
import dataHelper.SourceDataHelper;
import dataHelperImpl.AddressDataHelperImpl;
import dataHelperImpl.SourceDataHelperImpl;
import dataService.sourceDataService.SourceDataService;

public class SourceDataServiceImpl implements SourceDataService {

	SourceDataHelper sourceDataHelper;
	AddressDataHelper addressDataHelper;
	
	public SourceDataServiceImpl() {
		sourceDataHelper = new SourceDataHelperImpl();
		addressDataHelper = new AddressDataHelperImpl();
	}
	
	@Override
	public Iterator<String> getCities() {
		return addressDataHelper.getCity().iterator();
	}
	
	@Override
	public Iterator<String> getCircles(String city) {
		return addressDataHelper.getCircle(city).iterator();
	}

	@Override
	public Iterator<String> getLevels() {
		return sourceDataHelper.getLevels();
	}

	@Override
	public Iterator<String> getRoomTypes() {
		return sourceDataHelper.getRoomTypes();
	}

}
