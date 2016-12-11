package presentation.hotelWorkerUI.controller;

import java.util.Iterator;

import businessLogic.hotelBL.HotelBLController;
import businessLogicService.hotelBLService.HotelBLService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import utilities.IDReserve;
import utilities.enums.RoomType;
import vo.RoomInfoVO;

public class OfflineController {

	@FXML
	private ComboBox<String> roomType,roomType2;
	@FXML
	private ComboBox<Integer> roomNum,roomNum2;
	
	HotelBLService hotelBLController;
	String hotelID;
	private int maxRoomNum = 3;

	public OfflineController() {
		hotelBLController = HotelBLController.getInstance();
		hotelID = IDReserve.getInstance().getUserID();
	}

	@FXML
	void initialize(){
		roomType.setOnShowing(new RoomTypeShowingEventHandler());
		roomType2.setOnShowing(new RoomType2ShowingEventHandler());
		roomType.valueProperty().addListener(new RoomTypeChangedListener());
		roomType2.valueProperty().addListener(new RoomType2ChangedListener());
	}

	class RoomTypeShowingEventHandler implements EventHandler<Event>{
		@Override
		public void handle(Event arg0) {
			roomType.getItems().clear();
			Iterator<RoomInfoVO> rooms = hotelBLController.getHotelRoomInfo(hotelID);
			roomType.getItems().clear();
			while(rooms.hasNext()){
				roomType.getItems().add(rooms.next().roomType.getChineseRoomType());
			}
		}
	}

	class RoomType2ShowingEventHandler implements EventHandler<Event>{
		@Override
		public void handle(Event arg0) {
			Iterator<RoomInfoVO> rooms = hotelBLController.getHotelRoomInfo(hotelID);
			roomType2.getItems().clear();
			while(rooms.hasNext()){
				roomType2.getItems().add(rooms.next().roomType.getChineseRoomType());
			}
		}
	}

	class RoomTypeChangedListener implements ChangeListener<String> {
		@Override
		public void changed(ObservableValue<? extends String> arg0, String preRoomType, String newRoomType) {
			roomNum.getItems().clear();
			for(int i = 1;i <= maxRoomNum;i++){
				roomNum.getItems().add(i);
			}
			roomNum.setValue(1);
		}
	}

	class RoomType2ChangedListener implements ChangeListener<String> {
		@Override
		public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
			roomNum2.getItems().clear();
			for(int i = 1;i <= maxRoomNum;i++){
				roomNum2.getItems().add(i);
			}
			roomNum2.setValue(1);
		}
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
	 * @线下客户入住
	 */
	@FXML
	protected void checkIn(){
		hotelBLController.checkInOffline(hotelID, RoomType.getEnum(roomType.getValue()), Integer.valueOf(roomNum.getValue()));
		roomType.setValue("");
		roomNum.setValue(null);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
	 * @线下客户退房
	 */
	@FXML
	protected void checkOut(){
		/**
		 * TODO fjj注意：这里将roomType2改为roomName2，roomNum2也改为选择的，
		 * 我把已经入住的房间数量加载进来，不然又会加入条件检测；
		 * 我加了已经，房间的初始数目在前面初始化
		 * roomNum.getItems().add(i);for循环
		 */

		hotelBLController.checkOutOffline(hotelID,RoomType.getEnum(roomType2.getValue()), Integer.valueOf(roomNum2.getValue()));
		roomType2.setValue("");
		roomNum2.setValue(null);;
	}
}
