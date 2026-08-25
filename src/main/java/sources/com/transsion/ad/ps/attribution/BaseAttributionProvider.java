package com.transsion.ad.ps.attribution;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.pslink.AttributionPoint;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class BaseAttributionProvider {
    public static final a b = new a(null);
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.ad.ps.attribution.a
        public final Object invoke() {
            com.transsion.ad.db.pslink.a i;
            i = BaseAttributionProvider.i();
            return i;
        }
    });

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.ad.db.pslink.a f() {
        return (com.transsion.ad.db.pslink.a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.ad.db.pslink.a i() {
        MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return companion.b(a2).w0();
    }

    protected final Object c(AttributionPoint attributionPoint, Continuation continuation) {
        Object g = i.g(y0.b(), new BaseAttributionProvider$delete$2(this, attributionPoint, null), continuation);
        return g == IntrinsicsKt.f() ? g : Unit.a;
    }

    protected final Object d(Continuation continuation) {
        MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return companion.b(a2).w0().d(System.currentTimeMillis(), 5000L, continuation);
    }

    protected final String e() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    protected final Object g(String str, AttributionPoint.AttributionType attributionType, String str2, Continuation continuation) {
        Object g = i.g(y0.b(), new BaseAttributionProvider$insert$2(this, str2, str, attributionType, null), continuation);
        return g == IntrinsicsKt.f() ? g : Unit.a;
    }

    protected final Object h(String str, AttributionPoint.AttributionType attributionType, String str2, Continuation continuation) {
        return i.g(y0.b(), new BaseAttributionProvider$isAttributionPointExists$2(this, str, attributionType, str2, null), continuation);
    }

    protected final Object j(AttributionPoint attributionPoint, Continuation continuation) {
        Object g = i.g(y0.b(), new BaseAttributionProvider$update$2(attributionPoint, this, null), continuation);
        return g == IntrinsicsKt.f() ? g : Unit.a;
    }
}
