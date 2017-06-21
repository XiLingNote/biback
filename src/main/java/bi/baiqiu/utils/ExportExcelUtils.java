package bi.baiqiu.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

import com.google.common.base.Strings;

public class ExportExcelUtils {

	private FileOutputStream output;
	private Sheet sheet;
	private SXSSFWorkbook wb;
	private Integer countRow = 0;
	private Map<String, PropertyDescriptor> objPropertyMap;

	/**
	 * 初始化
	 * 
	 * @param xls_write_Address
	 * @param fieldNames
	 * @throws FileNotFoundException
	 */
	public void init_Excel(String path, String fileName, String[] fieldNames) throws FileNotFoundException {

		File pathfile = new File(path);
		if (!pathfile.exists()) {
			pathfile.mkdirs();
		}

		output = new FileOutputStream(new File(path + fileName)); // 读取的文件路径
		wb = new SXSSFWorkbook(1000);// 内存中保留 10000 条数据，以免内存溢出，其余写入 硬盘
		sheet = wb.createSheet(String.valueOf("sheet"));
		wb.setSheetName(0, "sheet");
		Row row = sheet.createRow(countRow++);
		for (int i = 0; i < fieldNames.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellType(XSSFCell.CELL_TYPE_STRING);// 文本格式
			// sheet.setColumnWidth(i, fieldNames[i].length()*384); //设置单元格宽度
			cell.setCellValue(fieldNames[i]);// 写入内容
		}

	}

	/**
	 * 
	 * @param datalist
	 * @param dataFields
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IOException
	 * @throws IntrospectionException
	 */
	public void write_data_Excel(List<Object> datalist, String[] dataFields) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException, IntrospectionException {
		write_data_Excel(datalist, dataFields, null, null);
	}

	public void write_data_Excel(List<Object> datalist, String[] dataFields, Map<String, Map<String, String>> dataDic)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException,
			IntrospectionException {
		write_data_Excel(datalist, dataFields, dataDic, null);
	}

	/**
	 * 写数据
	 * 
	 * @param datalist
	 * @param dataFields
	 * @throws IOException
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public void write_data_Excel(List<Object> datalist, String[] dataFields, Map<String, Map<String, String>> dataDic,
			Map<String, Integer> dataFormat) throws IOException, IntrospectionException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		ZipSecureFile.setMinInflateRatio(0l);

		for (int i = 0; i < datalist.size(); i++) {
			Row row = sheet.createRow(countRow++);
			Object obj = datalist.get(i);
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			if (objPropertyMap == null) {
				objPropertyMap = new HashMap<String, PropertyDescriptor>();
				for (PropertyDescriptor des : propertyDescriptors) {
					objPropertyMap.put(des.getName(), des);
				}
			}
			for (int cols = 0; cols < dataFields.length; cols++) {
				String dataField = dataFields[cols];
				Object value = "";
				if (objPropertyMap.get(dataField) != null) {
					// 得到property对应的getter方法
					Method gettter = objPropertyMap.get(dataField).getReadMethod();
					value = gettter.invoke(obj);
					if (value instanceof Date) {
						Date date = (Date) value;
						// 格式化日期
						value = value.toString().replaceAll(" 00:00:00", "");
						// 数据字典的匹配
					} else {
						if (dataDic != null && dataDic.get(dataField) != null) {
							value = dataDic.get(dataField).get(value + "");
						}
					}
				}

				if (value == null) {
					value = "";
				}
				Cell cell = row.createCell(cols);

				if (dataFormat != null && dataFormat.get(dataField) != null) {
					int format = dataFormat.get(dataField);

					switch (format) {
					case 10:
						cell.setCellStyle(cellStyle);
						cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);// 数字格式
						if (!Strings.isNullOrEmpty(value.toString())) {
							cell.setCellValue(Double.valueOf(value.toString()));// 写入内容
						}
						break;
					case XSSFCell.CELL_TYPE_NUMERIC:
						cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);// 数字格式
						if (!Strings.isNullOrEmpty(value.toString())) {
							cell.setCellValue(Double.valueOf(value.toString()));// 写入内容
						}
						break;
					}

				} else {
					cell.setCellType(XSSFCell.CELL_TYPE_STRING);// 文本格式
					cell.setCellValue(value.toString());// 写入内容
				}

				// sheet.setColumnWidth(cols, value.toString().length()*384);
				// //设置单元格宽度

			}
		}

	}

	/**
	 * 写文件
	 * 
	 * @throws IOException
	 */
	public void write_excel_disk() throws IOException {
		wb.write(output);
		output.close();
	}
	//文件下载
	public void downLoad(String filePath, HttpServletResponse response,  
            boolean isOnLine) throws Exception {  
        File f = new File(filePath);  
        /*  
         * if (!f.exists()) { response.sendError(404, "File not found!");  
         * return; }  
         */  
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));  
        byte[] buf = new byte[1024];  
        int len = 0;  
        response.reset(); // 非常重要  
        // 在线打开方式  
        if (isOnLine) {  
            URL u = new URL(filePath);  
            response.setContentType(u.openConnection().getContentType());  
            response.setHeader("Content-Disposition", "inline; filename="  
                    + toUTF8(f.getName()));  
            // 文件名应该编码成UTF-8  
        }  
        // 纯下载方式  
        else {  
            response.setContentType("application/x-msdownload");  
            response.setHeader("Content-Disposition", "attachment; filename="  
                    + toUTF8(f.getName()));  
        }  
        OutputStream out = response.getOutputStream();  
        while ((len = br.read(buf)) > 0)  
            out.write(buf, 0, len);  
        out.flush();  
        br.close();  
        out.close();  
    } 
	  public String toUTF8(String s) {  
	        StringBuffer sb = new StringBuffer();  
	        for (int i = 0; i < s.length(); i++) {  
	            char c = s.charAt(i);  
	            if (c >= 0 && c <= 255) {  
	                sb.append(c);  
	            } else {  
	                byte[] b;  
	                try {  
	                    b = Character.toString(c).getBytes("utf-8");  
	                } catch (Exception ex) {  
	                    System.out.println(ex);  
	                    b = new byte[0];  
	                }  
	                for (int j = 0; j < b.length; j++) {  
	                    int k = b[j];  
	                    if (k < 0)  
	                        k += 256;  
	                    sb.append("%" + Integer.toHexString(k).toUpperCase());  
	                }  
	            }  
	        }  
	        return sb.toString();  
	    } 
}