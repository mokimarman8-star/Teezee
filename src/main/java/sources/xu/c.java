package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c implements f4.a {
    private final LinearLayout a;
    public final EditTextWithClear b;
    public final EditTextWithClear c;
    public final EditTextWithClear d;
    public final TextView e;
    public final TextView f;

    private c(LinearLayout linearLayout, EditTextWithClear editTextWithClear, EditTextWithClear editTextWithClear2, EditTextWithClear editTextWithClear3, TextView textView, TextView textView2) {
        this.a = linearLayout;
        this.b = editTextWithClear;
        this.c = editTextWithClear2;
        this.d = editTextWithClear3;
        this.e = textView;
        this.f = textView2;
    }

    public static c a(View view) {
        EditTextWithClear a;
        EditTextWithClear a2;
        int i = R$id.edDeeplink;
        EditTextWithClear a3 = f4.b.a(view, i);
        if (a3 != null && (a = f4.b.a(view, (i = R$id.etAppId))) != null && (a2 = f4.b.a(view, (i = R$id.etSceneId))) != null) {
            i = R$id.tvApiOpen;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                i = R$id.tvDpOpen;
                TextView textView2 = (TextView) f4.b.a(view, i);
                if (textView2 != null) {
                    return new c((LinearLayout) view, a3, a, a2, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_lab_miniapp_sdk, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
