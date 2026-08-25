package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLLinearLayout;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.InfoExtendView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements f4.a {
    private final ConstraintLayout a;
    public final InfoExtendView b;
    public final ShapeableImageView c;
    public final AppCompatImageView d;
    public final AppCompatTextView e;
    public final LinearLayoutCompat f;
    public final AppCompatTextView g;
    public final BLLinearLayout h;
    public final AppCompatTextView i;

    private i(ConstraintLayout constraintLayout, InfoExtendView infoExtendView, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView2, BLLinearLayout bLLinearLayout, AppCompatTextView appCompatTextView3) {
        this.a = constraintLayout;
        this.b = infoExtendView;
        this.c = shapeableImageView;
        this.d = appCompatImageView;
        this.e = appCompatTextView;
        this.f = linearLayoutCompat;
        this.g = appCompatTextView2;
        this.h = bLLinearLayout;
        this.i = appCompatTextView3;
    }

    public static i a(View view) {
        ShapeableImageView a;
        AppCompatImageView a2;
        AppCompatTextView a3;
        LinearLayoutCompat a4;
        AppCompatTextView a5;
        BLLinearLayout a6;
        AppCompatTextView a7;
        int i = R$id.infoExtendView;
        InfoExtendView infoExtendView = (InfoExtendView) f4.b.a(view, i);
        if (infoExtendView == null || (a = f4.b.a(view, (i = R$id.ivAvatar))) == null || (a2 = f4.b.a(view, (i = R$id.tv_close))) == null || (a3 = f4.b.a(view, (i = R$id.tvDes))) == null || (a4 = f4.b.a(view, (i = R$id.tv_header_toolbar))) == null || (a5 = f4.b.a(view, (i = R$id.tvMovieTitle))) == null || (a6 = f4.b.a(view, (i = R$id.tv_music_avatar))) == null || (a7 = f4.b.a(view, (i = R$id.tvTag))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new i((ConstraintLayout) view, infoExtendView, a, a2, a3, a4, a5, a6, a7);
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_music_info_dialog, viewGroup, false);
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
