package comtext.mvpdemo.inter;

import comtext.mvpdemo.Listener.OnLoginListener;
import comtext.mvpdemo.model.UserBean;

/**
 * Created by eryan on 2016/5/28.
 */
public class UserBizImpl implements UserBiz {
    private OnLoginListener mListener;

    public UserBizImpl(OnLoginListener listener) {
        this.mListener = listener;


    }

    @Override
    public void login(UserBean login) {
        boolean state = false;
        String username = login.getUsername();
        String pwd = login.getPwd();
        if (username != null && "zy".equals(username)) {
            if (pwd != null && "123".equals(pwd)) {
                state = true;

            }
        }
        mListener.loginStatus(state);
    }
}
