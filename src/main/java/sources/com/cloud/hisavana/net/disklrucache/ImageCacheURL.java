package com.cloud.hisavana.net.disklrucache;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.n;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ImageCacheURL {
    private static final Charset d = StandardCharsets.UTF_8;
    private volatile byte[] a;
    private final String b;
    private final String c;

    public ImageCacheURL(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c = str;
            this.b = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        } else {
            this.c = "";
            this.b = "";
            c.netLog("url must be can not null or empty");
        }
    }

    public byte[] a() {
        if (this.a == null) {
            this.a = this.b.getBytes(d);
        }
        return this.a;
    }

    public String b() {
        return d();
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return n.a(this.b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageCacheURL) {
            return b().equals(((ImageCacheURL) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode() * 31;
    }
}
