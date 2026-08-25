package com.cloud.tmc.miniapp.performanceanalyse.screen;

import android.os.CountDownTimer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooOO0 extends CountDownTimer {
    public final OooO00o OooO00o;
    public List<Integer> OooO0O0;
    public int OooO0OO;

    public interface OooO00o {
        void OooO00o();

        void OooO0O0();

        void OooO0OO();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooOO0(long j, long j2, List<Integer> list, OooO00o oooO00o) {
        super(j, j2);
        Intrinsics.h(list, "_timePoints");
        Intrinsics.h(oooO00o, "timeCallback");
        this.OooO00o = oooO00o;
        this.OooO0O0 = CollectionsKt.U0(list);
    }

    public final long OooO00o() {
        return this.OooO0OO * 1000;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.OooO00o.OooO00o();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.OooO0OO++;
        if (this.OooO0O0.size() <= 0) {
            return;
        }
        if (this.OooO0OO != this.OooO0O0.get(0).intValue()) {
            this.OooO00o.OooO0O0();
        } else {
            this.OooO0O0.remove(0);
            this.OooO00o.OooO0OO();
        }
    }
}
