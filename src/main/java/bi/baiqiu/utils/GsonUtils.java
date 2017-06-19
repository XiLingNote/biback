package bi.baiqiu.utils;

import com.google.gson.Gson;

public class GsonUtils {
	public static Gson gson = new Gson(); 
	
	public static Gson getInstance(){
		
		return gson;
	}
}
