package presentation.webManagerUI.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import presentation.signUpUI.controller.StageController;
import utilities.IDReserve;

public class WebManagerViewController {
	@FXML
	private StackPane right;
	@FXML
	private Pane mainPane;
	@FXML
	private ImageView leftImage,rightImage;
	
	private Parent currentParent;

	@FXML
	private Label ID;
	
	@FXML
	void initialize(){
			String userID = IDReserve.getInstance().getUserID();
			ID.setText(userID);

			leftImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream("left.png")));
			rightImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream("right.png")));
	}

	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转客户修改界面
	 */
	@FXML
	protected void openGuest() throws IOException {
		jump("ModifyGuest");
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转酒店工作人员修改界面
	 */
	@FXML
	protected void openHotel() throws IOException {
		jump("ModifyHotelWorker");
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转营销人员修改或添加界面
	 */
	@FXML
	protected void openMarketer() throws IOException {
		jump("ModifyMarketer");
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转酒店注册界面
	 */
	@FXML
	protected void openHotelInfo() throws IOException {
		jump("ModifyHotelInfo");
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转主界面
	 */
	@FXML
	protected void openMain() {
		right.getChildren().clear();
		right.getChildren().add(mainPane);
	}
	/**
	 * @author 61990
	 * @lastChangedBy  61990
	 * @updateTime 2016/12/11
	 * @注销
	 */  

	@FXML 
	protected void logout() throws IOException{
		Stage stage=StageController.getInstance().getStage();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("logIn.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
	/**
	 * @Description:封装跳转逻辑
	 * @param parent
	 * @param path
	 * void
	 * @author: Harvey Gong
	 * @lastChangedBy: 61990
	 * @time:2016年12月8日 下午3:08:24
	 */
	private void jump(String path){
		right.getChildren().clear();
		try {
			currentParent = FXMLLoader.load(getClass().getClassLoader().getResource(path+".fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		right.getChildren().add(currentParent);
	}
}
