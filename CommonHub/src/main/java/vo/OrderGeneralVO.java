package vo;

import java.time.LocalDateTime;

import po.OrderGeneralPO;
import utilities.OrderState;

public class OrderGeneralVO {
	
	// 订单编号
	public String orderID;
	
	//	客户编号
	public String guestID;

	//	酒店编号
	public String hotelID;
		
	//	酒店名
	public String hotelName;

	//	酒店地址
	public String hotelAddress;

	//	最后预定价格
	public double price;

	//	最晚订单执行时间
	public LocalDateTime expectExecuteTime;

	//	预计离开时间
	public LocalDateTime expectLeaveTime;

	//	订单状态
	public OrderState state;

	public OrderGeneralVO(String orderID, String guestID, String hotelID, String hotelName, String hotelAddress,
			double price, LocalDateTime expectExecuteTime, LocalDateTime expectLeaveTime, OrderState state) {
		this.orderID = orderID;
		this.guestID = guestID;
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.price = price;
		this.expectExecuteTime = expectExecuteTime;
		this.expectLeaveTime = expectLeaveTime;
		this.state = state;
	}
	
	public OrderGeneralVO(OrderGeneralPO orderGeneralPO) {
		this.orderID = orderGeneralPO.getOrderID();
		this.guestID = orderGeneralPO.getGuestID();
		this.hotelID = orderGeneralPO.getHotelID();
		this.hotelName = orderGeneralPO.getHotelName();
		this.hotelAddress = orderGeneralPO.getHotelAddress();
		this.price = orderGeneralPO.getPrice();
		this.expectExecuteTime = orderGeneralPO.getExpectExecuteTime();
		this.expectLeaveTime = orderGeneralPO.getExpectLeaveTime();
		this.state = orderGeneralPO.getState();
	}
}
