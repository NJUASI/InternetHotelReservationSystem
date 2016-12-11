package presentation.webManagerUI.controller;

import java.util.Iterator;

import businessLogic.sourceBL.SourceBLController;
import businessLogic.userBL.UserController;
import businessLogicService.sourceBLService.SourceBLService;
import businessLogicService.userBLService.UserBLService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import presentation.PopUp.PopUp;
import vo.HotelVO;

public class HotelInfoController {

	@FXML
	private ComboBox<String> cityInput,cycleInput;

	@FXML
	private ComboBox<String>levelInput;
	@FXML
	private TextField hotelName,address;

	private SourceBLService sourceBLController;
	private UserBLService userBLController;
	
	public HotelInfoController() {
		sourceBLController = SourceBLController.getInstance();
		userBLController = UserController.getInstance();
	}
	
	@FXML
	private void initialize() {
		
		String firstCity = sourceBLController.getCities().next();
		String firstCircle = sourceBLController.getCircles(firstCity).next();
		cityInput.setValue(firstCity);
		cycleInput.setValue(firstCircle);
		levelInput.setValue("1");
		
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
		
		HotelVO newHotel = new HotelVO();
		//TODO djy 怎么获得被添加酒店的id，你说根据酒店工作人员来，但是我不知道酒店工作人员的id
		newHotel.hotelName = hotelName.getText();
		newHotel.city = cityInput.getValue();
		newHotel.circle = cycleInput.getValue();
		newHotel.level = String.valueOf(levelInput.getValue());
		newHotel.address = address.getText();
		HotelVO hotelVO = userBLController.addHotel(newHotel);
		
		if(hotelVO == null){
			new PopUp("添加失败", "congratulation");	
		}
		//TODO djy 然后 hotelVO里有添加成功后的参数,没有密码，我需要的是登录的方式，也就是hotelWorker的账号密码
//		new PopUp("撤销成功"+ hotelVO.hotelID+hotelVO.", "congratulation");	
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
