package dataService.sourceDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Iterator;

public interface SourceDataService extends Remote {
	
	
	/**
	 * @Description:获取该系统覆盖的所有城市
	 * @return
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 下午4:59:17
	 */
	public Iterator<String> getCities() throws RemoteException;
	
	
	/**
	 * @Description:根据选中的城市，获取该城市内，系统支持的所有商圈
	 * @param city
	 * @return
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 下午6:46:45
	 */
	public Iterator<String> getCircles(String city) throws RemoteException;

	/**
	 * @Description:获取该系统支持的所有酒店的星级
	 * @return
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 下午4:59:54
	 */
	public Iterator<String> getLevels() throws RemoteException;

	
	/**
	 * @Description:获取该系统支持的所有房间类型
	 * @return
	 * Iterator<String>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月7日 下午5:00:19
	 */
	public Iterator<String> getRoomTypes() throws RemoteException;
}
