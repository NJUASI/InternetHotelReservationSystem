package presentation.webMarketerUI.controller;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import vo.AddressVO;


public class DatePromotionController {
	@FXML
	private Pane modifyPane;
	@FXML
	private Button addBt;
	@FXML
	private TableView<DatePromotionTable> table;
	@FXML
	private TableColumn<DatePromotionTable, String> nameColumn,  discountColumn , startDateColumn , endDateColumn;
	@FXML
	private TextField nameText,discountText;
	@FXML
	private DatePicker startDatePicker, endDatePicker;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		table.getItems().clear();
		List<DatePromotionTable> datePromotion = new LinkedList<DatePromotionTable>();
		datePromotion.add(new DatePromotionTable("兰州", "www", LocalDate.of(2014,4,3),LocalDate.of(2014,4,23)));
		datePromotion.add(new DatePromotionTable("兰2州", "w2ww", LocalDate.of(2015,6,7),LocalDate.of(2014,4,23)));
		datePromotion.add(new DatePromotionTable("兰1州", "w2ww", LocalDate.of(2015,6,7),LocalDate.of(2014,4,23)));
		datePromotion.add(new DatePromotionTable("兰4s州", "w2ww", LocalDate.of(2015,6,7),LocalDate.of(2014,4,23)));

		ObservableList<DatePromotionTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < datePromotion.size(); i++) {
			data.add(datePromotion.get(i));
		}
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().name);
		startDateColumn.setCellValueFactory(cellData -> cellData.getValue().startDate);
		endDateColumn.setCellValueFactory(cellData -> cellData.getValue().endDate);
		discountColumn.setCellValueFactory(cellData -> cellData.getValue().discount);

		table.setItems(data);
	

	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @获取表中内容直接修改
	 */
	@FXML
	protected void modifyOne() {
		try{
			setModifyText(table.getSelectionModel().getSelectedItem().getName(),
					table.getSelectionModel().getSelectedItem().getDiscount(),
					table.getSelectionModel().getSelectedItem().getStartDate(),
					table.getSelectionModel().getSelectedItem().getEndDate());
			modifyPane.setVisible(true);
			addBt.setVisible(false);
		} catch (Exception e) {
			System.out.println("请选定");
		}
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @保存双十一策略
	 */
	@FXML
	protected void savePromotion() {
		try {
//			final LocalDate s1 = beginTime2.getValue();
//		final LocalDate s2 = beginTime2.getValue();
		// PromotionVO promitonVO=new
		// PromotionVO(PromotionType.HOTEL__HOLIDAY,Double.parseDouble(doubleDiscount2.getText()),s1,s2);
		System.out.println("success");
		modifyPane.setVisible(false);
		addBt.setVisible(true);
		setModifyText("","",null,null);
		initialize();
		} catch (Exception e) {
			System.out.println("保存失败");
		}
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @添加双十一策略
	 */
	@FXML
	protected void addPromotion() {
		try {
//			nameText.getText();
//			discountText.getText();
//			startDatePicker.getValue();
//			endDatePicker.getValue();
		System.out.println("success");
	
		} catch (Exception e) {
			System.out.println("保存失败");
		}
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @取消修改双十一策略
	 */
	@FXML
	protected void cancelModifyPromotion() {
		try {
			modifyPane.setVisible(false);
			addBt.setVisible(true);
			setModifyText("","",null,null);
		} catch (Exception e) {

		}
	}
	private void setModifyText(String name,String discount,LocalDate startDate ,LocalDate endDate) {
		
		nameText.setText(name);
		discountText.setText(discount);
		startDatePicker.setValue(startDate);
		endDatePicker.setValue(endDate);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @删除双十一策略
	 */
	@FXML
	protected void deleteOne() {
		//通过name删除
//		table.getSelectionModel().getSelectedItem().getName();
		initialize();	
	}
}