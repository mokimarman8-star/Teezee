package androidx.compose.ui.graphics;

import android.graphics.Path;
import androidx.compose.ui.graphics.Path;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class x0 {

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3875a;

        static {
            int[] iArr = new int[Path.Direction.values().length];
            try {
                iArr[Path.Direction.CounterClockwise.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Path.Direction.Clockwise.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f3875a = iArr;
        }
    }

    public static final Path a() {
        android.graphics.Path path = null;
        return new u0(path, 1, path);
    }

    public static final void c(String str) {
        throw new IllegalStateException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path.Direction d(Path.Direction direction) {
        int i5 = a.f3875a[direction.ordinal()];
        if (i5 == 1) {
            return Path.Direction.CCW;
        }
        if (i5 == 2) {
            return Path.Direction.CW;
        }
        throw new NoWhenBranchMatchedException();
    }
}
