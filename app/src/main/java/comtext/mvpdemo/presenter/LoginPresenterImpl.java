package comtext.mvpdemo.presenter;

import comtext.mvpdemo.Listener.OnLoginListener;
import comtext.mvpdemo.View.LoginView;
import comtext.mvpdemo.inter.UserBiz;
import comtext.mvpdemo.inter.UserBizImpl;
import comtext.mvpdemo.model.UserBean;

/**
 * Created by eryan on 2016/5/28.
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginListener {
    private UserBiz mUserBiz;
    private LoginView mLoginView;

    //在构造方法中传入view

    public LoginPresenterImpl(LoginView view) {
        this.mLoginView = view;
        mUserBiz = new UserBizImpl(this);
    }

    @Override
    public void login() {
        UserBean login = new UserBean();
        login.setUsername(mLoginView.getUsername());
        login.setPwd(mLoginView.getpwd());
        mUserBiz.login(login);
    }

    @Override
    public void clean() {
        mLoginView.cleanUsername();
        mLoginView.cleanUserpwd();
    }


    @Override
    public void loginStatus(boolean status) {
        String msg;
        if (status) {
            msg = "login succeed";
        } else {
            msg = "login failed";
        }
        mLoginView.showmessager(msg);
    }
}
