package presentation.guestUI.controller;

import businessLogic.marketBL.MarketController;
import businessLogic.memberBL.MemberController;
import businessLogicService.marketBLService.MarketBLService;
import businessLogicService.memberBLService.MemberBLService;
import exception.verificationException.UserInexistException;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utilities.IDReserve;
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

	private MemberBLService memberBLController = MemberController.getInstance();

	private MarketBLService marketBLController = MarketController.getInstance();

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/11构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {

		try {
			memberVO = memberBLController.getMemberInfo(IDReserve.getInstance().getUserID());
			String levelName = marketBLController.getLevelName(IDReserve.getInstance().getUserID());
			marketVO = new MarketVO(levelName, 0, 0);
			
			if (memberVO.enterprise != null) {
				enterprise.setText(memberVO.enterprise);
				market.setText(marketVO.marketName);
			}

			if (memberVO.birthday != null) {
				birthday.setText(memberVO.birthday.toString());
				market2.setText(marketVO.marketName);
			}
		} catch (UserInexistException e) {
			e.printStackTrace();
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
		
		if (birthday.getText() != "") {
			commonPane.setDisable(true);
			birthdayPicker.setValue(memberVO.birthday);
		}else{
			commonPane.setDisable(false);
		}
		if (enterprise.getText() != "") {
			enterprisePane.setDisable(true);
			enterpriseText.setText(memberVO.enterprise);
		}else{
			enterprisePane.setDisable(false);
		}
	}

	@FXML
	private TextField enterpriseText;
	@FXML
	private DatePicker birthdayPicker;

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * @企业会员提交
	 */
	@FXML
	protected void registerEnterprise() {

		MemberVO tempMemberVO = memberVO;
		tempMemberVO.enterprise = enterprise.getText();
		memberBLController.add(tempMemberVO);
		initialize();
	}

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * @普通会员提交
	 */
	@FXML
	protected void registerCommon() {

		MemberVO tempMemberVO = memberVO;
		tempMemberVO.birthday = birthdayPicker.getValue();
		memberBLController.add(tempMemberVO);
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
