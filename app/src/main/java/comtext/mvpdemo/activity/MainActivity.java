package comtext.mvpdemo.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import comtext.mvpdemo.R;
import comtext.mvpdemo.View.LoginView;
import comtext.mvpdemo.presenter.LoginPresenter;
import comtext.mvpdemo.presenter.LoginPresenterImpl;

public class MainActivity extends Activity implements LoginView {

    private EditText mUsename;
    private EditText mPwd;
    private Button mLogin;
    private Button mClean;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    //初始化
    private void init() {
        mLoginPresenter = new LoginPresenterImpl(this);
        mUsename = (EditText) findViewById(R.id.et_username);
        mPwd = (EditText) findViewById(R.id.et_pwd);
        mLogin = (Button) findViewById(R.id.btn_login);
        mClean = (Button) findViewById(R.id.btn_clean);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.login();
            }
        });
        mClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.clean();
            }
        });

    }

    @Override
    public String getUsername() {
        return mUsename.getText().toString();
    }

    @Override
    public String getpwd() {
        return mPwd.getText().toString();
    }

    @Override
    public void cleanUsername() {
        mUsename.setText("");
    }

    @Override
    public void cleanUserpwd() {
        mPwd.setText("");
    }

    @Override
    public void showmessager(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}
