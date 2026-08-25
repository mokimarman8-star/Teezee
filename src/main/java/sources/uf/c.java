package uf;

import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.view.View;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.d;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static long f18027a;

    public static final void b(View view, final long j5, final Function1 function1) {
        Intrinsics.h(view, "<this>");
        Intrinsics.h(function1, "action");
        view.setOnClickListener(new View.OnClickListener() { // from class: uf.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.d(j5, function1, view2);
            }
        });
    }

    public static /* synthetic */ void c(View view, long j5, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            j5 = 500;
        }
        b(view, j5, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(long j5, Function1 function1, View view) {
        long nanoTime = System.nanoTime();
        long j6 = f18027a;
        if (j6 == 0 || nanoTime - j6 >= j5) {
            f18027a = nanoTime;
            Intrinsics.e(view);
            function1.invoke(view);
        }
    }

    public static final void e(View view) {
        Intrinsics.h(view, "<this>");
        view.setPadding(view.getPaddingStart(), view.getPaddingTop() + d.c(), view.getPaddingEnd(), view.getPaddingBottom());
    }

    public static final boolean f() {
        Locale locale;
        LocaleList locales;
        String string = com.transsion.baselib.report.launch.b.a.b().getString("k_language_short_name", (String) null);
        if (Build.VERSION.SDK_INT >= 24) {
            locales = Utils.a().getResources().getConfiguration().getLocales();
            locale = locales.get(0);
        } else {
            locale = Utils.a().getResources().getConfiguration().locale;
        }
        if (!Intrinsics.c(locale.getLanguage(), string) && string != null && string.length() > 0) {
            locale = new Locale(string, locale.getCountry());
        }
        return TextUtils.getLayoutDirectionFromLocale(locale) == 1;
    }

    public static final void g(View view) {
        Intrinsics.h(view, "<this>");
        view.setVisibility(8);
    }

    public static final void h(View view) {
        Intrinsics.h(view, "<this>");
        view.setVisibility(4);
    }

    public static final boolean i(View view) {
        Intrinsics.h(view, "<this>");
        return view.getVisibility() == 0;
    }

    public static final void j(View view, boolean z5) {
        Intrinsics.h(view, "<this>");
        view.setVisibility(z5 ? 0 : 8);
    }

    public static final void k(View view) {
        Intrinsics.h(view, "<this>");
        view.setVisibility(0);
    }
}
