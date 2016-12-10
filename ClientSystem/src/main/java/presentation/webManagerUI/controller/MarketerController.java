package presentation.webManagerUI.controller;

import businessLogic.userBL.UserController;
import businessLogicService.userBLService.UserBLService;
import exception.verificationException.UserInexistException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.PopUp.PopUp;
import utilities.enums.ResultMessage;
import vo.WebMarketerVO;

/**
 * @author 61990
 *
 */
public class MarketerController {

	WebMarketerVO marketerVO;
	
	@FXML
	private Pane modifyPane,marketerInfoPane;
	@FXML
	private TextField inputID, password2;
	@FXML
	private Label password, marketerID, marketerID2;
	
	private UserBLService userBLController;

	@FXML
	private void initialize() {
		userBLController = UserController.getInstance();
	}

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * @搜营销人员并初始化界面        
	 */
	@FXML
	protected void search() {
		try {
			marketerVO = (WebMarketerVO) userBLController.getSingle(inputID.getText());
		} catch (UserInexistException e) {
			e.printStackTrace();
			// 为了保证编译能通过
		}
		
		if(marketerVO == null){
//			TODO djy得不到不是可以直接弄到异常里吗
				new PopUp("请检查输入内容", "sorry");
		}
		
		marketerID.setText(marketerVO.userID);
		password.setText(marketerVO.password);

		marketerInfoPane.setVisible(true);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @初始化营销人员信息界面
	 */
	@FXML
	protected void modifyHotel() {
		if (marketerVO != null) {
			marketerID2.setText(marketerVO.userID);
			password2.setText(marketerVO.password);

			modifyPane.setVisible(true);
			marketerInfoPane.setVisible(false);
		}
	}

	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * @保存营销人員信息
	 */
	@FXML
	protected void saveModify() {

		WebMarketerVO tempMarketerVO = marketerVO;
		
		tempMarketerVO.password = password2.getText();
		
		ResultMessage message = userBLController.modify(tempMarketerVO);
		 		
		new PopUp(message.toString(), "congratulation");	


		modifyPane.setVisible(false);
		marketerInfoPane.setVisible(true);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @取消更改人員信息
	 */
	@FXML
	protected void cancelModify() {
		modifyPane.setVisible(false);
		marketerInfoPane.setVisible(true);
	}
	/**
	 * @author 61990
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/7
	 * @添加营销人員信息
	 * 是否需要待议
	 */
	@FXML
	protected void addMarketer() {
		//TODO 返回初始的标号和密码
		// TODO djy 这个方法是添加酒店工作人员还是营销？
//		营销人员的VO
	}
}
