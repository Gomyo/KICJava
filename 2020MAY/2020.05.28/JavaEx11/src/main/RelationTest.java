package main;

import com.exam.Chargeable;
import com.exam.DigitalCamera;
import com.exam.HandPhone;

public class RelationTest {
	void badCase() {
		Object [] objs = {new HandPhone(), new DigitalCamera()};
		for (Object obj : objs) {
			if (obj instanceof HandPhone) {
				HandPhone hp = (HandPhone) obj;
				hp.charge();
			}
			else if (obj instanceof DigitalCamera) {
				DigitalCamera dica = (DigitalCamera)obj;
				dica.charge();
			}
		}
	}
	
	void goodCase() {
		Chargeable [] objs = {new HandPhone(), new DigitalCamera()};
		for (Chargeable obj: objs) {
			obj.charge();
		}
	}
	public static void main(String[] args) {
		RelationTest rt = new RelationTest();
		rt.badCase();
		rt.goodCase();
	}
}
