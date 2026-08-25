package kq;

import android.app.Application;
import androidx.lifecycle.b0;
import com.transsion.gslb.BuildConfig;
import com.transsion.search_pugc.bean.UGCEveryoneSearchData;
import com.transsion.search_pugc.bean.UGCRankSearchData;
import com.transsion.search_pugc.bean.UGCSearchSuggestData;
import com.transsion.search_pugc.widget.BoundaryLinkedHashMap;
import jq.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends androidx.lifecycle.b {
    private final BoundaryLinkedHashMap b;
    private final b0 c;
    private final b0 d;
    private final b0 e;
    private final Lazy f;
    private io.reactivex.rxjava3.disposables.c g;

    public static final class a extends dg.a {
        a() {
        }

        public void a(String str, String str2) {
            b.this.i().n((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UGCEveryoneSearchData uGCEveryoneSearchData) {
            b.this.i().n(uGCEveryoneSearchData);
        }
    }

    /* renamed from: kq.b$b, reason: collision with other inner class name */
    public static final class C0082b extends dg.a {
        C0082b() {
        }

        public void a(String str, String str2) {
            b.this.j().n((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UGCRankSearchData uGCRankSearchData) {
            b.this.j().n(uGCRankSearchData);
        }
    }

    public static final class c extends dg.a {
        c() {
        }

        public void a(String str, String str2) {
            b.this.k().n((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UGCSearchSuggestData uGCSearchSuggestData) {
            String str;
            BoundaryLinkedHashMap e = b.this.e();
            if (uGCSearchSuggestData == null || (str = uGCSearchSuggestData.getKeyword()) == null) {
                str = BuildConfig.FLAVOR;
            }
            e.put(str, uGCSearchSuggestData);
            b.this.k().n(uGCSearchSuggestData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = new BoundaryLinkedHashMap();
        this.c = new b0();
        this.d = new b0();
        this.e = new b0();
        this.f = LazyKt.b(new Function0() { // from class: kq.a
            public final Object invoke() {
                c l;
                l = b.l();
                return l;
            }
        });
    }

    private final jq.c d() {
        return (jq.c) this.f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jq.c l() {
        return new jq.c();
    }

    public final BoundaryLinkedHashMap e() {
        return this.b;
    }

    public final void f(String str) {
        Intrinsics.h(str, "pageFrom");
        d().d(str).E(ey.a.c()).subscribe(new a());
    }

    public final void g(String str) {
        Intrinsics.h(str, "pageFrom");
        d().e(str).E(ey.a.c()).subscribe(new C0082b());
    }

    public final void h(String str, int i, String str2) {
        Intrinsics.h(str, "keyword");
        Intrinsics.h(str2, "pageFrom");
        d().f(str, i, str2).E(ey.a.c()).subscribe(new c());
    }

    public final b0 i() {
        return this.c;
    }

    public final b0 j() {
        return this.d;
    }

    public final b0 k() {
        return this.e;
    }

    protected void onCleared() {
        io.reactivex.rxjava3.disposables.c cVar;
        super/*androidx.lifecycle.t0*/.onCleared();
        io.reactivex.rxjava3.disposables.c cVar2 = this.g;
        if (cVar2 == null || cVar2.isDisposed() || (cVar = this.g) == null) {
            return;
        }
        cVar.dispose();
    }
}
