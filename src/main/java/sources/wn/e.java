package wn;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final FrameLayout c;
    public final ImageView d;
    public final AppCompatTextView e;
    public final View f;

    private e(ConstraintLayout constraintLayout, View view, FrameLayout frameLayout, ImageView imageView, AppCompatTextView appCompatTextView, View view2) {
        this.a = constraintLayout;
        this.b = view;
        this.c = frameLayout;
        this.d = imageView;
        this.e = appCompatTextView;
        this.f = view2;
    }

    public static e a(View view) {
        AppCompatTextView a;
        View a2;
        int i = R$id.divider;
        View a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R$id.fl_comment_container;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R$id.iv_close;
                ImageView imageView = (ImageView) f4.b.a(view, i);
                if (imageView != null && (a = f4.b.a(view, (i = R$id.tv_comment))) != null && (a2 = f4.b.a(view, (i = R$id.v_bottom))) != null) {
                    return new e((ConstraintLayout) view, a3, frameLayout, imageView, a, a2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
