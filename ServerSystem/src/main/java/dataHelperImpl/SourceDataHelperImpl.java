package dataHelperImpl;

import java.util.Iterator;

import dataHelper.SourceDataHelper;

/**
 * @Description:TODO 商讨具体用什么实现,使用资源文件还是用什么方法，我倾向于使用资源文件
 * @author:Harvey Gong
 * @lastChangedBy:Harvey Gong
 * @time:2016年12月7日 下午5:04:19
 */
public class SourceDataHelperImpl implements SourceDataHelper {

	@Override
	public Iterator<String> getCities() {
		// TODO 获取支持的所有城市
		return null;
	}

	@Override
	public Iterator<String> getLevels() {
		// TODO 获取支持的所有酒店星级
		return null;
	}

	@Override
	public Iterator<String> getRoomTypes() {
		// TODO 获取支持的所有酒店客房类型
		return null;
	}

}
