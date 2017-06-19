package bi;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import bi.baiqiu.utils.ExportExcelUtils;

public class ExportTest {
	public static void main(String[] args) throws FileNotFoundException {
		ExportExcelUtils util=new ExportExcelUtils();  
		Date date=new Date();  
//		String strDate=DateUtil.dateFormat("yyyy/MM/dd", date);  
		//String path=ParameterConstants.UPLOAD_FILE_PATH+"excel/skcx/"+strDate+"/";  
		String path="C:";
		String fileName=date.getTime()+".xlsx";  
		  
		util.init_Excel(path,fileName, new String[]{"日期","时间","处理时间","编号","状态","金额"});  
		String[] datefiles=new String[]{"billDueDate","insertedTime","processTime","userNo","results","money"};//对象的属性名字  
		  
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
	}
}
