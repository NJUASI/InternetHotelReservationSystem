package presentation.guestUI.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businessLogic.hotelBL.HotelBLController;
import businessLogic.orderBL.OrderBLController;
import businessLogic.sourceBL.SourceBLController;
import businessLogic.userBL.UserController;
import businessLogicService.hotelBLService.HotelBLService;
import businessLogicService.orderBLService.OrderBLService;
import businessLogicService.sourceBLService.SourceBLService;
import businessLogicService.userBLService.UserBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.hotelWorkerUI.controller.HotelTable;
import presentation.hotelWorkerUI.controller.OrderTable;
import presentation.hotelWorkerUI.controller.TypeTable;
import utilities.IDReserve;
import utilities.OrderState;
import utilities.ResultMessage;
import utilities.RoomType;
import utilities.SearchCriteriaType;
import vo.GuestVO;
import vo.HotelEvaluationVO;
import vo.HotelVO;
import vo.OrderGeneralVO;
import vo.OrderVO;
import vo.RoomInfoVO;
import vo.SearchCriteriaVO;
/**
 * @author 61990
 * @控制酒店预定界面
 * @version 11.27
 * 
 * lastChangeBy charles
 * updateTime 2016/12/7
 * 
 * @高源 没找到界面初始化的initialize()函数
 * orderDataService的在界面初始化未实现
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

	private OrderBLService orderBLController;
	private SourceBLService sourceBLController;
	private HotelBLService hotelBLController;
	private UserBLService userBLController;

	public HotelSearchController() {
		orderBLController = OrderBLController.getInstance();
		sourceBLController = SourceBLController.getInstance();
		hotelBLController = HotelBLController.getInstance();
		userBLController = UserController.getInstance();
	}
	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7 
	 * @构造函数，初始化各种COMBOBOX
	 */
	@FXML
	private void initialize() {
		
	for (int i = 0; i < 60; i++) {
	minuteInOrder.getItems().add(i);
	minuteInOrder2.getItems().add(i);
	}
	for (int i = 0; i < 24; i++) {
	hourInOrder.getItems().add(i);
	hourInOrder2.getItems().add(i);
	}
	for (int i = 1; i < 5; i++) {
		guestNumInOrder.getItems().add(i);	
	}
	for (int i = 1; i < 9; i++) {
		roomCountInOrder.getItems().add(i);	
	}
	for (int i = 1; i < 6; i++) {
		minlevelInput.getItems().add(i);
		maxlevelInput.getItems().add(i);	
	}
	for (int i = 0; i < 6; i++) {
		minScoreInput.getItems().add(i+0.0);
		maxScoreInput.getItems().add(i+0.0);	
	}
	

	
	Iterator<String> cities = sourceBLController.getCities();

	while(cities.hasNext()){
		cityChoose.getItems().add(cities.next());
	}
	
	}
	/**
	 * @初始化所有城市
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void searchCity(){

		/**
		 * TODO gy注意：当点选一个城市之后，应该cityChoose的setValue值，修改显示出来那个city
		 * 所以这里应该会加一个监听，所有城市商圈出现的地方都有这样的问题，你改一下
		 * 
		 * 获取当前城市的所有商圈，调取以下方法
		 * Iterator<String> circles = sourceBLController.getCircles(String city)
		 */

	}

	/**
	 * @description 获取当前所选城市的所有商圈
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void searchCycle(){

		cycleChoose.getItems().clear();

		//调用sourceBL获取当前选中城市的所有商圈
		Iterator<String> circles = sourceBLController.getCircles(cityChoose.getValue());
		while(circles.hasNext()){
			cycleChoose.getItems().add(circles.next());
		}
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

	@FXML
	TableView<HotelTable> hotelTable;
	@FXML
	private TableColumn<HotelTable, String>	hotelIDColumn3,hotelNameColumn3, addressColumn3, cityColumn3, cycleColumn3, minPriceColumn3,hasOrderColumn3, levelColumn3, scoreColumn3;	

	/**
	 * @酒店浏览界面初始化
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void openHotelCheck() {

		//通过城市和商圈,调用hotelBL的方法获得所有的酒店
		Iterator<HotelVO> hotels = hotelBLController.getHotels(cityChoose.getValue(), cycleChoose.getValue());

		cityAndCircle.setVisible(false);
		hotelCheck.setVisible(true);
		hotelChoose.setVisible(false);

		initHotelTable(hotels);
	}

	private void initHotelTable(Iterator<HotelVO> hotels){
		hotelTable.getItems().clear();
		List<HotelTable> dataList = new ArrayList<HotelTable>();
		
		//TODO gy注意：显示hotel的table里面不是有订单，应该显示的是订单的状态,无订单的时候就在订单状态那栏写无订单
		
		while(hotels.hasNext()){
			HotelVO temp = hotels.next();
			dataList.add(new HotelTable(temp.hotelID, temp.hotelName,temp.address,
					temp.city,temp.circle,temp.orderState.toString(),
					Double.toString(temp.minPrice),temp.level,Double.toString(temp.score)));
		}

		ObservableList<HotelTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < dataList.size(); i++) {
			data.add(dataList.get(i));
		}
		hotelIDColumn3.setCellValueFactory(cellData -> cellData.getValue().hotelID);
		hotelNameColumn3.setCellValueFactory(cellData -> cellData.getValue().hotelName);
		addressColumn3.setCellValueFactory(cellData -> cellData.getValue().address);
		cityColumn3.setCellValueFactory(cellData -> cellData.getValue().city);
		cycleColumn3.setCellValueFactory(cellData -> cellData.getValue().cycle);
		minPriceColumn3.setCellValueFactory(cellData -> cellData.getValue().minPrice);
		hasOrderColumn3.setCellValueFactory(cellData -> cellData.getValue().hasOrder);
		levelColumn3.setCellValueFactory(cellData -> cellData.getValue().level);
		scoreColumn3.setCellValueFactory(cellData -> cellData.getValue().score);

		hotelTable.setItems(data);
	}

	/**
	 * @description 返回订单概况
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void returnHotelCheck() {
		hotelCheck.setVisible(true);
		hotelDetail.setVisible(false);
		createPane.setVisible(false);
	}


	// HotelDetail界面
	/*
	 *  TODO gy注意:确定hotelDetail界面不分开吗和订单浏览界面不分开吗？不分的话，这个类太大了
	 *  可以专门用一个类把这两个类联系起来，就可以保存现场了
	 * 
	 */

	@FXML
	private Label hotelNameInDetail, hotelIDInDetail, cityInDetail, LevelInDetail, ScoreInDetail, cycleInDetail,
	introductionInDetail, equipmentInDetail, hotelAddressInDetail;

	List<HotelEvaluationVO> commentList;
	List<RoomInfoVO> roomList;
	List<OrderGeneralVO> orderVOlist;
	HotelVO hotelVO;
	/**
	 * @description 初始化酒店详情界面
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void openHotelDetail() {
		//TODO fjj注意： 酒店订单列表 酒店评价列表

		String hotelID = hotelTable.getSelectionModel().getSelectedItem().getHotelID();

		//获取hotelVO，调用hotelBL的方法
		hotelVO = hotelBLController.getHotelInfo(hotelID);

		hotelCheck.setVisible(false);
		hotelDetail.setVisible(true);

		Iterator<RoomInfoVO> rooms = hotelBLController.getHotelRoomInfo(hotelID);


		//TODO fjj注意：调用orderBL
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

		//TODO fjj注意：调用orderbL
		commentList=new LinkedList<>();
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));

		initRoomTable(rooms);
		initCommentTable(commentList);
		initHotelDetail(hotelVO);
		initOrderCheck(orderVOlist);

	}


	@FXML
	TableView<TypeTable> roomTable;
	@FXML
	private TableColumn<TypeTable, String> typeColumn, roomNameColumn,roomNumColumn,remainRoomColumn, priceColumn;

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
	 * @description 初始化房间详情界面
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 * @param Iterator<RoomInfoVO> rooms
	 */
	private void initRoomTable(Iterator<RoomInfoVO> rooms) { 	
		roomTable.getItems().clear();
		List<TypeTable> dataList = new ArrayList<TypeTable>();
		while(rooms.hasNext()){
			RoomInfoVO temp = rooms.next();
			dataList.add(new TypeTable(temp.roomType.toString(),
					String.valueOf(temp.roomNum),String.valueOf(temp.remainNum),
					Double.toString(temp.price)));
		}

		ObservableList<TypeTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < dataList.size(); i++) {
			data.add(dataList.get(i));
		}
		typeColumn.setCellValueFactory(cellData -> cellData.getValue().roomType);
		roomNumColumn.setCellValueFactory(cellData -> cellData.getValue().roomNum);
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

	@FXML
	private CheckBox box1,box2,box3,box4,box5,boxOnly;
	@FXML
	private ComboBox<Integer> minlevelInput,maxlevelInput;
	@FXML
	private ComboBox<Double> minScoreInput,maxScoreInput;
	@FXML
	private TextField roomInput,minpriceInput,	maxpriceInput,hotelNameInput;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @describe 打开酒店筛选
	 */
	@FXML
	protected void openChoose() {

		hotelCheck.setVisible(false);
		hotelChoose.setVisible(true);
	}

	List<SearchCriteriaType> criteria;
	SearchCriteriaVO vo;
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @describe 筛选
	 */
	@FXML
	protected void selectHotel() {

		//获取到各种搜索条件和用了哪些搜索方法
		setVOAndCriteria();
		
		//调用hotelBL的方法，根据搜索标准列表搜索酒店
		hotelBLController.searchHotels(criteria, vo);

		hotelCheck.setVisible(true);
		hotelChoose.setVisible(false);
	}

	/**
	 * @Description:setSearchCriteriaVO的值
	 * @return
	 * SearchCriteriaVO
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 下午10:18:27
	 */
	private void setVOAndCriteria(){
		vo = new SearchCriteriaVO();
		criteria = new ArrayList<SearchCriteriaType>();
		
		if(vo.keyHotelName!=null){
			criteria.add(SearchCriteriaType.HOTEL_NAME);
			vo.keyHotelName = hotelNameInput.getText();
		}
		if(vo.bookedOnly){
			criteria.add(SearchCriteriaType.BOOKED_ONLY);
			vo.bookedOnly = boxOnly.isSelected();
		}
		if(minlevelInput.getValue()!=null){
			criteria.add(SearchCriteriaType.LEVEL_SPAN);
			//TODO gy注意：将星级选择的getValue改为int；
			//TODO gcm改了
			vo.minLevel = minlevelInput.getValue().intValue();
			vo.maxLevel =  maxlevelInput.getValue().intValue();
		}
		if(minpriceInput.getText()!=null){
			criteria.add(SearchCriteriaType.ORGIN_PRICE_SPAN);
			vo.minPrice = Double.valueOf(minpriceInput.getText());
			vo.maxPrice = Double.valueOf(maxpriceInput.getText());
		}
		if(minScoreInput.getValue()!=null){
			criteria.add(SearchCriteriaType.SCORE_SPAN);
			vo.minScore = minScoreInput.getValue();
			vo.maxScore = maxScoreInput.getValue();
		}
		if(roomInput.getText()!=null){
			criteria.add(SearchCriteriaType.REMAIN_ROOM_NUM);
			vo.remainRoomNum = Integer.parseInt(roomInput.getText());
		}
		//TODO gy注意：能不能把房间类型列表的选择做成复选框checkBox或者选择框choiceBox，可能ifelse会少一点儿
//		TODO gcm 不就是复选框checkBox吗
//		vo.roomTypes = new ArrayList<RoomType>();
		criteria.add(SearchCriteriaType.NULL);
		
	}


	/*
	 * TODO gy注意：确定这个界面也在这儿？。。。
	 * 这个类好tm大
	 */


	// 订单生成界面
	@FXML
	private ChoiceBox<String> roomTypeInOrder;
	@FXML
	private Label hotelNameInOrder, hotelIDInOrder, hotelAddressInOrder, previousPriceInOrder, priceOfOrder,remainNumInOrder;
	@FXML
	private TextField nameInOrder, phoneInOrder;
	@FXML
	private ComboBox<Integer> guestNumInOrder,roomCountInOrder, hourInOrder, hourInOrder2,minuteInOrder, minuteInOrder2;
	@FXML
	private DatePicker expectExecuteDateInOrder, expectLeaveDateInOrder;
	@FXML
	private TextArea messageInOrder;

	/**
	 * @dscription 点击预订酒店按钮
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/11/27
	 */
	@FXML
	protected void openCreateOrder() {
		//TODO gcm 8日,不一样，这里是从详情界面拿东西初始化，因为各种需要的东西已经初始化了，而且这里我的意思是你直接就把		
		roomTypeInOrder.setValue(roomTable.getSelectionModel().getSelectedItem().getRoomType());
		remainNumInOrder.setText(roomTable.getSelectionModel().getSelectedItem().getRemainRoomNum());
		previousPriceInOrder.setText(roomTable.getSelectionModel().getSelectedItem().getPrice());
		initCreateOrder();
	}

	private void initCreateOrder(){
		// TODO gcm 给一下需要查找客户信息的客户ID
//		GuestVO guestVO = userBLController.getSingle(userID);
//		nameInOrder.setText(guestVO.name);
//		phoneInOrder.setText(guestVO.phone);
//		
		for (int i = 0; i < roomList.size(); i++) {
			roomTypeInOrder.getItems().add(roomList.get(i).roomType.toString());
		}

		hotelNameInOrder.setText(hotelVO.hotelName);
		hotelIDInOrder.setText(hotelVO.hotelID);
		hotelAddressInOrder.setText(hotelVO.address);

		hotelDetail.setVisible(false);
		createPane.setVisible(true);
		hotelCheck.setVisible(false);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @点击概况预定酒店按钮
	 */
	@FXML
	protected void createOrderIncheck(){

		// TODO gy注意：与上面代码相似度极大，你看一下，能不能合，感觉是一个界面吧。。
		//TODO gcm 8日，这里是你界面没东西，必须通过ID得到东西比如没有HotelVO，没有ROOM typelist才能初始化订单详情界面，这里是立即预定
		
		hotelVO = new HotelVO("12345", "hantingjiudiansss", "xinjiekou", "xinjiekou", "malianhedadao", "5xinji", 4.5,
				198, "shoooo", "sdaf");

		roomList = new LinkedList<>();
		roomList.add(new RoomInfoVO("123456", RoomType.三人间, 23,3, 259));
		roomList.add(new RoomInfoVO("123456", RoomType.三人间, 23,3, 259));
		roomList.add(new RoomInfoVO("123456", RoomType.三人间, 23,3, 259));
		roomList.add(new RoomInfoVO("123456", RoomType.三人间, 23,3, 259));

		initCreateOrder();
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
		final LocalDateTime expectExecuteTime = LocalDateTime.of(expectExecuteDateInOrder.getValue(),
				LocalTime.of(hourInOrder.getValue(),minuteInOrder.getValue()));
		final LocalDateTime expectLeaveTime = LocalDateTime.of(expectLeaveDateInOrder.getValue(),
				LocalTime.of(hourInOrder2.getValue(),minuteInOrder2.getValue()));

		OrderGeneralVO createOrderGeneral = new OrderGeneralVO(IDReserve.getInstance().getUserID(), hotelIDInOrder.getText(), 
				hotelNameInOrder.getText(), hotelAddressInOrder.getText(), expectExecuteTime, expectLeaveTime, 
				nameInOrder.getText(), phoneInOrder.getText());

		OrderVO createVO = new OrderVO(createOrderGeneral, Double.parseDouble(priceOfOrder.getText()), 
				RoomType.convertString2Roomtype(roomTypeInOrder.getValue()), roomCountInOrder.getValue(), guestNumInOrder.getValue(), 
				messageInOrder.getText());

		final ResultMessage msg = orderBLController.createOrder(createVO);

		if (msg == ResultMessage.ORDER_CREATE_SUCCESS) {
			//@高源——————状态栏显示订单生成成功

		}else {
			//@高源——————状态栏显示订单生成失败

		}
	}

}
