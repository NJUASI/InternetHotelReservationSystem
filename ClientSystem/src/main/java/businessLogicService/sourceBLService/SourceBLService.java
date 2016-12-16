package businessLogicService.sourceBLService;

import java.util.Iterator;

/**
 * @Description:获取资源文件：
 * 城市，星级，房间类型
 * @author:Harvey Gong
 * @lastChangedBy:Harvey Gong
 * @time:2016年12月7日 下午4:54:01
 */
public interface SourceBLService {
	/**
	 * @Description:获取所有城市
	 * @return
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 下午4:55:09
	 */
	public Iterator<String> getCities();

	/**
	 * @Description:获取该城市所有的商圈
	 * @return
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 下午6:44:47
	 */
	public Iterator<String> getCircles(String city);


	/**
	 * @Description:获取酒店所有的等级
	 * @return
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 下午4:55:57
	 */
	public Iterator<String> getLevels();

	/**
	 * @Description:获取酒店所有的房间类型
	 * @return
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 下午4:56:34
	 */
	public Iterator<String> getRoomTypes();

	/**
	 * @Description:获取单个订单允许最大客人数
	 * @return
	 * int
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月13日 下午6:52:29
	 */
	public int getMaxGuestNumEachOrder();

	/**
	 * @Description:获取单个订单允许最大房间数
	 * @return
	 * int
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月13日 下午6:52:41
	 */
	public int getMaxRoomNumEachOrder();

}
