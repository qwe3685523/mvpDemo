package comtext.mvpdemo.View;

/**
 * Created by eryan on 2016/5/28.
 */
public interface LoginView {
    public String getUsername();

    public String getpwd();

    public void cleanUsername();

    public void cleanUserpwd();

    public void showmessager(String msg);

}
