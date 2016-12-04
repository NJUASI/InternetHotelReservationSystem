package businessLogic.hotelBL.hotelScan;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.hotelBL.hotel.Rooms;
import dataService.hotelDataService.HotelDataService;
import dataService.hotelDataService.HotelDataService_Stub;
import po.HotelPO;
import utilities.SortStrategy;
import vo.HotelVO;

/**
 * @Description:浏览酒店的类，为酒店浏览及搜索提供排序及范围搜索的功能
 * @author:Harvey Gong
 * @time:2016年12月3日 下午9:55:35
 */
public class HotelScan {

	HotelDataService hotelDataService;
	
	//用以保存处于当前城市商圈的所有酒店概况
	List<HotelPO> hotelPOList;
	
	//用以保存符合当前搜索条件的所有酒店概况
	List<HotelPO> currentPOList;
	
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
	 * Iterator<HotelVO>
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午9:01:13
	 */
	public Iterator<HotelVO> getHotels(String city,String circle){
		try {
			hotelPOList = hotelDataService.getHotels(city,circle);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		currentPOList = hotelPOList;
		return convertPOListToVOList(currentPOList).iterator();
	}
	
	/**
	 * @Description:根据传入的SortStrategy的enum值，对当前hotelList排序
	 * @param sortStrategy
	 * @return
	 * Iterator<HotelGeneralVO>
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午9:24:12
	 */
	public Iterator<HotelVO> sortHotels(SortStrategy sortStrategy){
		List<HotelVO> hotelVOList = convertPOListToVOList(currentPOList);
		hotelVOList.sort(sortComparatorFactory.createComparator(sortStrategy));
		return hotelVOList.iterator();
	}
	
	/**
	 * @Description:根据传入的搜索标准对当前currentGeneralPOList进行筛选
	 * @param searchCriteria
	 * @return
	 * Iterator<HotelGeneralVO>
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午8:33:25
	 */
	public Iterator<HotelVO> searchHotels(List<SearchCriteria> searchCriteria) {
		for(int i = 0;i < searchCriteria.size();i++){
			currentPOList = searchCriteria.get(i).meetCriteria(currentPOList);
		}
		return convertPOListToVOList(currentPOList).iterator();
	}
	
	/**
	 * @Description:因为几乎所有方法都会将poList转换为voList的Iterator，就将该方法提取出来
	 * @param generalPOList
	 * @return
	 * Iterator<HotelGeneralVO>
	 * @author: Harvey Gong
	 * @time:2016年11月29日 下午8:44:07
	 */
	private List<HotelVO> convertPOListToVOList(List<HotelPO> POList){
		List<HotelVO> hotelVOList = new ArrayList<HotelVO>();
		for(HotelPO hotelGeneralPO:currentPOList){
			double minPrice = new Rooms(hotelGeneralPO.getHotelID()).getLowestPrice();
			hotelVOList.add(new HotelVO(hotelGeneralPO,minPrice));
		}
		return hotelVOList;
	}
	
}
