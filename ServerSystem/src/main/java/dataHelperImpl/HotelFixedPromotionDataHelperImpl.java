package dataHelperImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataHelper.HotelFixedPromotionDataHelper;
import po.HotelFixedPromotionPO;
import utilities.JDBCUtil;
import utilities.PromotionType;
import utilities.ResultMessage;

/**
 * @Description:对数据库中hotelFixedPromotion表的具体操作
 * @author:Harvey Gong
 * @time:2016年12月3日 下午12:41:27
 */
public class HotelFixedPromotionDataHelperImpl implements HotelFixedPromotionDataHelper {
	
	private Connection conn;

	private PreparedStatement ps;

	private ResultSet rs;
	
	private String sql;
	
	public HotelFixedPromotionDataHelperImpl() {
		conn = JDBCUtil.getGongConnection();
	}
	
	/**
	 * @Description:根据酒店工作人员id获取酒店固定的策略，会员生日、企业会员、三间及以上特惠折扣
	 * @param hotelWorkerID
	 * @return
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月3日 下午1:21:02
	 */
	@Override
	public List<HotelFixedPromotionPO> getHotelFixedPromotion(String hotelWorkerID) {
		
		List<HotelFixedPromotionPO> hotelFixedPromotionPOList = new ArrayList<HotelFixedPromotionPO>();
		sql = "select * from hotelfixedpromotion where hotelID = ?";
		HotelFixedPromotionPO hotelFixedPromotionPO = new HotelFixedPromotionPO();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hotelWorkerID);
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				hotelFixedPromotionPO.setHotelID(rs.getString(1));
				hotelFixedPromotionPO.setPromotionType(stringToPromotionType(rs.getString(2)));
				hotelFixedPromotionPO.setDiscount(rs.getDouble(3));
				hotelFixedPromotionPOList.add(hotelFixedPromotionPO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return hotelFixedPromotionPOList;
	}

	/**
	 * @Description:更新酒店固定
	 * @param hotelFixedPromotionPO
	 * @return
	 * @exception:
	 * @author: Harvey Gong
	 * @time:2016年12月3日 下午1:43:36
	 */
	@Override
	public ResultMessage updateHotelFixedPromotion(HotelFixedPromotionPO hotelFixedPromotionPO) {
		
		sql = "update hotelfixedpromotion set discount = ? "
				+ "where hotelID = ? and promotionType = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, hotelFixedPromotionPO.getDiscount());
			ps.setString(2, hotelFixedPromotionPO.getHotelID());
			ps.setString(3, hotelFixedPromotionPO.getPromotionType().toString());
			ps.execute();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			return ResultMessage.FAIL;
		}
		
	}
	
	private PromotionType stringToPromotionType(String promotionType){
		if(promotionType.equals("HOTEL__BIRTHDAY")){
			return PromotionType.HOTEL__BIRTHDAY;
		}
		else if(promotionType.equals("HOTEL__ROOM_NUM_COUNT_BIGGER_THAN_THREE")){
			return PromotionType.HOTEL__ROOM_NUM_COUNT_BIGGER_THAN_THREE;
		}
		else if(promotionType.equals("HOTEL__ENTERPRISE")){
			return PromotionType.HOTEL__ENTERPRISE;
		}
		return null;
	}
	
}
