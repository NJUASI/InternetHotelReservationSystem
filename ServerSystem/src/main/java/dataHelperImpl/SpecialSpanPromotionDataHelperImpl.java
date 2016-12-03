package dataHelperImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import po.SpecialSpanPromotionPO;
import utilities.JDBCUtil;
import utilities.ResultMessage;

public class SpecialSpanPromotionDataHelperImpl implements dataHelper.SpecialSpanPromotionDataHelper {

	private Connection conn;

	private PreparedStatement ps;

	private ResultSet rs;

	private String sql;

	public SpecialSpanPromotionDataHelperImpl() {
		conn = JDBCUtil.getGongConnection();
	}

	@Override
	public List<SpecialSpanPromotionPO> getHotelSpecialSpanPromotion(String hotelID) {
		List<SpecialSpanPromotionPO> specialSpanPromotionPOList = new ArrayList<SpecialSpanPromotionPO>();
		sql = "select * from specialspanpromotion where userID = ?";
		SpecialSpanPromotionPO specialSpanPromotionPO = new SpecialSpanPromotionPO();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hotelID);
			rs = ps.executeQuery();

			if(rs.next()){

				specialSpanPromotionPO.setUserID(rs.getString(1));
				specialSpanPromotionPO.setPromotionName(rs.getString(2));
				specialSpanPromotionPO.setDiscount(rs.getDouble(3));
				specialSpanPromotionPOList.add(specialSpanPromotionPO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return specialSpanPromotionPOList;
	}

	@Override
	public List<SpecialSpanPromotionPO> getWebSpecialSpanPromotion() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage addSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage updateSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deleteSpecialSpanPromotion(SpecialSpanPromotionPO specialSpanPromotionPO) {
		// TODO 自动生成的方法存根
		return null;
	}

}
