package sam.shopline.generators;

import com.example.latte_annotations.annotations.EntryGenerator;
import com.example.latte_core.wechat.templates.WXEntryTemplate;

@EntryGenerator(
        packageName = "sam.shopline",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
