package presentation.hotelWorkerUI.controller;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

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

public class OrderController {
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
		
		
		@FXML
		private TableColumn<OrderTable, String> orderIDColumn,guestIDColumn, nameColumn, phoneColumn, priceColumn,
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
					final RoomType roomType = RoomType.DOUBLE_BED;

					orderVO = new OrderVO(new OrderGeneralVO("123456677","123456677", "123456677",  "1如家", 
							 "七里河十里店希望小学",124.0, LocalDateTime.of(2005, 3, 2, 22, 10),LocalDateTime.of(2005, 3, 2, 22, 10), 
							 OrderState.ABNORMAL,false, "gaoy", "1212121") ,12.4,createTime,checkInTime,checkOutTime,RoomType.AMBASSADOR,4,"202",4,"adsfas",3.4,"22w222");
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
		/**
		 * @author 61990
		 * @lastChangedBy 61990
		 * @updateTime 2016/11/27
		 * @办理入住
		 */
		@FXML
		protected void checkIn() {
			
		}
		/**
		 * @author 61990
		 * @lastChangedBy 61990
		 * @updateTime 2016/11/27
		 * @办理退房
		 */
		
		@FXML
		protected void checkOut() {
			
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
