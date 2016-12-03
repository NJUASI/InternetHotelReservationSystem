package businessLogic.creditBL.stub;

import java.time.LocalDate;
import java.util.List;

import businessLogicService.creditBLService.CreditBLService;
import utilities.ResultMessage;
import vo.BasicInfoVO;
import vo.CreditVO;
import vo.GuestVO;
import vo.MarketVO;

public class CreditBLService_Stub implements CreditBLService {

	public ResultMessage charge(int chargeNum) {
		return ResultMessage.SUCCESS;
	}

	public BasicInfoVO getBasicInfo(String ID) {
		return new BasicInfoVO(new GuestVO("1234567890", LocalDate.of(1995, 4, 1), "Samsung","Carol","cal", "123456", 
				"13555550000", 400), "L1");
	}

	
	public List<CreditVO> getAllCreditDetail(String guestID) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ResultMessage charge(String guestID, float chargeNum) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	
	public List<MarketVO> getMemberFormulation() {
		// TODO Auto-generated method stub
		return null;
	}

//	String guestID;
//	int credit;
//	String time;
//	String orderID;
//	int preCredit;
//	String reason;
//
//	public CreditBLService_Stub(String guestID, String time, String orderID, int preCredit,int credit, String reason) {
//		this.guestID = guestID;
//		this.credit = credit;
//		this.time = time;
//		this.orderID = orderID;
//		this.preCredit = preCredit;
//		this.reason = reason;
//	}
}
