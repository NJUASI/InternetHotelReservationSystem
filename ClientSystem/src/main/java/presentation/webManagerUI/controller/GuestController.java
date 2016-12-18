package presentation.webManagerUI.controller;

import businessLogic.userBL.UserController;
import businessLogicService.userBLService.UserBLService;
import exception.inputException.InvalidInputException;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.PasswordInputException;
import exception.operationFailedException.UpdateFaiedException;
import exception.verificationException.UserInexistException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.PopUp.PopUp;
import utilities.enums.ResultMessage;
import vo.GuestVO;

/**
 * @author 61990
 *
 */
public class GuestController {

	GuestVO guestVO;

	@FXML
	private Pane guestInfoPane, modifyPane;
	@FXML
	private Button modifyBt;
	@FXML
	private TextField inputID;
	@FXML
	private Label guestID, credit, nickName, phone, password, enterprise, name, birthday;
	@FXML
	private TextField nickNameText, passwordText, nameText, phoneText, enterpriseText;

	@FXML
	private DatePicker birthdayPicker;
	
	private UserBLService userBLController;

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		userBLController = UserController.getInstance();
	}
	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7 
	 * @通过ID查VO
	 */
	@FXML
	protected void search() {
		
		try {
			guestVO = (GuestVO) userBLController.getSingle(inputID.getText());
		} catch (UserInexistException e1) {
			e1.printStackTrace();
			new PopUp("请检查输入内容", "sorry");
			//TODO 原来是写在里面的
		}
		

		try {	
			guestID.setText(guestVO.userID);
			credit.setText(guestVO.credit + "");
			nickName.setText(guestVO.nickName);
			phone.setText(guestVO.phone);
			password.setText(guestVO.password);
			if (guestVO.enterprise != null) {
				enterprise.setText(guestVO.enterprise);
			}
			name.setText(guestVO.name);
			if (guestVO.birthday != null) {
				birthday.setText(guestVO.birthday.toString());
			}
			guestInfoPane.setVisible(true);
		} catch (Exception e) {
		
		}

	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2 
	 * @初始化修改界面
	 */
	@FXML
	protected void modifyGuest() {

		nickNameText.setText(nickName.getText());
		passwordText.setText(password.getText());
		nameText.setText(name.getText());
		phoneText.setText(phone.getText());
		
		if(enterprise.getText()!=""){
		enterpriseText.setText(enterprise.getText());
		}
		if(guestVO.birthday!=null){
		birthdayPicker.setValue(guestVO.birthday);
		}	

		modifyBt.setVisible(false);
		modifyPane.setVisible(true);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2 
	 * @取消修改
	 */
	@FXML
	protected void cancelModify() {
		modifyBt.setVisible(true);
		modifyPane.setVisible(false);
	}
	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7 
	 * @更改VO并保存
	 */
	@FXML
	protected void saveModify() {
		
		GuestVO tempGuestVO = guestVO;
		tempGuestVO.birthday = birthdayPicker.getValue();
		tempGuestVO.enterprise = enterpriseText.getText();
		tempGuestVO.phone=phoneText.getText();
		tempGuestVO.name=nameText.getText();
		tempGuestVO.nickName=nickNameText.getText();
		tempGuestVO.password=passwordText.getText();
		
		ResultMessage message = null;
		try {
			message = userBLController.modify(tempGuestVO);
			
			new PopUp(message.toString(), "congratulation");	
			
			modifyBt.setVisible(true);
			modifyPane.setVisible(false);
			
			search();
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
		} catch (UserInexistException e) {
			e.printStackTrace();
			new PopUp("请检查输入的编号", "sorry");
		}
		
	}

}
