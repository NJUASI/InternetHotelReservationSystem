package dataHelper;

import java.util.List;

/**
 * @Description:提供给dataService获取所有城市，所有星级，所有房间类型的方法
 * @author:Harvey Gong
 * @lastChangedBy:Harvey Gong
 * @time:2016年12月7日 下午5:02:01
 */
public interface SourceDataHelper {
	
	public List<String> getLevels();

	public List<String> getRoomTypes();

}
