package vo;

import java.time.LocalDateTime;

import po.OrderPO;
import utilities.OrderState;
import utilities.RoomType;

/**
 * 
 * @author 61990
 * lastChangedBy charles
 * updateTime 2016/12/4
 *
 */
public class OrderVO {
	
	//	订单编号(create时无) 客户编号 酒店编号 酒店名 酒店地址 最后预定价格(create时无) 
	//	最晚订单执行时间／预计入住时间 预计离开时间 订单状态
	public OrderGeneralVO orderGeneralVO;
	
	//	原价
	public double previousPrice;
	
	//	订单生成时间(create时无)
	public LocalDateTime createTime;
	
	//	入住时间(create时无)
	public LocalDateTime checkInTime;
	
	//	退房时间（实际离开时间）(create时无)
	public LocalDateTime checkOutTime;

	//	房间类型
	public RoomType roomType;
	
	//	房间数
	public int roomNumCount;
	
	//	房间号
	public String roomNumber;
	
	//	预计入住人数
	public int expectGuestNumCount;
	
	//	入住人姓名
	public String name;
	
	//	联系方式
	public String phone;
	
	//	特别要求
	public String message;
	
	//	评分(create时无)
	public double score;
	
	//	评价(create时无)
	public String comment;
	

	/**
	 * 
	 * @author 61990
	 * lastChangedBy 61990
	 * updateTime 2016/11/27
	 */
	public OrderVO(String orderID, String guestID, String hotelID, String hotelName, String hotelAddress, 
			double previousPrice, double price, LocalDateTime createTime, LocalDateTime checkInTime,
			LocalDateTime checkOutTime, LocalDateTime expectExecuteTime, LocalDateTime expectLeaveTime, 
			OrderState state, RoomType roomType, int roomNumCount, String roomNumber, 
			int expectGuestNumCount, String name, String phone, String message, double score, String comment) {
		super();
		this.orderGeneralVO = new OrderGeneralVO(orderID, guestID, hotelID, hotelName, hotelAddress,
				price, expectExecuteTime, expectLeaveTime, state);
		
		this.previousPrice = previousPrice;
		this.createTime = createTime;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.roomType = roomType;
		this.roomNumCount = roomNumCount;
		this.roomNumber = roomNumber;
		this.expectGuestNumCount = expectGuestNumCount;
		this.name = name;
		this.phone = phone;
		this.message = message;
		this.score = score;
		this.comment = comment;
	}

	/**
	 * 
	 * @author 61990
	 * lastChangedBy 61990
	 * updateTime 2016/11/27
	 */
	public OrderVO(OrderGeneralVO orderGeneralVO, double previousPrice, LocalDateTime createTime, LocalDateTime checkInTime, 
			LocalDateTime checkOutTime, RoomType roomType, int roomNumCount, String roomNumber, String name, 
			String phone, String message, double score, String comment) {
		super();
		this.orderGeneralVO = orderGeneralVO;
		
		this.previousPrice = previousPrice;
		this.createTime = createTime;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.roomType = roomType;
		this.roomNumCount = roomNumCount;
		this.roomNumber = roomNumber;
		this.name = name;
		this.phone = phone;
		this.message = message;
		this.score = score;
		this.comment = comment;
	}
	
	/**
	 * 
	 * @author 61990
	 * lastChangedBy charles
	 * updateTime 2016/12/4
	 * 
	 * 因为订单的入住时间、退房时间、房间号还未生成，不能从界面层直接得到，客户还未进行评论
	 * 所以order create的时候，提供一个专门的构造器
	 */
	public OrderVO (OrderGeneralVO orderGeneralVO, double previousPrice, RoomType roomType,
			int roomNumCount, int expectGuestNumCount, String name, String phone, String message) {
		this.createTime = LocalDateTime.now();
		this.checkInTime = null;
		this.checkOutTime = null;
		this.roomNumber = null;
		this.score = -1;
		this.comment = null;
		
		this.orderGeneralVO = orderGeneralVO;
		this.previousPrice = previousPrice;
		this.roomType = roomType;
		this.roomNumCount = roomNumCount;
		this.name = name;
		this.phone = phone;
		this.message = message;
	}
	
	/**
	 * 
	 * @author 61990
	 * lastChangedBy 61990
	 * updateTime 2016/11/27
	 */
	public OrderVO(OrderPO orderPO) {
		this.orderGeneralVO = new OrderGeneralVO(orderPO.getOrderGeneralPO());
		
		this.previousPrice = orderPO.getPreviousPrice();
		this.createTime = orderPO.getCreateTime();
		this.checkInTime = orderPO.getCheckInTime();
		this.checkOutTime = orderPO.getCheckOutTime();
		this.roomType = orderPO.getRoomType();
		this.roomNumCount = orderPO.getRoomNumCount();
		this.roomNumber = orderPO.getRoomNumber();
		this.name = orderPO.getName();
		this.phone = orderPO.getPhone();
		this.message = orderPO.getMessage();
		this.score = orderPO.getScore();
		this.comment = orderPO.getComment();
	}
}
