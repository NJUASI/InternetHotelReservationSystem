package dataHelperImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataHelper.RoomDataHelper;
import po.RoomInfoPO;
import utilities.JDBCUtil;
import utilities.ResultMessage;

/**
 * @Description:更新数据库中的客房信息
 * @author:Harvey Gong
 * @time:2016年12月4日 上午11:31:26
 */
public class RoomDataHelperImpl implements RoomDataHelper {

	private Connection conn;

	private PreparedStatement ps;

	private ResultSet rs;

	private String sql;


	public RoomDataHelperImpl() {
		conn = JDBCUtil.getGongConnection();
	}	

	@Override
	public List<RoomInfoPO> getRoomInfo(String hotelID) {
		sql = "select * from room where hotelID = ?";
		List<RoomInfoPO> list = new ArrayList<RoomInfoPO>();
		RoomInfoPO po;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hotelID);
			rs = ps.executeQuery();
			while(rs.next()){
				po = new RoomInfoPO();
				po.setHotelID(hotelID);
				po.setRoomType(rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage updateRoomInfo(RoomInfoPO roomInfoPO, String oldName) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage addRoomInfo(RoomInfoPO roomInfoPO) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deleteRoomInfo(String hotelID, String roomType) {
		// TODO 自动生成的方法存根
		return null;
	}

}
