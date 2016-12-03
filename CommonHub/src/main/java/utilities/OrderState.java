package utilities;

import java.io.Serializable;

public enum OrderState implements Serializable{
	
	UNEXECUTED, EXECUTED, COMMENTED, ABNORMAL, CANCELLED; 
}
