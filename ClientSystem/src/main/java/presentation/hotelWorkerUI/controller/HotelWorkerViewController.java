package presentation.hotelWorkerUI.controller;

import java.io.IOException;


import businessLogic.hotelBL.HotelBLController;
import businessLogicService.hotelBLService.HotelBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.signUpUI.controller.StageController;
import utilities.IDReserve;
import vo.HotelVO;
/**
 * @description 控制酒店工作人员所有界面的跳转
 * @author 61990
 * @lastChangedBy Harvey
 */
public class HotelWorkerViewController {

	@FXML 
	private AnchorPane right;
	@FXML 
	private AnchorPane mainPane;
	
	private Parent currentParent;
	
	HotelBLService hotelBLController;
	String hotelID = IDReserve.getInstance().getUserID();
	
	public HotelWorkerViewController() {
		hotelBLController = HotelBLController.getInstance();
	}
	/**
	 * @description:
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/7 
	 */
	@FXML
	private void initialize() {

		HotelVO hotelVO = hotelBLController.getHotelInfo(hotelID);
		infoBt.setText(hotelVO.hotelName);
	}

	@FXML
	private Button infoBt;
	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @查看酒店信息 
	 */    
	@FXML 
	protected void openHotelInfo() throws IOException{
		jump("HotelDetail");
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @查看酒店订单信息 
	 */    
	@FXML 
	protected void openOrderInfo() throws IOException{
		jump("OrderCheck");
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @线下处理 
	 */    
	@FXML 
	protected void openOffline() throws IOException{
		jump("Offline");
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @查看酒店策略信息 
	 */    
	@FXML 
	protected void openPromotion() throws IOException{
		jump("Promotion");
	}
	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @查看酒店房间信息 
	 */    
	@FXML 
	protected void openRoomInfo() throws IOException{
		jump("RoomInfo");
	}
	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @查看主面板信息 
	 */    
	@FXML 
	protected void openMain() throws IOException{
		right.getChildren().clear();
		right.getChildren().add(mainPane);
	}
	/**
	 * @author 61990
	 * @lastChangedBy  61990
	 * @updateTime 2016/12/11
	 * @注销
	 */  
	@SuppressWarnings("restriction")
	@FXML 
	protected void logout() throws IOException{
		Stage stage=StageController.getInstance().getStage();
		Parent root = FXMLLoader.load(getClass().getResource("/presentation/signUpUI/view/logIn.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
	
	/**
	 * @Description:封装界面跳转逻辑
	 * @param parent
	 * @param path
	 * void
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月8日 下午2:54:27
	 */
	private void jump(String path){
		right.getChildren().clear();
		try {
			currentParent = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/"+path+".fxml"));
		} catch (IOException e) {
		}
		right.getChildren().add(currentParent);
	}
}
