package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class VersionInfoUtils {
    private static volatile String a = "2.22.5";
    private static volatile String b = "android";
    private static volatile String c;
    private static final Log d = LogFactory.b(VersionInfoUtils.class);

    public static String a() {
        return b;
    }

    public static String b() {
        if (c == null) {
            synchronized (VersionInfoUtils.class) {
                try {
                    if (c == null) {
                        d();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public static String c() {
        return a;
    }

    private static void d() {
        c = f();
    }

    private static String e(String str) {
        return str.replace(' ', '_');
    }

    static String f() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("aws-sdk-");
        sb.append(StringUtils.b(a()));
        sb.append("/");
        sb.append(c());
        sb.append(" ");
        sb.append(e(System.getProperty("os.name")));
        sb.append("/");
        sb.append(e(System.getProperty("os.version")));
        sb.append(" ");
        sb.append(e(System.getProperty("java.vm.name")));
        sb.append("/");
        sb.append(e(System.getProperty("java.vm.version")));
        sb.append("/");
        sb.append(e(System.getProperty("java.version")));
        String property = System.getProperty("user.language");
        String property2 = System.getProperty("user.region");
        if (property != null && property2 != null) {
            sb.append(" ");
            sb.append(e(property));
            sb.append("_");
            sb.append(e(property2));
        }
        return sb.toString();
    }
}
