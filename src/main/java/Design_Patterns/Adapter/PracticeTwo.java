package Design_Patterns.Adapter;

interface LegacyLogger {
    void logMessage(String message);
}

interface ModernLogger {
    void log(String level, String message);
}

class LegacyLoggerImpl implements LegacyLogger {
    public void logMessage(String message) {
        System.out.println("Legacy log: " + message);
    }
}

class LoggerAdapter implements ModernLogger {
    private LegacyLogger legacyLogger;

    public LoggerAdapter(LegacyLogger legacyLogger) {
        this.legacyLogger = legacyLogger;
    }

    public void log(String level, String message) {
        legacyLogger.logMessage("[" + level + "] " + message);
    }
}
