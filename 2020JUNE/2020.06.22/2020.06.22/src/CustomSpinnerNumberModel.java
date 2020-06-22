import javax.swing.SpinnerNumberModel;

public class CustomSpinnerNumberModel extends SpinnerNumberModel {

	public CustomSpinnerNumberModel(int value, int minimum, int maximum, int stepsize) {
		super(value, minimum, maximum, stepsize);
	}

	
}
