package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLRead {

	public static void main(String[] args) {
		
		try {
			//URL 입력
			URL url = new URL("https://www.naver.com/");
			
			//내용을 가져오기 위해서 buffer를 사용하여 stream으로 가져옴
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			//br.readLine으로 내용을 가져와서 콘솔에 표시
			String line = "";
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			//buffer를 썼다면 꼭 닫아주기
			br.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
