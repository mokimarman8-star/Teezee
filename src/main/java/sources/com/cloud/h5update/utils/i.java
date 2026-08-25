package com.cloud.h5update.utils;

import com.cloud.h5update.utils.h;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class i {
    public static final i a = new i();

    private i() {
    }

    private final String a(byte[] bArr) {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.g(charArray, "this as java.lang.String).toCharArray()");
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(charArray[(b >> 4) & 15]);
            sb.append(charArray[b & 15]);
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "r.toString()");
        return sb2;
    }

    public final String b(File file) {
        h.a aVar = h.a;
        String str = "";
        if (!aVar.r(file)) {
            return "";
        }
        InputStream inputStream = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                inputStream = aVar.n(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    Intrinsics.e(inputStream);
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                byte[] digest = messageDigest.digest();
                Intrinsics.g(digest, "digest.digest()");
                str = a(digest);
                h.a.e(inputStream);
            } catch (Exception e) {
                rf.b.a.e(e);
                h.a.e(inputStream);
            }
            return str;
        } catch (Throwable th) {
            h.a.e(inputStream);
            throw th;
        }
    }
}
