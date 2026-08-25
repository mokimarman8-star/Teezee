package um;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ninegridview.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements f4.a {
    private final View a;
    public final AppCompatImageView b;
    public final FrameLayout c;
    public final ShapeableImageView d;

    private d(View view, AppCompatImageView appCompatImageView, FrameLayout frameLayout, ShapeableImageView shapeableImageView) {
        this.a = view;
        this.b = appCompatImageView;
        this.c = frameLayout;
        this.d = shapeableImageView;
    }

    public static d a(View view) {
        ShapeableImageView a;
        int i = R$id.label_gif;
        AppCompatImageView a2 = f4.b.a(view, i);
        if (a2 != null) {
            i = R$id.video_container;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null && (a = f4.b.a(view, (i = R$id.video_cover))) != null) {
                return new d(view, a2, frameLayout, a);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
