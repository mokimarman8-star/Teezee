package e5;

import org.glassfish.jersey.internal.spi.AutoDiscoverable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class a implements AutoDiscoverable {
    public static volatile boolean a = true;

    static {
        try {
            a = Boolean.parseBoolean(System.getProperty("fastjson.auto.discoverable", String.valueOf(a)));
        } catch (Throwable unused) {
        }
    }
}
