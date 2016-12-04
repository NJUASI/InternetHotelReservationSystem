package vo;

import java.time.LocalDateTime;

import po.OrderGeneralPO;
import utilities.OrderState;

/**
 * 
 * @author 61990
 * lastChangedBy charles
 * updateTime 2016/12/4
 */
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

	/**
	 * 
	 * @author 61990
	 * lastChangedBy 61990
	 * updateTime 2016/11/27
	 */
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
	
	/**
	 * 
	 * @author 61990
	 * lastChangedBy charles
	 * updateTime 2016/12/4
	 * 
	 * 因为订单编号、价格、状态不能从界面层直接得到
	 * 所以order create的时候，提供一个专门的构造器
	 */
	public OrderGeneralVO(String guestID, String hotelID, String hotelName, String hotelAddress,
			LocalDateTime expectExecuteTime, LocalDateTime expectLeaveTime) {
		this.orderID = null;
		this.price = -1;
		this.state = OrderState.UNEXECUTED;
		
		this.guestID = guestID;
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.expectExecuteTime = expectExecuteTime;
		this.expectLeaveTime = expectLeaveTime;
	}
	
	/**
	 * 
	 * @author 61990
	 * lastChangedBy 61990
	 * updateTime 2016/11/27
	 */
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
