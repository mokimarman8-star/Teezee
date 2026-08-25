package com.apm.insight.b;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class h {
    private static volatile boolean a;
    private static Printer b;
    private static final CopyOnWriteArrayList<e> c = new CopyOnWriteArrayList<>();
    private static volatile boolean d = false;

    public interface a {
        @Nullable
        String a();

        String b();

        String c();
    }

    public static void a() {
        if (a) {
            return;
        }
        a = true;
        b = new Printer() { // from class: com.apm.insight.b.h.1
            @Override // android.util.Printer
            public final void println(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.charAt(0) == '>') {
                    h.a(true, str);
                } else if (str.charAt(0) == '<') {
                    h.a(false, str);
                }
            }
        };
        i.a();
        i.a(b);
    }

    public static void a(e eVar) {
        CopyOnWriteArrayList<e> copyOnWriteArrayList = c;
        synchronized (copyOnWriteArrayList) {
            copyOnWriteArrayList.add(eVar);
        }
    }

    public static void a(boolean z, String str) {
        e.a = System.nanoTime() / 1000000;
        e.b = SystemClock.currentThreadTimeMillis();
        CopyOnWriteArrayList<e> copyOnWriteArrayList = c;
        for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
            e eVar = copyOnWriteArrayList.get(i);
            if (eVar == null || !eVar.a()) {
                if (!z && eVar.c) {
                    eVar.b("");
                }
            } else if (z) {
                if (!eVar.c) {
                    eVar.a(str);
                }
            } else if (eVar.c) {
                eVar.b(str);
            }
        }
    }
}
