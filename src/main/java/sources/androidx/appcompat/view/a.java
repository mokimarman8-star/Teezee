package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.appcompat.R;
import androidx.appcompat.R$dimen;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f410a;

    private a(Context context) {
        this.f410a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f410a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f410a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f410a.getResources().getConfiguration();
        int i5 = configuration.screenWidthDp;
        int i6 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i5 > 600) {
            return 5;
        }
        if (i5 > 960 && i6 > 720) {
            return 5;
        }
        if (i5 > 720 && i6 > 960) {
            return 5;
        }
        if (i5 >= 500) {
            return 4;
        }
        if (i5 > 640 && i6 > 480) {
            return 4;
        }
        if (i5 <= 480 || i6 <= 640) {
            return i5 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int e() {
        return this.f410a.getResources().getDimensionPixelSize(R$dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int f() {
        TypedArray obtainStyledAttributes = this.f410a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources resources = this.f410a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R$dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f410a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    public boolean h() {
        return true;
    }
}
