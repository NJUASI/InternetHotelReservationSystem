package utilities;

import java.time.LocalDate;

import vo.OrderVO;

public class PreOrder {
	
	// 客户编号
	public String guestID;
	
	// 酒店编号
	public String hotelID;
	
	// 预计入住时间
//	public LocalDateTime expectExecuteTime;
	
	// 预计入住日期
	public LocalDate expectExecuteDate;

	// 房间数
	public int roomNum;

	//入住天数
	public int lastDays;
	
	public PreOrder(OrderVO orderVO){
		this.guestID = orderVO.orderGeneralVO.guestID;
		this.hotelID = orderVO.orderGeneralVO.hotelID;
//		this.expectExecuteTime = orderVO.orderGeneralVO.expectExecuteTime;
		this.expectExecuteDate = orderVO.orderGeneralVO.expectExecuteTime.toLocalDate();
		this.roomNum=orderVO.roomNumCount;
		this.lastDays = orderVO.orderGeneralVO.expectLeaveTime.toLocalDate().getDayOfYear()
				- orderVO.orderGeneralVO.expectExecuteTime.toLocalDate().getDayOfYear();
		
	}

	public PreOrder(String guestID, String hotelID, LocalDate expectExecuteDate, int roomNum, int lastDays) {
		super();
		this.guestID = guestID;
		this.hotelID = hotelID;
		this.expectExecuteDate = expectExecuteDate;
		this.roomNum = roomNum;
		this.lastDays = lastDays;
	}
	
	

}
