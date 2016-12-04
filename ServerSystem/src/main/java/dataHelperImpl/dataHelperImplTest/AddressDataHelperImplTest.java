package dataHelperImpl.dataHelperImplTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataHelper.AddressDataHelper;
import dataHelperImpl.AddressDataHelperImpl;

public class AddressDataHelperImplTest {

	AddressDataHelper helper;
	
	@Before
	public void setUp() throws Exception {
		 helper = new AddressDataHelperImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddressDataHelperImpl() {
		fail("尚未实现");
	}

	@Test
	public void testGetCity() {
		fail("尚未实现");
	}

	@Test
	public void testGetCircle() {
		List<String> list = helper.getCircle("南京");
		assertEquals("新街口",list.get(0));
		assertEquals("仙林中心",list.get(1));
		
	}

	@Test
	public void testGetDiscout() {
		fail("尚未实现");
	}

	@Test
	public void testGetAll() {
		fail("尚未实现");
	}

	@Test
	public void testModifyDiscout() {
		fail("尚未实现");
	}

	@Test
	public void testClose() {
		fail("尚未实现");
	}

}
