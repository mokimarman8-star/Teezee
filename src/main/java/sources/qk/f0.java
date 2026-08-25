package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.tn.lib.widget.TnTextView;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f0 implements f4.a {
    private final BLConstraintLayout a;
    public final ShapeableImageView b;
    public final ImageView c;
    public final BLTextView d;
    public final TnTextView e;
    public final BLLinearLayout f;

    private f0(BLConstraintLayout bLConstraintLayout, ShapeableImageView shapeableImageView, ImageView imageView, BLTextView bLTextView, TnTextView tnTextView, BLLinearLayout bLLinearLayout) {
        this.a = bLConstraintLayout;
        this.b = shapeableImageView;
        this.c = imageView;
        this.d = bLTextView;
        this.e = tnTextView;
        this.f = bLLinearLayout;
    }

    public static f0 a(View view) {
        BLTextView a;
        TnTextView a2;
        BLLinearLayout a3;
        int i = R.id.ivCover;
        ShapeableImageView a4 = f4.b.a(view, i);
        if (a4 != null) {
            i = R.id.ivTypeIcon;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a = f4.b.a(view, (i = R.id.tvDuration))) != null && (a2 = f4.b.a(view, (i = R.id.tvTitle))) != null && (a3 = f4.b.a(view, (i = R.id.vDurationBg))) != null) {
                return new f0((BLConstraintLayout) view, a4, imageView, a, a2, a3);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static f0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_ugc_vertical_content, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.a;
    }
}
