package presentation.guestUI.controller;

import businessLogic.userBL.UserController;
import businessLogicService.userBLService.UserBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utilities.IDReserve;
import utilities.ResultMessage;
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
	private PasswordField password2,password3;
	
	private String userID =  IDReserve.getInstance().getUserID();;
	
	private UserBLService userBLController = UserController.getInstance();

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		
		guestVO = (GuestVO) userBLController.getSingle(userID);
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
			if(password2.getText()==password3.getText()){
			ResultMessage message = userBLController.modify(tempGuestVO);
			}else{
//				TODO 密码不对
			}
			// TODO 得到modify是否成功的结果，界面后续做提示处理
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
