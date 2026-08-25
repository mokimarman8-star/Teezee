package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.R$dimen;
import androidx.media3.common.PlaybackException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class s0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1118a;

    /* renamed from: b, reason: collision with root package name */
    private final View f1119b;

    /* renamed from: c, reason: collision with root package name */
    private final TextView f1120c;

    /* renamed from: d, reason: collision with root package name */
    private final WindowManager.LayoutParams f1121d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f1122e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f1123f;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f1124g;

    s0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1121d = layoutParams;
        this.f1122e = new Rect();
        this.f1123f = new int[2];
        this.f1124g = new int[2];
        this.f1118a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f1119b = inflate;
        this.f1120c = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = PlaybackException.ERROR_CODE_BEHIND_LIVE_WINDOW;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    private void a(View view, int i5, int i6, boolean z5, WindowManager.LayoutParams layoutParams) {
        int height;
        int i7;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1118a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i5 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1118a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_extra_offset);
            height = i6 + dimensionPixelOffset2;
            i7 = i6 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i7 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1118a.getResources().getDimensionPixelOffset(z5 ? R$dimen.tooltip_y_offset_touch : R$dimen.tooltip_y_offset_non_touch);
        View b5 = b(view);
        if (b5 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        b5.getWindowVisibleDisplayFrame(this.f1122e);
        Rect rect = this.f1122e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f1118a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1122e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b5.getLocationOnScreen(this.f1124g);
        view.getLocationOnScreen(this.f1123f);
        int[] iArr = this.f1123f;
        int i8 = iArr[0];
        int[] iArr2 = this.f1124g;
        int i9 = i8 - iArr2[0];
        iArr[0] = i9;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i9 + i5) - (b5.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1119b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1119b.getMeasuredHeight();
        int i10 = this.f1123f[1];
        int i11 = ((i7 + i10) - dimensionPixelOffset3) - measuredHeight;
        int i12 = i10 + height + dimensionPixelOffset3;
        if (z5) {
            if (i11 >= 0) {
                layoutParams.y = i11;
                return;
            } else {
                layoutParams.y = i12;
                return;
            }
        }
        if (measuredHeight + i12 <= this.f1122e.height()) {
            layoutParams.y = i12;
        } else {
            layoutParams.y = i11;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    void c() {
        if (d()) {
            ((WindowManager) this.f1118a.getSystemService("window")).removeView(this.f1119b);
        }
    }

    boolean d() {
        return this.f1119b.getParent() != null;
    }

    void e(View view, int i5, int i6, boolean z5, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f1120c.setText(charSequence);
        a(view, i5, i6, z5, this.f1121d);
        ((WindowManager) this.f1118a.getSystemService("window")).addView(this.f1119b, this.f1121d);
    }
}
