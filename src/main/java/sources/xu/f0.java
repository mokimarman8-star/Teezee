package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f0 implements f4.a {
    private final FrameLayout a;

    private f0(FrameLayout frameLayout) {
        this.a = frameLayout;
    }

    public static f0 a(View view) {
        if (view != null) {
            return new f0((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static f0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.feedback_option_list_header, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
