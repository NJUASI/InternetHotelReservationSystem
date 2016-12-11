package dataService.sourceDataService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SourceDataService_Stub extends UnicastRemoteObject implements SourceDataService {

	public SourceDataService_Stub() throws RemoteException {
		super();
	}

	@Override
	public Iterator<String> getCities() throws RemoteException {
		List<String> list = new ArrayList<String>();
		list.add("北京");
		list.add("上海");
		list.add("重庆");
		list.add("青岛");
		list.add("大连");
		list.add("成都");
		list.add("天津");
		list.add("广东");
		return list.iterator();
	}
	
	@Override
	public Iterator<String> getCircles(String city) throws RemoteException {
		List<String> list = new ArrayList<String>();
		list.add("仙林中心");
		list.add("马群");
		list.add("大行宫");
		list.add("夫子庙");
		list.add("新街口");
		return list.iterator();
	}


	@Override
	public Iterator<String> getLevels() throws RemoteException {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		return list.iterator();
	}

	@Override
	public Iterator<String> getRoomTypes() throws RemoteException {
		List<String> list = new ArrayList<String>();
		list.add("单人间");
		list.add("双人间");
		list.add("三人间");
		list.add("商务套房");
		list.add("总统套房");
		return list.iterator();
	}

	
}
