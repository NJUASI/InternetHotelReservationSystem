package presentation.guestUI.controller;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML; 
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import vo.CreditVO;

/**
 * 
 * @author 61990
 * 
 */
public class CreditCheckController {
	@FXML
	private TableView<CreditTable> table;
	@FXML
	private TableColumn<CreditTable, String> guestIDColumn, orderIDColumn, previousCreditColumn,afterCreditColumn,timeColumn,reasonColumn;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 构造函数，初始化成员变量
	 */
	@FXML
	private void initialize() {
		//Main.userID;
		List<CreditVO> credit = new LinkedList<CreditVO>();
		credit.add(new CreditVO("1234567",LocalDateTime.of(1421, 12, 4, 2, 13),"123455667",67,53,"异常->正常"));		
		credit.add(new CreditVO("1234567",LocalDateTime.of(1421, 12, 4, 2, 13),"123455667",67,53,"异常->正常"));
		credit.add(new CreditVO("1234567",LocalDateTime.of(1421, 12, 4, 2, 13),"123455667",67,53,"异常->正常"));
		credit.add(new CreditVO("1234567",LocalDateTime.of(1421, 12, 4, 2, 13),"123455667",67,53,"异常->正常"));
		credit.add(new CreditVO("1234567",LocalDateTime.of(1421, 12, 4, 2, 13),"123455667",67,53,"异常->正常"));
		

		ObservableList<CreditTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < credit.size(); i++) {
			data.add(new CreditTable(credit.get(i).guestID, credit.get(i).orderID, Double.toString(credit.get(i).previousCredit),Double.toString(credit.get(i).afterCredit),
					credit.get(i).time.toString(),credit.get(i).reason));
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
