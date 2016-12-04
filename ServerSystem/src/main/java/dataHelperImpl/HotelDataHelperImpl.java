package dataHelperImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataHelper.HotelDataHelper;
import po.HotelGeneralPO;
import utilities.JDBCUtil;

public class HotelDataHelperImpl implements HotelDataHelper{

	private Connection conn;

	private PreparedStatement ps;

	private ResultSet rs;
	
	private String sql;
	
	public HotelDataHelperImpl() {
		conn = JDBCUtil.getGongConnection();
	}
	
	
	@Override
	public List<HotelGeneralPO> getHotelGenerals(String city, String circle) {
		
		sql = "select * from hotel where city = ? and cycle = ?";
		
		List<HotelGeneralPO> list = new ArrayList<HotelGeneralPO>();
		HotelGeneralPO generalPO;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, city);
			ps.setString(2, circle);
			rs = ps.executeQuery();
			
			while(rs.next()){
				generalPO = new HotelGeneralPO();
				
				generalPO.setHotelID(rs.getString(1));
				generalPO.setHotelName(rs.getString(2));
				generalPO.setCity(city);
				generalPO.setCycle(circle);
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

	
}
