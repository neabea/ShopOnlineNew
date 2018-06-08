package sam.shopline;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.latte_core.acitivities.ProxyActivity;
import com.example.latte_core.app.Latte;
import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.ui.launcher.ILauncherListener;
import com.example.latte_core.ui.launcher.onLauncherFinishTag;
import com.example.latte_ec.launcher.LauncherDelegate;
import com.example.latte_ec.launcher.LauncherScrollDelegate;
import com.example.latte_ec.sign.ISignListener;
import com.example.latte_ec.sign.SignInDelegate;
import com.example.latte_ec.sign.SignUpDelegate;

public class ExampleAcitivity extends ProxyActivity  implements
        ISignListener,ILauncherListener{

    @Override
    public LatteDelegate setRootDelegate() {
        //return new ExampleDelegate();
        return new LauncherDelegate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
      //  Toast.makeText(Latte.getApplication(),"传入context",Toast.LENGTH_LONG).show();
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }

        Latte.getConfigurator().withActivity(this);

    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this,"onSignInSuccess 注册成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this,"onSignUpSuccess 注册成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLauncherFinish(onLauncherFinishTag tag) {
        switch (tag){
            case SIGNED:
                Toast.makeText(this,"启动结束了，用户登录了",Toast.LENGTH_LONG).show();
                startWithPop(new ExampleDelegate());//启动完出栈
                break;
            case NOT_SIGNED:
                Toast.makeText(this,"启动结束了，用户没登录",Toast.LENGTH_LONG).show();
                startWithPop(new SignInDelegate());//启动完出栈
                break;
                default:
                    break;
        }
    }
}
