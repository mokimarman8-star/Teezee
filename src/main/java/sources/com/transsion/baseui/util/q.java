package com.transsion.baseui.util;

import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.transsion.baseui.R;
import com.transsion.baseui.util.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class q {

    public static final class a extends ViewOutlineProvider {
        final /* synthetic */ float a;

        a(float f) {
            this.a = f;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.h(view, "view");
            Intrinsics.h(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
        }
    }

    private static final void b(SpannableStringBuilder spannableStringBuilder, Context context, int i) {
        spannableStringBuilder.append("￼");
        spannableStringBuilder.setSpan(d(context, i), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
    }

    public static final void c(View view, float f) {
        Intrinsics.h(view, "<this>");
        view.setOutlineProvider(new a(f));
        view.setClipToOutline(true);
    }

    private static final ImageSpan d(Context context, int i) {
        return Build.VERSION.SDK_INT >= 29 ? new ImageSpan(context, i, 2) : new ImageSpan(context, i, 1);
    }

    public static final SpannableStringBuilder e(List list, Context context) {
        Intrinsics.h(list, "array");
        Intrinsics.h(context, "context");
        CollectionsKt.I(list, new Function1() { // from class: com.transsion.baseui.util.p
            public final Object invoke(Object obj) {
                boolean h;
                h = q.h((String) obj);
                return Boolean.valueOf(h);
            }
        });
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            String str = (String) obj;
            if (Intrinsics.c(str, "special_#shorts_icon")) {
                b(spannableStringBuilder, context, R.drawable.ic_tag_ugc_shorts);
                spannableStringBuilder.append((CharSequence) " ");
            } else if (Intrinsics.c(str, "special_#user_icon")) {
                b(spannableStringBuilder, context, R.drawable.ic_ugc_creator);
                spannableStringBuilder.append((CharSequence) " ");
            } else if (StringsKt.W(str, "dynamic_icon_#", false, 2, (Object) null)) {
                Integer v = StringsKt.v(StringsKt.I0(str, "dynamic_icon_#"));
                if (v != null) {
                    b(spannableStringBuilder, context, v.intValue());
                    spannableStringBuilder.append((CharSequence) " ");
                }
            } else {
                spannableStringBuilder.append((CharSequence) str);
                if (i < list.size() - 1) {
                    b(spannableStringBuilder, context, R.mipmap.ic_subtitle_split);
                }
            }
            i = i2;
        }
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder f(List list, Context context, boolean z) {
        Intrinsics.h(list, "items");
        Intrinsics.h(context, "context");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            k kVar = (k) obj;
            if (!(kVar instanceof k.b) || ((k.b) kVar).a().length() > 0) {
                arrayList.add(obj);
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i = 0;
        for (Object obj2 : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            k kVar2 = (k) obj2;
            if (kVar2 instanceof k.a) {
                b(spannableStringBuilder, context, ((k.a) kVar2).a());
                if (z) {
                    spannableStringBuilder.append((CharSequence) " ");
                }
            } else {
                if (!(kVar2 instanceof k.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                int length = spannableStringBuilder.length();
                k.b bVar = (k.b) kVar2;
                spannableStringBuilder.append((CharSequence) bVar.a());
                Integer b = bVar.b();
                if (b != null) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(androidx.core.content.b.getColor(context, b.intValue())), length, spannableStringBuilder.length(), 33);
                }
                if (i < arrayList.size() - 1) {
                    b(spannableStringBuilder, context, R.mipmap.ic_subtitle_split);
                }
            }
            i = i2;
        }
        return spannableStringBuilder;
    }

    public static /* synthetic */ SpannableStringBuilder g(List list, Context context, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return f(list, context, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(String str) {
        Intrinsics.h(str, "it");
        return str.length() == 0;
    }
}
