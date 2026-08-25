package com.transsion.search.viewmodel;

import android.app.Application;
import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchWorkViewModel extends t0 {
    private int e;
    private boolean a = true;
    private final b0 b = new b0();
    private final List c = new ArrayList();
    private final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.search.viewmodel.b
        public final Object invoke() {
            VideoDetailPlayDao n;
            n = SearchWorkViewModel.n();
            return n;
        }
    });
    private int f = 50;

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao j() {
        return (VideoDetailPlayDao) this.d.getValue();
    }

    public static /* synthetic */ void l(SearchWorkViewModel searchWorkViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        searchWorkViewModel.k(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao n() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return appDatabase$f1.b(a).C1();
    }

    public final boolean g() {
        return this.a;
    }

    public final b0 h() {
        return this.b;
    }

    public final int i() {
        return this.e;
    }

    public final void k(boolean z) {
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new SearchWorkViewModel$getVideoHistoryList$1(z, this, null), 2, (Object) null);
    }

    public final void m(int i) {
        this.e = i;
    }
}
