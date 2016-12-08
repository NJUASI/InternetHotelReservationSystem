package presentation.guestUI.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * @author 61990
 * @lastChangedBy Harvey
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
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @throws IOException 跳转客户信息界面
	 */
	@FXML
	protected void openGuestInfo() throws IOException {
		guestInfo = FXMLLoader.load(getClass().getResource("/presentation/guestUI/view/GuestInfo.fxml"));
		jump(guestInfo);
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @throws IOException 跳转酒店查询界面
	 */
	@FXML
	protected void openHotel() throws IOException {
		hotelInfo = FXMLLoader.load(getClass().getResource("/presentation/guestUI/view/CityChoose.fxml"));
		jump(hotelInfo);
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @throws IOException 跳转订单查询界面
	 */
	@FXML
	protected void openOrder() throws IOException {
		orderInfo = FXMLLoader.load(getClass().getResource("/presentation/guestUI/view/OrderCheck.fxml"));
		jump(orderInfo);
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @throws IOException 跳转会员信息界面
	 */
	@FXML
	protected void openMember() throws IOException {
		memberInfo = FXMLLoader.load(getClass().getResource("/presentation/guestUI/view/MemberCheck.fxml"));
		jump(memberInfo);
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @throws IOException 跳转信用信息界面
	 */
	@FXML
	protected void openCredit() throws IOException {
		creditInfo= FXMLLoader.load(getClass().getResource("/presentation/guestUI/view/MemberCheck.fxml"));
		jump(creditInfo);
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @throws IOException 跳转主界面
	 */
	@FXML
	protected void openMain() {
		right.getChildren().removeAll(mainPane, guestInfo, hotelInfo, orderInfo, memberInfo, creditInfo);
		right.getChildren().add(mainPane);
	}

	/**
	 * @Description:封装跳转逻辑
	 * @param parent
	 * @param path
	 * void
	 * @author: Harvey Gong
	 * @throws IOException 
	 * @lastChangedBy: 61990
	 * @time:2016年12月8日 下午2:49:52
	 */
	private void jump(Parent parent) throws IOException{
		right.getChildren().removeAll(mainPane, guestInfo, hotelInfo, orderInfo, memberInfo, creditInfo);	
			right.getChildren().add(parent);
		
		
	}
}
