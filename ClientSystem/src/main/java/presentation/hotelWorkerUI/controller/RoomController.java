package presentation.hotelWorkerUI.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businessLogic.hotelBL.HotelBLController;
import businessLogicService.hotelBLService.HotelBLService;
import exception.operationFailedException.UpdateFaiedException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utilities.IDReserve;
import utilities.RoomType;
import vo.RoomInfoVO;
/**
 * @description 酒店客房信息界面的控制器
 * @author 61990
 * @lastChangedBY Harvey
 */
public class RoomController {
	@FXML
	private Pane modifyPane;
	@FXML
	private TableView<TypeTable> roomTable;
	@FXML
	private TableColumn<TypeTable, String> typeColumn, roomNameColumn,roomNumColumn,remainRoomColumn, priceColumn;

	@FXML
	private Button addBt;

	@FXML
	private ComboBox<String> roomType;
	@FXML
	private TextField roomName,roomNum,price;


	HotelBLService hotelBLController;
	String hotelID;
	public RoomController() {
		hotelBLController = HotelBLController.getInstance();
		hotelID = IDReserve.getInstance().getUserID();
	}

	/**
	 * @description 初始化该酒店的所有客房信息
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	private void initialize() {

		//TODO gcm注意：需要初始化添加信息列表中的房间类型
		roomType.getItems().clear();
		Iterator<RoomInfoVO> rooms = hotelBLController.getHotelRoomInfo(hotelID);
		List<RoomInfoVO> roomList = new ArrayList<RoomInfoVO>();
		while(rooms.hasNext()){
			roomList.add(rooms.next());
		}
		initRoomTable(roomList);
	}

	/**
	 * @description 初始化客房信息列表
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 * @初始化房间类型表
	 */
	private void initRoomTable(List<RoomInfoVO> roomList) { 	
		roomTable.getItems().clear();
		List<TypeTable> dataList = new LinkedList<TypeTable>();
		for (int i = 0; i < roomList.size(); i++) {
			RoomInfoVO temp = roomList.get(i);
			dataList.add(new TypeTable(temp.roomType.toString(),temp.roomName, temp.roomNum + "", temp.remainNum + "", Double.toString(temp.price)));
		}

		ObservableList<TypeTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < dataList.size(); i++) {
			data.add(dataList.get(i));
		}
		typeColumn.setCellValueFactory(cellData -> cellData.getValue().roomType);
		roomNameColumn.setCellValueFactory(cellData -> cellData.getValue().roomName);
		roomNumColumn.setCellValueFactory(cellData -> cellData.getValue().roomNum);
		remainRoomColumn.setCellValueFactory(cellData -> cellData.getValue().remainRoomNum);
		priceColumn.setCellValueFactory(cellData -> cellData.getValue().price);

		roomTable.setItems(data);
	}

	String preType;
	String preRoomNum;
	String preRemainNum;
	/**
	 * @description 从table中选中一条记录，然后点击修改
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void modifyOne() {
		// TODO gcm注意：房间类型选择的combobox中还需加入房间类型
		TypeTable selectedRoomVO = null;
		try{
			selectedRoomVO = roomTable.getSelectionModel().getSelectedItem();
			preType=roomTable.getSelectionModel().getSelectedItem().getRoomType();
			preRoomNum=roomTable.getSelectionModel().getSelectedItem().getRoomNum();
			preRemainNum=roomTable.getSelectionModel().getSelectedItem().getRemainRoomNum();
			setModifyText(selectedRoomVO.getRoomType(),selectedRoomVO.getRoomName(),
					selectedRoomVO.getRoomType(),selectedRoomVO.getPrice());
			modifyPane.setVisible(true);
			addBt.setVisible(false);
		} catch (Exception e) {
			System.out.println("请选定");
		}
	}

	/**
	 * @description 保存房间类型
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void save() {
		/**
		 *  TODO gy注意：需要获得被点击修改房间类型的旧名字，原始房间剩余数量，计算出现修改房间数量修改后的房间剩余数量
		 *  TODO gcm 旧名字指的是类型的名字吧？原始房间剩余数量不能打包，因为你在修改的时候有延迟，变数据库的时候不去直接动剩余房间信息
		 *    			只能给你一个改变量然后你去加或者减剩余数量
		 *  preName 旧类型
		 *  Integer.parseInt(preRemainNum) 旧剩余数量
		 * Integer.parseInt(preRoomNum) 旧房间总数量
		 *  roomType.getValue() 新类型
		 *  roomName.getText()  新名字
		 *   Integer.parseInt(roomNum.getText())  新房间总数
		 *  price.getText()  新价格
		 *  剩余房间变化 Integer	int i= Integer.parseInt(roomNum.getText())-Integer.parseInt(preRoomNum)
		 *  立即的房间剩余数量 给i+Integer.parseInt(preRemainNum);
		 *  
		 *	并把打包好的vo与旧名字传下去，调用更新客房信息的方法
		 */
	
		modifyPane.setVisible(false);
		addBt.setVisible(true);
		setModifyText("","","","");
		initialize();
	}
	void setModifyText(String roomType,String roomName,String roomNum,String price){
		this.roomType.setValue(roomType);
		this.roomName.setText(roomName);
		this.roomNum.setText(roomNum);
		this.price.setText(price);
	}

	/**
	 * @description 添加房间类型
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 * @添加房间类型
	 */
	@FXML
	protected void addRoomType() {
		/**
		 * TODO gy注意：需要获取所添加的酒店信息，在下面封装成vo
		 * 并根据该信息封装成一个vo，然后调用添加酒店客房信息的方法
		 */
		initialize();
	}

	/**
	 * @description 取消修改
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void cancelModify() {
		modifyPane.setVisible(false);
		addBt.setVisible(true);
		setModifyText("","","","");
	}
}
