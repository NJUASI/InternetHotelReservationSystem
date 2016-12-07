package utilities;

import java.io.Serializable;

public enum RoomType implements Serializable{
	单人间, 双人间, 三人间, 总统套房, 商务套房;
	
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
