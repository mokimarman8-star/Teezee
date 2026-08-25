package com.transsion.postdetail.viewmodel;

import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.R$string;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import mg.b;
import okhttp3.RequestBody;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostRecommendFragmentViewModel extends t0 {
    public static final a d = new a(null);
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.l
        public final Object invoke() {
            ao.b j;
            j = PostRecommendFragmentViewModel.j();
            return j;
        }
    });
    private final b0 b = new b0();
    private final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.m
        public final Object invoke() {
            b0 f;
            f = PostRecommendFragmentViewModel.f();
            return f;
        }
    });

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 f() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ao.b i() {
        return (ao.b) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ao.b j() {
        return (ao.b) kg.c.e.a().h(ao.b.class);
    }

    public final void g(String str, int i, int i2, int i3) {
        String str2;
        Intrinsics.h(str, "postId");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!yg.l.a.e()) {
            fh.b.a.d(R$string.upload_no_network);
            this.b.n((Object) null);
            return;
        }
        ImmVideoRequestEntity immVideoRequestEntity = new ImmVideoRequestEntity();
        immVideoRequestEntity.setPage(String.valueOf(i2));
        immVideoRequestEntity.setPerPage(i3);
        immVideoRequestEntity.setSessionId(jg.b.a.h());
        Uri b = com.transsion.baselib.report.h.a.b();
        if (b == null || (str2 = b.toString()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        immVideoRequestEntity.setDeepLink(str2);
        immVideoRequestEntity.setUserPrefer(BuildConfig.FLAVOR);
        immVideoRequestEntity.setLatest_events(ej.b.a.e());
        immVideoRequestEntity.setPostId(str);
        immVideoRequestEntity.setTabId(i);
        b.a aVar = mg.b.a;
        String j = com.blankj.utilcode.util.o.j(immVideoRequestEntity);
        Intrinsics.g(j, "toJson(...)");
        RequestBody a2 = aVar.a(j);
        if (a2 != null) {
            kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new PostRecommendFragmentViewModel$getImmVideoList$1$1(this, a2, null), 3, (Object) null);
        }
    }

    public final LiveData h() {
        return this.b;
    }
}
