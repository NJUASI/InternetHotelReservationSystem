package presentation.PopUp;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * @author 61990
 * @lastChangedBy 61990
 * @updateTime 2016/12/10
 * @弹框类
 */
public class PopUp {
	StackPane root;
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
		root.getChildren().add(result);
		stage.setTitle(operation);
	}

	private void initWindow() {
		root = new StackPane();
		scene = new Scene(root,300,150); // 创建场景；
		stage = new Stage();// 创建舞台；
		stage.setScene(scene); // 将场景载入舞台；
		stage.show(); // 显示窗口；
	}
}
