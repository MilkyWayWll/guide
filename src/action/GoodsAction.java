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
	
	private File photo;		//��ȡ�ϴ��ļ�
	private String photoFileName; //��ȡ�ϴ��ļ�����

	//��ȡ������Ϣ
	public String getAll(){
		getRequest().put("goods", goodsService.getAll());
		return "goodslist";
	}
	
	//���ҳ��
	public String addpage(){
		getRequest().put("brands", brandService.getAll());
		getRequest().put("categories", categoryService.getAll());
		return "addpage";
	}
	
	//���
	public String add(){
		if (photo != null) {
			fileUpload();	//�ϴ�ͼƬ
		}
		goodsService.add(goods);
		return "regoodslist";
	}
	
	//ɾ��
	public String delete(){
		goodsService.delete(goods);
		return "regoodslist";
	}
	
	//�޸�ҳ��
	public String updatepage() {
		getRequest().put("goods",goodsService.getGoods(goods));
		getRequest().put("brands", brandService.getAll());
		getRequest().put("categories", categoryService.getAll());
		return "updatepage";
	}
	
	//�޸�
	public String update(){
		if (photo!=null) {
			fileUpload();
		}
		goodsService.update(goods);
		return "regoodslist";
	}

	
	//�����ļ��ϴ�
	public void fileUpload(){
		
		//�ļ��洢·�� - ���Ե�ַ - eclipse��������ʱʹ��
//		String path = "E:/eclipse/workspace/eclipse-jee/guide2.0/WebContent/manage/upload/";
		String path = ServletActionContext.getServletContext().getRealPath("manage/upload/")+"\\";			
		
		//��ȡ��ǰ�ļ�����
		String type = photoFileName.substring(photoFileName.lastIndexOf(".")+1, photoFileName.length());
        //��ȡ��ǰϵͳʱ���ַ���
		String time = new SimpleDateFormat("yyMMddssSSS").format(new Date());
		//�������ļ���
		String newFileName = time+"."+type;
		//��ָ��·�������������ļ�
		File savefile = new File(path,newFileName);
		
		//�������ļ����ļ��в������򴴽�
		if (!savefile.getParentFile().exists()){
			savefile.getParentFile().mkdirs();
		}
		
		try {//���ϴ��ļ������ݸ��Ƶ��½��ļ���
			FileUtils.copyFile(photo, savefile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//��ͼƬ�ļ���ַ������Ʒ����
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
