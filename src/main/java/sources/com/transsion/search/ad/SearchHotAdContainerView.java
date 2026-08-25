package com.transsion.search.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vp.o;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\fR\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/transsion/search/ad/SearchHotAdContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "h", "()V", "i", BuildConfig.FLAVOR, "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "getHiNativeAdViews", "()Ljava/util/List;", "getNativeWrapperAdView", "()Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", PushConstants.PROVIDER_FIELD_DESTROY, BuildConfig.FLAVOR, "a", "Ljava/util/List;", "hiNativeAdViews", "b", "Lcom/transsion/ad/view/native_ad/NativeWrapperAdView;", "nativeWrapperAdView", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchHotAdContainerView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private List hiNativeAdViews;

    /* renamed from: b, reason: from kotlin metadata */
    private NativeWrapperAdView nativeWrapperAdView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchHotAdContainerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchHotAdContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SearchHotAdContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
    }

    public /* synthetic */ SearchHotAdContainerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h() {
        removeAllViews();
        this.hiNativeAdViews = new ArrayList();
        o c = o.c(LayoutInflater.from(getContext()), this, true);
        Intrinsics.g(c, "inflate(...)");
        List list = this.hiNativeAdViews;
        if (list != null) {
            NativeWrapperAdView nativeWrapperAdView = c.c;
            Intrinsics.g(nativeWrapperAdView, "nativeAdView1");
            list.add(nativeWrapperAdView);
        }
        List list2 = this.hiNativeAdViews;
        if (list2 != null) {
            NativeWrapperAdView nativeWrapperAdView2 = c.d;
            Intrinsics.g(nativeWrapperAdView2, "nativeAdView2");
            list2.add(nativeWrapperAdView2);
        }
        List list3 = this.hiNativeAdViews;
        if (list3 != null) {
            NativeWrapperAdView nativeWrapperAdView3 = c.e;
            Intrinsics.g(nativeWrapperAdView3, "nativeAdView3");
            list3.add(nativeWrapperAdView3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void i() {
        removeAllViews();
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        NativeWrapperAdView nativeWrapperAdView = new NativeWrapperAdView(context, null, 2, null);
        nativeWrapperAdView.setId(View.generateViewId());
        this.nativeWrapperAdView = nativeWrapperAdView;
        ViewGroup.LayoutParams bVar = new ConstraintLayout.b(-1, -2);
        ((ConstraintLayout.b) bVar).t = 0;
        ((ConstraintLayout.b) bVar).v = 0;
        ((ConstraintLayout.b) bVar).i = 0;
        ((ConstraintLayout.b) bVar).l = 0;
        NativeWrapperAdView nativeWrapperAdView2 = this.nativeWrapperAdView;
        if (nativeWrapperAdView2 != null) {
            nativeWrapperAdView2.setLayoutParams(bVar);
        }
        addView(this.nativeWrapperAdView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void destroy() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        removeAllViews();
        List list = this.hiNativeAdViews;
        if (list != null) {
            list.clear();
        }
        this.nativeWrapperAdView = null;
    }

    public final List<NativeWrapperAdView> getHiNativeAdViews() {
        List list = this.hiNativeAdViews;
        if (list == null || list.isEmpty()) {
            h();
        }
        return this.hiNativeAdViews;
    }

    public final NativeWrapperAdView getNativeWrapperAdView() {
        if (this.nativeWrapperAdView == null) {
            i();
        }
        return this.nativeWrapperAdView;
    }
}
