package presentation.webMarketerUI.controller;

import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.Main;
import presentation.signUpUI.controller.LogInViewController;
import vo.AddressVO;


public class CyclePromotionController {

	@FXML
	private TableView<AddressTable> table;
	@FXML
	private TableColumn<AddressTable, String> cityColumn, cycleColumn, discountColumn;
	@FXML
	private TextField cycleDiscount;
	@FXML
	private ComboBox<String> cityInput,cycleInput;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		

	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @获取表中内容直接修改
	 */
	@FXML
	protected void modifyOne() {
		try {
				cityInput.setValue(table.getSelectionModel().getSelectedItem().getCity());
			cycleInput.setValue(table.getSelectionModel().getSelectedItem().getCycle());
			cycleDiscount.setText(table.getSelectionModel().getSelectedItem().getDiscount());
		} catch (Exception e) {
			System.out.println("请选定或者输入城市商圈");
		}
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
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
	 * @updateTime 2016/11/30
	 * @查找商圈
	 */
	@FXML
	protected void searchCycle() {
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
	 * @updateTime 2016/11/30
	 * @初始化左边列表
	 */
	@FXML
	protected void searchInfo() {
		System.out.println(cityInput.getValue());
		List<AddressVO> address = new LinkedList<AddressVO>();
		address.add(new AddressVO("兰州", "www", 10.9));
		address.add(new AddressVO("兰州", "www", 20.9));
		address.add(new AddressVO("兰州", "www", 30.9));
		address.add(new AddressVO("兰州", "www", 0.9));
		address.add(new AddressVO("兰州", "www", 0.9));
		address.add(new AddressVO("兰州", "www", 0.9));
		address.add(new AddressVO("兰州", "www", 0.9));
		address.add(new AddressVO("兰州", "www", 40.9));
		address.add(new AddressVO("兰州", "www", 0.9));
		address.add(new AddressVO("兰州", "www", 0.9));
		address.add(new AddressVO("兰州", "www", 0.9));
		address.add(new AddressVO("兰州", "www", 60.9));
		address.add(new AddressVO("兰州", "www", 0.9));
		address.add(new AddressVO("兰州", "www", 0.9));
		address.add(new AddressVO("兰州", "www", 0.9));

		ObservableList<AddressTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < address.size(); i++) {
			data.add(new AddressTable(address.get(i).city, address.get(i).circle, Double.toString(address.get(i).discout)));
		}
		cityColumn.setCellValueFactory(cellData -> cellData.getValue().city);
		cycleColumn.setCellValueFactory(cellData -> cellData.getValue().cycle);
		discountColumn.setCellValueFactory(cellData -> cellData.getValue().discount);

		table.setItems(data);
	
	}
	


	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @保存地区策略
	 */
	@FXML
	protected void saveLocalPromotion() {
		cityInput.getPromptText();
		System.out.println(cycleInput.getValue());
		cycleDiscount.getText();
	}

}

