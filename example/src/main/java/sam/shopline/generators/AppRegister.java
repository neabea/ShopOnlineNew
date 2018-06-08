package sam.shopline.generators;

import com.example.latte_annotations.annotations.AppRegisterGenerator;
import com.example.latte_annotations.annotations.EntryGenerator;
import com.example.latte_core.wechat.templates.AppRegisterTemplate;
import com.example.latte_core.wechat.templates.WXEntryTemplate;

@AppRegisterGenerator(
        packageName = "sam.shopline",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
