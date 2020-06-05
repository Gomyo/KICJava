import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessMain {

	public static void main(String[] args) {
		RandomAccessFile raf = null;
		
		// w: write r: read
		try {
			raf = new RandomAccessFile("./score.dat", "rw");
			// 배열화시킨 데이터를 하나씩 데이터로 넣기
			int[] scores = {
					// int가 4byte이니 9번째부터는 36byte
				1, 100, 90, 95,
				2, 200, 91, 96,
				3, 300, 92, 97,
				4, 400, 93, 98,
				5, 500, 94, 99,
			};
			
			for (int i=0; i<scores.length; i++) {
				raf.writeInt(scores[i]);
				// 3을 쓰고 난 뒤의 위치값 출력
				if (scores[i]==3) {
					System.out.println(raf.getFilePointer());
				}
			}
			System.out.println("입력 완료");
			
			// 읽을 위치 지정 (File Pointer)
			raf.seek(0);
			
			// 이제 한 파일 안에서 쓰고 읽고가 동시에 이루어짐
			while (true) {
				System.out.println(raf.readInt());
			}
		} 
		catch (EOFException e) {
			System.out.println("출력 완료");
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (raf != null) try {raf.close();} catch (IOException e) {}
		}
	}

}
