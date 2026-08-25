package cl;

import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.b0;
import androidx.compose.foundation.layout.e0;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.b;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.a5;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.d0;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import cl.w;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.transsion.home.bean.FilterVal;
import com.transsion.home.bean.Item;
import com.transsion.videodetail.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o0.x;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class w {

    static final class a implements Function2 {
        final /* synthetic */ long a;
        final /* synthetic */ Item b;
        final /* synthetic */ Function1 c;
        final /* synthetic */ String d;

        /* renamed from: cl.w$a$a, reason: collision with other inner class name */
        static final class C0002a implements Function3 {
            final /* synthetic */ FilterVal a;
            final /* synthetic */ androidx.compose.foundation.layout.k b;
            final /* synthetic */ Function1 c;

            C0002a(FilterVal filterVal, androidx.compose.foundation.layout.k kVar, Function1 function1) {
                this.a = filterVal;
                this.b = kVar;
                this.c = function1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit c(Function1 function1, FilterVal filterVal) {
                function1.invoke(filterVal.getId());
                return Unit.a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0092, code lost:
            
                if (r10 == androidx.compose.runtime.i.a.a()) goto L15;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void b(androidx.compose.foundation.lazy.b bVar, androidx.compose.runtime.i iVar, int i) {
                Object obj;
                Intrinsics.h(bVar, "$this$item");
                if ((i & 17) == 16 && iVar.h()) {
                    iVar.G();
                    return;
                }
                if (androidx.compose.runtime.k.H()) {
                    androidx.compose.runtime.k.Q(860266798, i, -1, "com.transsion.home.view.filter.popup.SingleSelectFilter.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SingleFilterPopupWindow.kt:114)");
                }
                String name = this.a.getName();
                androidx.compose.ui.text.font.s b = androidx.compose.ui.text.font.h.b.b();
                androidx.compose.ui.text.font.p b2 = androidx.compose.ui.text.font.p.b.b();
                int b3 = androidx.compose.ui.text.style.p.a.b();
                long c = x.c(16);
                long f = u1.b.f();
                androidx.compose.foundation.layout.k kVar = this.b;
                f.a aVar = androidx.compose.ui.f.a;
                androidx.compose.ui.f b4 = kVar.b(PaddingKt.g(SizeKt.d(aVar, 0.0f, 1, (Object) null), o0.i.g(16), 0.0f, 2, (Object) null), androidx.compose.ui.b.a.f());
                iVar.P(-1633490746);
                boolean O = iVar.O(this.c) | iVar.O(this.a);
                final Function1 function1 = this.c;
                final FilterVal filterVal = this.a;
                Object y = iVar.y();
                if (!O) {
                    obj = y;
                }
                Function0 function0 = new Function0() { // from class: cl.v
                    public final Object invoke() {
                        Unit c2;
                        c2 = w.a.C0002a.c(function1, filterVal);
                        return c2;
                    }
                };
                iVar.p(function0);
                obj = function0;
                iVar.K();
                TextKt.a(name, ClickableKt.d(b4, false, (String) null, (androidx.compose.ui.semantics.f) null, (Function0) obj, 7, (Object) null), f, c, (androidx.compose.ui.text.font.n) null, b2, b, 0L, (androidx.compose.ui.text.style.i) null, (androidx.compose.ui.text.style.h) null, 0L, b3, false, 0, 0, (Function1) null, (d0) null, iVar, 200064, 48, 128912);
                e0.a(SizeKt.e(aVar, o0.i.g(37)), iVar, 6);
                if (androidx.compose.runtime.k.H()) {
                    androidx.compose.runtime.k.P();
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                b((androidx.compose.foundation.lazy.b) obj, (androidx.compose.runtime.i) obj2, ((Number) obj3).intValue());
                return Unit.a;
            }
        }

        a(long j, Item item, Function1 function1, String str) {
            this.a = j;
            this.b = item;
            this.c = function1;
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(Function1 function1) {
            function1.invoke((Object) null);
            return Unit.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(Item item, androidx.compose.foundation.layout.k kVar, Function1 function1, androidx.compose.foundation.lazy.u uVar) {
            Intrinsics.h(uVar, "$this$LazyColumn");
            for (FilterVal filterVal : item.getFilterValsV2()) {
                androidx.compose.foundation.lazy.t.a(uVar, filterVal.getId(), (Object) null, androidx.compose.runtime.internal.b.b(860266798, true, new C0002a(filterVal, kVar, function1)), 2, (Object) null);
            }
            return Unit.a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x0270, code lost:
        
            if (r3 == androidx.compose.runtime.i.a.a()) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x02f0, code lost:
        
            if (r4 == androidx.compose.runtime.i.a.a()) goto L56;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void c(androidx.compose.runtime.i iVar, int i) {
            Object obj;
            Object obj2;
            if ((i & 3) == 2 && iVar.h()) {
                iVar.G();
                return;
            }
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-800641360, i, -1, "com.transsion.home.view.filter.popup.SingleSelectFilter.<anonymous> (SingleFilterPopupWindow.kt:65)");
            }
            f.a aVar = androidx.compose.ui.f.a;
            androidx.compose.ui.f b = SizeKt.b(BackgroundKt.b(aVar, this.a, (a5) null, 2, (Object) null), 0.0f, 1, (Object) null);
            final Item item = this.b;
            final Function1 function1 = this.c;
            String str = this.d;
            b.a aVar2 = androidx.compose.ui.b.a;
            androidx.compose.ui.layout.t h = BoxKt.h(aVar2.m(), false);
            int a = androidx.compose.runtime.g.a(iVar, 0);
            androidx.compose.runtime.s n = iVar.n();
            androidx.compose.ui.f e = ComposedModifierKt.e(iVar, b);
            ComposeUiNode.Companion companion = ComposeUiNode.c1;
            Function0 a2 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a2);
            } else {
                iVar.o();
            }
            androidx.compose.runtime.i a3 = f3.a(iVar);
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
            int a5 = androidx.compose.runtime.g.a(iVar, 0);
            androidx.compose.runtime.s n2 = iVar.n();
            androidx.compose.ui.f e2 = ComposedModifierKt.e(iVar, aVar);
            Function0 a6 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a6);
            } else {
                iVar.o();
            }
            androidx.compose.runtime.i a7 = f3.a(iVar);
            f3.b(a7, a4, companion.c());
            f3.b(a7, n2, companion.e());
            Function2 b3 = companion.b();
            if (a7.e() || !Intrinsics.c(a7.y(), Integer.valueOf(a5))) {
                a7.p(Integer.valueOf(a5));
                a7.k(Integer.valueOf(a5), b3);
            }
            f3.b(a7, e2, companion.d());
            final androidx.compose.foundation.layout.l lVar = androidx.compose.foundation.layout.l.a;
            float f = 12;
            androidx.compose.ui.f f2 = PaddingKt.f(aVar, o0.i.g(16), o0.i.g(f));
            androidx.compose.ui.layout.t b4 = a0.b(bVar.c(), aVar2.j(), iVar, 0);
            int a8 = androidx.compose.runtime.g.a(iVar, 0);
            androidx.compose.runtime.s n3 = iVar.n();
            androidx.compose.ui.f e3 = ComposedModifierKt.e(iVar, f2);
            Function0 a9 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a9);
            } else {
                iVar.o();
            }
            androidx.compose.runtime.i a10 = f3.a(iVar);
            f3.b(a10, b4, companion.c());
            f3.b(a10, n3, companion.e());
            Function2 b5 = companion.b();
            if (a10.e() || !Intrinsics.c(a10.y(), Integer.valueOf(a8))) {
                a10.p(Integer.valueOf(a8));
                a10.k(Integer.valueOf(a8), b5);
            }
            f3.b(a10, e3, companion.d());
            androidx.compose.foundation.layout.d0 d0Var = androidx.compose.foundation.layout.d0.a;
            androidx.compose.ui.text.font.s b6 = androidx.compose.ui.text.font.h.b.b();
            androidx.compose.ui.text.font.p e4 = androidx.compose.ui.text.font.p.b.e();
            int b7 = androidx.compose.ui.text.style.p.a.b();
            TextKt.a(str, b0.a(d0Var, SizeKt.l(aVar, o0.i.g(0)), 1.0f, false, 2, (Object) null), u1.b.f(), x.c(18), (androidx.compose.ui.text.font.n) null, e4, b6, 0L, (androidx.compose.ui.text.style.i) null, (androidx.compose.ui.text.style.h) null, 0L, b7, false, 0, 0, (Function1) null, (d0) null, iVar, 200064, 48, 128912);
            e0.a(SizeKt.l(aVar, o0.i.g(f)), iVar, 6);
            Painter c = i0.e.c(R.drawable.music_iv_close, iVar, 0);
            long a11 = i0.b.a(com.tn.lib.widget.R.color.white, iVar, 0);
            float f3 = 21;
            androidx.compose.ui.f e5 = SizeKt.e(SizeKt.l(aVar, o0.i.g(f3)), o0.i.g(f3));
            iVar.P(5004770);
            boolean O = iVar.O(function1);
            Object y = iVar.y();
            if (!O) {
                obj = y;
            }
            Function0 function0 = new Function0() { // from class: cl.t
                public final Object invoke() {
                    Unit d;
                    d = w.a.d(function1);
                    return d;
                }
            };
            iVar.p(function0);
            obj = function0;
            iVar.K();
            IconKt.a(c, "open", ClickableKt.d(e5, false, (String) null, (androidx.compose.ui.semantics.f) null, (Function0) obj, 7, (Object) null), a11, iVar, 48, 0);
            iVar.r();
            DividerKt.a((androidx.compose.ui.f) null, o0.i.g(1), i0.b.a(com.tn.lib.widget.R.color.white_10, iVar, 0), iVar, 48, 1);
            e0.a(SizeKt.e(aVar, o0.i.g(23)), iVar, 6);
            androidx.compose.ui.f d = SizeKt.d(androidx.compose.foundation.layout.j.a(lVar, aVar, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
            iVar.P(-1746271574);
            boolean A = iVar.A(item) | iVar.O(function1);
            Object y2 = iVar.y();
            if (!A) {
                obj2 = y2;
            }
            Function1 function12 = new Function1() { // from class: cl.u
                public final Object invoke(Object obj3) {
                    Unit e6;
                    e6 = w.a.e(Item.this, lVar, function1, (androidx.compose.foundation.lazy.u) obj3);
                    return e6;
                }
            };
            iVar.p(function12);
            obj2 = function12;
            iVar.K();
            LazyDslKt.a(d, (LazyListState) null, (androidx.compose.foundation.layout.t) null, false, (b.k) null, (b.b) null, (androidx.compose.foundation.gestures.g) null, false, (Function1) obj2, iVar, 0, 254);
            e0.a(SizeKt.e(aVar, o0.i.g(40)), iVar, 6);
            iVar.r();
            iVar.r();
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
            return Unit.a;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d2, code lost:
    
        if (r2 == androidx.compose.runtime.i.a.a()) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f8, code lost:
    
        if (r1 == androidx.compose.runtime.i.a.a()) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void e(final Item item, final String str, final Function1 function1, androidx.compose.runtime.i iVar, final int i) {
        int i2;
        Object obj;
        Object obj2;
        androidx.compose.runtime.i iVar2;
        Intrinsics.h(item, "filterItem");
        Intrinsics.h(str, "title");
        Intrinsics.h(function1, "dismiss");
        androidx.compose.runtime.i g = iVar.g(666133991);
        if ((i & 6) == 0) {
            i2 = (g.A(item) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= g.O(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= g.A(function1) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && g.h()) {
            g.G();
            iVar2 = g;
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(666133991, i2, -1, "com.transsion.home.view.filter.popup.SingleSelectFilter (SingleFilterPopupWindow.kt:44)");
            }
            final com.google.accompanist.systemuicontroller.c e = SystemUiControllerKt.e((Window) null, g, 0, 1);
            final long a2 = i0.b.a(com.tn.lib.widget.R.color.black_80, g, 0);
            Handler handler = new Handler(Looper.getMainLooper());
            g.P(-1633490746);
            boolean O = g.O(e) | g.d(a2);
            Object y = g.y();
            if (O || y == androidx.compose.runtime.i.a.a()) {
                y = new Runnable() { // from class: cl.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.f(e, a2);
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
            Function1 function12 = new Function1() { // from class: cl.q
                public final Object invoke(Object obj3) {
                    Unit g2;
                    g2 = w.g(e, function1, (String) obj3);
                    return g2;
                }
            };
            g.p(function12);
            obj = function12;
            final Function1 function13 = (Function1) obj;
            g.K();
            g.P(5004770);
            boolean O3 = g.O(function13);
            Object y3 = g.y();
            if (!O3) {
                obj2 = y3;
            }
            Function0 function0 = new Function0() { // from class: cl.r
                public final Object invoke() {
                    Unit h;
                    h = w.h(function13);
                    return h;
                }
            };
            g.p(function0);
            obj2 = function0;
            g.K();
            iVar2 = g;
            AndroidDialog_androidKt.a((Function0) obj2, new androidx.compose.ui.window.c(false, false, false, 3, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.b.d(-800641360, true, new a(a2, item, function13, str), g, 54), g, 432, 0);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j = iVar2.j();
        if (j != null) {
            j.a(new Function2() { // from class: cl.s
                public final Object invoke(Object obj3, Object obj4) {
                    Unit i3;
                    i3 = w.i(Item.this, str, function1, i, (androidx.compose.runtime.i) obj3, ((Integer) obj4).intValue());
                    return i3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(com.google.accompanist.systemuicontroller.c cVar, long j) {
        com.google.accompanist.systemuicontroller.b.b(cVar, j, false, false, (Function1) null, 14, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(com.google.accompanist.systemuicontroller.c cVar, Function1 function1, String str) {
        com.google.accompanist.systemuicontroller.b.b(cVar, u1.b.d(), false, false, (Function1) null, 14, (Object) null);
        function1.invoke(str);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Function1 function1) {
        function1.invoke((Object) null);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Item item, String str, Function1 function1, int i, androidx.compose.runtime.i iVar, int i2) {
        e(item, str, function1, iVar, v1.a(i | 1));
        return Unit.a;
    }
}
