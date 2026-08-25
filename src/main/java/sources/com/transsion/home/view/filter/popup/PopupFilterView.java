package com.transsion.home.view.filter.popup;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.b0;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.e0;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.k;
import androidx.compose.runtime.q2;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.s;
import androidx.compose.runtime.snapshots.t;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.b;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.font.n;
import androidx.compose.ui.text.font.p;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.u;
import androidx.lifecycle.y0;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import cl.w;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.FilterVal;
import com.transsion.home.bean.Item;
import com.transsion.home.view.filter.popup.PopupFilterView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o0.x;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001\"B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011JG\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2(\b\u0002\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001d\u001a\u00020\u00172\u001e\u0010\u001c\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001b\u0012\u0004\u0012\u00020\u00170\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u00172\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b\u001f\u0010 R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R0\u0010'\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*²\u0006\u000e\u0010)\u001a\u00020\u00148\n@\nX\u008a\u008e\u0002"}, d2 = {"Lcom/transsion/home/view/filter/popup/PopupFilterView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "Lcom/transsion/home/bean/Item;", "filterItem", BuildConfig.FLAVOR, "m", "(Ljava/util/List;)Z", "data", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "selectItems", BuildConfig.FLAVOR, "initSelectData", "(Ljava/util/List;Ljava/util/HashMap;)V", "Lkotlin/Function1;", BuildConfig.FLAVOR, "callback", "setOnFilterListener", "(Lkotlin/jvm/functions/Function1;)V", "FilterLinear", "(Ljava/util/List;Landroidx/compose/runtime/i;I)V", "Landroidx/compose/runtime/snapshots/t;", "a", "Landroidx/compose/runtime/snapshots/t;", "selectItemsMap", "b", "Lkotlin/jvm/functions/Function1;", "onFilterChangedListener", "Companion", "currentPopup", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PopupFilterView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final t selectItemsMap;

    /* renamed from: b, reason: from kotlin metadata */
    private Function1 onFilterChangedListener;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: com.transsion.home.view.filter.popup.PopupFilterView$a, reason: from kotlin metadata */
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

    static final class b implements Function2 {
        final /* synthetic */ List b;

        b(List list) {
            this.b = list;
        }

        public final void a(i iVar, int i) {
            if ((i & 3) == 2 && iVar.h()) {
                iVar.G();
                return;
            }
            if (k.H()) {
                k.Q(486758898, i, -1, "com.transsion.home.view.filter.popup.PopupFilterView.initSelectData.<anonymous>.<anonymous> (PopupFilterView.kt:93)");
            }
            PopupFilterView.this.FilterLinear(this.b, iVar, 0);
            if (k.H()) {
                k.P();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((i) obj, ((Number) obj2).intValue());
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupFilterView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.selectItemsMap = new t();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        Intrinsics.h(attributeSet, "attrs");
        this.selectItemsMap = new t();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        Intrinsics.h(attributeSet, "attrs");
        this.selectItemsMap = new t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(PopupFilterView popupFilterView, Item item, i1 i1Var, String str) {
        if (str != null) {
            popupFilterView.selectItemsMap.put(item.getFilterType(), str);
            Function1 function1 = popupFilterView.onFilterChangedListener;
            if (function1 != null) {
                function1.invoke(popupFilterView.selectItemsMap.l());
            }
        }
        l(i1Var, BuildConfig.FLAVOR);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Item item, i1 i1Var) {
        l(i1Var, item.getFilterType());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(i1 i1Var) {
        l(i1Var, "multi");
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(PopupFilterView popupFilterView, i1 i1Var, boolean z) {
        Function1 function1;
        l(i1Var, BuildConfig.FLAVOR);
        if (z && (function1 = popupFilterView.onFilterChangedListener) != null) {
            function1.invoke(popupFilterView.selectItemsMap.l());
        }
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initSelectData$default(PopupFilterView popupFilterView, List list, HashMap hashMap, int i, Object obj) {
        if ((i & 2) != 0) {
            hashMap = null;
        }
        popupFilterView.initSelectData(list, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(PopupFilterView popupFilterView, List list, int i, i iVar, int i2) {
        popupFilterView.FilterLinear(list, iVar, v1.a(i | 1));
        return Unit.a;
    }

    private static final String k(i1 i1Var) {
        return (String) i1Var.getValue();
    }

    private static final void l(i1 i1Var, String str) {
        i1Var.setValue(str);
    }

    private final boolean m(List filterItem) {
        if (filterItem != null) {
            Iterator it = filterItem.iterator();
            while (it.hasNext()) {
                Item item = (Item) it.next();
                String str = (String) this.selectItemsMap.get(item.getFilterType());
                if (item.getRangeVals() == null && Intrinsics.c(item.getShowOut(), "false")) {
                    if (str != null && !Intrinsics.c(str, item.getFilterValsV2().get(0).getId())) {
                        return true;
                    }
                } else if (item.getRangeVals() != null) {
                    String a = INSTANCE.a(item.getRangeVals().getMinVal(), item.getRangeVals().getMaxVal());
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

    /* JADX WARN: Code restructure failed: missing block: B:149:0x0315, code lost:
    
        if (r10 == androidx.compose.runtime.i.a.a()) goto L115;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void FilterLinear(final List<Item> list, i iVar, final int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i2;
        i iVar2;
        ArrayList arrayList3;
        final i1 i1Var;
        int i3;
        long a;
        long a2;
        Object obj;
        Object obj2;
        String name;
        long a3;
        int i4 = 1;
        i g = iVar.g(541655127);
        int i5 = (i & 6) == 0 ? (g.A(list) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i5 |= g.A(this) ? 32 : 16;
        }
        if ((i5 & 19) == 18 && g.h()) {
            g.G();
            iVar2 = g;
        } else {
            if (k.H()) {
                k.Q(541655127, i5, -1, "com.transsion.home.view.filter.popup.PopupFilterView.FilterLinear (PopupFilterView.kt:127)");
            }
            if (list != null) {
                arrayList = new ArrayList();
                for (Object obj3 : list) {
                    Item item = (Item) obj3;
                    if (Intrinsics.c(item.getShowOut(), "true") && item.getRangeVals() == null) {
                        arrayList.add(obj3);
                    }
                }
            } else {
                arrayList = null;
            }
            if (list != null) {
                arrayList2 = new ArrayList();
                for (Object obj4 : list) {
                    if (Intrinsics.c(((Item) obj4).getShowOut(), "false")) {
                        arrayList2.add(obj4);
                    }
                }
            } else {
                arrayList2 = new ArrayList();
            }
            ArrayList arrayList4 = arrayList2;
            Iterator it = arrayList4.iterator();
            while (true) {
                i2 = 0;
                if (!it.hasNext()) {
                    break;
                }
                Item item2 = (Item) it.next();
                if (!item2.getFilterValsV2().isEmpty() && this.selectItemsMap.get(item2.getFilterType()) == null) {
                    this.selectItemsMap.put(item2.getFilterType(), item2.getFilterValsV2().get(0).getId());
                }
            }
            g.P(1849434622);
            Object y = g.y();
            if (y == i.a.a()) {
                y = r2.f(BuildConfig.FLAVOR, (q2) null, 2, (Object) null);
                g.p(y);
            }
            final i1 i1Var2 = (i1) y;
            g.K();
            f p = SizeKt.p(SizeKt.d(f.a, 0.0f, 1, (Object) null), (b.c) null, false, 3, (Object) null);
            androidx.compose.ui.layout.t b2 = a0.b(androidx.compose.foundation.layout.b.a.c(), androidx.compose.ui.b.a.h(), g, 48);
            int a4 = g.a(g, 0);
            s n = g.n();
            f e = ComposedModifierKt.e(g, p);
            ComposeUiNode.Companion companion = ComposeUiNode.c1;
            Function0 a5 = companion.a();
            if (!(g.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            g.C();
            if (g.e()) {
                g.F(a5);
            } else {
                g.o();
            }
            i a6 = f3.a(g);
            f3.b(a6, b2, companion.c());
            f3.b(a6, n, companion.e());
            Function2 b3 = companion.b();
            if (a6.e() || !Intrinsics.c(a6.y(), Integer.valueOf(a4))) {
                a6.p(Integer.valueOf(a4));
                a6.k(Integer.valueOf(a4), b3);
            }
            f3.b(a6, e, companion.d());
            d0 d0Var = d0.a;
            float size = 2 + ((((Configuration) g.l(AndroidCompositionLocals_androidKt.f())).screenWidthDp - ((r5 * 46) + 52.0f)) / (arrayList != null ? arrayList.size() : 1));
            g.P(-1055580859);
            if (arrayList == null) {
                iVar2 = g;
                arrayList3 = arrayList4;
                i1Var = i1Var2;
                i3 = 0;
            } else {
                int i6 = 0;
                for (Object obj5 : arrayList) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.u();
                    }
                    final Item item3 = (Item) obj5;
                    String str = (String) this.selectItemsMap.get(item3.getFilterType());
                    if (str == null) {
                        str = item3.getFilterValsV2().get(i2).getId();
                    }
                    if (Intrinsics.c(str, item3.getFilterValsV2().get(i2).getId())) {
                        g.P(-1987907022);
                        a = i0.b.a(R.color.text_03, g, i2);
                        a2 = i0.b.a(R.color.transparent, g, i2);
                        str = item3.getTitle();
                        g.K();
                    } else {
                        g.P(-1988249107);
                        a = i0.b.a(R.color.white, g, i2);
                        a2 = i0.b.a(com.transsion.wrapperad.R.color.white_40, g, i2);
                        Iterator<T> it2 = item3.getFilterValsV2().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                obj2 = it2.next();
                                if (Intrinsics.c(((FilterVal) obj2).getId(), str)) {
                                    break;
                                }
                            } else {
                                obj2 = null;
                                break;
                            }
                        }
                        FilterVal filterVal = (FilterVal) obj2;
                        if (filterVal != null && (name = filterVal.getName()) != null) {
                            str = name;
                        }
                        g.K();
                    }
                    String str2 = str;
                    long j = a2;
                    g.P(-1055550993);
                    if (Intrinsics.c(k(i1Var2), item3.getFilterType())) {
                        g.P(-1746271574);
                        boolean A = g.A(this) | g.A(item3);
                        Object y2 = g.y();
                        if (A || y2 == i.a.a()) {
                            y2 = new Function1() { // from class: cl.k
                                public final Object invoke(Object obj6) {
                                    Unit f;
                                    f = PopupFilterView.f(PopupFilterView.this, item3, i1Var2, (String) obj6);
                                    return f;
                                }
                            };
                            g.p(y2);
                        }
                        g.K();
                        w.e(item3, str2, (Function1) y2, g, i2);
                    }
                    g.K();
                    b.c h = androidx.compose.ui.b.a.h();
                    f.a aVar = f.a;
                    float f = i4;
                    ArrayList arrayList5 = arrayList4;
                    float f2 = 100;
                    f a7 = BackgroundKt.a(BorderKt.e(SizeKt.e(aVar, o0.i.g(28)), o0.i.g(f), a, q.g.c(o0.i.g(f2))), j, q.g.c(o0.i.g(f2)));
                    g.P(-1633490746);
                    boolean A2 = g.A(item3);
                    Object y3 = g.y();
                    if (!A2) {
                        obj = y3;
                    }
                    Function0 function0 = new Function0() { // from class: cl.l
                        public final Object invoke() {
                            Unit g2;
                            g2 = PopupFilterView.g(Item.this, i1Var2);
                            return g2;
                        }
                    };
                    g.p(function0);
                    obj = function0;
                    g.K();
                    f d = ClickableKt.d(a7, false, (String) null, (androidx.compose.ui.semantics.f) null, (Function0) obj, 7, (Object) null);
                    androidx.compose.ui.layout.t b4 = a0.b(androidx.compose.foundation.layout.b.a.c(), h, g, 48);
                    int a8 = g.a(g, 0);
                    s n2 = g.n();
                    f e2 = ComposedModifierKt.e(g, d);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.c1;
                    Function0 a9 = companion2.a();
                    if (!(g.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    g.C();
                    if (g.e()) {
                        g.F(a9);
                    } else {
                        g.o();
                    }
                    i a10 = f3.a(g);
                    f3.b(a10, b4, companion2.c());
                    f3.b(a10, n2, companion2.e());
                    Function2 b5 = companion2.b();
                    if (a10.e() || !Intrinsics.c(a10.y(), Integer.valueOf(a8))) {
                        a10.p(Integer.valueOf(a8));
                        a10.k(Integer.valueOf(a8), b5);
                    }
                    f3.b(a10, e2, companion2.d());
                    d0 d0Var2 = d0.a;
                    e0.a(SizeKt.l(aVar, o0.i.g(12)), g, 6);
                    i iVar3 = g;
                    TextKt.a(str2, SizeKt.n(aVar, 0.0f, o0.i.g(size), 1, (Object) null), i0.b.a(R.color.white, g, 0), x.c(14), (n) null, p.b.c(), h.b.b(), 0L, (androidx.compose.ui.text.style.i) null, (androidx.compose.ui.text.style.h) null, 0L, androidx.compose.ui.text.style.p.a.b(), false, 1, 0, (Function1) null, (androidx.compose.ui.text.d0) null, iVar3, 199680, 3120, 120720);
                    IconKt.a(i0.e.c(com.transsion.baseui.R.drawable.ic_arrow_down, iVar3, 0), "open", PaddingKt.i(SizeKt.e(SizeKt.l(aVar, o0.i.g(16)), o0.i.g(17)), 0.0f, o0.i.g(f), 0.0f, 0.0f, 13, (Object) null), i0.b.a(R.color.white, iVar3, 0), iVar3, 432, 0);
                    e0.a(SizeKt.l(aVar, o0.i.g(10)), iVar3, 6);
                    iVar3.r();
                    e0.a(SizeKt.l(aVar, o0.i.g(8)), iVar3, 6);
                    i1Var2 = i1Var2;
                    g = iVar3;
                    i2 = 0;
                    arrayList4 = arrayList5;
                    i6 = i7;
                    size = size;
                    i4 = 1;
                }
                iVar2 = g;
                arrayList3 = arrayList4;
                i1Var = i1Var2;
                i3 = i2;
                Unit unit = Unit.a;
            }
            iVar2.K();
            f.a aVar2 = f.a;
            e0.a(b0.a(d0Var, SizeKt.l(aVar2, o0.i.g(i3)), 1.0f, false, 2, (Object) null), iVar2, i3);
            iVar2.P(-1055474072);
            if (!arrayList3.isEmpty()) {
                if (m(list)) {
                    iVar2.P(1640111020);
                    a3 = i0.b.a(R.color.brand, iVar2, i3);
                    iVar2.K();
                } else {
                    iVar2.P(1640207244);
                    a3 = i0.b.a(R.color.white, iVar2, i3);
                    iVar2.K();
                }
                long j2 = a3;
                Painter c = i0.e.c(com.transsion.home.R.mipmap.ic_sub_operation_filter, iVar2, i3);
                float f3 = 24;
                f e3 = SizeKt.e(SizeKt.l(aVar2, o0.i.g(f3)), o0.i.g(f3));
                iVar2.P(5004770);
                Object y4 = iVar2.y();
                if (y4 == i.a.a()) {
                    y4 = new Function0() { // from class: cl.m
                        public final Object invoke() {
                            Unit h2;
                            h2 = PopupFilterView.h(i1Var);
                            return h2;
                        }
                    };
                    iVar2.p(y4);
                }
                iVar2.K();
                IconKt.a(c, "filter", ClickableKt.d(e3, false, (String) null, (androidx.compose.ui.semantics.f) null, (Function0) y4, 7, (Object) null), j2, iVar2, 48, 0);
            }
            iVar2.K();
            iVar2.P(-1055450448);
            if (Intrinsics.c(k(i1Var), "multi")) {
                t tVar = this.selectItemsMap;
                iVar2.P(-1633490746);
                boolean A3 = iVar2.A(this);
                Object y5 = iVar2.y();
                if (A3 || y5 == i.a.a()) {
                    y5 = new Function1() { // from class: cl.n
                        public final Object invoke(Object obj6) {
                            Unit i8;
                            i8 = PopupFilterView.i(PopupFilterView.this, i1Var, ((Boolean) obj6).booleanValue());
                            return i8;
                        }
                    };
                    iVar2.p(y5);
                }
                iVar2.K();
                e.p(arrayList3, tVar, (Function1) y5, iVar2, i3);
            }
            iVar2.K();
            iVar2.r();
            if (k.H()) {
                k.P();
            }
        }
        g2 j3 = iVar2.j();
        if (j3 != null) {
            j3.a(new Function2() { // from class: cl.o
                public final Object invoke(Object obj6, Object obj7) {
                    Unit j4;
                    j4 = PopupFilterView.j(PopupFilterView.this, list, i, (androidx.compose.runtime.i) obj6, ((Integer) obj7).intValue());
                    return j4;
                }
            });
        }
    }

    public final void initSelectData(List<Item> data, HashMap<String, String> selectItems) {
        List<Item> list = data;
        if (list == null || list.isEmpty()) {
            uf.c.g(this);
        } else {
            uf.c.k(this);
        }
        removeAllViews();
        this.selectItemsMap.clear();
        if (selectItems != null) {
            this.selectItemsMap.putAll(selectItems);
        }
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        u context2 = composeView.getContext();
        ViewTreeLifecycleOwner.b(composeView, context2 instanceof u ? context2 : null);
        y0 context3 = composeView.getContext();
        ViewTreeViewModelStoreOwner.b(composeView, context3 instanceof y0 ? context3 : null);
        Context context4 = composeView.getContext();
        ViewTreeSavedStateRegistryOwner.b(composeView, context4 instanceof androidx.savedstate.e ? (androidx.savedstate.e) context4 : null);
        composeView.setContent(androidx.compose.runtime.internal.b.b(486758898, true, new b(data)));
        addView(composeView);
    }

    public final void setOnFilterListener(Function1<? super Map<String, String>, Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.onFilterChangedListener = callback;
    }
}
