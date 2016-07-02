package challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DAO {

	public JSONArray getTicketList() throws JSONException, IOException {
		String zen ="https://wooyoung.zendesk.com/api/v2/tickets.json";
		URL url;
		StringBuilder sb = new StringBuilder();  
		try {
			url = new URL(zen);
		    URLConnection uc = url.openConnection();
		    String userpass = "s3588086@student.rmit.edu.au" + ":" + "An6281868";
		    String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
		    uc.setRequestProperty ("Authorization", basicAuth);
//		    InputStream in = uc.getInputStream();
		    	
			int HttpResult = ((HttpURLConnection) uc).getResponseCode(); 
				if (HttpResult == HttpURLConnection.HTTP_OK) {
				    BufferedReader br = new BufferedReader(
				            new InputStreamReader(uc.getInputStream(), "utf-8"));
				    String line = null;  
				    while ((line = br.readLine()) != null) {  
				        sb.append(line + "\n");  
				    }
				    br.close();
				} else {
				    System.out.println(((HttpURLConnection) uc).getResponseMessage());  
				}
		    	
			} catch (MalformedURLException e) {
					e.printStackTrace();
			}
				
//			ArrayList<HashMap<String, Object>> ticketList = null;
//			HashMap<String, Object> map = new HashMap<String, Object>();
			JSONObject obj = new JSONObject(sb.toString());
				
			JSONArray arr = obj.getJSONArray("tickets");
				
//			for (int i = 0; i < arr.length(); i++) {
//				int id = arr.getJSONObject(i).getInt("id");
//				String subject = arr.getJSONObject(i).getString("subject");
//				String description = arr.getJSONObject(i).getString("description");
//				map.put("id", id);
//				map.put("subject", subject);
//				map.put("description", description);
					
//				ticketList = new ArrayList (map.entrySet());
//				Iterator iter = ticketList.iterator();
//					
//				while(iter.hasNext()) {
//					Map.Entry entry = (Map.Entry) iter.next();
//				}
					
//				}
				return arr;
		    }
	}




