package presentation.guestUI.controller;


import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;

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
import presentation.webMarketerUI.controller.OrderTable;
import utilities.OrderState;
import utilities.RoomType;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * @author 61990
 * @控制订单查看界面
 * @version 12.3
 */
public class OrderCheckController {
	//订单概况
	@FXML
	private Pane orderCheck;

	@FXML
	private TableView<OrderTable> table;
	
	List<OrderGeneralVO> orderVOlist;
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/1 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		orderVOlist=new LinkedList<>();
		orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.ABNORMAL ));
		orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.CANCELLED ));
		orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.COMMENTED));
		orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.EXECUTED));
		orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.UNEXECUTED));
		initOrderCheck(orderVOlist);
	}
	
	
	@FXML
	private TableColumn<OrderTable, String> orderIDColumn, hotelNameColumn, addressColumn, priceColumn,
			checkInTimeColumn, stateColumn,checkOutTimeColumn;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @打开已执行订单概况
	 */
	@FXML
	protected void searchExecutedOrder() {
		// 获得输入的内容
				
				orderVOlist=new LinkedList<>();
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.EXECUTED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里22河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.EXECUTED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.EXECUTED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里3河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.EXECUTED ));

				initOrderCheck(orderVOlist);
				
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @打开异常订单概况
	 */
	@FXML
	protected void searchAbnormalOrder() {
		// 获得输入的内容
				
				orderVOlist=new LinkedList<>();
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.ABNORMAL ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里22河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.ABNORMAL ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.ABNORMAL ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里3河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.ABNORMAL ));

				initOrderCheck(orderVOlist);	
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @打开已评论订单概况
	 */
	@FXML
	protected void searchCommentedOrder() {
		// 获得输入的内容
				
				orderVOlist=new LinkedList<>();
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.COMMENTED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里22河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.COMMENTED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.COMMENTED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里3河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.COMMENTED ));

				initOrderCheck(orderVOlist);
				
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @打开未评论订单概况
	 */
	@FXML
	protected void searchUncommentedOrder() {
		// 获得输入的内容
				
				orderVOlist=new LinkedList<>();
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.CANCELLED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里22河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.UNEXECUTED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.UNEXECUTED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里3河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.UNEXECUTED ));

				initOrderCheck(orderVOlist);
				
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @打开已撤销订单概况
	 */
	@FXML
	protected void searchCancelledOrder() {
		// 获得输入的内容
				
				orderVOlist=new LinkedList<>();
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.CANCELLED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里22河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.CANCELLED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.CANCELLED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里3河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.CANCELLED ));

				initOrderCheck(orderVOlist);
				
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @打开未执行订单概况
	 */
	@FXML
	protected void searchUnexecutedOrder() {
	
				orderVOlist=new LinkedList<>();
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.UNEXECUTED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里22河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.UNEXECUTED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.UNEXECUTED ));
				orderVOlist.add(new OrderGeneralVO("123456677", "1234567", "1233444", "1如家", "七里3河十里店希望小学", 400, LocalDateTime.of(2005, 3, 2, 22, 10), LocalDateTime.of(2005, 3, 2, 22, 10),OrderState.UNEXECUTED ));

				initOrderCheck(orderVOlist);
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
	
	
	
	//订单详情初始化
	
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
			detail_price, detail_personName, detail_phone, detail_createTime, detail_expectTime,detail_message,detail_checkInTime,detail_checkOutTime;
	
	

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @跳转订单详情界面
	 */
	@FXML
	protected void orderDetail() {
//		System.out.println(table.getSelectionModel().getSelectedItem().getOrderID());
		orderDetail.setVisible(true);
		orderCheck.setVisible(false);
		// Test,需要删掉s
				final LocalDateTime createTime = LocalDateTime.of(2016, 2, 2, 18, 30);
				final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
				final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
				final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
				final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);

				final OrderState orderState = OrderState.EXECUTED;
				final RoomType roomType = RoomType.DOUBLE_BED;

				orderVO = new OrderVO("123456789012", "1234567890", "12345678", "thisHotel", "address", 250, 200, createTime,
						checkInTime, checkOutTime, expectExecuteTime, expectLeaveTime, orderState, roomType, 2, "301  302", 2,
						"zhangsan", "13554321234", "no", null);
				//
				
				//是否可以评论
				if (orderVO.orderGeneralVO.state == OrderState.EXECUTED) {
					if(orderVO.comment != null){
						orderComment.setDisable(true);
						orderScore.setDisable(true);
						commitBt.setDisable(true);

					}else{
						orderComment.setDisable(false);
						orderScore.setDisable(false);	
						commitBt.setDisable(false);

					}
				} else{
					orderComment.setDisable(true);
					orderScore.setDisable(true);
					commitBt.setDisable(true);
				}

				initOrderDetail(orderVO);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @评价订单
	 */
	@FXML
	protected void commitComment() {
		//传VO，改变内容，状态已评论，comment score同时一次，返回成功与否
		orderVO.comment=orderComment.getText();
//		orderVO.score=orderScore.getText();
//		评价订单
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
		detail_personName.setText(orderVO.name);
		detail_phone.setText(orderVO.phone);
		detail_createTime.setText(orderVO.createTime.toString());
		detail_expectTime.setText(orderVO.orderGeneralVO.expectExecuteTime.toString());
		detail_checkInTime.setText(orderVO.checkInTime.toString());
		detail_checkOutTime.setText(orderVO.checkOutTime.toString());
		detail_price.setText(Double.toString(orderVO.orderGeneralVO.price));
		detail_state.setText(orderVO.orderGeneralVO.state.toString());
		detail_message.setText(orderVO.message);
		orderComment.setText(orderVO.comment);
		//没有评分PO 
	}
}
