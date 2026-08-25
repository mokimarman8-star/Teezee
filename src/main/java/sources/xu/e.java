package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e implements f4.a {
    private final LinearLayout a;
    public final AppCompatImageButton b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;
    public final AppCompatTextView l;
    public final AppCompatTextView m;
    public final AppCompatTextView n;
    public final AppCompatTextView o;
    public final AppCompatTextView p;
    public final AppCompatTextView q;
    public final AppCompatTextView r;
    public final AppCompatTextView s;

    private e(LinearLayout linearLayout, AppCompatImageButton appCompatImageButton, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, AppCompatTextView appCompatTextView10, AppCompatTextView appCompatTextView11, AppCompatTextView appCompatTextView12, AppCompatTextView appCompatTextView13, AppCompatTextView appCompatTextView14, AppCompatTextView appCompatTextView15, AppCompatTextView appCompatTextView16, AppCompatTextView appCompatTextView17) {
        this.a = linearLayout;
        this.b = appCompatImageButton;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = appCompatTextView3;
        this.f = appCompatTextView4;
        this.g = appCompatTextView5;
        this.h = appCompatTextView6;
        this.i = appCompatTextView7;
        this.j = appCompatTextView8;
        this.k = appCompatTextView9;
        this.l = appCompatTextView10;
        this.m = appCompatTextView11;
        this.n = appCompatTextView12;
        this.o = appCompatTextView13;
        this.p = appCompatTextView14;
        this.q = appCompatTextView15;
        this.r = appCompatTextView16;
        this.s = appCompatTextView17;
    }

    public static e a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        AppCompatTextView a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        AppCompatTextView a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        AppCompatTextView a13;
        AppCompatTextView a14;
        AppCompatTextView a15;
        AppCompatTextView a16;
        AppCompatTextView a17;
        int i = R$id.btn_back;
        AppCompatImageButton a18 = f4.b.a(view, i);
        if (a18 == null || (a = f4.b.a(view, (i = R$id.tv_app_info))) == null || (a2 = f4.b.a(view, (i = R$id.tvChannel))) == null || (a3 = f4.b.a(view, (i = R$id.tv_content_mode))) == null || (a4 = f4.b.a(view, (i = R$id.tvDebugJS))) == null || (a5 = f4.b.a(view, (i = R$id.tv_fps_switch))) == null || (a6 = f4.b.a(view, (i = R$id.tvHttpHost))) == null || (a7 = f4.b.a(view, (i = R$id.tvIso))) == null || (a8 = f4.b.a(view, (i = R$id.tvKillApp))) == null || (a9 = f4.b.a(view, (i = R$id.tv_lane))) == null || (a10 = f4.b.a(view, (i = R$id.tv_location_mock))) == null || (a11 = f4.b.a(view, (i = R$id.tvMiniAppSDKTest))) == null || (a12 = f4.b.a(view, (i = R$id.tvNotification))) == null || (a13 = f4.b.a(view, (i = R$id.tv_select_brand))) == null || (a14 = f4.b.a(view, (i = R$id.tvStreaming))) == null || (a15 = f4.b.a(view, (i = R$id.tvTestAd))) == null || (a16 = f4.b.a(view, (i = R$id.tvWebTest))) == null || (a17 = f4.b.a(view, (i = R$id.tvWidget))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new e((LinearLayout) view, a18, a, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17);
    }

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_laboratory, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
