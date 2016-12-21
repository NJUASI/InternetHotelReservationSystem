package presentation.signUpUI.controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import utilities.enums.UserType;

public class RootFactory {

	private Parent root = null;

	public Parent createRoot(UserType userType) {

		try {
			if (userType == UserType.GUEST) {
				root = FXMLLoader.load(getClass().getClassLoader().getResource("Guest.fxml"));
			}
			
			if (userType == UserType.HOTEL_WORKER) {
				root = FXMLLoader.load(getClass().getClassLoader().getResource("Hotel.fxml"));
			}
			
			if (userType == UserType.WEB_MARKETER) {
				root = FXMLLoader.load(getClass().getClassLoader().getResource("Marketer.fxml"));
			}
			
			if (userType == UserType.WEB_MANAGER) {
				root = FXMLLoader.load(getClass().getClassLoader().getResource("Manager.fxml"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return root;
		
	}

}
