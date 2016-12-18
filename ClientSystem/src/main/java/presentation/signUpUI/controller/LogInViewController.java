package presentation.signUpUI.controller;

import java.net.URL;
import java.time.LocalDate;



import businessLogic.logInBL.LogInController;
import businessLogicService.logInBLService.LogInBLService;
import exception.inputException.InvalidInputException;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.PasswordInputException;
import exception.inputException.SpecialCharacterException;
import exception.verificationException.UserInexistException;
import exception.verificationException.WrongPasswordException;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.PopUp.PopUp;
import rmi.ClientRemoteHelper;
import utilities.IDReserve;
import utilities.enums.UserType;
import vo.GuestVO;
	

public class LogInViewController {
	public static String userID;
	//登录和注册界面
	@FXML
	private Pane logInPane,registerPane,rmiPane;

	//登录信息
	@FXML
	private TextField ID;
	@FXML
	private PasswordField password;
	//RMI信息
	@FXML
	private TextField rmiIpText, rmiPortText;
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
	private ImageView background,loginBt,rmiBt,registerBT,logInBT,registerBT2,rmiBT2;
	
	@FXML
	private void initialize() {
		this.logInBLController = LogInController.getInstance();
		factory = new RootFactory();
	
		background.setImage(new Image("/presentation/signUpUI/picture/mainLogIn.png"));	
		loginBt.setImage(new Image("/presentation/signUpUI/picture/logIn.png"));
		registerBT.setImage(new Image("/presentation/signUpUI/picture/changeToSignUp.png"));	
		logInBT.setImage(new Image("/presentation/signUpUI/picture/changeToLogIn.png"));	
		rmiBt.setImage(new Image("/presentation/signUpUI/picture/changeToRMI.png"));	
		registerBT2.setImage(new Image("/presentation/signUpUI/picture/signUp.png"));
		rmiBT2.setImage(new Image("/presentation/signUpUI/picture/connect.png"));
	}
	
	@FXML
	protected void enterLoginBt(){
		loginBt.setImage(new Image("/presentation/signUpUI/picture/logInEnter.png"));	
	}
	@FXML
	protected void exitedLoginBt(){
		loginBt.setImage(new Image("/presentation/signUpUI/picture/logIn.png"));	
	}
	@FXML
	protected void enterLoginBt2(){
		logInBT.setImage(new Image("/presentation/signUpUI/picture/changeToLogInEnter.png"));	
	}
	@FXML
	protected void exitedLoginBt2(){
		logInBT.setImage(new Image("/presentation/signUpUI/picture/changeToLogIn.png"));	
	}
	@FXML
	protected void enterRMIBt(){
		rmiBt.setImage(new Image("/presentation/signUpUI/picture/changeToRMI.png"));	
	}
	@FXML
	protected void exitedRMIBt(){
		rmiBt.setImage(new Image("/presentation/signUpUI/picture/changeToRMI.png"));	
	}
	@FXML
	protected void  enterRegisterBt(){
		registerBT.setImage(new Image("/presentation/signUpUI/picture/changeToSignUpEnter.png"));	
	}
	@FXML
	protected void  exitedRegisterBt(){
		registerBT.setImage(new Image("/presentation/signUpUI/picture/changeToSignUp.png"));	
	}
	@FXML
	protected void enter1(){
		registerBT2.setImage(new Image("/presentation/signUpUI/picture/signUpEnter.png"));
	}
	@FXML
	protected void excited1(){
		registerBT2.setImage(new Image("/presentation/signUpUI/picture/signUp.png"));
	}
	@FXML
	protected void enter2(){
		rmiBT2.setImage(new Image("/presentation/signUpUI/picture/connect.png"));
	}
	@FXML
	protected void excited2(){
		rmiBT2.setImage(new Image("/presentation/signUpUI/picture/connectEnter.png"));
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @切换登录界面
	 */
	@FXML
	protected void openLogIn() {
		background.setImage(new Image("/presentation/signUpUI/picture/mainLogIn.png"));	
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
		background.setImage(new Image("/presentation/signUpUI/picture/mainSignUp.png"));	
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
		background.setImage(new Image("/presentation/signUpUI/picture/mainRMI.png"));	
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
					
					if(root==null){
						new PopUp("账号长度无效", "登录失败");
					}
					else{
						Stage stage=StageController.getInstance().getStage();
						Scene scene = new Scene(root);
						stage.setScene(scene);
					}
				} catch(UserInexistException e){
					e.printStackTrace();
					new PopUp("该用户不存在", "登录失败");
				}catch (SpecialCharacterException e) {
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
					,phone.getText(),1000);
			try {
				guestVO = logInBLController.guestSignUp(userVO);
				openLogIn();
				new PopUp("你的账号是"+guestVO.userID, "注册成功");
			}catch (InvalidInputException e) {
				e.printStackTrace();
				new PopUp("无效输入", "注册失败");
			} catch(PasswordInputException e){
				e.printStackTrace();
				new PopUp("密码必须是数字与字母的结合", "注册失败");
			}catch (InvalidLengthInputException e){
				e.printStackTrace();
				new PopUp("输入的长度无效", "注册失败");
			} catch (UserInexistException e) {
				e.printStackTrace();
				new PopUp("请检查输入的编号", "注册失败");
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
		final String ip =  rmiIpText.getText();
		final String port = rmiPortText.getText();
		
		if (ip.equals("") && port.equals("")) {
			System.out.println("Link to localhost");
			ClientRemoteHelper.getInstance().setLocalhost();
		}else if(!ip.equals("") && !port.equals("")) {
			System.out.println("Connect to: " + ip + " : " + port);
			ClientRemoteHelper.getInstance().setIPandPort(ip, port);
			
			new PopUp("连接成功", "rmi连接");
		}else {
			new PopUp("连接失败", "rmi连接");
		}
	}

}
