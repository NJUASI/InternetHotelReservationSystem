package presentation.webManagerUI.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class WebManagerViewController {
	@FXML
	private StackPane right;
	@FXML
	private Pane mainPane;
	
	private Parent currentParent;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转客户修改界面
	 */
	@FXML
	protected void openGuest() throws IOException {
		jump("GuestModify");
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转酒店工作人员修改界面
	 */
	@FXML
	protected void openHotel() throws IOException {
		jump("HotelWorkerModify");
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转营销人员修改或添加界面
	 */
	@FXML
	protected void openMarketer() throws IOException {
		jump("MarketerModify");
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转酒店注册界面
	 */
	@FXML
	protected void openHotelInfo() throws IOException {
		jump("HotelInfo");
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/8
	 * @跳转主界面
	 */
	@FXML
	protected void openMain() {
		right.getChildren().clear();
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
	private void jump(String path){
		right.getChildren().clear();
		try {
			currentParent = FXMLLoader.load(getClass().getResource("/presentation/webMarketerUI/view/"+path+".fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		right.getChildren().add(currentParent);
	}
}
