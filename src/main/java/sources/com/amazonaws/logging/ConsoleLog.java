package com.amazonaws.logging;

import com.amazonaws.logging.LogFactory;
import java.io.PrintStream;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class ConsoleLog implements Log {
    private final String a;
    private LogFactory.Level b = null;

    public ConsoleLog(String str) {
        this.a = str;
    }

    private LogFactory.Level l() {
        LogFactory.Level level = this.b;
        return level != null ? level : LogFactory.a();
    }

    private void o(LogFactory.Level level, Object obj, Throwable th) {
        PrintStream printStream = System.out;
        printStream.printf("%s/%s: %s\n", this.a, level.name(), obj);
        if (th != null) {
            printStream.println(th.toString());
        }
    }

    @Override // com.amazonaws.logging.Log
    public void a(Object obj) {
        if (b()) {
            o(LogFactory.Level.DEBUG, obj, null);
        }
    }

    @Override // com.amazonaws.logging.Log
    public boolean b() {
        return l() == null || l().getValue() <= LogFactory.Level.DEBUG.getValue();
    }

    @Override // com.amazonaws.logging.Log
    public boolean c() {
        return l() == null || l().getValue() <= LogFactory.Level.INFO.getValue();
    }

    @Override // com.amazonaws.logging.Log
    public void d(Object obj) {
        if (c()) {
            o(LogFactory.Level.INFO, obj, null);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void e(Object obj, Throwable th) {
        if (h()) {
            o(LogFactory.Level.ERROR, obj, th);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void f(Object obj) {
        if (h()) {
            o(LogFactory.Level.ERROR, obj, null);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void g(Object obj, Throwable th) {
        if (b()) {
            o(LogFactory.Level.DEBUG, obj, th);
        }
    }

    @Override // com.amazonaws.logging.Log
    public boolean h() {
        return l() == null || l().getValue() <= LogFactory.Level.ERROR.getValue();
    }

    @Override // com.amazonaws.logging.Log
    public void i(Object obj, Throwable th) {
        if (n()) {
            o(LogFactory.Level.WARN, obj, th);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void j(Object obj) {
        if (n()) {
            o(LogFactory.Level.WARN, obj, null);
        }
    }

    @Override // com.amazonaws.logging.Log
    public void k(Object obj) {
        if (m()) {
            o(LogFactory.Level.TRACE, obj, null);
        }
    }

    public boolean m() {
        return l() == null || l().getValue() <= LogFactory.Level.TRACE.getValue();
    }

    public boolean n() {
        return l() == null || l().getValue() <= LogFactory.Level.WARN.getValue();
    }
}
