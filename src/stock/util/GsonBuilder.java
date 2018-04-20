package stock.util;

import com.google.gson.Gson;
/**
 * This method serves as utility for data serialization;JSON string to Java Object conversions & vice-versa.
 * @author a1727212
 *
 */
public class GsonBuilder {
	 static Gson gson = new Gson();
	 
	 public static  String toJson(Object object){
		return gson.toJson(object);
	 }
}
