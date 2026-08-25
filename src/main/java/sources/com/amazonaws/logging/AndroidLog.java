package com.amazonaws.logging;

import com.amazonaws.logging.LogFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AndroidLog implements Log {
    private final String a;
    private LogFactory.Level b = null;

    public AndroidLog(String str) {
        this.a = str;
    }

    private LogFactory.Level l() {
        LogFactory.Level level = this.b;
        return level != null ? level : LogFactory.a();
    }

    @Override // com.amazonaws.logging.Log
    public void a(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            obj.toString();
        }
    }

    @Override // com.amazonaws.logging.Log
    public boolean b() {
        return android.util.Log.isLoggable(this.a, 3) && (l() == null || l().getValue() <= LogFactory.Level.DEBUG.getValue());
    }

    @Override // com.amazonaws.logging.Log
    public boolean c() {
        return android.util.Log.isLoggable(this.a, 4) && (l() == null || l().getValue() <= LogFactory.Level.INFO.getValue());
    }

    @Override // com.amazonaws.logging.Log
    public void d(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.INFO.getValue()) {
            obj.toString();
        }
    }

    @Override // com.amazonaws.logging.Log
    public void e(Object obj, Throwable th) {
        if (l() == null || l().getValue() <= LogFactory.Level.ERROR.getValue()) {
            android.util.Log.e(this.a, obj.toString(), th);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void f(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.ERROR.getValue()) {
            android.util.Log.e(this.a, obj.toString());
        }
    }

    @Override // com.amazonaws.logging.Log
    public void g(Object obj, Throwable th) {
        if (l() == null || l().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            obj.toString();
        }
    }

    @Override // com.amazonaws.logging.Log
    public boolean h() {
        return android.util.Log.isLoggable(this.a, 6) && (l() == null || l().getValue() <= LogFactory.Level.ERROR.getValue());
    }

    @Override // com.amazonaws.logging.Log
    public void i(Object obj, Throwable th) {
        if (l() == null || l().getValue() <= LogFactory.Level.WARN.getValue()) {
            android.util.Log.w(this.a, obj.toString(), th);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void j(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.WARN.getValue()) {
            android.util.Log.w(this.a, obj.toString());
        }
    }

    @Override // com.amazonaws.logging.Log
    public void k(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.TRACE.getValue()) {
            android.util.Log.v(this.a, obj.toString());
        }
    }
}
