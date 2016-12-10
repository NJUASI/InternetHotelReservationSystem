package utilities.enums;

import java.io.Serializable;

public enum RoomType implements Serializable{
	单人间("a"), 双人间("kk"), 三人间("c"), 总统套房("d"), 商务套房("e");
	
	private String thisRoomtype;
	
	private RoomType(String a) {
		this.thisRoomtype = a;
	}
	public String getRoomType() {
		return thisRoomtype;
	}
	
	public static RoomType getEnum(String a) {
		for (RoomType roomType : values()) {
			if (roomType.thisRoomtype.equals(a)) {
				return roomType;
			}
		}
		return null;
	}
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 */
	public static RoomType convertString2Roomtype(String a) {
		if (a.equals("单人间")) {
			return RoomType.单人间;
		}else if (a.equals("双人间")) {
			return RoomType.双人间;
		}else if (a.equals("三人间")) {
			return RoomType.三人间;
		}else if (a.equals("总统套房")) {
			return RoomType.总统套房;
		}else {
			return RoomType.商务套房;
		}
	}
}
