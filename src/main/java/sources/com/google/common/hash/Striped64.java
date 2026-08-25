package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class Striped64 extends Number {
    private static final Unsafe a;
    private static final long b;
    private static final long c;
    volatile transient long base;
    volatile transient int busy;
    volatile transient b[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

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

    static final class b {
        private static final Unsafe b;
        private static final long c;
        volatile long a;

        static {
            try {
                Unsafe a = Striped64.a();
                b = a;
                c = a.objectFieldOffset(b.class.getDeclaredField("a"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        b(long j) {
            this.a = j;
        }

        final boolean a(long j, long j2) {
            return b.compareAndSwapLong(this, c, j, j2);
        }
    }

    static {
        try {
            Unsafe a2 = a();
            a = a2;
            b = a2.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            c = a2.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    Striped64() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe a() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e) {
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new a());
        }
    }

    final boolean casBase(long j, long j2) {
        return a.compareAndSwapLong(this, b, j, j2);
    }

    final boolean casBusy() {
        return a.compareAndSwapInt(this, c, 0, 1);
    }

    abstract long fn(long j, long j2);

    final void internalReset(long j) {
        b[] bVarArr = this.cells;
        this.base = j;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                if (bVar != null) {
                    bVar.a = j;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0023 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void retryUpdate(long j, int[] iArr, boolean z) {
        int i;
        int[] iArr2;
        boolean z2;
        int length;
        boolean z3;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            threadHashCode.set(iArr2);
            i = rng.nextInt();
            if (i == 0) {
                i = 1;
            }
            iArr2[0] = i;
        } else {
            i = iArr[0];
            iArr2 = iArr;
        }
        boolean z4 = false;
        int i2 = i;
        boolean z5 = z;
        while (true) {
            b[] bVarArr = this.cells;
            if (bVarArr != null && (length = bVarArr.length) > 0) {
                b bVar = bVarArr[(length - 1) & i2];
                if (bVar == null) {
                    if (this.busy == 0) {
                        b bVar2 = new b(j);
                        if (this.busy == 0 && casBusy()) {
                            try {
                                b[] bVarArr2 = this.cells;
                                if (bVarArr2 != null && (length2 = bVarArr2.length) > 0) {
                                    int i3 = (length2 - 1) & i2;
                                    if (bVarArr2[i3] == null) {
                                        bVarArr2[i3] = bVar2;
                                        z3 = true;
                                        if (!z3) {
                                            return;
                                        }
                                    }
                                }
                                z3 = false;
                                if (!z3) {
                                }
                            } finally {
                            }
                        }
                    }
                    z4 = false;
                } else if (z5) {
                    long j2 = bVar.a;
                    if (bVar.a(j2, fn(j2, j))) {
                        return;
                    }
                    if (length < NCPU && this.cells == bVarArr) {
                        if (!z4) {
                            z4 = true;
                        } else if (this.busy == 0 && casBusy()) {
                            try {
                                if (this.cells == bVarArr) {
                                    b[] bVarArr3 = new b[length << 1];
                                    for (int i4 = 0; i4 < length; i4++) {
                                        bVarArr3[i4] = bVarArr[i4];
                                    }
                                    this.cells = bVarArr3;
                                }
                                this.busy = 0;
                                z4 = false;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    z4 = false;
                } else {
                    z5 = true;
                }
                int i5 = i2 ^ (i2 << 13);
                int i6 = i5 ^ (i5 >>> 17);
                i2 = i6 ^ (i6 << 5);
                iArr2[0] = i2;
            } else if (this.busy == 0 && this.cells == bVarArr && casBusy()) {
                try {
                    if (this.cells == bVarArr) {
                        b[] bVarArr4 = new b[2];
                        bVarArr4[i2 & 1] = new b(j);
                        this.cells = bVarArr4;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                } finally {
                }
            } else {
                long j3 = this.base;
                if (casBase(j3, fn(j3, j))) {
                    return;
                }
            }
        }
    }
}
