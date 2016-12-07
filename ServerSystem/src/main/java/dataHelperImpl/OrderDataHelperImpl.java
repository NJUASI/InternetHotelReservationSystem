package dataHelperImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dataHelper.OrderDataHelper;
import po.OrderPO;
import utilities.JDBCUtil;
import utilities.OrderState;
import utilities.ResultMessage;
import utilities.RoomType;

/**
 * 
 * @author Byron Dong lastChangedBy Byron Dong updateTime 2016/11/30
 *
 */
public class OrderDataHelperImpl implements OrderDataHelper {

	private Connection conn;

	private PreparedStatement ps;

	private ResultSet rs;
	
	private String sql;
	
	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/30 构造函数，初始化成员变量conn
	 */
	public OrderDataHelperImpl() {
		this.conn = JDBCUtil.getConnection();
	}
	
	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/30
	 * @param orderPO orderInfo载体
	 * @return ResultMessage 是否成功添加到数据库中
	 */
	public ResultMessage add(final OrderPO orderPO) {
		sql = "INSERT INTO `order`(`order`.orderID,`order`.guestID,`order`.hotelID,`order`.hotelName,"
            + "`order`.hotelAddress,`order`.price,`order`.expectExecuteTime,`order`.expectLeaveTime,"
            + "`order`.state,`order`.hasCommented,`order`.`name`,`order`.phone,`order`.previousPrice,"
            + "`order`.createTime,`order`.checkInTime,`order`.checkOutTime,`order`.roomType,"
            + "`order`.roomNumCount,`order`.roomNumber,`order`.expectGuestNumCount,`order`.message,"
            + "`order`.`comment`,`order`.score) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, orderPO.getOrderID());
			ps.setObject(2, orderPO.getGuestID());
			ps.setObject(3, orderPO.getHotelID());
			ps.setString(4, orderPO.getHotelName());
			ps.setObject(5, orderPO.getHotelAddress());
			ps.setDouble(6, orderPO.getPrice());
			ps.setObject(7, orderPO.getExpectExecuteTime());
			ps.setObject(8, orderPO.getExpectLeaveTime());
			ps.setString(9, orderPO.getState().toString());
			ps.setString(10, String.valueOf(orderPO.getHasCommented()));
			ps.setString(11, orderPO.getName());
			ps.setString(12, orderPO.getPhone());
			ps.setDouble(13, orderPO.getPreviousPrice());
			ps.setObject(14, orderPO.getCreateTime());
			ps.setObject(15, orderPO.getCheckInTime());
			ps.setObject(16, orderPO.getCheckOutTime());
			ps.setString(17, orderPO.getRoomType().toString());
			ps.setInt(18, orderPO.getRoomNumCount());
			ps.setString(19, orderPO.getRoomNumber());
			ps.setInt(20, orderPO.getExpectGuestNumCount());
			ps.setString(21, orderPO.getMessage());
			ps.setString(22, orderPO.getComment());
			ps.setDouble(23, orderPO.getScore());
			
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}

	/**
	 * @author  Byron Dong
	 * @lastChangedBy  Byron Dong
	 * @updateTime 2016/11/30
	 * @param orderID 订单编号
	 * @param state 需要被修改的状态
	 * @return ResultMessage 是否成功修改订单状态
	 */
	public ResultMessage setState(final String orderID, final OrderState state) {
		sql = "UPDATE `order` SET `order`.state = ? WHERE `order`.orderID = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, state.toString()); //此处硬编码1-2对应sql语句中问号的位置
			ps.setObject(2, orderID);
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/5
	 * @param orderID  
	 * @param state  需要修改的状态
	 * @return ResultMessage 是否成功修改orderInfo
	 */
	public ResultMessage setHasCommentBool(String orderID) {
		sql = "UPDATE `order` SET `order`.hasCommented = ? WHERE `order`.orderID = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(true)); //此处硬编码1-2对应sql语句中问号的位置
			ps.setObject(2, orderID);
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * @author  Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/4
	 * @param orderID 此次订单评价的订单编号
	 * @param score 此次订单评价的评分
	 * @param comment 此次订单评价的评论
	 * @return ResultMessage 是否成功修改orderInfo
	 */
	public ResultMessage setEvaluation(final String orderID, final double score, final String comment) {
		sql = "UPDATE `order` SET `order`.`comment` = ?,score = ? WHERE `order`.orderID = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, comment);
			ps.setDouble(2, score);
			ps.setObject(3, orderID);
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param orderID 此次入住的订单编号
	 * @param roomNumber 房间号
	 * @param checkInTime 入住时间
	 * @return ResultMessage 是否成功修改orderInfo
	 */
	public ResultMessage setCheckIn(final String orderID, final String roomNumber, 
			final LocalDateTime checkInTime, LocalDateTime expectLeaveTime) {
		
		sql = "update order set roomNumber = ?,checkInTime = ?,expectLeaveTime = ? where orderID = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, roomNumber);
			ps.setObject(2, checkInTime);
			ps.setObject(3, expectLeaveTime);
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param orderID 此次退房的订单编号
	 * @param checkOutTime 退房时间
	 * @return ResultMessage 是否成功修改orderInfo
	 */
	public ResultMessage setCheckOut(final String orderID, final LocalDateTime checkOutTime) {
		
		sql = "update order set checkOutTime = ? where orderID = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, checkOutTime);
			ps.setObject(2, orderID);
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/30
	 * @param orderID 订单编号
	 * @return OrderPO orderInfo载体
	 */
	public OrderPO getSingleOrder(final String orderID) {
		sql = "SELECT * FROM `order` WHERE `order`.orderID = ?";
		OrderPO orderPO = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, orderID);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				orderPO = this.convert();
			}
			
			rs = null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return orderPO;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/30
	 * @param guestID 客户ID
	 * @return List<OrderPO> 指定客户的所有orderInfo载体
	 */
	public List<OrderPO> getAllOrderOfGuest(final String guestID) {
		sql = "SELECT * FROM `order` WHERE `order`.guestID = ?";
		final List<OrderPO> result = new ArrayList<OrderPO>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(guestID));
			rs = ps.executeQuery();
			
			while (rs.next()) {
				final OrderPO orderPO = this.convert();
				result.add(orderPO);
			}
			rs = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/30
	 * @param hotelID 酒店ID
	 * @return List<OrderPO> 指定酒店的所有orderInfo载体
	 */
	public List<OrderPO> getAllOrderOfHotel(final String hotelID) {
		sql = "SELECT * FROM `order` WHERE `order`.hotelID = ?";
		final List<OrderPO> result = new ArrayList<OrderPO>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(hotelID));
			rs = ps.executeQuery();
			
			while (rs.next()) {
				final OrderPO orderPO = this.convert();
				result.add(orderPO);
			}
			rs = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/30
	 * @param date 需要查询的日期
	 * @return List<OrderPO> 指定日期的所有异常orderInfo载体
	 */
	public List<OrderPO> getAbnormal() {
		sql = "SELECT * FROM `order` WHERE `order`.state = 'ABNORMAL'";
		final List<OrderPO> result = new ArrayList<OrderPO>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				final OrderPO orderPO = this.convert();
				result.add(orderPO);
			}
			rs = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/30
	 * @return List<OrderPO> 指定日期的所有未执行orderInfo载体
	 */
	public List<OrderPO> getUnexecuted() {
		sql = "SELECT * FROM `order` WHERE `order`.state = 'UNEXECUTED'";
		final List<OrderPO> result = new ArrayList<OrderPO>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				final OrderPO orderPO = this.convert();
				result.add(orderPO);
			}
			rs = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/30
	 * @param
	 * @return
	 */
	public void close() {
		JDBCUtil.close(rs, ps, conn);
		this.sql = null;
	}
	
	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/11/30
	 * @return OrderPO orderInfo载体
	 */
	private OrderPO convert() {  //当ResultSet被赋值后使用
		final OrderPO orderPO = new OrderPO();
		try {
			orderPO.setOrderID(String.valueOf(rs.getObject(1)));
			orderPO.setGuestID(String.valueOf(rs.getObject(2)));
			orderPO.setHotelID(String.valueOf(rs.getObject(3)));
			orderPO.setHotelName(rs.getString(4));
			orderPO.setHotelAddress(String.valueOf(rs.getObject(5)));
			orderPO.setPrice(rs.getDouble(6));
			orderPO.setExpectExecuteTime(rs.getTimestamp(7).toLocalDateTime());
			orderPO.setExpectLeaveTime(rs.getTimestamp(8).toLocalDateTime());
			orderPO.setState(OrderState.valueOf(rs.getString(9)));
			orderPO.setHasCommented(convertBooleanString2Boolean(rs.getString(10)));
			orderPO.setName(rs.getString(11));
			orderPO.setPhone(rs.getString(12));
			orderPO.setPreviousPrice(rs.getDouble(13));
			orderPO.setCreateTime(rs.getTimestamp(14).toLocalDateTime());
			orderPO.setCheckInTime(rs.getTimestamp(15).toLocalDateTime());
			orderPO.setCheckOutTime(rs.getTimestamp(16).toLocalDateTime());
			orderPO.setRoomType(RoomType.valueOf(rs.getString(17)));
			orderPO.setRoomNumCount(rs.getInt(18));
			orderPO.setRoomNumber(rs.getString(19));
			orderPO.setExpectGuestNumCount(rs.getInt(20));
			orderPO.setMessage(rs.getString(21));
			orderPO.setComment(rs.getString(22));
			orderPO.setScore(rs.getDouble(23));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderPO;
	}
	
	private boolean convertBooleanString2Boolean(String a) {
		if (a.equals("true")) {
			return true;
		}else {
			return false;
		}
	}
}
