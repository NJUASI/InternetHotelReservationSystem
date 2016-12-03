package po;

import java.io.Serializable;
import java.time.LocalDateTime;

import utilities.OrderState;
import utilities.RoomType;
import vo.OrderVO;

public class OrderPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6528720659331679661L;

	//	订单编号 客户编号 酒店编号 酒店名 酒店地址 最后预定价格 最晚订单执行时间 预计离开时间 订单状态
	private OrderGeneralPO orderGeneralPO;
	
	//	原价
	private double previousPrice;
	
	//	订单生成时间
	private LocalDateTime createTime;
	
	//	入住时间
	private LocalDateTime checkInTime;
	
	//	退房时间（实际离开时间）
	private LocalDateTime checkOutTime;

	//	房间类型
	private RoomType roomType;
	
	//	房间数
	private int roomNumCount;
	
	//	房间号
	private String roomNumber;
	
	//	预计入住人数
	private int expectGuestNumCount;
	
	//	入住人姓名
	private String name;
	
	//	联系方式
	private String phone;
	
	//	特别要求
	private String message;
	
	//	评论
	private String comment;
	
	// 评分
	private double score;
	
	public OrderPO(){
		this.orderGeneralPO = new OrderGeneralPO();
	}
	
	public OrderPO(OrderVO orderVO) {
		this.orderGeneralPO = new OrderGeneralPO(orderVO.orderGeneralVO);
		
		this.previousPrice = orderVO.previousPrice;
		this.createTime = orderVO.createTime;
		this.checkInTime = orderVO.checkInTime;
		this.checkOutTime = orderVO.checkOutTime;
		this.roomType = orderVO.roomType;
		this.roomNumCount = orderVO.roomNumCount;
		this.roomNumber = orderVO.roomNumber;
		this.name = orderVO.name;
		this.phone = orderVO.phone;
		this.message = orderVO.message;
	}

	public OrderPO(String orderID, String guestID, String hotelID, String hotelName, String hotelAddress, 
			double previousPrice, double price, LocalDateTime createTime, LocalDateTime checkInTime,
			LocalDateTime checkOutTime, LocalDateTime expectExecuteTime, LocalDateTime expectLeaveTime, 
			OrderState state, RoomType roomType, int roomNumCount, String roomNumber, 
			int expectGuestNumCount, String name, String phone, String message,String comment) {
		super();
		this.orderGeneralPO = new OrderGeneralPO(orderID, guestID, hotelID, hotelName, hotelAddress,
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
		this.comment = comment;
	}

	public OrderPO(OrderGeneralPO orderGeneralPO, double previousPrice, LocalDateTime createTime, LocalDateTime checkInTime, 
			LocalDateTime checkOutTime, RoomType roomType, int roomNumCount, String roomNumber, String name, 
			String phone, String message,String comment,double score) {
		super();
		this.orderGeneralPO = orderGeneralPO;
		
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
		this.comment = comment;
		this.score = score;
	}
	
	public String getOrderID() {
		return orderGeneralPO.getOrderID();
	}

	public OrderGeneralPO getOrderGeneralPO() {
		return orderGeneralPO;
	}

	public void setOrderGeneralPO(OrderGeneralPO orderGeneralPO) {
		this.orderGeneralPO = orderGeneralPO;
	}

	public void setOrderID(String orderID) {
		orderGeneralPO.setOrderID(orderID);
	}

	public String getGuestID() {
		return orderGeneralPO.getGuestID();
	}

	public void setGuestID(String guestID) {
		orderGeneralPO.setGuestID(guestID);
	}

	public String getHotelID() {
		return orderGeneralPO.getHotelID();
	}

	public void setHotelID(String hotelID) {
		orderGeneralPO.setHotelID(hotelID);
	}

	public String getHotelName() {
		return orderGeneralPO.getHotelName();
	}

	public void setHotelName(String hotelName) {
		orderGeneralPO.setHotelName(hotelName);
	}

	public String getHotelAddress() {
		return orderGeneralPO.getHotelAddress();
	}

	public void setHotelAddress(String hotelAddress) {
		orderGeneralPO.setHotelAddress(hotelAddress);
	}

	public double getPrice() {
		return orderGeneralPO.getPrice();
	}

	public void setPrice(double price) {
		orderGeneralPO.setPrice(price);
	}

	public double getPreviousPrice() {
		return previousPrice;
	}

	public void setPreviousPrice(double previousPrice) {
		this.previousPrice = previousPrice;
	}
	
	public LocalDateTime getExpectExecuteTime() {
		return orderGeneralPO.getExpectExecuteTime();
	}

	public void setExpectExecuteTime(LocalDateTime expectExecuteTime) {
		orderGeneralPO.setExpectExecuteTime(expectExecuteTime);
	}

	public OrderState getState() {
		return orderGeneralPO.getState();
	}

	public void setState(OrderState state) {
		orderGeneralPO.setState(state);
	}
	
	public LocalDateTime getExpectLeaveTime() {
		return orderGeneralPO.getExpectLeaveTime();
	}

	public void setExpectLeaveTime(LocalDateTime expectLeaveTime) {
		orderGeneralPO.setExpectLeaveTime(expectLeaveTime);
	}
	
	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public int getRoomNumCount() {
		return roomNumCount;
	}

	public void setRoomNumCount(int roomNumCount) {
		this.roomNumCount = roomNumCount;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getExpectGuestNumCount() {
		return expectGuestNumCount;
	}

	public void setExpectGuestNumCount(int expectGuestNumCount) {
		this.expectGuestNumCount = expectGuestNumCount;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
