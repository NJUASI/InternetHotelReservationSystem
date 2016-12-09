package presentation.webManagerUI.controller;

import java.util.Iterator;

import javax.xml.ws.Holder;

import businessLogic.hotelBL.HotelBLController;
import businessLogic.sourceBL.SourceBLController;
import businessLogic.userBL.UserController;
import businessLogicService.hotelBLService.HotelBLService;
import businessLogicService.sourceBLService.SourceBLService;
import businessLogicService.userBLService.UserBLService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import vo.HotelVO;
import vo.HotelWorkerVO;

public class HotelInfoController {

	@FXML
	private ComboBox<String> cityInput,cycleInput;

	@FXML
	private ComboBox<Integer>levelInput;
	@FXML
	private TextField hotelName,address;

	private SourceBLService sourceBLController;
	private HotelBLService hotelBLController;
	private  UserBLService userBLConrtoller;
	
	public HotelInfoController() {
		sourceBLController = SourceBLController.getInstance();
		hotelBLController = HotelBLController.getInstance();
		userBLConrtoller = UserController.getInstance();
	}

	/**
	 * @description 获得所有城市名称
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7 
	 * @查找城市
	 */
	@FXML
	protected void searchCity() {
		cityInput.getItems().clear();

		Iterator<String> cities = sourceBLController.getCities();
		while(cities.hasNext()){
			cityInput.getItems().add(cities.next());
		}
	}

	/**
	 * @description 查找星级
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void searchLevel() {
		levelInput.getItems().clear();

		Iterator<String> levels = sourceBLController.getLevels();

		while(levels.hasNext()){
			//TODO 把levelInput的add改为String类型，因为其它都是String类型，就可以减少重复的代码
			levelInput.getItems().add(Integer.valueOf(levels.next()));
		}
	}

	/**
	 * @description 查找商圈
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void searchCycle() {

		cycleInput.getItems().clear();
		//调用sourceBL方法获取该城市的所有商圈
		Iterator<String> circles = sourceBLController.getCircles(cityInput.getValue());
		while(circles.hasNext()){
			cycleInput.getItems().add(circles.next());
		}
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
}
