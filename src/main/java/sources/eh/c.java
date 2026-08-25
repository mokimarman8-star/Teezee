package eh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;
import com.tn.lib.widget.TnTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c implements f4.a {
    private final View a;
    public final AppCompatImageView b;
    public final TnTextView c;
    public final LinearLayoutCompat d;
    public final TitleLayout e;
    public final TnTextView f;
    public final TnTextView g;

    private c(View view, AppCompatImageView appCompatImageView, TnTextView tnTextView, LinearLayoutCompat linearLayoutCompat, TitleLayout titleLayout, TnTextView tnTextView2, TnTextView tnTextView3) {
        this.a = view;
        this.b = appCompatImageView;
        this.c = tnTextView;
        this.d = linearLayoutCompat;
        this.e = titleLayout;
        this.f = tnTextView2;
        this.g = tnTextView3;
    }

    public static c a(View view) {
        TnTextView a;
        LinearLayoutCompat a2;
        TnTextView a3;
        TnTextView a4;
        int i = R$id.bg_no_connection;
        AppCompatImageView a5 = f4.b.a(view, i);
        if (a5 != null && (a = f4.b.a(view, (i = R$id.go_to_setting))) != null && (a2 = f4.b.a(view, (i = R$id.ll_no_connection_tip))) != null) {
            i = R$id.ll_title;
            TitleLayout titleLayout = (TitleLayout) f4.b.a(view, i);
            if (titleLayout != null && (a3 = f4.b.a(view, (i = R$id.no_connection_title))) != null && (a4 = f4.b.a(view, (i = R$id.retry))) != null) {
                return new c(view, a5, a, a2, titleLayout, a3, a4);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static c b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.view_no_connection, viewGroup);
        return a(viewGroup);
    }

    public View getRoot() {
        return this.a;
    }
}
