import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetEx01 {
	public static void main(String[] args) {
		// 도메인과 아이피에 관한 클래스 : InetAddress
		
		// dns(domain name service)
		// 도메인  <-> IP에 대한 정보를 저장하고 있는 서버
		try {
			InetAddress inetAdd1 = InetAddress.getByName("www.naver.com");
			
			System.out.println(inetAdd1.getHostName());
			System.out.println(inetAdd1.getHostAddress());
			
			// 서버는 ip가 여러개~
			InetAddress[] inetAddArray = InetAddress.getAllByName("www.naver.com");
			for (InetAddress inetAddress : inetAddArray) {
				System.out.println(inetAddress.getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
