package presentation.webMarketerUI.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import businessLogic.creditBL.CreditController;
import businessLogic.userBL.UserController;
import businessLogic.userBL.userService.Guest;
import businessLogic.userBL.userService.service.GuestCreditService;
import businessLogicService.userBLService.UserBLService;
import exception.inputException.InvalidInputException;
import exception.verificationException.UserInexistException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import presentation.PopUp.PopUp;
import utilities.Detector;
import utilities.enums.CreditRecord;
import vo.CreditVO;
import vo.GuestVO;

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
	@FXML
	private ImageView rightImage;
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		rightImage.setImage(new Image("/presentation/signUpUI/picture/right.png"));
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
		
		if (!searchGuestID.getText().equals("")) {
			//输入不为空时才响应
			try {
				guestVO = (GuestVO) userBLService.getSingle(searchGuestID.getText());
				chargePane.setVisible(true);
				guestID.setText(guestVO.userID);
				name.setText(guestVO.name);
				credit.setText(Double.toString(guestVO.credit));
			} catch (UserInexistException e) {
				new PopUp("该用户不存在", "搜索失败");
			}
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
		//我不是很懂
//		通过得到改变后的信用值 Double.parseDouble(chargeNum.getText()) + Double.parseDouble(credit.getText())
		
		if (!chargeNum.getText().equals("")) {
			/*
			 * 因为user里的modifyCredit只是单纯的将信用值改变为期望值，crredit里面没有相关接口
			 * 故此处逻辑暴露，要不就这样，要不还是得新增接口Credit.charge(args)
			 * TODO @龚尘淼 Charge回复 ，可以啊，但Credit不是我的模块
			 */
			LocalDateTime time = LocalDateTime.now();
			try {
				new Detector().chargeDetector(chargeNum.getText());
				
				final double preCredit = Double.parseDouble(credit.getText());
				double afterCredit = preCredit +  Double.parseDouble(chargeNum.getText()) * 100;
				CreditVO creditVO = new CreditVO(guestID.getText(), time, "", preCredit, afterCredit, CreditRecord.CHARGE);
		
				creditController.addCreditRecord(creditVO);
				credit.setText(Double.toString(afterCredit));
				chargeNum.setText("");
			} catch (InvalidInputException e1) {
				e1.printStackTrace();
				new PopUp("请勿输入无效符号", "充值失败");
			} catch (UserInexistException e) {
				e.printStackTrace();
				new PopUp("该用户不存在，请检查输入的ID", "充值失败");
			}
		}
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
