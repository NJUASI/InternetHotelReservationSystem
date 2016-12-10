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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import presentation.PopUp.PopUp;
import presentation.Table.EvaluationTable;
import presentation.Table.HotelTable;
import presentation.Table.OrderTable;
import presentation.Table.TypeTable;
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

	@FXML
	private ComboBox<Integer> guestNumInOrder,roomCountInOrder, hourInOrder, hourInOrder2,minuteInOrder, minuteInOrder2;

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8 
	 */
	@FXML
	private void initialize() {
		
		//gy 注意，可不可以把和最开始显示界面无关的东西放到后面再赋值，比如酒店搜索进去先要选城市商圈，我就只把这两个先赋值了，
		// 这样的话感觉会有点儿优化,就感觉这个initEveryBox就把可以把她放到创建订单的时候再初始
		//TODO gcm 有的是筛选酒店里的
		
		initEveryBox();

//		cityChoose.setOnShowing(new CityChooseHandler());
//		cityChoose.valueProperty().addListener(new CityChangedListener());
//
//		cityChoose.setValue(cityChoose.getItems().get(0));
	}

	void initEveryBox(){

		int minutes = 60;
		int hours = 24;
		int maxGuestNum = 3;
		//TODO gcm注意，用客户选择得房间类型，去下面拿到该酒店该房型得剩余房间数量
		//TODO gy注意 我怎么得到用户选择的房型
		//		int maxRoomNum = hotelBLController.getRemainRoomNum(roomType);
		int maxRoomNum = 3;
		int maxLevel = 5;
		int maxScore = 5;

		for (int i = 0; i < minutes; i++) {
			minuteInOrder.getItems().add(i);
			minuteInOrder2.getItems().add(i);
		}
		minuteInOrder.setValue(0);
		minuteInOrder2.setValue(0);
		for (int i = 0; i < hours; i++) {
			hourInOrder.getItems().add(i);
			hourInOrder2.getItems().add(i);
		}
		hourInOrder.setValue(0);
		hourInOrder2.setValue(0);
		for (int i = 1; i <= maxGuestNum; i++) {
			guestNumInOrder.getItems().add(i);	
		}
		guestNumInOrder.setValue(1);
		for (int i = 1; i < maxRoomNum; i++) {
			roomCountInOrder.getItems().add(i);	
		}
		//		房间必须选不初始
		//		roomCountInOrder.setValue(1);
		for (int i = 1; i <= maxLevel; i++) {
			minLevelInput.getItems().add(i);
			maxLevelInput.getItems().add(i);	
		}
		minLevelInput.setValue(1);
		maxLevelInput.setValue(5);
		for (int i = 0; i <= maxScore; i++) {
			minScoreInput.getItems().add(i+0.0);
			maxScoreInput.getItems().add(i+0.0);	
		}
		minScoreInput.setValue(0.0);
		maxScoreInput.setValue(5.0);
		expectExecuteDateInOrder.setValue(LocalDate.now());
		expectLeaveDateInOrder.setValue(LocalDate.now());

//		cityChoose.setOnShowing(new CityChooseHandler());
//		cityChoose.valueProperty().addListener(new CityChangedListener());
//		roomTypeInOrder.valueProperty().addListener(new RoomTypeChangeListener());
//		roomCountInOrder.valueProperty().addListener(new RoomNumChangeListener());

	}

	class RoomTypeChangeListener implements ChangeListener<String>{
		public void changed(ObservableValue ov, String oldValue, String roomType) {
			
			//根据改变的房型，改变可预订的房间数量
			roomCountInOrder.getItems().clear();
			int remainRoomNum = hotelBLController.getRemainRoomNum(RoomType.convertString2Roomtype(roomType));
			if(remainRoomNum<1){
				roomCountInOrder.setValue(remainRoomNum);
			}
			else{
				roomCountInOrder.setValue(1);
				for(int i = 2;i<=remainRoomNum;i++){
					roomCountInOrder.getItems().add(i);
				}
			}
			
			previousPriceInOrder.setText("1");
			remainNumInOrder.setText("2");

			// TODO fjj roomType为当前订单所选的房间类型，需要计算订单加个返回，即需要给preOrder的roomType重新赋值
			// TODO gy 房间类型改变后此房间的单价会改变，显示在previousPriceInOrder的值需修改，你好像还没有实现，你改了我再改
			final LocalDateTime expectExecuteTime = LocalDateTime.of(expectExecuteDateInOrder.getValue(),
					LocalTime.of(hourInOrder.getValue(), minuteInOrder.getValue()));

			final OrderGeneralVO createOrderGeneral = new OrderGeneralVO(IDReserve.getInstance().getUserID(),
					hotelIDInOrder.getText(), expectExecuteTime);

			final OrderVO tempOrder = new OrderVO(createOrderGeneral,
					Double.parseDouble(previousPriceInOrder.getText()),
					RoomType.convertString2Roomtype(roomTypeInOrder.getValue()), roomCountInOrder.getValue());

			final double tempPrice = orderBLController.getTempPrice(tempOrder);
			
		}    
	}

	class RoomNumChangeListener implements ChangeListener<Integer>{
		public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer roomNum) {
			final LocalDateTime expectExecuteTime = LocalDateTime.of(expectExecuteDateInOrder.getValue(), 
					LocalTime.of(hourInOrder.getValue(), minuteInOrder.getValue()));
			
			final OrderGeneralVO createOrderGeneral = new OrderGeneralVO(IDReserve.getInstance().getUserID(), 
					hotelIDInOrder.getText(), expectExecuteTime);

			final OrderVO tempOrder = new OrderVO(createOrderGeneral, Double.parseDouble(previousPriceInOrder.getText()), 
					RoomType.convertString2Roomtype(roomTypeInOrder.getValue()), roomCountInOrder.getValue());
			
			final double tempPrice = orderBLController.getTempPrice(tempOrder);
			
			priceOfOrder.setText(String.valueOf(tempPrice));
		}    
	}

	class CityChooseHandler implements EventHandler<Event>{
		@Override
		public void handle(Event arg0) {
			if(cityChoose.getItems().size() <= 1){
				Iterator<String> cities = sourceBLController.getCities();
				while(cities.hasNext()){
					cityChoose.getItems().add(cities.next());
				}
			}
		}
	}

	class CityChangedListener implements ChangeListener<String>{
		@Override
		public void changed(ObservableValue<? extends String> arg0, String preCity, String newCity) {
			cycleChoose.getItems().clear();
			Iterator<String> circles = sourceBLController.getCircles(newCity);
			while(circles.hasNext()){
				cycleChoose.getItems().add(circles.next());
			}
			cycleChoose.setValue(cycleChoose.getItems().get(0));
		}
	}

	@FXML
	protected void openSwitchCityCircle(){
		cityAndCircle.setVisible(true);
		hotelCheck.setVisible(false);
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
		try {
			
		Iterator<HotelVO> hotels = hotelBLController.getHotels(cityChoose.getValue(), cycleChoose.getValue());

		cityAndCircle.setVisible(false);
		hotelCheck.setVisible(true);
		hotelChoose.setVisible(false);

		initHotelTable(hotels);
		} catch (Exception e) {
			new PopUp("城市商圈有误", "错误提醒");
		}
	}

	private void initHotelTable(Iterator<HotelVO> hotels){
		hotelTable.getItems().clear();
		List<HotelTable> dataList = new ArrayList<HotelTable>();

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
	Iterator<RoomInfoVO> rooms;
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
		//TODO 冯俊杰回复高源：酒店订单列表是指此客户在此酒店的所有订单吧？  不是所有酒店订单列表吧？确认一下  and我在fxml里面没找到这个地方
		try{

			String hotelID = hotelTable.getSelectionModel().getSelectedItem().getHotelID();

			// 获取hotelVO，调用hotelBL的方法
			hotelVO = hotelBLController.getHotelInfo(hotelID);
			hotelCheck.setVisible(false);
			hotelDetail.setVisible(true);
			rooms = hotelBLController.getHotelRoomInfo(hotelID);

			// 此客户在此酒店的所有订单
			orderVOlist = new ArrayList<OrderGeneralVO>();
			Iterator<OrderGeneralVO> myOrdersOfThisHotel = orderBLController.getMyOrdersOfThisHotel(IDReserve.getInstance().getUserID(), hotelID);
			while (myOrdersOfThisHotel.hasNext()) {
				orderVOlist.add(myOrdersOfThisHotel.next());
			}

			// 初始化此酒店的评论
			commentList = new ArrayList<HotelEvaluationVO>();
			Iterator<HotelEvaluationVO> thisHotelEvaluation = orderBLController.getEvaluations(hotelID);
			while (thisHotelEvaluation.hasNext()) {
				commentList.add(thisHotelEvaluation.next());
			}

			initRoomTable(rooms);
			initCommentTable(commentList);
			initHotelDetail(hotelVO);
			initOrderCheck(orderVOlist);
		} catch (Exception e) {
			new PopUp("请选定酒店", "");
		}
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
	private ComboBox<Integer> minLevelInput,maxLevelInput;
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
		if(minLevelInput.getValue()!=null){
			criteria.add(SearchCriteriaType.LEVEL_SPAN);
			vo.minLevel = minLevelInput.getValue();
			vo.maxLevel =  maxLevelInput.getValue();
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
		//TODO gy 我不能用一个for循环去取到已经被勾选的框，只能单个取，给我一种可以通过循环取的方案
		//TODO gcm 容我考虑一下这个问题		
		//		vo.roomTypes = new ArrayList<RoomType>();

		criteria.add(SearchCriteriaType.NULL);

	}


	// 订单生成界面
	@FXML
	private ComboBox<String> roomTypeInOrder;
	@FXML
	private Label hotelNameInOrder, hotelIDInOrder, hotelAddressInOrder, previousPriceInOrder, priceOfOrder,remainNumInOrder;
	@FXML
	private TextField nameInOrder, phoneInOrder;
	@FXML
	private DatePicker expectExecuteDateInOrder, expectLeaveDateInOrder;
	@FXML
	private TextArea messageInOrder;
	GuestVO guestVO;

	/**
	 * @dscription 点击预订酒店按钮
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/11/27
	 */
	@FXML
	protected void openCreateOrder() {

		roomTypeInOrder.setValue(roomTable.getSelectionModel().getSelectedItem().getRoomType());
		remainNumInOrder.setText(roomTable.getSelectionModel().getSelectedItem().getRemainRoomNum());
		previousPriceInOrder.setText(roomTable.getSelectionModel().getSelectedItem().getPrice());
		initCreateOrder();
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @点击概况预定酒店按钮
	 */
	@FXML
	protected void createOrderIncheck(){
		initCreateOrder();
	}
	
	
	private String selectedHotelID ;

	private void initCreateOrder(){	
		selectedHotelID = hotelTable.getSelectionModel().getSelectedItem().getHotelID();
		roomTypeInOrder.getItems().clear();

		hotelVO = hotelBLController.getHotelInfo(selectedHotelID);
		rooms = hotelBLController.getHotelRoomInfo(selectedHotelID);

		guestVO = (GuestVO) userBLController.getSingle(selectedHotelID);
		nameInOrder.setText(guestVO.name);
		phoneInOrder.setText(guestVO.phone);

		while(rooms.hasNext()){
			RoomInfoVO temp = rooms.next();
			roomTypeInOrder.getItems().add(temp.roomType.toString());
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
	 * @点击提交订单按钮
	 */
	OrderVO orderVO;

	@FXML 
	StackPane right;

	@FXML
	protected void commitOrder() {

		final LocalDateTime expectExecuteTime = LocalDateTime.of(expectExecuteDateInOrder.getValue(), 
				LocalTime.of(hourInOrder.getValue(), minuteInOrder.getValue()));
		final LocalDateTime expectLeaveTime = LocalDateTime.of(expectLeaveDateInOrder.getValue(), 
				LocalTime.of(hourInOrder2.getValue(), minuteInOrder2.getValue()));

		OrderGeneralVO createOrderGeneral = new OrderGeneralVO(IDReserve.getInstance().getUserID(), hotelIDInOrder.getText(), 
				hotelNameInOrder.getText(), hotelAddressInOrder.getText(), expectExecuteTime, expectLeaveTime, 
				nameInOrder.getText(), phoneInOrder.getText());

		OrderVO createVO = new OrderVO(createOrderGeneral, Double.parseDouble(previousPriceInOrder.getText()), 
				RoomType.convertString2Roomtype(roomTypeInOrder.getValue()), roomCountInOrder.getValue(), guestNumInOrder.getValue(), 
				messageInOrder.getText());

		final ResultMessage msg = orderBLController.createOrder(createVO);

		if (msg == ResultMessage.SUCCESS) {
			new PopUp("订单生成成功", "订单");
		}else {
			new PopUp("订单生成失败", "订单");
		}
	}
}

