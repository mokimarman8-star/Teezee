package com.transsion.baselib.config;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class d implements OnCompleteListener {
    public final /* synthetic */ e a;
    public final /* synthetic */ Function2 b;

    public /* synthetic */ d(e eVar, Function2 function2) {
        this.a = eVar;
        this.b = function2;
    }

    public final void onComplete(Task task) {
        e.b(this.a, this.b, task);
    }
}
