package presentation.hotelWorkerUI.controller;

import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utilities.RoomType;
import vo.RoomInfoVO;
/**
 * @author 61990
 * @控制酒店房间界面
 * @version 11.27
 */
public class RoomController {
	@FXML
	private Pane modifyPane;
	@FXML
	private TableView<TypeTable> roomTable;
	@FXML
	private TableColumn<TypeTable, String> typeColumn, roomNameColumn,roomNumColumn,remainRoomColumn, priceColumn;
	
	List<RoomInfoVO> roomList;
	@FXML
	private Button addBt;
	
	@FXML
	private ComboBox<String> roomType;
	@FXML
	private TextField roomName,roomNum,price;
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
	 * @构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		
		roomType.getItems().clear();
		roomType.getItems().add("单人间");
		roomType.getItems().add("双人间");
		roomList = new LinkedList<>();
		roomList.add(new RoomInfoVO("123456", RoomType.三人间,"sasdasdas", 23,3, 259));
		roomList.add(new RoomInfoVO("123456", RoomType.三人间,"sasdasdas", 23,3, 259));
		roomList.add(new RoomInfoVO("123456", RoomType.三人间,"sasdasdas", 23,3, 259));
		roomList.add(new RoomInfoVO("123456", RoomType.三人间,"sasdasdas", 23,3, 259));
		initRoomTable(roomList);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
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
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @获取表中内容直接修改
	 */
	@FXML
	protected void modifyOne() {
		try{
			setModifyText(roomTable.getSelectionModel().getSelectedItem().getRoomType(),
			roomTable.getSelectionModel().getSelectedItem().getRoomName(),
			roomTable.getSelectionModel().getSelectedItem().getRoomType(),
			roomTable.getSelectionModel().getSelectedItem().getPrice());
			modifyPane.setVisible(true);
			addBt.setVisible(false);
		} catch (Exception e) {
			System.out.println("请选定");
		}
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @保存房间类型
	 */
	@FXML
	protected void save() {
		try {
			
		modifyPane.setVisible(false);
		addBt.setVisible(true);
		setModifyText("","","","");
		initialize();
		} catch (Exception e) {
			System.out.println("保存失败");
		}
	}
	void setModifyText(String roomType,String roomName,String roomNum,String price){
		this.roomType.setValue(roomType);
		this.roomName.setText(roomName);
		this.roomNum.setText(roomNum);
		this.price.setText(price);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @添加房间类型
	 */
	@FXML
	protected void addRoomType() {
		try {
//			roomType.getValue();
//			roomName.getText();
//			roomNum.getText();
//			price.getText();
//			RoomInfoVO=
			initialize();
		System.out.println("success");
	
		} catch (Exception e) {
			System.out.println("保存失败");
		}
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @取消修改
	 */
	@FXML
	protected void cancelModify() {
		try {
			modifyPane.setVisible(false);
			addBt.setVisible(true);
			setModifyText("","","","");
		} catch (Exception e) {

		}
	}
}
