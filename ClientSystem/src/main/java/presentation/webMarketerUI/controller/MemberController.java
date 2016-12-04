package presentation.webMarketerUI.controller;

import java.util.LinkedList;
import java.util.List;

import businessLogic.marketBL.stub.MarketBLService_Stub;
import businessLogicService.marketBLService.MarketBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utilities.ResultMessage;
import vo.MarketVO;

/**
 * @author 61990
 *
 */
public class MemberController {

	@FXML
	private Pane marketCheckPane;

	@FXML
	private Pane marketModifyPane;

	//加载查看的显示框
	@FXML
	private Label name1, name2, name3, name4, name5, credit1, credit2, credit3, credit4, credit5, discount1, discount2,
			discount3, discount4, discount5;
	
	//加载维护的输入框
	@FXML
	private TextField market1,market2,market3,market4,market5,needCredit1,needCredit2,needCredit3,needCredit4,needCredit5,modifyDiscount1,modifyDiscount2,modifyDiscount3,modifyDiscount4,modifyDiscount5;
	private MarketBLService marketBLService;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		marketBLService = new MarketBLService_Stub();
		List<MarketVO> listMarket = marketBLService.getMemberFormulation();
		name1.setText(listMarket.get(0).marketName);
		name2.setText(listMarket.get(1).marketName);
		name3.setText(listMarket.get(2).marketName);
		name4.setText(listMarket.get(3).marketName);
		name5.setText(listMarket.get(4).marketName);
		credit1.setText(Double.toString(listMarket.get(0).marketCredit));
		credit2.setText(Double.toString(listMarket.get(1).marketCredit));
		credit3.setText(Double.toString(listMarket.get(2).marketCredit));
		credit4.setText(Double.toString(listMarket.get(3).marketCredit));
		credit5.setText(Double.toString(listMarket.get(4).marketCredit));
		discount1.setText(Double.toString(listMarket.get(0).marketBenefit));
		discount2.setText(Double.toString(listMarket.get(1).marketBenefit));
		discount3.setText(Double.toString(listMarket.get(2).marketBenefit));
		discount4.setText(Double.toString(listMarket.get(3).marketBenefit));
		discount5.setText(Double.toString(listMarket.get(4).marketBenefit));
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @跳转并初始化会员等级维护界面
	 */
	@FXML
	protected void modifyMarket() {
		market1.setText(name1.getText());
		market2.setText(name2.getText());
		market3.setText(name3.getText());
		market4.setText(name4.getText());
		market5.setText(name5.getText());
		needCredit1.setText(credit1.getText());
		needCredit2.setText(credit2.getText());
		needCredit3.setText(credit3.getText());
		needCredit4.setText(credit4.getText());
		needCredit5.setText(credit5.getText());
		modifyDiscount1.setText(discount1.getText());
		modifyDiscount2.setText(discount2.getText());
		modifyDiscount3.setText(discount3.getText());
		modifyDiscount4.setText(discount4.getText());
		modifyDiscount5.setText(discount5.getText());
		
		marketModifyPane.setVisible(true);
		marketCheckPane.setVisible(false);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @跳转会员等级查看界面，取消维护
	 */
	@FXML
	protected void cancelModify() {
		marketCheckPane.setVisible(true);
		marketModifyPane.setVisible(false);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @保存维护界面
	 */
	@FXML
	protected void saveModify() {
		
		List<MarketVO> list = new LinkedList<MarketVO>();
		list.add(new MarketVO(market1.getText(), Double.parseDouble(needCredit1.getText()) , Double.parseDouble(modifyDiscount1.getText())));
		list.add(new MarketVO(market2.getText(), Double.parseDouble(needCredit2.getText()) , Double.parseDouble(modifyDiscount2.getText())));
		list.add(new MarketVO(market3.getText(), Double.parseDouble(needCredit3.getText()) , Double.parseDouble(modifyDiscount3.getText())));
		list.add(new MarketVO(market4.getText(), Double.parseDouble(needCredit4.getText()) , Double.parseDouble(modifyDiscount4.getText())));
		list.add(new MarketVO(market5.getText(), Double.parseDouble(needCredit5.getText()) , Double.parseDouble(modifyDiscount5.getText())));
		
		if(marketBLService.setMemberFormulation(list)==ResultMessage.SUCCESS){
			System.out.println("success");
		}
		initialize();
		marketCheckPane.setVisible(true);
		marketModifyPane.setVisible(false);
	}
}
