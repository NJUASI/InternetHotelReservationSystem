package dataHelperImpl.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dataHelper.GuestDataHelper;
import po.GuestPO;
import utilities.ResultMessage;

/**
 * 
 * @author 董金玉 lastChangedBy 董金玉 updateTime 2016/12/1
 *
 */
public class GuestDataHelperImpl_Stub implements GuestDataHelper {


	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param guestPO guestInfo载体
	 * @return guestPO 是否成功添加到数据库中
	 */
	public ResultMessage add(final GuestPO guestPO) {
		return ResultMessage.SUCCESS;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param guestPO guestInfo载体
	 * @return ResultMessage 是否成功修改数据库中的指定guestInfo
	 */
	public ResultMessage modify(final GuestPO guestPO) {
		return ResultMessage.SUCCESS;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param guestID 客户ID
	 * @return GuestPO 数据库中的指定guestInfo载体
	 */
	public GuestPO getSingle(final String guestID) {
		LocalDate birthday = LocalDate.of(1995, 1, 1);
		
		return new GuestPO("1234567890", birthday, "school", "zhangsan", "xiaosan", "000000", "13523456789", 100);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param
	 * @return List<GuestPO> 获取所有guestInfo载体
	 */
	public List<GuestPO> getAll() {
		List<GuestPO> list = new ArrayList<GuestPO>();
		GuestPO a= new GuestPO("1234567890", LocalDate.of(1995, 1, 1), "school", "zhangsan", "xiaosan",
				"000000", "13523456789",100);
		list.add(a);
		return list;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/28
	 * @param
	 * @return
	 */
	public void close() { // 当决定抛弃该对象的时候，调用该方法
	}
}
