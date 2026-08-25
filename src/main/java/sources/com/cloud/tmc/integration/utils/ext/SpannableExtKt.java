package com.cloud.tmc.integration.utils.ext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BulletSpan;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.QuoteSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.view.View;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.params.TmcStartParams;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0003\u001a\u00020\u00042\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\u0010\r\u001a)\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001a)\u0010\u0012\u001a\u00020\u000f*\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001a1\u0010\u0013\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001a\u001a\u0010\u0015\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u001a\u001c\u0010\u0015\u001a\u00020\u000f*\u00020\u000f2\b\b\u0001\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019\u001a.\u0010\u001f\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u001a:\u0010\u001f\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u001aC\u0010\u001f\u001a\u00020\u000f*\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\u0010\"\u001a0\u0010\u001f\u001a\u00020\u000f*\u00020\u000f2\b\b\u0001\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u001a\u001e\u0010#\u001a\u00020\u000f*\u00020\u000f2\b\b\u0001\u0010$\u001a\u00020%2\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u001a\u001e\u0010#\u001a\u00020\u000f*\u00020\u000f2\b\b\u0001\u0010$\u001a\u00020\u00062\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u001a;\u0010&\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010'\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020)2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001aB\u0010*\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010+\u001a\u00020%2\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010,\u001aD\u0010*\u001a\u00020\u000f*\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u00062\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010-\u001a3\u0010.\u001a\u00020\u000f*\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010\u00012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001a;\u00100\u001a\u00020\u000f*\u00020\u000f2\u0006\u00101\u001a\u00020%2\b\b\u0002\u00102\u001a\u00020%2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001a;\u00100\u001a\u00020\u000f*\u00020\u000f2\u0006\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u00062\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001a1\u00103\u001a\u00020\u000f*\u00020\u000f2\u0006\u00104\u001a\u0002052\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001a:\u00106\u001a\u00020\u000f*\u00020\u000f2\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000¢\u0006\u0002\u00107\u001a$\u00108\u001a\u0004\u0018\u00010\f*\u0002092\u0006\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020<H\u0086\u0002¢\u0006\u0002\u0010=\u001a*\u00108\u001a\u0004\u0018\u00010\f*\u0002092\u0006\u0010:\u001a\u00020\u00012\f\u0010>\u001a\b\u0012\u0004\u0012\u00020<0?H\u0086\u0002¢\u0006\u0002\u0010@\u001a1\u0010$\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010$\u001a\u00020%2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001a1\u0010$\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010$\u001a\u00020\u00062\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001a1\u0010A\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010A\u001a\u00020B2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001a1\u0010C\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010C\u001a\u00020\u00012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006D"}, d2 = {"IMAGE_SPAN_TEXT", "", "SPACE_SPAN_TEXT", "ClickableSpan", "Landroid/text/style/ClickableSpan;", "color", "", "isUnderlineText", "", "onClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "(Ljava/lang/Integer;ZLkotlin/jvm/functions/Function1;)Landroid/text/style/ClickableSpan;", "alignCenter", "Landroid/text/SpannableStringBuilder;", "builderAction", "Lkotlin/ExtensionFunctionType;", "alignOpposite", "alignment", "Landroid/text/Layout$Alignment;", "append", "bitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "drawable", "Landroid/graphics/drawable/Drawable;", "width", "height", "resourceId", "appendClickable", "text", "", "(Landroid/text/SpannableStringBuilder;Ljava/lang/CharSequence;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "appendSpace", "size", "", "blur", "radius", "style", "Landroid/graphics/BlurMaskFilter$Blur;", "bullet", "gapWidth", "(Landroid/text/SpannableStringBuilder;FLjava/lang/Integer;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "(Landroid/text/SpannableStringBuilder;ILjava/lang/Integer;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "fontFamily", "family", "leadingMargin", "first", "rest", "maskFilter", "filter", "Landroid/graphics/MaskFilter;", "quote", "(Landroid/text/SpannableStringBuilder;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "set", "Landroid/text/Spannable;", "string", "span", "", "(Landroid/text/Spannable;Ljava/lang/String;Ljava/lang/Object;)Lkotlin/Unit;", "spans", "", "(Landroid/text/Spannable;Ljava/lang/String;Ljava/util/List;)Lkotlin/Unit;", "typeface", "Landroid/graphics/Typeface;", TmcStartParams.KEY_URL, BuildConfig.LIBRARY_PACKAGE_NAME}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class SpannableExtKt {
    private static final String IMAGE_SPAN_TEXT = "<img/>";
    private static final String SPACE_SPAN_TEXT = "<space/>";

    public static final ClickableSpan ClickableSpan(final Integer num, final boolean z, final Function1<? super View, Unit> function1) {
        Intrinsics.h(function1, "onClick");
        return new ClickableSpan() { // from class: com.cloud.tmc.integration.utils.ext.SpannableExtKt$ClickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.h(widget, "widget");
                function1.invoke(widget);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.h(ds, "ds");
                Integer num2 = num;
                ds.setColor(num2 != null ? num2.intValue() : ds.linkColor);
                ds.setUnderlineText(z);
            }
        };
    }

    public static /* synthetic */ ClickableSpan ClickableSpan$default(Integer num, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return ClickableSpan(num, z, function1);
    }

    public static final SpannableStringBuilder alignCenter(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        AlignmentSpan.Standard standard = new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(standard, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder alignOpposite(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        AlignmentSpan.Standard standard = new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(standard, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder alignment(SpannableStringBuilder spannableStringBuilder, Layout.Alignment alignment, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(alignment, "alignment");
        Intrinsics.h(function1, "builderAction");
        AlignmentSpan.Standard standard = new AlignmentSpan.Standard(alignment);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(standard, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder append(SpannableStringBuilder spannableStringBuilder, int i, Context context) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(context, "context");
        ImageSpan imageSpan = new ImageSpan(context, i);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(IMAGE_SPAN_TEXT);
        spannableStringBuilder.setSpan(imageSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder append(SpannableStringBuilder spannableStringBuilder, Bitmap bitmap, Context context) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(bitmap, "bitmap");
        Intrinsics.h(context, "context");
        ImageSpan imageSpan = new ImageSpan(context, bitmap);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(IMAGE_SPAN_TEXT);
        spannableStringBuilder.setSpan(imageSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder append(SpannableStringBuilder spannableStringBuilder, Drawable drawable, int i, int i2) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(drawable, "drawable");
        drawable.setBounds(0, 0, i, i2);
        ImageSpan imageSpan = new ImageSpan(drawable);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(IMAGE_SPAN_TEXT);
        spannableStringBuilder.setSpan(imageSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static /* synthetic */ SpannableStringBuilder append$default(SpannableStringBuilder spannableStringBuilder, Drawable drawable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i3 & 4) != 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        return append(spannableStringBuilder, drawable, i, i2);
    }

    public static final SpannableStringBuilder appendClickable(SpannableStringBuilder spannableStringBuilder, int i, Context context, Function1<? super View, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(context, "context");
        Intrinsics.h(function1, "onClick");
        ClickableSpan ClickableSpan$default = ClickableSpan$default(null, false, function1, 3, null);
        int length = spannableStringBuilder.length();
        append(spannableStringBuilder, i, context);
        spannableStringBuilder.setSpan(ClickableSpan$default, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder appendClickable(SpannableStringBuilder spannableStringBuilder, Bitmap bitmap, Context context, Function1<? super View, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(bitmap, "bitmap");
        Intrinsics.h(context, "context");
        Intrinsics.h(function1, "onClick");
        ClickableSpan ClickableSpan$default = ClickableSpan$default(null, false, function1, 3, null);
        int length = spannableStringBuilder.length();
        append(spannableStringBuilder, bitmap, context);
        spannableStringBuilder.setSpan(ClickableSpan$default, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder appendClickable(SpannableStringBuilder spannableStringBuilder, Drawable drawable, int i, int i2, Function1<? super View, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(drawable, "drawable");
        Intrinsics.h(function1, "onClick");
        ClickableSpan ClickableSpan$default = ClickableSpan$default(null, false, function1, 3, null);
        int length = spannableStringBuilder.length();
        append(spannableStringBuilder, drawable, i, i2);
        spannableStringBuilder.setSpan(ClickableSpan$default, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder appendClickable(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, Integer num, boolean z, Function1<? super View, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "onClick");
        ClickableSpan ClickableSpan = ClickableSpan(num, z, function1);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(ClickableSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static /* synthetic */ SpannableStringBuilder appendClickable$default(SpannableStringBuilder spannableStringBuilder, Drawable drawable, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i3 & 4) != 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        return appendClickable(spannableStringBuilder, drawable, i, i2, (Function1<? super View, Unit>) function1);
    }

    public static /* synthetic */ SpannableStringBuilder appendClickable$default(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, Integer num, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return appendClickable(spannableStringBuilder, charSequence, num, z, (Function1<? super View, Unit>) function1);
    }

    public static final SpannableStringBuilder appendSpace(SpannableStringBuilder spannableStringBuilder, float f, int i) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        return appendSpace(spannableStringBuilder, (int) f, i);
    }

    public static final SpannableStringBuilder appendSpace(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        SpaceSpan spaceSpan = new SpaceSpan(i, i2);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(SPACE_SPAN_TEXT);
        spannableStringBuilder.setSpan(spaceSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static /* synthetic */ SpannableStringBuilder appendSpace$default(SpannableStringBuilder spannableStringBuilder, float f, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return appendSpace(spannableStringBuilder, f, i);
    }

    public static /* synthetic */ SpannableStringBuilder appendSpace$default(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return appendSpace(spannableStringBuilder, i, i2);
    }

    public static final SpannableStringBuilder blur(SpannableStringBuilder spannableStringBuilder, float f, BlurMaskFilter.Blur blur, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(blur, "style");
        Intrinsics.h(function1, "builderAction");
        MaskFilterSpan maskFilterSpan = new MaskFilterSpan(new BlurMaskFilter(f, blur));
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(maskFilterSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static /* synthetic */ SpannableStringBuilder blur$default(SpannableStringBuilder spannableStringBuilder, float f, BlurMaskFilter.Blur blur, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            blur = BlurMaskFilter.Blur.NORMAL;
        }
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(blur, "style");
        Intrinsics.h(function1, "builderAction");
        MaskFilterSpan maskFilterSpan = new MaskFilterSpan(new BlurMaskFilter(f, blur));
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(maskFilterSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder bullet(SpannableStringBuilder spannableStringBuilder, float f, Integer num, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        int i = (int) f;
        BulletSpan bulletSpan = num == null ? new BulletSpan(i) : new BulletSpan(i, num.intValue());
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(bulletSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder bullet(SpannableStringBuilder spannableStringBuilder, int i, Integer num, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        BulletSpan bulletSpan = num == null ? new BulletSpan(i) : new BulletSpan(i, num.intValue());
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(bulletSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static /* synthetic */ SpannableStringBuilder bullet$default(SpannableStringBuilder spannableStringBuilder, float f, Integer num, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        int i2 = (int) f;
        BulletSpan bulletSpan = num == null ? new BulletSpan(i2) : new BulletSpan(i2, num.intValue());
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(bulletSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static /* synthetic */ SpannableStringBuilder bullet$default(SpannableStringBuilder spannableStringBuilder, int i, Integer num, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        if ((i2 & 2) != 0) {
            num = null;
        }
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        BulletSpan bulletSpan = num == null ? new BulletSpan(i) : new BulletSpan(i, num.intValue());
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(bulletSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder fontFamily(SpannableStringBuilder spannableStringBuilder, String str, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        TypefaceSpan typefaceSpan = new TypefaceSpan(str);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(typefaceSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder leadingMargin(SpannableStringBuilder spannableStringBuilder, float f, float f2, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        LeadingMarginSpan.Standard standard = new LeadingMarginSpan.Standard((int) f, (int) f2);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(standard, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder leadingMargin(SpannableStringBuilder spannableStringBuilder, int i, int i2, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        LeadingMarginSpan.Standard standard = new LeadingMarginSpan.Standard(i, i2);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(standard, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static /* synthetic */ SpannableStringBuilder leadingMargin$default(SpannableStringBuilder spannableStringBuilder, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        LeadingMarginSpan.Standard standard = new LeadingMarginSpan.Standard((int) f, (int) f2);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(standard, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static /* synthetic */ SpannableStringBuilder leadingMargin$default(SpannableStringBuilder spannableStringBuilder, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        LeadingMarginSpan.Standard standard = new LeadingMarginSpan.Standard(i, i2);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(standard, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder maskFilter(SpannableStringBuilder spannableStringBuilder, MaskFilter maskFilter, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(maskFilter, "filter");
        Intrinsics.h(function1, "builderAction");
        MaskFilterSpan maskFilterSpan = new MaskFilterSpan(maskFilter);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(maskFilterSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder quote(SpannableStringBuilder spannableStringBuilder, Integer num, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        QuoteSpan quoteSpan = num == null ? new QuoteSpan() : new QuoteSpan(num.intValue());
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(quoteSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static /* synthetic */ SpannableStringBuilder quote$default(SpannableStringBuilder spannableStringBuilder, Integer num, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        QuoteSpan quoteSpan = num == null ? new QuoteSpan() : new QuoteSpan(num.intValue());
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(quoteSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final Unit set(Spannable spannable, String str, Object obj) {
        Intrinsics.h(spannable, "<this>");
        Intrinsics.h(str, "string");
        Intrinsics.h(obj, "span");
        Integer valueOf = Integer.valueOf(StringsKt.o0(spannable.toString(), str, 0, false, 6, (Object) null));
        if (valueOf.intValue() == -1) {
            valueOf = null;
        }
        if (valueOf == null) {
            return null;
        }
        int intValue = valueOf.intValue();
        spannable.setSpan(obj, intValue, str.length() + intValue, 17);
        return Unit.a;
    }

    public static final Unit set(Spannable spannable, String str, List<? extends Object> list) {
        Intrinsics.h(spannable, "<this>");
        Intrinsics.h(str, "string");
        Intrinsics.h(list, "spans");
        Integer valueOf = Integer.valueOf(StringsKt.o0(spannable.toString(), str, 0, false, 6, (Object) null));
        if (valueOf.intValue() == -1) {
            valueOf = null;
        }
        if (valueOf == null) {
            return null;
        }
        int intValue = valueOf.intValue();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            spannable.setSpan(it.next(), intValue, str.length() + intValue, 17);
        }
        return Unit.a;
    }

    public static final SpannableStringBuilder size(SpannableStringBuilder spannableStringBuilder, float f, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan((int) f);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(absoluteSizeSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder size(SpannableStringBuilder spannableStringBuilder, int i, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(function1, "builderAction");
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(i);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(absoluteSizeSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder typeface(SpannableStringBuilder spannableStringBuilder, Typeface typeface, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(typeface, "typeface");
        Intrinsics.h(function1, "builderAction");
        TypefaceSpanCompat typefaceSpanCompat = new TypefaceSpanCompat(typeface);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(typefaceSpanCompat, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder url(SpannableStringBuilder spannableStringBuilder, String str, Function1<? super SpannableStringBuilder, Unit> function1) {
        Intrinsics.h(spannableStringBuilder, "<this>");
        Intrinsics.h(str, TmcStartParams.KEY_URL);
        Intrinsics.h(function1, "builderAction");
        URLSpan uRLSpan = new URLSpan(str);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(uRLSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}
