package presentation.webMarketerUI.controller;

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

/**
 * @author 61990
 *
 */
public class WebMarketerViewController {

	@FXML
	private StackPane right;

	@FXML
	private Pane mainPane;
	
	@FXML
	private Label ID;
	@FXML
	private ImageView leftImage,rightImage;
	private Parent currentParent;
	
	@FXML
	void initialize(){
			String userID = IDReserve.getInstance().getUserID();
			ID.setText(userID);

			leftImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream("left.png")));
			rightImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream("right.png")));
	}

	
	
	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @跳转主界面
	 */
	@FXML
	protected void openMain() {
		right.getChildren().clear();
		right.getChildren().add(mainPane);
	}

	/**
	 * @dscription 跳转信用充值界面
	 * @author 61990
	 * @throws IOException 
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 */
	@FXML
	protected void openCharge(){
		jump("MarketerCharge");
	}

	/**
	 * @description 跳转会员等级制定界面
	 * @author 61990
	 * @throws IOException 
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 */
	@FXML
	protected void openMarket(){
		jump("MarketerMemberCheck");
	}

	/**
	 * @description 跳转网站商圈策略制定界面
	 * @author 61990
	 * @throws IOException 
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 */
	@FXML
	protected void openPromotion(){
		jump("MarketerCyclePromotion");
	}

	/**
	 * @description  跳转会员等级制定界面
	 * @author 61990
	 * @throws IOException 
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 */
	@FXML
	protected void openCommonPromotion(){
		jump("MarketerDatePromotion");
	}

	/**
	 * @description 跳转异常订单界面
	 * @author 61990
	 * @throws IOException 
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 */
	@FXML
	protected void openOrder(){
		jump("MarketerOrderSearch");
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
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月8日 下午3:08:03
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
