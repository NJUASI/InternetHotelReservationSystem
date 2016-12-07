package presentation.guestUI.controller;


import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import businessLogic.orderBL.OrderBLController;
import businessLogicService.orderBLService.OrderBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.hotelWorkerUI.controller.OrderController;
import presentation.hotelWorkerUI.controller.OrderTable;
import utilities.IDReserve;
import utilities.OrderState;
import utilities.ResultMessage;
import utilities.RoomType;
import vo.GuestEvaluationVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * @author 61990
 * @控制订单查看界面
 * @version 12.3
 * 
 * lastChangeBy charles
 * updateTime 2016/12/7
 * 
 * @高源 评论界面好像有点问题  房间号也不对
 */
public class OrderCheckController {
	
	private OrderBLService orderBLService;
	
	private final String guestID = IDReserve.getInstance().getUserID();
	
	private List<OrderGeneralVO> orderGenerals;
	
	
	//订单概况
	@FXML
	private Pane orderCheck;

	@FXML
	private TableView<OrderTable> table;
	
	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * 
	 * 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		//通过guestID得到orderGeneralVOs list
		orderBLService = OrderBLController.getInstance();
		List<OrderGeneralVO> orderGenerals = orderBLService.getAllGuestOrderGeneral(guestID);
		initOrderCheck(orderGenerals);
	}
	
	
	@FXML
	private TableColumn<OrderTable, String> orderIDColumn, hotelNameColumn, addressColumn, priceColumn,
			checkInTimeColumn, stateColumn,checkOutTimeColumn;

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
	protected void searchAllOrder() {
		//@高源——————charles新加的，界面上没有对应按钮——所有订单
		orderGenerals = orderBLService.getAllGuestOrderGeneral(guestID);
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
		orderGenerals = orderBLService.getAllGuestUnexecutedOrderGeneral(guestID);
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
		orderGenerals = orderBLService.getAllGuestExecutedOrderGeneral(guestID);
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
		orderGenerals = orderBLService.getAllGuestAbnormalOrderGeneral(guestID);
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
		orderGenerals = orderBLService.getAllGuestCancelledOrderGeneral(guestID);
		initOrderCheck(orderGenerals);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @打开已评论订单概况
	 */
	@FXML
	protected void searchCommentedOrder() {
		orderGenerals = orderBLService.getAllGuestCommentedOrderGeneral(guestID);
		initOrderCheck(orderGenerals);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @打开未评论订单概况
	 */
	@FXML
	protected void searchUncommentedOrder() {
		orderGenerals = orderBLService.getAllGuestUncommentedOrderGeneral(guestID);
		initOrderCheck(orderGenerals);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @param orderVO
	 * @describe 选择并初始化订单概况界面
	 */
	private void initOrderCheck(List<OrderGeneralVO> orderGenerals) {
		table.getItems().clear();
		List<OrderTable> orderList = new LinkedList<OrderTable>();
		for (int i = 0; i < orderGenerals.size(); i++) {
			OrderGeneralVO temp = orderGenerals.get(i);
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
		priceColumn.setCellValueFactory(cellData -> cellData.getValue().price);
		stateColumn.setCellValueFactory(cellData -> cellData.getValue().state);

		table.setItems(data);
	}
	
	
	
	
	
	/*
	 * 订单详情初始化
	 */
	private String orderID;
	
	OrderVO orderVO;
	
	
	@FXML
	private Pane orderDetail;
	@FXML
	private TextField orderScore;
	@FXML
	private TextArea orderComment;
	
	@FXML
	private Button detail_state,commitBt;
	@FXML
	private Label detail_ID, detail_Hotel, detail_address, detail_roomType, detail_roomNum, detail_personNum,detail_roomNumber,
			detail_price, detail_personName, detail_phone, detail_createTime, detail_expectTime,detail_expectLeaveTime,detail_message,detail_checkInTime,detail_checkOutTime;
	
	

	/**
	 * @author 61990
	 * @lastChangedBy cahrles
	 * @updateTime 2016/12/7
	 * @跳转订单详情界面
	 */
	@FXML
	protected void orderDetail() {
		orderID = table.getSelectionModel().getSelectedItem().getOrderID();
		
		orderDetail.setVisible(true);
		orderCheck.setVisible(false);
		
		orderVO = orderBLService.getOrderDetail(orderID);
		initOrderDetail(orderVO);
	}
	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @评价订单
	 */
	@FXML
	protected void commitComment() {
		final double score = Double.valueOf(orderScore.getText());
		final String comment = orderComment.getText();
		
		GuestEvaluationVO evaluationVO = new GuestEvaluationVO(orderID, score, comment);
		final ResultMessage result = orderBLService.addEvaluation(evaluationVO);
		if (result == ResultMessage.UPDATE_EVALUATION_SUCCESS) {
			//@高源——————状态栏显示已评价成功
			
		}else {
			//@高源——————状态栏显示评价失败
		}
		orderVO = orderBLService.getOrderDetail(orderID);
		initOrderDetail(orderVO);
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
		
		// 是否可以评论
		if (!orderVO.orderGeneralVO.hasCommented) {
			orderComment.setDisable(true);
			orderScore.setDisable(true);
			commitBt.setDisable(true);
		} else {
			orderComment.setDisable(false);
			orderScore.setDisable(false);
			commitBt.setDisable(false);
		}
	}
}
