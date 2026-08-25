package com.transsion.audio.viewmodel;

import android.app.Application;
import androidx.lifecycle.b0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.audio.AudioBean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HistoryListManager {
    public static final a e = new a(null);
    private static final Lazy f = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.audio.viewmodel.e
        public final Object invoke() {
            HistoryListManager x;
            x = HistoryListManager.x();
            return x;
        }
    });
    private static boolean g;
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.audio.viewmodel.a
        public final Object invoke() {
            si.a m;
            m = HistoryListManager.m();
            return m;
        }
    });
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.audio.viewmodel.b
        public final Object invoke() {
            li.a y;
            y = HistoryListManager.y();
            return y;
        }
    });
    private final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.audio.viewmodel.c
        public final Object invoke() {
            b0 l;
            l = HistoryListManager.l();
            return l;
        }
    });
    private final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.audio.viewmodel.d
        public final Object invoke() {
            b0 z;
            z = HistoryListManager.z();
            return z;
        }
    });

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return HistoryListManager.g;
        }

        public final HistoryListManager b() {
            return (HistoryListManager) HistoryListManager.f.getValue();
        }

        public final void c(boolean z) {
            HistoryListManager.g = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 l() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final si.a m() {
        Application a2 = Utils.a();
        if (a2 != null) {
            return AppDatabase.p.b(a2).n1();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final si.a q() {
        return (si.a) this.a.getValue();
    }

    public static /* synthetic */ void t(HistoryListManager historyListManager, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 10;
        }
        historyListManager.s(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final li.a u() {
        return (li.a) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HistoryListManager x() {
        return new HistoryListManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final li.a y() {
        return (li.a) kg.c.e.a().h(li.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 z() {
        return new b0();
    }

    public final void k(AudioBean audioBean) {
        Intrinsics.h(audioBean, "audioBean");
        a.a.g(wf.a.a, "audio insert name " + audioBean.getTitle(), false, 2, (Object) null);
        i.f((CoroutineContext) null, new HistoryListManager$addToList$1(audioBean, this, null), 1, (Object) null);
    }

    public final void n() {
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new HistoryListManager$deleteAll$1(this, null), 3, (Object) null);
    }

    public final void o(AudioBean audioBean) {
        Intrinsics.h(audioBean, "audioItem");
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new HistoryListManager$deleteItem$1(this, audioBean, null), 3, (Object) null);
    }

    public final b0 p() {
        return (b0) this.c.getValue();
    }

    public final void r() {
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new HistoryListManager$getAudioList$1(this, null), 3, (Object) null);
    }

    public final void s(String str, String str2, int i) {
        Intrinsics.h(str, "subjectId");
        Intrinsics.h(str2, "postId");
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new HistoryListManager$getResourcePosition$1(this, str, str2, i, null), 3, (Object) null);
    }

    public final b0 v() {
        return (b0) this.d.getValue();
    }

    public final void w(AudioBean audioBean) {
        Intrinsics.h(audioBean, "audioBean");
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new HistoryListManager$insert$1(audioBean, this, null), 3, (Object) null);
    }
}
