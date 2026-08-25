package com.cloud.hisavana.net.disklrucache.utils;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.hisavana.net.disklrucache.impl.DiskCacheProvider;
import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;
import com.cloud.hisavana.net.utils.StorageUtils;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.e;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DiskLruCacheUtil {
    private static IDiskCache c;
    private static IDiskCache d;
    private static IDiskCache e;
    public static final Charset a = StandardCharsets.US_ASCII;
    public static final Charset b = StandardCharsets.UTF_8;
    private static final char[] f = "0123456789abcdef".toCharArray();
    private static final char[] g = new char[64];

    private DiskLruCacheUtil() {
    }

    private static String a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = f;
            cArr[i2] = cArr2[(b2 & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                c.netLog("closeQuietly --> " + Log.getStackTraceString(e2));
            }
        }
    }

    public static void c(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                c(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    public static File d(int i) {
        return i != 3 ? i != 4 ? StorageUtils.a(e.a()) : StorageUtils.c(e.a(), true) : StorageUtils.f(e.a(), true);
    }

    public static String e(String str, int i) {
        File d2;
        if (TextUtils.isEmpty(str) || (d2 = d(i)) == null) {
            return "";
        }
        return d2 + File.separator + (SafeKeyUtils.b(new ImageCacheURL(str)) + ".0");
    }

    private static IDiskCache f() {
        if (e == null) {
            e = new DiskCacheProvider().b(HttpRequest.a.f() <= 0 ? 209715200L : r0.f() * 1024 * 1024, 4);
        }
        return e;
    }

    public static synchronized IDiskCache g(int i) {
        synchronized (DiskLruCacheUtil.class) {
            if (i == 3) {
                return i();
            }
            if (i != 4) {
                return h();
            }
            return f();
        }
    }

    private static IDiskCache h() {
        if (c == null) {
            c = new DiskCacheProvider().b(HttpRequest.a.e() <= 0 ? 314572800L : r0.e() * 1024 * 1024, 1);
        }
        return c;
    }

    private static IDiskCache i() {
        if (d == null) {
            d = new DiskCacheProvider().b(HttpRequest.a.i() <= 0 ? 157286400L : r0.i() * 1024 * 1024, 3);
        }
        return d;
    }

    public static String j(byte[] bArr) {
        String a2;
        char[] cArr = g;
        synchronized (cArr) {
            a2 = a(bArr, cArr);
        }
        return a2;
    }
}
