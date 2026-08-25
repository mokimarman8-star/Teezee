package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.tn.lib.view.RoomJoinAnimationView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class y implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final Group c;
    public final ShapeableImageView d;
    public final b0 e;
    public final c0 f;
    public final AppCompatTextView g;
    public final BLTextView h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;
    public final RoomJoinAnimationView l;
    public final View m;
    public final BLView n;

    private y(ConstraintLayout constraintLayout, FrameLayout frameLayout, Group group, ShapeableImageView shapeableImageView, b0 b0Var, c0 c0Var, AppCompatTextView appCompatTextView, BLTextView bLTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, RoomJoinAnimationView roomJoinAnimationView, View view, BLView bLView) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = group;
        this.d = shapeableImageView;
        this.e = b0Var;
        this.f = c0Var;
        this.g = appCompatTextView;
        this.h = bLTextView;
        this.i = appCompatTextView2;
        this.j = appCompatTextView3;
        this.k = appCompatTextView4;
        this.l = roomJoinAnimationView;
        this.m = view;
        this.n = bLView;
    }

    public static y a(View view) {
        Group a;
        ShapeableImageView a2;
        View a3;
        BLTextView a4;
        AppCompatTextView a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        RoomJoinAnimationView a8;
        View a9;
        BLView a10;
        int i = R$id.fl_new_post_cover;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R$id.group_new_post))) != null && (a2 = f4.b.a(view, (i = R$id.iv_cover))) != null && (a3 = f4.b.a(view, (i = R$id.layout_new_post_image))) != null) {
            b0 a11 = b0.a(a3);
            i = R$id.layout_new_post_video;
            View a12 = f4.b.a(view, i);
            if (a12 != null) {
                c0 a13 = c0.a(a12);
                i = R$id.tv_member;
                AppCompatTextView a14 = f4.b.a(view, i);
                if (a14 != null && (a4 = f4.b.a(view, (i = R$id.tv_new_count))) != null && (a5 = f4.b.a(view, (i = R$id.tv_new_post_content))) != null && (a6 = f4.b.a(view, (i = R$id.tv_tag))) != null && (a7 = f4.b.a(view, (i = R$id.tv_title))) != null && (a8 = f4.b.a(view, (i = R$id.v_join))) != null && (a9 = f4.b.a(view, (i = R$id.v_line))) != null && (a10 = f4.b.a(view, (i = R$id.v_new_post_bg))) != null) {
                    return new y((ConstraintLayout) view, frameLayout, a, a2, a11, a13, a14, a4, a5, a6, a7, a8, a9, a10);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static y c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.item_room_list, viewGroup, false);
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
