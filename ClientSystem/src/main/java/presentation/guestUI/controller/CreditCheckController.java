package presentation.guestUI.controller;

import java.util.Iterator;

import businessLogic.creditBL.CreditController;
import businessLogicService.creditBLService.CreditBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.Table.CreditTable;
import utilities.IDReserve;
import vo.CreditVO;

/**
 * @description 显示客户信用记录变化的界面控制器
 * @author 61990
 * @lastChangedBy Harvey
 * 
 */
public class CreditCheckController {
	@FXML
	private TableView<CreditTable> table;
	@FXML
	private TableColumn<CreditTable, String> guestIDColumn, orderIDColumn, previousCreditColumn,afterCreditColumn,timeColumn,reasonColumn;

	private CreditBLService creditBLController;
	private String guestID;
	public CreditCheckController() {
		creditBLController = CreditController.getInstance();
		guestID = IDReserve.getInstance().getUserID();
	}
	
	/**
	 * @description 获取客户所有的信用变化记录
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	private void initialize() {

		// 调用creditBL的方法，通过guest获得该用户所有的信用变化
		Iterator<CreditVO> creditChanges = creditBLController.getAllCreditDetail(guestID);
		
		ObservableList<CreditTable> data = FXCollections.observableArrayList();
		while(creditChanges.hasNext()){
			CreditVO credit = creditChanges.next();
			data.add(new CreditTable(credit.guestID, credit.orderID, 
					Double.toString(credit.previousCredit),Double.toString(credit.afterCredit),
					credit.time.toString(),credit.reason.toString()));
		}
		guestIDColumn.setCellValueFactory(cellData -> cellData.getValue().guestID);
		orderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderID);
		previousCreditColumn.setCellValueFactory(cellData -> cellData.getValue().previousCredit);
		afterCreditColumn.setCellValueFactory(cellData -> cellData.getValue().afterCredit);
		timeColumn.setCellValueFactory(cellData -> cellData.getValue().time);
		reasonColumn.setCellValueFactory(cellData -> cellData.getValue().reason);
		table.setItems(data);

	}

}
