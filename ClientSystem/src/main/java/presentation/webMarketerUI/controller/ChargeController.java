package presentation.webMarketerUI.controller;

import java.io.IOException;

import businessLogic.userBL.stub.UserBLService_Stub;
import businessLogic.userBL.userService.Guest;
import businessLogic.userBL.userService.service.GuestCreditService;
import businessLogicService.userBLService.UserBLService;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vo.GuestVO;

/**
 * @author 61990
 * @控制信用充值界面
 * @version 11.27
 */
public class ChargeController {

	private UserBLService userBLService;
	private GuestCreditService creditService;
	
	GuestVO guestVO;
	
	@FXML
	private Pane chargePane;

	@FXML
	private Label guestID , name , credit;
	
	@FXML
	private TextField searchGuestID , chargeNum;
	
	@FXML
	private Button searchBtn;
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		
		//TODO 掉需要的接口
//	TODO	fjj 这个是谁的上面那句话
		userBLService = new UserBLService_Stub();
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @ 点击查询按钮，返回客户信息，初始化界面
	 */	
	@FXML
	protected void search() {
		chargePane.setVisible(true);
		guestVO = (GuestVO) userBLService.getSingle(searchGuestID.getText());
		guestID.setText(guestVO.userID);
		name.setText(guestVO.name);
		credit.setText(Double.toString(guestVO.credit));
	}
	
	/**
	 * @author 61990
	 * @throws IOException
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @点击保存按钮，更改信用值信息
	 */
	@FXML
	protected void saveCharge() throws IOException {
		//TODO djy/gcm注意：通过guestID保存   guestID.getText()得到ID
//		通过得到改变后的信用值 Double.parseDouble(chargeNum.getText()) + Double.parseDouble(credit.getText())
		
		creditService = new Guest();
		if (credit.getText() != null) {
			creditService.modifyCredit(searchGuestID.getText(),
					Double.parseDouble(chargeNum.getText()) + Double.parseDouble(credit.getText()));
			showResult();
		}
	}
	//弹窗
	void showResult() throws IOException{
			Pane root = new Pane();
			Label result = new Label("save successfully");
			result.setLayoutY(50);
			result.setLayoutX(50);
			root.getChildren().add(result);
			Scene scene = new Scene(root,200,100); // 创建场景；
			Stage message = new Stage();// 创建舞台；
			message.setScene(scene); // 将场景载入舞台；
			message.show(); // 显示窗口；
	}
	/**
	 * @author 61990
	 * @throws IOException
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @点击返回按钮
	 */
	@FXML
	protected void cancelCharge() {
		chargePane.setVisible(false);
		chargeNum.setText("");
	}
}
