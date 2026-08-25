package bx;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class l implements f4.a {
    private final FrameLayout a;
    public final Group b;
    public final Group c;
    public final AppCompatImageView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final View j;
    public final View k;
    public final View l;
    public final View m;

    private l(FrameLayout frameLayout, Group group, Group group2, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view, View view2, View view3, View view4) {
        this.a = frameLayout;
        this.b = group;
        this.c = group2;
        this.d = appCompatImageView;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
        this.i = textView5;
        this.j = view;
        this.k = view2;
        this.l = view3;
        this.m = view4;
    }

    public static l a(View view) {
        Group a;
        AppCompatImageView a2;
        View a3;
        View a4;
        View a5;
        View a6;
        int i = R.id.groupBatteryPermission;
        Group a7 = f4.b.a(view, i);
        if (a7 != null && (a = f4.b.a(view, (i = R.id.groupPremium))) != null && (a2 = f4.b.a(view, (i = R.id.ivPremium))) != null) {
            i = R.id.tvBatteryPermission;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                i = R.id.tvCancel;
                TextView textView2 = (TextView) f4.b.a(view, i);
                if (textView2 != null) {
                    i = R.id.tvDownloadXXSizeAtOnce;
                    TextView textView3 = (TextView) f4.b.a(view, i);
                    if (textView3 != null) {
                        i = R.id.tvPremium;
                        TextView textView4 = (TextView) f4.b.a(view, i);
                        if (textView4 != null) {
                            i = R.id.tvResumeAll;
                            TextView textView5 = (TextView) f4.b.a(view, i);
                            if (textView5 != null && (a3 = f4.b.a(view, (i = R.id.viewBgPremium))) != null && (a4 = f4.b.a(view, (i = R.id.viewLine1))) != null && (a5 = f4.b.a(view, (i = R.id.viewLine2))) != null && (a6 = f4.b.a(view, (i = R.id.viewLine3))) != null) {
                                return new l((FrameLayout) view, a7, a, a2, textView, textView2, textView3, textView4, textView5, a3, a4, a5, a6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
