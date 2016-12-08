package dataHelper;

import java.util.List;

import po.RoomInfoPO;
import utilities.ResultMessage;
import utilities.RoomType;

public interface RoomDataHelper {
	
	public List<RoomInfoPO> getRoomInfo(String hotelID);
	
	public ResultMessage updateRoomInfo(RoomInfoPO roomInfoPO);

	public ResultMessage addRoomInfo(RoomInfoPO roomInfoPO);

	public ResultMessage deleteRoomInfo(String hotelID,RoomType roomType);
	
}
