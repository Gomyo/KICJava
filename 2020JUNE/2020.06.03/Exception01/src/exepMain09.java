import java.io.FileNotFoundException;
import java.io.IOException;

class Parent {
	void methodA() throws IOException{
		
	}
	void methodB() throws ClassNotFoundException{
		
	}
}

public class exepMain09 extends Parent {
	@Override
	void methodA() throws FileNotFoundException{
		
	}
//	@Override
//	void methodB() throws Exception {
//		
//	}
}
