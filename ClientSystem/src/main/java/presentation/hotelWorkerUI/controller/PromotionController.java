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
import presentation.Table.DatePromotionTable;
import utilities.IDReserve;
import utilities.enums.PromotionType;
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
	
	List<SpecialSpanPromotionVO> datePromotion;
	List<HotelFixedPromotionVO> fixedPromotion;

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
		datePromotion = new LinkedList<SpecialSpanPromotionVO>();
		while (spanPromotionItr.hasNext()) {
			SpecialSpanPromotionVO vo = spanPromotionItr.next();
			datePromotion.add(new SpecialSpanPromotionVO(vo.promotionName,vo.discount,vo.startDate,vo.endDate));	
		}
		initDatePromotion(datePromotion);
		
		fixedPromotion= new LinkedList<>();
		fixedPromotion.add(new HotelFixedPromotionVO("1231231231",PromotionType.HOTEL_ABOVE_THREE_ROOMS,9.3));
		fixedPromotion.add(new HotelFixedPromotionVO("1231231231",PromotionType.HOTEL_ABOVE_THREE_ROOMS,9.3));
		fixedPromotion.add(new HotelFixedPromotionVO("1231231231",PromotionType.HOTEL_ABOVE_THREE_ROOMS,9.3));
		fixedPromotion.add(new HotelFixedPromotionVO("1231231231",PromotionType.HOTEL_ABOVE_THREE_ROOMS,9.3));
		initFixedPromotion(fixedPromotion);
	}
	/**
	 * @description 初始化特定期间折扣的tableView
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	protected void initDatePromotion(List<SpecialSpanPromotionVO> datePromotion){
		table.getItems().clear();
		ObservableList<DatePromotionTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < datePromotion.size(); i++) {
			data.add(new DatePromotionTable(datePromotion.get(i).promotionName,Double.toString(datePromotion.get(i).discount),datePromotion.get(i).startDate,datePromotion.get(i).endDate));
		}
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().name);
		startDateColumn.setCellValueFactory(cellData -> cellData.getValue().startDate);
		endDateColumn.setCellValueFactory(cellData -> cellData.getValue().endDate);
		discountColumn.setCellValueFactory(cellData -> cellData.getValue().discount);

		table.setItems(data);
	}


	String preName;
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
			preName=table.getSelectionModel().getSelectedItem().getName();
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
//			TODO gcm 保存双十一
//			preName 改之前的名字
//			改之后的信息
//			nameText.getText();
			//			discountText.getText();
			//			startDatePicker.getValue();
			//			endDatePicker.getValue();
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
		//TODO gcm 通过name删除
		//		table.getSelectionModel().getSelectedItem().getName();
		initialize();	
	}
	

	@FXML
	private TableView<DatePromotionTable> table1;
	@FXML
	private TableColumn<DatePromotionTable, String> nameColumn1,  discountColumn1 ;
	@FXML
	private TextField discountText1;
	@FXML
	private Label name;
	@FXML
	private Pane modifyPane1;
	/**
	 * @description 初始化其他三类
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/7
	 */
	protected void initFixedPromotion(List<HotelFixedPromotionVO> fixedPromotion){
		table1.getItems().clear();
		ObservableList<DatePromotionTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < fixedPromotion.size(); i++) {
			data.add(new DatePromotionTable(fixedPromotion.get(i).promotionType.toString(),Double.toString(fixedPromotion.get(i).discount)));
		}
		nameColumn1.setCellValueFactory(cellData -> cellData.getValue().name);
		discountColumn1.setCellValueFactory(cellData -> cellData.getValue().discount);

		table1.setItems(data);
	}
	/**
	 * @description 修改三种策略之一的折扣
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void modify(){
		name.setText(table1.getSelectionModel().getSelectedItem().getName());
		discountText1.setText(table1.getSelectionModel().getSelectedItem().getDiscount());
		modifyPane1.setVisible(true);
	}
	/**
		 * @description 取消修改三种策略
		 * @author 61990
		 * @lastChangedBy 61990
		 * @updateTime 2016/12/7
		 */
	@FXML
	protected void cancel(){
		modifyPane1.setVisible(false);
		name.setText("");
		discountText1.setText("");
	}
	/**
		 * @description 保存三种策略之一的折扣
		 * @author 61990
		 * @lastChangedBy 61990
		 * @updateTime 2016/12/7
		 */
	@FXML
	protected void save(){
		//TODO gcm 实现一下
//		name.getText();String 需转换
//		discountText1.getText();
	}
	
	
	
}