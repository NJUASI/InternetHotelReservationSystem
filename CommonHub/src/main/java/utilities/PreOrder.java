package utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import vo.OrderVO;

public class PreOrder {
	
	// 客户编号
	public String guestID;
	
	// 酒店编号
	public String hotelID;
	
	// 入住时间
	public LocalDateTime checkInTime;
	
	// 入住日期
	public LocalDate checkInDate;

	// 房间数
	public int roomNum;

	//入住天数
	public int lastDays;
	
	public PreOrder(OrderVO orderVO){
		this.guestID = orderVO.orderGeneralVO.guestID;
		this.hotelID=orderVO.orderGeneralVO.hotelID;
		this.checkInTime =orderVO.checkInTime;
		this.roomNum=orderVO.roomNumCount;
		
	}

}
