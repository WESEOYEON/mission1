package example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonParsing {
	public static long getFinal() {
		String key = "6359514f727773653635444751636c";
		String result = "";
		long totalCnt = 0;
		try {
			URL url = new URL ("http://openapi.seoul.go.kr:8088/" + key +"/json/TbPublicWifiInfo/1/1");
			
			BufferedReader bf;
			
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		
			result = bf.readLine();

        	JSONParser jsonParser = new JSONParser();
        	JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
        	JSONObject wifiInforesult = (JSONObject)jsonObject.get("TbPublicWifiInfo");
        	totalCnt = Long.parseLong(wifiInforesult.get("list_total_count").toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
    	return totalCnt;
	}
	
	public static void addDB (int start, int end) {
		String key = "6359514f727773653635444751636c";
		String result = "";
		try {
			URL url = new URL ("http://openapi.seoul.go.kr:8088/" + key +"/json/TbPublicWifiInfo/" + start +"/" + end);
			
			BufferedReader bf;
			
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		
			result = bf.readLine();

        	JSONParser jsonParser = new JSONParser();
        	JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
        	JSONObject wifiInforesult = (JSONObject)jsonObject.get("TbPublicWifiInfo");
        	JSONArray row = (JSONArray)wifiInforesult.get("row");
        	
        	List<wifiInfo> wifiList = new ArrayList<wifiInfo>();
                for(int i = 0; i < row.size(); i++) {
        		JSONObject info = (JSONObject)row.get(i);
        		String strJson = info.toString();
        		jsonParser = new JSONParser();
        		Object obj = jsonParser.parse(strJson);
        		JSONObject jsonObj = (JSONObject) obj;
        		Object X_SWIFI_MGR_NO = (Object)jsonObj.get("X_SWIFI_MGR_NO");
            	Object X_SWIFI_WRDOFC = (Object)jsonObj.get("X_SWIFI_WRDOFC");
            	Object X_SWIFI_MAIN_NM = (Object)info.get("X_SWIFI_MAIN_NM");
            	Object X_SWIFI_ADRES1 = (Object)info.get("X_SWIFI_ADRES1");
            	Object X_SWIFI_ADRES2 = (Object)info.get("X_SWIFI_ADRES2");
            	Object X_SWIFI_INSTL_FLOOR = (Object)info.get("X_SWIFI_INSTL_FLOOR");
            	Object X_SWIFI_INSTL_TY = (Object)info.get("X_SWIFI_INSTL_TY");
            	Object X_SWIFI_INSTL_MBY = (Object)info.get("X_SWIFI_INSTL_MBY");
            	Object X_SWIFI_SVC_SE = (Object)info.get("X_SWIFI_SVC_SE");
            	Object X_SWIFI_CMCWR = (Object)info.get("X_SWIFI_CMCWR");
            	Object X_SWIFI_CNSTC_YEAR = (Object)info.get("X_SWIFI_CNSTC_YEAR");
            	Object X_SWIFI_INOUT_DOOR = (Object)info.get("X_SWIFI_INOUT_DOOR");
            	Object X_SWIFI_REMARS3 = (Object)info.get("X_SWIFI_REMARS3");
            	double LAT = Double.parseDouble(info.get("LAT").toString());
            	double LNT = Double.parseDouble(info.get("LNT").toString());
            	Object WORK_DTTM = (Object)info.get("WORK_DTTM");
            	

            	wifiInfo Info = new wifiInfo((String)X_SWIFI_MGR_NO
            			, (String)X_SWIFI_WRDOFC
            			, (String)X_SWIFI_MAIN_NM
            			, (String)X_SWIFI_ADRES1
            			, (String)X_SWIFI_ADRES2
            			, (String)X_SWIFI_INSTL_FLOOR 
            			, (String)X_SWIFI_INSTL_TY
            			, (String)X_SWIFI_INSTL_MBY
            			, (String)X_SWIFI_SVC_SE
            			, (String)X_SWIFI_CMCWR
            			, Integer.parseInt((String)X_SWIFI_CNSTC_YEAR)
            			, (String)X_SWIFI_INOUT_DOOR
            			, (String)X_SWIFI_REMARS3
            			, LAT
            			, LNT
            			, (String)WORK_DTTM
            			);
            	wifiList.add(Info);
        	}
            wifi.register(wifiList);
            
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}