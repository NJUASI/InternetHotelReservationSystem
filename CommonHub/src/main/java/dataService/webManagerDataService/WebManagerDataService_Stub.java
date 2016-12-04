package dataService.webManagerDataService;

import java.util.ArrayList;
import java.util.List;

import po.WebManagerPO;
import utilities.ResultMessage;

public class WebManagerDataService_Stub implements WebManagerDataService{

	
	public WebManagerPO getSingleWebManager(String webManagerID) {
		return new WebManagerPO("0001", "123456");
	}

	
	public List<WebManagerPO> getAllWebManager() {
		 List<WebManagerPO> list = new  ArrayList<WebManagerPO>();
		 WebManagerPO a= new WebManagerPO("0001", "123456");
		 list.add(a);
		return list;
	}

	
	public ResultMessage add(WebManagerPO newWebManagerPO) {
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage modify(WebManagerPO webManagerPO) {
		return ResultMessage.SUCCESS;
	}


}
