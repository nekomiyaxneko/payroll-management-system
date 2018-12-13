package action.user;

import action.BaseAction;
import dao.UserDao;
import util.Factory;

public class LogoutAction  extends BaseAction {
    public String execute() throws Exception{
        session.remove("userInfo");
        return "success";
    }

}
