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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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
	
	public OfflineController() {
		hotelBLController = HotelBLController.getInstance();
		hotelID = IDReserve.getInstance().getUserID();
	}
	@FXML
	void initialize(){
		roomType.setValue("单人间");
		roomType2.setValue("单人间");
		 roomNum.setValue(1);
		 roomNum2.setValue(1);
		roomType.setOnShowing(new RoomTypeShowingEventHandler());
		roomType2.setOnShowing(new RoomTypeShowingEventHandler());
		roomType.valueProperty().addListener(new RoomTypeChangedListener());
	}
	
	class RoomTypeShowingEventHandler implements EventHandler<Event>{
		@Override
		public void handle(Event arg0) {
			roomType.getItems().clear();
			Iterator<RoomInfoVO> rooms = hotelBLController.getHotelRoomInfo(hotelID);
			while(rooms.hasNext()){
				roomType.getItems().add(rooms.next().roomType.getChineseRoomType());
			}
		}
	}
	
	class RoomTypeChangedListener implements ChangeListener<String> {
		@Override
		public void changed(ObservableValue<? extends String> arg0, String preRoomType, String newRoomType) {
			int remainRoomNum = hotelBLController.getRemainRoomNum(hotelID, RoomType.getEnum(newRoomType));
			roomNum.getItems().clear();
			for(int i = 1;i<= remainRoomNum;i++){
				roomNum.getItems().add(i);
			}
			if(remainRoomNum == 0){
				roomNum.setValue(0);
			}
			else{
				roomNum.setValue(1);
			}
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
