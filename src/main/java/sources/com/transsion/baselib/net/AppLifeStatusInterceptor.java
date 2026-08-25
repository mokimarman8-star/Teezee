package com.transsion.baselib.net;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.therouter.TheRouter;
import com.transsion.baselib.report.k;
import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class AppLifeStatusInterceptor implements Interceptor {
    public static final a d = new a((DefaultConstructorMarker) null);
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.baselib.net.b
        public final Object invoke() {
            Handler f;
            f = AppLifeStatusInterceptor.f();
            return f;
        }
    });
    private final HashSet c;

    public AppLifeStatusInterceptor() {
        HashSet hashSet = new HashSet();
        this.c = hashSet;
        hashSet.add("/wefeed-mobile-bff/message/push/local/list");
        hashSet.add("/wefeed-mobile-bff/subject-api/get-ext-captions");
        hashSet.add("/wefeed-mobile-bff/app/config");
        hashSet.add("/wefeed-mobile-bff/live/sub-upcomming-match");
        hashSet.add("/wefeed-mobile-bff/subject-api/widget");
        d();
    }

    private final void d() {
        k.a.g(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler f() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        ij.k.p(TheRouter.c("/main/page_not_available"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        if (this.a.get()) {
            this.a.set(false);
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new requestForBackToForeground.1((Continuation) null), 3, (Object) null);
        }
    }

    private final boolean i(Interceptor.Chain chain) {
        k kVar = k.a;
        if (!kVar.q() || ((!kVar.v() && d.a.b().get()) || kVar.r())) {
            return false;
        }
        String path = Uri.parse(chain.request().url().toString()).getPath();
        if (!kVar.v() && CollectionsKt.b0(this.c, path)) {
            return false;
        }
        this.a.set(true);
        return true;
    }

    public final Handler e() {
        return (Handler) this.b.getValue();
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.h(chain, "chain");
        Request request = chain.request();
        if (!i(chain)) {
            Response proceed = chain.proceed(request);
            if (proceed.code() == 403 && !k.a.q()) {
                e().post(new a());
            }
            return proceed;
        }
        a.a.p("HttpTag", new String[]{"AppLifeStatusInterceptor response " + ((Object) null) + " : " + request.url() + " is Background request cancel "}, true);
        throw new IOException("is Background request cancel");
    }
}
