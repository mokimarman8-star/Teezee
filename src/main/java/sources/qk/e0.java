package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.TnTextView;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e0 implements f4.a {
    private final LinearLayout a;
    public final ShapeableImageView b;
    public final TnTextView c;

    private e0(LinearLayout linearLayout, ShapeableImageView shapeableImageView, TnTextView tnTextView) {
        this.a = linearLayout;
        this.b = shapeableImageView;
        this.c = tnTextView;
    }

    public static e0 a(View view) {
        TnTextView a;
        int i = R.id.ivCover;
        ShapeableImageView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R.id.tvTitle))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new e0((LinearLayout) view, a2, a);
    }

    public static e0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_single_image, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
