package iv;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsnet.downloader.adapter.u0;
import com.transsnet.downloader.popup.q;
import kotlin.jvm.internal.Intrinsics;
import zg.h;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    private PopupWindow a;
    private u0.b b;

    private final View c(Context context, final boolean z) {
        String string;
        View inflate = LayoutInflater.from(context).inflate(R$layout.popup_report_layout, (ViewGroup) null);
        inflate.findViewById(R$id.menu_item1).setOnClickListener(new View.OnClickListener() { // from class: iv.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.d(c.this, z, view);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R$id.menu_item2);
        textView.setOnClickListener(new View.OnClickListener() { // from class: iv.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.e(c.this, z, view);
            }
        });
        if (z) {
            textView.setVisibility(8);
            string = textView.getResources().getString(R$string.str_unblock);
        } else {
            string = textView.getResources().getString(R$string.str_block);
        }
        textView.setText(string);
        Intrinsics.e(inflate);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c cVar, boolean z, View view) {
        u0.b bVar = cVar.b;
        if (bVar != null) {
            bVar.b(0, 0, 2, z);
        }
        PopupWindow popupWindow = cVar.a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c cVar, boolean z, View view) {
        u0.b bVar = cVar.b;
        if (bVar != null) {
            bVar.b(0, 0, 1, z);
        }
        PopupWindow popupWindow = cVar.a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void f(u0.b listener) {
        Intrinsics.h(listener, "listener");
        this.b = listener;
    }

    public final void g(View anchorView, boolean z) {
        Intrinsics.h(anchorView, "anchorView");
        Context context = anchorView.getContext();
        Intrinsics.g(context, "getContext(...)");
        View c = c(context, z);
        PopupWindow popupWindow = new PopupWindow(c, -2, -2, true);
        this.a = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        int[] a = q.a.a(anchorView, c);
        h hVar = h.a;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        int a3 = hVar.a(a2, 16.0f);
        int i = a[0] - a3;
        a[0] = i;
        int i2 = a[1] - a3;
        a[1] = i2;
        PopupWindow popupWindow2 = this.a;
        if (popupWindow2 != null) {
            popupWindow2.showAtLocation(anchorView, 8388659, i, i2);
        }
    }
}
