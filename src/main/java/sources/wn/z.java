package wn;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLLinearLayout;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class z implements f4.a {
    private final BLLinearLayout a;
    public final ConstraintLayout b;
    public final ShapeableImageView c;
    public final ShapeableImageView d;
    public final AppCompatImageView e;
    public final LinearLayout f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final View k;
    public final View l;
    public final View m;

    private z(BLLinearLayout bLLinearLayout, ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, AppCompatImageView appCompatImageView, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, View view, View view2, View view3) {
        this.a = bLLinearLayout;
        this.b = constraintLayout;
        this.c = shapeableImageView;
        this.d = shapeableImageView2;
        this.e = appCompatImageView;
        this.f = linearLayout;
        this.g = appCompatTextView;
        this.h = appCompatTextView2;
        this.i = appCompatTextView3;
        this.j = appCompatTextView4;
        this.k = view;
        this.l = view2;
        this.m = view3;
    }

    public static z a(View view) {
        ShapeableImageView a;
        ShapeableImageView a2;
        AppCompatImageView a3;
        AppCompatTextView a4;
        AppCompatTextView a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        View a8;
        View a9;
        View a10;
        int i = R$id.cl_subject_content;
        ConstraintLayout a11 = f4.b.a(view, i);
        if (a11 != null && (a = f4.b.a(view, (i = R$id.iv_room_cover))) != null && (a2 = f4.b.a(view, (i = R$id.iv_subject_cover))) != null && (a3 = f4.b.a(view, (i = R$id.iv_subject_tag))) != null) {
            i = R$id.ll_room_tag;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a4 = f4.b.a(view, (i = R$id.tv_room_tag))) != null && (a5 = f4.b.a(view, (i = R$id.tv_subject_date))) != null && (a6 = f4.b.a(view, (i = R$id.tv_subject_genre))) != null && (a7 = f4.b.a(view, (i = R$id.tv_subject_name))) != null && (a8 = f4.b.a(view, (i = R$id.v_subject_line_1))) != null && (a9 = f4.b.a(view, (i = R$id.v_subject_line_2))) != null && (a10 = f4.b.a(view, (i = R$id.v_subject_room_line))) != null) {
                return new z((BLLinearLayout) view, a11, a, a2, a3, linearLayout, a4, a5, a6, a7, a8, a9, a10);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLLinearLayout getRoot() {
        return this.a;
    }
}
