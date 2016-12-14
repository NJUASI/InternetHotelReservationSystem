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
		
		//启动自动检查的线程
		System.out.println("线程已启动");
		CheckThread check = new CheckThread();
		while(true){
			check.run();
		}
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
	}
	public static void main(String[] args) {

		launch(args);

		new ServerRunner();

	}
}
