package sam.shopline;

import android.app.Application;

import com.example.latte_core.app.Latte;
import com.example.latte_core.net.interceptors.DebugInterceptor;
import com.example.latte_ec.database.DatabaseManager;
import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .withWeChatAppId("aa")
                .withWeChatAppSecret("bb")
                .configure();
        Logger.addLogAdapter(new AndroidLogAdapter());
        // initStetho();
        DatabaseManager.getInstance().init(this);
    }


    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }

}
