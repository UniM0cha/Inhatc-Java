package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {

	final static int port = 9999;
	
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			//지정된 포트 번호로 먼저 서버를 생성
			server = new ServerSocket(port);
			System.out.println("연결 대기중...");
			
			//서버를 통해 클라이언트 소켓에 연결
			socket = server.accept();
			System.out.println("연결 되었습니다.");
			
			//소켓으로 통신을 하기 위해 stream을 이용
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//클라이언트로부터 메시지가 오는 것을 계속 대기
			while(true) {
				String inMsg = in.readLine();
				
				// 클라이언트의 문자가 bye면 연결 끊음
				// ignorecase하면 대문자, 소문자 구분 무시
				if(inMsg.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트가 나갔습니다.");
					break;
				}
				
				// 정상 메시지인 경우
				System.out.println("클라이언트 : " + inMsg);
				
				//보낼 메시지의 프롬프트를 띄우고
				System.out.print("보내기 >> ");
				
				//스캐너로 받은 문자열을 클라이언트로 보냄
				String outMsg = sc.nextLine();
				out.write(outMsg + "\n");
				out.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sc.close();
				out.close();
				in.close();
				socket.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
