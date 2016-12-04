package presentation.hotelWorkerUI.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class HotelWorkerViewController {
	Parent hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo;	
	
		@FXML private AnchorPane right;
	    @FXML private AnchorPane mainPane;
	    
	    @FXML 
		protected void openHotelInfo() throws IOException{
	    	right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
			hotelInfo = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/HotelDetail.fxml"));		
			right.getChildren().add(hotelInfo);			
		}
	    @FXML 
	  	protected void openOrderInfo() throws IOException{
	  			right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
	  			orderInfo = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/OrderCheck.fxml"));
	  			right.getChildren().add(orderInfo);	  			
	  	}
	    @FXML 
  		protected void openOffline() throws IOException{
  			right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
  			offline = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/Offline.fxml"));
  			right.getChildren().add(offline);		
  		}
	    @FXML 
  		protected void openRemainRoom() throws IOException{
  			right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
  			remainRoom = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/RemainRoomInfo.fxml"));
  			right.getChildren().add(remainRoom);
  		}
	    @FXML 
  		protected void openPromotion() throws IOException{
	    	right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
	    	promotion = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/Promotion.fxml"));
  			right.getChildren().add(promotion);
  		}
	    @FXML 
  		protected void openRoomInfo() throws IOException{
	    	right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
  			roomInfo = FXMLLoader.load(getClass().getResource("/presentation/hotelWorkerUI/view/RoomInfo.fxml"));
  		
  			right.getChildren().add(roomInfo);
  		}
	    @FXML 
  		protected void openMain() throws IOException{
  			
  			right.getChildren().removeAll(mainPane,hotelInfo ,orderInfo, offline,remainRoom,promotion,roomInfo);
  			right.getChildren().add(mainPane);
  		}
}
