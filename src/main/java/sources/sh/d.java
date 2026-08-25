package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.AdTagView;
import com.transsion.ad.view.MemberTagView;
import com.transsion.ad.view.RoundedCornerLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d implements f4.a {
    private final ConstraintLayout a;
    public final AdTagView b;
    public final RoundedCornerLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final AppCompatTextView f;
    public final ConstraintLayout g;
    public final AppCompatImageView h;
    public final AppCompatTextView i;
    public final LinearLayoutCompat j;
    public final MemberTagView k;

    private d(ConstraintLayout constraintLayout, AdTagView adTagView, RoundedCornerLayout roundedCornerLayout, FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView2, LinearLayoutCompat linearLayoutCompat, MemberTagView memberTagView) {
        this.a = constraintLayout;
        this.b = adTagView;
        this.c = roundedCornerLayout;
        this.d = frameLayout;
        this.e = frameLayout2;
        this.f = appCompatTextView;
        this.g = constraintLayout2;
        this.h = appCompatImageView;
        this.i = appCompatTextView2;
        this.j = linearLayoutCompat;
        this.k = memberTagView;
    }

    public static d a(View view) {
        RoundedCornerLayout a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        LinearLayoutCompat a4;
        MemberTagView a5;
        int i = R$id.adIcon;
        AdTagView a6 = f4.b.a(view, i);
        if (a6 != null && (a = f4.b.a(view, (i = R$id.container))) != null) {
            i = R$id.flCloseContainer;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R$id.flVolumeContainer;
                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout2 != null && (a2 = f4.b.a(view, (i = R$id.learn_more))) != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R$id.tvAudio;
                    AppCompatImageView a7 = f4.b.a(view, i);
                    if (a7 != null && (a3 = f4.b.a(view, (i = R$id.tvCd))) != null && (a4 = f4.b.a(view, (i = R$id.viewCd))) != null && (a5 = f4.b.a(view, (i = R$id.viewMember))) != null) {
                        return new d(constraintLayout, a6, a, frameLayout, frameLayout2, a2, constraintLayout, a7, a3, a4, a5);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_bidding_buy_out_interstitial_land_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
