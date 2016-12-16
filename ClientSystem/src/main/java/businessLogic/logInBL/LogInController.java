package businessLogic.logInBL;

import businessLogicService.logInBLService.LogInBLService;
import exception.inputException.InvalidInputException;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.PasswordInputException;
import exception.inputException.SpecialCharacterException;
import exception.verificationException.ParameterInvalidException;
import exception.verificationException.UserInexistException;
import exception.verificationException.WrongPasswordException;
import utilities.enums.UserType;
import vo.GuestVO;
import vo.UserVO;

/**
 * 
 * @author 61990
 * lastChangedBy charles
 *
 */
public final class LogInController implements LogInBLService {

	private LogIn logIn;
	
	private static LogInController logInController = new LogInController();


	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	private LogInController() {
		logIn = new LogIn();
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @return login controller的实例，单例化
	 */
	public static LogInController getInstance() {
		return logInController;
	}
	
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guestVO
	 *           从注册界面层传下来的guestVO
	 * @return 客户是否成功注册
	 * @throws InvalidLengthInputException 
	 * @throws PasswordInputException 
	 * @throws InvalidInputException 
	 * @throws ParameterInvalidException 
	 */
	public GuestVO guestSignUp(UserVO guestVO) throws InvalidInputException, PasswordInputException, InvalidLengthInputException {
		return logIn.guestSignUp(guestVO);
	}

	/**
	 * @author Harvey Gong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * @param userID
	 *           从登录界面层传下来的userID
	 * @param password
	 *           从登录界面层传下来的password
	 * @return 用户是否成功登录
	 * @throws InvalidLengthInputException 
	 * @throws SpecialCharacterException
	 * @throws UserInexistException
	 */
	@Override
	public UserType logIn(String userID, String password) throws WrongPasswordException, SpecialCharacterException, InvalidLengthInputException, UserInexistException{
		return logIn.logIn(userID, password);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/11
	 * @param userID 当前客户端登录的用户编号 
	 * 
	 * TODO 根据后期确定检查重复登录
	 */
	@Override
	public void logOut(String userID) {
		logIn.logOut(userID);		
	}
}
