package mn;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.player.longvideo.R$id;
import com.transsion.postdetail.ad.AdInterceptTimerView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AdInterceptTimerView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final View g;
    public final View h;
    public final AppCompatTextView i;

    private i(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AdInterceptTimerView adInterceptTimerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view, View view2, AppCompatTextView appCompatTextView4) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = adInterceptTimerView;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
        this.f = appCompatTextView3;
        this.g = view;
        this.h = view2;
        this.i = appCompatTextView4;
    }

    public static i a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        View a4;
        View a5;
        AppCompatTextView a6;
        int i = R$id.iv_back;
        AppCompatImageView a7 = f4.b.a(view, i);
        if (a7 != null) {
            i = R$id.rewardInterceptTimer;
            AdInterceptTimerView adInterceptTimerView = (AdInterceptTimerView) f4.b.a(view, i);
            if (adInterceptTimerView != null && (a = f4.b.a(view, (i = R$id.tvDownloadView))) != null && (a2 = f4.b.a(view, (i = R$id.tvFeedback))) != null && (a3 = f4.b.a(view, (i = R$id.tvSubtitleSetting))) != null && (a4 = f4.b.a(view, (i = R$id.v_space_end))) != null && (a5 = f4.b.a(view, (i = R$id.v_space_start))) != null && (a6 = f4.b.a(view, (i = R$id.vd_title))) != null) {
                return new i((ConstraintLayout) view, a7, adInterceptTimerView, a, a2, a3, a4, a5, a6);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
