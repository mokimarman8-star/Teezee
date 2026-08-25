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
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.home.bean.ugc.UGCFilterItem;
import com.transsion.home.view.filter.expand.UGCTabExpandView;
import java.util.ArrayList;
import java.util.Iterator;
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
import u6.a;
import uf.c;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0013\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001.B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u000f¢\u0006\u0004\b\u001f\u0010\u001aJ\r\u0010 \u001a\u00020\u000f¢\u0006\u0004\b \u0010\u001aJ0\u0010%\u001a\u00020\u000f2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000f0!¢\u0006\u0004\b%\u0010&J'\u0010)\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b+\u0010,R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R(\u0010;\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010=\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\t088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010:R3\u0010@\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000f\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010AR\"\u0010I\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006K"}, d2 = {"Lcom/transsion/home/view/filter/expand/UGCTabExpandView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "Lcom/transsion/home/bean/ugc/UGCFilterItem;", "list", BuildConfig.FLAVOR, "l", "(Ljava/util/List;)V", "item", "Landroid/view/View;", "itemView", "f", "(Lcom/transsion/home/bean/ugc/UGCFilterItem;Landroid/view/View;)Landroid/view/View;", "m", "(Lcom/transsion/home/bean/ugc/UGCFilterItem;)V", "i", "()V", BuildConfig.FLAVOR, "enable", "enableExpand", "(Z)V", "collapse", "expand", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onItemClickListener", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "selectedId", "updateData", "(Ljava/util/List;Ljava/lang/String;)V", "getSelectedItem", "()Lcom/transsion/home/bean/ugc/UGCFilterItem;", "Lqk/g0;", "a", "Lqk/g0;", "getBinding", "()Lqk/g0;", "setBinding", "(Lqk/g0;)V", "binding", "b", "Ljava/util/List;", "datas", BuildConfig.FLAVOR, "c", "Ljava/util/Map;", "rowMap", "d", "itemInRow", "e", "Lkotlin/jvm/functions/Function1;", "mOnItemClickListener", "Lcom/transsion/home/bean/ugc/UGCFilterItem;", "curSelectItem", "g", "I", "getInParentIndex", "()I", "setInParentIndex", "(I)V", "inParentIndex", "Companion", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCTabExpandView extends FrameLayout {

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
    private UGCFilterItem curSelectItem;

    /* renamed from: g, reason: from kotlin metadata */
    private int inParentIndex;
    public static final int $stable = 8;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UGCTabExpandView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UGCTabExpandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCTabExpandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        g0 c = g0.c(LayoutInflater.from(getContext()), this, true);
        Intrinsics.g(c, "inflate(...)");
        this.binding = c;
        this.datas = new ArrayList();
        this.rowMap = new LinkedHashMap();
        this.itemInRow = new LinkedHashMap();
        this.inParentIndex = -1;
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: al.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCTabExpandView.e(UGCTabExpandView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(UGCTabExpandView uGCTabExpandView, View view) {
        uGCTabExpandView.binding.c.setSelected(!r2.isSelected());
        if (uGCTabExpandView.binding.c.isSelected()) {
            uGCTabExpandView.expand();
        } else {
            uGCTabExpandView.collapse();
        }
    }

    private final View f(final UGCFilterItem item, View itemView) {
        Typeface d;
        if (itemView == null) {
            itemView = a.a(this, R.layout.adapter_filter_item);
        }
        String categoryId = item.getCategoryId();
        UGCFilterItem uGCFilterItem = this.curSelectItem;
        boolean c = Intrinsics.c(categoryId, uGCFilterItem != null ? uGCFilterItem.getCategoryId() : null);
        TextView textView = (TextView) itemView.findViewById(R.id.filter_item_name);
        textView.setText(item.getNameDesc());
        if (c) {
            textView.setBackgroundResource(R$drawable.bg_selected_filter_item);
            textView.setTextColor(b.getColor(textView.getContext(), com.tn.lib.widget.R.color.text_01));
            Context context = textView.getContext();
            Intrinsics.g(context, "getContext(...)");
            d = uf.a.a(context);
        } else {
            textView.setBackgroundResource(com.tn.lib.widget.R.color.transparent);
            textView.setTextColor(b.getColor(textView.getContext(), com.tn.lib.widget.R.color.text_02));
            Context context2 = textView.getContext();
            Intrinsics.g(context2, "getContext(...)");
            d = uf.a.d(context2);
        }
        textView.setTypeface(d);
        itemView.setOnClickListener(new View.OnClickListener() { // from class: al.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCTabExpandView.h(UGCTabExpandView.this, item, view);
            }
        });
        return itemView;
    }

    static /* synthetic */ View g(UGCTabExpandView uGCTabExpandView, UGCFilterItem uGCFilterItem, View view, int i, Object obj) {
        if ((i & 2) != 0) {
            view = null;
        }
        return uGCTabExpandView.f(uGCFilterItem, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(UGCTabExpandView uGCTabExpandView, UGCFilterItem uGCFilterItem, View view) {
        uGCTabExpandView.m(uGCFilterItem);
        uGCTabExpandView.l(uGCTabExpandView.datas);
        Function1 function1 = uGCTabExpandView.mOnItemClickListener;
        if (function1 != null) {
            function1.invoke(uGCFilterItem);
        }
        wf.a.a.c("UGCTabExpandView", "item clicked: id=" + uGCFilterItem.getCategoryId() + ", name=" + uGCFilterItem.getName(), false);
    }

    private final void i() {
        this.binding.b.post(new Runnable() { // from class: al.m
            @Override // java.lang.Runnable
            public final void run() {
                UGCTabExpandView.j(UGCTabExpandView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(UGCTabExpandView uGCTabExpandView) {
        int rowsCount = uGCTabExpandView.binding.b.getRowsCount();
        int i = 0;
        for (int i2 = 0; i2 < rowsCount; i2++) {
            ArrayList arrayList = new ArrayList();
            int countInRow = uGCTabExpandView.binding.b.getCountInRow(i2);
            int i3 = 0;
            while (i3 < countInRow) {
                int i4 = i + 1;
                UGCFilterItem uGCFilterItem = (UGCFilterItem) uGCTabExpandView.datas.get(i);
                Map map = uGCTabExpandView.itemInRow;
                String categoryId = uGCFilterItem.getCategoryId();
                if (categoryId == null) {
                    categoryId = BuildConfig.FLAVOR;
                }
                map.put(categoryId, Integer.valueOf(i2));
                arrayList.add(uGCFilterItem);
                i3++;
                i = i4;
            }
            uGCTabExpandView.rowMap.put(Integer.valueOf(i2), arrayList);
        }
        if (uGCTabExpandView.rowMap.size() > 1) {
            AppCompatTextView appCompatTextView = uGCTabExpandView.binding.c;
            Intrinsics.g(appCompatTextView, "tvExpand");
            c.k(appCompatTextView);
        } else {
            AppCompatTextView appCompatTextView2 = uGCTabExpandView.binding.c;
            Intrinsics.g(appCompatTextView2, "tvExpand");
            c.h(appCompatTextView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(UGCTabExpandView uGCTabExpandView) {
        Map map = uGCTabExpandView.itemInRow;
        UGCFilterItem uGCFilterItem = uGCTabExpandView.curSelectItem;
        List list = (List) uGCTabExpandView.rowMap.get((Integer) map.get(uGCFilterItem != null ? uGCFilterItem.getCategoryId() : null));
        if (list == null) {
            list = uGCTabExpandView.datas;
        }
        uGCTabExpandView.l(list);
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
                    f((UGCFilterItem) list.get(i), childAt);
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
            UGCFilterItem uGCFilterItem = (UGCFilterItem) obj;
            View childAt2 = this.binding.b.getChildAt(i);
            if (childAt2 != null) {
                f(uGCFilterItem, childAt2);
            } else {
                this.binding.b.addView(g(this, uGCFilterItem, null, 2, null));
            }
            i = i2;
        }
    }

    private final void m(UGCFilterItem item) {
        this.curSelectItem = item;
    }

    public static /* synthetic */ void updateData$default(UGCTabExpandView uGCTabExpandView, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        uGCTabExpandView.updateData(list, str);
    }

    public final void collapse() {
        this.binding.b.setMaxRows(1);
        this.binding.c.setSelected(false);
        this.binding.b.post(new Runnable() { // from class: al.l
            @Override // java.lang.Runnable
            public final void run() {
                UGCTabExpandView.k(UGCTabExpandView.this);
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

    /* renamed from: getSelectedItem, reason: from getter */
    public final UGCFilterItem getCurSelectItem() {
        return this.curSelectItem;
    }

    public final void setBinding(g0 g0Var) {
        Intrinsics.h(g0Var, "<set-?>");
        this.binding = g0Var;
    }

    public final void setInParentIndex(int i) {
        this.inParentIndex = i;
    }

    public final void setOnItemClickListener(Function1<? super UGCFilterItem, Unit> onItemClickListener) {
        Intrinsics.h(onItemClickListener, "onItemClickListener");
        this.mOnItemClickListener = onItemClickListener;
    }

    public final void updateData(List<UGCFilterItem> list, String selectedId) {
        Object obj;
        Intrinsics.h(list, "list");
        this.datas = list;
        this.rowMap.clear();
        this.itemInRow.clear();
        if (selectedId != null) {
            Iterator it = this.datas.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.c(((UGCFilterItem) obj).getCategoryId(), selectedId)) {
                        break;
                    }
                }
            }
            UGCFilterItem uGCFilterItem = (UGCFilterItem) obj;
            if (uGCFilterItem != null) {
                this.curSelectItem = uGCFilterItem;
            }
        }
        if (this.curSelectItem == null && !this.datas.isEmpty()) {
            this.curSelectItem = (UGCFilterItem) CollectionsKt.i0(this.datas);
        }
        l(list);
        i();
        wf.a.a.c("UGCTabExpandView", "updateData: size=" + list.size() + ", selectedId=" + selectedId, false);
    }
}
