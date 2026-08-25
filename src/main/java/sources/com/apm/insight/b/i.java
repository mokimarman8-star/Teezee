package com.apm.insight.b;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class i {
    private static int a = 5;
    private static b b;
    private static boolean c;
    private static Printer d;

    public interface a {
    }

    static class b implements Printer {
        List<Printer> a = new ArrayList();
        private List<Printer> d = new ArrayList();
        List<Printer> b = new ArrayList();
        private boolean e = false;
        boolean c = false;

        b() {
        }

        @Override // android.util.Printer
        public final void println(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i.b();
            if (str.charAt(0) == '>' && this.c) {
                for (Printer printer : this.b) {
                    if (!this.a.contains(printer)) {
                        this.a.add(printer);
                    }
                }
                this.b.clear();
                this.c = false;
            }
            if (this.a.size() > i.a) {
                Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
            }
            for (Printer printer2 : this.a) {
                if (printer2 != null) {
                    printer2.println(str);
                }
            }
            str.charAt(0);
            i.b();
        }
    }

    public static void a() {
        if (c) {
            return;
        }
        c = true;
        b = new b();
        Printer d2 = d();
        d = d2;
        if (d2 != null) {
            b.a.add(d2);
        }
        if (com.apm.insight.e.s()) {
            Looper.getMainLooper().setMessageLogging(b);
        }
    }

    public static void a(Printer printer) {
        if (printer == null || b.b.contains(printer)) {
            return;
        }
        b.b.add(printer);
        b.c = true;
    }

    static /* synthetic */ a b() {
        return null;
    }

    private static Printer d() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception unused) {
            return null;
        }
    }
}
