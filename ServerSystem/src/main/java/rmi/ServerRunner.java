package rmi;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import checkAbnormalOrder.CheckThread;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ServerRunner extends Application{



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
	public ServerRunner() {
		
		initFrame();
		
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
	private void initFrame() {
		JFrame jFrame = new JFrame("RMI连接");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		jFrame.setBounds(((int)dimension.getWidth() - 500) / 2, ((int)dimension.getHeight() - 400) / 2, 500, 400);
		jFrame.setResizable(false);
		jFrame.setLayout(null);
		JLabel label =new JLabel("welcome");
		label.setBounds(220, 195, 80, 10);
		jFrame.add(label);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		
	}
	public static void main(String[] args) {
		launch(args);
		new ServerRunner();
	}
}
