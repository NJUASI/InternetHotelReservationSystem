package presentation.guestUI.controller;

import java.time.LocalDate;

import businessLogic.memberBL.MemberController;
import businessLogicService.memberBLService.MemberBLService;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utilities.IDReserve;
import utilities.MemberType;
import vo.MarketVO;
import vo.MemberVO;

/**
 * @author 61990
 * @控制会员查看注册界面
 * @version 11.27
 */
public class MemberCheckController {

	MemberVO memberVO;
	MarketVO marketVO;
	@FXML
	private Pane memberCheck;
	
	@FXML
	private Pane memberModify;

	@FXML
	private Label enterprise, market, market2, birthday;
	
	private MemberBLService  memberBLController = MemberController.getInstance();

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		try {
			
			memberVO=memberBLController.getMemberInfo(IDReserve.getInstance().getUserID(), 
					MemberType.BOTH);
			// TODO gy 该会员类型该如何获取，在初始化的时候！！！！！
			// TODO djy 通过ID得到他的guestVO啊，通过里面存的是否有生日或者企业来判断？
			marketVO = new MarketVO("LV4", 0, 0);
			// TODO 认领一下 获取客户等级
			enterprise.setText(memberVO.enterprise);
			if(memberVO.enterprise!=null){
			market.setText(marketVO.marketName);
			}
			birthday.setText(memberVO.birthday.toString());
			
			if(memberVO.birthday!=null){
			market2.setText(marketVO.marketName);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	// 注册界面
	@FXML
	private Pane commonPane;
	
	@FXML
	private Pane enterprisePane;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @跳转会员注册界面
	 */
	@FXML
	protected void register() {
		memberCheck.setVisible(false);
		memberModify.setVisible(true);
		if (birthday.getText()!=null) {
			commonPane.setDisable(true);
			birthdayPicker.setValue(memberVO.birthday);
		}
		if (enterprise.getText()!=null) {
			enterprisePane.setDisable(true);
			enterpriseText.setText(memberVO.enterprise);
		}
	}
	@FXML
	private TextField enterpriseText;
	@FXML 
	private DatePicker birthdayPicker;
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @企业会员提交
	 */
	@FXML
	protected void registerEnterprise() {
		//TODO 通过ID和QQ企业注册生日会员
		// TODO DJY 接口不对应，若要实现界面就会内含逻辑
		// TODO gy 双会员怎么办
		enterprise.getText();	
		initialize();
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @普通会员提交
	 */
	@FXML
	protected void registerCommon() {
		//TODO 通过ID和生日注册生日会员
		// TODO DJY 接口不对应，若要实现界面就会内含逻辑
		// TODO gy 双会员怎么办
//		String s=Main.userID;
		birthdayPicker.getValue();
		initialize();
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @返回会员信息界面
	 */
	@FXML
	protected void cancer() {
		memberCheck.setVisible(true);
		memberModify.setVisible(false);
	}
}
