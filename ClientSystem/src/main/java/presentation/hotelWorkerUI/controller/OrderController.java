package presentation.hotelWorkerUI.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

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
import javafx.stage.Stage;
import utilities.OrderState;
import utilities.RoomType;
import vo.OrderGeneralVO;
import vo.OrderVO;
/**
 * @description 酒店查看订单的界面
 * @author 61990
 *
 */
public class OrderController {
	//订单概况
	@FXML
	private Pane orderCheck;

	@FXML
	private TableView<OrderTable> table;

	List<OrderGeneralVO> orderVOlist;
	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/1 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		//此函数用的话告诉一下gy
	}


	@FXML
	private TableColumn<OrderTable, String> orderIDColumn,guestIDColumn, nameColumn, phoneColumn, priceColumn,
	checkInTimeColumn, stateColumn,checkOutTimeColumn;

	@FXML
	private Button checkInBt1,checkOutBt1;
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @打开已执行订单概况
	 */
	@FXML
	protected void searchExecutedOrder() {
		//  TODO 通过ID
		checkInBt1.setVisible(false);
		checkOutBt1.setVisible(true);
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

	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @打开异常订单概况
	 */
	@FXML
	protected void searchAbnormalOrder() {
	//  TODO 通过ID
		checkInBt1.setVisible(true);
		checkOutBt1.setVisible(false);

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
	}


	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @打开已撤销订单概况
	 */
	@FXML
	protected void searchCancelledOrder() {
	//  TODO 通过ID
		// 获得输入的内容
		checkInBt1.setVisible(false);
		checkOutBt1.setVisible(false);

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

	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @打开未执行订单概况
	 */
	@FXML
	protected void searchUnexecutedOrder() {
	//  TODO 通过ID
		
		checkInBt1.setVisible(true);
		checkOutBt1.setVisible(false);
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



	//订单详情初始化

	OrderVO orderVO;
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
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @跳转订单详情界面
	 */
	@FXML
	protected void orderDetail() {
	//  TODO 通过orderID得到orderVO
		//			System.out.println(table.getSelectionModel().getSelectedItem().getOrderID());
		orderDetail.setVisible(true);
		orderCheck.setVisible(false);
		// Test,需要删掉s
		final LocalDateTime createTime = LocalDateTime.of(2016, 2, 2, 18, 30);
		final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
		final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
		final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);

		final OrderState orderState = OrderState.EXECUTED;
		final RoomType roomType = RoomType.三人间;

		orderVO = new OrderVO(new OrderGeneralVO("123456677","123456677", "123456677",  "1如家", 
				"七里河十里店希望小学",124.0, LocalDateTime.of(2005, 3, 2, 22, 10),LocalDateTime.of(2005, 3, 2, 22, 10), 
				OrderState.ABNORMAL,false, "gaoy", "1212121") ,12.4,createTime,checkInTime,checkOutTime,RoomType.商务套房,4,"202",4,"adsfas",3.4,"22w222");
		//					


		orderComment.setDisable(false);
		orderScore.setDisable(false);	
		if(orderVO.orderGeneralVO.state==OrderState.EXECUTED){
			checkOutBt.setVisible(true);
			checkInBt.setVisible(false);
		}
		if(orderVO.orderGeneralVO.state==OrderState.UNEXECUTED||orderVO.orderGeneralVO.state==OrderState.ABNORMAL){
			checkOutBt.setVisible(false);
			checkInBt.setVisible(true);
		}

		initOrderDetail(orderVO);
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
	protected void checkIn() throws IOException{
	
//		buildCheckInWindow();
//		checkInOrderID.setText(orderVO.orderGeneralVO.orderID);
//		initCheckInWindow(orderVO.orderGeneralVO.orderID, orderVO.orderGeneralVO.name,
//				orderVO.orderGeneralVO.expectLeaveTime.toLocalDate(),
//				orderVO.orderGeneralVO.expectLeaveTime.getHour() + "",
//				orderVO.orderGeneralVO.expectLeaveTime.getMinute() + "");
	}
	void initCheckInWindow(String orderID,String name,LocalDate date,String hour,String minute){
//		checkInOrderID.setText(orderID);
//		 checkInName.setText(name);
//		 checkInLeaveDate.setValue(date);
//		 checkInMinute.setText(minute);
//		 checkInHour.setText(hour);
	}
	void buildCheckInWindow() throws IOException{
//		Parent checkInStage = FXMLLoader.load(getClass().getResource("/presentation/popUp/checkIn.fxml"));
//		Stage stage =new Stage();
//		Scene scene = new Scene(checkInStage);
//		stage.setTitle("订单入住");
//		stage.setScene(scene);
//		stage.show();
	}
	//订单概况执行
	@FXML
	protected void checkIn2() throws IOException {
//		 buildCheckInWindow();
//		 initCheckInWindow(table.getSelectionModel().getSelectedItem().getOrderID(), table.getSelectionModel().getSelectedItem().getName(),
//				 table.getSelectionModel().getSelectedItem().getCheckOutTime().toLocalDate(),
//				 table.getSelectionModel().getSelectedItem().getCheckOutTime().getHour() + "",
//				 table.getSelectionModel().getSelectedItem().getCheckOutTime().getMinute() + "");
	}
	@FXML
	protected void sureCheckIn(){
//		//  TODO 订单入住，提供订单号，房间号，预计离开时间等，界面暂缺
//		 checkInOrderID.getText();
//		 checkInName.getText();//客户姓名，可不管
//		 checkInRoomNum.getText();//房间号
//	//离开时间获取	LocalDateTime.of(checkInLeaveDate.getValue(),LocalTime.of(Integer.parseInt(checkInHour.getText()), Integer.parseInt(checkInMinute.getText())));
//		
	}
	
	@FXML
	protected void sureCheckOut(){
//	  TODO 订单退房，提供订单号，房间号，预计离开时间等，界面暂缺
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
	//  TODO 订单退房，供订单号，需要下层更改离开时间
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
