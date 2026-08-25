package com.transsion.shorttv._channel.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.slider.RangeSlider;
import com.transsion.shorttv.R;
import com.transsion.shorttv._channel.model.ShortTvFilterVal;
import com.transsion.shorttv._channel.model.ShortTvItem;
import com.transsion.shorttv._channel.model.ShortTvRangeValue;
import com.transsion.shorttv._channel.ui.widget.ShortTvPopupFilterView;
import com.transsion.shorttv._channel.ui.widget.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends Dialog {
    private RecyclerView a;
    private View b;
    private View c;
    private ImageView d;
    private b e;
    private List f;
    private Map g;
    private Function1 h;
    private final Map i;

    /* renamed from: com.transsion.shorttv._channel.ui.widget.a$a, reason: collision with other inner class name */
    public static final class C0059a extends RecyclerView.a0 {
        private final TextView a;
        private final FlexboxLayout b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0059a(View view, TextView textView, FlexboxLayout flexboxLayout) {
            super(view);
            Intrinsics.h(view, "itemView");
            Intrinsics.h(textView, "title");
            Intrinsics.h(flexboxLayout, "flexbox");
            this.a = textView;
            this.b = flexboxLayout;
        }

        public final FlexboxLayout f() {
            return this.b;
        }

        public final TextView g() {
            return this.a;
        }
    }

    public final class b extends RecyclerView.Adapter {
        private final List a;
        private final Map b;
        private final int c;
        private final int d;
        final /* synthetic */ a e;

        public b(a aVar, List list, Map map) {
            Intrinsics.h(list, "items");
            Intrinsics.h(map, "selectItems");
            this.e = aVar;
            this.a = list;
            this.b = map;
            this.d = 1;
        }

        private final View i(String str, boolean z, int i) {
            LinearLayout linearLayout = new LinearLayout(this.e.getContext());
            linearLayout.setGravity(17);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(a0.a(100.0f));
            if (z) {
                gradientDrawable.setStroke(a0.a(1.0f), -1);
                gradientDrawable.setColor(linearLayout.getContext().getResources().getColor(R.color.short_tv_white_40));
            } else {
                gradientDrawable.setStroke(a0.a(1.0f), linearLayout.getContext().getResources().getColor(R.color.short_tv_gray_light_40));
                gradientDrawable.setColor(0);
            }
            linearLayout.setBackground(gradientDrawable);
            TextView textView = new TextView(this.e.getContext());
            textView.setText(str);
            textView.setTextSize(14.0f);
            textView.setTextColor(-1);
            textView.setTypeface(Typeface.DEFAULT);
            linearLayout.addView(textView);
            return linearLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(b bVar, ShortTvItem shortTvItem, ShortTvFilterVal shortTvFilterVal, int i, View view) {
            bVar.b.put(shortTvItem.getFilterType(), shortTvFilterVal.getId());
            bVar.notifyItemChanged(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(RecyclerView.a0 a0Var, b bVar, ShortTvItem shortTvItem, RangeSlider rangeSlider, float f, boolean z) {
            Intrinsics.h(rangeSlider, "slider");
            List values = rangeSlider.getValues();
            Intrinsics.g(values, "getValues(...)");
            if (values.size() >= 2) {
                Float f2 = (Float) values.get(0);
                Float f3 = (Float) values.get(1);
                c cVar = (c) a0Var;
                cVar.h().setText(String.valueOf((int) f2.floatValue()));
                cVar.f().setText(String.valueOf((int) f3.floatValue()));
                Map map = bVar.b;
                String filterType = shortTvItem.getFilterType();
                ShortTvPopupFilterView.Companion companion = ShortTvPopupFilterView.INSTANCE;
                Intrinsics.e(f2);
                float floatValue = f2.floatValue();
                Intrinsics.e(f3);
                map.put(filterType, companion.a(floatValue, f3.floatValue()));
            }
        }

        public int getItemCount() {
            return this.a.size();
        }

        public int getItemViewType(int i) {
            return ((ShortTvItem) this.a.get(i)).getRangeVals() != null ? this.d : this.c;
        }

        public void onBindViewHolder(final RecyclerView.a0 a0Var, final int i) {
            String str;
            Float t;
            String str2;
            Float t2;
            Intrinsics.h(a0Var, "holder");
            final ShortTvItem shortTvItem = (ShortTvItem) this.a.get(i);
            if (!(a0Var instanceof C0059a)) {
                if (a0Var instanceof c) {
                    c cVar = (c) a0Var;
                    cVar.i().setText(shortTvItem.getTitle());
                    ShortTvRangeValue rangeVals = shortTvItem.getRangeVals();
                    if (rangeVals == null) {
                        return;
                    }
                    cVar.g().setValueFrom(rangeVals.getMinVal());
                    cVar.g().setValueTo(rangeVals.getMaxVal());
                    cVar.g().setStepSize(1.0f);
                    String str3 = (String) this.b.get(shortTvItem.getFilterType());
                    List S0 = str3 != null ? StringsKt.S0(str3, new String[]{","}, false, 0, 6, (Object) null) : null;
                    float minVal = (S0 == null || (str2 = (String) CollectionsKt.l0(S0, 0)) == null || (t2 = StringsKt.t(str2)) == null) ? rangeVals.getMinVal() : t2.floatValue();
                    float maxVal = (S0 == null || (str = (String) CollectionsKt.l0(S0, 1)) == null || (t = StringsKt.t(str)) == null) ? rangeVals.getMaxVal() : t.floatValue();
                    cVar.g().setValues(new Float[]{Float.valueOf(minVal), Float.valueOf(maxVal)});
                    cVar.h().setText(String.valueOf((int) minVal));
                    cVar.f().setText(String.valueOf((int) maxVal));
                    cVar.g().addOnChangeListener(new com.google.android.material.slider.a() { // from class: wq.g
                        /* renamed from: b, reason: merged with bridge method [inline-methods] */
                        public final void a(RangeSlider rangeSlider, float f, boolean z) {
                            a.b.k(a0Var, this, shortTvItem, rangeSlider, f, z);
                        }
                    });
                    return;
                }
                return;
            }
            C0059a c0059a = (C0059a) a0Var;
            c0059a.g().setText(shortTvItem.getTitle());
            c0059a.f().removeAllViews();
            int a = (this.e.getContext().getResources().getDisplayMetrics().widthPixels - a0.a(44.0f)) / 2;
            int i2 = 0;
            for (Object obj : shortTvItem.getFilterValsV2()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                final ShortTvFilterVal shortTvFilterVal = (ShortTvFilterVal) obj;
                View i4 = i(shortTvFilterVal.getName(), Intrinsics.c(this.b.get(shortTvItem.getFilterType()), shortTvFilterVal.getId()), a);
                i4.setOnClickListener(new View.OnClickListener() { // from class: wq.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.b.j(a.b.this, shortTvItem, shortTvFilterVal, i, view);
                    }
                });
                FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(a, a0.a(32.0f));
                if (i2 % 2 == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = a0.a(12.0f);
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = a0.a(12.0f);
                i4.setLayoutParams(layoutParams);
                c0059a.f().addView(i4);
                i2 = i3;
            }
        }

        public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.h(viewGroup, "parent");
            LinearLayout linearLayout = new LinearLayout(this.e.getContext());
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            linearLayout.setPadding(0, 0, 0, a0.a(16.0f));
            TextView textView = new TextView(this.e.getContext());
            textView.setTextSize(16.0f);
            textView.setTextColor(-1);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setPadding(0, 0, 0, a0.a(12.0f));
            linearLayout.addView(textView);
            if (i == this.c) {
                View flexboxLayout = new FlexboxLayout(this.e.getContext());
                flexboxLayout.setFlexDirection(0);
                flexboxLayout.setFlexWrap(1);
                linearLayout.addView(flexboxLayout);
                return new C0059a(linearLayout, textView, flexboxLayout);
            }
            LinearLayout linearLayout2 = new LinearLayout(this.e.getContext());
            linearLayout2.setOrientation(1);
            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            View rangeSlider = new RangeSlider(this.e.getContext());
            rangeSlider.setValues(new Float[]{Float.valueOf(0.0f), Float.valueOf(100.0f)});
            rangeSlider.setTrackActiveTintList(ColorStateList.valueOf(-1));
            rangeSlider.setTrackInactiveTintList(ColorStateList.valueOf(rangeSlider.getContext().getResources().getColor(R.color.short_tv_white_40)));
            rangeSlider.setThumbTintList(ColorStateList.valueOf(-1));
            rangeSlider.setTickVisible(false);
            LinearLayout linearLayout3 = new LinearLayout(this.e.getContext());
            linearLayout3.setOrientation(0);
            TextView textView2 = new TextView(this.e.getContext());
            textView2.setTextSize(12.0f);
            textView2.setTextColor(-1);
            Typeface typeface = Typeface.DEFAULT_BOLD;
            textView2.setTypeface(typeface);
            TextView textView3 = new TextView(this.e.getContext());
            textView3.setTextSize(12.0f);
            textView3.setTextColor(-1);
            textView3.setTypeface(typeface);
            linearLayout3.addView(textView2);
            View view = new View(this.e.getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
            linearLayout3.addView(view);
            linearLayout3.addView(textView3);
            linearLayout2.addView(rangeSlider);
            linearLayout2.addView(linearLayout3);
            linearLayout.addView(linearLayout2);
            return new c(linearLayout, textView, rangeSlider, textView2, textView3);
        }
    }

    public static final class c extends RecyclerView.a0 {
        private final TextView a;
        private final RangeSlider b;
        private final TextView c;
        private final TextView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view, TextView textView, RangeSlider rangeSlider, TextView textView2, TextView textView3) {
            super(view);
            Intrinsics.h(view, "itemView");
            Intrinsics.h(textView, "title");
            Intrinsics.h(rangeSlider, "slider");
            Intrinsics.h(textView2, "startLabel");
            Intrinsics.h(textView3, "endLabel");
            this.a = textView;
            this.b = rangeSlider;
            this.c = textView2;
            this.d = textView3;
        }

        public final TextView f() {
            return this.d;
        }

        public final RangeSlider g() {
            return this.b;
        }

        public final TextView h() {
            return this.c;
        }

        public final TextView i() {
            return this.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, android.R.style.Theme.Black.NoTitleBar.Fullscreen);
        Intrinsics.h(context, "context");
        this.f = CollectionsKt.l();
        this.g = new LinkedHashMap();
        this.i = new LinkedHashMap();
    }

    private final View e() {
        View view = new View(getContext());
        view.setBackgroundColor(view.getContext().getResources().getColor(R.color.short_tv_white_10));
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, a0.a(1.0f)));
        return view;
    }

    private final boolean f() {
        if (this.g.size() != this.i.size()) {
            return true;
        }
        for (Map.Entry entry : this.g.entrySet()) {
            String str = (String) entry.getKey();
            if (!Intrinsics.c(this.i.get(str), (String) entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat g(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.h(view, "v");
        Intrinsics.h(windowInsetsCompat, "insets");
        z0.c insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.g(insets, "getInsets(...)");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), insets.d);
        return WindowInsetsCompat.CONSUMED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(a aVar, View view) {
        aVar.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(a aVar, View view) {
        Function1 function1;
        if (aVar.f() && (function1 = aVar.h) != null) {
            function1.invoke(Boolean.TRUE);
        }
        aVar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(a aVar, View view) {
        aVar.dismiss();
        Function1 function1 = aVar.h;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    private final void k() {
        for (ShortTvItem shortTvItem : this.f) {
            if (shortTvItem.getRangeVals() != null) {
                this.g.put(shortTvItem.getFilterType(), ShortTvPopupFilterView.INSTANCE.a(shortTvItem.getRangeVals().getMinVal(), shortTvItem.getRangeVals().getMaxVal()));
            } else if (!shortTvItem.getFilterValsV2().isEmpty()) {
                this.g.put(shortTvItem.getFilterType(), shortTvItem.getFilterValsV2().get(0).getId());
            }
        }
        b bVar = this.e;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public final void l(List list, Map map, Function1 function1) {
        Intrinsics.h(list, "items");
        Intrinsics.h(map, "selectItems");
        Intrinsics.h(function1, "callback");
        this.f = list;
        this.g.clear();
        this.g.putAll(map);
        this.i.clear();
        this.i.putAll(map);
        this.h = function1;
        this.e = new b(this, this.f, this.g);
        RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            if (recyclerView == null) {
                Intrinsics.y("mRecyclerView");
                recyclerView = null;
            }
            recyclerView.setAdapter(this.e);
        }
        if (isShowing()) {
            return;
        }
        show();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        RecyclerView recyclerView;
        Window window;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 35 && (window = getWindow()) != null) {
            WindowCompat.setDecorFitsSystemWindows(window, false);
            View findViewById = window.getDecorView().findViewById(android.R.id.content);
            Intrinsics.e(findViewById);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById, new OnApplyWindowInsetsListener() { // from class: wq.b
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    WindowInsetsCompat g;
                    g = com.transsion.shorttv._channel.ui.widget.a.g(view, windowInsetsCompat);
                    return g;
                }
            });
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setLayout(-1, -1);
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.addFlags(Integer.MIN_VALUE);
        }
        Window window5 = getWindow();
        if (window5 != null) {
            window5.setStatusBarColor(getContext().getResources().getColor(R.color.short_tv_black_90));
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(linearLayout.getContext().getResources().getColor(R.color.short_tv_black_90));
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(a0.a(16.0f), a0.a(12.0f), a0.a(16.0f), a0.a(12.0f));
        TextView textView = new TextView(getContext());
        textView.setText(textView.getContext().getString(R.string.short_tv_filter_more_title));
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        Typeface typeface = Typeface.DEFAULT_BOLD;
        textView.setTypeface(typeface);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.short_tv_music_iv_close);
        imageView.setColorFilter(imageView.getContext().getResources().getColor(R.color.short_tv_white));
        imageView.setLayoutParams(new LinearLayout.LayoutParams(a0.a(21.0f), a0.a(21.0f)));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: wq.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.transsion.shorttv._channel.ui.widget.a.j(com.transsion.shorttv._channel.ui.widget.a.this, view);
            }
        });
        this.d = imageView;
        linearLayout2.addView(textView);
        ImageView imageView2 = this.d;
        if (imageView2 == null) {
            Intrinsics.y("mCloseBtn");
            imageView2 = null;
        }
        linearLayout2.addView(imageView2);
        linearLayout.addView(linearLayout2);
        linearLayout.addView(e());
        View recyclerView2 = new RecyclerView(getContext());
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        recyclerView2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        recyclerView2.setPadding(a0.a(16.0f), a0.a(12.0f), a0.a(16.0f), a0.a(12.0f));
        recyclerView2.setClipToPadding(false);
        this.a = recyclerView2;
        linearLayout.addView(recyclerView2);
        LinearLayout linearLayout3 = new LinearLayout(getContext());
        linearLayout3.setOrientation(1);
        linearLayout3.setBackgroundColor(linearLayout3.getContext().getResources().getColor(R.color.short_tv_black_90));
        linearLayout3.addView(e());
        LinearLayout linearLayout4 = new LinearLayout(getContext());
        linearLayout4.setOrientation(0);
        linearLayout4.setPadding(a0.a(16.0f), a0.a(12.0f), a0.a(16.0f), a0.a(16.0f));
        LinearLayout linearLayout5 = new LinearLayout(getContext());
        linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(-2, a0.a(48.0f)));
        linearLayout5.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(a0.a(100.0f));
        gradientDrawable.setStroke(a0.a(1.0f), linearLayout5.getContext().getResources().getColor(R.color.short_tv_white));
        gradientDrawable.setColor(0);
        linearLayout5.setBackground(gradientDrawable);
        linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: wq.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.transsion.shorttv._channel.ui.widget.a.h(com.transsion.shorttv._channel.ui.widget.a.this, view);
            }
        });
        TextView textView2 = new TextView(linearLayout5.getContext());
        textView2.setText(textView2.getContext().getString(R.string.short_tv_filter_reset));
        textView2.setTextSize(18.0f);
        textView2.setTextColor(-1);
        textView2.setTypeface(typeface);
        textView2.setPadding(a0.a(24.0f), 0, a0.a(24.0f), 0);
        linearLayout5.addView(textView2);
        this.b = linearLayout5;
        LinearLayout linearLayout6 = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, a0.a(48.0f), 1.0f);
        layoutParams.setMarginStart(a0.a(12.0f));
        linearLayout6.setLayoutParams(layoutParams);
        linearLayout6.setGravity(17);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(a0.a(100.0f));
        gradientDrawable2.setColor(linearLayout6.getContext().getResources().getColor(R.color.short_tv_white));
        linearLayout6.setBackground(gradientDrawable2);
        linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: wq.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.transsion.shorttv._channel.ui.widget.a.i(com.transsion.shorttv._channel.ui.widget.a.this, view);
            }
        });
        TextView textView3 = new TextView(linearLayout6.getContext());
        textView3.setText(textView3.getContext().getString(R.string.short_tv_filter_confirm));
        textView3.setTextSize(18.0f);
        textView3.setTextColor(textView3.getContext().getResources().getColor(R.color.short_tv_black));
        textView3.setTypeface(typeface);
        linearLayout6.addView(textView3);
        this.c = linearLayout6;
        View view = this.b;
        if (view == null) {
            Intrinsics.y("mResetBtn");
            view = null;
        }
        linearLayout4.addView(view);
        View view2 = this.c;
        if (view2 == null) {
            Intrinsics.y("mConfirmBtn");
            view2 = null;
        }
        linearLayout4.addView(view2);
        linearLayout3.addView(linearLayout4);
        linearLayout.addView(linearLayout3);
        setContentView(linearLayout);
        if (this.e != null) {
            RecyclerView recyclerView3 = this.a;
            if (recyclerView3 == null) {
                Intrinsics.y("mRecyclerView");
                recyclerView = null;
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setAdapter(this.e);
        }
    }
}
