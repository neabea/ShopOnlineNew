package sam.shopline.generators;

import com.example.latte_annotations.annotations.EntryGenerator;
import com.example.latte_annotations.annotations.PayEntryGenerator;
import com.example.latte_core.wechat.templates.WXEntryTemplate;
import com.example.latte_core.wechat.templates.WXPayEntryTemplate;

@PayEntryGenerator(
        packageName = "sam.shopline",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
