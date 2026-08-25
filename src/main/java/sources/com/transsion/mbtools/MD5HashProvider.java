package com.transsion.mbtools;

import android.os.Build;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.security.MessageDigest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MD5HashProvider {
    public static final MD5HashProvider a = new MD5HashProvider();
    private static final Lazy b = LazyKt.b(new Function0<String>() { // from class: com.transsion.mbtools.MD5HashProvider$SYSTEM_SALT$2
        public final String invoke() {
            String str = Build.ID;
            Intrinsics.g(str, "ID");
            String substring = str.substring(0, 4);
            Intrinsics.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String str2 = Build.MANUFACTURER;
            Intrinsics.g(str2, "MANUFACTURER");
            return substring + StringsKt.u1(str2);
        }
    });

    private MD5HashProvider() {
    }

    private final String b() {
        return (String) b.getValue();
    }

    public final String a(String str) {
        Intrinsics.h(str, "content");
        MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_MD5);
        byte[] bytes = (b() + str).getBytes(Charsets.b);
        Intrinsics.g(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = messageDigest.digest(bytes);
        StringBuilder sb = new StringBuilder();
        Intrinsics.g(digest, "hashBytes");
        for (byte b2 : digest) {
            sb.append(CharsKt.f((b2 & 255) >> 4, 16));
            sb.append(CharsKt.f(b2 & 15, 16));
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
