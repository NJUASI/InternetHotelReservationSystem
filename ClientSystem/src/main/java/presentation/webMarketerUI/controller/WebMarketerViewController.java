package presentation.webMarketerUI.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * @author 61990
 *
 */
public class WebMarketerViewController {

	Parent charge, market, commonPromotion, cyclePromotion, abnormalOrder;

	@FXML
	private StackPane right;

	@FXML
	private Pane mainPane;

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @跳转主界面
	 */
	@FXML
	protected void openMain() {
		right.getChildren().removeAll(mainPane, charge, market, commonPromotion, cyclePromotion, abnormalOrder);
		right.getChildren().add(mainPane);
	}

	/**
	 * @dscription 跳转信用充值界面
	 * @author 61990
	 * @throws IOException 
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 */
	@FXML
	protected void openCharge() throws IOException{
		charge = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/Charge.fxml"));
		jump(charge);
	}

	/**
	 * @description 跳转会员等级制定界面
	 * @author 61990
	 * @throws IOException 
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 */
	@FXML
	protected void openMarket() throws IOException{
		market = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/MemberCheck.fxml"));
		jump(market);
	}

	/**
	 * @description 跳转网站商圈策略制定界面
	 * @author 61990
	 * @throws IOException 
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 */
	@FXML
	protected void openPromotion() throws IOException{
		cyclePromotion = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/CyclePromotion.fxml"));
		jump(cyclePromotion);
	}

	/**
	 * @description  跳转会员等级制定界面
	 * @author 61990
	 * @throws IOException 
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 */
	@FXML
	protected void openCommonPromotion() throws IOException{
		commonPromotion = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/DatePromotion.fxml"));
		jump(commonPromotion);
	}

	/**
	 * @description 跳转异常订单界面
	 * @author 61990
	 * @throws IOException 
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 */
	@FXML
	protected void openOrder() throws IOException{
		abnormalOrder = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/orderSearch.fxml"));
		jump(abnormalOrder);
	}

	/**
	 * @Description:封装跳转逻辑
	 * @param parent
	 * @param path
	 * void
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月8日 下午3:08:03
	 */
	private void jump(Parent parent){
		right.getChildren().removeAll(mainPane, charge, market, commonPromotion, cyclePromotion, abnormalOrder);
		right.getChildren().add(parent);
	}
}
