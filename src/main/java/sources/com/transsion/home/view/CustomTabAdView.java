package com.transsion.home.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import ci.q;
import com.blankj.utilcode.util.a0;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.bean.NameImage;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J/\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\u0010H\u0016¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\u0010H\u0016¢\u0006\u0004\b!\u0010\u001eJ\u0017\u0010\"\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\"\u0010\u000fJ\u001d\u0010%\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010¢\u0006\u0004\b%\u0010\u0014J\u0015\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0010¢\u0006\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.R\u001b\u00104\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u00102\u001a\u0004\b3\u0010\u001eR\u001b\u00107\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00102\u001a\u0004\b6\u0010\u001e¨\u00068"}, d2 = {"Lcom/transsion/home/view/CustomTabAdView;", "Landroid/widget/FrameLayout;", "Lxy/b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/transsion/home/bean/HomeTabItem;", "homeTabItem", "Landroidx/appcompat/widget/AppCompatImageView;", "imageView", BuildConfig.FLAVOR, "d", "(Lcom/transsion/home/bean/HomeTabItem;Landroidx/appcompat/widget/AppCompatImageView;)V", "g", "(Lcom/transsion/home/bean/HomeTabItem;)V", BuildConfig.FLAVOR, "p0", "p1", "onSelected", "(II)V", "onDeselected", BuildConfig.FLAVOR, "p2", BuildConfig.FLAVOR, "p3", "onEnter", "(IIFZ)V", "onLeave", "getContentLeft", "()I", "getContentTop", "getContentRight", "getContentBottom", "showData", "normalColor", "selectedColor", "changeTextColor", "textColor", "setTextColor", "(I)V", "Landroidx/appcompat/widget/AppCompatTextView;", "a", "Landroidx/appcompat/widget/AppCompatTextView;", "textView", "b", "I", "mSelectedColor", "c", "mNormalColor", "Lkotlin/Lazy;", "getMLeftPadding", "mLeftPadding", "e", "getMRightPadding", "mRightPadding", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CustomTabAdView extends FrameLayout implements xy.b {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private AppCompatTextView textView;

    /* renamed from: b, reason: from kotlin metadata */
    private int mSelectedColor;

    /* renamed from: c, reason: from kotlin metadata */
    private int mNormalColor;

    /* renamed from: d, reason: from kotlin metadata */
    private final Lazy mLeftPadding;

    /* renamed from: e, reason: from kotlin metadata */
    private final Lazy mRightPadding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabAdView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.mSelectedColor = androidx.core.content.b.getColor(context, R.color.text_01);
        this.mNormalColor = androidx.core.content.b.getColor(context, R.color.text_02);
        this.mLeftPadding = LazyKt.b(new Function0() { // from class: com.transsion.home.view.a
            public final Object invoke() {
                int e;
                e = CustomTabAdView.e();
                return Integer.valueOf(e);
            }
        });
        this.mRightPadding = LazyKt.b(new Function0() { // from class: com.transsion.home.view.b
            public final Object invoke() {
                int f;
                f = CustomTabAdView.f();
                return Integer.valueOf(f);
            }
        });
    }

    private final void d(HomeTabItem homeTabItem, AppCompatImageView imageView) {
        NameImage nameImage;
        Integer width;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((homeTabItem == null || (nameImage = homeTabItem.getNameImage()) == null || (width = nameImage.getWidth()) == null) ? -2 : a0.a(width.intValue()), a0.a(22.0f));
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = 20;
        layoutParams.topMargin = 20;
        removeAllViews();
        q.a.a(imageView);
        addView((View) imageView, (ViewGroup.LayoutParams) layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e() {
        return a0.a(12.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f() {
        return a0.a(10.0f);
    }

    private final void g(HomeTabItem homeTabItem) {
        removeAllViews();
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.textView = appCompatTextView;
        appCompatTextView.setText(homeTabItem != null ? homeTabItem.getName() : null);
        appCompatTextView.setTextSize(14.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        appCompatTextView.setPadding(getMLeftPadding(), 0, getMRightPadding(), 0);
        appCompatTextView.setGravity(17);
        layoutParams.gravity = 17;
        addView((View) appCompatTextView, (ViewGroup.LayoutParams) layoutParams);
    }

    private final int getMLeftPadding() {
        return ((Number) this.mLeftPadding.getValue()).intValue();
    }

    private final int getMRightPadding() {
        return ((Number) this.mRightPadding.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(CustomTabAdView customTabAdView, AppCompatImageView appCompatImageView, HomeTabItem homeTabItem, boolean z, boolean z2, long j) {
        if (!z) {
            customTabAdView.removeView(appCompatImageView);
            customTabAdView.g(homeTabItem);
        }
        return Unit.a;
    }

    public final void changeTextColor(int normalColor, int selectedColor) {
        this.mNormalColor = normalColor;
        this.mSelectedColor = selectedColor;
    }

    public int getContentBottom() {
        return 0;
    }

    public int getContentLeft() {
        return 0;
    }

    public int getContentRight() {
        return 0;
    }

    public int getContentTop() {
        return 0;
    }

    public void onDeselected(int p0, int p1) {
        TextPaint paint;
        AppCompatTextView appCompatTextView = this.textView;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(this.mNormalColor);
        }
        AppCompatTextView appCompatTextView2 = this.textView;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setTextSize(14.0f);
        }
        AppCompatTextView appCompatTextView3 = this.textView;
        if (appCompatTextView3 != null && (paint = appCompatTextView3.getPaint()) != null) {
            paint.setFakeBoldText(false);
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            paint.setTypeface(uf.a.d(context));
        }
        AppCompatTextView appCompatTextView4 = this.textView;
        if (appCompatTextView4 != null) {
            appCompatTextView4.setPadding(getMLeftPadding(), 0, getMRightPadding(), 0);
        }
    }

    public void onEnter(int p0, int p1, float p2, boolean p3) {
        TextPaint paint;
        AppCompatTextView appCompatTextView = this.textView;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(this.mSelectedColor);
        }
        AppCompatTextView appCompatTextView2 = this.textView;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setTextSize(16.0f);
        }
        AppCompatTextView appCompatTextView3 = this.textView;
        if (appCompatTextView3 == null || (paint = appCompatTextView3.getPaint()) == null) {
            return;
        }
        paint.setFakeBoldText(true);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
    }

    public void onLeave(int p0, int p1, float p2, boolean p3) {
        TextPaint paint;
        AppCompatTextView appCompatTextView = this.textView;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(this.mNormalColor);
        }
        AppCompatTextView appCompatTextView2 = this.textView;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setTextSize(16.0f);
        }
        AppCompatTextView appCompatTextView3 = this.textView;
        if (appCompatTextView3 == null || (paint = appCompatTextView3.getPaint()) == null) {
            return;
        }
        paint.setFakeBoldText(false);
        paint.setTypeface(Typeface.DEFAULT);
    }

    public void onSelected(int p0, int p1) {
        TextPaint paint;
        AppCompatTextView appCompatTextView = this.textView;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(this.mSelectedColor);
        }
        AppCompatTextView appCompatTextView2 = this.textView;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setTextSize(16.0f);
        }
        AppCompatTextView appCompatTextView3 = this.textView;
        if (appCompatTextView3 != null && (paint = appCompatTextView3.getPaint()) != null) {
            paint.setFakeBoldText(true);
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            paint.setTypeface(uf.a.a(context));
        }
        AppCompatTextView appCompatTextView4 = this.textView;
        if (appCompatTextView4 != null) {
            appCompatTextView4.setPadding(getMLeftPadding() - 2, 0, getMRightPadding() - 2, 0);
        }
    }

    public final void setTextColor(int textColor) {
        AppCompatTextView appCompatTextView = this.textView;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(textColor);
        }
    }

    public final void showData(final HomeTabItem homeTabItem) {
        NameImage nameImage;
        String url;
        StringBuilder sb = new StringBuilder();
        sb.append("CustomTabAdView --> showData() --> homeTabItem = ");
        sb.append(homeTabItem);
        sb.append(" ");
        final ImageView appCompatImageView = new AppCompatImageView(getContext());
        d(homeTabItem, appCompatImageView);
        if (homeTabItem == null || (nameImage = homeTabItem.getNameImage()) == null || (url = nameImage.getUrl()) == null) {
            return;
        }
        f.a aVar = ni.f.a;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        aVar.m(context).g(url).i(R.color.transparent).b(new Function3() { // from class: com.transsion.home.view.c
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit h;
                h = CustomTabAdView.h(CustomTabAdView.this, appCompatImageView, homeTabItem, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Long) obj3).longValue());
                return h;
            }
        }).d(appCompatImageView);
    }
}
