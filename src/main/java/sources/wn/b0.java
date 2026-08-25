package wn;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b0 implements f4.a {
    private final CardView a;
    public final FrameLayout b;
    public final CardView c;
    public final ShapeableImageView d;
    public final AppCompatImageView e;
    public final BLTextView f;
    public final BLView g;

    private b0(CardView cardView, FrameLayout frameLayout, CardView cardView2, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, BLTextView bLTextView, BLView bLView) {
        this.a = cardView;
        this.b = frameLayout;
        this.c = cardView2;
        this.d = shapeableImageView;
        this.e = appCompatImageView;
        this.f = bLTextView;
        this.g = bLView;
    }

    public static b0 a(View view) {
        AppCompatImageView a;
        BLTextView a2;
        int i = R$id.flPlayer;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null) {
            CardView cardView = (CardView) view;
            i = R$id.iv_cover;
            ShapeableImageView a3 = f4.b.a(view, i);
            if (a3 != null && (a = f4.b.a(view, (i = R$id.iv_video_play))) != null && (a2 = f4.b.a(view, (i = R$id.tv_video_duration))) != null) {
                return new b0(cardView, frameLayout, cardView, a3, a, a2, f4.b.a(view, R$id.v_cover_stroke));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.a;
    }
}
