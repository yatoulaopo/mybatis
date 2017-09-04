package ssm.po;

import java.util.List;

public class Orders {
    private String id;

    private Integer user_id;
    //多对多resultMap方式，用户、订单、订单项、商品
    private List<Ordersdetail> listOrdersdetail;

    public List<Ordersdetail> getListOrdersdetail() {
		return listOrdersdetail;
	}
	public void setListOrdersdetail(List<Ordersdetail> listOrdersdetail) {
		this.listOrdersdetail = listOrdersdetail;
	}
	private String createTime;
    public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	//resultMap方式实现：一对一
    private User user;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

   
}