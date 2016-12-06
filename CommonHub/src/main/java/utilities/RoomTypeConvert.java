package utilities;

public class RoomTypeConvert {
	public static RoomType convert(String roomType){
		if(roomType.equals("单人间")){
			return RoomType.单人间;
		}
		if(roomType.equals("双人间")){
			return RoomType.双人间;
		}
		if(roomType.equals("三人间")){
			return RoomType.三人间;
		}
		if(roomType.equals("总统套房")){
			return RoomType.总统套房;
		}
		return null;
	}
}
