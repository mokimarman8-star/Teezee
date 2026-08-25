package com.transsion.moviedetail.viewmodel;

import android.app.Application;
import android.text.SpannableStringBuilder;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.google.gson.JsonObject;
import com.transsion.baselib.locale.d$b;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.preload.MovieDetailDownloadListLoader;
import com.transsion.moviedetail.preload.MovieDetailResourcesSeasonLoader;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MovieDetailViewModel extends androidx.lifecycle.b {
    public static final a r = new a(null);
    private final Lazy b;
    private final Lazy c;
    private final Lazy d;
    private final Lazy e;
    private final Lazy f;
    private final Lazy g;
    private final Lazy h;
    private final Lazy i;
    private final b0 j;
    private final Lazy k;
    private final b0 l;
    private com.transsion.moviedetail.preload.b m;
    private MovieDetailDownloadListLoader n;
    private MovieDetailResourcesSeasonLoader o;
    private final Lazy p;
    private boolean q;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieDetailViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.d
            public final Object invoke() {
                b0 q;
                q = MovieDetailViewModel.q();
                return q;
            }
        });
        this.c = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.e
            public final Object invoke() {
                b0 Z;
                Z = MovieDetailViewModel.Z();
                return Z;
            }
        });
        this.d = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.f
            public final Object invoke() {
                b0 r2;
                r2 = MovieDetailViewModel.r();
                return r2;
            }
        });
        this.e = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.g
            public final Object invoke() {
                b0 X;
                X = MovieDetailViewModel.X();
                return X;
            }
        });
        this.f = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.moviedetail.viewmodel.h
            public final Object invoke() {
                om.a b0;
                b0 = MovieDetailViewModel.b0();
                return b0;
            }
        });
        this.g = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.i
            public final Object invoke() {
                cx.a a0;
                a0 = MovieDetailViewModel.a0();
                return a0;
            }
        });
        this.h = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.j
            public final Object invoke() {
                b0 U;
                U = MovieDetailViewModel.U();
                return U;
            }
        });
        this.i = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.k
            public final Object invoke() {
                b0 e0;
                e0 = MovieDetailViewModel.e0();
                return e0;
            }
        });
        this.j = new b0();
        this.k = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.l
            public final Object invoke() {
                b0 Y;
                Y = MovieDetailViewModel.Y();
                return Y;
            }
        });
        this.l = new b0();
        this.p = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.viewmodel.m
            public final Object invoke() {
                b0 c0;
                c0 = MovieDetailViewModel.c0();
                return c0;
            }
        });
    }

    private final Locale C(String str) {
        Locale locale = null;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    locale = Intrinsics.c(str, "in_id") ? new Locale("id") : new Locale(str);
                }
            } catch (Exception unused) {
            }
        }
        return locale;
    }

    public static /* synthetic */ void E(MovieDetailViewModel movieDetailViewModel, String str, Integer num, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        movieDetailViewModel.D(str, num, z);
    }

    private final b0 G() {
        return (b0) this.h.getValue();
    }

    private final void M(String str) {
        MovieDetailResourcesSeasonLoader movieDetailResourcesSeasonLoader = this.o;
        if (movieDetailResourcesSeasonLoader != null) {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            movieDetailResourcesSeasonLoader.p(str);
        }
        MovieDetailResourcesSeasonLoader movieDetailResourcesSeasonLoader2 = this.o;
        if (movieDetailResourcesSeasonLoader2 != null) {
            movieDetailResourcesSeasonLoader2.f(L());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final om.a N() {
        return (om.a) this.f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final cx.a O() {
        return (cx.a) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 R() {
        return (b0) this.i.getValue();
    }

    public static /* synthetic */ void T(MovieDetailViewModel movieDetailViewModel, int i, String str, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        movieDetailViewModel.S(i, str, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 U() {
        return new b0();
    }

    public static /* synthetic */ void W(MovieDetailViewModel movieDetailViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        movieDetailViewModel.V(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 X() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 Y() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 Z() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cx.a a0() {
        return (cx.a) kg.c.e.a().h(cx.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final om.a b0() {
        return (om.a) kg.c.e.a().h(om.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 c0() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 e0() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 q() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 r() {
        return new b0();
    }

    public static /* synthetic */ void u(MovieDetailViewModel movieDetailViewModel, String str, Integer num, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        movieDetailViewModel.t(str, num, i, z);
    }

    public final LiveData A() {
        return this.j;
    }

    public final boolean B() {
        return this.q;
    }

    public final void D(String str, Integer num, boolean z) {
        Intrinsics.h(str, "subjectId");
        com.transsion.moviedetail.preload.b bVar = this.m;
        if (bVar != null) {
            bVar.q(str);
        }
        com.transsion.moviedetail.preload.b bVar2 = this.m;
        if (bVar2 != null) {
            bVar2.p(num);
        }
        com.transsion.moviedetail.preload.b bVar3 = this.m;
        if (bVar3 != null) {
            bVar3.o(z);
        }
        com.transsion.moviedetail.preload.b bVar4 = this.m;
        if (bVar4 != null) {
            bVar4.f(G());
        }
    }

    public final LiveData F() {
        return G();
    }

    public final b0 H() {
        return this.l;
    }

    public final b0 I() {
        return (b0) this.e.getValue();
    }

    public final void J() {
        this.q = true;
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new MovieDetailViewModel$getRoomPostEntrance$1(this, null), 3, (Object) null);
    }

    public final b0 K() {
        return (b0) this.k.getValue();
    }

    public final b0 L() {
        return (b0) this.c.getValue();
    }

    public final b0 P() {
        return (b0) this.p.getValue();
    }

    public final LiveData Q() {
        return R();
    }

    public final void S(int i, String str, Integer num) {
        am.b bVar;
        am.b bVar2;
        Object obj;
        Object obj2;
        Intrinsics.h(str, "subjectId");
        List a2 = am.e.a.a(i);
        Object obj3 = null;
        if (a2 != null) {
            Iterator it = a2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = it.next();
                    if (((am.b) obj2) instanceof com.transsion.moviedetail.preload.b) {
                        break;
                    }
                }
            }
            bVar = (am.b) obj2;
        } else {
            bVar = null;
        }
        com.transsion.moviedetail.preload.b bVar3 = (com.transsion.moviedetail.preload.b) bVar;
        if (bVar3 == null) {
            bVar3 = new com.transsion.moviedetail.preload.b(str, num, false, 4, null);
        }
        this.m = bVar3;
        if (a2 != null) {
            Iterator it2 = a2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it2.next();
                    if (((am.b) obj) instanceof MovieDetailDownloadListLoader) {
                        break;
                    }
                }
            }
            bVar2 = (am.b) obj;
        } else {
            bVar2 = null;
        }
        MovieDetailDownloadListLoader movieDetailDownloadListLoader = (MovieDetailDownloadListLoader) bVar2;
        if (movieDetailDownloadListLoader == null) {
            movieDetailDownloadListLoader = new MovieDetailDownloadListLoader(str);
        }
        this.n = movieDetailDownloadListLoader;
        if (a2 != null) {
            Iterator it3 = a2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next = it3.next();
                if (((am.b) next) instanceof MovieDetailResourcesSeasonLoader) {
                    obj3 = next;
                    break;
                }
            }
            obj3 = (am.b) obj3;
        }
        MovieDetailResourcesSeasonLoader movieDetailResourcesSeasonLoader = (MovieDetailResourcesSeasonLoader) obj3;
        if (movieDetailResourcesSeasonLoader == null) {
            movieDetailResourcesSeasonLoader = new MovieDetailResourcesSeasonLoader(str);
        }
        this.o = movieDetailResourcesSeasonLoader;
        M(str);
        z(str);
    }

    public final void V(String str, boolean z) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new MovieDetailViewModel$postRequestResource$1(str, z, this, null), 3, (Object) null);
    }

    public final void d0(String str, int i) {
        Intrinsics.h(str, "subjectId");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("subjectId", str);
        jsonObject.addProperty("action", Integer.valueOf(i));
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new MovieDetailViewModel$wantToSee$1(jsonObject, this, null), 3, (Object) null);
    }

    public final void s(boolean z, String str, Integer num, int i, boolean z2) {
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new MovieDetailViewModel$fetchLocalRec$1(z, str, num, i, z2, this, null), 2, (Object) null);
    }

    public final void t(String str, Integer num, int i, boolean z) {
        if (str == null || str.length() == 0) {
            return;
        }
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new MovieDetailViewModel$fetchRec$1(str, num, i, z, this, null), 2, (Object) null);
    }

    public final CharSequence v(String str) {
        List S0;
        List U0 = (str == null || (S0 = StringsKt.S0(str, new String[]{","}, false, 0, 6, (Object) null)) == null) ? null : CollectionsKt.U0(S0);
        List list = U0;
        if (list == null || list.isEmpty()) {
            return null;
        }
        d$b d_b = com.transsion.baselib.locale.d.f;
        Locale l = d_b.e().l();
        Locale k = d_b.e().k();
        int i = -1;
        int i2 = 0;
        if (Intrinsics.c(l, k)) {
            Iterator it = U0.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Locale C = C((String) it.next());
                if (Intrinsics.c(C != null ? C.getLanguage() : null, l != null ? l.getLanguage() : null)) {
                    i = i3;
                    break;
                }
                i3++;
            }
            if (i > 0) {
                U0.add(0, U0.remove(i));
            }
        } else {
            Iterator it2 = U0.iterator();
            int i4 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i4 = -1;
                    break;
                }
                Locale C2 = C((String) it2.next());
                if (Intrinsics.c(C2 != null ? C2.getLanguage() : null, k != null ? k.getLanguage() : null)) {
                    break;
                }
                i4++;
            }
            if (i4 > 0) {
                U0.add(0, U0.remove(i4));
            }
            Iterator it3 = U0.iterator();
            int i5 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Locale C3 = C((String) it3.next());
                if (Intrinsics.c(C3 != null ? C3.getLanguage() : null, l != null ? l.getLanguage() : null)) {
                    i = i5;
                    break;
                }
                i5++;
            }
            if (i > 0) {
                U0.add(0, U0.remove(i));
            }
        }
        Application b = b();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) b.getString(R$string.movie_detail_subtitles));
        spannableStringBuilder.append((CharSequence) " ");
        for (Object obj : U0) {
            int i6 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            spannableStringBuilder.append((CharSequence) obj);
            if (i2 != U0.size() - 1) {
                spannableStringBuilder.append((CharSequence) ", ");
            }
            i2 = i6;
        }
        return spannableStringBuilder;
    }

    public final b0 w() {
        return (b0) this.d.getValue();
    }

    public final void x(String str, int i, int i2, int i3, int i4) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new MovieDetailViewModel$getDownloadList$1(this, str, i4, i, i2, i3, null), 3, (Object) null);
    }

    public final b0 y() {
        return (b0) this.b.getValue();
    }

    public final void z(String str) {
        MovieDetailDownloadListLoader movieDetailDownloadListLoader = this.n;
        if (movieDetailDownloadListLoader != null) {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            movieDetailDownloadListLoader.p(str);
        }
        MovieDetailDownloadListLoader movieDetailDownloadListLoader2 = this.n;
        if (movieDetailDownloadListLoader2 != null) {
            movieDetailDownloadListLoader2.f(y());
        }
    }
}
