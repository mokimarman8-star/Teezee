package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a0 implements f4.a {
    private final ConstraintLayout a;
    public final ShapeableImageView b;
    public final AppCompatTextView c;
    public final BLTextView d;
    public final BLView e;
    public final BLView f;

    private a0(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, BLTextView bLTextView, BLView bLView, BLView bLView2) {
        this.a = constraintLayout;
        this.b = shapeableImageView;
        this.c = appCompatTextView;
        this.d = bLTextView;
        this.e = bLView;
        this.f = bLView2;
    }

    public static a0 a(View view) {
        AppCompatTextView a;
        BLTextView a2;
        BLView a3;
        BLView a4;
        int i = R$id.iv_cover;
        ShapeableImageView a5 = f4.b.a(view, i);
        if (a5 == null || (a = f4.b.a(view, (i = R$id.tv_name))) == null || (a2 = f4.b.a(view, (i = R$id.tv_new_count))) == null || (a3 = f4.b.a(view, (i = R$id.v_name_bg))) == null || (a4 = f4.b.a(view, (i = R$id.v_stroke))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new a0((ConstraintLayout) view, a5, a, a2, a3, a4);
    }

    public static a0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.item_your_rooms, viewGroup, false);
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
