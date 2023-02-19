import java.io.*;
import java.net.*;
import java.util.*;

public class Week14_client_김예린 {
	
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket("10.200.3.198",8000); //IP 확인하고 실행하기!
			
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			Scanner sc = new Scanner(System.in);
			
			//server로 문자열 보내기
			out.println("Hello?");
			out.flush();
			
			//server에서 문자열 받아오기
			String strIn = in.nextLine();
			System.out.println(strIn);
			
			//server로 n 입력해서 보내기
			int n = sc.nextInt();
			out.println(n);
			out.flush();
			
			//server에서 문자열 받아오기
			strIn = in.nextLine();
			System.out.println(strIn);
			
			//입력한 n만큼 반복해서 정수 보내기
			for(int i = 0; i < n; i++) {
				out.println(sc.nextInt());
				out.flush();
			}
			System.out.println(in.nextLine());
			System.out.println(in.nextLine());
		}//exception handling
		catch(Exception e) {
			System.out.println(e.getMessage());
		}//close socket
		finally {
			try {
				socket.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
