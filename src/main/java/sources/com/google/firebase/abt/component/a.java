package com.google.firebase.abt.component;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import kc.b;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    private final Map a = new HashMap();
    private final Context b;
    private final b c;

    protected a(Context context, b bVar) {
        this.b = context;
        this.c = bVar;
    }

    protected jb.b a(String str) {
        return new jb.b(this.b, this.c, str);
    }

    public synchronized jb.b b(String str) {
        try {
            if (!this.a.containsKey(str)) {
                this.a.put(str, a(str));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (jb.b) this.a.get(str);
    }
}
