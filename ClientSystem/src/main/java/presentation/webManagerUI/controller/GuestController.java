package presentation.webManagerUI.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/1 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2 
	 * @通过ID查VO
	 */
	@FXML
	protected void search() {
		guestVO = new GuestVO("12356789", null, "人寿保险", "fjj", "fjj", "qfghyrs", "13999439954", 4.19);

		try {	
			// inputID.getText();
			// test
			
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
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2 
	 * @更改VO并保存
	 */
	@FXML
	protected void saveModify() {
		guestVO.birthday = birthdayPicker.getValue();
		guestVO.enterprise = enterpriseText.getText();
		guestVO.phone=phoneText.getText();
		guestVO.name=nameText.getText();
		guestVO.nickName=nickNameText.getText();
		guestVO.password=passwordText.getText();
		
		//save guestVO
		modifyBt.setVisible(true);
		modifyPane.setVisible(false);
		
		initialize();
	}

}
