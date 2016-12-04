package vo;

import java.time.LocalDateTime;

/**
 * 
 * @author 61990
 * lastChangedBy charles
 * updateTime 2016/12/4
 *
 */
public class CheckInVO {

	//	订单编号
	public String orderID;
	
	//	房间号
	public String roomNumber;
	
	//	入住时间
	public LocalDateTime checkInTime;	
	
	/**
	 * 
	 * @author 61990
	 * lastChangedBy charles
	 * updateTime 2016/12/4
	 */
	public CheckInVO(String orderID, String roomNumber, LocalDateTime checkInTime) {
		this.orderID = orderID;
		this.roomNumber = roomNumber;
		this.checkInTime = checkInTime;
	}
}
