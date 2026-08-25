package rn;

import android.view.View;
import com.transsion.player.ui.render.RenderScaleMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private int a;
    private int b;
    private RenderScaleMode c = RenderScaleMode.SCREEN_SCALE_DEFAULT;
    private int d;

    /* renamed from: rn.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0090a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RenderScaleMode.values().length];
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_ORIGINAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_16_9.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_4_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_MATCH_PARENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RenderScaleMode.SCREEN_SCALE_CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int[] a(int i, int i2) {
        int i3 = this.d;
        if (i3 == 90 || i3 == 270) {
            i2 = i;
            i = i2;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.b == 0 || this.a == 0) {
            return new int[]{size, size2};
        }
        switch (C0090a.a[this.c.ordinal()]) {
            case 1:
                int i4 = this.a;
                int i5 = i4 * size2;
                int i6 = this.b;
                if (i5 < size * i6) {
                    i = (i4 * size2) / i6;
                } else {
                    if (i4 * size2 > size * i6) {
                        i2 = (i6 * size) / i4;
                        i = size;
                        return new int[]{i, i2};
                    }
                    i = size;
                }
                i2 = size2;
                return new int[]{i, i2};
            case 2:
                i = this.a;
                i2 = this.b;
                return new int[]{i, i2};
            case 3:
                i2 = (size / 16) * 9;
                if (size2 <= i2) {
                    i = (size2 / 9) * 16;
                    i2 = size2;
                    return new int[]{i, i2};
                }
                i = size;
                return new int[]{i, i2};
            case 4:
                i2 = (size / 4) * 3;
                if (size2 <= i2) {
                    i = (size2 / 3) * 4;
                    i2 = size2;
                    return new int[]{i, i2};
                }
                i = size;
                return new int[]{i, i2};
            case 5:
                return new int[]{i, i2};
            case 6:
                int i7 = this.a;
                int i8 = i7 * size2;
                int i9 = this.b;
                if (i8 > size * i9) {
                    i = (i7 * size2) / i9;
                    i2 = size2;
                    return new int[]{i, i2};
                }
                i2 = (i9 * size) / i7;
                i = size;
                return new int[]{i, i2};
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void b(RenderScaleMode renderScaleMode) {
        Intrinsics.h(renderScaleMode, "screenScale");
        if (renderScaleMode == this.c) {
            return;
        }
        this.c = renderScaleMode;
    }

    public final void c(int i) {
        this.d = i;
    }

    public final void d(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
