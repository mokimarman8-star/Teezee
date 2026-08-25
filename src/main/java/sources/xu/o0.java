package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class o0 implements f4.a {
    private final ConstraintLayout a;
    public final TnTextView b;
    public final AppCompatTextView c;
    public final ImageView d;
    public final LinearLayout e;
    public final TnTextView f;
    public final View g;

    private o0(ConstraintLayout constraintLayout, TnTextView tnTextView, AppCompatTextView appCompatTextView, ImageView imageView, LinearLayout linearLayout, TnTextView tnTextView2, View view) {
        this.a = constraintLayout;
        this.b = tnTextView;
        this.c = appCompatTextView;
        this.d = imageView;
        this.e = linearLayout;
        this.f = tnTextView2;
        this.g = view;
    }

    public static o0 a(View view) {
        AppCompatTextView a;
        TnTextView a2;
        View a3;
        int i = R$id.btnTv;
        TnTextView a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R$id.desTv))) != null) {
            i = R$id.icIV;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null) {
                i = R$id.llBottom;
                LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                if (linearLayout != null && (a2 = f4.b.a(view, (i = R$id.titleTv))) != null && (a3 = f4.b.a(view, (i = R$id.vTopGuideline))) != null) {
                    return new o0((ConstraintLayout) view, a4, a, imageView, linearLayout, a2, a3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static o0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.mine_item_novel_layout, viewGroup, false);
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
