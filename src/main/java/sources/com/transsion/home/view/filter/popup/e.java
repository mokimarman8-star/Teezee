package com.transsion.home.view.filter.popup;

import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.b0;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.e0;
import androidx.compose.foundation.layout.j;
import androidx.compose.foundation.layout.l;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.u;
import androidx.compose.material.DividerKt;
import androidx.compose.material.SliderKt;
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
import androidx.compose.ui.graphics.a5;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.font.n;
import androidx.compose.ui.text.font.p;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import com.blankj.utilcode.util.f0;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.transsion.home.R;
import com.transsion.home.bean.FilterVal;
import com.transsion.home.bean.Item;
import com.transsion.home.bean.RangeValue;
import com.transsion.home.view.filter.popup.e;
import i0.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import o0.x;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class e {
    private static float a;
    private static float b;
    private static boolean c;

    static final class a implements Function2 {
        final /* synthetic */ long a;
        final /* synthetic */ List b;
        final /* synthetic */ t c;
        final /* synthetic */ Function1 d;
        final /* synthetic */ t e;

        /* renamed from: com.transsion.home.view.filter.popup.e$a$a, reason: collision with other inner class name */
        static final class C0034a implements Function3 {
            final /* synthetic */ Item a;
            final /* synthetic */ t b;

            C0034a(Item item, t tVar) {
                this.a = item;
                this.b = tVar;
            }

            public final void a(androidx.compose.foundation.lazy.b bVar, i iVar, int i) {
                Intrinsics.h(bVar, "$this$item");
                if ((i & 17) == 16 && iVar.h()) {
                    iVar.G();
                    return;
                }
                if (k.H()) {
                    k.Q(807301957, i, -1, "com.transsion.home.view.filter.popup.MultiFilterPopup.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiFilterPopupWindow.kt:137)");
                }
                e.k(this.a, this.b, iVar, 0);
                if (k.H()) {
                    k.P();
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                a((androidx.compose.foundation.lazy.b) obj, (i) obj2, ((Number) obj3).intValue());
                return Unit.a;
            }
        }

        a(long j, List list, t tVar, Function1 function1, t tVar2) {
            this.a = j;
            this.b = list;
            this.c = tVar;
            this.d = function1;
            this.e = tVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f(t tVar, t tVar2, Function1 function1) {
            function1.invoke(Boolean.valueOf(e.D(tVar, tVar2)));
            return Unit.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(List list, t tVar) {
            e.E(list, tVar);
            return Unit.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(Function1 function1) {
            function1.invoke(Boolean.FALSE);
            return Unit.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit i(List list, t tVar, u uVar) {
            Intrinsics.h(uVar, "$this$LazyColumn");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Item item = (Item) it.next();
                androidx.compose.foundation.lazy.t.a(uVar, item.getFilterType(), (Object) null, androidx.compose.runtime.internal.b.b(807301957, true, new C0034a(item, tVar)), 2, (Object) null);
            }
            return Unit.a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x027b, code lost:
        
            if (r3 == androidx.compose.runtime.i.a.a()) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0302, code lost:
        
            if (r3 == androidx.compose.runtime.i.a.a()) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0429, code lost:
        
            if (r8 == androidx.compose.runtime.i.a.a()) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0576, code lost:
        
            if (r6 == androidx.compose.runtime.i.a.a()) goto L90;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(i iVar, int i) {
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            if ((i & 3) == 2 && iVar.h()) {
                iVar.G();
                return;
            }
            if (k.H()) {
                k.Q(-1419240635, i, -1, "com.transsion.home.view.filter.popup.MultiFilterPopup.<anonymous> (MultiFilterPopupWindow.kt:86)");
            }
            f.a aVar = f.a;
            f b = SizeKt.b(BackgroundKt.b(aVar, this.a, (a5) null, 2, (Object) null), 0.0f, 1, (Object) null);
            final List list = this.b;
            final t tVar = this.c;
            final Function1 function1 = this.d;
            final t tVar2 = this.e;
            b.a aVar2 = androidx.compose.ui.b.a;
            androidx.compose.ui.layout.t h = BoxKt.h(aVar2.m(), false);
            int a = g.a(iVar, 0);
            s n = iVar.n();
            f e = ComposedModifierKt.e(iVar, b);
            ComposeUiNode.Companion companion = ComposeUiNode.c1;
            Function0 a2 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a2);
            } else {
                iVar.o();
            }
            i a3 = f3.a(iVar);
            f3.b(a3, h, companion.c());
            f3.b(a3, n, companion.e());
            Function2 b2 = companion.b();
            if (a3.e() || !Intrinsics.c(a3.y(), Integer.valueOf(a))) {
                a3.p(Integer.valueOf(a));
                a3.k(Integer.valueOf(a), b2);
            }
            f3.b(a3, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            androidx.compose.foundation.layout.b bVar = androidx.compose.foundation.layout.b.a;
            androidx.compose.ui.layout.t a4 = androidx.compose.foundation.layout.i.a(bVar.d(), aVar2.i(), iVar, 0);
            int a5 = g.a(iVar, 0);
            s n2 = iVar.n();
            f e2 = ComposedModifierKt.e(iVar, aVar);
            Function0 a6 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a6);
            } else {
                iVar.o();
            }
            i a7 = f3.a(iVar);
            f3.b(a7, a4, companion.c());
            f3.b(a7, n2, companion.e());
            Function2 b3 = companion.b();
            if (a7.e() || !Intrinsics.c(a7.y(), Integer.valueOf(a5))) {
                a7.p(Integer.valueOf(a5));
                a7.k(Integer.valueOf(a5), b3);
            }
            f3.b(a7, e2, companion.d());
            l lVar = l.a;
            float f = 12;
            float f2 = 16;
            f f3 = PaddingKt.f(aVar, o0.i.g(f2), o0.i.g(f));
            androidx.compose.ui.layout.t b4 = a0.b(bVar.c(), aVar2.j(), iVar, 0);
            int a8 = g.a(iVar, 0);
            s n3 = iVar.n();
            f e3 = ComposedModifierKt.e(iVar, f3);
            Function0 a9 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a9);
            } else {
                iVar.o();
            }
            i a10 = f3.a(iVar);
            f3.b(a10, b4, companion.c());
            f3.b(a10, n3, companion.e());
            Function2 b5 = companion.b();
            if (a10.e() || !Intrinsics.c(a10.y(), Integer.valueOf(a8))) {
                a10.p(Integer.valueOf(a8));
                a10.k(Integer.valueOf(a8), b5);
            }
            f3.b(a10, e3, companion.d());
            d0 d0Var = d0.a;
            String a11 = h.a(R.string.filter_more_title, iVar, 0);
            h.a aVar3 = androidx.compose.ui.text.font.h.b;
            androidx.compose.ui.text.font.s b6 = aVar3.b();
            p.a aVar4 = p.b;
            p e4 = aVar4.e();
            int b7 = androidx.compose.ui.text.style.p.a.b();
            TextKt.a(a11, b0.a(d0Var, SizeKt.l(aVar, o0.i.g(0)), 1.0f, false, 2, (Object) null), u1.b.f(), x.c(18), (n) null, e4, b6, 0L, (androidx.compose.ui.text.style.i) null, (androidx.compose.ui.text.style.h) null, 0L, b7, false, 0, 0, (Function1) null, (androidx.compose.ui.text.d0) null, iVar, 200064, 48, 128912);
            e0.a(SizeKt.l(aVar, o0.i.g(f)), iVar, 6);
            Painter c = i0.e.c(com.transsion.videodetail.R.drawable.music_iv_close, iVar, 0);
            long a12 = i0.b.a(com.tn.lib.widget.R.color.white, iVar, 0);
            float f4 = 21;
            f e5 = SizeKt.e(SizeKt.l(aVar, o0.i.g(f4)), o0.i.g(f4));
            iVar.P(5004770);
            boolean O = iVar.O(function1);
            Object y = iVar.y();
            if (!O) {
                obj = y;
            }
            Function0 function0 = new Function0() { // from class: com.transsion.home.view.filter.popup.a
                public final Object invoke() {
                    Unit h2;
                    h2 = e.a.h(function1);
                    return h2;
                }
            };
            iVar.p(function0);
            obj = function0;
            iVar.K();
            IconKt.a(c, "open", ClickableKt.d(e5, false, (String) null, (androidx.compose.ui.semantics.f) null, (Function0) obj, 7, (Object) null), a12, iVar, 48, 0);
            iVar.r();
            float f5 = 1;
            DividerKt.a((f) null, i0.b.a(com.tn.lib.widget.R.color.white_10, iVar, 0), o0.i.g(f5), 0.0f, iVar, 384, 9);
            e0.a(SizeKt.e(aVar, o0.i.g(f)), iVar, 6);
            f d = SizeKt.d(PaddingKt.g(j.a(lVar, aVar, 1.0f, false, 2, (Object) null), o0.i.g(f2), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null);
            iVar.P(-1633490746);
            boolean A = iVar.A(list) | iVar.O(tVar);
            Object y2 = iVar.y();
            if (!A) {
                obj2 = y2;
            }
            Function1 function12 = new Function1() { // from class: com.transsion.home.view.filter.popup.b
                public final Object invoke(Object obj5) {
                    Unit i2;
                    i2 = e.a.i(list, tVar, (u) obj5);
                    return i2;
                }
            };
            iVar.p(function12);
            obj2 = function12;
            iVar.K();
            LazyDslKt.a(d, (LazyListState) null, (androidx.compose.foundation.layout.t) null, false, (b.k) null, (b.b) null, (androidx.compose.foundation.gestures.g) null, false, (Function1) obj2, iVar, 0, 254);
            DividerKt.a((f) null, i0.b.a(com.tn.lib.widget.R.color.white_10, iVar, 0), o0.i.g(f5), 0.0f, iVar, 384, 9);
            e0.a(SizeKt.e(aVar, o0.i.g(f)), iVar, 6);
            f g = PaddingKt.g(aVar, o0.i.g(f2), 0.0f, 2, (Object) null);
            androidx.compose.ui.layout.t b8 = a0.b(bVar.c(), aVar2.j(), iVar, 0);
            int a13 = g.a(iVar, 0);
            s n4 = iVar.n();
            f e6 = ComposedModifierKt.e(iVar, g);
            Function0 a14 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a14);
            } else {
                iVar.o();
            }
            i a15 = f3.a(iVar);
            f3.b(a15, b8, companion.c());
            f3.b(a15, n4, companion.e());
            Function2 b9 = companion.b();
            if (a15.e() || !Intrinsics.c(a15.y(), Integer.valueOf(a13))) {
                a15.p(Integer.valueOf(a13));
                a15.k(Integer.valueOf(a13), b9);
            }
            f3.b(a15, e6, companion.d());
            b.b f6 = aVar2.f();
            b.e b10 = bVar.b();
            float f7 = 48;
            float f8 = 100;
            f e7 = BorderKt.e(SizeKt.e(aVar, o0.i.g(f7)), o0.i.g(f5), i0.b.a(com.tn.lib.widget.R.color.white, iVar, 0), q.g.c(o0.i.g(f8)));
            iVar.P(-1633490746);
            boolean A2 = iVar.A(list) | iVar.O(tVar);
            Object y3 = iVar.y();
            if (!A2) {
                obj3 = y3;
            }
            Function0 function02 = new Function0() { // from class: com.transsion.home.view.filter.popup.c
                public final Object invoke() {
                    Unit g2;
                    g2 = e.a.g(list, tVar);
                    return g2;
                }
            };
            iVar.p(function02);
            obj3 = function02;
            iVar.K();
            f d2 = ClickableKt.d(e7, false, (String) null, (androidx.compose.ui.semantics.f) null, (Function0) obj3, 7, (Object) null);
            androidx.compose.ui.layout.t a16 = androidx.compose.foundation.layout.i.a(b10, f6, iVar, 54);
            int a17 = g.a(iVar, 0);
            s n5 = iVar.n();
            f e8 = ComposedModifierKt.e(iVar, d2);
            Function0 a18 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a18);
            } else {
                iVar.o();
            }
            i a19 = f3.a(iVar);
            f3.b(a19, a16, companion.c());
            f3.b(a19, n5, companion.e());
            Function2 b11 = companion.b();
            if (a19.e() || !Intrinsics.c(a19.y(), Integer.valueOf(a17))) {
                a19.p(Integer.valueOf(a17));
                a19.k(Integer.valueOf(a17), b11);
            }
            f3.b(a19, e8, companion.d());
            String a20 = i0.h.a(R.string.filter_reset, iVar, 0);
            long c2 = x.c(18);
            androidx.compose.ui.text.font.s b12 = aVar3.b();
            TextKt.a(a20, PaddingKt.g(aVar, o0.i.g(24), 0.0f, 2, (Object) null), i0.b.a(com.tn.lib.widget.R.color.white, iVar, 0), c2, (n) null, aVar4.e(), b12, 0L, (androidx.compose.ui.text.style.i) null, (androidx.compose.ui.text.style.h) null, 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.d0) null, iVar, 199728, 0, 130960);
            iVar.r();
            e0.a(SizeKt.l(aVar, o0.i.g(f)), iVar, 6);
            b.b f9 = aVar2.f();
            b.e b13 = bVar.b();
            f a21 = BackgroundKt.a(b0.a(d0Var, SizeKt.e(aVar, o0.i.g(f7)), 1.0f, false, 2, (Object) null), i0.b.a(com.tn.lib.widget.R.color.white, iVar, 0), q.g.c(o0.i.g(f8)));
            iVar.P(-1746271574);
            boolean O2 = iVar.O(tVar2) | iVar.O(tVar) | iVar.O(function1);
            Object y4 = iVar.y();
            if (!O2) {
                obj4 = y4;
            }
            Function0 function03 = new Function0() { // from class: com.transsion.home.view.filter.popup.d
                public final Object invoke() {
                    Unit f10;
                    f10 = e.a.f(tVar2, tVar, function1);
                    return f10;
                }
            };
            iVar.p(function03);
            obj4 = function03;
            iVar.K();
            f d3 = ClickableKt.d(a21, false, (String) null, (androidx.compose.ui.semantics.f) null, (Function0) obj4, 7, (Object) null);
            androidx.compose.ui.layout.t a22 = androidx.compose.foundation.layout.i.a(b13, f9, iVar, 54);
            int a23 = g.a(iVar, 0);
            s n6 = iVar.n();
            f e9 = ComposedModifierKt.e(iVar, d3);
            Function0 a24 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a24);
            } else {
                iVar.o();
            }
            i a25 = f3.a(iVar);
            f3.b(a25, a22, companion.c());
            f3.b(a25, n6, companion.e());
            Function2 b14 = companion.b();
            if (a25.e() || !Intrinsics.c(a25.y(), Integer.valueOf(a23))) {
                a25.p(Integer.valueOf(a23));
                a25.k(Integer.valueOf(a23), b14);
            }
            f3.b(a25, e9, companion.d());
            TextKt.a(i0.h.a(R.string.filter_confirm, iVar, 0), (f) null, i0.b.a(com.tn.lib.widget.R.color.black, iVar, 0), x.c(18), (n) null, aVar4.e(), aVar3.b(), 0L, (androidx.compose.ui.text.style.i) null, (androidx.compose.ui.text.style.h) null, 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.d0) null, iVar, 199680, 0, 130962);
            iVar.r();
            iVar.r();
            e0.a(SizeKt.e(aVar, o0.i.g(f)), iVar, 6);
            iVar.r();
            iVar.r();
            if (k.H()) {
                k.P();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            e((i) obj, ((Number) obj2).intValue());
            return Unit.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(t tVar, t tVar2) {
        boolean z = false;
        for (Map.Entry entry : tVar2.entrySet()) {
            if (!Intrinsics.c(tVar.get(entry.getKey()), entry.getValue())) {
                tVar.put(entry.getKey(), entry.getValue());
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(List list, t tVar) {
        c = true;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Item item = (Item) it.next();
            if (item.getRangeVals() != null) {
                tVar.put(item.getFilterType(), PopupFilterView.INSTANCE.a(item.getRangeVals().getMinVal(), item.getRangeVals().getMaxVal()));
            } else if (!item.getFilterValsV2().isEmpty()) {
                tVar.put(item.getFilterType(), item.getFilterValsV2().get(0).getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final Item item, final t tVar, i iVar, final int i) {
        i iVar2;
        int i2;
        i g = iVar.g(1506355035);
        int i3 = (i & 6) == 0 ? (g.A(item) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i3 |= g.O(tVar) ? 32 : 16;
        }
        int i4 = i3;
        if ((i4 & 19) == 18 && g.h()) {
            g.G();
            iVar2 = g;
        } else {
            if (k.H()) {
                k.Q(1506355035, i4, -1, "com.transsion.home.view.filter.popup.FilterItemView (MultiFilterPopupWindow.kt:242)");
            }
            f.a aVar = f.a;
            androidx.compose.ui.layout.t a2 = androidx.compose.foundation.layout.i.a(androidx.compose.foundation.layout.b.a.d(), androidx.compose.ui.b.a.i(), g, 0);
            int a3 = g.a(g, 0);
            s n = g.n();
            f e = ComposedModifierKt.e(g, aVar);
            ComposeUiNode.Companion companion = ComposeUiNode.c1;
            Function0 a4 = companion.a();
            if (!(g.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            g.C();
            if (g.e()) {
                g.F(a4);
            } else {
                g.o();
            }
            i a5 = f3.a(g);
            f3.b(a5, a2, companion.c());
            f3.b(a5, n, companion.e());
            Function2 b2 = companion.b();
            if (a5.e() || !Intrinsics.c(a5.y(), Integer.valueOf(a3))) {
                a5.p(Integer.valueOf(a3));
                a5.k(Integer.valueOf(a3), b2);
            }
            f3.b(a5, e, companion.d());
            l lVar = l.a;
            int i5 = 0;
            TextKt.a(item.getTitle(), (f) null, i0.b.a(com.tn.lib.widget.R.color.white, g, 0), x.c(16), (n) null, p.b.c(), androidx.compose.ui.text.font.h.b.b(), 0L, (androidx.compose.ui.text.style.i) null, (androidx.compose.ui.text.style.h) null, 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.d0) null, g, 199680, 0, 130962);
            if (item.getRangeVals() == null) {
                g.P(727601012);
                int i6 = (((Configuration) g.l(AndroidCompositionLocals_androidKt.f())).screenWidthDp - 44) / 2;
                for (List<FilterVal> list : CollectionsKt.a0(item.getFilterValsV2(), 2)) {
                    f i7 = PaddingKt.i(SizeKt.d(f.a, 0.0f, 1, (Object) null), 0.0f, o0.i.g(12), 0.0f, 0.0f, 13, (Object) null);
                    androidx.compose.ui.layout.t b3 = a0.b(androidx.compose.foundation.layout.b.a.c(), androidx.compose.ui.b.a.j(), g, i5);
                    int a6 = g.a(g, i5);
                    s n2 = g.n();
                    f e2 = ComposedModifierKt.e(g, i7);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.c1;
                    Function0 a7 = companion2.a();
                    if (!(g.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    g.C();
                    if (g.e()) {
                        g.F(a7);
                    } else {
                        g.o();
                    }
                    i a8 = f3.a(g);
                    f3.b(a8, b3, companion2.c());
                    f3.b(a8, n2, companion2.e());
                    Function2 b4 = companion2.b();
                    if (a8.e() || !Intrinsics.c(a8.y(), Integer.valueOf(a6))) {
                        a8.p(Integer.valueOf(a6));
                        a8.k(Integer.valueOf(a6), b4);
                    }
                    f3.b(a8, e2, companion2.d());
                    d0 d0Var = d0.a;
                    g.P(-1743407500);
                    for (FilterVal filterVal : list) {
                        f.a aVar2 = f.a;
                        int i8 = i6;
                        int i9 = i4;
                        i iVar3 = g;
                        m(item, filterVal, tVar, SizeKt.l(aVar2, o0.i.g(i6)), g, (i4 & 14) | ((i4 << 3) & 896));
                        iVar3.P(-1743402035);
                        if (Intrinsics.c(filterVal, CollectionsKt.u0(list))) {
                            i2 = 0;
                        } else {
                            i2 = 0;
                            e0.a(b0.a(d0Var, aVar2, 1.0f, false, 2, (Object) null), iVar3, 0);
                        }
                        iVar3.K();
                        i5 = i2;
                        g = iVar3;
                        i6 = i8;
                        i4 = i9;
                    }
                    int i10 = i6;
                    i iVar4 = g;
                    iVar4.K();
                    iVar4.r();
                    i6 = i10;
                }
                iVar2 = g;
                iVar2.K();
            } else {
                iVar2 = g;
                iVar2.P(728374648);
                u(item, tVar, iVar2, i4 & 126);
                iVar2.K();
            }
            e0.a(SizeKt.e(f.a, o0.i.g(32)), iVar2, 6);
            iVar2.r();
            if (k.H()) {
                k.P();
            }
        }
        g2 j = iVar2.j();
        if (j != null) {
            j.a(new Function2() { // from class: cl.e
                public final Object invoke(Object obj, Object obj2) {
                    Unit l;
                    l = com.transsion.home.view.filter.popup.e.l(Item.this, tVar, i, (androidx.compose.runtime.i) obj, ((Integer) obj2).intValue());
                    return l;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Item item, t tVar, int i, i iVar, int i2) {
        k(item, tVar, iVar, v1.a(i | 1));
        return Unit.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x010e, code lost:
    
        if (r7 == androidx.compose.runtime.i.a.a()) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m(final Item item, final FilterVal filterVal, final t tVar, final f fVar, i iVar, final int i) {
        int i2;
        long a2;
        long a3;
        Object obj;
        i iVar2;
        i g = iVar.g(973616320);
        if ((i & 6) == 0) {
            i2 = (g.A(item) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= g.O(filterVal) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= g.O(tVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= g.O(fVar) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && g.h()) {
            g.G();
            iVar2 = g;
        } else {
            if (k.H()) {
                k.Q(973616320, i2, -1, "com.transsion.home.view.filter.popup.GridItem (MultiFilterPopupWindow.kt:285)");
            }
            if (Intrinsics.c(tVar.get(item.getFilterType()), filterVal.getId())) {
                g.P(1089913522);
                a2 = i0.b.a(com.tn.lib.widget.R.color.white, g, 0);
                a3 = i0.b.a(com.transsion.wrapperad.R.color.white_40, g, 0);
                g.K();
            } else {
                g.P(1090061733);
                a2 = i0.b.a(com.tn.lib.widget.R.color.text_03, g, 0);
                a3 = i0.b.a(com.tn.lib.widget.R.color.transparent, g, 0);
                g.K();
            }
            androidx.compose.ui.b d = androidx.compose.ui.b.a.d();
            float f = 100;
            f a4 = BackgroundKt.a(BorderKt.e(SizeKt.e(fVar, o0.i.g(32)), o0.i.g(1), a2, q.g.c(o0.i.g(f))), a3, q.g.c(o0.i.g(f)));
            g.P(-1746271574);
            boolean A = ((i2 & 896) == 256) | g.A(item) | ((i2 & 112) == 32);
            Object y = g.y();
            if (!A) {
                obj = y;
            }
            Function0 function0 = new Function0() { // from class: cl.i
                public final Object invoke() {
                    Unit n;
                    n = com.transsion.home.view.filter.popup.e.n(tVar, item, filterVal);
                    return n;
                }
            };
            g.p(function0);
            obj = function0;
            g.K();
            f d2 = ClickableKt.d(a4, false, (String) null, (androidx.compose.ui.semantics.f) null, (Function0) obj, 7, (Object) null);
            androidx.compose.ui.layout.t h = BoxKt.h(d, false);
            int a5 = g.a(g, 0);
            s n = g.n();
            f e = ComposedModifierKt.e(g, d2);
            ComposeUiNode.Companion companion = ComposeUiNode.c1;
            Function0 a6 = companion.a();
            if (!(g.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            g.C();
            if (g.e()) {
                g.F(a6);
            } else {
                g.o();
            }
            i a7 = f3.a(g);
            f3.b(a7, h, companion.c());
            f3.b(a7, n, companion.e());
            Function2 b2 = companion.b();
            if (a7.e() || !Intrinsics.c(a7.y(), Integer.valueOf(a5))) {
                a7.p(Integer.valueOf(a5));
                a7.k(Integer.valueOf(a5), b2);
            }
            f3.b(a7, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            iVar2 = g;
            TextKt.a(filterVal.getName(), (f) null, i0.b.a(com.tn.lib.widget.R.color.white, g, 0), x.c(14), (n) null, p.b.c(), androidx.compose.ui.text.font.h.b.b(), 0L, (androidx.compose.ui.text.style.i) null, (androidx.compose.ui.text.style.h) null, 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.d0) null, iVar2, 199680, 0, 130962);
            iVar2.r();
            if (k.H()) {
                k.P();
            }
        }
        g2 j = iVar2.j();
        if (j != null) {
            j.a(new Function2() { // from class: cl.j
                public final Object invoke(Object obj2, Object obj3) {
                    Unit o;
                    o = com.transsion.home.view.filter.popup.e.o(Item.this, filterVal, tVar, fVar, i, (androidx.compose.runtime.i) obj2, ((Integer) obj3).intValue());
                    return o;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(t tVar, Item item, FilterVal filterVal) {
        tVar.put(item.getFilterType(), filterVal.getId());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Item item, FilterVal filterVal, t tVar, f fVar, int i, i iVar, int i2) {
        m(item, filterVal, tVar, fVar, iVar, v1.a(i | 1));
        return Unit.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d1, code lost:
    
        if (r2 == androidx.compose.runtime.i.a.a()) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ff, code lost:
    
        if (r1 == androidx.compose.runtime.i.a.a()) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void p(final List list, final t tVar, final Function1 function1, i iVar, final int i) {
        int i2;
        Object obj;
        Object obj2;
        Intrinsics.h(list, "filterItems");
        Intrinsics.h(tVar, "selectItems");
        Intrinsics.h(function1, "dismiss");
        i g = iVar.g(1096788014);
        if ((i & 6) == 0) {
            i2 = (g.A(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= g.O(tVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= g.A(function1) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && g.h()) {
            g.G();
        } else {
            if (k.H()) {
                k.Q(1096788014, i2, -1, "com.transsion.home.view.filter.popup.MultiFilterPopup (MultiFilterPopupWindow.kt:61)");
            }
            final com.google.accompanist.systemuicontroller.c e = SystemUiControllerKt.e((Window) null, g, 0, 1);
            final long a2 = i0.b.a(com.tn.lib.widget.R.color.black_80, g, 0);
            Handler handler = new Handler(Looper.getMainLooper());
            g.P(-1633490746);
            boolean O = g.O(e) | g.d(a2);
            Object y = g.y();
            if (O || y == i.a.a()) {
                y = new Runnable() { // from class: cl.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.transsion.home.view.filter.popup.e.q(e, a2);
                    }
                };
                g.p(y);
            }
            g.K();
            handler.postDelayed((Runnable) y, 100L);
            g.P(-1633490746);
            boolean O2 = g.O(e) | ((i2 & 896) == 256);
            Object y2 = g.y();
            if (!O2) {
                obj = y2;
            }
            Function1 function12 = new Function1() { // from class: cl.b
                public final Object invoke(Object obj3) {
                    Unit r;
                    r = com.transsion.home.view.filter.popup.e.r(e, function1, ((Boolean) obj3).booleanValue());
                    return r;
                }
            };
            g.p(function12);
            obj = function12;
            final Function1 function13 = (Function1) obj;
            g.K();
            t tVar2 = new t();
            tVar2.putAll(tVar);
            g.P(5004770);
            boolean O3 = g.O(function13);
            Object y3 = g.y();
            if (!O3) {
                obj2 = y3;
            }
            Function0 function0 = new Function0() { // from class: cl.c
                public final Object invoke() {
                    Unit s;
                    s = com.transsion.home.view.filter.popup.e.s(function13);
                    return s;
                }
            };
            g.p(function0);
            obj2 = function0;
            g.K();
            AndroidDialog_androidKt.a((Function0) obj2, new androidx.compose.ui.window.c(false, false, false, 3, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.b.d(-1419240635, true, new a(a2, list, tVar2, function13, tVar), g, 54), g, 432, 0);
            if (k.H()) {
                k.P();
            }
        }
        g2 j = g.j();
        if (j != null) {
            j.a(new Function2() { // from class: cl.d
                public final Object invoke(Object obj3, Object obj4) {
                    Unit t;
                    t = com.transsion.home.view.filter.popup.e.t(list, tVar, function1, i, (androidx.compose.runtime.i) obj3, ((Integer) obj4).intValue());
                    return t;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(com.google.accompanist.systemuicontroller.c cVar, long j) {
        com.google.accompanist.systemuicontroller.b.b(cVar, j, false, false, (Function1) null, 14, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(com.google.accompanist.systemuicontroller.c cVar, Function1 function1, boolean z) {
        com.google.accompanist.systemuicontroller.b.b(cVar, u1.b.d(), false, false, (Function1) null, 14, (Object) null);
        function1.invoke(Boolean.valueOf(z));
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function1 function1) {
        function1.invoke(Boolean.FALSE);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(List list, t tVar, Function1 function1, int i, i iVar, int i2) {
        p(list, tVar, function1, iVar, v1.a(i | 1));
        return Unit.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0234, code lost:
    
        if (r6 == r29.a()) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void u(final Item item, final t tVar, i iVar, final int i) {
        int i2;
        final i1 i1Var;
        Object obj;
        i iVar2;
        String str;
        Float t;
        String str2;
        Float t2;
        i g = iVar.g(-945657323);
        if ((i & 6) == 0) {
            i2 = (g.A(item) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= g.O(tVar) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) == 18 && g.h()) {
            g.G();
            iVar2 = g;
        } else {
            if (k.H()) {
                k.Q(-945657323, i3, -1, "com.transsion.home.view.filter.popup.StepRangeSlider (MultiFilterPopupWindow.kt:337)");
            }
            RangeValue rangeVals = item.getRangeVals();
            Intrinsics.e(rangeVals);
            float minVal = rangeVals.getMinVal();
            float maxVal = rangeVals.getMaxVal();
            String str3 = (String) tVar.get(item.getFilterType());
            List S0 = str3 != null ? StringsKt.S0(str3, new String[]{","}, false, 0, 6, (Object) null) : null;
            if ((S0 != null ? S0.size() : 0) >= 2) {
                minVal = (S0 == null || (str2 = (String) S0.get(0)) == null || (t2 = StringsKt.t(str2)) == null) ? rangeVals.getMinVal() : t2.floatValue();
                maxVal = (S0 == null || (str = (String) S0.get(1)) == null || (t = StringsKt.t(str)) == null) ? rangeVals.getMaxVal() : t.floatValue();
            }
            g.P(1849434622);
            Object y = g.y();
            i.a aVar = i.a;
            if (y == aVar.a()) {
                y = r2.f(RangesKt.b(minVal, maxVal), (q2) null, 2, (Object) null);
                g.p(y);
            }
            i1 i1Var2 = (i1) y;
            g.K();
            if (c) {
                w(i1Var2, RangesKt.b(minVal, maxVal));
                c = false;
            }
            f.a aVar2 = f.a;
            androidx.compose.foundation.layout.b bVar = androidx.compose.foundation.layout.b.a;
            b.k d = bVar.d();
            b.a aVar3 = androidx.compose.ui.b.a;
            androidx.compose.ui.layout.t a2 = androidx.compose.foundation.layout.i.a(d, aVar3.i(), g, 0);
            int a3 = g.a(g, 0);
            s n = g.n();
            f e = ComposedModifierKt.e(g, aVar2);
            ComposeUiNode.Companion companion = ComposeUiNode.c1;
            Function0 a4 = companion.a();
            if (!(g.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            g.C();
            if (g.e()) {
                g.F(a4);
            } else {
                g.o();
            }
            i a5 = f3.a(g);
            f3.b(a5, a2, companion.c());
            f3.b(a5, n, companion.e());
            Function2 b2 = companion.b();
            if (a5.e() || !Intrinsics.c(a5.y(), Integer.valueOf(a3))) {
                a5.p(Integer.valueOf(a3));
                a5.k(Integer.valueOf(a3), b2);
            }
            f3.b(a5, e, companion.d());
            l lVar = l.a;
            int d2 = MathKt.d(((Number) v(i1Var2).j()).floatValue());
            int d3 = MathKt.d(((Number) v(i1Var2).e()).floatValue());
            ClosedFloatingPointRange v = v(i1Var2);
            ClosedFloatingPointRange b3 = RangesKt.b(rangeVals.getMinVal(), rangeVals.getMaxVal());
            int maxVal2 = ((int) rangeVals.getMaxVal()) - 1;
            androidx.compose.material.j a6 = androidx.compose.material.k.a.a(i0.b.a(com.tn.lib.widget.R.color.white, g, 0), 0L, i0.b.a(com.tn.lib.widget.R.color.white, g, 0), 0L, i0.b.a(com.tn.lib.widget.R.color.white_40, g, 0), 0L, i0.b.a(com.tn.lib.widget.R.color.transparent, g, 0), i0.b.a(com.tn.lib.widget.R.color.transparent, g, 0), 0L, 0L, g, 0, androidx.compose.material.k.b, 810);
            g.P(5004770);
            Object y2 = g.y();
            if (y2 == aVar.a()) {
                i1Var = i1Var2;
                y2 = new Function1() { // from class: cl.f
                    public final Object invoke(Object obj2) {
                        Unit x;
                        x = com.transsion.home.view.filter.popup.e.x(i1Var, (ClosedFloatingPointRange) obj2);
                        return x;
                    }
                };
                g.p(y2);
            } else {
                i1Var = i1Var2;
            }
            Function1 function1 = (Function1) y2;
            g.K();
            g.P(-1746271574);
            boolean A = g.A(item) | ((i3 & 112) == 32);
            Object y3 = g.y();
            if (!A) {
                obj = y3;
            }
            Function0 function0 = new Function0() { // from class: cl.g
                public final Object invoke() {
                    Unit y4;
                    y4 = com.transsion.home.view.filter.popup.e.y(tVar, item, i1Var);
                    return y4;
                }
            };
            g.p(function0);
            obj = function0;
            g.K();
            SliderKt.b(v, function1, (f) null, false, b3, maxVal2, (Function0) obj, a6, g, 48, 12);
            androidx.compose.ui.layout.t b4 = a0.b(bVar.c(), aVar3.j(), g, 0);
            int a7 = g.a(g, 0);
            s n2 = g.n();
            f e2 = ComposedModifierKt.e(g, aVar2);
            Function0 a8 = companion.a();
            if (!(g.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            g.C();
            if (g.e()) {
                g.F(a8);
            } else {
                g.o();
            }
            i a9 = f3.a(g);
            f3.b(a9, b4, companion.c());
            f3.b(a9, n2, companion.e());
            Function2 b5 = companion.b();
            if (a9.e() || !Intrinsics.c(a9.y(), Integer.valueOf(a7))) {
                a9.p(Integer.valueOf(a7));
                a9.k(Integer.valueOf(a7), b5);
            }
            f3.b(a9, e2, companion.d());
            d0 d0Var = d0.a;
            String valueOf = String.valueOf(d2);
            long c2 = x.c(12);
            h.a aVar4 = androidx.compose.ui.text.font.h.b;
            androidx.compose.ui.text.font.s b6 = aVar4.b();
            p.a aVar5 = p.b;
            TextKt.a(valueOf, PaddingKt.i(aVar2, o0.i.g(5), 0.0f, 0.0f, 0.0f, 14, (Object) null), i0.b.a(com.tn.lib.widget.R.color.white, g, 0), c2, (n) null, aVar5.e(), b6, 0L, (androidx.compose.ui.text.style.i) null, (androidx.compose.ui.text.style.h) null, 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.d0) null, g, 199728, 0, 130960);
            e0.a(b0.a(d0Var, aVar2, 1.0f, false, 2, (Object) null), g, 0);
            iVar2 = g;
            TextKt.a(String.valueOf(d3), (f) null, i0.b.a(com.tn.lib.widget.R.color.white, g, 0), x.c(12), (n) null, aVar5.e(), aVar4.b(), 0L, (androidx.compose.ui.text.style.i) null, (androidx.compose.ui.text.style.h) null, 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.d0) null, iVar2, 199680, 0, 130962);
            iVar2.r();
            iVar2.r();
            if (k.H()) {
                k.P();
            }
        }
        g2 j = iVar2.j();
        if (j != null) {
            j.a(new Function2() { // from class: cl.h
                public final Object invoke(Object obj2, Object obj3) {
                    Unit z;
                    z = com.transsion.home.view.filter.popup.e.z(Item.this, tVar, i, (androidx.compose.runtime.i) obj2, ((Integer) obj3).intValue());
                    return z;
                }
            });
        }
    }

    private static final ClosedFloatingPointRange v(i1 i1Var) {
        return (ClosedFloatingPointRange) i1Var.getValue();
    }

    private static final void w(i1 i1Var, ClosedFloatingPointRange closedFloatingPointRange) {
        i1Var.setValue(closedFloatingPointRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(i1 i1Var, ClosedFloatingPointRange closedFloatingPointRange) {
        Intrinsics.h(closedFloatingPointRange, "it");
        float floatValue = ((Number) closedFloatingPointRange.j()).floatValue() == ((Number) v(i1Var).j()).floatValue() ? ((Number) closedFloatingPointRange.e()).floatValue() : ((Number) closedFloatingPointRange.j()).floatValue();
        if (((int) floatValue) != ((int) b)) {
            f0.b(20L);
        }
        b = floatValue;
        w(i1Var, closedFloatingPointRange);
        if (((Number) closedFloatingPointRange.j()).floatValue() == ((Number) closedFloatingPointRange.e()).floatValue()) {
            a = ((Number) closedFloatingPointRange.j()).floatValue();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(t tVar, Item item, i1 i1Var) {
        if (((Number) v(i1Var).j()).floatValue() > ((Number) v(i1Var).e()).floatValue()) {
            float f = a;
            w(i1Var, RangesKt.b(f, f));
        }
        tVar.put(item.getFilterType(), PopupFilterView.INSTANCE.a(((Number) v(i1Var).j()).floatValue(), ((Number) v(i1Var).e()).floatValue()));
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Item item, t tVar, int i, i iVar, int i2) {
        u(item, tVar, iVar, v1.a(i | 1));
        return Unit.a;
    }
}
