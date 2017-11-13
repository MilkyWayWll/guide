package action;

import model.Category;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import service.CategoryService;

@Action("category")
@Results({
	@Result(name="categorylist",location="/manage/pages/category-list.jsp"),
	@Result(name="recategorylist",type="redirect",location="category!getAll.action")
})
public class CategoryAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private CategoryService categoryService = new CategoryService();
	private Category category;

	//��ȡ������Ϣ
	public String getAll(){
		getRequest().put("categories", categoryService.getAll());
		return "categorylist";
	}
	
	//���
	public String add(){
		categoryService.add(category);
		return "recategorylist";
	}
	
	//ɾ��
	public String delete(){
		categoryService.delete(category);
		return "recategorylist";
	}
	
	//�޸�
	public String update(){
		categoryService.update(category);
		return "recategorylist";
	}

	
	
	
	
	
	
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	


	
	
}
