package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class w implements f4.a {
    private final HorizontalScrollView a;
    public final ShapeableImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final ConstraintLayout g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;

    private w(HorizontalScrollView horizontalScrollView, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6) {
        this.a = horizontalScrollView;
        this.b = shapeableImageView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = appCompatTextView3;
        this.f = appCompatTextView4;
        this.g = constraintLayout;
        this.h = appCompatTextView5;
        this.i = appCompatTextView6;
    }

    public static w a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        ConstraintLayout a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        int i = R$id.ivAvatar;
        ShapeableImageView a8 = f4.b.a(view, i);
        if (a8 == null || (a = f4.b.a(view, (i = R$id.tv_add))) == null || (a2 = f4.b.a(view, (i = R$id.tvDes))) == null || (a3 = f4.b.a(view, (i = R$id.tv_download))) == null || (a4 = f4.b.a(view, (i = R$id.tv_download_page))) == null || (a5 = f4.b.a(view, (i = R$id.tv_music_avatar))) == null || (a6 = f4.b.a(view, (i = R$id.tv_remind))) == null || (a7 = f4.b.a(view, (i = R$id.tv_share))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new w((HorizontalScrollView) view, a8, a, a2, a3, a4, a5, a6, a7);
    }

    public static w c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static w d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.header_extension_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public HorizontalScrollView getRoot() {
        return this.a;
    }
}
