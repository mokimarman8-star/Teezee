package com.transsion.push.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.transsion.http.impl.BitmapCallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n {

    class a implements c {
        final /* synthetic */ HashMap a;
        final /* synthetic */ AtomicInteger b;
        final /* synthetic */ d c;

        a(HashMap hashMap, AtomicInteger atomicInteger, d dVar) {
            this.a = hashMap;
            this.b = atomicInteger;
            this.c = dVar;
        }

        @Override // com.transsion.push.utils.n.c
        public void a(String str, Bitmap bitmap) {
            this.a.put(str, bitmap);
            if (this.b.decrementAndGet() == 0) {
                this.c.a(this.a);
            }
        }
    }

    class b extends BitmapCallback {
        final /* synthetic */ String e;
        final /* synthetic */ c f;
        final /* synthetic */ int g;

        b(String str, c cVar, int i) {
            this.e = str;
            this.f = cVar;
            this.g = i;
        }

        @Override // com.transsion.http.impl.BitmapCallback
        public void y(int i, Bitmap bitmap, Throwable th2) {
            PushLogUtils.LOG.i("image download fail, url:" + this.e);
            c cVar = this.f;
            if (cVar != null) {
                cVar.a(this.e, null);
            }
        }

        @Override // com.transsion.http.impl.BitmapCallback
        public void z(int i, Bitmap bitmap) {
            PushLogUtils.LOG.g("image download complete, url:" + this.e);
            c cVar = this.f;
            if (cVar != null) {
                if (this.g != 3) {
                    cVar.a(this.e, bitmap);
                    return;
                }
                try {
                    this.f.a(this.e, com.transsion.push.utils.b.a(yj.a.a(), bitmap));
                } catch (Exception unused) {
                    this.f.a(this.e, null);
                }
            }
        }
    }

    interface c {
        void a(String str, Bitmap bitmap);
    }

    interface d {
        void a(HashMap hashMap);
    }

    private static void a(int i, String str, c cVar) {
        try {
            ((gl.a) ((gl.a) ((gl.a) ((gl.a) el.a.a(yj.a.a()).f(true).b(yj.a.c())).a(10000)).c(10000)).d(str)).e().a(new b(str, cVar, i));
        } catch (Exception unused) {
            if (cVar != null) {
                cVar.a(str, null);
            }
        }
    }

    public static void b(int i, List list, d dVar) {
        HashMap hashMap = new HashMap();
        AtomicInteger atomicInteger = new AtomicInteger(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!TextUtils.isEmpty(str)) {
                a(i, str, new a(hashMap, atomicInteger, dVar));
            }
        }
    }
}
