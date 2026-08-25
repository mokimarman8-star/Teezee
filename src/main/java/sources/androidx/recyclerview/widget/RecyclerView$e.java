package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
/* synthetic */ class RecyclerView$e {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f12830a;

    static {
        int[] iArr = new int[RecyclerView.Adapter.StateRestorationPolicy.values().length];
        f12830a = iArr;
        try {
            iArr[RecyclerView.Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f12830a[RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
