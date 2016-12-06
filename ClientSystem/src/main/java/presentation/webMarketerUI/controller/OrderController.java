package presentation.webMarketerUI.controller;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

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
import utilities.OrderState;
import utilities.RoomType;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * @author 61990
 *
 */
public class OrderController {

	OrderVO orderVO;

	List<OrderGeneralVO> orderVOlist;

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
			checkInTimeColumn, stateColumn,checkOutTimeColumn;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/1 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		cancelPercent.setValue("50%");
		cancelPercent.getItems().add("50%");
		cancelPercent.getItems().add("100%");
		cancelPercentInCheck.setValue("50%");
		cancelPercentInCheck.getItems().add("50%");
		cancelPercentInCheck.getItems().add("100%");
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @通过订单编号查找订单
	 */
	@FXML
	protected void searchOneOrder() {
		back1.setVisible(false);
		back2.setVisible(true);
		orderDetail.setVisible(true);
		searchPane.setVisible(false);
		// Order.
		// 获得输入的内容
		// searchID.getText();
		// Test,需要删掉s
		final LocalDateTime createTime = LocalDateTime.of(2016, 2, 2, 18, 30);
		final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
		final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
		final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);

		final OrderState orderState = OrderState.ABNORMAL;
		final RoomType roomType = RoomType.双人间;

		orderVO = new OrderVO(new OrderGeneralVO("123456677","123456677", "123456677",  "1如家", 
		 "七里河十里店希望小学",124.0, LocalDateTime.of(2005, 3, 2, 22, 10),LocalDateTime.of(2005, 3, 2, 22, 10), 
		 OrderState.ABNORMAL,false, "gaoy", "1212121") ,12.4,createTime,checkInTime,checkOutTime,RoomType.AMBASSADOR,4,"202",4,"adsfas",3.4,"22w222");

		if (orderVO.orderGeneralVO.state == OrderState.ABNORMAL) {
			cancelOrderPane.setDisable(false);
		} else {
			cancelOrderPane.setDisable(true);
		}

		initOrderDetail(orderVO);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @取消异常订单在订单详情中
	 */
	@FXML
	protected void cancelAbnormalOrder() {
		try {
			if (cancelPercent.getValue().equals("50%")) {

			} else if (cancelPercent.getValue().equals("100%")) {

			}
		} catch (Exception e) {
			System.out.println("ssss");
		}finally {
			System.out.println("ucc");
		}
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @通过日期查找订单
	 */
	@FXML
	protected void searchDateOrder() {
		try {
			orderCheck.setVisible(true);
		searchPane.setVisible(false);
			// 获得输入的内容
		// LocalDate date = searchDate.getValue();
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
		
		initOrderCheck(orderVOlist);
	
	
		
		} catch (Exception e) {
			
		}
		
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
		//通过iD get GeneralVO 
//		System.out.println(table.getSelectionModel().getSelectedItem().getOrderID());
		
		final LocalDateTime createTime = LocalDateTime.of(2016, 2, 2, 18, 30);
		final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
		final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
		final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);

		final OrderState orderState = OrderState.ABNORMAL;
		final RoomType roomType = RoomType.商务套房;

		orderVO = new OrderVO(new OrderGeneralVO("123456677","123456677", "123456677",  "1如家", 
				 "七里河十里店希望小学",124.0, LocalDateTime.of(2005, 3, 2, 22, 10),LocalDateTime.of(2005, 3, 2, 22, 10), 
				 OrderState.ABNORMAL,false, "gaoy", "1212121") ,12.4,createTime,checkInTime,checkOutTime,RoomType.AMBASSADOR,4,"202",4,"adsfas",3.4,"22w222");
		
		
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
		// 获得输入的内容
				
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
		
				initOrderCheck(orderVOlist);
			
				cancelOrderPaneInCheck.setDisable(false);
				
				 
	}

	@FXML
	protected void searchUnexecutedOrder() {
	
				orderVOlist=new LinkedList<>();
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
				
				initOrderCheck(orderVOlist);
			
				cancelOrderPaneInCheck.setDisable(true);
 
	}
	@FXML
	protected void cancelAbnormalOrderInCheck() {
		try {
			if (cancelPercentInCheck.getValue().equals("50%")) {

			} else if (cancelPercentInCheck.getValue().equals("100%")) {

			}
		} catch (Exception e) {
			System.out.println("ssss");
		}
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
	private void initOrderCheck(List<OrderGeneralVO> orderVOlist) {
		table.getItems().clear();
		List<OrderTable> orderList = new LinkedList<OrderTable>();
		for (int i = 0; i < orderVOlist.size(); i++) {
			OrderGeneralVO temp = orderVOlist.get(i);
			orderList.add(new OrderTable(temp.orderID ,temp.orderID,temp.name,temp.phone, temp.hotelName,temp.hotelAddress,	temp.expectExecuteTime.toString(),temp.expectLeaveTime.toString(),temp.price + "", temp.state.toString()));
					
		}

		ObservableList<OrderTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < orderList.size(); i++) {
			data.add(orderList.get(i));
		}
		orderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderID);
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().name);
		hotelNameColumn.setCellValueFactory(cellData -> cellData.getValue().hotelName);
		addressColumn.setCellValueFactory(cellData -> cellData.getValue().address);
		checkInTimeColumn.setCellValueFactory(cellData -> cellData.getValue().checkInTime);
		checkOutTimeColumn.setCellValueFactory(cellData -> cellData.getValue().checkOutTime);
		priceColumn.setCellValueFactory(cellData -> cellData.getValue().price);
		stateColumn.setCellValueFactory(cellData -> cellData.getValue().state);

		table.setItems(data);

	}
}
