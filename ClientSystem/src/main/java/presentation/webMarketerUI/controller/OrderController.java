package presentation.webMarketerUI.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import businessLogic.orderBL.OrderBLController;
import businessLogic.userBL.userService.Guest;
import businessLogic.userBL.userService.service.GuestCreditService;
import businessLogic.userBL.userService.service.UserService;
import businessLogicService.orderBLService.OrderBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.hotelWorkerUI.controller.OrderTable;
import utilities.IDReserve;
import utilities.OrderState;
import utilities.ResultMessage;
import vo.GuestVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * @author 61990
 *
 * lastChangeBy charles
 * updateTime 2016/12/9
 * 
 * TODO 高源：网站营销人员查看订单时进的界面跳转有错误 方法监听好像也有点问题，就是最开始进去调全部订单没有  返回再点进去就有了
 * TODO 冯俊杰：undo时修改credit产生一条信用记录addCredit还未实现  cancel & cancelInCheck
 */
public class OrderController {

	//order
	private OrderBLService orderBLController;
	
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

	@FXML
	private Pane orderCheck, orderDetail, searchPane;

	@FXML
	private Pane cancelOrderPane, cancelOrderPaneInCheck;
	
	// 控制返回界面
	@FXML
	private Button back1, back2, detail_state;

	@FXML
	private TextField searchID;

	@FXML
	private DatePicker searchDate;

	@FXML
	private ComboBox<String> cancelPercent, cancelPercentInCheck;
	
	// 详情界面内容
	@FXML
	private Label detail_ID, detail_Hotel, detail_address, detail_roomType, detail_roomNum, detail_personNum,
			detail_price, detail_personName, detail_phone,detail_expectLeaveTime ,detail_createTime, detail_expectTime,detail_message;
	
	// 概况界面内容
	@FXML
	private TableView<OrderTable> table;
	@FXML
	private TableColumn<OrderTable, String> orderIDColumn,nameColumn, hotelNameColumn, addressColumn, priceColumn,
			checkInTimeColumn, stateColumn,checkOutTimeColumn,guestIDColumn;

	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		
		orderBLController = OrderBLController.getInstance();
		
		cancelPercent.setValue("50%");
		cancelPercent.getItems().add("50%");
		cancelPercent.getItems().add("100%");
		cancelPercentInCheck.setValue("50%");
		cancelPercentInCheck.getItems().add("50%");
		cancelPercentInCheck.getItems().add("100%");
	}

	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @通过订单编号查找订单
	 */
	@FXML
	protected void searchOneOrder() {
		back1.setVisible(false);
		back2.setVisible(true);
		orderDetail.setVisible(true);
		searchPane.setVisible(false);
	
		orderID = searchID.getText();
		orderVO = orderBLController.getOrderDetail(orderID);
		initOrderDetail(orderVO);
		
		if (orderVO.orderGeneralVO.state == OrderState.ABNORMAL) {
			cancelOrderPane.setDisable(false);
		} else {
			cancelOrderPane.setDisable(true);
		}
	}

	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/8
	 * @在订单详情中取消异常订单
	 */
	@FXML
	protected void cancelAbnormalOrder() {
		orderID = orderVO.orderGeneralVO.guestID;
		
		double percent = 1.0;
		if (cancelPercentInCheck.getValue().equals("50%")) {
			percent = 0.5;
		} else if (cancelPercentInCheck.getValue().equals("100%")) {
			percent = 1.0;
		}
		undoAbnormalOrder(orderID, percent);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/8
	 * @通过日期查所有异常订单和未执行订单
	 */
	@FXML
	protected void searchDateOrder() {
		orderCheck.setVisible(true);
		searchPane.setVisible(false);
		
		LocalDate date = searchDate.getValue();
		List<OrderGeneralVO> abnormalOrderGenerals = orderBLController.getAllAbnormalOrderGeneral(date);
		List<OrderGeneralVO> unexecutedOrderGenerals = orderBLController.getAllUnexecutedOrderGeneral(date);

		orderGenerals.addAll(abnormalOrderGenerals);
		orderGenerals.addAll(unexecutedOrderGenerals);
		
		//TODO 冯俊杰：按时间排序
		initOrderCheck(orderGenerals);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @取消查找订单，返回初始界面
	 */
	@FXML
	protected void cancelCheck() {
		orderCheck.setVisible(false);
		searchPane.setVisible(true);
	}
	@FXML
	protected void cancelDetail1() {
		orderDetail.setVisible(false);
		orderCheck.setVisible(true);
	}
	@FXML
	protected void cancelDetail2() {
		orderDetail.setVisible(false);
		searchPane.setVisible(true);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @打开选择的订单详情
	 */
	@FXML
	protected void OrderDetail() {
		orderID = table.getSelectionModel().getSelectedItem().getOrderID();
		orderVO = orderBLController.getOrderDetail(orderID);
		//TODO 高源：原本没有下面这句。。需要加吧？？
		initOrderDetail(orderVO);
		
		if (orderVO.orderGeneralVO.state == OrderState.ABNORMAL) {
			cancelOrderPane.setDisable(false);
		} else {
			cancelOrderPane.setDisable(true);
		}

		back1.setVisible(true);
		back2.setVisible(false);
		orderDetail.setVisible(true);
		orderCheck.setVisible(false);
	}

	@FXML
	protected void searchAbnormalOrder() {
		LocalDate date = searchDate.getValue();
		
		orderGenerals = orderBLController.getAllAbnormalOrderGeneral(date);
		initOrderCheck(orderGenerals);
		
		cancelOrderPaneInCheck.setDisable(false);
				 
	}

	@FXML
	protected void searchUnexecutedOrder() {
		LocalDate date = searchDate.getValue();
		
		orderGenerals = orderBLController.getAllUnexecutedOrderGeneral(date);
		initOrderCheck(orderGenerals);
		
		cancelOrderPaneInCheck.setDisable(true);
 
	}
	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/8
	 * @在订单概况查看界面撤销异常订单
	 */
	@FXML
	protected void cancelAbnormalOrderInCheck() {
		orderID = table.getSelectionModel().getSelectedItem().getOrderID();
		
		double percent = 1.0;
		if (cancelPercentInCheck.getValue().equals("50%")) {
			percent = 0.5;
		} else if (cancelPercentInCheck.getValue().equals("100%")) {
			percent = 1.0;
		}

		undoAbnormalOrder(orderID, percent);
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
		detail_price.setText(Double.toString(orderVO.orderGeneralVO.price));
		detail_state.setText(orderVO.orderGeneralVO.state.toString());
		detail_message.setText(orderVO.message);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @param orderVO
	 * @describe 初始化订单概况界面
	 */
	private void initOrderCheck(List<OrderGeneralVO> orderGenerals) {
		table.getItems().clear();
		List<OrderTable> orderList = new LinkedList<OrderTable>();
		for (int i = 0; i < orderGenerals.size(); i++) {
			OrderGeneralVO temp = orderGenerals.get(i);
			orderList.add(new OrderTable(temp.orderID ,temp.guestID,temp.name,temp.phone, temp.hotelName,temp.hotelAddress,	temp.expectExecuteTime.toString(),temp.expectLeaveTime.toString(),temp.price + "", temp.state.toString()));
					
		}

		ObservableList<OrderTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < orderList.size(); i++) {
			data.add(orderList.get(i));
		}
		orderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderID);
		guestIDColumn.setCellValueFactory(cellData -> cellData.getValue().guestID);
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().name);
		hotelNameColumn.setCellValueFactory(cellData -> cellData.getValue().hotelName);
		addressColumn.setCellValueFactory(cellData -> cellData.getValue().address);
		checkInTimeColumn.setCellValueFactory(cellData -> cellData.getValue().checkInTime);
		checkOutTimeColumn.setCellValueFactory(cellData -> cellData.getValue().checkOutTime);
		priceColumn.setCellValueFactory(cellData -> cellData.getValue().price);
		stateColumn.setCellValueFactory(cellData -> cellData.getValue().state);

		table.setItems(data);

	}
	
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/9
	 * @param orderID
	 * @param percent
	 */
	private void undoAbnormalOrder(String orderID, double percent) {
		ResultMessage result = orderBLController.undoAbnormalOrder(orderID, percent);
		
		if (result == ResultMessage.ABNORMAL_ORDER_UNDO_SUCCESS) {
			//TODO 高源：状态栏显示异常订单撤销成功
			
		}else {
			//TODO 高源：状态栏显示异常订单撤销失败
			
		}
	}
}
