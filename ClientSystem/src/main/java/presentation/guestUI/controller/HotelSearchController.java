package presentation.guestUI.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * @author 61990
 * @控制酒店预定界面
 * @version 11.27
 */
public class HotelSearchController {
	
	//加载HotelSearch相关界面

	@FXML
	private Pane cityAndCircle, hotelCheck, hotelDetail, hotelChoose, createPane;

	
	//city and cycle choose 内容
	@FXML
	private TextField cityInput;
	
//	@FXML
//	private ComboBox cycleChoose;
	
//	@FXML
//	private ComboBox cityChoose;
//	
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @打开酒店浏览界面
	 */
	@FXML
	protected void openHotelCheck() {
		cityAndCircle.setVisible(false);
		hotelCheck.setVisible(true);
		hotelChoose.setVisible(false);
		
//		cityInput.getText();
//		cycleChoose;
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
	private Label hotelName1, hotelName2, hotelName3, hotelName4, ID1, ID2, ID3, ID4;
	private Label city1, city2, city3, city4, cycle1, cycle2, cycle3, cycle4;
	private Label level1, level2, level3, level4, score1, score2, score3, score4;
	private Label price1, price2, price3, price4;

	/**
	 * 
	 */
	@FXML
	protected void lastPage() {
	
	}
	
	/**
	 * 
	 */
	@FXML
	protected void nextPage() {
		
	}
	
	/**
	 * 
	 */
	@FXML
	protected void openHotelDetail1() {
		hotelCheck.setVisible(false);
		hotelDetail.setVisible(true);
	}
	
	/**
	 * 
	 */
	@FXML
	protected void openHotelDetail2() {
		hotelCheck.setVisible(false);
		hotelDetail.setVisible(true);
	}
	
	/**
	 * 
	 */
	@FXML
	protected void openHotelDetail3() {
		hotelCheck.setVisible(false);
		hotelDetail.setVisible(true);
	}
	
	/**
	 * 
	 */
	@FXML
	protected void openHotelDetail4() {
		hotelCheck.setVisible(false);
		hotelDetail.setVisible(true);
	}
	
	/**
	 * 
	 */
	@FXML
	protected void openChoose() {
		hotelCheck.setVisible(false);
		hotelChoose.setVisible(true);
	}
	
	//HotelDetail界面
	/**
	 * 
	 */
	@FXML
	protected void returnHotelCheck() {
		hotelCheck.setVisible(true);
		hotelDetail.setVisible(false);
		createPane.setVisible(false);
	}
	
	
	//Hotel筛选界面

	//订单生成界面
	/**
	 * 
	 */
	@FXML
	protected void openCreateOrder() {
		hotelDetail.setVisible(false);
		createPane.setVisible(true);
	}

}
