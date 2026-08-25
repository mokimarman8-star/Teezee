package wn;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a0 implements f4.a {
    private final View a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final BLTextView d;
    public final BLView e;
    public final BLImageView f;

    private a0(View view, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, BLTextView bLTextView, BLView bLView, BLImageView bLImageView) {
        this.a = view;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = bLTextView;
        this.e = bLView;
        this.f = bLImageView;
    }

    public static a0 a(View view) {
        AppCompatImageView a;
        BLTextView a2;
        BLView a3;
        BLImageView a4;
        int i = R$id.iv_short_tv_guide_arrow_1;
        AppCompatImageView a5 = f4.b.a(view, i);
        if (a5 == null || (a = f4.b.a(view, (i = R$id.iv_short_tv_guide_arrow_2))) == null || (a2 = f4.b.a(view, (i = R$id.tv_short_tv_guide_ep))) == null || (a3 = f4.b.a(view, (i = R$id.tv_short_tv_guide_ep_bg))) == null || (a4 = f4.b.a(view, (i = R$id.tv_short_tv_guide_list))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new a0(view, a5, a, a2, a3, a4);
    }

    public View getRoot() {
        return this.a;
    }
}
