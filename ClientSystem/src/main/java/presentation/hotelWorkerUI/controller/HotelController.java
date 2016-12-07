package presentation.hotelWorkerUI.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businessLogic.hotelBL.HotelBLController;
import businessLogic.orderBL.OrderBLController;
import businessLogic.sourceBL.SourceBLController;
import businessLogicService.hotelBLService.HotelBLService;
import businessLogicService.orderBLService.OrderBLService;
import businessLogicService.sourceBLService.SourceBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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

	HotelBLService hotelBLController;
	OrderBLService orderBLController;
	SourceBLService sourceBLController;
	String hotelID = IDReserve.getInstance().getUserID();

	public HotelController() {
		hotelBLController = HotelBLController.getInstance();
		orderBLController = OrderBLController.getInstance();
		sourceBLController = SourceBLController.getInstance();
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
	 * @updateTime 2016/12/7 
	 */
	@FXML
	private void initialize() {

		//显示酒店详情
		HotelVO hotelVO = hotelBLController.getHotelInfo(hotelID);
		initHotelDetail(hotelVO);

		//显示酒店的所有评论
		Iterator<HotelEvaluationVO> evaluations = orderBLController.getEvaluations(hotelID);
		commentList=new ArrayList<HotelEvaluationVO>();
		while(evaluations.hasNext()){
			commentList.add(evaluations.next());
		}
		initCommentTable(commentList);
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



	@FXML
	private Label hotelIDText,scoreText;
	@FXML	
	private TextArea equipmentText;
	@FXML
	private TextField hotelNameText,hotelAddressText,introductionText;
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

		System.out.println(hotelVO.circle);

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
	 * @updateTime 2016/12/7
	 * @describe 点击城市按钮
	 */
	@FXML
	protected void getCity(){

		//每次点击先清除一次
		cityText.getItems().clear();

		//TODO djy注意：将当前酒店的城市从list中出去，然后逐一添加到combobox中,所有城市的list保存在哪儿的
		Iterator<String> cities = sourceBLController.getCities();
		while(cities.hasNext()){
			cityText.getItems().add(cities.next());
		}

		//TODO gy注意：需要加上item被点选的监听,当新的城市被选点选时，cycletext需要被设值为第一个circle，从list除去
	}
	
	
	/**
	 * @description 点击商圈按钮,初始化选中城市的所有商圈
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void getCycle(){

		/**
		 *  TODO gy注意：每次都将value清空，对用户不友好，用户如果不想修改，
		 *  只是随意点了一下，就必须又去选择一次
		 *   TODO gcm 我试了他所有的监听，他fx内在的方法并不能监听选择之后再清空，就是监听不到换城市这个动作，你可以试试别的方法
		 * 
		 */
		
		cycleText.getItems().clear();

		Iterator<String> circles = sourceBLController.getCircles(cityText.getValue());
		while(circles.hasNext()){
			cycleText.getItems().add(circles.next());
		}
		
	}
	/**
	 * @description 点击星级按钮
	 * @author 61990
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 */
	@FXML
	protected void getLevel(){
		levelText.getItems().clear();
		Iterator<String> levels = sourceBLController.getLevels();
		while(levels.hasNext()){
			levelText.getItems().add(levels.next());
		}
	}

	/**
	 * @description 点击保存按钮
	 * @author 61990
	 * @lastChangedBy Harvey
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

		//TODO gcm注意：调用更新酒店信息的方法,可能会catch到exception，以后加入exception
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
