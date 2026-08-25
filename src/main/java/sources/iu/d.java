package iu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final AppCompatTextView c;
    public final View d;

    private d(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatTextView appCompatTextView, View view) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = appCompatTextView;
        this.d = view;
    }

    public static d a(View view) {
        AppCompatTextView a;
        View a2;
        int i = R$id.fl_comment_container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout == null || (a = f4.b.a(view, (i = R$id.tv_comment))) == null || (a2 = f4.b.a(view, (i = R$id.v_bottom_divider))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new d((ConstraintLayout) view, frameLayout, a, a2);
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_detail_comment, viewGroup, false);
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
