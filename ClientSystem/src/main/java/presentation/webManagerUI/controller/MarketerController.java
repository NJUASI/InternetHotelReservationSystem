package presentation.webManagerUI.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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

	@FXML
	private void initialize() {

	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @搜营销人员并初始化界面        
	 */
	@FXML
	protected void search() {
		// 通过IDget marketer
		marketerVO = new WebMarketerVO("12345678", "876543231");
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
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @保存营销人員信息
	 */
	@FXML
	protected void saveModify() {
		marketerVO.password = password2.getText();
		// save(hotelVO)

		modifyPane.setVisible(false);
		marketerInfoPane.setVisible(true);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @取消更改酒店工作人員信息
	 */
	@FXML
	protected void cancelModify() {
		modifyPane.setVisible(false);
		marketerInfoPane.setVisible(true);
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/2
	 * @添加酒店工作人員信息
	 * 是否需要待议
	 */
	@FXML
	protected void addMarketer() {
		
	}
}
