package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * action基类继承了ActionSupport类  
 * 为使用action对象实现了SessionAware,RequestAware接口
 * 为使用HttpServlet对象实现了ServletRequestAware,ServletResponseAware接口
 * 另提供了获取HttpSess的方法
 * @author YJ
 */

public class BaseAction extends ActionSupport implements SessionAware, RequestAware, ServletRequestAware, ServletResponseAware{

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private HttpServletRequest servletRequest;
	private HttpServletResponse servletResponse;
	
	@Override//重写自父接口SessionAware的方法,有容器自行调用并给session对象赋值
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Override//重写自父接口RequestAware的方法,有容器自行调用并给request对象赋值
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	@Override//重写自父接口ServletRequestAware的方法,有容器自行调用并给Servletrequest对象赋值
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
		
	}
	
	@Override//重写自父接口ServletResponseAware的方法,有容器自行调用并给Servletresponse对象赋值
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}

	//用于在子类中获取session对象
	public Map<String, Object> getSession(){
		return session;
	}
	
	//用于在子类中获取request对象
	public Map<String, Object> getRequest(){
		return request;
	}
	
	//用于在子类中获取servletRequest对象
	public HttpServletRequest getServletRequest(){
		return servletRequest;
	}
	
	//用于在子类中获取servletResponse对象
	public HttpServletResponse getServletResponse(){
		servletResponse.setCharacterEncoding("utf-8");
		return servletResponse;
	}

	//用于在子类中获取HttpSession对象
	public HttpSession getHttpSession(){
		return getServletRequest().getSession();
	}



}
