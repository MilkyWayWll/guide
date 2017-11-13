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

	//��ȡ������Ϣ
	public String getAll(){
		getRequest().put("brands", brandService.getAll());
		return "brandlist";
	}
	
	//���
	public String add(){
		brandService.add(brand);
		return "rebrandlist";
	}
	
	//ɾ��
	public String delete(){
		brandService.delete(brand);
		return "rebrandlist";
	}
	
	//�޸�
	public String update(){
		brandService.update(brand);
		return "rebrandlist";
	}
	
	
	
	
	//ʹ��struts2�Զ�װ������ - ��д
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	
	
}
