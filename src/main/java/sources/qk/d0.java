package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d0 implements f4.a {
    private final BLConstraintLayout a;
    public final Group b;
    public final ShapeableImageView c;
    public final ShapeableImageView d;
    public final AppCompatImageView e;
    public final TnTextView f;
    public final TnTextView g;
    public final View h;

    private d0(BLConstraintLayout bLConstraintLayout, Group group, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, AppCompatImageView appCompatImageView, TnTextView tnTextView, TnTextView tnTextView2, View view) {
        this.a = bLConstraintLayout;
        this.b = group;
        this.c = shapeableImageView;
        this.d = shapeableImageView2;
        this.e = appCompatImageView;
        this.f = tnTextView;
        this.g = tnTextView2;
        this.h = view;
    }

    public static d0 a(View view) {
        ShapeableImageView a;
        ShapeableImageView a2;
        AppCompatImageView a3;
        TnTextView a4;
        TnTextView a5;
        View a6;
        int i = R.id.group_room_info;
        Group a7 = f4.b.a(view, i);
        if (a7 == null || (a = f4.b.a(view, (i = R.id.ivCover))) == null || (a2 = f4.b.a(view, (i = R.id.iv_room_cover))) == null || (a3 = f4.b.a(view, (i = R.id.ivVideoPlay))) == null || (a4 = f4.b.a(view, (i = R.id.tv_room_title))) == null || (a5 = f4.b.a(view, (i = R.id.tvTitle))) == null || (a6 = f4.b.a(view, (i = R.id.v_room_info))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new d0((BLConstraintLayout) view, a7, a, a2, a3, a4, a5, a6);
    }

    public static d0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_adapter_room_entrance_post, viewGroup, false);
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
