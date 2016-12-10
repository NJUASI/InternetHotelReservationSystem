package businessLogicService.memberBLService;

<<<<<<< HEAD
import utilities.enums.MemberType;
import utilities.enums.ResultMessage;
=======
import exception.verificationException.UserInexistException;
import utilities.MemberType;
import utilities.ResultMessage;
>>>>>>> master
import vo.MemberVO;

public interface MemberBLService {

	public ResultMessage add(MemberVO memberVO);
	
	public ResultMessage modify(MemberVO memberVO);
	
	public MemberVO getMemberInfo(String userID) throws UserInexistException;
	
	public boolean isMember(String userID, MemberType memberType) throws UserInexistException;
	
	public MemberType getMemberType(String userID) throws UserInexistException;

}
