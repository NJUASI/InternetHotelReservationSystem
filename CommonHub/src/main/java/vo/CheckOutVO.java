package vo;

import java.time.LocalDateTime;

public class CheckOutVO {

	//	订单编号
	public String orderID;
	
	//	退房时间
	public LocalDateTime checkOutTime;
	

	public CheckOutVO(String orderID, LocalDateTime checkOutTime) {
		this.orderID = orderID;
		this.checkOutTime = checkOutTime;
	}
}
