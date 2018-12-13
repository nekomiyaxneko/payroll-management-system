package action.user;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class ImageCodeAction {
	//output
	private  InputStream imageStream;
	
	public String execute() throws Exception{
		//动态生成一个图片
//		try{
			Map<String,BufferedImage> map = 
					ImageUtil.createImage();
			//获取图片字符，写入session，为校验做准备
			String code = 
				map.keySet().iterator().next();
			Map session = 
				ActionContext.getContext().getSession();
			session.put("number", code);
			//将图片对象给imageStream赋值
			BufferedImage image = map.get(code);
			imageStream = ImageUtil.getInputStream(image);
			return "success";//交给stream类型result负责输出
//		}catch(Exception ex){
//			ex.printStackTrace();
//			return "error";
//		}
	}
	
	

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
}
