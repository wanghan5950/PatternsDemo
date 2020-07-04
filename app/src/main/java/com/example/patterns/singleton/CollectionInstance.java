package com.example.patterns.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式——容器模式
 * 统一管理各种对象
 */
public class CollectionInstance {

    private static Map<String, Object> objectMap = new HashMap<>();

    private CollectionInstance() {
    }

    public static void registerService(String key, Object object) {
        if (!objectMap.containsKey(key)) {
            objectMap.put(key, object);
        }
    }

    public static Object getService(String key) {
        return objectMap.get(key);
    }
}
