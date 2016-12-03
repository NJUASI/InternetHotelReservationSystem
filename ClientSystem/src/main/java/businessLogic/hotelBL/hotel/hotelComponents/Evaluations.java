package businessLogic.hotelBL.hotel.hotelComponents;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataService.hotelDataService.HotelDataService;
import po.HotelEvaluationPO;
import utilities.ResultMessage;
import vo.HotelEvaluationVO;

public class Evaluations {

	private String hotelID;
	private HotelDataService hotelDataService;
	private List<HotelEvaluationPO> evaluationList;
	
	public Evaluations(String hotelID, HotelDataService hotelDataService) {
		this.hotelID = hotelID;
		this.hotelDataService = hotelDataService;
		initEvaluations();
	}

	private void initEvaluations() {
		try {
			evaluationList = hotelDataService.getEvaluations(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public Iterator<HotelEvaluationVO> getEvaluations(){
		List<HotelEvaluationVO> evaluationsVOList = new ArrayList<HotelEvaluationVO>();
		
		for(HotelEvaluationPO evaluationPO:evaluationList){
			evaluationsVOList.add(new HotelEvaluationVO(evaluationPO));
		}
		
		return evaluationsVOList.iterator();
	}
	
//	public ResultMessage addEvaluation(EvaluationVO evaluationVO) {
//		
//		EvaluationPO evaluationPO = new EvaluationPO(evaluationVO);
//		evaluationList.add(evaluationPO);
//		try {
//			return hotelDataService.updateEvaluation(evaluationPO);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			return ResultMessage.FAIL;
//		}
//	}
	

}
