package com.transsion.base.report.athena.sampler;

import com.transsion.api.gateway.utils.EncoderUtil;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Charsets;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final boolean a(double d, String str, String str2, int i) {
        Intrinsics.h(str, "deviceId");
        Intrinsics.h(str2, "batchKey");
        if (d <= 0.0d) {
            return false;
        }
        if (d >= 100.0d) {
            return true;
        }
        String str3 = str + '-' + str2;
        MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_MD5);
        byte[] bytes = str3.getBytes(Charsets.b);
        Intrinsics.g(bytes, "getBytes(...)");
        byte[] digest = messageDigest.digest(bytes);
        return (((digest[3] & 255) | ((((digest[0] & 255) << 24) | ((digest[1] & 255) << 16)) | ((digest[2] & 255) << 8))) & Integer.MAX_VALUE) % i < MathKt.c((d / 100.0d) * ((double) i));
    }
}
