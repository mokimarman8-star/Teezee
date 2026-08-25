package com.google.firebase.perf.util;

import android.os.Bundle;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d {
    private static final uc.a b = uc.a.e();
    private final Bundle a;

    public d() {
        this(new Bundle());
    }

    public d(Bundle bundle) {
        this.a = (Bundle) bundle.clone();
    }

    private e d(String str) {
        if (!a(str)) {
            return e.a();
        }
        try {
            return e.b((Integer) this.a.get(str));
        } catch (ClassCastException e) {
            b.b("Metadata key %s contains type other than int: %s", str, e.getMessage());
            return e.a();
        }
    }

    public boolean a(String str) {
        return str != null && this.a.containsKey(str);
    }

    public e b(String str) {
        if (!a(str)) {
            return e.a();
        }
        try {
            return e.b((Boolean) this.a.get(str));
        } catch (ClassCastException e) {
            b.b("Metadata key %s contains type other than boolean: %s", str, e.getMessage());
            return e.a();
        }
    }

    public e c(String str) {
        Object obj;
        if (a(str) && (obj = this.a.get(str)) != null) {
            if (obj instanceof Float) {
                return e.e(Double.valueOf(((Float) obj).doubleValue()));
            }
            if (obj instanceof Double) {
                return e.e((Double) obj);
            }
            b.b("Metadata key %s contains type other than double: %s", str);
            return e.a();
        }
        return e.a();
    }

    public e e(String str) {
        return d(str).d() ? e.e(Long.valueOf(((Integer) r3.c()).intValue())) : e.a();
    }
}
