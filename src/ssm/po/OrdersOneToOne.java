package ssm.po;
/**
 * resultType实现一对一，方法是用第3方类去继承列多的，然后把列少的类的列全部直接声明进来。
 * @author Administrator
 *
 */
public class OrdersOneToOne extends Orders{
    //把列少类的列声明进来
	private String username;
	private String city;
	private String country;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}