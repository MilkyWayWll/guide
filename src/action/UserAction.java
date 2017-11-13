package action;

import model.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import service.UserService;

@Action("user")
@Results({
	@Result(name="success",location="/manage/main.jsp"),
	@Result(name="input",location="/guide/login.jsp"),
	@Result(name="userlist",location="/manage/pages/user-list.jsp"),
	@Result(name="addpage",location="/manage/pages/user-add.jsp"),
	@Result(name="updatepage",location="/manage/pages/user-update.jsp"),
	@Result(name="reuserlist",type="redirect",location="user!getAll.action")
})
public class UserAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	private User user;

	public String login(){//�Զ��巽�� - �Զ�ִ��(ͨ��!login����ʱ)
		if(userService.isValidate(user)){
			user.setPosition(userService.getPosition(user));
			getSession().put("user", user);
			return "success";
		}else{
			addActionMessage("username or password is error!");
			return "input";
		}
	}
	
	//��ȡ������Ϣ
	public String getAll(){
		getRequest().put("users", userService.getAllUser());
		return "userlist";
	}
	
	//���ҳ��
	public String addpage(){
		getRequest().put("positions", userService.getPositions());
		return "addpage";
	}
	//���
	public String add(){
		if (userService.isUser(user)) {
			getRequest().put("msg", "�û����Ѵ���!");
			getRequest().put("positions", userService.getPositions());
			return "addpage";
		}else {
			userService.addUser(user);
			return "reuserlist";	
		}
	}
	
	//ɾ��
	public String delete(){
		userService.deleteUser(user);
		return "reuserlist";
	}
	
	//�޸�ҳ��
	public String updatepage(){
		getRequest().put("user", userService.getUser(user));
		getRequest().put("positions", userService.getPositions());
		return "updatepage";
	}
	
	//�޸�
	public String update(){
		userService.updateUser(user);
		return "reuserlist";
	}

	
	
	//ʹ��struts2�Զ�װ������ - ��д
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
}
