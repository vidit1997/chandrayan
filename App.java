package comeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.google.common.collect.Multiset.Entry;

import java.io.OutputStream;
import java.lang.Object;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.StringJoiner;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 
public class App {
	
	 public static void main(String[] args) {
	       // implementing server A
		   // taking a predefined data instead of stream of incoming data
		 	HashMap<Integer,Float[]> inputStream= new HashMap<Integer,Float[]>();
//		 	ArrayList<Double> a=new ArrayList<>();
//		 	a.add(44.3422432);
		 	inputStream.put(1,new Float[]{(float) 2.12342341,(float) 44.3422432});
		 	inputStream.put(1,new Float[]{(float) 2.12342321,(float) 4.3422432});
		 	inputStream.put(2,new Float[]{(float) 2.12342321,(float) 4.3422439});
		 	inputStream.put(2,new Float[]{(float) 2.12332321,(float) 4.3492432});
		 	inputStream.put(3,new Float[]{(float) 2.12242321,(float) 4.3429432});
		 	inputStream.put(4,new Float[]{(float) 2.12122321,(float) 4.3422932});
		 	inputStream.put(5,new Float[]{(float) 2.12342321,(float) 4.3422932});
		 	inputStream.put(2,new Float[]{(float) 4.12342321,(float) 4.3422432});
		 	inputStream.put(3,new Float[]{(float) 5.12342321,(float) 4.3422432});
		 	inputStream.put(3,new Float[]{(float) 5.12342321,(float) 2.3422432});
		 	inputStream.put(5,new Float[]{(float) 6.12842321,(float) 34.3428432});
		 	inputStream.put(2,new Float[]{(float) 6.12342381,(float) 34.3472432});
		 	inputStream.put(4,new Float[]{(float) 6.12342821,(float) 34.3427432});
		 	inputStream.put(1,new Float[]{(float) 2.12362321,(float) 34.3422632});
		 	Float aggregateX[]= new Float[100];
		 	Float aggregateY[]= new Float[100];
		 	Float count[]= new Float[100];
		 	Float X[]=new Float[100];
		 	Float Y[]=new Float[100];
		 	for(Map.Entry<Integer, Float[]> entry : inputStream.entrySet()) {
		 		Integer k=entry.getKey();
		 		Float coordinates[]= new Float[2];
		 		coordinates=(entry.getValue());
		 		if(X[k]==0 && Y[k]==0) {
		 			X[k]=coordinates[0];
		 			Y[k]=coordinates[1];
		 			count[k]++;
		 			continue;
		 		}
		 		requestDTO request = new requestDTO();
		 		request.setComplete(complete);
		 		request.setGeo_points(geo_points);
		 		request.setLake_id(lake_id);
		 		request.jsonencode();
		 		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		 		String json = ow.writeValueAsString(object);
		 		if(coordinates[0]==X[k] && coordinates[1]==Y[k]) {
		 			//post method call
		 			URL url = new URL("https://www.example.com/login");
//		 			URL url = new URL("localhost:9042/appplication/api/apigate");
		 			URLConnection con = url.openConnection();
		 			HttpURLConnection http = (HttpURLConnection)con;
		 			http.setRequestMethod("POST");
		 			http.setDoOutput(true);
		 			
					byte[] out =json.getBytes(StandardCharsets.UTF_8);
		 			int length = out.length;
		 			
		 			http.setFixedLengthStreamingMode(length);
		 			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		 			http.connect();
		 			try(OutputStream os = http.getOutputStream()) {
		 			    os.write(out);
		 			}
		 			
					/*
					 * byte[] out = "{\"username\":\"root\",\"password\":\"password\"}"
					 * .getBytes(StandardCharsets.UTF_8); int length = out.length;
					 * 
					 * http.setFixedLengthStreamingMode(length);
					 * http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
					 * http.connect(); try(OutputStream os = http.getOutputStream()) {
					 * os.write(out); }
					 */
		 		}
		 		//if(//out of memory ){
		 				//}
		 		
		 		X[k]=((X[k]*count[k])+coordinates[0])/(count[k]+1);
		 		Y[k]=((Y[k]*count[k])+coordinates[1])/(count[k]+1);
		 		count[k]++;
		 		
		 		if(coordinates[0]==X[k] && coordinates[1]==Y[k]) {
		 			//post method call
		 		}
		 		
		 		
		 	}
	 }
}
