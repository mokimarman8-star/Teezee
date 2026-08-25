package com.transsion.transfer.impl;

import com.transsion.transfer.androidasync.http.b0;
import com.transsion.transfer.impl.PingPongHelper;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class PingPongHelper {
    private final String a;
    private final boolean b;
    private final com.transsion.transfer.androidasync.http.b0 c;
    private final a d;
    private final Stack e;
    private boolean f;
    private int g;
    private final int h;
    private final Timer i;
    private final PingPongHelper$task$1 j;

    public interface a {
        void a(String str, com.transsion.transfer.androidasync.http.b0 b0Var);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.transsion.transfer.impl.PingPongHelper$task$1] */
    public PingPongHelper(String remoteIP, boolean z, com.transsion.transfer.androidasync.http.b0 socket, a pingPongListener) {
        Intrinsics.h(remoteIP, "remoteIP");
        Intrinsics.h(socket, "socket");
        Intrinsics.h(pingPongListener, "pingPongListener");
        this.a = remoteIP;
        this.b = z;
        this.c = socket;
        this.d = pingPongListener;
        this.e = new Stack();
        this.h = 2;
        socket.D(new b0.b() { // from class: com.transsion.transfer.impl.j
            @Override // com.transsion.transfer.androidasync.http.b0.b
            public final void a(String str) {
                PingPongHelper.b(PingPongHelper.this, str);
            }
        });
        this.i = new Timer();
        this.j = new TimerTask() { // from class: com.transsion.transfer.impl.PingPongHelper$task$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                int i;
                int i2;
                boolean z2;
                String m;
                Stack stack;
                com.transsion.transfer.androidasync.http.b0 b0Var;
                int i3;
                Stack stack2;
                int i4;
                Stack stack3;
                PingPongHelper.a aVar;
                String str;
                com.transsion.transfer.androidasync.http.b0 b0Var2;
                i = PingPongHelper.this.g;
                i2 = PingPongHelper.this.h;
                if (i >= i2) {
                    aVar = PingPongHelper.this.d;
                    str = PingPongHelper.this.a;
                    b0Var2 = PingPongHelper.this.c;
                    aVar.a(str, b0Var2);
                    PingPongHelper.this.f = true;
                }
                z2 = PingPongHelper.this.f;
                if (z2) {
                    return;
                }
                m = PingPongHelper.this.m();
                stack = PingPongHelper.this.e;
                stack.push(m);
                b0Var = PingPongHelper.this.c;
                b0Var.x(m);
                i3 = PingPongHelper.this.g;
                PingPongHelper.this.g = i3 + 1;
                stack2 = PingPongHelper.this.e;
                int size = stack2.size();
                i4 = PingPongHelper.this.h;
                if (size > i4) {
                    stack3 = PingPongHelper.this.e;
                    stack3.remove(0);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PingPongHelper pingPongHelper, String str) {
        pingPongHelper.g = 0;
        pingPongHelper.e.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m() {
        return (this.b ? "server" : "client") + "-" + System.currentTimeMillis();
    }

    public final void n() {
        this.i.schedule(this.j, 0L, 2000L);
    }

    public final void o() {
        this.f = true;
        cancel();
        this.i.cancel();
    }
}
