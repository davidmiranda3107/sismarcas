package portal.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import portal.security.SecurityController;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB extends SecurityController {

	public LoginMB() {
		super();
	}
	
	@Override
	protected boolean beforeLogin() {
		setOutcome("/page/login/main.xhtml");
		setChangePassOutcome("/changepass.xhtml");
		return true;
	}

	@Override
	protected boolean beforeLogout() {
		setOutcome("/index.xhtml?faces-redirect=true");
		return true;
	}
}
