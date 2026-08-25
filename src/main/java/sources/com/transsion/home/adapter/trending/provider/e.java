package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.home.R$drawable;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.HomePreferencesContentItem;
import com.transsion.home.bean.HomePreferencesSelectType;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e extends BaseItemProvider {
    public static final a r = new a(null);
    public static final int s = 8;
    private Function1 f;
    private Function1 g;
    private Function3 h;
    private Function1 i;
    private final TextPaint p;
    private final Map q;
    private final Set e = new LinkedHashSet();
    private final int j = com.blankj.utilcode.util.a0.a(12.0f);
    private final int k = com.blankj.utilcode.util.a0.a(32.0f);
    private final int l = com.blankj.utilcode.util.a0.a(68.0f);
    private final int m = com.blankj.utilcode.util.a0.a(8.0f);
    private final int n = com.blankj.utilcode.util.a0.a(16.0f);
    private final int o = com.blankj.utilcode.util.a0.a(4.0f);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e() {
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(com.blankj.utilcode.util.a0.a(12.0f));
        this.p = textPaint;
        this.q = new LinkedHashMap();
    }

    private final void A(LinearLayout linearLayout, List list, boolean z, int i, LinearLayout linearLayout2) {
        int a2 = com.blankj.utilcode.util.a0.a(8.0f);
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.u();
            }
            View E = E(linearLayout, (HomePreferencesContentItem) obj, z, i, linearLayout2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.k);
            layoutParams.setMarginStart(i2 == 0 ? a2 : this.m);
            linearLayout.addView(E, layoutParams);
            i2 = i3;
        }
    }

    private final void B(GradientTextView gradientTextView, Context context, boolean z) {
        int color = androidx.core.content.b.getColor(context, R.color.white_80);
        int color2 = androidx.core.content.b.getColor(context, R.color.brand_new_gradient_start);
        int color3 = androidx.core.content.b.getColor(context, R.color.brand_new_gradient_center);
        int color4 = androidx.core.content.b.getColor(context, R.color.brand_new_gradient_end);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(e eVar, HomePreferencesConfig homePreferencesConfig, View view) {
        Function1 function1 = eVar.f;
        if (function1 != null) {
            function1.invoke(homePreferencesConfig);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.view.View, android.widget.TextView, com.transsion.baseui.widget.GradientTextView] */
    private final LinearLayout E(ViewGroup viewGroup, final HomePreferencesContentItem homePreferencesContentItem, final boolean z, final int i, final LinearLayout linearLayout) {
        final Context context = viewGroup.getContext();
        boolean contains = this.e.contains(homePreferencesContentItem.getValue());
        final LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setMinimumWidth(this.l);
        int i2 = this.j;
        linearLayout2.setPadding(i2, 0, i2, 0);
        linearLayout2.setBackground(androidx.core.content.b.getDrawable(context, R$drawable.bg_preferences_tag));
        linearLayout2.setSelected(contains);
        linearLayout2.setTag(homePreferencesContentItem.getValue());
        Intrinsics.e(context);
        final ?? gradientTextView = new GradientTextView(context, null, 0, 6, null);
        gradientTextView.setText(homePreferencesContentItem.getName());
        gradientTextView.setTextSize(12.0f);
        gradientTextView.setMaxLines(1);
        gradientTextView.setGravity(17);
        gradientTextView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        B(gradientTextView, context, contains);
        final ImageView imageView = new ImageView(context);
        imageView.setImageResource(contains ? R$drawable.ic_preferences_heart_selected : R$drawable.ic_preferences_heart_unselected);
        int i3 = this.n;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.setMarginStart(this.o);
        imageView.setLayoutParams(layoutParams);
        linearLayout2.addView(gradientTextView);
        linearLayout2.addView(imageView);
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.F(z, this, homePreferencesContentItem, linearLayout, i, context, linearLayout2, imageView, gradientTextView, view);
            }
        });
        return linearLayout2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(boolean z, e eVar, HomePreferencesContentItem homePreferencesContentItem, LinearLayout linearLayout, int i, Context context, LinearLayout linearLayout2, ImageView imageView, GradientTextView gradientTextView, View view) {
        if (z) {
            if (eVar.e.contains(homePreferencesContentItem.getValue())) {
                eVar.e.remove(homePreferencesContentItem.getValue());
            } else {
                eVar.e.clear();
                eVar.e.add(homePreferencesContentItem.getValue());
            }
            eVar.I(linearLayout);
        } else {
            boolean contains = eVar.e.contains(homePreferencesContentItem.getValue());
            boolean z2 = !contains;
            if (contains) {
                eVar.e.remove(homePreferencesContentItem.getValue());
            } else {
                if (i > 0 && eVar.e.size() >= i) {
                    String string = context.getString(com.transsion.home.R.string.home_preferences_max_select_tips, Integer.valueOf(i));
                    Intrinsics.g(string, "getString(...)");
                    com.transsion.baseui.util.m.e(string);
                    return;
                }
                eVar.e.add(homePreferencesContentItem.getValue());
            }
            linearLayout2.setSelected(z2);
            imageView.setImageResource(!contains ? R$drawable.ic_preferences_heart_selected : R$drawable.ic_preferences_heart_unselected);
            Intrinsics.e(context);
            eVar.B(gradientTextView, context, z2);
        }
        Function1 function1 = eVar.g;
        if (function1 != null) {
            function1.invoke(CollectionsKt.R0(eVar.e));
        }
    }

    private final List G(List list, int i) {
        List[] listArr = new List[i];
        for (int i2 = 0; i2 < i; i2++) {
            listArr[i2] = new ArrayList();
        }
        float[] fArr = new float[i];
        Iterator it = list.iterator();
        while (it.hasNext()) {
            HomePreferencesContentItem homePreferencesContentItem = (HomePreferencesContentItem) it.next();
            float H = H(homePreferencesContentItem.getName());
            float f = Float.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < i; i4++) {
                if (listArr[i4].size() < 8) {
                    float f2 = fArr[i4];
                    if (f2 < f) {
                        i3 = i4;
                        f = f2;
                    }
                }
            }
            if (i3 == -1) {
                break;
            }
            listArr[i3].add(homePreferencesContentItem);
            fArr[i3] = fArr[i3] + H + this.m;
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i5 = 0; i5 < i; i5++) {
            arrayList.add(CollectionsKt.R0(listArr[i5]));
        }
        return arrayList;
    }

    private final float H(String str) {
        return Math.max((this.j * 2) + this.p.measureText(str) + this.o + this.n, this.l);
    }

    private final void I(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) childAt;
                int childCount2 = linearLayout.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    View childAt2 = linearLayout.getChildAt(i2);
                    if (childAt2 instanceof LinearLayout) {
                        LinearLayout linearLayout2 = (LinearLayout) childAt2;
                        if (linearLayout2.getTag() instanceof String) {
                            Object tag = linearLayout2.getTag();
                            Intrinsics.f(tag, "null cannot be cast to non-null type kotlin.String");
                            boolean contains = this.e.contains((String) tag);
                            linearLayout2.setSelected(contains);
                            if (linearLayout2.getChildCount() >= 2) {
                                Object childAt3 = linearLayout2.getChildAt(0);
                                GradientTextView gradientTextView = childAt3 instanceof GradientTextView ? (GradientTextView) childAt3 : null;
                                if (gradientTextView != null) {
                                    Context context = linearLayout2.getContext();
                                    Intrinsics.g(context, "getContext(...)");
                                    B(gradientTextView, context, contains);
                                }
                                View childAt4 = linearLayout2.getChildAt(1);
                                ImageView imageView = childAt4 instanceof ImageView ? (ImageView) childAt4 : null;
                                if (imageView != null) {
                                    imageView.setImageResource(contains ? R$drawable.ic_preferences_heart_selected : R$drawable.ic_preferences_heart_unselected);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, OperateItem operateItem) {
        boolean z;
        final e eVar = this;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        long nanoTime = System.nanoTime();
        final HomePreferencesConfig homePreferencesConfig = operateItem.getHomePreferencesConfig();
        if (homePreferencesConfig == null) {
            return;
        }
        List options = homePreferencesConfig.getOptions();
        if (options.isEmpty()) {
            return;
        }
        TextView textView = (TextView) baseViewHolder.getViewOrNull(com.transsion.home.R.id.tv_title);
        if (textView != null) {
            textView.setText(homePreferencesConfig.getTitle());
        }
        ImageView imageView = (ImageView) baseViewHolder.getViewOrNull(com.transsion.home.R.id.iv_close);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.D(e.this, homePreferencesConfig, view);
                }
            });
        }
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getViewOrNull(com.transsion.home.R.id.ll_rows_container);
        if (linearLayout == null) {
            return;
        }
        boolean c = Intrinsics.c(homePreferencesConfig.getSelectType(), HomePreferencesSelectType.SINGLE.getValue());
        String labelId = homePreferencesConfig.getLabelId();
        List list = (List) eVar.q.get(labelId);
        if (list != null) {
            List x = CollectionsKt.x(list);
            boolean z2 = x.size() == options.size();
            if (z2) {
                List list2 = x;
                ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((HomePreferencesContentItem) it.next()).getValue());
                }
                List list3 = options;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.v(list3, 10));
                Iterator<T> it2 = list3.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((HomePreferencesContentItem) it2.next()).getValue());
                }
                z = Intrinsics.c(arrayList, arrayList2);
            } else {
                z = false;
            }
            if (!z2 || !z) {
                list = eVar.G(options, options.size() <= 8 ? 1 : (int) Math.ceil(options.size() / 8));
                eVar.q.put(labelId, list);
            }
        } else {
            list = eVar.G(options, options.size() <= 8 ? 1 : (int) Math.ceil(options.size() / 8));
            eVar.q.put(labelId, list);
        }
        int size = list.size();
        Object tag = linearLayout.getTag();
        if (!Intrinsics.c(tag instanceof String ? (String) tag : null, labelId) || linearLayout.getChildCount() == 0) {
            linearLayout.removeAllViews();
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                List list4 = (List) obj;
                LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
                linearLayout2.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i > 0) {
                    layoutParams.topMargin = eVar.m;
                }
                linearLayout2.setLayoutParams(layoutParams);
                A(linearLayout2, list4, c, homePreferencesConfig.getMaxSelectNum(), linearLayout);
                linearLayout.addView(linearLayout2);
                eVar = this;
                i = i2;
            }
            linearLayout.setTag(labelId);
        }
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) baseViewHolder.getViewOrNull(com.transsion.home.R.id.hsv_tags);
        if (horizontalScrollView != null) {
            horizontalScrollView.scrollTo(0, 0);
        }
        a.a aVar = wf.a.a;
        a.a.f(aVar, "HomePreferencesProvider", "convert cost=" + ((System.nanoTime() - nanoTime) / 1000000.0f) + "ms, items=" + options.size() + ", rows=" + size, false, 4, (Object) null);
    }

    public final void J(Function1 function1) {
        this.f = function1;
    }

    public final void K(Function1 function1) {
        this.i = function1;
    }

    public final void L(Function3 function3) {
        this.h = function3;
    }

    public int l() {
        return PostItemType.PREFERENCES.ordinal();
    }

    public int m() {
        return com.transsion.home.R.layout.item_home_preferences;
    }

    public void t(BaseViewHolder baseViewHolder) {
        HomePreferencesConfig homePreferencesConfig;
        List data;
        Intrinsics.h(baseViewHolder, "holder");
        super.t(baseViewHolder);
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        BaseProviderMultiAdapter g = g();
        OperateItem operateItem = (g == null || (data = g.getData()) == null) ? null : (OperateItem) CollectionsKt.l0(data, bindingAdapterPosition);
        OperateItem operateItem2 = operateItem instanceof OperateItem ? operateItem : null;
        if (operateItem2 == null || (homePreferencesConfig = operateItem2.getHomePreferencesConfig()) == null) {
            return;
        }
        a.a.f(wf.a.a, "HomePreferencesProvider", "onViewAttachedToWindow: labelId=" + homePreferencesConfig.getLabelId(), false, 4, (Object) null);
        Function1 function1 = this.i;
        if (function1 != null) {
            function1.invoke(homePreferencesConfig);
        }
    }

    public void u(BaseViewHolder baseViewHolder) {
        HomePreferencesConfig homePreferencesConfig;
        List data;
        Intrinsics.h(baseViewHolder, "holder");
        super.u(baseViewHolder);
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        BaseProviderMultiAdapter g = g();
        OperateItem operateItem = (g == null || (data = g.getData()) == null) ? null : (OperateItem) CollectionsKt.l0(data, bindingAdapterPosition);
        OperateItem operateItem2 = operateItem instanceof OperateItem ? operateItem : null;
        if (operateItem2 == null || (homePreferencesConfig = operateItem2.getHomePreferencesConfig()) == null) {
            return;
        }
        List<HomePreferencesContentItem> options = homePreferencesConfig.getOptions();
        ArrayList arrayList = new ArrayList(CollectionsKt.v(options, 10));
        Iterator<T> it = options.iterator();
        while (it.hasNext()) {
            arrayList.add(((HomePreferencesContentItem) it.next()).getValue());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (this.e.contains((String) obj)) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            a.a.f(wf.a.a, "HomePreferencesProvider", "onViewDetachedFromWindow: no selection, skip submit, labelId=" + homePreferencesConfig.getLabelId(), false, 4, (Object) null);
            return;
        }
        a.a.f(wf.a.a, "HomePreferencesProvider", "onViewDetachedFromWindow: try submit, labelId=" + homePreferencesConfig.getLabelId() + ", options=" + arrayList2, false, 4, (Object) null);
        Function3 function3 = this.h;
        if (function3 != null) {
            function3.invoke(homePreferencesConfig, arrayList2, "opt_scroll");
        }
    }
}
