package com.transsion.home.view.filter.expand;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.b;
import bl.a;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.home.view.filter.expand.TabExpandView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import qk.g0;
import uf.c;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u000f¢\u0006\u0004\b\u001f\u0010\u001aJ\r\u0010 \u001a\u00020\u000f¢\u0006\u0004\b \u0010\u001aJ0\u0010%\u001a\u00020\u000f2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000f0!¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b'\u0010\u0011R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R(\u00106\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\"\u00109\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\t038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00105R3\u0010<\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000f\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010=R\"\u0010E\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/transsion/home/view/filter/expand/TabExpandView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "Lbl/a;", "list", BuildConfig.FLAVOR, "l", "(Ljava/util/List;)V", "item", "Landroid/view/View;", "itemView", "f", "(Lbl/a;Landroid/view/View;)Landroid/view/View;", "m", "(Lbl/a;)V", "i", "()V", BuildConfig.FLAVOR, "enable", "enableExpand", "(Z)V", "collapse", "expand", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onItemClickListener", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "updateData", "Lqk/g0;", "a", "Lqk/g0;", "getBinding", "()Lqk/g0;", "setBinding", "(Lqk/g0;)V", "binding", "b", "Ljava/util/List;", "datas", BuildConfig.FLAVOR, "c", "Ljava/util/Map;", "rowMap", BuildConfig.FLAVOR, "d", "itemInRow", "e", "Lkotlin/jvm/functions/Function1;", "mOnItemClickListener", "Lbl/a;", "curSelectItem", "g", "I", "getInParentIndex", "()I", "setInParentIndex", "(I)V", "inParentIndex", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TabExpandView extends FrameLayout {
    public static final int $stable = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private g0 binding;

    /* renamed from: b, reason: from kotlin metadata */
    private List datas;

    /* renamed from: c, reason: from kotlin metadata */
    private Map rowMap;

    /* renamed from: d, reason: from kotlin metadata */
    private Map itemInRow;

    /* renamed from: e, reason: from kotlin metadata */
    private Function1 mOnItemClickListener;

    /* renamed from: f, reason: from kotlin metadata */
    private a curSelectItem;

    /* renamed from: g, reason: from kotlin metadata */
    private int inParentIndex;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabExpandView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabExpandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabExpandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        g0 c = g0.c(LayoutInflater.from(getContext()), this, true);
        Intrinsics.g(c, "inflate(...)");
        this.binding = c;
        this.datas = new ArrayList();
        this.rowMap = new LinkedHashMap();
        this.itemInRow = new LinkedHashMap();
        this.inParentIndex = -1;
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: al.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TabExpandView.e(TabExpandView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(TabExpandView tabExpandView, View view) {
        tabExpandView.binding.c.setSelected(!r2.isSelected());
        if (tabExpandView.binding.c.isSelected()) {
            tabExpandView.expand();
        } else {
            tabExpandView.collapse();
        }
    }

    private final View f(final a item, final View itemView) {
        Typeface defaultFromStyle;
        if (itemView == null) {
            itemView = u6.a.a(this, R.layout.adapter_filter_item);
        }
        TextView textView = (TextView) itemView.findViewById(R.id.filter_item_name);
        textView.setText(item.a());
        if (item.d()) {
            this.curSelectItem = item;
            textView.setBackgroundResource(R$drawable.bg_selected_filter_item);
            textView.setTextColor(b.getColor(textView.getContext(), com.tn.lib.widget.R.color.text_01));
            defaultFromStyle = Typeface.defaultFromStyle(1);
        } else {
            textView.setBackgroundResource(com.tn.lib.widget.R.color.transparent);
            textView.setTextColor(b.getColor(textView.getContext(), com.tn.lib.widget.R.color.text_02));
            defaultFromStyle = Typeface.defaultFromStyle(0);
        }
        textView.setTypeface(defaultFromStyle);
        itemView.setOnClickListener(new View.OnClickListener() { // from class: al.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TabExpandView.h(TabExpandView.this, item, itemView, view);
            }
        });
        return itemView;
    }

    static /* synthetic */ View g(TabExpandView tabExpandView, a aVar, View view, int i, Object obj) {
        if ((i & 2) != 0) {
            view = null;
        }
        return tabExpandView.f(aVar, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(TabExpandView tabExpandView, a aVar, View view, View view2) {
        tabExpandView.m(aVar);
        tabExpandView.f(aVar, view);
        Function1 function1 = tabExpandView.mOnItemClickListener;
        if (function1 != null) {
            function1.invoke(aVar);
        }
    }

    private final void i() {
        this.binding.b.post(new Runnable() { // from class: al.b
            @Override // java.lang.Runnable
            public final void run() {
                TabExpandView.j(TabExpandView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(TabExpandView tabExpandView) {
        int rowsCount = tabExpandView.binding.b.getRowsCount();
        int i = 0;
        for (int i2 = 0; i2 < rowsCount; i2++) {
            ArrayList arrayList = new ArrayList();
            int countInRow = tabExpandView.binding.b.getCountInRow(i2);
            int i3 = 0;
            while (i3 < countInRow) {
                int i4 = i + 1;
                a aVar = (a) tabExpandView.datas.get(i);
                tabExpandView.itemInRow.put(aVar.c(), Integer.valueOf(i2));
                arrayList.add(aVar);
                i3++;
                i = i4;
            }
            tabExpandView.rowMap.put(Integer.valueOf(i2), arrayList);
        }
        if (tabExpandView.rowMap.size() > 1) {
            AppCompatTextView appCompatTextView = tabExpandView.binding.c;
            Intrinsics.g(appCompatTextView, "tvExpand");
            c.k(appCompatTextView);
        } else {
            AppCompatTextView appCompatTextView2 = tabExpandView.binding.c;
            Intrinsics.g(appCompatTextView2, "tvExpand");
            c.h(appCompatTextView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(TabExpandView tabExpandView) {
        Map map = tabExpandView.itemInRow;
        a aVar = tabExpandView.curSelectItem;
        List list = (List) tabExpandView.rowMap.get((Integer) map.get(aVar != null ? aVar.c() : null));
        if (list == null) {
            list = tabExpandView.datas;
        }
        tabExpandView.l(list);
    }

    private final void l(List list) {
        int childCount = this.binding.b.getChildCount();
        int i = 0;
        if (list.size() <= childCount) {
            while (i < childCount) {
                View childAt = this.binding.b.getChildAt(i);
                if (i < list.size()) {
                    Intrinsics.e(childAt);
                    c.k(childAt);
                    f((a) list.get(i), childAt);
                } else {
                    Intrinsics.e(childAt);
                    c.g(childAt);
                }
                i++;
            }
            return;
        }
        this.binding.b.removeAllViews();
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            a aVar = (a) obj;
            View childAt2 = this.binding.b.getChildAt(i);
            if (childAt2 != null) {
                f(aVar, childAt2);
            } else {
                this.binding.b.addView(g(this, aVar, null, 2, null));
            }
            i = i2;
        }
    }

    private final void m(a item) {
        for (a aVar : this.datas) {
            aVar.e(Intrinsics.c(aVar, item));
        }
        this.curSelectItem = item;
    }

    public final void collapse() {
        this.binding.b.setMaxRows(1);
        this.binding.c.setSelected(false);
        this.binding.b.post(new Runnable() { // from class: al.d
            @Override // java.lang.Runnable
            public final void run() {
                TabExpandView.k(TabExpandView.this);
            }
        });
    }

    public final void enableExpand(boolean enable) {
        this.binding.c.setEnabled(enable);
    }

    public final void expand() {
        this.binding.b.setMaxRows(Integer.MAX_VALUE);
        this.binding.c.setSelected(true);
        l(this.datas);
    }

    public final g0 getBinding() {
        return this.binding;
    }

    public final int getInParentIndex() {
        return this.inParentIndex;
    }

    public final void setBinding(g0 g0Var) {
        Intrinsics.h(g0Var, "<set-?>");
        this.binding = g0Var;
    }

    public final void setInParentIndex(int i) {
        this.inParentIndex = i;
    }

    public final void setOnItemClickListener(Function1<? super a, Unit> onItemClickListener) {
        Intrinsics.h(onItemClickListener, "onItemClickListener");
        this.mOnItemClickListener = onItemClickListener;
    }

    public final void updateData(List<a> list) {
        Intrinsics.h(list, "list");
        this.datas = list;
        this.rowMap.clear();
        this.itemInRow.clear();
        l(list);
        i();
    }
}
