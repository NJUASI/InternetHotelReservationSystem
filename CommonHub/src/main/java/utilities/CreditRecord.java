package utilities;

public enum CreditRecord {

	//	信用充值，未执行正常订单执行，订单逾期（最晚订单执行时间），异常订单撤销
	CHARGE, EXECUTE, ABNORMAL_EXECUTE, OVERDUE, UNDO_ABNORMAL; 
	
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/9
	 */
	public String toString() {
		if (this == CHARGE) {
			return "信用充值";
		}else if (this == EXECUTE) {
			return "未执行->已执行";
		}else if (this == ABNORMAL_EXECUTE) {
			return "异常->已执行";
		}else if (this == OVERDUE) {
			return "未执行->异常";
		}else {
			return "异常->已撤销";
		}
	};
}
