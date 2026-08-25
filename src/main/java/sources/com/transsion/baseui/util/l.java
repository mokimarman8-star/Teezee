package com.transsion.baseui.util;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class l {
    private static final Pattern a = Pattern.compile("(?i:http|https|rtsp|ftp)://");

    public static final class a extends ClickableSpan {
        final /* synthetic */ Function2 a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;
        final /* synthetic */ int d;

        a(Function2 function2, String str, boolean z, int i) {
            this.a = function2;
            this.b = str;
            this.c = z;
            this.d = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Intrinsics.h(view, "widget");
            Function2 function2 = this.a;
            if (function2 != null) {
                String str = this.b;
                if (str == null) {
                    str = BuildConfig.FLAVOR;
                }
                function2.invoke(view, str);
            }
            if (this.c) {
                l.d(this.b);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Intrinsics.h(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(this.d);
        }
    }

    public static final class b extends ClickableSpan {
        final /* synthetic */ Function2 a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;
        final /* synthetic */ int d;

        b(Function2 function2, String str, boolean z, int i) {
            this.a = function2;
            this.b = str;
            this.c = z;
            this.d = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Intrinsics.h(view, "widget");
            Function2 function2 = this.a;
            if (function2 != null) {
                String str = this.b;
                if (str == null) {
                    str = BuildConfig.FLAVOR;
                }
                function2.invoke(view, str);
            }
            if (this.c) {
                l.d(this.b);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Intrinsics.h(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(this.d);
        }
    }

    public static final SpannableString b(TextView textView, CharSequence charSequence, boolean z, g gVar, Function2 function2) {
        boolean z2;
        int i;
        Object obj = null;
        if (textView != null) {
            textView.setOnTouchListener(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            return new SpannableString(BuildConfig.FLAVOR);
        }
        ArrayList<UrlContent> arrayList = new ArrayList();
        Matcher matcher = Patterns.WEB_URL.matcher(charSequence);
        int color = androidx.core.content.b.getColor(Utils.a(), R.color.color_0ba7ff);
        CharSequence charSequence2 = charSequence;
        while (matcher.find()) {
            String group = matcher.group();
            Intrinsics.e(group);
            int i2 = 0;
            if (StringsKt.G(group, ")", false, 2, obj)) {
                Intrinsics.e(group);
                group = StringsKt.Q(group, ")", BuildConfig.FLAVOR, false, 4, (Object) null);
            }
            if (charSequence2 != null) {
                Intrinsics.e(group);
                z2 = false;
                i2 = StringsKt.o0(charSequence2, group, 0, false, 6, (Object) null);
            } else {
                z2 = false;
            }
            Intrinsics.e(group);
            boolean z3 = z2;
            String Q = StringsKt.Q(group, "%20", " ", false, 4, (Object) null);
            Matcher matcher2 = a.matcher(Q);
            if (matcher2.find()) {
                String group2 = matcher2.group();
                Intrinsics.g(group2, "group(...)");
                String Q2 = StringsKt.Q(Q, group2, BuildConfig.FLAVOR, false, 4, (Object) null);
                Matcher matcher3 = Patterns.DOMAIN_NAME.matcher(Q2);
                if (matcher3.find()) {
                    String group3 = matcher3.group();
                    Intrinsics.e(group3);
                    i = 2;
                    if (StringsKt.c0(group3, ".", z3, 2, obj)) {
                        List S0 = StringsKt.S0(group3, new String[]{"."}, false, 0, 6, (Object) null);
                        if (S0.size() > 2) {
                            Q2 = StringsKt.Q(Q2, S0.get(z3 ? 1 : 0) + ".", BuildConfig.FLAVOR, false, 4, (Object) null);
                        }
                    }
                } else {
                    i = 2;
                }
                if (Q2.length() > 24) {
                    Q2 = StringsKt.M0(Q2, 24, Q2.length(), "...").toString();
                }
                String str = "-" + Q2;
                String valueOf = String.valueOf(charSequence2);
                Intrinsics.e(group);
                charSequence2 = StringsKt.S(valueOf, group, str, false, 4, (Object) null);
                Drawable drawable = androidx.core.content.b.getDrawable(Utils.a(), com.transsion.baseui.R.mipmap.base_ic_url_link);
                if (drawable != null) {
                    drawable.setBounds(z3 ? 1 : 0, z3 ? 1 : 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                }
                arrayList.add(new UrlContent(new a(function2, Q, z, color), drawable != null ? new com.transsion.baseui.widget.d(drawable, i) : null, group, str, i2));
                obj = null;
            }
        }
        if (arrayList.isEmpty()) {
            return new SpannableString(charSequence);
        }
        SpannableString spannableString = new SpannableString(charSequence2);
        for (UrlContent urlContent : arrayList) {
            spannableString.setSpan(urlContent.getIconSpan(), urlContent.getIndexOfUrl(), urlContent.getIndexOfUrl() + 1, 33);
            spannableString.setSpan(urlContent.getClickableSpan(), urlContent.getIndexOfUrl(), urlContent.getIndexOfUrl() + urlContent.getUrl().length(), 33);
        }
        if (gVar != null) {
            gVar.a(arrayList);
        }
        if (textView != null) {
            textView.setOnTouchListener(new pj.a(spannableString));
        }
        if (textView != null) {
            textView.setHighlightColor(androidx.core.content.b.getColor(Utils.a(), R.color.cl17));
        }
        return spannableString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v22 */
    public static final SpannableStringBuilder c(TextView textView, CharSequence charSequence, boolean z, int i, g gVar, Function2 function2) {
        SpannableStringBuilder spannableStringBuilder;
        Matcher matcher;
        ?? r5;
        int i2;
        Object obj = null;
        if (textView != null) {
            textView.setOnTouchListener(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            return new SpannableStringBuilder(BuildConfig.FLAVOR);
        }
        ArrayList<UrlContent> arrayList = new ArrayList();
        Matcher matcher2 = Patterns.WEB_URL.matcher(charSequence);
        int color = androidx.core.content.b.getColor(Utils.a(), R.color.color_0ba7ff);
        CharSequence charSequence2 = charSequence;
        while (true) {
            int i3 = 0;
            if (!matcher2.find()) {
                break;
            }
            String group = matcher2.group();
            Intrinsics.e(group);
            if (StringsKt.G(group, ")", false, 2, obj)) {
                Intrinsics.e(group);
                group = StringsKt.Q(group, ")", BuildConfig.FLAVOR, false, 4, (Object) null);
            }
            String str = group;
            if (charSequence2 != null) {
                Intrinsics.e(str);
                matcher = matcher2;
                r5 = 0;
                i3 = StringsKt.o0(charSequence2, str, 0, false, 6, (Object) null);
            } else {
                matcher = matcher2;
                r5 = 0;
            }
            Intrinsics.e(str);
            String Q = StringsKt.Q(str, "%20", " ", false, 4, (Object) null);
            Matcher matcher3 = a.matcher(Q);
            if (matcher3.find()) {
                String group2 = matcher3.group();
                Intrinsics.g(group2, "group(...)");
                String Q2 = StringsKt.Q(Q, group2, BuildConfig.FLAVOR, false, 4, (Object) null);
                Matcher matcher4 = Patterns.DOMAIN_NAME.matcher(Q2);
                if (matcher4.find()) {
                    String group3 = matcher4.group();
                    Intrinsics.e(group3);
                    i2 = 2;
                    if (StringsKt.c0(group3, ".", (boolean) r5, 2, obj)) {
                        List S0 = StringsKt.S0(group3, new String[]{"."}, false, 0, 6, (Object) null);
                        if (S0.size() > 2) {
                            Q2 = StringsKt.Q(Q2, S0.get(r5) + ".", BuildConfig.FLAVOR, false, 4, (Object) null);
                        }
                    }
                } else {
                    i2 = 2;
                }
                if (Q2.length() > 24) {
                    Q2 = StringsKt.M0(Q2, 24, Q2.length(), "...").toString();
                }
                String str2 = "-" + Q2;
                String valueOf = String.valueOf(charSequence2);
                Intrinsics.e(str);
                charSequence2 = StringsKt.S(valueOf, str, str2, false, 4, (Object) null);
                Drawable drawable = androidx.core.content.b.getDrawable(Utils.a(), com.transsion.baseui.R.mipmap.base_ic_url_link);
                if (drawable != 0) {
                    drawable.setBounds(r5, r5, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                }
                arrayList.add(new UrlContent(new b(function2, Q, z, color), drawable != 0 ? new com.transsion.baseui.widget.d(drawable, i2) : null, str, str2, i3));
                matcher2 = matcher;
                obj = null;
            } else {
                matcher2 = matcher;
            }
        }
        StaticLayout staticLayout = new StaticLayout(charSequence, textView != null ? textView.getPaint() : null, textView != null ? textView.getWidth() : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        if (i < staticLayout.getLineCount()) {
            int lineEnd = staticLayout.getLineEnd(i - 1) - 13;
            if ((charSequence2 != null ? charSequence2.length() : 0) > 30 && lineEnd > 0) {
                if (lineEnd < (charSequence2 != null ? charSequence2.length() : 0)) {
                    charSequence2 = charSequence2 != null ? charSequence2.subSequence(0, lineEnd).toString() : null;
                }
            }
            spannableStringBuilder = new SpannableStringBuilder(charSequence2);
            for (UrlContent urlContent : arrayList) {
                if (urlContent.getIndexOfUrl() + urlContent.getUrl().length() < spannableStringBuilder.length()) {
                    spannableStringBuilder.setSpan(urlContent.getIconSpan(), urlContent.getIndexOfUrl(), urlContent.getIndexOfUrl() + 1, 33);
                    spannableStringBuilder.setSpan(urlContent.getClickableSpan(), urlContent.getIndexOfUrl(), urlContent.getIndexOfUrl() + urlContent.getUrl().length(), 33);
                }
            }
            spannableStringBuilder.append((CharSequence) "...");
            spannableStringBuilder.append((CharSequence) " More");
            int length = spannableStringBuilder.length() - 5;
            int length2 = spannableStringBuilder.length();
            Application a2 = Utils.a();
            Intrinsics.g(a2, "getApp(...)");
            spannableStringBuilder.setSpan(new ah.a(uf.a.c(a2)), length, length2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Utils.a().getResources().getColor(R.color.brand_new_50)), length, length2, 33);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(charSequence2);
            for (UrlContent urlContent2 : arrayList) {
                spannableStringBuilder.setSpan(urlContent2.getIconSpan(), urlContent2.getIndexOfUrl(), urlContent2.getIndexOfUrl() + 1, 33);
                spannableStringBuilder.setSpan(urlContent2.getClickableSpan(), urlContent2.getIndexOfUrl(), urlContent2.getIndexOfUrl() + urlContent2.getUrl().length(), 33);
            }
        }
        if (gVar != null) {
            gVar.a(arrayList);
        }
        if (textView != null) {
            textView.setOnTouchListener(new pj.a(spannableStringBuilder));
        }
        if (textView != null) {
            textView.setHighlightColor(androidx.core.content.b.getColor(Utils.a(), R.color.cl17));
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str) {
        Navigator.x(TheRouter.c("/web/web").K("url", str), (Context) null, (mf.c) null, 3, (Object) null);
    }

    public static final void e(TextView textView, CharSequence charSequence, Function2 function2) {
        Intrinsics.h(textView, "<this>");
        textView.setText(b(textView, charSequence, true, null, function2));
    }

    public static final void f(TextView textView, CharSequence charSequence, boolean z, Function2 function2) {
        Intrinsics.h(textView, "<this>");
        textView.setText(b(textView, charSequence, z, null, function2));
    }

    public static final void g(TextView textView, CharSequence charSequence, int i, Function2 function2) {
        Intrinsics.h(textView, "<this>");
        textView.setText(c(textView, charSequence, true, i, null, function2));
    }

    public static /* synthetic */ void h(TextView textView, CharSequence charSequence, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 10;
        }
        if ((i2 & 4) != 0) {
            function2 = null;
        }
        g(textView, charSequence, i, function2);
    }
}
