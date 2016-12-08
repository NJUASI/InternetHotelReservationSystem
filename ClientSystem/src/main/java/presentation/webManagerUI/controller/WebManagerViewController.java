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
	 * @updateTime 2016/12/8
	 * @跳转客户修改界面
	 */
	@FXML
	protected void openGuest() throws IOException {
		guest = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/GuestModify.fxml"));
		jump(guest);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转酒店工作人员修改界面
	 */
	@FXML
	protected void openHotel() throws IOException {
		hotel = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/HotelWorkerModify.fxml"));
		jump(hotel);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转营销人员修改或添加界面
	 */
	@FXML
	protected void openMarketer() throws IOException {
		marketer = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/MarketerModify.fxml"));
		jump(marketer);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转酒店注册界面
	 */
	@FXML
	protected void openHotelInfo() throws IOException {
		hotelInfo = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/HotelInfo.fxml"));
		jump(hotelInfo);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转主界面
	 */
	@FXML
	protected void openMain() {
		right.getChildren().removeAll(mainPane, guest, hotel, marketer, hotelInfo);
		right.getChildren().add(mainPane);
	}
	
	/**
	 * @Description:封装跳转逻辑
	 * @param parent
	 * @param path
	 * void
	 * @author: Harvey Gong
	 * @lastChangedBy: 61990
	 * @time:2016年12月8日 下午3:08:24
	 */
	private void jump(Parent parent){
		right.getChildren().removeAll(mainPane,guest, hotel, marketer, hotelInfo);

		right.getChildren().add(parent);
	}
}
