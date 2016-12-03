package dataServiceImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.Test;

import dataService.webMarketerDataService.WebMarketerDataService;
import po.WebMarketerPO;
import utilities.ResultMessage;

public class WebMarekterDataServiceImpl_Test {

	@Test
	public void testGetSingleWebMarketer() {
		// test the method GetSingleWebMarketer
		try {
			WebMarketerDataService webMarketer = new WebMarketerDataServiceImpl();
			WebMarketerPO webMarketerPO = webMarketer.getSingleWebMarketer("000001");

			assertEquals(webMarketerPO.getWebMarketerID(), "000001");
			assertEquals(webMarketerPO.getPassword(), "123456");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllWebMarketer() {
		// test the method GetAllWebMarketer
		try {
			WebMarketerDataService webMarketer = new WebMarketerDataServiceImpl();
			List<WebMarketerPO> list = webMarketer.getAllWebMarketer();
			WebMarketerPO webMarketerPO = list.get(0);

			assertEquals(webMarketerPO.getWebMarketerID(), "000001");
			assertEquals(webMarketerPO.getPassword(), "123456");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAdd() {
		// test the method Add
		try {
			WebMarketerDataService webMarketer = new WebMarketerDataServiceImpl();
			WebMarketerPO webMarketerPO = new WebMarketerPO("000001", "123456");

			assertEquals(webMarketer.add(webMarketerPO), ResultMessage.SUCCESS);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testModify() {
		// test the method Modify
		try {
			WebMarketerDataService webMarketer = new WebMarketerDataServiceImpl();
			WebMarketerPO webMarketerPO = new WebMarketerPO("000001", "123456");

			assertEquals(webMarketer.modify(webMarketerPO), ResultMessage.SUCCESS);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteWebMarketer() {
		// test the method DeleteWebMarketer
		try {
			WebMarketerDataService webMarketer = new WebMarketerDataServiceImpl();

			assertEquals(webMarketer.deleteWebMarketer("000001"), ResultMessage.SUCCESS);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
