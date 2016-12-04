package dataHelper;

import java.util.List;

import po.RoomInfoPO;
import utilities.ResultMessage;

public interface RoomDataHelper {
	
	public List<RoomInfoPO> getRoomInfo(String hotelID);
	
	public ResultMessage updateRoomInfo(RoomInfoPO roomInfoPO,String oldName);

	public ResultMessage addRoomInfo(RoomInfoPO roomInfoPO);

	public ResultMessage deleteRoomInfo(String hotelID, String roomType);
	
}
