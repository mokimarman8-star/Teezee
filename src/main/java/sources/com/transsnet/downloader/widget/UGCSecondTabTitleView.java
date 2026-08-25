package com.transsnet.downloader.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import bx.g1;
import com.noober.background.view.BLView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsnet.downloader.R;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J/\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001f\u0010\u001cJ\u0015\u0010!\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J%\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n¢\u0006\u0004\b%\u0010)R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00104\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010/R\u0014\u00106\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010/¨\u00067"}, d2 = {"Lcom/transsnet/downloader/widget/UGCSecondTabTitleView;", "Landroid/widget/FrameLayout;", "Lxy/b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", HttpUrl.FRAGMENT_ENCODE_SET, "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "index", "totalCount", HttpUrl.FRAGMENT_ENCODE_SET, "onSelected", "(II)V", "onDeselected", HttpUrl.FRAGMENT_ENCODE_SET, "leavePercent", HttpUrl.FRAGMENT_ENCODE_SET, "leftToRight", "onLeave", "(IIFZ)V", "enterPercent", "onEnter", "getContentLeft", "()I", "getContentTop", "getContentRight", "getContentBottom", "show", "setDotVisibility", "(Z)V", HttpUrl.FRAGMENT_ENCODE_SET, "title", "setTitle", "(Ljava/lang/String;)V", "count", "position", "(Ljava/lang/String;II)V", "Lbx/g1;", "a", "Lbx/g1;", "viewBinding", "b", "I", "normalColor", "c", "selectedStartColor", "d", "selectedCenterColor", "e", "selectedEndColor", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class UGCSecondTabTitleView extends FrameLayout implements xy.b {

    /* renamed from: a, reason: from kotlin metadata */
    private final g1 viewBinding;

    /* renamed from: b, reason: from kotlin metadata */
    private final int normalColor;

    /* renamed from: c, reason: from kotlin metadata */
    private final int selectedStartColor;

    /* renamed from: d, reason: from kotlin metadata */
    private final int selectedCenterColor;

    /* renamed from: e, reason: from kotlin metadata */
    private final int selectedEndColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UGCSecondTabTitleView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UGCSecondTabTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCSecondTabTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        View.inflate(getContext(), R.layout.view_download_top_second_tab, this);
        g1 a = g1.a(this);
        Intrinsics.g(a, "bind(...)");
        this.viewBinding = a;
        this.normalColor = androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.white_80);
        this.selectedStartColor = androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.brand_new_gradient_start);
        this.selectedCenterColor = androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.brand_new_gradient_center);
        this.selectedEndColor = androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.brand_new_gradient_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence e(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence f(UGCSecondTabTitleView uGCSecondTabTitleView, String str) {
        return uGCSecondTabTitleView.getContext().getString(R.string.downloading_Local_files) + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence g(UGCSecondTabTitleView uGCSecondTabTitleView, String str) {
        return uGCSecondTabTitleView.getContext().getString(R.string.download_transfer_tab_received) + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence h(String str) {
        return str;
    }

    @Override // xy.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = this.viewBinding.b.getPaint().getFontMetrics();
        Intrinsics.g(fontMetrics, "getFontMetrics(...)");
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2));
    }

    @Override // xy.b
    public int getContentLeft() {
        String obj;
        List l;
        Rect rect = new Rect();
        if (StringsKt.c0(this.viewBinding.b.getText().toString(), "\n", false, 2, null)) {
            List split = new Regex("\\n").split(this.viewBinding.b.getText().toString(), 0);
            if (!split.isEmpty()) {
                ListIterator listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        l = CollectionsKt.K0(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            l = CollectionsKt.l();
            String[] strArr = (String[]) l.toArray(new String[0]);
            obj = HttpUrl.FRAGMENT_ENCODE_SET;
            for (String str : strArr) {
                if (str.length() > obj.length()) {
                    obj = str;
                }
            }
        } else {
            obj = this.viewBinding.b.getText().toString();
        }
        this.viewBinding.b.getPaint().getTextBounds(obj, 0, obj.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    @Override // xy.b
    public int getContentRight() {
        String obj;
        List l;
        Rect rect = new Rect();
        if (StringsKt.c0(this.viewBinding.b.getText().toString(), "\n", false, 2, null)) {
            List split = new Regex("\\n").split(this.viewBinding.b.getText().toString(), 0);
            if (!split.isEmpty()) {
                ListIterator listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        l = CollectionsKt.K0(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            l = CollectionsKt.l();
            String[] strArr = (String[]) l.toArray(new String[0]);
            obj = HttpUrl.FRAGMENT_ENCODE_SET;
            for (String str : strArr) {
                if (str.length() > obj.length()) {
                    obj = str;
                }
            }
        } else {
            obj = this.viewBinding.b.getText().toString();
        }
        this.viewBinding.b.getPaint().getTextBounds(obj, 0, obj.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    @Override // xy.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = this.viewBinding.b.getPaint().getFontMetrics();
        Intrinsics.g(fontMetrics, "getFontMetrics(...)");
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2));
    }

    @Override // xy.d
    public void onDeselected(int index, int totalCount) {
        GradientTextView gradientTextView = this.viewBinding.b;
        int i = this.normalColor;
        gradientTextView.setGradientColors(i, i, i);
        gradientTextView.setBackgroundResource(com.tn.lib.widget.R.color.transparent);
        Context context = gradientTextView.getContext();
        Intrinsics.g(context, "getContext(...)");
        gradientTextView.setTypeface(uf.a.d(context));
    }

    @Override // xy.d
    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
    }

    @Override // xy.d
    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
    }

    @Override // xy.d
    public void onSelected(int index, int totalCount) {
        GradientTextView gradientTextView = this.viewBinding.b;
        gradientTextView.setGradientColors(this.selectedStartColor, this.selectedCenterColor, this.selectedEndColor);
        gradientTextView.setBackgroundResource(R.drawable.bg_shape_download_tab_second_selected);
        Context context = gradientTextView.getContext();
        Intrinsics.g(context, "getContext(...)");
        gradientTextView.setTypeface(uf.a.a(context));
    }

    public final void setDotVisibility(boolean show) {
        BLView vDot = this.viewBinding.c;
        Intrinsics.g(vDot, "vDot");
        vDot.setVisibility(show ? 0 : 8);
    }

    public final void setTitle(final String title) {
        Intrinsics.h(title, "title");
        this.viewBinding.b.setTextAction(new Function0() { // from class: com.transsnet.downloader.widget.v0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                CharSequence e;
                e = UGCSecondTabTitleView.e(title);
                return e;
            }
        });
    }

    public final void setTitle(final String title, int count, int position) {
        final String str;
        Intrinsics.h(title, "title");
        if (count > 0) {
            str = " " + count;
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (position == 1) {
            this.viewBinding.b.setTextAction(new Function0() { // from class: com.transsnet.downloader.widget.w0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CharSequence f;
                    f = UGCSecondTabTitleView.f(UGCSecondTabTitleView.this, str);
                    return f;
                }
            });
        } else if (position != 2) {
            this.viewBinding.b.setTextAction(new Function0() { // from class: com.transsnet.downloader.widget.y0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CharSequence h;
                    h = UGCSecondTabTitleView.h(title);
                    return h;
                }
            });
        } else {
            this.viewBinding.b.setTextAction(new Function0() { // from class: com.transsnet.downloader.widget.x0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CharSequence g;
                    g = UGCSecondTabTitleView.g(UGCSecondTabTitleView.this, str);
                    return g;
                }
            });
        }
    }
}
