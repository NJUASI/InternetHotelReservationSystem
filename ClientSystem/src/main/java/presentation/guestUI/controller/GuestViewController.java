package presentation.guestUI.controller;

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
public class GuestViewController {
	Parent guestInfo, hotelInfo, orderInfo, memberInfo, creditInfo;

	@FXML
	private StackPane right;
	
	@FXML
	private Pane mainPane;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @throws IOException 跳转客户信息界面
	 */
	@FXML
	protected void openGuestInfo() throws IOException {
		right.getChildren().removeAll(mainPane, guestInfo, hotelInfo, orderInfo, memberInfo, creditInfo);
		guestInfo = FXMLLoader.load(getClass().getResource("/presentation/guestUI/view/GuestInfo.fxml"));
		right.getChildren().add(guestInfo);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @throws IOException 跳转酒店查询界面
	 */
	@FXML
	protected void openHotel() throws IOException {
		right.getChildren().removeAll(mainPane, guestInfo, hotelInfo, orderInfo, memberInfo, creditInfo);
		hotelInfo = FXMLLoader.load(getClass().getResource("/presentation/guestUI/view/CityChoose.fxml"));
		right.getChildren().add(hotelInfo);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @throws IOException 跳转订单查询界面
	 */
	@FXML
	protected void openOrder() throws IOException {
		right.getChildren().removeAll(mainPane, guestInfo, hotelInfo, orderInfo, memberInfo, creditInfo);
		orderInfo = FXMLLoader.load(getClass().getResource("/presentation/guestUI/view/OrderCheck.fxml"));
		right.getChildren().add(orderInfo);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @throws IOException 跳转会员信息界面
	 */
	@FXML
	protected void openMember() throws IOException {
		right.getChildren().removeAll(mainPane, guestInfo, hotelInfo, orderInfo, memberInfo, creditInfo);
		memberInfo = FXMLLoader.load(getClass().getResource("/presentation/guestUI/view/MemberCheck.fxml"));
		right.getChildren().add(memberInfo);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @throws IOException 跳转信用信息界面
	 */
	@FXML
	protected void openCredit() throws IOException {
		right.getChildren().removeAll(mainPane, guestInfo, hotelInfo, orderInfo, memberInfo, creditInfo);
		creditInfo = FXMLLoader.load(getClass().getResource("/presentation/guestUI/view/Credit.fxml"));

		right.getChildren().add(creditInfo);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @throws IOException 跳转主界面
	 */
	@FXML
	protected void openMain() {
		right.getChildren().removeAll(mainPane, guestInfo, hotelInfo, orderInfo, memberInfo, creditInfo);
		right.getChildren().add(mainPane);
	}
}
