package utilities;

import java.io.Serializable;

/**
 * 
 * @author charles
 * @lastChangedBy charles
 * @updateTime 2016/12/7
 * 
 * 优先级：已取消 < 异常 < 未执行 < 已执行
 */
public enum OrderState implements Serializable{
	
	CANCELLED, ABNORMAL, UNEXECUTED, EXECUTED;
	
	
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
		}else {
			return "已执行";
		}
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 */
	public static OrderState convertString2OrderState(String a) {
		if (a.equals("已撤销")) {
			return CANCELLED;
		}else if (a.equals("异常")) {
			return ABNORMAL;
		}else if (a.equals("未执行")) {
			return UNEXECUTED;
		}else {
			return EXECUTED;
		}
	}
	
}
