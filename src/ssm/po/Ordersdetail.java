package ssm.po;

public class Ordersdetail {
    private Integer id;

    private String itemName;

    public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	private Integer num;

    private String orderId;

    private Integer items_id;
    
    public Integer getItems_id() {
		return items_id;
	}

	public void setItems_id(Integer items_id) {
		this.items_id = items_id;
	}

	private Items items;

    public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

 

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    
}