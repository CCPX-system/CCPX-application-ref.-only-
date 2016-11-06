/**
 * 
 */
package model;

/**
 * @author KEN
 *
 */
@SuppressWarnings("serial")
public class Seller_transferInfoBean {

	private String name;
	private String password;
	private String trade_type;
	private int points;
	private String seller_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	@Override
	public String toString() {
		return "Seller_transferInfoBean [name=" + name + ", password="
				+ password + ", trade_type=" + trade_type + ", points="
				+ points + ", seller_id=" + seller_id + "]";
	}
	
	
}
