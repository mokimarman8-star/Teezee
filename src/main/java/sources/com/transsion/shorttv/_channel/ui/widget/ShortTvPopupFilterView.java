package com.transsion.shorttv._channel.ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.a0;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import com.transsion.shorttv._channel.model.ShortTvFilterVal;
import com.transsion.shorttv._channel.model.ShortTvItem;
import com.transsion.shorttv._channel.ui.widget.ShortTvPopupFilterView;
import cr.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wq.r;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 =2\u00020\u0001:\u0001-B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\u00132\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\"\u0010\u0015JG\u0010&\u001a\u00020\u00132\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2(\b\u0002\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010#j\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u0001`$¢\u0006\u0004\b&\u0010'J-\u0010+\u001a\u00020\u00132\u001e\u0010*\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160)\u0012\u0004\u0012\u00020\u00130(¢\u0006\u0004\b+\u0010,R0\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160#j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R0\u00102\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160)\u0012\u0004\u0012\u00020\u0013\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001e\u00105\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010;¨\u0006>"}, d2 = {"Lcom/transsion/shorttv/_channel/ui/widget/ShortTvPopupFilterView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "Lcom/transsion/shorttv/_channel/model/ShortTvItem;", "filterItem", BuildConfig.FLAVOR, "i", "(Ljava/util/List;)Z", "data", BuildConfig.FLAVOR, "e", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "text", "isSelected", "Landroid/view/View;", "h", "(Ljava/lang/String;Z)Landroid/view/View;", "anchor", "item", "selectedId", "l", "(Landroid/view/View;Lcom/transsion/shorttv/_channel/model/ShortTvItem;Ljava/lang/String;)V", "innerData", "j", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "selectItems", "initSelectData", "(Ljava/util/List;Ljava/util/HashMap;)V", "Lkotlin/Function1;", BuildConfig.FLAVOR, "callback", "setOnFilterListener", "(Lkotlin/jvm/functions/Function1;)V", "a", "Ljava/util/HashMap;", "selectItemsMap", "b", "Lkotlin/jvm/functions/Function1;", "onFilterChangedListener", "c", "Ljava/util/List;", "mData", "Lwq/r;", "d", "Lwq/r;", "mSingleFilterPopup", "Lcom/transsion/shorttv/_channel/ui/widget/a;", "Lcom/transsion/shorttv/_channel/ui/widget/a;", "mMultiFilterPopup", "Companion", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvPopupFilterView extends FrameLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private final HashMap selectItemsMap;

    /* renamed from: b, reason: from kotlin metadata */
    private Function1 onFilterChangedListener;

    /* renamed from: c, reason: from kotlin metadata */
    private List mData;

    /* renamed from: d, reason: from kotlin metadata */
    private r mSingleFilterPopup;

    /* renamed from: e, reason: from kotlin metadata */
    private a mMultiFilterPopup;

    /* renamed from: com.transsion.shorttv._channel.ui.widget.ShortTvPopupFilterView$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(float f, float f2) {
            return ((int) f) + "," + ((int) f2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvPopupFilterView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.selectItemsMap = new HashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvPopupFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        Intrinsics.h(attributeSet, "attrs");
        this.selectItemsMap = new HashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvPopupFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        Intrinsics.h(attributeSet, "attrs");
        this.selectItemsMap = new HashMap();
    }

    private final void e(List data) {
        Object obj;
        String title;
        List list = data;
        ArrayList<ShortTvItem> arrayList = new ArrayList();
        for (Object obj2 : list) {
            ShortTvItem shortTvItem = (ShortTvItem) obj2;
            if (Intrinsics.c(shortTvItem.getShowOut(), "true") && shortTvItem.getRangeVals() == null) {
                arrayList.add(obj2);
            }
        }
        final ArrayList<ShortTvItem> arrayList2 = new ArrayList();
        for (Object obj3 : list) {
            if (Intrinsics.c(((ShortTvItem) obj3).getShowOut(), "false")) {
                arrayList2.add(obj3);
            }
        }
        for (ShortTvItem shortTvItem2 : arrayList2) {
            if (!shortTvItem2.getFilterValsV2().isEmpty() && this.selectItemsMap.get(shortTvItem2.getFilterType()) == null) {
                this.selectItemsMap.put(shortTvItem2.getFilterType(), shortTvItem2.getFilterValsV2().get(0).getId());
            }
        }
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());
        horizontalScrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        horizontalScrollView.setFillViewport(true);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        for (final ShortTvItem shortTvItem3 : arrayList) {
            final String str = (String) this.selectItemsMap.get(shortTvItem3.getFilterType());
            if (str == null) {
                str = !shortTvItem3.getFilterValsV2().isEmpty() ? shortTvItem3.getFilterValsV2().get(0).getId() : BuildConfig.FLAVOR;
            }
            boolean z = (shortTvItem3.getFilterValsV2().isEmpty() || Intrinsics.c(str, shortTvItem3.getFilterValsV2().get(0).getId())) ? false : true;
            Iterator<T> it = shortTvItem3.getFilterValsV2().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.c(((ShortTvFilterVal) obj).getId(), str)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            ShortTvFilterVal shortTvFilterVal = (ShortTvFilterVal) obj;
            if (!z) {
                title = shortTvItem3.getTitle();
            } else if (shortTvFilterVal == null || (title = shortTvFilterVal.getName()) == null) {
                title = str;
            }
            final View h = h(title, z);
            h.setOnClickListener(new View.OnClickListener() { // from class: wq.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShortTvPopupFilterView.f(ShortTvPopupFilterView.this, h, shortTvItem3, str, view);
                }
            });
            linearLayout.addView(h);
            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(a0.a(8.0f), 1));
            linearLayout.addView(view);
        }
        View view2 = new View(getContext());
        view2.setLayoutParams(new LinearLayout.LayoutParams(0, 1, 1.0f));
        linearLayout.addView(view2);
        if (!arrayList2.isEmpty()) {
            boolean i = i(data);
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.mipmap.short_tv_ic_sub_operation_filter);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(a0.a(24.0f), a0.a(24.0f)));
            if (i) {
                imageView.setColorFilter(imageView.getContext().getResources().getColor(R.color.brand));
            } else {
                imageView.setColorFilter(imageView.getContext().getResources().getColor(R.color.short_tv_white));
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: wq.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    ShortTvPopupFilterView.g(ShortTvPopupFilterView.this, arrayList2, view3);
                }
            });
            linearLayout.addView(imageView);
        }
        horizontalScrollView.addView(linearLayout);
        addView(horizontalScrollView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ShortTvPopupFilterView shortTvPopupFilterView, View view, ShortTvItem shortTvItem, String str, View view2) {
        shortTvPopupFilterView.l(view, shortTvItem, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ShortTvPopupFilterView shortTvPopupFilterView, List list, View view) {
        shortTvPopupFilterView.j(list);
    }

    private final View h(String text, boolean isSelected) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, a0.a(28.0f)));
        linearLayout.setPadding(a0.a(12.0f), 0, a0.a(10.0f), 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(a0.a(100.0f));
        if (isSelected) {
            gradientDrawable.setStroke(a0.a(1.0f), linearLayout.getContext().getResources().getColor(R.color.short_tv_white));
            gradientDrawable.setColor(linearLayout.getContext().getResources().getColor(R.color.short_tv_white_40));
        } else {
            gradientDrawable.setStroke(a0.a(1.0f), linearLayout.getContext().getResources().getColor(R.color.short_tv_gray_light_40));
            gradientDrawable.setColor(0);
        }
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(getContext());
        textView.setText(text);
        textView.setTextSize(14.0f);
        textView.setTextColor(-1);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxWidth(a0.a(120.0f));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.short_tv_ic_arrow_down);
        imageView.setColorFilter(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a0.a(16.0f), a0.a(16.0f));
        layoutParams.setMarginStart(a0.a(4.0f));
        imageView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    private final boolean i(List filterItem) {
        if (filterItem != null) {
            Iterator it = filterItem.iterator();
            while (it.hasNext()) {
                ShortTvItem shortTvItem = (ShortTvItem) it.next();
                String str = (String) this.selectItemsMap.get(shortTvItem.getFilterType());
                if (shortTvItem.getRangeVals() == null && Intrinsics.c(shortTvItem.getShowOut(), "false")) {
                    if (str != null && !shortTvItem.getFilterValsV2().isEmpty() && !Intrinsics.c(str, shortTvItem.getFilterValsV2().get(0).getId())) {
                        return true;
                    }
                } else if (shortTvItem.getRangeVals() != null) {
                    String a = INSTANCE.a(shortTvItem.getRangeVals().getMinVal(), shortTvItem.getRangeVals().getMaxVal());
                    if (str != null && !Intrinsics.c(str, a)) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initSelectData$default(ShortTvPopupFilterView shortTvPopupFilterView, List list, HashMap hashMap, int i, Object obj) {
        if ((i & 2) != 0) {
            hashMap = null;
        }
        shortTvPopupFilterView.initSelectData(list, hashMap);
    }

    private final void j(List innerData) {
        if (this.mMultiFilterPopup == null) {
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            this.mMultiFilterPopup = new a(context);
        }
        a aVar = this.mMultiFilterPopup;
        if (aVar != null) {
            aVar.l(innerData, this.selectItemsMap, new Function1() { // from class: wq.k
                public final Object invoke(Object obj) {
                    Unit k;
                    k = ShortTvPopupFilterView.k(ShortTvPopupFilterView.this, ((Boolean) obj).booleanValue());
                    return k;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(ShortTvPopupFilterView shortTvPopupFilterView, boolean z) {
        if (z) {
            Function1 function1 = shortTvPopupFilterView.onFilterChangedListener;
            if (function1 != null) {
                function1.invoke(shortTvPopupFilterView.selectItemsMap);
            }
            List<ShortTvItem> list = shortTvPopupFilterView.mData;
            if (list != null) {
                shortTvPopupFilterView.initSelectData(list, shortTvPopupFilterView.selectItemsMap);
            }
        }
        return Unit.a;
    }

    private final void l(View anchor, final ShortTvItem item, String selectedId) {
        if (this.mSingleFilterPopup == null) {
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            this.mSingleFilterPopup = new r(context);
        }
        r rVar = this.mSingleFilterPopup;
        if (rVar != null) {
            rVar.j(item, selectedId, new Function1() { // from class: wq.j
                public final Object invoke(Object obj) {
                    Unit m;
                    m = ShortTvPopupFilterView.m(ShortTvPopupFilterView.this, item, (String) obj);
                    return m;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(ShortTvPopupFilterView shortTvPopupFilterView, ShortTvItem shortTvItem, String str) {
        if (str != null) {
            shortTvPopupFilterView.selectItemsMap.put(shortTvItem.getFilterType(), str);
            Function1 function1 = shortTvPopupFilterView.onFilterChangedListener;
            if (function1 != null) {
                function1.invoke(shortTvPopupFilterView.selectItemsMap);
            }
            List<ShortTvItem> list = shortTvPopupFilterView.mData;
            if (list != null) {
                shortTvPopupFilterView.initSelectData(list, shortTvPopupFilterView.selectItemsMap);
            }
        }
        return Unit.a;
    }

    public final void initSelectData(List<ShortTvItem> data, HashMap<String, String> selectItems) {
        this.mData = data;
        List<ShortTvItem> list = data;
        if (list == null || list.isEmpty()) {
            b.b(this);
            return;
        }
        b.e(this);
        this.selectItemsMap.clear();
        if (selectItems != null) {
            this.selectItemsMap.putAll(selectItems);
        }
        removeAllViews();
        e(data);
    }

    public final void setOnFilterListener(Function1<? super Map<String, String>, Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.onFilterChangedListener = callback;
    }
}
