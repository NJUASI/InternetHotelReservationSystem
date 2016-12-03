package presentation.hotelWorkerUI.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class RoomController {

    @FXML private Pane roomModifyPane;
    @FXML private Pane roomInfoPane;
    
    @FXML
    protected void modifyRoom() {
    	roomInfoPane.setVisible(false);
    	 roomModifyPane.setVisible(true);
    }
     
     @FXML
     public void cancelModify() {
    	 roomInfoPane.setVisible(true);
		 roomModifyPane.setVisible(false);
     }
     @FXML
     public void saveModify() {
    	 roomInfoPane.setVisible(true);
		 roomModifyPane.setVisible(false);
     }
}
