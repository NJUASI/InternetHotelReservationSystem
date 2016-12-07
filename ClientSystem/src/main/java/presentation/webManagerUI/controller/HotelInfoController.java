package presentation.webManagerUI.controller;

import java.util.LinkedList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class HotelInfoController {
	
	@FXML
	private ComboBox<String> cityInput,cycleInput;
	
	@FXML
	private ComboBox<Integer>levelInput;
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
		cityInput.getItems().clear();
		
		//TODO 获得所有城市名称
		List<String> list = getCity();
		
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
		levelInput.getItems().clear();
		
	
		List<Integer> list = getLevel();
		
		for (int i = 0; i < list.size(); i++) {
			levelInput.getItems().add(list.get(i));
		}
	}
	List<Integer> getLevel() {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <5 ; i++) {
			list.add(i);
		}
		
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
		//TODO 通过城市，获得所有商圈名称
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
		//TODO 创建hotelVO，保存，并需要返回初始化的酒店编号和密码
//		addHotel(hotelName.getText(),cityInput.getValue(),cycleInput.getValue(),levelInput.getValue(),address.getText());

	}
}
