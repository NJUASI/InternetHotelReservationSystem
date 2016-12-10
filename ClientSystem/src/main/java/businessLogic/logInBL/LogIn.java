package businessLogic.logInBL;

import businessLogic.userBL.User;
import businessLogicService.logInBLService.LogInBLService;
import exception.inputException.InvalidInputException;
import exception.inputException.InvalidLengthInputException;
import exception.inputException.PasswordInputException;
import exception.inputException.SpecialCharacterException;
import exception.verificationException.WrongPasswordException;
import utilities.Detector;
import utilities.enums.UserType;
import vo.GuestVO;
import vo.UserVO;

/**
 * 
 * @author 61990
 * @lastChangedBy Byron Dong
 *
 */
public class LogIn implements LogInBLService{

	private User user;
	private LogInFactory factory;

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * 构造函数，初始化成员变量
	 */
	public LogIn() {
		user = new User();
		factory = new LogInFactory();
	}

	/**
	 * @Description:根据用户id获取用户的密码，并验证登录
	 * @param userID
	 * @param password
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @throws SpecialCharacterException 
	 * @throws InvalidLengthInputException 
	 * @lastChangedBy: Byron Dong
	 * @time:2016年12月7日 
	 */
	public UserType logIn(String userID,String password) throws WrongPasswordException, SpecialCharacterException, InvalidLengthInputException{
		
		UserType userType = null;
		try {
			userType = this.factory.getUserType(userID);
		} catch (SpecialCharacterException e) {
			e.printStackTrace();
			throw new SpecialCharacterException();
		} catch (InvalidLengthInputException e) {
			e.printStackTrace();
			throw new InvalidLengthInputException();
		}
		
		if(!this.hasUserType(userType)){return null;} //
		
		String tempPassword = user.getLogInInfo(userID,userType); 
		
		if(!tempPassword.equals(password)){
			throw new WrongPasswordException();
		} //密码不正确, 登录失败
		
		return userType;
	}

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/10
	 * @param guestVO
	 *           从注册界面层传下来的guestVO
	 * @return 客户是否成功注册
	 * @throws InvalidInputException,PasswordInputException 
	 */
	public GuestVO guestSignUp(UserVO guestVO) throws InvalidInputException,PasswordInputException,InvalidLengthInputException{
		
		try {
			this.infoDetector(guestVO);
			return (GuestVO)user.add(guestVO ,UserType.GUEST);
		} catch (InvalidInputException e) {
			e.printStackTrace();
			throw new InvalidInputException();
		} catch (PasswordInputException e) {
			e.printStackTrace();
			throw new PasswordInputException();
		} catch (InvalidLengthInputException e) {
			e.printStackTrace();
			throw new InvalidLengthInputException();
		} //检查内容是否符合规范，不符合返回null
	}
	
	private boolean hasUserType(UserType userType){
		if(userType==null){
			return false;
		}
		else{
			return true;
		}
	}
	
	private boolean infoDetector(UserVO userVO) throws InvalidInputException, PasswordInputException, InvalidLengthInputException{
		GuestVO guestVO = (GuestVO)userVO;
		Detector detector = new Detector();
		boolean name = detector.infoDetector(guestVO.name);
		if(!name){throw new InvalidInputException();}
		
		boolean password = detector.passwordDetector(guestVO.password);
		if(!password){throw new PasswordInputException();}
		
		boolean phone = detector.phoneDetector(guestVO.phone);
		if(!phone){throw new InvalidLengthInputException();}
		
		return true;
	}
}
