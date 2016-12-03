package dataHelperImpl.stub;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dataHelper.CreditDataHelper;
import po.CreditPO;
import utilities.ResultMessage;

/**
 * 
 * @author 董金玉 lastChangedBy 董金玉 updateTime 2016/11/30
 *
 */
public class CreditDataHelperImpl_Stub implements CreditDataHelper {

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/30
	 * @param guestID
	 *            客户ID
	 * @return List<CreditPO> 所有creditInfo载体
	 */
	public List<CreditPO> getAll(final String guestID) {
		List<CreditPO> list = new ArrayList<CreditPO>();

		list.add(new CreditPO("1234567890", LocalDateTime.of(2016, 10, 2, 18, 12), "123420161002", 100, 100, "undo"));
		list.add(new CreditPO("1234567890", LocalDateTime.of(2016, 10, 3, 13, 14), "124520161003", 100, 100, "create"));
		list.add(new CreditPO("1234567890", LocalDateTime.of(2016, 10, 4, 15, 22), "244520161004", 100, 300,
				"executed"));
		return list;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/30
	 * @param creditPO
	 *            creditInfo载体
	 * @return ResultMessage 是否成功添加creditInfo
	 */
	public ResultMessage add(final CreditPO creditPO) {

		return ResultMessage.SUCCESS;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/30
	 * @param
	 * @return
	 */
	public void close() { // 当决定抛弃该对象时调用
	}

}
