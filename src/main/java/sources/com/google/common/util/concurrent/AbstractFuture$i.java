package com.google.common.util.concurrent;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class AbstractFuture$i extends AbstractFuture$b {
    static final Unsafe a;
    static final long b;
    static final long c;
    static final long d;
    static final long e;
    static final long f;

    class a implements PrivilegedExceptionAction {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        } catch (SecurityException unused) {
            unsafe = (Unsafe) AccessController.doPrivileged(new a());
        }
        try {
            c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
            b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
            d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));
            e = unsafe.objectFieldOffset(AbstractFuture$j.class.getDeclaredField("a"));
            f = unsafe.objectFieldOffset(AbstractFuture$j.class.getDeclaredField(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B));
            a = unsafe;
        } catch (NoSuchFieldException e3) {
            throw new RuntimeException(e3);
        }
    }

    private AbstractFuture$i() {
        super();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    boolean a(AbstractFuture abstractFuture, AbstractFuture$d abstractFuture$d, AbstractFuture$d abstractFuture$d2) {
        return com.google.android.libraries.places.internal.a.a(a, abstractFuture, b, abstractFuture$d, abstractFuture$d2);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
        return com.google.android.libraries.places.internal.a.a(a, abstractFuture, d, obj, obj2);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    boolean c(AbstractFuture abstractFuture, AbstractFuture$j abstractFuture$j, AbstractFuture$j abstractFuture$j2) {
        return com.google.android.libraries.places.internal.a.a(a, abstractFuture, c, abstractFuture$j, abstractFuture$j2);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    AbstractFuture$d d(AbstractFuture abstractFuture, AbstractFuture$d abstractFuture$d) {
        AbstractFuture$d access$700;
        do {
            access$700 = AbstractFuture.access$700(abstractFuture);
            if (abstractFuture$d == access$700) {
                return access$700;
            }
        } while (!a(abstractFuture, access$700, abstractFuture$d));
        return access$700;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    AbstractFuture$j e(AbstractFuture abstractFuture, AbstractFuture$j abstractFuture$j) {
        AbstractFuture$j access$800;
        do {
            access$800 = AbstractFuture.access$800(abstractFuture);
            if (abstractFuture$j == access$800) {
                return access$800;
            }
        } while (!c(abstractFuture, access$800, abstractFuture$j));
        return access$800;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    void f(AbstractFuture$j abstractFuture$j, AbstractFuture$j abstractFuture$j2) {
        a.putObject(abstractFuture$j, f, abstractFuture$j2);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture$b
    void g(AbstractFuture$j abstractFuture$j, Thread thread) {
        a.putObject(abstractFuture$j, e, thread);
    }
}
