package jt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLImageView;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class k implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatEditText b;
    public final BLImageView c;
    public final BLImageView d;
    public final ConstraintLayout e;
    public final AppCompatTextView f;

    private k(ConstraintLayout constraintLayout, AppCompatEditText appCompatEditText, BLImageView bLImageView, BLImageView bLImageView2, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = appCompatEditText;
        this.c = bLImageView;
        this.d = bLImageView2;
        this.e = constraintLayout2;
        this.f = appCompatTextView;
    }

    public static k a(View view) {
        BLImageView a;
        BLImageView a2;
        int i = R$id.et_sync_adjust;
        AppCompatEditText a3 = f4.b.a(view, i);
        if (a3 != null && (a = f4.b.a(view, (i = R$id.iv_sync_adjust_minus))) != null && (a2 = f4.b.a(view, (i = R$id.iv_sync_adjust_plus))) != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.tvTitle;
            AppCompatTextView a4 = f4.b.a(view, i);
            if (a4 != null) {
                return new k(constraintLayout, a3, a, a2, constraintLayout, a4);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static k c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.view_subtitle_sync_adjust_layout, viewGroup, false);
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
