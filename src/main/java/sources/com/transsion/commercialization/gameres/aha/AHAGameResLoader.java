package com.transsion.commercialization.gameres.aha;

import android.content.Context;
import com.transsion.bean.GameInfoType;
import com.transsion.commercialization.gameres.GameResView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AHAGameResLoader implements com.transsion.commercialization.gameres.a {
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.commercialization.gameres.aha.d
        public final Object invoke() {
            a h;
            h = AHAGameResLoader.h();
            return h;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final a g() {
        return (a) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a h() {
        return (a) kg.c.e.a().h(a.class);
    }

    @Override // com.transsion.commercialization.gameres.a
    public void a(Context context, String str, String str2, Function1 function1) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "itemId");
        Intrinsics.h(function1, "callback");
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new AHAGameResLoader$loadGameInfo$1(str2, this, function1, context, str, null), 3, (Object) null);
    }

    public uj.a d(String str, String str2, c cVar) {
        Intrinsics.h(str, "pageName");
        Intrinsics.h(str2, "itemId");
        Intrinsics.h(cVar, "info");
        uj.a aVar = new uj.a(GameInfoType.AHA, null, cVar);
        aVar.l(str);
        aVar.k(str2);
        return aVar;
    }

    public GameResView e(Context context, uj.a aVar) {
        Intrinsics.h(context, "context");
        Intrinsics.h(aVar, "info");
        AHAGameResView aHAGameResView = new AHAGameResView(context);
        aHAGameResView.setContent(aVar);
        return aHAGameResView;
    }

    public String f() {
        return ag.a.a.d() ? "https://tapi.ahagamecenter.com" : "https://api.ahagamecenter.com";
    }
}
