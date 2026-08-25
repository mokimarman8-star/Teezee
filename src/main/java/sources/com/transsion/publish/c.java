package com.transsion.publish;

import android.text.TextUtils;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.api.LinkEntity;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jsoup.nodes.Document;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final a a = new a(null);
    private static final Lazy b = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.publish.b
        public final Object invoke() {
            c c;
            c = c.c();
            return c;
        }
    });

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return (c) c.b.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c c() {
        return new c();
    }

    private final void e(Runnable runnable) {
        p.b.a().d(runnable);
    }

    private final void f(String str, String str2, String str3, boolean z) {
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setTitle(str);
        linkEntity.setCover(str2);
        linkEntity.setUrl(str3);
        linkEntity.setType(4);
        linkEntity.setLoading(z);
        jo.b bVar = new jo.b();
        bVar.o(4);
        bVar.n(1);
        bVar.p(linkEntity);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(c cVar, String str) {
        try {
            cVar.f(str == null ? BuildConfig.FLAVOR : str, BuildConfig.FLAVOR, str == null ? BuildConfig.FLAVOR : str, false);
            if (str != null) {
                cVar.i(str);
            }
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                a.a.f(wf.a.a, "LinkParseManager", message, false, 4, (Object) null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String str2 = str == null ? BuildConfig.FLAVOR : str;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            cVar.f(str2, BuildConfig.FLAVOR, str, true);
        }
    }

    private final void i(String str) {
        Document document = rz.a.a(str).a(true).get();
        Intrinsics.g(document, "get(...)");
        String j1 = document.j1();
        Intrinsics.g(j1, "title(...)");
        a.a.f(wf.a.a, "LinkParseManager", "title:" + j1, false, 4, (Object) null);
        f(j1, BuildConfig.FLAVOR, str, true);
    }

    public final void g(final String str) {
        if (TextUtils.isEmpty(str)) {
            fh.b.a.e("Not a valid link");
        } else {
            e(new Runnable() { // from class: com.transsion.publish.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.h(c.this, str);
                }
            });
        }
    }
}
