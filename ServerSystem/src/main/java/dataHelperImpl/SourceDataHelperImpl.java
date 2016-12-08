package dataHelperImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import dataHelper.SourceDataHelper;

/**
 * @Description:资源文件的读取：
 * 系统支持城市的获取、支持星级的获取、支持酒店类型的获取
 * @author:Harvey Gong
 * @lastChangedBy:Harvey Gong
 * @time:2016年12月7日 下午5:04:19
 */
public class SourceDataHelperImpl implements SourceDataHelper {
	
	/**
	 * @Description:读取资源文件里的所有城市
	 * @return 
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月8日 下午1:06:28
	 */
	@Override
	public Iterator<String> getCities() {
		return getSources("city");
	}

	/**
	 * @Description:TODO
	 * @return
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月8日 下午1:07:01
	 */
	@Override
	public Iterator<String> getLevels() {
		return getSources("level");
	}

	/**
	 * @Description:获取系统支持的所有酒店客房类型
	 * @return
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月8日 下午1:10:44
	 */
	@Override
	public Iterator<String> getRoomTypes() {
		return getSources("roomType");
	}
	
	/**
	 * @Description:根据传入的城市，到相应的资源文件中去找该城市的所有商圈
	 * @param city
	 * @return
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月8日 下午1:16:27
	 */
	@Override
	public Iterator<String> getCircles(String city) {
		return getSources("circle/"+city);
	}
	
	private Iterator<String> getSources(String sourceName){
		Properties source = new Properties();
		List<String> values = new ArrayList<String>();
		try {
			source.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(sourceName+".properties"));
			for(int i = 0;i < source.size();i++){
				values.add(source.getProperty(""+(i+1)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return values.iterator();
	}

}
