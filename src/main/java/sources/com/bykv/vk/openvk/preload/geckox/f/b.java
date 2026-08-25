package com.bykv.vk.openvk.preload.geckox.f;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class b {
    private final Map<String, a> a = new HashMap();
    private AtomicBoolean b = new AtomicBoolean(false);
    private String c;

    public b(Context context, String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key empty");
        }
        if (file != null) {
            this.c = new File(file, str).getAbsolutePath();
            return;
        }
        this.c = new File(context.getFilesDir(), "gecko_offline_res_x" + File.separator + str).getAbsolutePath();
    }

    private a d(String str) {
        a aVar;
        int indexOf = str.indexOf("/");
        if (indexOf == -1) {
            new RuntimeException("channel：".concat(str));
        }
        String substring = str.substring(0, indexOf);
        synchronized (this.a) {
            try {
                aVar = this.a.get(substring);
                if (aVar == null) {
                    aVar = new a(this.c, substring);
                    this.a.put(substring, aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public final InputStream a(String str) throws Exception {
        if (this.b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).a(str);
    }

    public final String a() {
        return this.c;
    }

    public final int b(String str) throws Exception {
        if (this.b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).c(str);
    }

    public final Map<String, Long> b() {
        HashMap hashMap = new HashMap();
        synchronized (this.a) {
            try {
                Collection<a> values = this.a.values();
                if (values == null) {
                    return hashMap;
                }
                for (a aVar : values) {
                    hashMap.put(aVar.b(), aVar.a());
                }
                return hashMap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() throws Exception {
        if (this.b.getAndSet(true)) {
            return;
        }
        GeckoLogger.d("Loader", "release version res loader");
        synchronized (this.a) {
            try {
                Iterator<a> it = this.a.values().iterator();
                while (it.hasNext()) {
                    it.next().c();
                }
                this.a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c(String str) throws Exception {
        if (this.b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).b(str);
    }
}
