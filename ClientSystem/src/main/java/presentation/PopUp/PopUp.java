package presentation.PopUp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * @author 61990
 * @lastChangedBy 61990
 * @updateTime 2016/12/10
 * @弹框类
 */
public class PopUp {
	Pane root;
	Stage stage;
	Scene scene;
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/10
	 * @只显示一条提示信息的通用方法
	 */
	public PopUp(String message, String operation){
		initWindow();
		Label result = new Label(message);
		VBox vbox = new VBox(); 
		vbox.setPrefHeight(150);
		vbox.setPrefWidth(300);
		StackPane pane1=new StackPane();
		pane1.setPrefHeight(200);
		pane1.getChildren().add(result);
		
		Button btn = new Button();
	       btn.setText("关闭");
	       btn.setLayoutX(140);
	       btn.setLayoutY(120);
	       btn.setOnAction(new EventHandler<ActionEvent>() {
	           @Override
	           public void handle(ActionEvent event) {
	             stage.close();
	           }
	    });
	  StackPane pane2=new StackPane();
	  pane2.setPrefHeight(100);
		pane2.getChildren().add(btn);
		vbox.getChildren().addAll(pane1,pane2);
		root.getChildren().add(vbox);
		
		stage.setTitle(operation);

		
	}

	private void initWindow() {
		root = new Pane();
		scene = new Scene(root,300,150); // 创建场景；
		stage = new Stage();// 创建舞台
		stage.setScene(scene); // 将场景载入舞台；
		stage.setAlwaysOnTop(true);
		stage.setResizable(false);
		stage.show(); // 显示窗口；
	}
}
