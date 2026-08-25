package com.tn.lib.thread;

import android.os.MessageQueue;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface a extends MessageQueue.IdleHandler {
    public static final C0138a a = C0138a.a;

    /* renamed from: com.tn.lib.thread.a$a, reason: collision with other inner class name */
    public static final class C0138a {
        static final /* synthetic */ C0138a a = new C0138a();
        private static final List b = new CopyOnWriteArrayList();

        private C0138a() {
        }

        public final List a() {
            return b;
        }
    }
}
