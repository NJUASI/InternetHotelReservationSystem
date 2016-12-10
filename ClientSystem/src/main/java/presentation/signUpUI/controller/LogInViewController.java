package presentation.signUpUI.controller;

import java.time.LocalDate;

import com.sun.javafx.robot.impl.FXRobotHelper;

import businessLogic.logInBL.LogInController;
import businessLogicService.logInBLService.LogInBLService;
import exception.inputException.InvalidInputException;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.PasswordInputException;
import exception.inputException.SpecialCharacterException;
import exception.verificationException.WrongPasswordException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.PopUp.PopUp;
import utilities.IDReserve;
import utilities.UserType;
import vo.GuestVO;
	
@SuppressWarnings("restriction")
public class LogInViewController {
	public static String userID;
	//登录和注册界面
	@FXML
	private Pane logInPane,registerPane,rmiPane;
	@FXML
	private Button registerBT,logInBT;
	//登录信息
	@FXML
	private TextField ID;
	@FXML
	private PasswordField password;
	//登录信息
	@FXML
	private TextField rmiText;
	//注册信息
	@FXML
	private PasswordField password2,password3;
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
		rmiPane.setVisible(false);
		logInBT.setVisible(false);
		registerBT.setVisible(true);
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
		rmiPane.setVisible(false);
		logInBT.setVisible(true);
		registerBT.setVisible(false);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @切换RMI界面
	 */
	@FXML
	public void openRMI() {
		rmiPane.setVisible(true);
		registerPane.setVisible(false);
		logInPane.setVisible(false);
		logInBT.setVisible(true);
		registerBT.setVisible(false);
	}
	

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * @登录
	 */
	@FXML
	protected void logIn() {
		
			UserType userType = null;;
				try {
					userType = logInBLController.logIn(ID.getText(), password.getText());
					
					IDReserve.getInstance().setUserID(ID.getText());
					Parent root = factory.createRoot(userType);
					ObservableList<Stage> stage = FXRobotHelper.getStages();

					Scene scene = new Scene(root);
					stage.get(0).setScene(scene);
				} catch (SpecialCharacterException e) {
					e.printStackTrace();
					new PopUp("账号中含有不合法符号", "登录失败");
				} catch (WrongPasswordException e) {
					e.printStackTrace();
					new PopUp("请检查你的账号或密码", "登录失败");
				} catch (InvalidLengthInputException e) {
					e.printStackTrace();
					new PopUp("账号长度无效", "登录失败");
				}
				
	}

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/9
	 * @客户注册
	 */
	@FXML
	protected void register() {
		
		GuestVO guestVO = null;
		if(password2.getText().equals(password3.getText())){
			GuestVO userVO = new GuestVO("",LocalDate.of(1,1,1),"",name.getText(), nickName.getText(),password2.getText()
					,phone.getText(),0);
			try {
				guestVO = logInBLController.guestSignUp(userVO);
			
				new PopUp("你的账号是"+guestVO.userID, "注册成功");
			} catch (InvalidInputException e) {
				e.printStackTrace();
				new PopUp("无效输入", "注册失败");
			} catch(PasswordInputException e){
				e.printStackTrace();
				new PopUp("密码必须是数字与字母的结合", "注册失败");
			}catch (InvalidLengthInputException e){
				e.printStackTrace();
				new PopUp("输入的长度无效", "注册失败");
			}
		}
		else{
			new PopUp("密码输入不一致", "注册失败");
		}
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @连接RMI
	 */
	@FXML
	protected void link() {
		System.out.println(rmiText.getText());
		new PopUp("连接成功", "rmi连接");
	}

}
