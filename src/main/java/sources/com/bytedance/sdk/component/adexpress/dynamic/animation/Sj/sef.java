package com.bytedance.sdk.component.adexpress.dynamic.animation.Sj;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sef extends EjP {
    public sef(View view, com.bytedance.sdk.component.adexpress.dynamic.EjP.Sj sj) {
        super(view, sj);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.Sj.EjP
    List<ObjectAnimator> Sj() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.TKC, "rotation", 0.0f, this.sP.HiB(), 0.0f, this.sP.HiB(), 0.0f).setDuration((int) (this.sP.TEQ() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(Sj(duration));
        return arrayList;
    }
}
