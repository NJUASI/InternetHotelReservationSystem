package presentation.hotelWorkerUI.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
/**
 * @author 61990
 *
 */
public class HotelWorkerViewController {
	
	Parent hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo;	
	
		@FXML private AnchorPane right;
	    @FXML private AnchorPane mainPane;
	    
	    /**
		 * @author 61990
		 * @lastChangedBy 61990
		 * @updateTime 2016/12/1
		 * @查看酒店信息 
		 */    
	    @FXML 
		protected void openHotelInfo() throws IOException{
	    	right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
			hotelInfo = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/HotelDetail.fxml"));		
			right.getChildren().add(hotelInfo);			
		}
	    
	    /**
	  		 * @author 61990
	  		 * @lastChangedBy 61990
	  		 * @updateTime 2016/12/1
	  		 * @查看酒店订单信息 
	  		 */    
	    @FXML 
	  	protected void openOrderInfo() throws IOException{
	  			right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
	  			orderInfo = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/OrderCheck.fxml"));
	  			right.getChildren().add(orderInfo);	  			
	  	}
	    
	    /**
	  		 * @author 61990
	  		 * @lastChangedBy 61990
	  		 * @updateTime 2016/12/1
	  		 * @线下处理 
	  		 */    
	    @FXML 
  		protected void openOffline() throws IOException{
  			right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
  			offline = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/Offline.fxml"));
  			right.getChildren().add(offline);		
  		}
	    
	    /**
	  		 * @author 61990
	  		 * @lastChangedBy 61990
	  		 * @updateTime 2016/12/1
	  		 * @查看酒店策略信息 
	  		 */    
	    @FXML 
  		protected void openPromotion() throws IOException{
	    	right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
	    	promotion = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/Promotion.fxml"));
  			right.getChildren().add(promotion);
  		}
	    /**
	  		 * @author 61990
	  		 * @lastChangedBy 61990
	  		 * @updateTime 2016/12/1
	  		 * @查看酒店房间信息 
	  		 */    
	    @FXML 
  		protected void openRoomInfo() throws IOException{
	    	right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
  			roomInfo = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/RoomInfo.fxml"));
  		
  			right.getChildren().add(roomInfo);
  		}
	    /**
	  		 * @author 61990
	  		 * @lastChangedBy 61990
	  		 * @updateTime 2016/12/1
	  		 * @查看主面板信息 
	  		 */    
	    @FXML 
  		protected void openMain() throws IOException{
  			
  			right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
  			right.getChildren().add(mainPane);
  		}
}
