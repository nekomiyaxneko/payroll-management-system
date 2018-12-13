package util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Calendar c=Calendar.getInstance();
		Integer month=c.get(Calendar.MONTH)+1;
		
		List monthList =new ArrayList();
		for(int i=1;i<=12;i++){
			monthList.add(i);
		}
		System.out.println(monthList.toString());
	}
}
