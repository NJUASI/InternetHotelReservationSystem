package presentation.hotelWorkerUI.controller;

import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	TableView<TypeTable> roomTable;
	@FXML
	private TableColumn<TypeTable, String> typeColumn, roomNameColumn,roomNumColumn,remainRoomColumn, priceColumn;
	
	List<RoomInfoVO> roomList;
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
	 * @构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		roomList = new LinkedList<>();
		roomList.add(new RoomInfoVO("123456", RoomType.三人间,"sasdasdas", 23,3, 259));
		roomList.add(new RoomInfoVO("123456", RoomType.三人间,"sasdasdas", 23,3, 259));
		roomList.add(new RoomInfoVO("123456", RoomType.三人间,"sasdasdas", 23,3, 259));
		roomList.add(new RoomInfoVO("123456", RoomType.三人间,"sasdasdas", 23,3, 259));
		initRoomTable(roomList);
	}
	
	
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
}
