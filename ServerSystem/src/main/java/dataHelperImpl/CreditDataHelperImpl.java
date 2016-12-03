package dataHelperImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dataHelper.CreditDataHelper;
import po.CreditPO;
import utilities.JDBCUtil;
import utilities.ResultMessage;

/**
 * 
 * @author 董金玉 lastChangedBy 董金玉 updateTime 2016/11/30
 *
 */
public class CreditDataHelperImpl implements CreditDataHelper {

	private Connection conn;

	private PreparedStatement ps;

	private ResultSet rs;
	
	private String sql;
	

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/30 构造函数，初始化成员变量conn
	 */
	public CreditDataHelperImpl() {
		this.conn = JDBCUtil.getConnection();
	}
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/30
	 * @param guestID 客户ID
	 * @return List<CreditPO> 所有creditInfo载体
	 */
	public List<CreditPO> getAll(final String guestID) {
		sql = "SELECT * FROM credit WHERE credit.guestID = ?";
		final List<CreditPO> result = new ArrayList<CreditPO>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, guestID);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				final CreditPO creditPO = new CreditPO();
				creditPO.setGuestID(guestID);
				creditPO.setTime((LocalDateTime) rs.getObject(2)); //此处硬编码2-6对应表项中元素的位置，已确定
				creditPO.setOrderID(String.valueOf(rs.getInt(3)));
				creditPO.setPreCredit(rs.getDouble(4));
				creditPO.setCredit(rs.getDouble(5));
				creditPO.setReason((String)rs.getObject(6));
				
				result.add(creditPO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/30
	 * @param creditPO creditInfo载体
	 * @return ResultMessage 是否成功添加creditInfo
	 */
	public ResultMessage add(final CreditPO creditPO) {
		sql = "INSERT INTO credit(credit.guestID,credit.orderID,credit.time,"
				+ "credit.previousCredit,credit.afterCredit,credit.reason) "
				+ "VALUES(?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(creditPO.getGuestID())); //此处硬编码1-6对应语句中元素的位置，已确定
			ps.setInt(2, Integer.parseInt(creditPO.getOrderID()));
			ps.setObject(3, creditPO.getTime());
			ps.setDouble(4, creditPO.getPreCredit()); 
			ps.setDouble(5, creditPO.getCredit());
			ps.setObject(6, creditPO.getReason());
			
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
	 * @updateTime 2016/11/30
	 * @param
	 * @return
	 */
	public void close() { //当决定抛弃该对象时调用
		JDBCUtil.close(rs, ps, conn);
		this.sql = null;
	}

	
}
