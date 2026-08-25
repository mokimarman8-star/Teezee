package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements f4.a {
    private final ConstraintLayout a;
    public final Group b;
    public final Group c;
    public final ShapeableImageView d;
    public final ShapeableImageView e;
    public final AppCompatImageView f;
    public final ProgressBar g;
    public final TextView h;
    public final View i;
    public final AppCompatImageView j;
    public final SecondariesSeekBar k;
    public final TextView l;
    public final ViewStub m;

    private j(ConstraintLayout constraintLayout, Group group, Group group2, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, AppCompatImageView appCompatImageView, ProgressBar progressBar, TextView textView, View view, AppCompatImageView appCompatImageView2, SecondariesSeekBar secondariesSeekBar, TextView textView2, ViewStub viewStub) {
        this.a = constraintLayout;
        this.b = group;
        this.c = group2;
        this.d = shapeableImageView;
        this.e = shapeableImageView2;
        this.f = appCompatImageView;
        this.g = progressBar;
        this.h = textView;
        this.i = view;
        this.j = appCompatImageView2;
        this.k = secondariesSeekBar;
        this.l = textView2;
        this.m = viewStub;
    }

    public static j a(View view) {
        Group a;
        ShapeableImageView a2;
        ShapeableImageView a3;
        AppCompatImageView a4;
        View a5;
        AppCompatImageView a6;
        SecondariesSeekBar a7;
        int i = R$id.groupLoading;
        Group a8 = f4.b.a(view, i);
        if (a8 != null && (a = f4.b.a(view, (i = R$id.groupProgress))) != null && (a2 = f4.b.a(view, (i = R$id.ivMovieBlurCover))) != null && (a3 = f4.b.a(view, (i = R$id.ivMovieCover))) != null && (a4 = f4.b.a(view, (i = R$id.ivPlay))) != null) {
            i = R$id.progress;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null) {
                i = R$id.tvLoading;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null && (a5 = f4.b.a(view, (i = R$id.vTap))) != null && (a6 = f4.b.a(view, (i = R$id.vdPause))) != null && (a7 = f4.b.a(view, (i = R$id.vdSeekbar))) != null) {
                    i = R$id.vdVideoTime;
                    TextView textView2 = (TextView) f4.b.a(view, i);
                    if (textView2 != null) {
                        i = R$id.vsLoadFailed;
                        ViewStub viewStub = (ViewStub) f4.b.a(view, i);
                        if (viewStub != null) {
                            return new j((ConstraintLayout) view, a8, a, a2, a3, a4, progressBar, textView, a5, a6, a7, textView2, viewStub);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static j c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_music_trailer_layout, viewGroup, false);
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
