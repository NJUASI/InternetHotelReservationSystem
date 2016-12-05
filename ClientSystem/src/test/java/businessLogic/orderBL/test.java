package businessLogic.orderBL;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import utilities.OrderState;
import utilities.ResultMessage;
import utilities.RoomType;
import vo.GuestEvaluationVO;
import vo.OrderVO;

public class test {

	public static void main(String[] args) {
		final OrderController controller = OrderController.getInstance();
		
		System.out.println(controller.addEvaluation(new GuestEvaluationVO("1234567890", 4.5, "good")));
	}
}
