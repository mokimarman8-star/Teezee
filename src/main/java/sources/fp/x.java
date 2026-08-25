package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLView;
import com.tn.lib.view.RoomJoinAnimationView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class x implements f4.a {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final ShapeableImageView c;
    public final ShapeableImageView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final RoomJoinAnimationView h;
    public final BLView i;

    private x(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, RoomJoinAnimationView roomJoinAnimationView, BLView bLView) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = shapeableImageView;
        this.d = shapeableImageView2;
        this.e = appCompatTextView;
        this.f = appCompatTextView2;
        this.g = appCompatTextView3;
        this.h = roomJoinAnimationView;
        this.i = bLView;
    }

    public static x a(View view) {
        ShapeableImageView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        RoomJoinAnimationView a5;
        BLView a6;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R$id.iv_cover;
        ShapeableImageView a7 = f4.b.a(view, i);
        if (a7 == null || (a = f4.b.a(view, (i = R$id.iv_cover_bg))) == null || (a2 = f4.b.a(view, (i = R$id.tv_members))) == null || (a3 = f4.b.a(view, (i = R$id.tv_tag))) == null || (a4 = f4.b.a(view, (i = R$id.tv_title))) == null || (a5 = f4.b.a(view, (i = R$id.v_join))) == null || (a6 = f4.b.a(view, (i = R$id.v_stroke))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new x(constraintLayout, constraintLayout, a7, a, a2, a3, a4, a5, a6);
    }

    public static x c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.item_recommend_rooms, viewGroup, false);
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
