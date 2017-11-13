package action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Goods;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import service.BrandService;
import service.CategoryService;
import service.GoodsService;

@Action("goods")
@Results({
	@Result(name="goodslist",location="/manage/pages/goods-list.jsp"),
	@Result(name="addpage",location="/manage/pages/goods-add.jsp"),
	@Result(name="updatepage",location="/manage/pages/goods-update.jsp"),
	@Result(name="regoodslist",type="redirect",location="goods!getAll.action")
})
public class GoodsAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private GoodsService goodsService = new GoodsService();
	private BrandService brandService = new BrandService();
	private CategoryService categoryService = new CategoryService();
	private Goods goods;
	
	private File photo;		//获取上传文件
	private String photoFileName; //获取上传文件类型

	//获取所有信息
	public String getAll(){
		getRequest().put("goods", goodsService.getAll());
		return "goodslist";
	}
	
	//添加页面
	public String addpage(){
		getRequest().put("brands", brandService.getAll());
		getRequest().put("categories", categoryService.getAll());
		return "addpage";
	}
	
	//添加
	public String add(){
		if (photo != null) {
			fileUpload();	//上传图片
		}
		goodsService.add(goods);
		return "regoodslist";
	}
	
	//删除
	public String delete(){
		goodsService.delete(goods);
		return "regoodslist";
	}
	
	//修改页面
	public String updatepage() {
		getRequest().put("goods",goodsService.getGoods(goods));
		getRequest().put("brands", brandService.getAll());
		getRequest().put("categories", categoryService.getAll());
		return "updatepage";
	}
	
	//修改
	public String update(){
		if (photo!=null) {
			fileUpload();
		}
		goodsService.update(goods);
		return "regoodslist";
	}

	
	//处理文件上传
	public void fileUpload(){
		
		//文件存储路径 - 绝对地址 - eclipse开发中暂时使用
//		String path = "E:/eclipse/workspace/eclipse-jee/guide2.0/WebContent/manage/upload/";
		String path = ServletActionContext.getServletContext().getRealPath("manage/upload/")+"\\";			
		
		//获取当前文件类型
		String type = photoFileName.substring(photoFileName.lastIndexOf(".")+1, photoFileName.length());
        //获取当前系统时间字符串
		String time = new SimpleDateFormat("yyMMddssSSS").format(new Date());
		//构建新文件名
		String newFileName = time+"."+type;
		//按指定路径重命名构建文件
		File savefile = new File(path,newFileName);
		
		//若保存文件的文件夹不存在则创建
		if (!savefile.getParentFile().exists()){
			savefile.getParentFile().mkdirs();
		}
		
		try {//将上传文件的内容复制到新建文件中
			FileUtils.copyFile(photo, savefile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//将图片文件地址存入商品对象
		goods.setPhoto("manage/upload/"+newFileName);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}


	
	
}
