package xt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.SwitchButton;
import com.tn.lib.view.TitleLayout;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d implements f4.a {
    private final LinearLayoutCompat a;
    public final Group b;
    public final Group c;
    public final AppCompatImageView d;
    public final ShapeableImageView e;
    public final LinearLayout f;
    public final ConstraintLayout g;
    public final ProgressBar h;
    public final SwitchButton i;
    public final TitleLayout j;
    public final AppCompatTextView k;
    public final AppCompatTextView l;
    public final AppCompatTextView m;
    public final AppCompatTextView n;
    public final AppCompatTextView o;
    public final AppCompatTextView p;
    public final AppCompatTextView q;

    private d(LinearLayoutCompat linearLayoutCompat, Group group, Group group2, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, LinearLayout linearLayout, ConstraintLayout constraintLayout, ProgressBar progressBar, SwitchButton switchButton, TitleLayout titleLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7) {
        this.a = linearLayoutCompat;
        this.b = group;
        this.c = group2;
        this.d = appCompatImageView;
        this.e = shapeableImageView;
        this.f = linearLayout;
        this.g = constraintLayout;
        this.h = progressBar;
        this.i = switchButton;
        this.j = titleLayout;
        this.k = appCompatTextView;
        this.l = appCompatTextView2;
        this.m = appCompatTextView3;
        this.n = appCompatTextView4;
        this.o = appCompatTextView5;
        this.p = appCompatTextView6;
        this.q = appCompatTextView7;
    }

    public static d a(View view) {
        Group a;
        AppCompatImageView a2;
        ShapeableImageView a3;
        ConstraintLayout a4;
        SwitchButton a5;
        TitleLayout a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        AppCompatTextView a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        AppCompatTextView a13;
        int i = R$id.groupErrorLayout;
        Group a14 = f4.b.a(view, i);
        if (a14 != null && (a = f4.b.a(view, (i = R$id.groupSuccessLayout))) != null && (a2 = f4.b.a(view, (i = R$id.ivError))) != null && (a3 = f4.b.a(view, (i = R$id.ivTransWifiQrCode))) != null) {
            i = R$id.llSend;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a4 = f4.b.a(view, (i = R$id.llUp))) != null) {
                i = R$id.progressBar;
                ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                if (progressBar != null && (a5 = f4.b.a(view, (i = R$id.switchButton))) != null && (a6 = f4.b.a(view, (i = R$id.toolBar))) != null && (a7 = f4.b.a(view, (i = R$id.tvErrorTip))) != null && (a8 = f4.b.a(view, (i = R$id.tvRetry))) != null && (a9 = f4.b.a(view, (i = R$id.tvSend))) != null && (a10 = f4.b.a(view, (i = R$id.tvShareLink))) != null && (a11 = f4.b.a(view, (i = R$id.tvShareQrCode))) != null && (a12 = f4.b.a(view, (i = R$id.tvWaitingForReceiver))) != null && (a13 = f4.b.a(view, (i = R$id.tvWifiSsid))) != null) {
                    return new d((LinearLayoutCompat) view, a14, a, a2, a3, linearLayout, a4, progressBar, a5, a6, a7, a8, a9, a10, a11, a12, a13);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_wifi_create, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
