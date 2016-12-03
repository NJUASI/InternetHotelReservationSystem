package businessLogic.userBL.userService.service;

import java.util.List;

import utilities.ResultMessage;
import vo.UserVO;

public interface UserService {
	
	public ResultMessage add(UserVO newUserVO);

	public ResultMessage modify(UserVO userVO);
	
	public UserVO getSingle(String userID);
	
	public List<UserVO> getAll();
	
	public String getLogInInfo(String userID);

}
