package mn;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.transsion.player.longvideo.R$id;
import com.transsion.postdetail.ui.view.VideoDoubleClickBackgroundView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements f4.a {
    private final ConstraintLayout a;
    public final LottieAnimationView b;
    public final LottieAnimationView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final VideoDoubleClickBackgroundView f;

    private c(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, VideoDoubleClickBackgroundView videoDoubleClickBackgroundView) {
        this.a = constraintLayout;
        this.b = lottieAnimationView;
        this.c = lottieAnimationView2;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
        this.f = videoDoubleClickBackgroundView;
    }

    public static c a(View view) {
        LottieAnimationView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        int i = R$id.lottie_double_click_left;
        LottieAnimationView a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R$id.lottie_double_click_right))) != null && (a2 = f4.b.a(view, (i = R$id.tv_double_click_left))) != null && (a3 = f4.b.a(view, (i = R$id.tv_double_click_right))) != null) {
            i = R$id.v_double_click;
            VideoDoubleClickBackgroundView videoDoubleClickBackgroundView = (VideoDoubleClickBackgroundView) f4.b.a(view, i);
            if (videoDoubleClickBackgroundView != null) {
                return new c((ConstraintLayout) view, a4, a, a2, a3, videoDoubleClickBackgroundView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
