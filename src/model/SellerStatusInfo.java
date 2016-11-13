/**
 * 
 */
package model;

/**
 * @author KEN
 *
 */
public class SellerStatusInfo {
	public final static int SUCCESS = 0;
	public final static int FAILED = 1;

	public final static String SUCCESS_MSG = "success";
	
	private int status = SUCCESS;
	private String msg = SUCCESS_MSG;
	private Object data ;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "SellerStatusInfo [status=" + status + ", msg=" + msg
				+ ", data=" + data + "]";
	}
	
	
	
	
	
}
