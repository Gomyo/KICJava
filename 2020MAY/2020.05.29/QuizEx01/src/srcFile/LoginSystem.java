package srcFile;

public class LoginSystem {
	public LoginResult doLogin(String id, String pass) {
		LoginResult real = new LoginResult();
		if (id.equals("engcraft") && pass.equals("123456")) {
			real.result = true;
			real.msg = id + "님 ㅎㅇ";
			
		}
	}
}
