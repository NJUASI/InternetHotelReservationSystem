package businessLogic.userBL.userService.service;

import java.util.List;

import exception.verificationException.UserInexistException;
import utilities.enums.ResultMessage;
import vo.UserVO;

public interface UserService {
	
	public UserVO add(UserVO newUserVO);

	public ResultMessage modify(UserVO userVO);
	
	public UserVO getSingle(String userID) throws UserInexistException;
	
	public List<UserVO> getAll();
	
	public String getLogInInfo(String userID) throws UserInexistException;
	
}
