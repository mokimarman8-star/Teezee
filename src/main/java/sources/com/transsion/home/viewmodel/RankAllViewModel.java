package com.transsion.home.viewmodel;

import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.transsion.home.bean.RankAllData;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RankAllViewModel extends t0 {
    private final androidx.lifecycle.b0 a = new androidx.lifecycle.b0();
    private final androidx.lifecycle.b0 b = new androidx.lifecycle.b0();
    private int c = 1;
    private final yk.d d = (yk.d) kg.c.e.a().h(yk.d.class);
    private String e;
    private int f;
    private String g;

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(RankAllData rankAllData) {
        List<Subject> subjects;
        String ops = rankAllData != null ? rankAllData.getOps() : null;
        if (ops == null || ops.length() == 0 || rankAllData == null || (subjects = rankAllData.getSubjects()) == null) {
            return;
        }
        for (Subject subject : subjects) {
            String ops2 = subject.getOps();
            if (ops2 == null || ops2.length() == 0) {
                subject.setOps(ops);
            }
        }
    }

    private final void n(boolean z) {
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new RankAllViewModel$startRequest$1(z, this, null), 2, (Object) null);
    }

    public final androidx.lifecycle.b0 i() {
        return this.b;
    }

    public final androidx.lifecycle.b0 j() {
        return this.a;
    }

    public final void k(String str, int i, String str2) {
        this.e = str;
        this.f = i;
        this.g = str2;
        this.c = 1;
        n(false);
    }

    public final void l() {
        n(true);
    }
}
