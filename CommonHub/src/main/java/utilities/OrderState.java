package utilities;

import java.io.Serializable;

/**
 * 
 * @author charles
 * @lastChangedBy charles
 * @updateTime 2016/12/4
 * 
 * 优先级：已评论 > 已执行 > 未执行 > 异常 > 已取消
 */
public enum OrderState implements Serializable{
	
	CANCELLED, ABNORMAL, UNEXECUTED, EXECUTED, COMMENTED;
	
	
	@Override
	public String toString() {
		if (this == CANCELLED) {
			return "已撤销";
		}
		return super.toString();
	}
	
}
