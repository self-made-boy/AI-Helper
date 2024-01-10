package com.github.selfmadeboy.aihelper;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;

import java.util.function.Supplier;

public class MyBundle extends DynamicBundle {

    @NonNls
    private static final String BUNDLE = "messages.MyBundle";

    private MyBundle() {
        // 私有构造函数防止外部实例化
        super(BUNDLE);
    }

    private static final MyBundle INSTANCE = new MyBundle();

    public static String message(@PropertyKey(resourceBundle = BUNDLE) String key, Object... params) {
        return INSTANCE.getMessage(key, params);
    }

    @SuppressWarnings("unused")
    public static Supplier<String> messagePointer(@PropertyKey(resourceBundle = BUNDLE) String key, Object... params) {
        return INSTANCE.getLazyMessage(key, params);
    }
}
