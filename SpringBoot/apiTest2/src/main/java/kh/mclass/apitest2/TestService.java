package kh.mclass.apitest2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.print.DocFlavor.URL;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	private String key = "t%2BMBfXyUlsCG64LCFFpv%2FVotwMILtIfeNO7zAeIjdTWYPTgoNLBWkbOaqy9OXo3PMctejj%2FXe7pWVinitw3AUg%3D%3D";
	public String getApi() {
		
		String url;
		try {
			url = "https://apis.data.go.kr/1741000/TsunamiShelter4/getTsunamiShelter4List"
					+ "?serviceKey=" + key
					+ "&pageNo=" + URLEncoder.encode("1", "UTF-8")
					+ "&numOfRows="+ URLEncoder.encode("2", "UTF-8")
					+ "&type="+ URLEncoder.encode("xml", "UTF-8");
			
			URL requestUrl = new URL(url);
			HttpsURLConnection urlConnection = (HttpsURLConnection)requestUrl;
			urlConnection.setRequestMethod("GET");
			
			BuffrerReader br = new BufferReader
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return "";
	}

}
