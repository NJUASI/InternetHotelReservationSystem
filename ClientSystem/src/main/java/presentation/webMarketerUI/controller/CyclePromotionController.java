package presentation.webMarketerUI.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.promotionBL.PromotionBLController;
import businessLogic.sourceBL.SourceBLController;
import businessLogicService.promotionBLService.PromotionBLService;
import businessLogicService.sourceBLService.SourceBLService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.Table.AddressTable;
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

	
	SourceBLService sourceBLController;
	PromotionBLService promotionBLController;
	
	public CyclePromotionController() {
		sourceBLController = SourceBLController.getInstance();
		promotionBLController = PromotionBLController.getInstance();
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		cityInput.setOnShowing(new CityShowingHandler());
		cityInput.valueProperty().addListener(new CityChangedListener());
	}
	
	class CityShowingHandler implements EventHandler<Event>{
		@Override
		public void handle(Event arg0) {
			if(cityInput.getItems().size() <= 1){
				Iterator<String> cities = sourceBLController.getCities();
				while(cities.hasNext()){
					cityInput.getItems().add(cities.next());
				}
			}
		}
	}

	class CityChangedListener implements ChangeListener<String> {
		@Override
		public void changed(ObservableValue arg0, String preCity, String selectedCity) {
			cycleInput.getItems().clear();
			Iterator<String> circles = sourceBLController.getCircles(selectedCity);
			while(circles.hasNext()){
				cycleInput.getItems().add(circles.next());
			}
			cycleInput.setValue(cycleInput.getItems().get(0));
		}
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
	 * @description 初始化选中城市的特定商圈的列表
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void searchInfo() {
		//根据获取到selectedCity，然后调用promotion接口获取特定商圈折扣
		String selectedCity = cityInput.getValue();
		Iterator<AddressVO> specialCirclePromotions = null;
		// TODO gcm注意：为null时可能会抛出异常，异常之后加
		if(selectedCity!=null){
			specialCirclePromotions = promotionBLController.getSpecialCirclePromotions(selectedCity);
		}
		
		List<AddressVO> address = new ArrayList<AddressVO>();
		while(specialCirclePromotions.hasNext()){
			address.add(specialCirclePromotions.next());
		}
		
		/**
		 *  TODO gcm 他变量不一样,String 不能直接加到里面，应该是必须要装换为simple…………的没有见到可行的方法
		 *  我看网上可以直接调用FXCollections.observableArrayList(List list)
		 *  而且addressTable和addressVO几乎一样，看看能不能消除冗余
		 */
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
	 * @description 保存某一特定商圈的信息
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @保存地区策略
	 */
	@FXML
	protected void saveLocalPromotion() {
		String city = cityInput.getValue();
		String circle = cycleInput.getValue();
		double discount = Double.valueOf(cycleDiscount.getText());
		AddressVO addressVO = new AddressVO(city,circle,discount);
		//调用promotionController的更新特定商圈策略的方法
		promotionBLController.updateSpecialCirclePromotions(addressVO);
	}
	
	//TODO gcm注意：没有看到添加策略的方法
// 	我原来理解的是你有没有那个折扣都要放在那个表里,相当于全部初始化,如果你需要添加,找到对应的城市商圈,如果没有折扣改折扣就行
// 这样一个表就解决了,然后昨天发现你们是存了两个表,就有点矛盾,我可以加一个按钮,其实我那种想法方便点,就增删改查一起就走了,反正都是改折扣,想一下给我回复
}

