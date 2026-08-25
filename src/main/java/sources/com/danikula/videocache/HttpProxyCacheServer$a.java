package com.danikula.videocache;

import android.content.Context;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class HttpProxyCacheServer$a {
    private File a;
    private r7.b b = new r7.a();
    private a c;

    public HttpProxyCacheServer$a(Context context) {
        this.a = p.b(context);
    }

    private c b() {
        return new c(this.a, this.b, this.c);
    }

    public HttpProxyCacheServer a() {
        return new HttpProxyCacheServer(b(), (f) null);
    }

    public HttpProxyCacheServer$a c(File file) {
        this.a = (File) l.c(file);
        return this;
    }

    public HttpProxyCacheServer$a d(a aVar) {
        this.c = aVar;
        return this;
    }
}
