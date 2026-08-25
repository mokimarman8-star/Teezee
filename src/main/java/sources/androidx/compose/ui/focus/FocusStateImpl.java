package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/focus/FocusStateImpl;", "", "Landroidx/compose/ui/focus/r;", "<init>", "(Ljava/lang/String;I)V", "", "isFocused", "()Z", "getHasFocus", "hasFocus", "isCaptured", "Active", "ActiveParent", "Captured", "Inactive", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public enum FocusStateImpl implements r {
    Active,
    ActiveParent,
    Captured,
    Inactive;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3224a;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f3224a = iArr;
        }
    }

    @Override // androidx.compose.ui.focus.r
    public boolean getHasFocus() {
        int i5 = a.f3224a[ordinal()];
        if (i5 == 1 || i5 == 2 || i5 == 3) {
            return true;
        }
        if (i5 == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public boolean isCaptured() {
        int i5 = a.f3224a[ordinal()];
        if (i5 == 1) {
            return true;
        }
        if (i5 == 2 || i5 == 3 || i5 == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.compose.ui.focus.r
    public boolean isFocused() {
        int i5 = a.f3224a[ordinal()];
        if (i5 == 1 || i5 == 2) {
            return true;
        }
        if (i5 == 3 || i5 == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }
}
