package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import rmi.ClientRemoteHelper;



/**
 * @author 61990
 *
 */

public class Main extends Application {
	public static String userID;
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param stage 界面主载体
	 * @throws IOException 界面初始化
	 */
	public void start(final Stage stage) throws IOException {
		final Parent root = FXMLLoader.load(getClass().getResource("/presentation/signUpUI/view/logIn.fxml"));
		
		final Scene scene = new Scene(root, 1000, 625);

		stage.setTitle("酒店互联网预定系统");
		stage.setScene(scene);

		stage.show();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>(){

			@Override
			public void handle(WindowEvent event) {
				System.exit(0); 
			}
		});
	}

	/**
	 * @author 61990
	 * @param args ……
	 */
	public static void main(final String[] args) {
		ClientRemoteHelper.getInstance().init();
		launch(args);
	}
}
