package utilities;

import java.io.Serializable;

/**
 * 
 * @author charles
 * @lastChangedBy charles
 * @updateTime 2016/12/5
 * 
 * 优先级：已评论 > 已执行 > 未执行 > 异常 > 已取消
 */
public enum OrderState implements Serializable{
	
	CANCELLED, ABNORMAL, UNEXECUTED, EXECUTED, COMMENTED;
	
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * 
	 * 复写toString，便于界面调用
	 */
	@Override
	public String toString() {
		if (this == CANCELLED) {
			return "已撤销";
		}else if (this == ABNORMAL) {
			return "异常";
		}else if (this == UNEXECUTED) {
			return "未执行";
		}else if (this == EXECUTED) {
			return "已执行";
		}else {
			return "已评论";
		}
	}
	
	
}
