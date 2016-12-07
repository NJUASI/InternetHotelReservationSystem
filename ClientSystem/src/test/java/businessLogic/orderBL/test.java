package businessLogic.orderBL;

import vo.GuestEvaluationVO;

public class test {

	public static void main(String[] args) {
		final OrderBLController controller = OrderBLController.getInstance();
		
		System.out.println(controller.addEvaluation(new GuestEvaluationVO("1234567890", 4.5, "good")));
	}
}
