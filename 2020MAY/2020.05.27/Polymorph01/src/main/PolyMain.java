package main;

import com.exam.Child1;
import com.exam.Child2;
import com.exam.Parent;

public class PolyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Parent();
		Child1 c1 = new Child1();
		
		// 객체 묵시적 형변환(자동 형변환) 부모<-자식 
		Parent p1 = c1;
		Parent p2 = new Child1();
		
		p.viewP();
		p.viewS();
		
		c1.viewC();
		c1.viewS();
		
		p1.viewP();
		p1.viewS();
		
		p2.viewP();
		
		// Overrided method는 자식의 method를 호출
		p2.viewS();
		
		Parent p3 = new Child2();
		p3.viewS();
		
		
	}

}
