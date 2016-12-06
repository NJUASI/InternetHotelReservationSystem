package presentation.hotelWorkerUI.controller;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.webMarketerUI.controller.DatePromotionTable;

public class PromotionController {
	@FXML
	private Pane modifyPane,pane1,pane2,pane3;
	@FXML
	private Button addBt,threeBt,birthdayBt,enterpriseBt;
	@FXML
	private TableView<DatePromotionTable> table;
	@FXML
	private TableColumn<DatePromotionTable, String> nameColumn,  discountColumn , startDateColumn , endDateColumn;
	@FXML
	private TextField nameText,discountText,enterpriseText,birthdayText,threeText;
	@FXML
	private DatePicker startDatePicker, endDatePicker;
	@FXML
	private Label threeLB,enterpriseLB,birthdayLB;
	
	List<DatePromotionTable> datePromotion;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		datePromotion = new LinkedList<DatePromotionTable>();
		datePromotion.add(new DatePromotionTable("兰州", "www", LocalDate.of(2014,4,3),LocalDate.of(2014,4,23)));
		datePromotion.add(new DatePromotionTable("兰2州", "w2ww", LocalDate.of(2015,6,7),LocalDate.of(2014,4,23)));
		datePromotion.add(new DatePromotionTable("兰1州", "w2ww", LocalDate.of(2015,6,7),LocalDate.of(2014,4,23)));
		datePromotion.add(new DatePromotionTable("兰4s州", "w2ww", LocalDate.of(2015,6,7),LocalDate.of(2014,4,23)));
		initDatePromotion(datePromotion);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @初始化其他三个
	 */
		protected void initDatePromotion(List<DatePromotionTable> datePromotion){
			table.getItems().clear();
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
 * @初始化其他三个
 */
	protected void initOther(){
		threeLB.setText("9");
		birthdayLB.setText("1");
		enterpriseLB.setText("8");
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @修改三间及以上
	 */
	@FXML
	protected void modifyThree(){
		threeText.setVisible(true);
		threeText.setText(threeLB.getText());
		threeBt.setVisible(false);
		pane1.setVisible(true);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @修改生日策略
	 */
	@FXML
	protected void modifyBirthday(){
		birthdayText.setVisible(true);
		birthdayText.setText(threeLB.getText());
		pane2.setVisible(true);
		birthdayBt.setVisible(false);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @修改企业策略
	 */
	@FXML
	protected void modifyEnterprise(){
		enterpriseText.setVisible(true);
		enterpriseText.setText(threeLB.getText());
		pane3.setVisible(true);
		enterpriseBt.setVisible(false);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @保存修改三间及以上
	 */
	@FXML
	protected void saveThree(){
		threeText.setVisible(false);
		threeBt.setVisible(true);
		pane1.setVisible(false);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @保存修改生日策略
	 */
	@FXML
	protected void saveBirthday(){
		birthdayText.setVisible(false);
		birthdayBt.setVisible(true);
		pane2.setVisible(false);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @保存修改企业策略
	 */
	@FXML
	protected void saveEnterprise(){
		enterpriseText.setVisible(false);
		enterpriseBt.setVisible(true);
		pane3.setVisible(false);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @取消修改三间及以上
	 */
	@FXML
	protected void cancelThree(){
		threeText.setVisible(false);
		threeBt.setVisible(true);
		pane1.setVisible(false);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @取消修改生日策略
	 */
	@FXML
	protected void cancelBirthday(){
		birthdayText.setVisible(false);
		birthdayBt.setVisible(true);
		pane2.setVisible(false);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @取消修改企业策略
	 */
	@FXML
	protected void cancelEnterprise(){
		enterpriseText.setVisible(false);
		enterpriseBt.setVisible(true);
		pane3.setVisible(false);
	}
	
	
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @获取表中内容直接修改双十一
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