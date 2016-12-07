package presentation.hotelWorkerUI.controller;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import businessLogic.hotelBL.HotelBLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import presentation.guestUI.controller.EvaluationTable;
import utilities.IDReserve;
import vo.HotelEvaluationVO;
import vo.HotelVO;

/**
 * @author 61990
 * @lastChangedBy Harvey
 *
 */
public class HotelController {
	
	HotelBLController hotelBLController;
	String hotelID = IDReserve.getInstance().getUserID();
	
	public HotelController() {
		hotelBLController = HotelBLController.getInstance();
	}

	@FXML
	private Pane hotelModifyPane;
	@FXML
	private Pane hotelInfoPane;

	@FXML
	private Label hotelNameInDetail, hotelIDInDetail, cityInDetail, levelInDetail, scoreInDetail, cycleInDetail,
	introductionInDetail, equipmentInDetail, hotelAddressInDetail;

	List<HotelEvaluationVO> commentList;
	/**
	 * @description: 在查看酒店详情时，需要显示酒店详情及酒店的所有评论
	 * @author 61990
	 * @lastChangedBy Harvey Gong
	 * @updateTime 2016/12/6 
	 */
	@FXML
	private void initialize() {
		
		//显示酒店详情
		HotelVO hotelVO = hotelBLController.getHotelInfo(hotelID);
		initHotelDetail(hotelVO);

		//TODO 显示酒店的所有评论
		commentList=new LinkedList<>();
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		commentList.add(new HotelEvaluationVO("12334", LocalDate.of(2005, 3, 2),5.0,"ssssdfgasdfadgljglfksdjfklajdlfkjasldfkj"));
		initCommentTable(commentList);
	}	
	@FXML
	TableView<EvaluationTable> evaluationTable;
	@FXML
	private TableColumn<EvaluationTable, String> guestIDColumn,scoreColumn, commentColumn;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @param orderVO
	 * @describe 初始化评价详情
	 */
	private void initCommentTable(List<HotelEvaluationVO> commentList) {
		evaluationTable.getItems().clear();
		List<EvaluationTable> dataList = new LinkedList<EvaluationTable>();
		for (int i = 0; i < commentList.size(); i++) {
			HotelEvaluationVO temp = commentList.get(i);
			dataList.add(new EvaluationTable(temp.guestID, Double.toString(temp.score), temp.comment));
		}

		ObservableList<EvaluationTable> data = FXCollections.observableArrayList();
		for (int i = 0; i < dataList.size(); i++) {
			data.add(dataList.get(i));
		}
		guestIDColumn.setCellValueFactory(cellData -> cellData.getValue().guestID);
		scoreColumn.setCellValueFactory(cellData -> cellData.getValue().score);
		commentColumn.setCellValueFactory(cellData -> cellData.getValue().comment);

		evaluationTable.setItems(data);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/30
	 * @param hotelVO
	 * @describe 初始化酒店详情
	 */
	private void initHotelDetail(HotelVO hotelVO) {

		hotelNameInDetail.setText(hotelVO.hotelName);
		hotelIDInDetail.setText(hotelVO.hotelID);
		hotelAddressInDetail.setText(hotelVO.address);
		cityInDetail.setText(hotelVO.city);
		cycleInDetail.setText(hotelVO.circle);
		levelInDetail.setText(hotelVO.level);
		scoreInDetail.setText(Double.toString(hotelVO.score));
		equipmentInDetail.setText(hotelVO.equipment);
		introductionInDetail.setText(hotelVO.introduction);
	}
	@FXML
	private Label hotelIDText,scoreText;
	@FXML
	private TextField hotelNameText,hotelAddressText,equipmentText,introductionText;
	@FXML
	private ComboBox<String> cityText,cycleText,levelText;
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
	 * @describe 点击修改按钮，显示可编辑的界面，内容为酒店详情
	 * 同时得初始化城市的下拉框以供选择
	 */
	@FXML
	protected void modify() {

		HotelVO hotelVO = hotelBLController.getHotelInfo(hotelID);
		
		hotelNameText.setText(hotelVO.hotelName);
		hotelIDText.setText(hotelVO.hotelID);
		hotelAddressText.setText(hotelVO.address);
		cityText.setValue(hotelVO.city);
		cycleText.setValue(hotelVO.circle);
		levelText.setValue(hotelVO.level);
		scoreText.setText(Double.toString(hotelVO.score));
		equipmentText.setText(hotelVO.equipment);
		introductionText.setText(hotelVO.introduction);

		hotelModifyPane.setVisible(true);
		hotelInfoPane.setVisible(false);
	}
	/**
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/6
	 * @describe 点击城市按钮
	 */
	@FXML
	protected void getCity(){

		//TODO 将当前酒店的城市从list中出去，然后逐一添加到combobox中
		
		cityText.getItems().add("1234");
		cityText.getItems().add("1234");
		cityText.getItems().add("1234");
		cityText.getItems().add("1234");

		//TODO 当新的城市被选点选时，cycletext需要被更新为当前city的所有的circle，并设值为第一个circle，从list除去
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
	 * @describe 点击商圈按钮
	 */
	@FXML
	protected void getCycle(){
		
		//TODO 通过当前city，获得当前城市所有的cycle，并将此酒店的circle从list中除去,不知道在哪个controller里面
		String city = cityText.getValue();


		cycleText.getItems().add("1234");
		cycleText.getItems().add("1234");
		cycleText.getItems().add("1234");
		cycleText.getItems().add("1234");
		cycleText.getItems().add("1234");
	}
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
	 * @describe 点击星级按钮
	 */
	@FXML
	protected void getLevel(){
		levelText.getItems().clear();
		for(int i =1;i <= 5;i++ ){
			levelText.getItems().add(""+i);
		}
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
	 * @describe 点击保存按钮
	 */
	@FXML
	protected void save() {

		HotelVO hotelVO = new HotelVO();
		
		hotelVO.hotelName=hotelNameText.getText();
		hotelVO.address=hotelAddressText.getText();
		hotelVO.city=cityText.getValue();
		hotelVO.circle=cycleText.getValue();
		hotelVO.level=levelText.getValue();
		hotelVO.equipment=equipmentText.getText();
		hotelVO.introduction=introductionText.getText();
		
		//TODO 调用更新酒店信息的方法
		hotelBLController.updateHotelInfo(hotelVO);
		initHotelDetail(hotelVO);

		hotelModifyPane.setVisible(false);
		
		hotelInfoPane.setVisible(true);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/12/6
	 * @describe 点击取消按钮
	 */
	@FXML
	protected void cancel() {
		hotelModifyPane.setVisible(false);
		initHotelDetail(hotelBLController.getHotelInfo(hotelID));
		hotelInfoPane.setVisible(true);
	}
}
