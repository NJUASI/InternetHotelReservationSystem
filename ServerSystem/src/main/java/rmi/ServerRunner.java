package rmi;


import java.io.IOException;

import checkAbnormalOrder.CheckThread;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ServerRunner extends Application{

	public ServerRunner() {
		ServerRemoteHelper.setLocalhost();
		//		ServerRemoteHelper.setIPandPort("172.28.21.131", "8889");
		new ServerRemoteHelper();
	}

	public void start(final Stage stage) throws IOException {
		StackPane root = new StackPane();
		final Scene scene = new Scene(root, 500, 300);
		Label label = new Label("welcome");
		root.getChildren().add(label);
		stage.setTitle("酒店互联网预定系统");
		stage.setScene(scene);

		stage.show();
		stage.setOnCloseRequest(new EventHandler<WindowEvent>(){

			@Override
			public void handle(WindowEvent event) {
				System.exit(0); 
			}
		});

		//启动自动检查的线程
		CheckThread checkThread = new CheckThread();
		Thread check = new Thread(checkThread);
		System.out.println("线程已启动");
		check.start();
	}
	public static void main(String[] args) {

		launch(args);

		new ServerRunner();

	}
}
