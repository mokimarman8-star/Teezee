package fp;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.room.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c0 implements f4.a {
    private final FrameLayout a;
    public final ShapeableImageView b;

    private c0(FrameLayout frameLayout, ShapeableImageView shapeableImageView) {
        this.a = frameLayout;
        this.b = shapeableImageView;
    }

    public static c0 a(View view) {
        int i = R$id.iv_post_cover;
        ShapeableImageView a = f4.b.a(view, i);
        if (a != null) {
            return new c0((FrameLayout) view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
