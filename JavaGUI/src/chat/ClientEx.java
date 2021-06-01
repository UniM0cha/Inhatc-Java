package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {

	final static int port = 9999;
	final static String ip = "localhost";
	
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		Scanner sc = new Scanner(System.in);
		
		//서버를 열 필요 없으므로 서버는 삭제
		try {
			//해당 아이피로 소켓을 연결
			socket = new Socket(ip, port);
			
			//스트림 통신을 위한 in, out 설정
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//메시지가 입력될 때까지 대기
			while(true) {
				System.out.print("보내기 >> ");
				String outMsg = sc.nextLine();
				
				//bye를 입력하면 서버로 bye를 전송하고 통신 종료 
				if(outMsg.equalsIgnoreCase("bye")) {
					out.write(outMsg + "\n");
					out.flush();
					break;
				}
				
				// 정상 메시지인 경우 서버로 메시지 전송
				out.write(outMsg + "\n");
				out.flush();
				
				//서버에서 응답이 올 때까지 대기
				String inMsg = in.readLine();
				System.out.println("서버 >> " + inMsg);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//사용했으면 반드시 닫아주기
				sc.close();
				out.close();
				in.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
