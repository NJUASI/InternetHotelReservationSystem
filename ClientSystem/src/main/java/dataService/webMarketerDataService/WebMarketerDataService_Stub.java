package dataService.webMarketerDataService;

import java.util.ArrayList;
import java.util.List;

import po.WebMarketerPO;
import utilities.ResultMessage;

public class WebMarketerDataService_Stub implements WebMarketerDataService{

	
	public WebMarketerPO getSingleWebMarketer(String webMarketID) {
		return new WebMarketerPO("000001", "123456");
	}

	
	public List<WebMarketerPO> getAllWebMarketer() {
		List<WebMarketerPO> list= new ArrayList<WebMarketerPO>();
		WebMarketerPO a= new WebMarketerPO("000001", "123456");
		list.add(a);
		return list;
	}
	
	
	public ResultMessage add(WebMarketerPO newWebMarketerPO) {
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage modify(WebMarketerPO webMarketerPO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage deleteWebMarketer(String webMarketerID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
