package presentation.guestUI.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.hotelWorkerUI.controller.TypeTable;
import presentation.webMarketerUI.controller.OrderTable;
import utilities.OrderState;
import utilities.RoomType;
import vo.HotelEvaluationVO;
import vo.HotelVO;
import vo.OrderGeneralVO;
import vo.OrderVO;
import vo.RoomInfoVO;
/**
 * @author 61990
 * @控制酒店预定界面
 * @version 11.27
 */
public class HotelSearchController {

	// 加载HotelSearch相关界面

	@FXML
	private Pane cityAndCircle, hotelCheck, hotelDetail, hotelChoose, createPane;

	// city and cycle choose 内容

	 @FXML
	 private ComboBox<String> cycleChoose;

	 @FXML
	 private ComboBox<String> cityChoose;
	//
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @初始化所有城市
	 */
	@FXML
	protected void searchCity(){
		cityChoose.getItems().clear();
		cityChoose.getItems().add("222");
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @初始化所有城市
	 */
	@FXML
	protected void searchCycle(){
//		cityChoose.getValue();
		cycleChoose.getItems().clear();
		cycleChoose.getItems().add("222");
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @打开切换酒店商圈界面
	 */
	@FXML
	protected void openSwitchCityCircle() {
		hotelCheck.setVisible(false);
		cityAndCircle.setVisible(true);
	}

	// Hotel概况浏览界面
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @打开酒店浏览界面并初始化
	 */
//	hotelTable
//	hotelIDColumn,hotelNameColumn addressColumn cityColumn cycleColumn minPriceColumn levelColumn scoreColumn
	@FXML
	protected void openHotelCheck() {
		cityAndCircle.setVisible(false);
		hotelCheck.setVisible(true);
		hotelChoose.setVisible(false);

		// cityChoose.getValue();
		// cycleChoose;
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @返回订单概况
	 */
	@FXML
	protected void returnHotelCheck() {
		hotelCheck.setVisible(true);
		hotelDetail.setVisible(false);
		createPane.setVisible(false);
	}

	
	/**
	 * 
	 */
	@FXML
	protected void openChoose() {
		hotelCheck.setVisible(false);
		hotelChoose.setVisible(true);
	}

	// HotelDetail界面

	@FXML
	private Label hotelNameInDetail, hotelIDInDetail, cityInDetail, LevelInDetail, ScoreInDetail, cycleInDetail,
			introductionInDetail, equipmentInDetail, hotelAddressInDetail;
	
	List<HotelEvaluationVO> commentList;
	List<RoomInfoVO> roomList;
	List<OrderGeneralVO> orderVOlist;
	HotelVO hotelVO;
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/4
	 * @describe 初始化酒店详情界面
	 */
	@FXML
	protected void openHotelDetail() {
		hotelCheck.setVisible(false);
		hotelDetail.setVisible(true);

		hotelVO = new HotelVO("12345", "hantingjiudiansss", "xinjiekou", "xinjiekou", "malianhedadao", "5xinji", 4.5,
				198, "shoooo", "sdaf");

		roomList = new LinkedList<>();
		roomList.add(new RoomInfoVO("123456", "DANREN", 23,3, 259));
		roomList.add(new RoomInfoVO("12123456", "双人", 12,3, 259));
		roomList.add(new RoomInfoVO("1232456","三间", 134,23, 2159));
		roomList.add(new RoomInfoVO("1234136", "总统",233, 223, 259));
		
		
		orderVOlist=new LinkedList<>();
		orderVOlist.add(new OrderGeneralVO("123456677","123456677", "123456677",  "1如家", 
				 "七里河十里店希望小学",124.0, LocalDateTime.of(2005, 3, 2, 22, 10),LocalDateTime.of(2005, 3, 2, 22, 10), 
				 OrderState.ABNORMAL,false, "gaoy", "1212121") );
		orderVOlist.add(new OrderGeneralVO("123456677","123456677", "123456677",  "1如家", 
				 "七里河十里店希望小学",124.0, LocalDateTime.of(2005, 3, 2, 22, 10),LocalDateTime.of(2005, 3, 2, 22, 10), 
				 OrderState.ABNORMAL,false, "gaoy", "1212121") );
		orderVOlist.add(new OrderGeneralVO("123456677","123456677", "123456677",  "1如家", 
				 "七里河十里店希望小学",124.0, LocalDateTime.of(2005, 3, 2, 22, 10),LocalDateTime.of(2005, 3, 2, 22, 10), 
				 OrderState.ABNORMAL,false, "gaoy", "1212121") );
		orderVOlist.add(new OrderGeneralVO("123456677","123456677", "123456677",  "1如家", 
				 "七里河十里店希望小学",124.0, LocalDateTime.of(2005, 3, 2, 22, 10),LocalDateTime.of(2005, 3, 2, 22, 10), 
				 OrderState.ABNORMAL,false, "gaoy", "1212121") );
		commentList=new LinkedList<>();
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		
		initRoomTable(roomList);
		initCommentTable(commentList);
		initHotelDetail(hotelVO);
		initOrderCheck(orderVOlist);
		
	}

	
	@FXML
	TableView<TypeTable> roomTable;
	@FXML
	private TableColumn<TypeTable, String> typeColumn, remainRoomColumn, priceColumn;

	@FXML
	TableView<EvaluationTable> evaluationTable;
	@FXML
	private TableColumn<EvaluationTable, String> guestIDColumn,scoreColumn, commentColumn;

	@FXML
	private TableView<OrderTable> orderTable;
	@FXML
	private TableColumn<OrderTable, String> orderIDColumn, hotelNameColumn, addressColumn, priceColumn1,
			checkInTimeColumn, stateColumn,checkOutTimeColumn;

	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @param orderVO
	 * @describe 初始化评价详情界面
	 */
	 private void initCommentTable(List<HotelEvaluationVO> commentList) {
		 evaluationTable.getItems().clear();
			List<EvaluationTable> dataList = new LinkedList<EvaluationTable>();
			for (int i = 0; i < commentList.size(); i++) {
				HotelEvaluationVO temp = commentList.get(i);
				dataList.add(new EvaluationTable(temp.guestID, Double.toString(temp.score), temp.comment));
			}

			ObservableList<EvaluationTable> data = FXCollections.observableArrayList();
			for (int i = 0; i < dataList.size(); i++) {
				data.add(dataList.get(i));
			}
			guestIDColumn.setCellValueFactory(cellData -> cellData.getValue().guestID);
			scoreColumn.setCellValueFactory(cellData -> cellData.getValue().score);
			commentColumn.setCellValueFactory(cellData -> cellData.getValue().comment);

			evaluationTable.setItems(data);
	 }
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @param orderVO
	 * @describe 初始化房间详情界面
	 */
	private void initRoomTable(List<RoomInfoVO> roomList) { 	
		roomTable.getItems().clear();
		List<TypeTable> dataList = new LinkedList<TypeTable>();
		for (int i = 0; i < roomList.size(); i++) {
			RoomInfoVO temp = roomList.get(i);
			dataList.add(new TypeTable(temp.roomType, temp.remainNum + "", Double.toString(temp.price)));
		}

		ObservableList<TypeTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < dataList.size(); i++) {
			data.add(dataList.get(i));
		}
		typeColumn.setCellValueFactory(cellData -> cellData.getValue().roomType);
		remainRoomColumn.setCellValueFactory(cellData -> cellData.getValue().remainRoomNum);
		priceColumn.setCellValueFactory(cellData -> cellData.getValue().price);

		roomTable.setItems(data);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @param orderVO
	 * @describe 选择并初始化订单概况界面
	 */
	private void initOrderCheck(List<OrderGeneralVO> orderVOlist) {
		orderTable.getItems().clear();
		List<OrderTable> orderList = new LinkedList<OrderTable>();
		for (int i = 0; i < orderVOlist.size(); i++) {
			OrderGeneralVO temp = orderVOlist.get(i);
			orderList.add(new OrderTable(temp.orderID, temp.hotelName, temp.hotelAddress,
					temp.expectExecuteTime.toString(),temp.expectLeaveTime.toString(),temp.price + "", temp.state.toString()));
		}

		ObservableList<OrderTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < orderList.size(); i++) {
			data.add(orderList.get(i));
		}
		orderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderID);
		hotelNameColumn.setCellValueFactory(cellData -> cellData.getValue().hotelName);
		addressColumn.setCellValueFactory(cellData -> cellData.getValue().address);
		checkInTimeColumn.setCellValueFactory(cellData -> cellData.getValue().checkInTime);
		checkOutTimeColumn.setCellValueFactory(cellData -> cellData.getValue().checkOutTime);
		priceColumn1.setCellValueFactory(cellData -> cellData.getValue().price);
		stateColumn.setCellValueFactory(cellData -> cellData.getValue().state);

		orderTable.setItems(data);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @param hotelVO
	 * @describe 初始化酒店详情界面
	 */
	private void initHotelDetail(HotelVO hotelVO) {
		
		hotelNameInDetail.setText(hotelVO.hotelName);
		hotelIDInDetail.setText(hotelVO.hotelID);
		hotelAddressInDetail.setText(hotelVO.address);
		cityInDetail.setText(hotelVO.city);
		cycleInDetail.setText(hotelVO.circle);
		LevelInDetail.setText(hotelVO.level);
		ScoreInDetail.setText(Double.toString(hotelVO.score));
		equipmentInDetail.setText(hotelVO.equipment);
		introductionInDetail.setText(hotelVO.introduction);
	}

	// Hotel筛选界面

	// 订单生成界面
	@FXML
	private ChoiceBox<String> roomTypeInOrder;
	@FXML
	private Label hotelNameInOrder, hotelIDInOrder, hotelAddressInOrder, previousPriceInOrder, priceOfOrder,remainNumInOrder;
	@FXML
	private TextField nameInOrder, phoneInOrder, guestNumInOrder, roomCountInOrder, hourInOrder, hourInOrder2,
			minuteInOrder, minuteInOrder2;
	@FXML
	private DatePicker expectExecuteDateInOrder, expectLeaveDateInOrder;
	@FXML
	private TextArea messageInOrder;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @点击预定酒店按钮
	 */
	@FXML
	protected void openCreateOrder() {
		for (int i = 0; i < roomList.size(); i++) {
		 roomTypeInOrder.getItems().add(roomList.get(i).roomType);
		}
		roomTypeInOrder.setValue(roomTable.getSelectionModel().getSelectedItem().getRoomType());
		remainNumInOrder.setText(roomTable.getSelectionModel().getSelectedItem().getRemainRoomNum());
		previousPriceInOrder.setText(roomTable.getSelectionModel().getSelectedItem().getPrice());
		
		hotelNameInOrder.setText(hotelVO.hotelName);
		hotelIDInOrder.setText(hotelVO.hotelID);
		hotelAddressInOrder.setText(hotelVO.address);

		hotelDetail.setVisible(false);
		createPane.setVisible(true);

	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @改变房间类型
	 */
	@FXML
	protected void changeRoom(){
		roomTypeInOrder.getValue();
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @点击提交订单按钮
	 */
	OrderVO orderVO;

	@FXML
	protected void commitOrder() {
//		orderVO = new OrderVO(
//				new OrderGeneralVO("", Main.userID, hotelIDInOrder.getText(), hotelNameInOrder.getText(),
//						hotelAddressInOrder.getText(), Double.parseDouble(priceOfOrder.getText()),
//						LocalDateTime.of(expectExecuteDateInOrder.getValue(),
//								LocalTime.of(Integer.parseInt(hourInOrder.getText()),
//										Integer.parseInt(minuteInOrder.getText()))),
//						LocalDateTime.of(expectLeaveDateInOrder.getValue(),
//								LocalTime.of(Integer.parseInt(hourInOrder.getText()),
//										Integer.parseInt(minuteInOrder.getText()))),
//						null),
//				Double.parseDouble(previousPriceInOrder.getText()), LocalDateTime.now(), RoomType.DELUXE,
//				Integer.parseInt(roomCountInOrder.getText()), Integer.parseInt(guestNumInOrder.getText()),
//				nameInOrder.getText(), phoneInOrder.getText(), messageInOrder.getText());
		// 传VO
		System.out.println("生成成功");

	}

}
