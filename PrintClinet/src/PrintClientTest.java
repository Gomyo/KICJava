interface Printer {
	void print(String file);
}
class LaserPrinter implements Printer {
	@Override
	public void print(String file) {
		// TODO Auto-generated method stub
		System.out.printf("Laser printing : %s%n", file);
	}
}

class DotPrinter implements Printer {
	@Override
	public void print(String file) {
		// TODO Auto-generated method stub
		System.out.printf("Dot printing : %s%n", file);
	}
}

class PrintClient {
	private Printer printer;
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void printThis(String file) {
		printer.print(file);
	}
}


public class PrintClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintClient pc = new PrintClient();
		pc.setPrinter(new DotPrinter());
		pc.printThis("Holy shit Dot");
		pc.setPrinter(new LaserPrinter());
		pc.printThis("Laser Z------------------");
	}

}
