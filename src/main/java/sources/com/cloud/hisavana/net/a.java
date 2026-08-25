package com.cloud.hisavana.net;

import com.cloud.hisavana.net.impl.IHttpCallback;
import kotlin.jvm.internal.Ref;
import okhttp3.Request;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Ref.ObjectRef a;
    public final /* synthetic */ Request b;
    public final /* synthetic */ IHttpCallback c;

    public /* synthetic */ a(Ref.ObjectRef objectRef, Request request, IHttpCallback iHttpCallback) {
        this.a = objectRef;
        this.b = request;
        this.c = iHttpCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpRequest.a(this.a, this.b, this.c);
    }
}
