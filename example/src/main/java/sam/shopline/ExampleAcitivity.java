package sam.shopline;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.latte_core.acitivities.ProxyActivity;
import com.example.latte_core.app.Latte;
import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_ec.launcher.LauncherDelegate;
import com.example.latte_ec.launcher.LauncherScrollDelegate;
import com.example.latte_ec.sign.SignUpDelegate;

public class ExampleAcitivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        //return new ExampleDelegate();
        return new SignUpDelegate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
      //  Toast.makeText(Latte.getApplication(),"传入context",Toast.LENGTH_LONG).show();
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.hide();
        }


    }
}
