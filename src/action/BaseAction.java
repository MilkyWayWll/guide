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
 * action����̳���ActionSupport��  
 * Ϊʹ��action����ʵ����SessionAware,RequestAware�ӿ�
 * Ϊʹ��HttpServlet����ʵ����ServletRequestAware,ServletResponseAware�ӿ�
 * ���ṩ�˻�ȡHttpSess�ķ���
 * @author YJ
 */

public class BaseAction extends ActionSupport implements SessionAware, RequestAware, ServletRequestAware, ServletResponseAware{

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private HttpServletRequest servletRequest;
	private HttpServletResponse servletResponse;
	
	@Override//��д�Ը��ӿ�SessionAware�ķ���,���������е��ò���session����ֵ
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Override//��д�Ը��ӿ�RequestAware�ķ���,���������е��ò���request����ֵ
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	@Override//��д�Ը��ӿ�ServletRequestAware�ķ���,���������е��ò���Servletrequest����ֵ
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
		
	}
	
	@Override//��д�Ը��ӿ�ServletResponseAware�ķ���,���������е��ò���Servletresponse����ֵ
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}

	//�����������л�ȡsession����
	public Map<String, Object> getSession(){
		return session;
	}
	
	//�����������л�ȡrequest����
	public Map<String, Object> getRequest(){
		return request;
	}
	
	//�����������л�ȡservletRequest����
	public HttpServletRequest getServletRequest(){
		return servletRequest;
	}
	
	//�����������л�ȡservletResponse����
	public HttpServletResponse getServletResponse(){
		servletResponse.setCharacterEncoding("utf-8");
		return servletResponse;
	}

	//�����������л�ȡHttpSession����
	public HttpSession getHttpSession(){
		return getServletRequest().getSession();
	}



}
