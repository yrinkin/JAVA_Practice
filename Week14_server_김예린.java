import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Week14_server_김예린 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		int count = 0;
		String strNum[] = null;
		int number[] = null;
		int sum = 0;
		double average; //필요한 변수들 선언
		
		try {
			// socket, serverSocket
			serverSocket = new ServerSocket(8000);
			socket = serverSocket.accept();
			
			//input, output stream
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			//client에서 보낸 문자열 받아서 출력
			String strIn = in.nextLine();
			System.out.println(strIn);
			
			//client에 문자열 보냄
			out.println("How many numbers?");
			out.flush();
			
			//client에서 입력한 문자열 받아서 출력(n)
			String strCount = in.nextLine();
			System.out.println(strCount);
			
			//앞에서 받은 문자열을 integer로 형변환
			try {
				count = Integer.parseInt(strCount);
			}
			catch(NumberFormatException	e) {
				System.out.println(e.getMessage());
			}
			//n개의 수를 입력 받음
			out.println("Input "+count+" numbers");
			out.flush();
			
			strNum = new String[count];
			number = new int[count];
			
			for(int i = 0; i < count; i++) {
				strNum[i] = in.nextLine();
				try {
					number[i] = Integer.parseInt(strNum[i]);
				}
				catch(NumberFormatException e) {
					System.out.println(e.getMessage());
				}
				sum += number[i]; //입력 받음과 동시에 더함
			}
			average = (double)sum/count; //평균 구하기
			//client로 sum과 average 보냄
			out.println("Sum: "+sum);
			out.println("Avg: "+average);
			out.flush();
			
			System.out.println("Service finished.");
			
		} // exception handling
		catch(Exception e){
			System.out.println(e.getMessage());
		} //close sockets.
		finally {
			try {socket.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			try {
				serverSocket.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}



	}

}
