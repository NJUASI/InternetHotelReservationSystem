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
		clearScene();
		jump(guestInfo, "GuestInfo");
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @throws IOException 跳转酒店查询界面
	 */
	@FXML
	protected void openHotel() throws IOException {
		clearScene();
		jump(hotelInfo, "CityChoose");
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @throws IOException 跳转订单查询界面
	 */
	@FXML
	protected void openOrder() throws IOException {
		clearScene();
		jump(orderInfo, "OrderCheck");
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @throws IOException 跳转会员信息界面
	 */
	@FXML
	protected void openMember() throws IOException {
		clearScene();
		jump(memberInfo, "MemberCheck");
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @throws IOException 跳转信用信息界面
	 */
	@FXML
	protected void openCredit() throws IOException {
		jump(creditInfo, "Credit");
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
	 * @author: 61990
	 * @lastChangedBy: 61990
	 * @time:2016年12月8日 下午5:49:52
	 */
	private void clearScene(){
		right.getChildren().removeAll(mainPane, guestInfo, hotelInfo, orderInfo, memberInfo, creditInfo);
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
	private void jump(Parent parent,String path) throws IOException{
		
			parent = FXMLLoader.load(getClass().getResource("/presentation/guestUI/view/"+path+".fxml"));
			right.getChildren().add(parent);
		
		
	}
}
