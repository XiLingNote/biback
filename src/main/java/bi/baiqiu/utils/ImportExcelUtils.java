package bi.baiqiu.utils;
import java.io.FileOutputStream;
import java.io.IOException;  
import java.io.InputStream;  
import java.text.DecimalFormat;  
import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.List; 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
/**
 * excel解析类
 * @author Administrator
 *
 */
public class ImportExcelUtils {  
  
  private final static String excel2003L =".xls";  //2003- 版本的excel  
  private final static String excel2007U =".xlsx"; //2007+ 版本的excel  
  
  /** 
   * 描述：获取IO流中的数据，组装成List<List<Object>>对象 
   * @param in,fileName 
   * @return 
   * @throws IOException  
   */  
  public  List<List<Object>> getBankListByExcel(InputStream in,String fileName) throws Exception{  
    List<List<Object>> list = null;  
    
    //创建Excel工作薄  
    Workbook work = this.getWorkbook(in,fileName);  
    if(null == work){  
    throw new Exception("创建Excel工作薄为空！");  
    }  
    Sheet sheet = null;  
    Row row = null;  
    Cell cell = null;  
    
    list = new ArrayList<List<Object>>();  
    //遍历Excel中所有的sheet  
    for (int i = 0; i < work.getNumberOfSheets(); i++) {  
    sheet = work.getSheetAt(i);  
    if(sheet==null){continue;}  
      
    //遍历当前sheet中的所有行  
    for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum(); j++) {  
      row = sheet.getRow(j);  
      if(row==null||row.getFirstCellNum()==j){continue;}  
      
      //遍历所有的列  
      List<Object> li = new ArrayList<Object>();  
      for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {  
        cell = row.getCell(y);  
        li.add(this.getCellValue(cell));  
      }  
      list.add(li);  
    }  
    }  
    work.close();  
    return list;  
  }  
  
  /** 
   * 描述：根据文件后缀，自适应上传文件的版本  
   * @param inStr,fileName 
   * @return 
   * @throws Exception 
   */  
  public  Workbook getWorkbook(InputStream inStr,String fileName) throws Exception{  
    Workbook wb = null;  
    String fileType = fileName.substring(fileName.lastIndexOf("."));  
    if(excel2003L.equals(fileType)){  
    wb = new HSSFWorkbook(inStr);  //2003-  
    }else if(excel2007U.equals(fileType)){  
    wb = new XSSFWorkbook(inStr);  //2007+  
    }else{  
    throw new Exception("解析的文件格式有误！");  
    }  
    return wb;  
  }  
  
  /** 
   * 描述：对表格中数值进行格式化 
   * @param cell 
   * @return 
   */  
  public  Object getCellValue(Cell cell){  
    Object value = null;  
    DecimalFormat df = new DecimalFormat("0");  //格式化number String字符  
    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化  
    DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字  
    
    switch (cell.getCellType()) {  
    case Cell.CELL_TYPE_STRING:  
    value = cell.getRichStringCellValue().getString();  
    break;  
    case Cell.CELL_TYPE_NUMERIC:  
    if("General".equals(cell.getCellStyle().getDataFormatString())){  
      value = df.format(cell.getNumericCellValue());  
    }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){  
      value = sdf.format(cell.getDateCellValue());  
    }else{  
      value = df2.format(cell.getNumericCellValue());  
    }  
    break;  
    case Cell.CELL_TYPE_BOOLEAN:  
    value = cell.getBooleanCellValue();  
    break;  
    case Cell.CELL_TYPE_BLANK:  
    value = "";  
    break;  
    default:  
    break;  
    }  
    return value;  
  }  
    /**2007以上的数据
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {  
	          //创建基于stream的工作薄对象的  
	          Workbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk  
	          //SXSSFWorkbook wb = new SXSSFWorkbook();   
	          //wb.setCompressTempFiles(true); // temp files will be gzipped  
	          Sheet sh = wb.createSheet();  
	          //使用createRow将信息写在内存中。  
	          for(int rownum = 0; rownum < 1000; rownum++){  
	              Row row = sh.createRow(rownum);  
	              for(int cellnum = 0; cellnum < 10; cellnum++){  
	                  Cell cell = row.createCell(cellnum);  
	                  String address = new CellReference(cell).formatAsString();  
	                  cell.setCellValue(address);  
	              }  
	    
	          }  
	    
	          // Rows with rownum < 900 are flushed and not accessible  
	          //当使用getRow方法访问的时候，将内存中的信息刷新到硬盘中去。  
	          for(int rownum = 0; rownum < 900; rownum++){  
	            System.out.println(sh.getRow(rownum));  
	          }  
	    
	          // ther last 100 rows are still in memory  
	          for(int rownum = 900; rownum < 1000; rownum++){  
	              System.out.println(sh.getRow(rownum));  
	          }  
	          //写入文件中  
	          FileOutputStream out = new FileOutputStream("C://sxssf.xlsx");  
	          wb.write(out);  
	          //关闭文件流对象  
	          out.close();  
	          System.out.println("基于流写入执行完毕!");  
	      }  
	  }  
  