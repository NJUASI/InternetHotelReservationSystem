package dataHelperImpl.stub;

import java.util.ArrayList;
import java.util.List;

import dataHelper.WebMarketerDataHelper;
import po.WebMarketerPO;
import utilities.ResultMessage;

/**
 * 
 * @author 董金玉 lastChangedBy 董金玉 updateTime 2016/12/1
 *
 */
public class WebMarketerDataHelperImpl_Stub implements WebMarketerDataHelper {

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param webMarketerPO webMarketerInfo载体
	 * @return ResultMessage 是否成功添加到数据库中
	 */
	public ResultMessage add(final WebMarketerPO webMarketerPO) {
		return ResultMessage.SUCCESS;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param webMarketerPO webMarketerInfo载体
	 * @return ResultMessage 是否成功修改数据库中的指定webMarketerInfo
	 */
	public ResultMessage modify(final WebMarketerPO webMarketerPO) {
		return ResultMessage.SUCCESS;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param webMarketerID 网站营销人员ID
	 * @return ResultMessage 是否成功删除指定网站营销人员信息
	 */
	public ResultMessage delete(final String webMarketerID) {
		return ResultMessage.SUCCESS;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param webMarketerID 网站营销人员ID
	 * @return WebMarketerPO 数据库中的指定webMarketerInfo载体
	 */
	public WebMarketerPO getSingle(final String webMarketerID) {
		return new WebMarketerPO("000001", "123456");
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param
	 * @return List<WebMarketerPO> 获取所有webMarketerInfo载体
	 */
	public List<WebMarketerPO> getAll() {
		List<WebMarketerPO> list= new ArrayList<WebMarketerPO>();
		WebMarketerPO a= new WebMarketerPO("000001", "123456");
		list.add(a);
		return list;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param
	 * @return
	 */
	public void close() { // 当决定抛弃该对象的时候，调用该方法
	}
}
