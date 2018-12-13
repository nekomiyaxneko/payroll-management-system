package action.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public final class ImageUtil {
//	private static final String[] chars = { "0", "1", "2", "3", "4", "5", "6",
//			"7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "东",
//			"南", "西", "北", "中", "发", "白" };
	private static final String[] chars = { "0", "1", "2", "3", "4", "5", "6",
		"7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I"};
	private static final int SIZE = 5;
	private static final int LINES = 20;
	private static final int WIDTH = 200;
	private static final int HEIGHT = 100;
	private static final int FONT_SIZE = 30;
	
	public static Map<String,BufferedImage> createImage() {
		StringBuffer sb = new StringBuffer();
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphic = image.getGraphics();
		graphic.setColor(Color.LIGHT_GRAY);
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		Random ran = new Random();
		//画随机字符
		for(int i=1;i<=SIZE;i++){
			
			int r = ran.nextInt(chars.length);
//			graphic.setColor(getRandomColor());
			graphic.setColor(new Color(0,0,0));
			graphic.setFont(new Font(null,Font.BOLD+Font.ITALIC,FONT_SIZE));
			graphic.drawString(chars[r],(i-1)*WIDTH/SIZE , HEIGHT/2);
			sb.append(chars[r]);//将字符保存，存入Session
		}
		//画干扰线
		for(int i=1;i<=LINES;i++){
			graphic.setColor(getRandomColor());
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH),ran.nextInt(HEIGHT));
		}
		Map<String,BufferedImage> map = new HashMap<String,BufferedImage>();
		map.put(sb.toString(), image);
		return map;
	}
	
	public static InputStream getInputStream(
			BufferedImage image) throws Exception{
			//将图片给imageStream赋值
			ByteArrayOutputStream bos = 
					new ByteArrayOutputStream();
			JPEGImageEncoder jpegCoder = 
				JPEGCodec.createJPEGEncoder(bos);
			jpegCoder.encode(image);
			//获取压缩处理后的图片信息
			byte[] bys = bos.toByteArray();
			return new ByteArrayInputStream(bys);
	}
	
	public static Color getRandomColor(){
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256));
		return color;
	}
}
