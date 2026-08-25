package com.transsion.rewardscenter.task.dada;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r {
    private DadaTaskState a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public r() {
        this(r0, 1, r0);
        DadaTaskState dadaTaskState = null;
    }

    public r(DadaTaskState dadaTaskState) {
        Intrinsics.h(dadaTaskState, "taskState");
        this.a = dadaTaskState;
    }

    public /* synthetic */ r(DadaTaskState dadaTaskState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DadaTaskState.NORMAL : dadaTaskState);
    }

    public final DadaTaskState a() {
        return this.a;
    }

    public final void b(DadaTaskState dadaTaskState) {
        Intrinsics.h(dadaTaskState, "<set-?>");
        this.a = dadaTaskState;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r) && this.a == ((r) obj).a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "DadaTaskItem(taskState=" + this.a + ")";
    }
}
