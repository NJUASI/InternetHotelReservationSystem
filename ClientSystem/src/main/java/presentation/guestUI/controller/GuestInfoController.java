package presentation.guestUI.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import vo.GuestVO;

/**
 * @description 查看客户信息界面的控制类
 * @author 61990
 * @lastChangedBy Harvey
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
	private TextField name2, nickname2, phone2, password2;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		//TODO 通过guestID获得guestVO

		guestVO = new GuestVO("12345", null, "", "张三", "小张", "123456", "13993323454", 100);
		guestID.setText(guestVO.userID);
		name.setText(guestVO.name);
		nickname.setText(guestVO.nickName);
		password.setText(guestVO.password);
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
		password2.setText(password.getText());
	}

	/**
	 * @description 点击保存按钮
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void saveGuestInfo() {

		//TODO 需要先将修改过的信息封装成一个vo，然后调用下层更新客户信息的方法，并刷新客户信息
		try {
			//TODO 通过guestVO保存信息

			name.setText(name2.getText());
			nickname.setText(nickname2.getText());
			phone.setText(phone2.getText());
			password.setText(password2.getText());

			//			save(	name.setText(name2.getText()),			
			//					nickname.setText(nickname2.getText()),
			//			phone.setText(phone2.getText()),
			//			password.setText(password2.getText()));

			guestModify.setVisible(false);
			guestCheck.setVisible(true);

			//再次初始化界面
			initialize();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * @description 点击取消按钮，取消修改
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void cancer() {
		guestModify.setVisible(false);
		guestCheck.setVisible(true);
	}
}
