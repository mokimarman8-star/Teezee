package fp;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLView;
import com.transsion.room.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b0 implements f4.a {
    private final FrameLayout a;
    public final ShapeableImageView b;
    public final ShapeableImageView c;
    public final BLView d;

    private b0(FrameLayout frameLayout, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, BLView bLView) {
        this.a = frameLayout;
        this.b = shapeableImageView;
        this.c = shapeableImageView2;
        this.d = bLView;
    }

    public static b0 a(View view) {
        ShapeableImageView a;
        BLView a2;
        int i = R$id.iv_post_cover_1;
        ShapeableImageView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.iv_post_cover_2))) == null || (a2 = f4.b.a(view, (i = R$id.v_post_bg))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new b0((FrameLayout) view, a3, a, a2);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
