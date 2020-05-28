package gugudan;

public class Util {
	// 메서드- 출력(디버깅)
	public String gugudan(int Start, int End) {
		String result = "";
		for (int dan=Start; dan<=End; dan++) {
			for (int i=1; i<=9; i++) {
				result += dan + "X" + i + "=" + (dan*i) + "\t";
			}
			result += "\n";
		}
		return result;
	}
}
