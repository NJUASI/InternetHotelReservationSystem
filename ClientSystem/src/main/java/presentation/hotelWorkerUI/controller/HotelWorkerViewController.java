package presentation.hotelWorkerUI.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
/**
 * @description 控制酒店工作人员所有界面的跳转
 * @author 61990
 * @lastChangedBy Harvey
 */
public class HotelWorkerViewController {
	Parent hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo;	

	@FXML private AnchorPane right;
	@FXML private AnchorPane mainPane;

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @查看酒店信息 
	 */    
	@FXML 
	protected void openHotelInfo() throws IOException{
		hotelInfo = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/HotelDetail.fxml"));
		jump(hotelInfo);
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @查看酒店订单信息 
	 */    
	@FXML 
	protected void openOrderInfo() throws IOException{
		orderInfo = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/OrderCheck.fxml"));
		jump(orderInfo);
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @线下处理 
	 */    
	@FXML 
	protected void openOffline() throws IOException{
		offline = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/Offline.fxml"));
		jump(offline);
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @查看酒店策略信息 
	 */    
	@FXML 
	protected void openPromotion() throws IOException{
		promotion = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/Promotion.fxml"));
		jump(promotion);
	}
	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @查看酒店房间信息 
	 */    
	@FXML 
	protected void openRoomInfo() throws IOException{
		roomInfo = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/RoomInfo.fxml"));
		jump(roomInfo);
	}
	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @查看主面板信息 
	 */    
	@FXML 
	protected void openMain() throws IOException{
		right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
		right.getChildren().add(mainPane);
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
	private void jump(Parent parent ){
		right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
		right.getChildren().add(roomInfo);
	}
}
