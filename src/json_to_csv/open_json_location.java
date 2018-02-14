package json_to_csv;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class open_json_location {
	public static void main(String[] argv)  {
		ArrayList<Datalist> location_edl=new ArrayList<Datalist>();
		System.out.println("hello");
		String location_1="00800000a00006d4";
		double location_1_lat=24.96715;
		double location_1_lon=121.18766;
		String location_2="00800000a0000a1c";
		double location_2_lat=24.96822;
		double location_2_lon=121.19437;
		String location_3="00800000a0000ed1";
		double location_3_lat=24.97154;
		double location_3_lon=121.19268;
		 /*FileReader fr = new FileReader("C:\\Users\\Aaron\\Desktop\\location.json"); 
	     BufferedReader br = new BufferedReader(fr);
	     String line;
	     String tempstring="";
	     String[] tempArray= new String[3];
	     ArrayList myList = new ArrayList();
	        int i=0;
	        while((line = br.readLine())!=null)
	        {
	        	tempstring= line;
	        	System.out.println(tempstring);
	        }
	        System.out.println(tempstring);
	       */
		//FileReader reader = new FileReader("./�泓ocation.json");
		FileReader fr=null;
		try {
			//fr = new FileReader("C:\\Users\\Aaron\\Desktop\\location.json");
			fr = new FileReader("C:\\Users\\user\\Desktop\\location.json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		JSONTokener jsrc = new JSONTokener(fr);
	    JSONObject j = new JSONObject(jsrc);
	    JSONObject location = j.getJSONObject("location");
	    for(int i=1;i<=23;i++) {
	    	JSONArray recs =  location.getJSONArray(String.valueOf(i));
	    	location_edl.add(new Datalist(i,(double)recs.get(0),(double)recs.get(1)));
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_1_lat, location_1_lon, 1);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_2_lat, location_2_lon, 2);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_3_lat, location_3_lon, 3);
	    	System.out.println(location_edl.get(location_edl.size()-1).location+":"
	    	+location_edl.get(location_edl.size()-1).lat+","+location_edl.get(location_edl.size()-1).lon+"  "
	    	+location_edl.get(location_edl.size()-1).location_between_gateway1+","+location_edl.get(location_edl.size()-1).location_between_gateway2+","
	    	+location_edl.get(location_edl.size()-1).location_between_gateway3);
	    	
	    }
	    for(int i=25;i<=38;i++) {
	    	JSONArray recs =  location.getJSONArray(String.valueOf(i));
	    	location_edl.add(new Datalist(i,(double)recs.get(0),(double)recs.get(1)));
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_1_lat, location_1_lon, 1);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_2_lat, location_2_lon, 2);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_3_lat, location_3_lon, 3);
	    	System.out.println(location_edl.get(location_edl.size()-1).location+":"
	    	    	+location_edl.get(location_edl.size()-1).lat+","+location_edl.get(location_edl.size()-1).lon+"  "
	    	    	+location_edl.get(location_edl.size()-1).location_between_gateway1+","+location_edl.get(location_edl.size()-1).location_between_gateway2+","
	    	    	+location_edl.get(location_edl.size()-1).location_between_gateway3);
	    }
	    for(int i=47;i<=57;i++) {
	    	JSONArray recs =  location.getJSONArray(String.valueOf(i));
	    	location_edl.add(new Datalist(i,(double)recs.get(0),(double)recs.get(1)));
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_1_lat, location_1_lon, 1);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_2_lat, location_2_lon, 2);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_3_lat, location_3_lon, 3);
	    	System.out.println(location_edl.get(location_edl.size()-1).location+":"
	    	    	+location_edl.get(location_edl.size()-1).lat+","+location_edl.get(location_edl.size()-1).lon+"  "
	    	    	+location_edl.get(location_edl.size()-1).location_between_gateway1+","+location_edl.get(location_edl.size()-1).location_between_gateway2+","
	    	    	+location_edl.get(location_edl.size()-1).location_between_gateway3);
	    }
	    for(int i=156;i<=169;i++) {
	    	JSONArray recs =  location.getJSONArray(String.valueOf(i));
	    	location_edl.add(new Datalist(i,(double)recs.get(0),(double)recs.get(1)));
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_1_lat, location_1_lon, 1);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_2_lat, location_2_lon, 2);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_3_lat, location_3_lon, 3);
	    	System.out.println(location_edl.get(location_edl.size()-1).location+":"
	    	    	+location_edl.get(location_edl.size()-1).lat+","+location_edl.get(location_edl.size()-1).lon+"  "
	    	    	+location_edl.get(location_edl.size()-1).location_between_gateway1+","+location_edl.get(location_edl.size()-1).location_between_gateway2+","
	    	    	+location_edl.get(location_edl.size()-1).location_between_gateway3);
	    }
	    
	    /*
	     for(int i=193;i<=195;i++) {
	    	JSONArray recs =  location.getJSONArray(String.valueOf(i));
	    	location_edl.add(new Datalist(i,(double)recs.get(0),(double)recs.get(1)));
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_1_lat, location_1_lon, 1);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_2_lat, location_2_lon, 2);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_3_lat, location_3_lon, 3);
	    	System.out.println(location_edl.get(location_edl.size()-1).location+":"
	    	    	+location_edl.get(location_edl.size()-1).lat+","+location_edl.get(location_edl.size()-1).lon+"  "
	    	    	+location_edl.get(location_edl.size()-1).location_between_gateway1+","+location_edl.get(location_edl.size()-1).location_between_gateway2+","
	    	    	+location_edl.get(location_edl.size()-1).location_between_gateway3);
	    }
	  
	     for(int i=197;i<=209;i++) {
	    	JSONArray recs =  location.getJSONArray(String.valueOf(i));
	    	location_edl.add(new Datalist(i,(double)recs.get(0),(double)recs.get(1)));
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_1_lat, location_1_lon, 1);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_2_lat, location_2_lon, 2);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_3_lat, location_3_lon, 3);
	    	System.out.println(location_edl.get(location_edl.size()-1).location+":"
	    	    	+location_edl.get(location_edl.size()-1).lat+","+location_edl.get(location_edl.size()-1).lon+"  "
	    	    	+location_edl.get(location_edl.size()-1).location_between_gateway1+","+location_edl.get(location_edl.size()-1).location_between_gateway2+","
	    	    	+location_edl.get(location_edl.size()-1).location_between_gateway3);
	    }
	     * */
	    
	    for(int i=408;i<=412;i++) {
	    	JSONArray recs =  location.getJSONArray(String.valueOf(i));
	    	location_edl.add(new Datalist(i,(double)recs.get(0),(double)recs.get(1)));
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_1_lat, location_1_lon, 1);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_2_lat, location_2_lon, 2);
	    	location_edl.get(location_edl.size()-1).count_location_bet_gatway(location_3_lat, location_3_lon, 3);
	    	System.out.println(location_edl.get(location_edl.size()-1).location+":"
	    	    	+location_edl.get(location_edl.size()-1).lat+","+location_edl.get(location_edl.size()-1).lon+"  "
	    	    	+location_edl.get(location_edl.size()-1).location_between_gateway1+","+location_edl.get(location_edl.size()-1).location_between_gateway2+","
	    	    	+location_edl.get(location_edl.size()-1).location_between_gateway3);
	    }
	    System.out.println(location_edl.size());
	    
	    creat_csv cc=new creat_csv(location_edl);
	    cc.input_data();
	    cc.csv_array();
	}
	
	 public void json_deal(String return_json) throws JSONException {
	        JSONObject j;
	        j = new JSONObject(return_json);
	        JSONArray recs =  j.getJSONArray("DataList");
	        for (int i = 0; i < recs.length(); ++i) {
	            JSONObject rec = recs.getJSONObject(i);
	            String Value = rec.getString("Value");
	            String TimeStamp = rec.getString("TimeStamp");
	        }
	 }
}
