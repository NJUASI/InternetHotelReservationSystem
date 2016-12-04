package presentation.guestUI.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.hotelWorkerUI.controller.TypeTable;
import utilities.RoomType;
import vo.HotelVO;
import vo.OrderVO;

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
	private TextField cityInput;

	// @FXML
	// private ComboBox cycleChoose;

	// @FXML
	// private ComboBox cityChoose;
	//

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @打开酒店浏览界面
	 */
	@FXML
	protected void openHotelCheck() {
		cityAndCircle.setVisible(false);
		hotelCheck.setVisible(true);
		hotelChoose.setVisible(false);

		// cityInput.getText();
		// cycleChoose;
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
	 * @返回订单概况
	 */
	@FXML
	protected void returnHotelCheck() {
		hotelCheck.setVisible(true);
		hotelDetail.setVisible(false);
		createPane.setVisible(false);
	}

	private Label hotelName1, hotelName2, hotelName3, hotelName4, ID1, ID2, ID3, ID4;
	private Label city1, city2, city3, city4, cycle1, cycle2, cycle3, cycle4;
	private Label level1, level2, level3, level4, score1, score2, score3, score4;
	private Label price1, price2, price3, price4;

	/**
	 * 
	 */
	@FXML
	protected void lastPage() {

	}

	/**
	 * 
	 */
	@FXML
	protected void nextPage() {

	}

	/**
	 * 
	 */
	@FXML
	protected void openHotelDetail2() {
		hotelCheck.setVisible(false);
		hotelDetail.setVisible(true);
	}

	/**
	 * 
	 */
	@FXML
	protected void openHotelDetail3() {
		hotelCheck.setVisible(false);
		hotelDetail.setVisible(true);
	}

	/**
	 * 
	 */
	@FXML
	protected void openHotelDetail4() {
		hotelCheck.setVisible(false);
		hotelDetail.setVisible(true);
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
//	List<RemainRoomInfoVO> roomList;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/4
	 * @describe 初始化酒店详情界面
	 */
	@FXML
	protected void openHotelDetail1() {
		hotelCheck.setVisible(false);
		hotelDetail.setVisible(true);

		hotelVO = new HotelVO("12345", "hantingjiudiansss", "xinjiekou", "xinjiekou", "malianhedadao", "5xinji", 4.5,
				198, "shoooo", "sdaf");

//		roomList = new LinkedList<>();
//		roomList.add(new RemainRoomInfoVO("123456", RoomType.AMBASSADOR, 23, 259));
//		roomList.add(new RemainRoomInfoVO("12123456", RoomType.DELUXE, 23, 259));
//		roomList.add(new RemainRoomInfoVO("1232456", RoomType.AMBASSADOR, 23, 2159));
//		roomList.add(new RemainRoomInfoVO("1234136", RoomType.AMBASSADOR, 223, 259));
//		initRoomTable(roomList);
//		System.out.println(hotelVO.hotelID);
//		initHotelDetail(hotelVO);
	}

	HotelVO hotelVO;
	@FXML
	TableView<TypeTable> roomTable;
	@FXML
	private TableColumn<TypeTable, String> typeColumn, remainRoomColumn, priceColumn;

	@FXML
	TableView<EvaluationTable> evaluationTable;
	@FXML
	private TableColumn<EvaluationTable, String> guestIDColumn, commentColumn;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @param orderVO
	 * @describe 初始化评价详情界面
	 */
	// private void initCommentTable(List<RemainRoomInfoVO> roomList) {
	// 完了再写
	// }
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @param orderVO
	 * @describe 初始化房间详情界面
	 */
//	private void initRoomTable(List<RemainRoomInfoVO> roomList) {
//		roomTable.getItems().clear();
//		List<TypeTable> dataList = new LinkedList<TypeTable>();
//		for (int i = 0; i < roomList.size(); i++) {
//			RemainRoomInfoVO temp = roomList.get(i);
//			dataList.add(new TypeTable(temp.roomType.toString(), temp.roomNumCount + "", Double.toString(temp.price)));
//		}
//
//		ObservableList<TypeTable> data = FXCollections.observableArrayList();
//		for (int i = 0; i < dataList.size(); i++) {
//			data.add(dataList.get(i));
//		}
//		typeColumn.setCellValueFactory(cellData -> cellData.getValue().roomType);
//		remainRoomColumn.setCellValueFactory(cellData -> cellData.getValue().remainRoomNum);
//		priceColumn.setCellValueFactory(cellData -> cellData.getValue().price);
//
//		roomTable.setItems(data);
//	}

	private void initHotelDetail(HotelVO hotelVO) {
		
		System.out.println(hotelVO.hotelID);
//		
//		hotelNameInDetail.setText(hotelVO.hotelGeneralVO.hotelName);
//		hotelIDInDetail.setText(hotelVO.hotelGeneralVO.hotelID);
//		hotelAddressInDetail.setText(hotelVO.hotelAddress);
//		cityInDetail.setText(hotelVO.hotelGeneralVO.city);
//		cycleInDetail.setText(hotelVO.hotelGeneralVO.cycle);
//		LevelInDetail.setText(hotelVO.hotelGeneralVO.level);
		ScoreInDetail.setText(Double.toString(hotelVO.score));
		equipmentInDetail.setText(hotelVO.equipment);
		introductionInDetail.setText(hotelVO.introduction);
	}

	// Hotel筛选界面

	// 订单生成界面
	@FXML
	private ChoiceBox<RoomType> roomTypeInOrder;
	@FXML
	private Label hotelNameInOrder, hotelIDInOrder, hotelAddressInOrder, previousPriceInOrder, priceOfOrder;
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
//		 for (int i = 0; i < roomList.size(); i++) {
//		 roomTypeInOrder.getItems().add(roomList.get(i).roomType);
//		 }
//		roomTypeInOrder.setValue(roomTable.getSelectionModel().getSelectedItem().getRoomType());
//		previousPriceInOrder.setText(roomTable.getSelectionModel().getSelectedItem().getPrice());
//		
//
//		hotelNameInOrder.setText(hotelVO.hotelGeneralVO.hotelName);
//		hotelIDInOrder.setText(hotelVO.hotelGeneralVO.hotelID);
//		hotelAddressInOrder.setText(hotelVO.hotelAddress);

		hotelDetail.setVisible(false);
		createPane.setVisible(true);

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
