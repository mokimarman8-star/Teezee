package d8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class b {
    private static final b a = d();

    static class a extends b {
        private static final Map b;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put(Bundle.class, new x7.a());
            hashMap.put(Intent.class, new x7.b());
            b = Collections.unmodifiableMap(hashMap);
        }

        a() {
        }

        @Override // d8.b
        Map a() {
            return b;
        }

        @Override // d8.b
        g8.c b() {
            return new g8.a();
        }

        @Override // d8.b
        public void c(String str) {
            Log.e("XLog", str);
        }

        @Override // d8.b
        String f() {
            return System.lineSeparator();
        }

        @Override // d8.b
        public void g(String str) {
            Log.w("XLog", str);
        }
    }

    private static b d() {
        try {
            Class.forName("android.os.Build");
            return new a();
        } catch (ClassNotFoundException unused) {
            return new b();
        }
    }

    public static b e() {
        return a;
    }

    Map a() {
        return Collections.emptyMap();
    }

    g8.c b() {
        return new g8.b();
    }

    public void c(String str) {
        System.out.println(str);
    }

    String f() {
        return System.lineSeparator();
    }

    public void g(String str) {
        System.out.println(str);
    }
}
