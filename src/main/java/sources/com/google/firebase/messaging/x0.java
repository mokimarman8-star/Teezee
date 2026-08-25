package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class x0 {
    private final SharedPreferences a;
    private final String b;
    private final String c;
    private final Executor e;
    final ArrayDeque d = new ArrayDeque();
    private boolean f = false;

    private x0(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.a = sharedPreferences;
        this.b = str;
        this.c = str2;
        this.e = executor;
    }

    private boolean c(boolean z) {
        if (z && !this.f) {
            j();
        }
        return z;
    }

    static x0 d(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        x0 x0Var = new x0(sharedPreferences, str, str2, executor);
        x0Var.e();
        return x0Var;
    }

    private void e() {
        synchronized (this.d) {
            try {
                this.d.clear();
                String string = this.a.getString(this.b, TtmlNode.ANONYMOUS_REGION_ID);
                if (!TextUtils.isEmpty(string) && string.contains(this.c)) {
                    String[] split = string.split(this.c, -1);
                    if (split.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str)) {
                            this.d.add(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        synchronized (this.d) {
            this.a.edit().putString(this.b, h()).commit();
        }
    }

    private void j() {
        this.e.execute(new Runnable() { // from class: com.google.firebase.messaging.w0
            @Override // java.lang.Runnable
            public final void run() {
                x0.this.i();
            }
        });
    }

    public boolean b(String str) {
        boolean c;
        if (TextUtils.isEmpty(str) || str.contains(this.c)) {
            return false;
        }
        synchronized (this.d) {
            c = c(this.d.add(str));
        }
        return c;
    }

    public String f() {
        String str;
        synchronized (this.d) {
            str = (String) this.d.peek();
        }
        return str;
    }

    public boolean g(Object obj) {
        boolean c;
        synchronized (this.d) {
            c = c(this.d.remove(obj));
        }
        return c;
    }

    public String h() {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            sb2.append(this.c);
        }
        return sb2.toString();
    }
}
