package com.transsion.home.fragment.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.a0;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.HomePreferencesContentItem;
import com.transsion.home.bean.HomePreferencesSelectType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 `2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010#\u001a\u00020\u0014*\u00020\u001f2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0014H\u0002¢\u0006\u0004\b%\u0010\u0003J\u0017\u0010'\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0017H\u0002¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0012¢\u0006\u0004\b*\u0010+J\u0019\u0010.\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/J!\u00100\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b0\u00101R\u0018\u0010)\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u0004048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R*\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R6\u0010G\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0004\u0012\u00020\u0014\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010P\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010MR\u0014\u0010R\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010MR\u0014\u0010T\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010MR\u0014\u0010V\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010MR\u0014\u0010X\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010MR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^¨\u0006b"}, d2 = {"Lcom/transsion/home/fragment/dialog/HomePreferencesDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "v0", "(Ljava/lang/String;)F", BuildConfig.FLAVOR, "Lcom/transsion/home/bean/HomePreferencesContentItem;", "items", BuildConfig.FLAVOR, "rowCount", "u0", "(Ljava/util/List;I)Ljava/util/List;", "Landroid/view/View;", "view", "Lcom/transsion/home/bean/HomePreferencesConfig;", "cfg", BuildConfig.FLAVOR, "r0", "(Landroid/view/View;Lcom/transsion/home/bean/HomePreferencesConfig;)V", "Landroid/view/ViewGroup;", "parent", "item", BuildConfig.FLAVOR, "isSingle", "Landroid/widget/LinearLayout;", "s0", "(Landroid/view/ViewGroup;Lcom/transsion/home/bean/HomePreferencesContentItem;Z)Landroid/widget/LinearLayout;", "Lcom/transsion/baseui/widget/GradientTextView;", "Landroid/content/Context;", "context", "selected", "q0", "(Lcom/transsion/baseui/widget/GradientTextView;Landroid/content/Context;Z)V", "C0", "container", "y0", "(Landroid/view/ViewGroup;)V", "config", "z0", "(Lcom/transsion/home/bean/HomePreferencesConfig;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "c", "Lcom/transsion/home/bean/HomePreferencesConfig;", BuildConfig.FLAVOR, "d", "Ljava/util/Set;", "selectedIds", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "getOnClose", "()Lkotlin/jvm/functions/Function0;", "A0", "(Lkotlin/jvm/functions/Function0;)V", "onClose", "Lkotlin/Function1;", "f", "Lkotlin/jvm/functions/Function1;", "getOnConfirm", "()Lkotlin/jvm/functions/Function1;", "B0", "(Lkotlin/jvm/functions/Function1;)V", "onConfirm", "Landroid/widget/TextView;", "g", "Landroid/widget/TextView;", "confirmButton", "h", "I", "tagHorizontalPadding", "i", "tagHeight", "j", "tagMinWidth", "k", "tagGap", "l", "iconSize", "m", "iconGap", "Landroid/text/TextPaint;", "n", "Landroid/text/TextPaint;", "measurePaint", "o", "Landroid/widget/LinearLayout;", "rowsContainer", "p", "a", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class HomePreferencesDialog extends BaseDialog {

    /* renamed from: p, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int q = 8;

    /* renamed from: c, reason: from kotlin metadata */
    private HomePreferencesConfig config;

    /* renamed from: d, reason: from kotlin metadata */
    private final Set selectedIds;

    /* renamed from: e, reason: from kotlin metadata */
    private Function0 onClose;

    /* renamed from: f, reason: from kotlin metadata */
    private Function1 onConfirm;

    /* renamed from: g, reason: from kotlin metadata */
    private TextView confirmButton;

    /* renamed from: h, reason: from kotlin metadata */
    private final int tagHorizontalPadding;

    /* renamed from: i, reason: from kotlin metadata */
    private final int tagHeight;

    /* renamed from: j, reason: from kotlin metadata */
    private final int tagMinWidth;

    /* renamed from: k, reason: from kotlin metadata */
    private final int tagGap;

    /* renamed from: l, reason: from kotlin metadata */
    private final int iconSize;

    /* renamed from: m, reason: from kotlin metadata */
    private final int iconGap;

    /* renamed from: n, reason: from kotlin metadata */
    private final TextPaint measurePaint;

    /* renamed from: o, reason: from kotlin metadata */
    private LinearLayout rowsContainer;

    /* renamed from: com.transsion.home.fragment.dialog.HomePreferencesDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HomePreferencesDialog a() {
            return new HomePreferencesDialog();
        }
    }

    public HomePreferencesDialog() {
        super(R.layout.dialog_home_preferences);
        this.selectedIds = new LinkedHashSet();
        this.tagHorizontalPadding = a0.a(12.0f);
        this.tagHeight = a0.a(32.0f);
        this.tagMinWidth = a0.a(68.0f);
        this.tagGap = a0.a(8.0f);
        this.iconSize = a0.a(16.0f);
        this.iconGap = a0.a(4.0f);
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(a0.a(12.0f));
        this.measurePaint = textPaint;
    }

    private final void C0() {
        TextView textView = this.confirmButton;
        if (textView != null) {
            textView.setAlpha(this.selectedIds.isEmpty() ? 0.5f : 1.0f);
        }
    }

    private final void q0(GradientTextView gradientTextView, Context context, boolean z) {
        int color = androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.white_80);
        int color2 = androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.brand_new_gradient_start);
        int color3 = androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.brand_new_gradient_center);
        int color4 = androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.brand_new_gradient_end);
        if (!z) {
            color2 = color;
        }
        if (!z) {
            color3 = color;
        }
        if (z) {
            color = color4;
        }
        gradientTextView.setGradientColors(color2, color3, color);
    }

    private final void r0(View view, HomePreferencesConfig cfg) {
        List options = cfg.getOptions();
        if (options.isEmpty()) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.llRowsContainer);
        this.rowsContainer = linearLayout;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        List u0 = u0(options, options.size() <= 8 ? 1 : (int) Math.ceil(options.size() / 8));
        boolean c = Intrinsics.c(cfg.getSelectType(), HomePreferencesSelectType.SINGLE.getValue());
        int i = 0;
        for (Object obj : u0) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            List list = (List) obj;
            LinearLayout linearLayout2 = new LinearLayout(view.getContext());
            linearLayout2.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i > 0) {
                layoutParams.topMargin = this.tagGap;
            }
            linearLayout2.setLayoutParams(layoutParams);
            int a = a0.a(8.0f);
            int i3 = 0;
            for (Object obj2 : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.u();
                }
                LinearLayout s0 = s0(linearLayout2, (HomePreferencesContentItem) obj2, c);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, this.tagHeight);
                layoutParams2.setMarginStart(i3 == 0 ? a : this.tagGap);
                linearLayout2.addView(s0, layoutParams2);
                i3 = i4;
            }
            LinearLayout linearLayout3 = this.rowsContainer;
            if (linearLayout3 != null) {
                linearLayout3.addView(linearLayout2);
            }
            i = i2;
        }
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.hsvTags);
        if (horizontalScrollView != null) {
            horizontalScrollView.scrollTo(0, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.view.View, android.widget.TextView, com.transsion.baseui.widget.GradientTextView] */
    private final LinearLayout s0(ViewGroup parent, final HomePreferencesContentItem item, final boolean isSingle) {
        final Context context = parent.getContext();
        boolean contains = this.selectedIds.contains(item.getValue());
        final LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setMinimumWidth(this.tagMinWidth);
        int i = this.tagHorizontalPadding;
        linearLayout.setPadding(i, 0, i, 0);
        linearLayout.setBackground(androidx.core.content.b.getDrawable(context, R$drawable.bg_preferences_tag));
        linearLayout.setSelected(contains);
        Intrinsics.e(context);
        final ?? gradientTextView = new GradientTextView(context, null, 0, 6, null);
        gradientTextView.setText(item.getName());
        gradientTextView.setTextSize(12.0f);
        gradientTextView.setMaxLines(1);
        gradientTextView.setGravity(17);
        gradientTextView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        q0(gradientTextView, context, contains);
        final ImageView imageView = new ImageView(context);
        imageView.setImageResource(contains ? R$drawable.ic_preferences_heart_selected : R$drawable.ic_preferences_heart_unselected);
        int i2 = this.iconSize;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.setMarginStart(this.iconGap);
        imageView.setLayoutParams(layoutParams);
        linearLayout.addView(gradientTextView);
        linearLayout.addView(imageView);
        linearLayout.setTag(item.getValue());
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.dialog.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomePreferencesDialog.t0(isSingle, this, item, context, linearLayout, imageView, gradientTextView, view);
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(boolean z, HomePreferencesDialog homePreferencesDialog, HomePreferencesContentItem homePreferencesContentItem, Context context, LinearLayout linearLayout, ImageView imageView, GradientTextView gradientTextView, View view) {
        if (z) {
            if (homePreferencesDialog.selectedIds.contains(homePreferencesContentItem.getValue())) {
                homePreferencesDialog.selectedIds.remove(homePreferencesContentItem.getValue());
            } else {
                homePreferencesDialog.selectedIds.clear();
                homePreferencesDialog.selectedIds.add(homePreferencesContentItem.getValue());
            }
            LinearLayout linearLayout2 = homePreferencesDialog.rowsContainer;
            if (linearLayout2 != null) {
                homePreferencesDialog.y0(linearLayout2);
            }
        } else {
            boolean contains = homePreferencesDialog.selectedIds.contains(homePreferencesContentItem.getValue());
            boolean z2 = !contains;
            if (contains) {
                homePreferencesDialog.selectedIds.remove(homePreferencesContentItem.getValue());
            } else {
                HomePreferencesConfig homePreferencesConfig = homePreferencesDialog.config;
                int maxSelectNum = homePreferencesConfig != null ? homePreferencesConfig.getMaxSelectNum() : 0;
                if (maxSelectNum > 0 && homePreferencesDialog.selectedIds.size() >= maxSelectNum) {
                    String string = context.getString(R.string.home_preferences_max_select_tips, Integer.valueOf(maxSelectNum));
                    Intrinsics.g(string, "getString(...)");
                    com.transsion.baseui.util.m.e(string);
                    return;
                }
                homePreferencesDialog.selectedIds.add(homePreferencesContentItem.getValue());
            }
            linearLayout.setSelected(z2);
            imageView.setImageResource(!contains ? R$drawable.ic_preferences_heart_selected : R$drawable.ic_preferences_heart_unselected);
            Intrinsics.e(context);
            homePreferencesDialog.q0(gradientTextView, context, z2);
        }
        homePreferencesDialog.C0();
    }

    private final List u0(List items, int rowCount) {
        List[] listArr = new List[rowCount];
        for (int i = 0; i < rowCount; i++) {
            listArr[i] = new ArrayList();
        }
        float[] fArr = new float[rowCount];
        Iterator it = items.iterator();
        while (it.hasNext()) {
            HomePreferencesContentItem homePreferencesContentItem = (HomePreferencesContentItem) it.next();
            float v0 = v0(homePreferencesContentItem.getName());
            float f = Float.MAX_VALUE;
            int i2 = -1;
            for (int i3 = 0; i3 < rowCount; i3++) {
                if (listArr[i3].size() < 8) {
                    float f2 = fArr[i3];
                    if (f2 < f) {
                        i2 = i3;
                        f = f2;
                    }
                }
            }
            if (i2 == -1) {
                break;
            }
            listArr[i2].add(homePreferencesContentItem);
            fArr[i2] = fArr[i2] + v0 + this.tagGap;
        }
        ArrayList arrayList = new ArrayList(rowCount);
        for (int i4 = 0; i4 < rowCount; i4++) {
            arrayList.add(CollectionsKt.R0(listArr[i4]));
        }
        return arrayList;
    }

    private final float v0(String text) {
        return Math.max((this.tagHorizontalPadding * 2) + this.measurePaint.measureText(text) + this.iconGap + this.iconSize, this.tagMinWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(HomePreferencesDialog homePreferencesDialog, View view) {
        Function0 function0 = homePreferencesDialog.onClose;
        if (function0 != null) {
            function0.invoke();
        }
        homePreferencesDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(HomePreferencesDialog homePreferencesDialog, View view) {
        if (homePreferencesDialog.selectedIds.isEmpty()) {
            return;
        }
        Function1 function1 = homePreferencesDialog.onConfirm;
        if (function1 != null) {
            function1.invoke(CollectionsKt.R0(homePreferencesDialog.selectedIds));
        }
        homePreferencesDialog.dismissAllowingStateLoss();
    }

    private final void y0(ViewGroup container) {
        int childCount = container.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = container.getChildAt(i);
            if (childAt instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) childAt;
                if (linearLayout.getTag() instanceof String) {
                    Object tag = linearLayout.getTag();
                    Intrinsics.f(tag, "null cannot be cast to non-null type kotlin.String");
                    boolean contains = this.selectedIds.contains((String) tag);
                    linearLayout.setSelected(contains);
                    if (linearLayout.getChildCount() >= 2) {
                        Object childAt2 = linearLayout.getChildAt(0);
                        GradientTextView gradientTextView = childAt2 instanceof GradientTextView ? (GradientTextView) childAt2 : null;
                        if (gradientTextView != null) {
                            Context context = linearLayout.getContext();
                            Intrinsics.g(context, "getContext(...)");
                            q0(gradientTextView, context, contains);
                        }
                        View childAt3 = linearLayout.getChildAt(1);
                        ImageView imageView = childAt3 instanceof ImageView ? (ImageView) childAt3 : null;
                        if (imageView != null) {
                            imageView.setImageResource(contains ? R$drawable.ic_preferences_heart_selected : R$drawable.ic_preferences_heart_unselected);
                        }
                    }
                }
            }
            if (childAt instanceof ViewGroup) {
                y0((ViewGroup) childAt);
            }
        }
    }

    public final void A0(Function0 function0) {
        this.onClose = function0;
    }

    public final void B0(Function1 function1) {
        this.onConfirm = function1;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.BottomDialogTheme);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
        HomePreferencesConfig homePreferencesConfig = this.config;
        if (homePreferencesConfig == null) {
            return;
        }
        ((TextView) view.findViewById(R.id.tvTitle)).setText(homePreferencesConfig.getTitle());
        TextView textView = (TextView) view.findViewById(R.id.tvSubtitle);
        String subTitle = homePreferencesConfig.getSubTitle();
        if (subTitle == null || StringsKt.q0(subTitle)) {
            textView.setVisibility(8);
        } else {
            textView.setText(homePreferencesConfig.getSubTitle());
            textView.setVisibility(0);
        }
        view.findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.dialog.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomePreferencesDialog.w0(HomePreferencesDialog.this, view2);
            }
        });
        TextView textView2 = (TextView) view.findViewById(R.id.btnConfirm);
        this.confirmButton = textView2;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.dialog.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HomePreferencesDialog.x0(HomePreferencesDialog.this, view2);
                }
            });
        }
        r0(view, homePreferencesConfig);
        C0();
    }

    public final void z0(HomePreferencesConfig config) {
        Intrinsics.h(config, "config");
        this.config = config;
        this.selectedIds.clear();
    }
}
