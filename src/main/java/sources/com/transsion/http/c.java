package com.transsion.http;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.transsion.http.impl.r;
import el.b;
import el.d;
import fl.h;
import fl.j;
import il.f;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import kl.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class c implements Runnable, Comparable<c> {
    private final r a;
    private final f b;
    private final AtomicBoolean c = new AtomicBoolean();
    private final h d;
    private volatile boolean e;

    public c(b bVar, r rVar) {
        this.a = rVar;
        f d = bVar.d();
        this.b = d;
        this.d = bVar.b();
        new WeakReference(d.e().m());
    }

    private void b() throws IOException {
        try {
            this.b.i();
            if (a()) {
                this.b.a();
                return;
            }
            byte[] d = a.d(a.b(this.b.c()));
            r rVar = this.a;
            if (rVar != null) {
                rVar.c(this.b.g(), d);
            }
            if (this.b.e().o() && this.d != null) {
                ((fl.b) this.d).c(new d(this.b.e().n()), new j(new fl.a(), ByteBuffer.wrap(d)));
            }
            this.b.a();
        } catch (Throwable th2) {
            this.b.a();
            throw th2;
        }
    }

    private synchronized void c() {
        r rVar;
        if (!this.e && this.c.get() && (rVar = this.a) != null) {
            rVar.e();
        }
    }

    public boolean a() {
        boolean z = this.c.get();
        if (z) {
            c();
        }
        return z;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull c cVar) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e5, code lost:
    
        if (r0 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x010e, code lost:
    
        if (a() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0110, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0111, code lost:
    
        r0 = r6.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0113, code lost:
    
        if (r0 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0115, code lost:
    
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0118, code lost:
    
        r6.e = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0105, code lost:
    
        ((fl.b) r0).b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0103, code lost:
    
        if (r0 == null) goto L55;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        h hVar;
        r rVar;
        jl.c cVar = jl.a.a;
        StringBuilder sb = new StringBuilder();
        sb.append("run Current Looper:");
        sb.append(Looper.myLooper() == Looper.getMainLooper() ? "Main Looper" : "thread Looper");
        cVar.d("book", sb.toString());
        if (a()) {
            return;
        }
        r rVar2 = this.a;
        if (rVar2 != null) {
            rVar2.a();
        }
        try {
            try {
                if (this.b.e().o()) {
                    h hVar2 = this.d;
                    if (hVar2 != null) {
                        File a = ((fl.b) hVar2).a(new d(this.b.e().n()));
                        if (a == null || !a.exists() || a.length() <= 0) {
                            b();
                        } else {
                            jl.c cVar2 = jl.a.a;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("image url:");
                            sb2.append(this.b.e().n());
                            cVar2.d("image", sb2.toString());
                            jl.c cVar3 = jl.a.a;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("image path:");
                            sb3.append(a.getPath());
                            cVar3.d("image", sb3.toString());
                            if (a()) {
                                this.b.a();
                                h hVar3 = this.d;
                                if (hVar3 != null) {
                                    ((fl.b) hVar3).b();
                                    return;
                                }
                                return;
                            }
                            r rVar3 = this.a;
                            if (rVar3 != null) {
                                rVar3.c(250, a.d(a.a(a)));
                            }
                        }
                    } else {
                        b();
                    }
                } else {
                    b();
                }
                this.b.a();
                hVar = this.d;
            } catch (Exception e) {
                if (!a() && (rVar = this.a) != null) {
                    rVar.d(this.b.g(), null, e);
                }
                this.b.a();
                hVar = this.d;
            }
        } catch (Throwable th2) {
            this.b.a();
            h hVar4 = this.d;
            if (hVar4 != null) {
                ((fl.b) hVar4).b();
            }
            throw th2;
        }
    }
}
