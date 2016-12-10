package presentation.signUpUI.controller;

import java.time.LocalDate;

import com.sun.javafx.robot.impl.FXRobotHelper;

import businessLogic.logInBL.LogInController;
import businessLogicService.logInBLService.LogInBLService;
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

			UserType userType = logInBLController.logIn(ID.getText(), password.getText());
			
			if(userType==null){
				new PopUp("请检查你的账号或密码", "登录失败");
			// TODO 细化啊你倒是，关于失败原因这里暂时没有，后面细化，此处需要界面处理if之后不跳转界面
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
	 * @updateTime 2016/12/9
	 * @客户注册
	 */
	@FXML
	protected void register() {
		
		GuestVO guestVO = null;
		if(password2.getText().equals(password3.getText())){
		GuestVO userVO = new GuestVO("",LocalDate.of(1,1,1),"",name.getText(), nickName.getText(),password2.getText()
				,phone.getText(),0);
		guestVO = logInBLController.guestSignUp(userVO);
		// TODO 此处返回了界面需要的自动递增的ID，后续操作由界面完成
			
		}
		
		if(guestVO==null){
			new PopUp("密码输入不一致", "登录失败");
//			System.out.println("密码不一致");;
		}else{
			new PopUp("你的账号是"+guestVO.userID, "注册成功");
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
	}

}
