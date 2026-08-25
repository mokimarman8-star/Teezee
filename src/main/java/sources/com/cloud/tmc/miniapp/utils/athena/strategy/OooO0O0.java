package com.cloud.tmc.miniapp.utils.athena.strategy;

import android.content.Context;
import com.cloud.tmc.miniapp.utils.athena.strategy.steps.OooOO0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0O0 implements OooOO0.OooO00o {
    public final Context OooO00o;
    public final String OooO0O0;
    public final List<OooOO0> OooO0OO;
    public final int OooO0Oo;
    public final OooO00o OooO0o0;

    /* JADX WARN: Multi-variable type inference failed */
    public OooO0O0(Context context, String str, List<? extends OooOO0> list, int i, OooO00o oooO00o) {
        Intrinsics.h(list, "steps");
        Intrinsics.h(oooO00o, "athenaReportBean");
        this.OooO00o = context;
        this.OooO0O0 = str;
        this.OooO0OO = list;
        this.OooO0Oo = i;
        this.OooO0o0 = oooO00o;
    }

    public OooO00o OooO00o(boolean z) {
        if (this.OooO0Oo >= this.OooO0OO.size() || z) {
            return this.OooO0o0;
        }
        return this.OooO0OO.get(this.OooO0Oo).OooO00o(new OooO0O0(this.OooO00o, this.OooO0O0, this.OooO0OO, this.OooO0Oo + 1, this.OooO0o0));
    }
}
