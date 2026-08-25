package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c0 implements f4.a {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final ShapeableImageView c;
    public final BLTextView d;
    public final AppCompatTextView e;
    public final BLView f;

    private c0(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ShapeableImageView shapeableImageView, BLTextView bLTextView, AppCompatTextView appCompatTextView, BLView bLView) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = shapeableImageView;
        this.d = bLTextView;
        this.e = appCompatTextView;
        this.f = bLView;
    }

    public static c0 a(View view) {
        BLTextView a;
        AppCompatTextView a2;
        BLView a3;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.ivCover;
        ShapeableImageView a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R.id.tvMembers))) == null || (a2 = f4.b.a(view, (i = R.id.tvTitle))) == null || (a3 = f4.b.a(view, (i = R.id.v_stroke))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new c0(constraintLayout, constraintLayout, a4, a, a2, a3);
    }

    public static c0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_adapter_room_entrance_group, viewGroup, false);
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
