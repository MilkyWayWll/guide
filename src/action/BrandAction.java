package action;

import model.Brand;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import service.BrandService;

@Action("brand")
@Results({
	@Result(name="brandlist",location="/manage/pages/brand-list.jsp"),
	@Result(name="rebrandlist",type="redirect",location="brand!getAll.action")
})
public class BrandAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private BrandService brandService = new BrandService();
	private Brand brand;

	//获取所有信息
	public String getAll(){
		getRequest().put("brands", brandService.getAll());
		return "brandlist";
	}
	
	//添加
	public String add(){
		brandService.add(brand);
		return "rebrandlist";
	}
	
	//删除
	public String delete(){
		brandService.delete(brand);
		return "rebrandlist";
	}
	
	//修改
	public String update(){
		brandService.update(brand);
		return "rebrandlist";
	}
	
	
	
	
	//使用struts2自动装配数据 - 必写
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	
	
}
