package iu;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.transsion.ugcvideodetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class n implements f4.a {
    private final ConstraintLayout a;
    public final BLTextView b;
    public final BLTextView c;
    public final Group d;
    public final Group e;
    public final ShapeableImageView f;
    public final AppCompatImageView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;

    private n(ConstraintLayout constraintLayout, BLTextView bLTextView, BLTextView bLTextView2, Group group, Group group2, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.a = constraintLayout;
        this.b = bLTextView;
        this.c = bLTextView2;
        this.d = group;
        this.e = group2;
        this.f = shapeableImageView;
        this.g = appCompatImageView;
        this.h = appCompatTextView;
        this.i = appCompatTextView2;
        this.j = appCompatTextView3;
    }

    public static n a(View view) {
        BLTextView a;
        Group a2;
        Group a3;
        ShapeableImageView a4;
        AppCompatImageView a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        int i = R$id.bgDetails;
        BLTextView a9 = f4.b.a(view, i);
        if (a9 == null || (a = f4.b.a(view, (i = R$id.bgDownload))) == null || (a2 = f4.b.a(view, (i = R$id.groupDetails))) == null || (a3 = f4.b.a(view, (i = R$id.groupDownload))) == null || (a4 = f4.b.a(view, (i = R$id.ivAvatar))) == null || (a5 = f4.b.a(view, (i = R$id.ivDownload))) == null || (a6 = f4.b.a(view, (i = R$id.tvDetails))) == null || (a7 = f4.b.a(view, (i = R$id.tvDownload))) == null || (a8 = f4.b.a(view, (i = R$id.tvTitle))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new n((ConstraintLayout) view, a9, a, a2, a3, a4, a5, a6, a7, a8);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
