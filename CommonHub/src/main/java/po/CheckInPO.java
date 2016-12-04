package po;

import java.io.Serializable;
import java.time.LocalDateTime;

import vo.CheckInVO;

public class CheckInPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8580848803895356693L;

	//	订单编号
	private String orderID;
	
	//	房间号
	private String roomNumber;
	
	//	入住时间
	private LocalDateTime checkInTime;	
	
	//	预计离开时间
	private LocalDateTime expectLeaveTime;
	
	public CheckInPO(String orderID, String roomNumber, LocalDateTime checkInTime, LocalDateTime expectLeaveTime) {
		this.orderID = orderID;
		this.roomNumber = roomNumber;
		this.checkInTime = checkInTime;
		this.expectLeaveTime = expectLeaveTime;
	}
	
	public CheckInPO(CheckInVO checkInVO) {
		this.checkInTime = checkInVO.checkInTime;
		this.expectLeaveTime = checkInVO.expectLeaveTime;
		this.orderID = checkInVO.orderID;
		this.roomNumber = checkInVO.roomNumber;
	}

	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}
	public LocalDateTime getExpectLeaveTime() {
		return expectLeaveTime;
	}
	public void setExpectLeaveTime(LocalDateTime expectLeaveTime) {
		this.expectLeaveTime = expectLeaveTime;
	}
	
	
}
