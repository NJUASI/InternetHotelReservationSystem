package businessLogic.hotelBL.hotelScan;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataService.hotelDataService.HotelDataService;
import dataService.hotelDataService.HotelDataService_Stub;
import po.HotelGeneralPO;
import utilities.SortStrategy;
import vo.AddressVO;
import vo.HotelGeneralVO;

public class HotelScan {

	HotelDataService hotelDataService;
	
	//用以保存处于当前城市商圈的所有酒店概况
	List<HotelGeneralPO> hotelGeneralPOList;
	
	//用以保存符合当前搜索条件的所有酒店概况
	List<HotelGeneralPO> currentGeneralPOList;
	
	//各个搜索器的工厂
	SortComparatorFactory sortComparatorFactory; 
	
	public HotelScan() {
		hotelDataService = new HotelDataService_Stub();
		sortComparatorFactory = new SortComparatorFactory();
	}

	/**
	 * @Description:根据城市商圈的信息查找所有位于该城市商圈的酒店
	 * @param addressVO
	 * @return
	 * Iterator<HotelGeneralVO>
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午9:01:13
	 */
	public Iterator<HotelGeneralVO> getHotels(AddressVO addressVO){
		try {
			hotelGeneralPOList = hotelDataService.getHotelGeneralList(addressVO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		currentGeneralPOList = hotelGeneralPOList;
		return convertPOListToVOList(currentGeneralPOList).iterator();
	}
	
	/**
	 * @Description:根据传入的SortStrategy的enum值，对当前hotelList排序
	 * @param sortStrategy
	 * @return
	 * Iterator<HotelGeneralVO>
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午9:24:12
	 */
	public Iterator<HotelGeneralVO> sortHotels(SortStrategy sortStrategy){
		List<HotelGeneralVO> hotelGeneralVOList = convertPOListToVOList(currentGeneralPOList);
		hotelGeneralVOList.sort(sortComparatorFactory.createComparator(sortStrategy));
		return hotelGeneralVOList.iterator();
	}
	
	
	/**
	 * @Description:根据传入的搜索标准对当前currentGeneralPOList进行筛选
	 * @param searchCriteria
	 * @return
	 * Iterator<HotelGeneralVO>
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午8:33:25
	 */
	public Iterator<HotelGeneralVO> searchHotels(List<SearchCriteria> searchCriteria) {
		for(int i = 0;i < searchCriteria.size();i++){
			currentGeneralPOList = searchCriteria.get(i).meetCriteria(currentGeneralPOList);
		}
		return convertPOListToVOList(currentGeneralPOList).iterator();
	}
	
	public Iterator<HotelGeneralVO> getBookedList(){
		
		//TODO
		
		return null;
	}
	
	/**
	 * @Description:因为几乎所有方法都会将poList转换为voList的Iterator，就将该方法提取出来
	 * @param generalPOList
	 * @return
	 * Iterator<HotelGeneralVO>
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午8:44:07
	 */
	private List<HotelGeneralVO> convertPOListToVOList(List<HotelGeneralPO> generalPOList){
		List<HotelGeneralVO> hotelGeneralVOList = new ArrayList<HotelGeneralVO>();
		for(HotelGeneralPO hotelGeneralPO:currentGeneralPOList){
			hotelGeneralVOList.add(new HotelGeneralVO(hotelGeneralPO));
		}
		return hotelGeneralVOList;
	}
	
}
