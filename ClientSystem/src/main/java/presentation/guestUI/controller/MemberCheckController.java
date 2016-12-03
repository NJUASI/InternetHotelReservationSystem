package presentation.guestUI.controller;

import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.Main;
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

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		try {
			memberVO=new MemberVO("12345",LocalDate.of(2001, 1, 22),null);
			marketVO = new MarketVO("LV4", 0, 0);
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
		if (!"".equals(birthday.getText())) {
			commonPane.setDisable(false);
		}
		if (!"".equals(enterprise.getText())) {
			enterprisePane.setDisable(true);
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
//		String s=Main.userID;
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
