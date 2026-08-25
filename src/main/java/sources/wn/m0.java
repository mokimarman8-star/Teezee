package wn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatTextView;
import com.noober.background.view.BLTextView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m0 implements f4.a {
    private final View a;
    public final BLTextView b;
    public final Space c;
    public final BLTextView d;
    public final AppCompatTextView e;

    private m0(View view, BLTextView bLTextView, Space space, BLTextView bLTextView2, AppCompatTextView appCompatTextView) {
        this.a = view;
        this.b = bLTextView;
        this.c = space;
        this.d = bLTextView2;
        this.e = appCompatTextView;
    }

    public static m0 a(View view) {
        BLTextView a;
        AppCompatTextView a2;
        int i = R$id.go_to_setting;
        BLTextView a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R$id.guideline;
            Space space = (Space) f4.b.a(view, i);
            if (space != null && (a = f4.b.a(view, (i = R$id.retry))) != null && (a2 = f4.b.a(view, (i = R$id.tv_title))) != null) {
                return new m0(view, a3, space, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static m0 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.view_imm_video_not_net, viewGroup);
        return a(viewGroup);
    }

    public View getRoot() {
        return this.a;
    }
}
