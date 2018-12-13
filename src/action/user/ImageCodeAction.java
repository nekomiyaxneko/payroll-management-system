package action.user;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class ImageCodeAction {
	//output
	private  InputStream imageStream;
	
	public String execute() throws Exception{
		//��̬����һ��ͼƬ
//		try{
			Map<String,BufferedImage> map = 
					ImageUtil.createImage();
			//��ȡͼƬ�ַ���д��session��ΪУ����׼��
			String code = 
				map.keySet().iterator().next();
			Map session = 
				ActionContext.getContext().getSession();
			session.put("number", code);
			//��ͼƬ�����imageStream��ֵ
			BufferedImage image = map.get(code);
			imageStream = ImageUtil.getInputStream(image);
			return "success";//����stream����result�������
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
