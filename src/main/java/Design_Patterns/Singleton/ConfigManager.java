package Design_Patterns.Singleton;

import java.util.HashMap;
import java.util.Map;

class ConfigManager {
    private static ConfigManager instance;
    private Map<String, String> config = new HashMap<>();

    private ConfigManager() {
        System.out.println("Loading config...");
        config.put("url", "https://example.com");
        config.put("timeout", "5000");
    }

    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getConfig(String key) {
        return config.getOrDefault(key, "Not found");
    }
}

class Main02 {
    public static void main(String[] args) {
        ConfigManager cfg = ConfigManager.getInstance();
        System.out.println(cfg.getConfig("url"));
        System.out.println(cfg.getConfig("timeout"));
    }
}
