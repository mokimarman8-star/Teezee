package com.transsion.search_pugc.fragment.result;

import android.app.Application;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.transsion.search_pugc.bean.SecondTab;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchResultViewModel extends androidx.lifecycle.b {
    public static final a i = new a(null);
    private final Lazy b;
    private final b0 c;
    private final b0 d;
    private final b0 e;
    private String f;
    private final b0 g;
    private int h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchResultViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.o
            public final Object invoke() {
                jq.a o;
                o = SearchResultViewModel.o();
                return o;
            }
        });
        this.c = new b0();
        this.d = new b0();
        this.e = new b0();
        this.g = new b0(Boolean.FALSE);
        this.h = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final jq.a j() {
        return (jq.a) this.b.getValue();
    }

    public static /* synthetic */ void n(SearchResultViewModel searchResultViewModel, String str, String str2, String str3, boolean z, SecondTab secondTab, int i2, Object obj) {
        String str4 = (i2 & 2) != 0 ? null : str2;
        if ((i2 & 8) != 0) {
            z = false;
        }
        searchResultViewModel.m(str, str4, str3, z, (i2 & 16) != 0 ? null : secondTab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jq.a o() {
        return (jq.a) kg.c.e.a().h(jq.a.class);
    }

    public final String g() {
        return this.f;
    }

    public final b0 h() {
        return this.e;
    }

    public final b0 i() {
        return this.g;
    }

    public final b0 k() {
        return this.d;
    }

    public final b0 l() {
        return this.c;
    }

    public final void m(String str, String str2, String str3, boolean z, SecondTab secondTab) {
        Intrinsics.h(str, "keyword");
        Intrinsics.h(str3, "pageFrom");
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new SearchResultViewModel$requestUGCSearchResult$1(this, str, str3, str2, secondTab, z, null), 3, (Object) null);
    }

    public final void p(String str) {
        this.f = str;
    }

    public final void q(int i2) {
        this.h = i2;
    }
}
