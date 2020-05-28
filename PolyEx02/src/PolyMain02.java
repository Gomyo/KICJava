import com.exam2.ChildEmployee1;
import com.exam2.ChildEmployee2;
import com.exam2.Employee;

public class PolyMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new ChildEmployee1();
		Employee e2 = new ChildEmployee2();
		
		e1.salary();
		e2.salary();
	}

}
