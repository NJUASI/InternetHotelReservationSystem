package presentation.guestUI.controller;

import businessLogic.userBL.UserController;
import businessLogicService.userBLService.UserBLService;
import exception.inputException.InvalidInputException;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.PasswordInputException;
import exception.operationFailedException.UpdateFaiedException;
import exception.verificationException.UserInexistException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.PopUp.PopUp;
import utilities.IDReserve;
import utilities.enums.ResultMessage;
import vo.GuestVO;

/**
 * @description 查看客户信息界面的控制类
 * @author 61990
 * @lastChangedBy Byron Dong
 */
public class GuestInfoController {
	GuestVO guestVO;
	// 加载guestInfo相关界面
	@FXML
	private Pane guestCheck;

	@FXML
	private Pane guestModify;

	// guestInfo界面内容
	@FXML
	private Label guestID, name, nickname, password, credit, phone;

	// modify 界面内容
	@FXML
	private TextField name2, nickname2, phone2;
	@FXML
	private PasswordField password2, password3;

	private String userID = IDReserve.getInstance().getUserID();;

	private UserBLService userBLController = UserController.getInstance();

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {

		try {
			guestVO = (GuestVO) userBLController.getSingle(userID);
		} catch (UserInexistException e) {
			e.printStackTrace();
			// 主要登录该情况是不出现的，只是为了编译通过
		}
		guestID.setText(guestVO.userID);
		name.setText(guestVO.name);
		nickname.setText(guestVO.nickName);
		password.setText("******");
		credit.setText(Double.toString(guestVO.credit));
		phone.setText(guestVO.phone);
	}

	/**
	 * @description 点击修改按钮
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void modifyGuestInfo() {
		guestModify.setVisible(true);
		guestCheck.setVisible(false);

		// 初始化modify界面
		name2.setText(name.getText());
		nickname2.setText(nickname.getText());
		phone2.setText(phone.getText());
		password2.setText(guestVO.password);
		password3.setText(guestVO.password);
	}

	/**
	 * @description 点击保存按钮
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void saveGuestInfo() {

		try {
			
			GuestVO tempGuestVO = guestVO;
			tempGuestVO.name = name2.getText();
			tempGuestVO.nickName = nickname2.getText();
			tempGuestVO.phone = phone2.getText();
			tempGuestVO.password = password2.getText();
			
			System.out.println(password2.getText().equals(password3.getText()));
			if(password2.getText().equals(password3.getText())){
				ResultMessage message = userBLController.modify(tempGuestVO);
			}else{
				new PopUp("请检查你的密码", "更改失败");
			}

		GuestVO tempGuestVO = guestVO;
		tempGuestVO.name = name2.getText();
		tempGuestVO.nickName = nickname2.getText();
		tempGuestVO.phone = phone2.getText();
		tempGuestVO.password = password2.getText();
		
		if (password2.getText().equals(password3.getText())) {
			try {
				ResultMessage message = userBLController.modify(tempGuestVO);

				new PopUp("您已经成功修改信息", "更改成功");
				
				guestModify.setVisible(false);
				guestCheck.setVisible(true);
				
				// 再次初始化界面
				initialize();
			} catch (InvalidLengthInputException e) {
				e.printStackTrace();
				new PopUp("请勿输入无效电话", "更改失败");
			} catch (InvalidInputException e) {
				e.printStackTrace();
				new PopUp("请勿输入不合法标识符或不能为空", "更改失败");
			} catch (PasswordInputException e) {
				e.printStackTrace();
				new PopUp("密码必须含有一个数字和密码或不能为空", "更改失败");
			} catch (UpdateFaiedException e) {
				e.printStackTrace();
				new PopUp("填写内容不能为空", "更改失败");
			}
		}
		else{
			new PopUp("请检查你的密码", "更改失败");
		}

	}

	/**
	 * @description 点击取消按钮，取消修改
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void cancer() {
		guestModify.setVisible(false);
		guestCheck.setVisible(true);
	}
}
