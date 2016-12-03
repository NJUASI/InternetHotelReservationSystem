package presentation.webManagerUI.controller;

import java.util.LinkedList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import presentation.Main;

public class HotelInfoController {
	
	@FXML
	private ComboBox<String> cityInput,cycleInput,levelInput;
	@FXML
	private TextField hotelName,address;
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2 
	 * @查找城市
	 */
	@FXML
	protected void searchCity() {
		List<String> list = getCity();
		cityInput.getItems().clear();
		for (int i = 0; i < list.size(); i++) {
			cityInput.getItems().add(list.get(i));
		}
	}
	List<String> getCity() {
		List<String> list = new LinkedList<String>();
		list.add("1");
		list.add("122");
		list.add("122221");
		list.add("131");
		list.add("3");
		list.add("23");
		return list;
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @查找星级
	 */
	@FXML
	protected void searchLevel() {
		//cityInput.getValue();
		List<String> list = getLevel();
		levelInput.getItems().clear();
		for (int i = 0; i < list.size(); i++) {
			levelInput.getItems().add(list.get(i));
		}
	}
	List<String> getLevel() {
		List<String> list = new LinkedList<String>();
		list.add("一");
		list.add("二");
		list.add("三");
		list.add("四");
		list.add("五");
		return list;
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @查找商圈
	 */
	@FXML
	protected void searchCycle() {
		//cityInput.getValue();
		List<String> list = getCycle(cityInput.getValue());
		cycleInput.getItems().clear();
		for (int i = 0; i < list.size(); i++) {
			cycleInput.getItems().add(list.get(i));
		}
	}

	List<String> getCycle(String city) {
		List<String> list = new LinkedList<String>();
		list.add("123");
		list.add("1233");
		list.add("1231");
		list.add("1232");
		list.add("1213");
		list.add("1123");
		return list;
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @添加酒店信息
	 */
	@FXML
	protected void addHotel(){
//		addHotel(hotelName.getText(),cityInput.getValue(),cycleInput.getValue(),levelInput.getValue(),address.getText());

	}
}
