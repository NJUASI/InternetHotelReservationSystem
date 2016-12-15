package businessLogicService.memberBLService;

import exception.verificationException.UserInexistException;
import utilities.enums.MemberType;
import utilities.enums.ResultMessage;
import vo.MemberVO;

public interface MemberBLService {

	public ResultMessage add(MemberVO memberVO) throws UserInexistException;
	
	public ResultMessage modify(MemberVO memberVO) throws UserInexistException;
	
	public MemberVO getMemberInfo(String userID) throws UserInexistException;
	
	public boolean isMember(String userID, MemberType memberType) throws UserInexistException;
	
	public MemberType getMemberType(String userID) throws UserInexistException;

}
