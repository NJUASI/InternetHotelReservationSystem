package presentation.hotelWorkerUI.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class PromotionController {
	 @FXML private Pane promotion;
	  @FXML private Pane promotionModify;
	  @FXML
		protected void openModify(){
		  promotionModify.setVisible(true);
		  promotion.setVisible(false);
	  }
	  @FXML
		protected void cancel(){
		  promotion.setVisible(true);
		  promotionModify.setVisible(false);
	  }
	  @FXML
			protected void save(){
			  promotion.setVisible(true);
			  promotionModify.setVisible(false);
	 }
		 
	  
}
