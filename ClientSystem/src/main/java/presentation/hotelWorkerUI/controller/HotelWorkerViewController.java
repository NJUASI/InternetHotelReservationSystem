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

	@FXML 
	private AnchorPane right;
	@FXML 
	private AnchorPane mainPane;
	
	private Parent currentParent;
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
