package ssm.po;

import java.util.List;

public class UserQueryVo {
	//综合查询用的是包装类
	private UserCustom userCustom;
	private List<Integer> listId;

	public List<Integer> getListId() {
		return listId;
	}

	public void setListId(List<Integer> listId) {
		this.listId = listId;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
}
