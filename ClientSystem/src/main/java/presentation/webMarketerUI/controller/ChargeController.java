package presentation.webMarketerUI.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import businessLogic.creditBL.CreditController;
import businessLogic.userBL.UserController;
import businessLogic.userBL.stub.UserBLService_Stub;
import businessLogic.userBL.userService.Guest;
import businessLogic.userBL.userService.service.GuestCreditService;
import businessLogicService.userBLService.UserBLService;
import exception.verificationException.UserInexistException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.PopUp.PopUp;
import utilities.enums.CreditRecord;
import vo.CreditVO;
import vo.GuestVO;
import vo.OrderVO;

/**
 * @author 61990
 * @控制信用充值界面
 * @version 11.27
 */
public class ChargeController {

	//user
	private UserBLService userBLService;
	private GuestCreditService creditService;

	//credit
	private CreditController creditController;
	
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
		//TODO 冯俊杰回复：不归我啊，但顺手将其修改为实现
		userBLService = UserController.getInstance();
		creditService = new Guest();
//		userBLService = new UserBLService_Stub();
		
		creditController = CreditController.getInstance();
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @ 点击查询按钮，返回客户信息，初始化界面
	 */	
	@FXML
	protected void search() {
		
		try {
			guestVO = (GuestVO) userBLService.getSingle(searchGuestID.getText());
			chargePane.setVisible(true);
			guestID.setText(guestVO.userID);
			name.setText(guestVO.name);
			credit.setText(Double.toString(guestVO.credit));
		} catch (UserInexistException e) {
			e.printStackTrace();
			// 为了保证编译能通过
			new PopUp("该用户不存在", "搜索失败");
		}
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
		
		if (credit.getText() != null) {
			/*
			 * TODO 董金玉：因为user里的modifyCredit只是单纯的将信用值改变为期望值，crredit里面没有相关接口
			 * 故此处逻辑暴露，要不就这样，要不还是得新增接口Credit.charge(args)
			 */
			final LocalDateTime time = LocalDateTime.now();
			final double preCredit = Double.parseDouble(chargeNum.getText());
			double afterCredit = preCredit +  Double.parseDouble(credit.getText());
			CreditVO creditVO = new CreditVO(guestID.getText(), time, "", preCredit, afterCredit, CreditRecord.CHARGE);
			try {
				creditController.addCreditRecord(creditVO);
			} catch (UserInexistException e) {
				e.printStackTrace();
			}
//			try {
//				afterCredit = Double.parseDouble(chargeNum.getText()) +  Double.parseDouble(credit.getText());
//				creditVO = new CreditVO(guestID.getText(), time, 
//						"", thisGuest.credit, afterCredit, CreditRecord.CHARGE);
//			} catch (NumberFormatException e) {
//				e.printStackTrace();
//			} catch (UserInexistException e) {
//				e.printStackTrace();
//				// TODO 弹窗提示，需要充值的客户不存在
//			}
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
