package businessLogicService.memberBLService;

import utilities.enums.MemberType;
import utilities.enums.ResultMessage;
import vo.MemberVO;

public interface MemberBLService {

	public ResultMessage add(MemberVO memberVO);
	
	public ResultMessage modify(MemberVO memberVO);
	
	public MemberVO getMemberInfo(String userID);
	
	public boolean isMember(String userID, MemberType memberType);
	
	public MemberType getMemberType(String userID);

}
