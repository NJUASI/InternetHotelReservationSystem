package dataHelperImpl;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataHelper.HotelDataHelper;
import po.HotelPO;
import utilities.JDBCUtil;
import utilities.ResultMessage;

public class HotelDataHelperImpl implements HotelDataHelper{

	private Connection conn;

	private PreparedStatement ps;

	private ResultSet rs;

	private String sql;

	public HotelDataHelperImpl() {
		conn = JDBCUtil.getGongConnection();
	}

	@Override
	public List<HotelPO> getHotels(String city, String circle) {

		sql = "select * from hotel where city = ? and circle = ?";

		List<HotelPO> list = new ArrayList<HotelPO>();
		HotelPO generalPO;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, city);
			ps.setString(2, circle);
			rs = ps.executeQuery();

			while(rs.next()){
				generalPO = new HotelPO();

				generalPO.setHotelID(rs.getString(1));
				generalPO.setHotelName(rs.getString(2));
				generalPO.setCity(city);
				generalPO.setCircle(circle);
				generalPO.setLevel(rs.getString(5));
				generalPO.setScore(rs.getDouble(6));

				list.add(generalPO);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * @Description:根据酒店id取得该酒店的基本信息
	 * @param hotelID
	 * @return
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 下午3:35:50
	 */
	@Override
	public HotelPO getHotelInfo(String hotelID){
		sql = "select * from hotel where hotelID = ?";

		HotelPO hotelPO = new HotelPO();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hotelID);
			rs = ps.executeQuery();
			if(rs.next()){

				hotelPO.setHotelID(hotelID);
				hotelPO.setHotelName(rs.getString(2));
				hotelPO.setCity(rs.getString(3));
				hotelPO.setCircle(rs.getString(4));
				hotelPO.setLevel(rs.getString(5));
				hotelPO.setScore(rs.getDouble(6));
				hotelPO.setIntroduction(rs.getString(7));
				hotelPO.setEquipment(rs.getString(8));
			}
		} catch (SQLException e) {
		}
		return hotelPO;
	}


	/**
	 * @Description:更新一条酒店基本信息
	 * @param hotelPO
	 * @return
	 * @throws RemoteException
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 下午3:43:15
	 */
	@Override
	public ResultMessage updateHotelInfo(HotelPO hotelPO){
		sql = "update hotel set hotelName = ?,city = ?,circle = ?, level = ?,score = ?, introduction = ?,equipment = ?"
				+ "where hotelID = ?";
				

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, hotelPO.getHotelName());
			ps.setString(2, hotelPO.getCity());
			ps.setString(3, hotelPO.getCircle());
			ps.setString(4, hotelPO.getLevel());
			ps.setDouble(5, hotelPO.getScore());
			ps.setString(6, hotelPO.getIntroduction());
			ps.setString(7, hotelPO.getEquipment());
			ps.setString(8, hotelPO.getHotelID());
			
			ps.execute();
			return ResultMessage.SUCCESS;
		}
		catch (SQLException e) {
			return ResultMessage.FAIL;
		}
	} 

	/**
	 * @Description:添加一条酒店基本信息
	 * @param hotelPO
	 * @return
	 * @throws RemoteException
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月4日 下午3:49:44
	 */
	@Override
	public ResultMessage addHotelInfo(HotelPO hotelPO){
		sql = "insert into hotel(hotelID,hotelName,city,circle,level,score,introduction,equipment)"
				+"values(?,?,?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, hotelPO.getHotelID());
			ps.setString(2, hotelPO.getHotelName());
			ps.setString(3, hotelPO.getCity());
			ps.setString(4, hotelPO.getCircle());
			ps.setString(5, hotelPO.getLevel());
			ps.setDouble(6, hotelPO.getScore());
			ps.setString(7, hotelPO.getIntroduction());
			ps.setString(8, hotelPO.getEquipment());
			
			ps.execute();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			return ResultMessage.FAIL;
		}
	}

}
