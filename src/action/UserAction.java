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

	public String login(){//自定义方法 - 自动执行(通过!login访问时)
		if(userService.isValidate(user)){
			user.setPosition(userService.getPosition(user));
			getSession().put("user", user);
			return "success";
		}else{
			addActionMessage("username or password is error!");
			return "input";
		}
	}
	
	//获取所有信息
	public String getAll(){
		getRequest().put("users", userService.getAllUser());
		return "userlist";
	}
	
	//添加页面
	public String addpage(){
		getRequest().put("positions", userService.getPositions());
		return "addpage";
	}
	//添加
	public String add(){
		if (userService.isUser(user)) {
			getRequest().put("msg", "用户名已存在!");
			getRequest().put("positions", userService.getPositions());
			return "addpage";
		}else {
			userService.addUser(user);
			return "reuserlist";	
		}
	}
	
	//删除
	public String delete(){
		userService.deleteUser(user);
		return "reuserlist";
	}
	
	//修改页面
	public String updatepage(){
		getRequest().put("user", userService.getUser(user));
		getRequest().put("positions", userService.getPositions());
		return "updatepage";
	}
	
	//修改
	public String update(){
		userService.updateUser(user);
		return "reuserlist";
	}

	
	
	//使用struts2自动装配数据 - 必写
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
}
