package com.transsion.rewardscenter.task.dada;

import com.tencent.mmkv.MMKV;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class q {
    public static final q a = new q();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.dada.p
        public final Object invoke() {
            MMKV d;
            d = q.d();
            return d;
        }
    });
    public static final int c = 8;

    private q() {
    }

    private final MMKV b() {
        return (MMKV) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV d() {
        return MMKV.I("DadaCache");
    }

    public final DadaTaskState c(List list) {
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            int i = b().getInt("task_state_" + str, -1);
            if (i != -1) {
                return (DadaTaskState) DadaTaskState.getEntries().get(i);
            }
        }
        return null;
    }

    public final void e(String str, DadaTaskState dadaTaskState) {
        Intrinsics.h(dadaTaskState, "taskState");
        if (str == null) {
            return;
        }
        b().putInt("task_state_" + str, dadaTaskState.ordinal());
    }
}
