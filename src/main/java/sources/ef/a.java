package ef;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;
import com.permissionx.guolindev.R$id;
import f4.b;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a implements f4.a {
    private final BLConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final BLView g;

    private a(BLConstraintLayout bLConstraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, BLView bLView) {
        this.a = bLConstraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
        this.f = appCompatTextView3;
        this.g = bLView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a a(View view) {
        AppCompatImageView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        int i = R$id.iv_close;
        AppCompatImageView a5 = b.a(view, i);
        if (a5 != null && (a = b.a(view, (i = R$id.iv_icon))) != null && (a2 = b.a(view, (i = R$id.tv_button))) != null && (a3 = b.a(view, (i = R$id.tv_subtitle))) != null && (a4 = b.a(view, (i = R$id.tv_title))) != null) {
            i = R$id.v_icon_bg;
            BLView bLView = (BLView) b.a(view, i);
            if (bLView != null) {
                return new a((BLConstraintLayout) view, a5, a, a2, a3, a4, bLView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.a;
    }
}
