package ssm.po;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	private Integer id;
	private String username;
	private String city;
	private String country;
	//多对多：根据用户信息，关联订单，关联订单项，关联商品
	private List<Orders> listOrders;
	public List<Orders> getListOrders() {
		return listOrders;
	}
	public void setListOrders(List<Orders> listOrders) {
		this.listOrders = listOrders;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
