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
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @跳转主界面
	 */
	@FXML
	protected void openMain() {
		right.getChildren().removeAll(mainPane, charge, market, commonPromotion, cyclePromotion, abnormalOrder);
		right.getChildren().add(mainPane);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @throws IOException
	 *             跳转信用充值界面
	 */
	@FXML
	protected void openCharge() throws IOException {
		right.getChildren().removeAll(mainPane, charge, market, commonPromotion, cyclePromotion, abnormalOrder);
		charge = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/Charge.fxml"));
		right.getChildren().add(charge);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @throws IOException
	 *             跳转会员等级制定界面
	 */
	@FXML
	protected void openMarket() throws IOException {
		right.getChildren().removeAll(mainPane, charge, market, commonPromotion, cyclePromotion, abnormalOrder);
		market = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/MemberCheck.fxml"));
		right.getChildren().add(market);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @throws IOException
	 *             跳转网站商圈策略制定界面
	 */
	@FXML
	protected void openPromotion() throws IOException {
		right.getChildren().removeAll(mainPane, charge, market, commonPromotion, cyclePromotion, abnormalOrder);
		cyclePromotion = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/CyclePromotion.fxml"));

		right.getChildren().add(cyclePromotion);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @throws IOException
	 *             跳转会员等级制定界面
	 */
	@FXML
	protected void openCommonPromotion() throws IOException {
		right.getChildren().removeAll(mainPane, charge, market, commonPromotion, cyclePromotion, abnormalOrder);
		commonPromotion = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/DatePromotion.fxml"));
		right.getChildren().add(commonPromotion);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @throws IOException
	 *             跳转异常订单界面
	 */
	@FXML
	protected void openOrder() throws IOException {
		right.getChildren().removeAll(mainPane, charge, market, commonPromotion, cyclePromotion, abnormalOrder);
		abnormalOrder = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/orderSearch.fxml"));
		right.getChildren().add(abnormalOrder);
	}
}
