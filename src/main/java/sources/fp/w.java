package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class w implements f4.a {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final ShapeableImageView c;
    public final AppCompatTextView d;

    private w(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = shapeableImageView;
        this.d = appCompatTextView;
    }

    public static w a(View view) {
        AppCompatTextView a;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R$id.iv_cover;
        ShapeableImageView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.tv_title))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new w(constraintLayout, constraintLayout, a2, a);
    }

    public static w c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static w d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.item_community_rooms_footer, viewGroup, false);
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
