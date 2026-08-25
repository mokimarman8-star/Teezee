package com.transsion.baselib.net;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final d a = new d();
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final AtomicBoolean c = new AtomicBoolean(true);

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(Ref.ObjectRef objectRef, Message message) {
        Intrinsics.h(message, "msg");
        a.a.r(wf.a.a, "hook", new String[]{"msg= " + message.what}, false, 4, (Object) null);
        AtomicBoolean atomicBoolean = b;
        if (!atomicBoolean.get()) {
            atomicBoolean.set(true);
            int i = message.what;
            int i2 = Build.VERSION.SDK_INT;
            boolean z = i2 >= 35 && i == 164;
            boolean z2 = i2 >= 28 && i == 159;
            boolean z3 = i2 < 28 && i == 100;
            if (z2 || z3 || z) {
                c.set(true);
            } else {
                c.set(false);
            }
        }
        Handler.Callback callback = (Handler.Callback) objectRef.element;
        if (callback != null) {
            return callback.handleMessage(message);
        }
        return false;
    }

    public final AtomicBoolean b() {
        return c;
    }

    public final void c() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = cls.getDeclaredField("mH");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Field declaredField3 = obj2.getClass().getSuperclass().getDeclaredField("mCallback");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj2);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            if (obj3 != null) {
                objectRef.element = (Handler.Callback) obj3;
            }
            declaredField3.set(obj2, new Handler.Callback() { // from class: com.transsion.baselib.net.c
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    boolean d;
                    d = d.d(objectRef, message);
                    return d;
                }
            });
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder();
            sb.append("exception= ");
            sb.append(message);
        }
    }
}
