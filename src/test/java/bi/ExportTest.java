package bi;

import java.beans.IntrospectionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bi.baiqiu.pojo.DailyTarget;
import bi.baiqiu.utils.ExportExcelUtils;

public class ExportTest {
	public void exportDaily(){
		ExportExcelUtils util=new ExportExcelUtils();  
		Date date=new Date();  
//		String strDate=DateUtil.dateFormat("yyyy/MM/dd", date);  
		//String path=ParameterConstants.UPLOAD_FILE_PATH+"excel/skcx/"+strDate+"/";  
		String path="C:";
		String fileName=date.getTime()+".xlsx";  
	}
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, IntrospectionException {
		ExportExcelUtils util=new ExportExcelUtils();  
		Date date=new Date();  
//		String strDate=DateUtil.dateFormat("yyyy/MM/dd", date);  
		//String path=ParameterConstants.UPLOAD_FILE_PATH+"excel/skcx/"+strDate+"/";  
		String path="C:";
		String fileName=date.getTime()+".xlsx";  
		  
		util.init_Excel(path,fileName, new String[]{"id","店铺","时间","目标计划数"});  
		String[] datefiles=new String[]{"billDueDate","insertedTime","processTime","userNo","results","money"};//对象的属性名字  
		String[] dailyfiles=new String[]{"id","storename","date","payment"};//对象的属性名字    
		/** 
		 * 定义数据字典 
		 */  
		Map<String, String> resultsMap=new HashMap<String, String>();  
		resultsMap.put("0", "未处理");  
		resultsMap.put("1", "收款成功");  
		resultsMap.put("2", "收款失败");  
		Map<String, Map<String,String>> properyMap=new HashMap<String, Map<String,String>>();  
		properyMap.put("results", resultsMap);//可以多个  
		  
		/** 
		 * 定义数据格式 
		 */  
		Map <String,Integer> dataFormat =new HashMap<String,Integer>();  
		dataFormat.put("money", 10);//带两位小数数字  
		  
		int countPage=1;  
//		
		List<Object> dailys=new ArrayList<>();
		DailyTarget daily=new DailyTarget("test", "2017-01-01", "100");
	dailys.add(daily);
	dailys.add(daily);
		util.write_data_Excel(dailys,dailyfiles);
		util.write_excel_disk();
	}
}
