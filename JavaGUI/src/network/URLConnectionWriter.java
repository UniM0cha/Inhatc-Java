package network;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionWriter {

	public static void main(String[] args) {
		URL aURL;
		try {
			aURL = new URL("https://www.naver.com/");
			URLConnection uc = aURL.openConnection();
			uc.setDoOutput(true);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
