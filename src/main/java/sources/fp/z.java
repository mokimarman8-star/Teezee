package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLTextView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class z implements f4.a {
    private final BLFrameLayout a;
    public final BLFrameLayout b;
    public final BLTextView c;
    public final View d;

    private z(BLFrameLayout bLFrameLayout, BLFrameLayout bLFrameLayout2, BLTextView bLTextView, View view) {
        this.a = bLFrameLayout;
        this.b = bLFrameLayout2;
        this.c = bLTextView;
        this.d = view;
    }

    public static z a(View view) {
        View a;
        BLFrameLayout bLFrameLayout = (BLFrameLayout) view;
        int i = R$id.tv_title;
        BLTextView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.v_selected))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new z(bLFrameLayout, bLFrameLayout, a2, a);
    }

    public static z c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.item_room_list_tab, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLFrameLayout getRoot() {
        return this.a;
    }
}
