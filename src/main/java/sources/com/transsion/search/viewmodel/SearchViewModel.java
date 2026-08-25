package com.transsion.search.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.activity.SearchManagerActivity;
import com.transsion.search.bean.HotSubjectEntity;
import com.transsion.search.bean.JoinGroupEntity;
import com.transsion.search.bean.SearchSuggestEntity;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.net.RequestJoinGroupEntity;
import com.transsion.search.net.RequestSearchEntity;
import com.transsion.search.widget.BoundaryLinkedHashMap;
import cq.c;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchViewModel extends androidx.lifecycle.b {
    private final b0 b;
    private final b0 c;
    private final b0 d;
    private final b0 e;
    private final b0 f;
    private final b0 g;
    private final Lazy h;
    private io.reactivex.rxjava3.disposables.c i;
    private final BoundaryLinkedHashMap j;
    private final BoundaryLinkedHashMap k;
    private final b0 l;

    public static final class a extends dg.a {
        a() {
        }

        public void a(String str, String str2) {
            SearchViewModel.this.j().n((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(HotSubjectEntity hotSubjectEntity) {
            SearchViewModel.this.j().n(hotSubjectEntity);
        }
    }

    public static final class b extends dg.a {
        final /* synthetic */ String e;

        b(String str) {
            this.e = str;
        }

        public void a(String str, String str2) {
            SearchViewModel.this.r().n(this.e);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(SearchSuggestEntity searchSuggestEntity) {
            if (searchSuggestEntity != null) {
                SearchViewModel searchViewModel = SearchViewModel.this;
                String str = this.e;
                searchViewModel.s().put(searchSuggestEntity.getKeyword(), searchSuggestEntity);
                searchViewModel.r().n(str);
                List<SuggestEntity> items = searchSuggestEntity.getItems();
                if (items == null || !items.isEmpty()) {
                    return;
                }
                String keyword = searchSuggestEntity.getKeyword();
                if ((keyword != null ? keyword.length() : 0) < 2 || searchViewModel.q().containsKey(searchSuggestEntity.getKeyword())) {
                    return;
                }
                searchViewModel.q().put(searchSuggestEntity.getKeyword(), null);
                SearchManagerActivity.INSTANCE.a("no associative word results when the user enters query longer than 2 characters");
                HashMap hashMap = new HashMap();
                String keyword2 = searchSuggestEntity.getKeyword();
                String str2 = BuildConfig.FLAVOR;
                if (keyword2 == null) {
                    keyword2 = BuildConfig.FLAVOR;
                }
                hashMap.put("key_word", keyword2);
                String ops = searchSuggestEntity.getOps();
                if (ops != null) {
                    str2 = ops;
                }
                hashMap.put("ops", str2);
                h.a.z("search_suggest", hashMap);
            }
        }
    }

    public static final class c extends dg.a {
        c() {
        }

        public void a(String str, String str2) {
            if (str2 != null) {
                com.tn.lib.widget.toast.core.h.a.l(str2);
            }
            SearchViewModel.this.e.n(BuildConfig.FLAVOR);
        }

        public void d(BaseDto baseDto) {
            Intrinsics.h(baseDto, "baseDto");
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(JoinGroupEntity joinGroupEntity) {
            if (TextUtils.isEmpty(joinGroupEntity != null ? joinGroupEntity.getM() : null)) {
                SearchViewModel.this.e.n("succeed");
            } else {
                SearchViewModel.this.e.n(joinGroupEntity != null ? joinGroupEntity.getM() : null);
            }
        }
    }

    public static final class d extends dg.a {
        d() {
        }

        public void a(String str, String str2) {
            if (str2 != null) {
                com.tn.lib.widget.toast.core.h.a.l(str2);
            }
            SearchViewModel.this.b.n((Object) null);
        }

        public void d(BaseDto baseDto) {
            Intrinsics.h(baseDto, "baseDto");
            SearchViewModel.this.b.n(baseDto.getData());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = new b0();
        this.c = new b0();
        this.d = new b0();
        this.e = new b0();
        this.f = new b0();
        this.g = new b0();
        this.h = LazyKt.b(new Function0() { // from class: com.transsion.search.viewmodel.a
            public final Object invoke() {
                c u;
                u = SearchViewModel.u();
                return u;
            }
        });
        this.j = new BoundaryLinkedHashMap();
        this.k = new BoundaryLinkedHashMap();
        this.l = new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final cq.c l() {
        return (cq.c) this.h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cq.c u() {
        return new cq.c();
    }

    public final void i() {
        l().c().E(ey.a.c()).subscribe(new a());
    }

    public final b0 j() {
        return this.g;
    }

    public final b0 k() {
        return this.e;
    }

    public final b0 m() {
        return this.b;
    }

    public final void n(String str) {
        Intrinsics.h(str, "keyword");
        l().d(str).E(ey.a.c()).subscribe(new b(str));
    }

    public final b0 o() {
        return this.c;
    }

    protected void onCleared() {
        io.reactivex.rxjava3.disposables.c cVar;
        super/*androidx.lifecycle.t0*/.onCleared();
        io.reactivex.rxjava3.disposables.c cVar2 = this.i;
        if (cVar2 == null || cVar2.isDisposed() || (cVar = this.i) == null) {
            return;
        }
        cVar.dispose();
    }

    public final b0 p() {
        return this.d;
    }

    public final BoundaryLinkedHashMap q() {
        return this.k;
    }

    public final b0 r() {
        return this.l;
    }

    public final BoundaryLinkedHashMap s() {
        return this.j;
    }

    public final void t(String str) {
        Intrinsics.h(str, "groupId");
        l().f(new RequestJoinGroupEntity(str)).E(ey.a.c()).subscribe(new c());
    }

    public final void v(int i, int i2, String str) {
        Intrinsics.h(str, "keyword");
        l().g(new RequestSearchEntity(i, i2, str)).E(ey.a.c()).subscribe(new d());
    }

    public final void w(int i, int i2, String str) {
        Intrinsics.h(str, "keyword");
        i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new SearchViewModel$searchWork$1(this, new RequestSearchEntity(i, i2, str), null), 3, (Object) null);
    }

    public final void x(int i, int i2, String str, int i3) {
        Intrinsics.h(str, "keyword");
        i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new SearchViewModel$searchWorkV2$1(this, new RequestSearchEntity(i, i2, str, i3), null), 3, (Object) null);
    }
}
