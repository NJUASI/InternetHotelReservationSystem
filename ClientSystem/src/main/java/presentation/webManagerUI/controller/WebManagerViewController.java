package presentation.webManagerUI.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class WebManagerViewController {
	Parent guest, hotel, marketer, hotelInfo;

	@FXML
	private StackPane right;
	@FXML
	private Pane mainPane;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @跳转客户修改界面
	 */
	@FXML
	protected void openGuest() throws IOException {
		right.getChildren().removeAll(mainPane, guest, hotel, marketer, hotelInfo);
		guest = FXMLLoader.load(getClass().getResource("/presentation/webManagerUI/view/GuestModify.fxml"));
		right.getChildren().add(guest);

	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @跳转酒店工作人员修改界面
	 */
	@FXML
	protected void openHotel() throws IOException {
		right.getChildren().removeAll(mainPane, guest, hotel, marketer, hotelInfo);
		hotel = FXMLLoader.load(getClass().getResource("/presentation/webManagerUI/view/HotelWorkerModify.fxml"));
		right.getChildren().add(hotel);

	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @跳转营销人员修改或添加界面
	 */
	@FXML
	protected void openMarketer() throws IOException {
		right.getChildren().removeAll(mainPane, guest, hotel, marketer, hotelInfo);
		marketer = FXMLLoader.load(getClass().getResource("/presentation/webManagerUI/view/MarketerModify.fxml"));
		right.getChildren().add(marketer);

	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @跳转酒店注册界面
	 */
	@FXML
	protected void openHotelInfo() throws IOException {
		right.getChildren().removeAll(mainPane, guest, hotel, marketer, hotelInfo);
		hotelInfo = FXMLLoader.load(getClass().getResource("/presentation/webManagerUI/view/HotelInfo.fxml"));
		right.getChildren().add(hotelInfo);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @跳转主界面
	 */
	@FXML
	protected void openMain() {
		right.getChildren().removeAll(mainPane, guest, hotel, marketer, hotelInfo);
		right.getChildren().add(mainPane);
	}
}
