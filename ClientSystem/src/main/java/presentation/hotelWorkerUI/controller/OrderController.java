package presentation.hotelWorkerUI.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import businessLogic.orderBL.OrderBLController;
import businessLogicService.orderBLService.OrderBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utilities.IDReserve;
import utilities.OrderState;
import utilities.RoomType;
import vo.OrderGeneralVO;
import vo.OrderVO;
/**
 * @description 酒店查看订单的界面
 * @author 61990
 *
 * lastChangeBy charles
 * updateTime 2016/12/7
 * 
 */
public class OrderController {
	
	private OrderBLService orderBLService;
	
	/*
	 * 订单概况
	 */
	private final String hotelID = IDReserve.getInstance().getUserID();
	
	private List<OrderGeneralVO> orderGenerals;

	/*
	 * 订单详情
	 */
	private String orderID;
	
	private OrderVO orderVO;

	
	//订单概况
	@FXML
	private Pane orderCheck;

	@FXML
	private TableView<OrderTable> table;

	List<OrderGeneralVO> orderVOlist;
	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7 
	 * 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {

		//通过hotelID得到orderGeneralVOs list
		orderBLService = OrderBLController.getInstance();
		List<OrderGeneralVO> orderGenerals = orderBLService.getAllGuestOrderGeneral(hotelID);
		initOrderCheck(orderGenerals);

	}


	@FXML
	private TableColumn<OrderTable, String> orderIDColumn,guestIDColumn, nameColumn, phoneColumn, priceColumn,
	checkInTimeColumn, stateColumn,checkOutTimeColumn;

	@FXML
	private Button checkInBt1,checkOutBt1;
	
	
	/*
	 * 订单概况界面可分别查看各个类型的订单
	 */
	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @打开所有订单概况
	 */
	@FXML
	protected void searchAlldOrder() {
		//@高源——————charles新加的，界面上没有对应按钮——所有订单
		orderGenerals = orderBLService.getAllHotelOrderGeneral(hotelID);
		initOrderCheck(orderGenerals);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @打开未执行订单概况
	 */
	@FXML
	protected void searchUnexecutedOrder() {
		orderGenerals = orderBLService.getAllHotelUnexecutedOrderGeneral(hotelID);
		initOrderCheck(orderGenerals);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @打开已执行订单概况
	 */
	@FXML
	protected void searchExecutedOrder() {
		orderGenerals = orderBLService.getAllHotelExecutedOrderGeneral(hotelID);
		initOrderCheck(orderGenerals);
	}

	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @打开异常订单概况
	 */
	@FXML
	protected void searchAbnormalOrder() {
		orderGenerals = orderBLService.getAllHotelAbnormalOrderGeneral(hotelID);
		initOrderCheck(orderGenerals);
	}


	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @打开已撤销订单概况
	 */
	@FXML
	protected void searchCancelledOrder() {
		orderGenerals = orderBLService.getAllHotelCancelledOrderGeneral(hotelID);
		initOrderCheck(orderGenerals);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @param orderVO
	 * @describe 选择并初始化订单概况界面
	 */
	private void initOrderCheck(List<OrderGeneralVO> orderVOlist) {
		table.getItems().clear();
		List<OrderTable> orderList = new LinkedList<OrderTable>();
		for (int i = 0; i < orderVOlist.size(); i++) {
			OrderGeneralVO temp = orderVOlist.get(i);
			orderList.add(new OrderTable(temp.orderID,temp.guestID, temp.name, temp.phone,
					temp.expectExecuteTime.toString(),temp.expectLeaveTime.toString(),temp.price + "", temp.state.toString()));
		}

		ObservableList<OrderTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < orderList.size(); i++) {
			data.add(orderList.get(i));
		}
		orderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderID);
		guestIDColumn.setCellValueFactory(cellData -> cellData.getValue().guestID);
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().name);
		phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phone);
		checkInTimeColumn.setCellValueFactory(cellData -> cellData.getValue().checkInTime);
		checkOutTimeColumn.setCellValueFactory(cellData -> cellData.getValue().checkOutTime);
		priceColumn.setCellValueFactory(cellData -> cellData.getValue().price);
		stateColumn.setCellValueFactory(cellData -> cellData.getValue().state);

		table.setItems(data);
	}



	/*
	 * 订单详情初始化
	 */
	@FXML
	private Pane orderDetail;
	@FXML
	private TextField orderScore;
	@FXML
	private TextArea orderComment;

	@FXML
	private Button detail_state,checkInBt,checkOutBt;
	@FXML
	private Label detail_ID, detail_Hotel, detail_address, detail_roomType, detail_roomNum, detail_personNum,detail_roomNumber,
	detail_price, detail_personName, detail_phone, detail_createTime, detail_expectLeaveTime,detail_expectTime,detail_message,detail_checkInTime,detail_checkOutTime;



	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @跳转订单详情界面
	 */
	@FXML
	protected void orderDetail() {
		orderID = table.getSelectionModel().getSelectedItem().getOrderID();
		
		orderDetail.setVisible(true);
		orderCheck.setVisible(false);

		orderComment.setDisable(false);
		orderScore.setDisable(false);	

		orderVO = orderBLService.getOrderDetail(orderID);
		initOrderDetail(orderVO);
		
		//show 相应的button
		if(orderVO.orderGeneralVO.state==OrderState.EXECUTED){
			checkOutBt.setVisible(true);
			checkInBt.setVisible(false);
		}
		if(orderVO.orderGeneralVO.state==OrderState.UNEXECUTED||orderVO.orderGeneralVO.state==OrderState.ABNORMAL){
			checkOutBt.setVisible(false);
			checkInBt.setVisible(true);
		}
	}
	
	@FXML
	private Label checkInOrderID,checkInName;
	@FXML
	private TextField checkInRoomNum,checkInMinute,checkInHour;
	@FXML
	private DatePicker checkInLeaveDate;
	
	/**
	 * @author 61990
	 * @throws IOException 
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @办理入住
	 */
	//订单详情执行
	@FXML

	protected void checkIn() {
	//  TODO fjj注意：订单入住，提供订单号，房间号，离开时间等，界面暂缺
	}
	//订单概况执行
	@FXML
	protected void checkIn2() {
	//  TODO fjj注意：订单入住，提供订单号，房间号，预计离开时间等，界面暂缺

	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @办理退房
	 */
	//订单详情执行
	@FXML
	protected void checkOut() {
	//  TODO gcm注意：订单退房，供订单号，需要下层更改离开时间
	}
	void buildCheckOutWindow() throws IOException{
//		Parent checkOutStage = FXMLLoader.load(getClass().getResource("/presentation/popUp/checkIn.fxml"));
//		Stage stage =new Stage();
//		Scene scene = new Scene(checkOutStage);
//		stage.setTitle("订单退房");
//		stage.setScene(scene);
//		stage.show();
	}
	//订单概况执行
	@FXML
	protected void checkOut2() {

	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @跳转订单概况界面
	 */
	@FXML
	protected void cancel() {
		orderDetail.setVisible(false);
		orderCheck.setVisible(true);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @param orderVO
	 * @describe 初始化订单详情界面
	 */
	private void initOrderDetail(OrderVO orderVO) {
		detail_ID.setText(orderVO.orderGeneralVO.hotelID);
		detail_Hotel.setText(orderVO.orderGeneralVO.hotelName);
		detail_address.setText(orderVO.orderGeneralVO.hotelAddress);
		detail_roomType.setText(orderVO.roomType.toString());
		detail_roomNum.setText(orderVO.roomNumCount + "");
		detail_personNum.setText(orderVO.expectGuestNumCount + "");
		detail_personName.setText(orderVO.orderGeneralVO.name);
		detail_phone.setText(orderVO.orderGeneralVO.phone);
		detail_createTime.setText(orderVO.createTime.toString());
		detail_expectTime.setText(orderVO.orderGeneralVO.expectExecuteTime.toString());
		detail_expectLeaveTime.setText(orderVO.orderGeneralVO.expectLeaveTime.toString());
		detail_checkInTime.setText(orderVO.checkInTime.toString());
		detail_checkOutTime.setText(orderVO.checkOutTime.toString());
		detail_price.setText(Double.toString(orderVO.orderGeneralVO.price));
		detail_state.setText(orderVO.orderGeneralVO.state.toString());
		detail_message.setText(orderVO.message);
		orderComment.setText(orderVO.comment);
		orderScore.setText(Double.toString(orderVO.score));
	}
}
