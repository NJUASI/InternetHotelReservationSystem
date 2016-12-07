package presentation.hotelWorkerUI.controller;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businessLogic.promotionBL.PromotionBLController;
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
import utilities.IDReserve;
import utilities.PromotionType;
import vo.HotelFixedPromotionVO;
import vo.SpecialSpanPromotionVO;

/**
 * @Description:酒店查看promotion的controller
 * @author:Harvey Gong
 * @lastChangedBy:Harvey Gong
 * @time:2016年12月7日 上午10:36:35
 */
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


	PromotionBLController promotionBLController;
	String hotelID;
	/**
	 * @Description:在初始化该controller时，初始化promotionBLController
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 上午10:36:11
	 */
	public PromotionController() {
		promotionBLController = PromotionBLController.getInstance();
		hotelID = IDReserve.getInstance().getUserID();
	}

	/**
	 * @description 初始化酒店特定期间折扣
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/6
	 */
	@FXML
	private void initialize() {
		//TODO 折扣显示有问题
		Iterator<SpecialSpanPromotionVO> spanPromotionItr = promotionBLController.getHotelSpecialSpanPromotions(hotelID);
		datePromotion = new LinkedList<DatePromotionTable>();
		while (spanPromotionItr.hasNext()) {
			SpecialSpanPromotionVO vo = spanPromotionItr.next();
			datePromotion.add(new DatePromotionTable(vo.promotionName,String.valueOf(vo.discount),vo.startDate,vo.endDate));	
		}
		initDatePromotion(datePromotion);
		initHotelFixedPromotion();
	}
	/**
	 * @description 初始化特定期间折扣的tableView
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
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
	 * @description 初始化酒店固定的策略
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	protected void initHotelFixedPromotion(){
		Iterator<HotelFixedPromotionVO> list = promotionBLController.getHotelFixedPromotions(hotelID);
		//TODO 折扣显示有问题
		threeLB.setText(String.valueOf(list.next().discount));
		birthdayLB.setText(String.valueOf(list.next().discount));
		enterpriseLB.setText(String.valueOf(list.next().discount));
	}
	/**
	 * @description 点击三间及以上折扣的按钮
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void modifyThree(){
		threeText.setVisible(true);
		threeText.setText(threeLB.getText());
		threeBt.setVisible(false);
		pane1.setVisible(true);
	}
	/**
	 * @description 点击修改生日折扣的按钮 
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void modifyBirthday(){
		birthdayText.setVisible(true);
		birthdayText.setText(threeLB.getText());
		birthdayBt.setVisible(false);
		pane2.setVisible(true);
	}
	/**
	 * @description 点击修改企业会员的按钮
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/11/30
	 * @修改企业策略
	 */
	@FXML
	protected void modifyEnterprise(){
		enterpriseText.setVisible(true);
		enterpriseText.setText(threeLB.getText());
		enterpriseBt.setVisible(false);
		pane3.setVisible(true);
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 * @保存修改三间及以上
	 */
	@FXML
	protected void saveThree(){
		updateHotelFixedPromotion(threeText, threeLB);
		initHotelFixedPromotion();
		
		threeText.setVisible(false);
		threeBt.setVisible(true);
		pane1.setVisible(false);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 * @保存修改生日策略
	 */
	@FXML
	protected void saveBirthday(){
		updateHotelFixedPromotion(birthdayText,birthdayLB);
		initHotelFixedPromotion();
		
		birthdayText.setVisible(false);
		birthdayBt.setVisible(true);
		pane2.setVisible(false);
	}
	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 * @保存修改企业策略
	 */
	@FXML
	protected void saveEnterprise(){
		updateHotelFixedPromotion(enterpriseText,enterpriseLB);
		initHotelFixedPromotion();
		
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
	 * @description 获取表中内容直接修改双十一  
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
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
	 * @description 保存特定期间策略
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
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
	
	/**
	 * @Description:根据传入的field,label更新相应的酒店固定策略
	 * @param field
	 * @param label
	 * void
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 上午11:45:16
	 */
	private void updateHotelFixedPromotion(TextField field,Label label){
		HotelFixedPromotionVO vo = new HotelFixedPromotionVO();
		vo.hotelID = hotelID;
		vo.discount = Double.valueOf(field.getText());
		vo.promotionType = PromotionType.valueOf(label.getText());
		promotionBLController.updateHotelFixedPromotion(vo);
	}
}