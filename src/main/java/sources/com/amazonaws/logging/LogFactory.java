package com.amazonaws.logging;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class LogFactory {
    private static final String a = "LogFactory";
    private static final Map b = new HashMap();
    private static Level c = null;

    public enum Level {
        ALL(Integer.MIN_VALUE),
        TRACE(0),
        DEBUG(1),
        INFO(2),
        WARN(3),
        ERROR(4),
        OFF(Integer.MAX_VALUE);

        private final int value;

        Level(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static Level a() {
        return c;
    }

    public static synchronized Log b(Class cls) {
        Log c2;
        synchronized (LogFactory.class) {
            c2 = c(d(cls.getSimpleName()));
        }
        return c2;
    }

    public static synchronized Log c(String str) {
        synchronized (LogFactory.class) {
            try {
                String d = d(str);
                Map map = b;
                Log log = (Log) map.get(d);
                if (log != null) {
                    return log;
                }
                Log consoleLog = Environment.a() ? new ConsoleLog(d) : new AndroidLog(d);
                map.put(d, consoleLog);
                return consoleLog;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String d(String str) {
        if (str.length() <= 23) {
            return str;
        }
        c(a).j("Truncating log tag length as it exceed 23, the limit imposed by Android on certain API Levels");
        return str.substring(0, 23);
    }
}
