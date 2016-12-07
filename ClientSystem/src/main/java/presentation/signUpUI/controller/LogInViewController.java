package presentation.signUpUI.controller;

import java.time.LocalDate;

import com.sun.javafx.robot.impl.FXRobotHelper;

import businessLogic.logInBL.LogInController;
import businessLogicService.logInBLService.LogInBLService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.Main;
import utilities.IDReserve;
import utilities.UserType;
import vo.GuestVO;
import vo.UserVO;
	
public class LogInViewController {
	public static String userID;
	//登录和注册界面
	@FXML
	private Pane logInPane;
	@FXML
	private Pane registerPane;
	//登录信息
	@FXML
	private TextField ID;
	@FXML
	private TextField password;
	//注册信息
	@FXML
	private TextField password2;
	@FXML
	private TextField name;
	@FXML
	private TextField nickName;
	@FXML
	private TextField phone;
	
	private LogInBLService logInBLController;
	
	private RootFactory factory;
	
	
	@FXML
	private void initialize() {
		this.logInBLController = LogInController.getInstance();
		factory = new RootFactory();
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @切换登录界面
	 */
	@FXML
	protected void openLogIn() {
		registerPane.setVisible(false);
		logInPane.setVisible(true);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @切换注册界面
	 */
	@FXML
	public void openRegister() {
		registerPane.setVisible(true);
		logInPane.setVisible(false);
	}


	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * @登录
	 */
	@FXML
	protected void logIn() {
			UserType userType = logInBLController.logIn(ID.getText(), password.getText());
			
			if(userType==null){
			// TODO 需要消息框或状态栏提示登录失败，关于失败原因这里暂时没有，后面细化，此处需要界面处理if之后不跳转界面
			}
			
			IDReserve.getInstance().setUserID(ID.getText());
			Parent root = factory.createRoot(userType);
			// TODO 此处警告可能是依赖问题，需要下去查看
			ObservableList<Stage> stage = FXRobotHelper.getStages();

			Scene scene = new Scene(root);
			stage.get(0).setScene(scene);

	}

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * @客户注册
	 */
	@FXML
	protected void register() {
		GuestVO userVO = new GuestVO("",LocalDate.of(0,0,0),"",name.getText(), nickName.getText(),password2.getText()
				,phone.getText(),0);
		GuestVO guestVO = logInBLController.guestSignUp(userVO);
		// TODO 此处返回了界面需要的自动递增的ID，后续操作由界面完成
	}

}
