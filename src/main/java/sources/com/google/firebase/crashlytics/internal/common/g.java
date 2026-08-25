package com.google.firebase.crashlytics.internal.common;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class g {
    private static final String b = CommonUtils.z(UUID.randomUUID().toString() + System.currentTimeMillis());
    private static final AtomicLong c = new AtomicLong(0);
    private final String a;

    g() {
        byte[] bArr = new byte[10];
        f(bArr);
        e(bArr);
        d(bArr);
        String t = CommonUtils.t(bArr);
        Locale locale = Locale.US;
        this.a = String.format(locale, "%s%s%s%s", t.substring(0, 12), t.substring(12, 16), t.subSequence(16, 20), b.substring(0, 12)).toUpperCase(locale);
    }

    private static byte[] a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private void d(byte[] bArr) {
        byte[] b2 = b(Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b2[0];
        bArr[9] = b2[1];
    }

    private void e(byte[] bArr) {
        byte[] b2 = b(c.incrementAndGet());
        bArr[6] = b2[0];
        bArr[7] = b2[1];
    }

    private void f(byte[] bArr) {
        long time = new Date().getTime();
        byte[] a = a(time / 1000);
        bArr[0] = a[0];
        bArr[1] = a[1];
        bArr[2] = a[2];
        bArr[3] = a[3];
        byte[] b2 = b(time % 1000);
        bArr[4] = b2[0];
        bArr[5] = b2[1];
    }

    public String c() {
        return this.a;
    }

    public String toString() {
        return this.a;
    }
}
