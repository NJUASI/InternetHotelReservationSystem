package dataServiceImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.Test;

import dataService.webManagerDataService.WebManagerDataService;
import po.WebManagerPO;
import utilities.ResultMessage;

public class WebManagerDataServiceImpl_Test {

	@Test
	public void testGetSingleWebManager() {
		//test the method GetSingleWebManager
		try {
			WebManagerDataService webManager = new WebManagerDataServiceImpl();
			WebManagerPO webManagerPO = webManager.getSingleWebManager("0001");

			assertEquals(webManagerPO.getWebManagerID(), "0001");
			assertEquals(webManagerPO.getPassword(), "123456");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllWebManager() {
		//test the method GetAllWebManager
		try {
			WebManagerDataService webManager = new WebManagerDataServiceImpl();
			List<WebManagerPO> list = webManager.getAllWebManager();
			WebManagerPO webManagerPO = list.get(0);

			assertEquals(webManagerPO.getWebManagerID(), "0001");
			assertEquals(webManagerPO.getPassword(), "123456");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAdd() {
		//test the method Add
		try {
			WebManagerDataService webManager = new WebManagerDataServiceImpl();
			WebManagerPO webManagerPO = new WebManagerPO("0001", "123456");

			assertEquals(webManager.add(webManagerPO), ResultMessage.SUCCESS);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testModify() {
		//test the method Modify
		try {
			WebManagerDataService webManager = new WebManagerDataServiceImpl();
			WebManagerPO webManagerPO = new WebManagerPO("0001", "123456");

			assertEquals(webManager.modify(webManagerPO), ResultMessage.SUCCESS);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
