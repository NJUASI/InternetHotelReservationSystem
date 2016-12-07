package dataService.sourceDataService;

import java.util.Iterator;

public interface SourceDataService {
	
	
	/**
	 * @Description:获取该系统覆盖的所有城市
	 * @return
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 下午4:59:17
	 */
	public Iterator<String> getCities();

	/**
	 * @Description:获取该系统支持的所有酒店的星级
	 * @return
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 下午4:59:54
	 */
	public Iterator<String> getLevels();

	
	/**
	 * @Description:获取该系统支持的所有房间类型
	 * @return
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 下午5:00:19
	 */
	public Iterator<String> getRoomTypes();
}
