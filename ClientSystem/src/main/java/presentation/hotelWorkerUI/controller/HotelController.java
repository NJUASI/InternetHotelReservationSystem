package presentation.hotelWorkerUI.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class HotelController {
	@FXML
	private Pane hotelModifyPane;
	@FXML
	private Pane hotelInfoPane;

	@FXML
	protected void modify() {
		hotelModifyPane.setVisible(true);
		hotelInfoPane.setVisible(false);
	}

	@FXML
	protected void save() {
		hotelModifyPane.setVisible(false);
		hotelInfoPane.setVisible(true);
	}
	

	@FXML
	protected void cancel() {
		hotelModifyPane.setVisible(false);
		hotelInfoPane.setVisible(true);
	}
}
