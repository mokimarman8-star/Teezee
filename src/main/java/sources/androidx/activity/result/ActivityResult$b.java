package androidx.activity.result;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ActivityResult$b {
    private ActivityResult$b() {
    }

    public /* synthetic */ ActivityResult$b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String a(int i5) {
        return i5 != -1 ? i5 != 0 ? String.valueOf(i5) : "RESULT_CANCELED" : "RESULT_OK";
    }
}
