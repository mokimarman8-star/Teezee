package lo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.CustomPublishHeader;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements f4.a {
    private final RelativeLayout a;
    public final FrameLayout b;
    public final CustomPublishHeader c;

    private b(RelativeLayout relativeLayout, FrameLayout frameLayout, CustomPublishHeader customPublishHeader) {
        this.a = relativeLayout;
        this.b = frameLayout;
        this.c = customPublishHeader;
    }

    public static b a(View view) {
        int i = R$id.fl_content;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null) {
            i = R$id.sv_title_bar;
            CustomPublishHeader customPublishHeader = (CustomPublishHeader) f4.b.a(view, i);
            if (customPublishHeader != null) {
                return new b((RelativeLayout) view, frameLayout, customPublishHeader);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_film_review, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
