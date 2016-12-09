package presentation.webManagerUI.controller;

import java.util.Iterator;

import businessLogic.hotelBL.HotelBLController;
import businessLogic.sourceBL.SourceBLController;
import businessLogicService.hotelBLService.HotelBLService;
import businessLogicService.sourceBLService.SourceBLService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import vo.HotelVO;

public class HotelInfoController {

	@FXML
	private ComboBox<String> cityInput,cycleInput;

	@FXML
	private ComboBox<String>levelInput;
	@FXML
	private TextField hotelName,address;

	private SourceBLService sourceBLController;
	private HotelBLService hotelBLController;
	
	public HotelInfoController() {
		sourceBLController = SourceBLController.getInstance();
		hotelBLController = HotelBLController.getInstance();
		
		cityInput.setOnShowing(new CityShowingHandler());
		cityInput.valueProperty().addListener(new CityChangedListener());
		levelInput.setOnShowing(new LevelShowingHandler());
	}

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/9
	 * @添加酒店信息
	 */
	@FXML
	protected void addHotel(){
		//TODO djy注意:创建hotelVO，保存，并需要返回初始化的酒店编号和密码
		/*
		 *  TODO djy注意:先更改你addhotel的接口，我再去user那里修改
		 *  我这里add没有问题，要怎么修改
		 */
		
		HotelVO newHotel = new HotelVO();
		newHotel.hotelName = hotelName.getText();
		newHotel.city = cityInput.getValue();
		newHotel.circle = cycleInput.getValue();
		//TODO 还是将levelInput的改为返回String
		newHotel.level = String.valueOf(levelInput.getValue());
		newHotel.address = address.getText();
		hotelBLController.addHotel(newHotel);
		
//		HotelWorkerVO tempHotelWorkerVO  = new HotelWorkerVO()
		// TODO gcm 注意！！！	hotelID是你生成还是User生成因为两个的ID是一样的，我觉得是我生成
		// TODO gy 注意！！！	所有的用户的add都是由User返回ID和默认密码吗
	}
	
	class CityShowingHandler implements EventHandler<Event>{
		@Override
		public void handle(Event arg0) {
			if(cityInput.getItems().size() <= 1){
				Iterator<String> cities = sourceBLController.getCities();
				while(cities.hasNext()){
					cityInput.getItems().add(cities.next());
				}
			}
		}
	}

	class CityChangedListener implements ChangeListener<String> {
		@Override
		public void changed(ObservableValue arg0, String preCity, String selectedCity) {
			cycleInput.getItems().clear();
			Iterator<String> circles = sourceBLController.getCircles(selectedCity);
			while(circles.hasNext()){
				cycleInput.getItems().add(circles.next());
			}
			cycleInput.setValue(cycleInput.getItems().get(0));
		}
	}

	class LevelShowingHandler implements EventHandler<Event>{
		@Override
		public void handle(Event arg0) {
			if(levelInput.getItems().size() <= 1){
				Iterator<String> levels = sourceBLController.getLevels();
				while(levels.hasNext()){
					levelInput.getItems().add(levels.next());
				}	
			}
		}
	}
}
