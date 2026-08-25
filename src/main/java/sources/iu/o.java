package iu;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.noober.background.view.BLView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.widget.TopCropShapeableImageView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class o implements f4.a {
    private final ConstraintLayout a;
    public final Group b;
    public final Group c;
    public final TopCropShapeableImageView d;
    public final TopCropShapeableImageView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;
    public final BLView i;
    public final BLView j;

    private o(ConstraintLayout constraintLayout, Group group, Group group2, TopCropShapeableImageView topCropShapeableImageView, TopCropShapeableImageView topCropShapeableImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, BLView bLView, BLView bLView2) {
        this.a = constraintLayout;
        this.b = group;
        this.c = group2;
        this.d = topCropShapeableImageView;
        this.e = topCropShapeableImageView2;
        this.f = appCompatTextView;
        this.g = appCompatTextView2;
        this.h = appCompatTextView3;
        this.i = bLView;
        this.j = bLView2;
    }

    public static o a(View view) {
        Group a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        BLView a5;
        BLView a6;
        int i = R$id.groupPreview;
        Group a7 = f4.b.a(view, i);
        if (a7 != null && (a = f4.b.a(view, (i = R$id.groupPreviewCollection))) != null) {
            i = R$id.ivPreviewImage;
            TopCropShapeableImageView topCropShapeableImageView = (TopCropShapeableImageView) f4.b.a(view, i);
            if (topCropShapeableImageView != null) {
                i = R$id.ivPreviewImageCollection;
                TopCropShapeableImageView topCropShapeableImageView2 = (TopCropShapeableImageView) f4.b.a(view, i);
                if (topCropShapeableImageView2 != null && (a2 = f4.b.a(view, (i = R$id.tvClickText))) != null && (a3 = f4.b.a(view, (i = R$id.tvClickTextCollection))) != null && (a4 = f4.b.a(view, (i = R$id.tvTitle))) != null && (a5 = f4.b.a(view, (i = R$id.vGradientOverlay))) != null && (a6 = f4.b.a(view, (i = R$id.vGradientOverlayCollection))) != null) {
                    return new o((ConstraintLayout) view, a7, a, topCropShapeableImageView, topCropShapeableImageView2, a2, a3, a4, a5, a6);
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
