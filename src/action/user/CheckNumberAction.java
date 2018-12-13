package action.user;

import action.BaseAction;


public class CheckNumberAction extends BaseAction{
	private String number;
	private boolean ok=false;
	public String execute(){
		
		String oldnumber=(String)session.get("number");
		if(oldnumber.equalsIgnoreCase(number)){
			ok=true;
		}
		return "success";
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
}
