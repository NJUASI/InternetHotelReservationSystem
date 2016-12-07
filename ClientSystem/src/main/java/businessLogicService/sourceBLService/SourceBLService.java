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
}
