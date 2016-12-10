package businessLogic.userBL.userService.service;

import java.util.List;

import utilities.enums.ResultMessage;
import vo.UserVO;

public interface UserService {
	
	public UserVO add(UserVO newUserVO);

	public ResultMessage modify(UserVO userVO);
	
	public UserVO getSingle(String userID);
	
	public List<UserVO> getAll();
	
	public String getLogInInfo(String userID);
	
}
