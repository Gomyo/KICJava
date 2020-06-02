import com.exam.Vehicle;
import com.exam.ele;
import com.exam.suv;

public class VehicleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle[] vehicles = {new suv(), new ele()};
		
		for ( Vehicle v : vehicles) {
			v.addFuel();
			v.reportPosition();
		}
	}

}
