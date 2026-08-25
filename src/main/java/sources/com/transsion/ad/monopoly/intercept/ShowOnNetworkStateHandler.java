package com.transsion.ad.monopoly.intercept;

import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Locale;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShowOnNetworkStateHandler extends a {
    private final Boolean g(MbAdDbPlans mbAdDbPlans) {
        String extraConfig;
        if (mbAdDbPlans != null && (extraConfig = mbAdDbPlans.getExtraConfig()) != null) {
            try {
                String string = new JSONObject(extraConfig).getString("network");
                Intrinsics.e(string);
                String lowerCase = string.toLowerCase(Locale.ROOT);
                Intrinsics.g(lowerCase, "toLowerCase(...)");
                return Boolean.valueOf(Intrinsics.c(lowerCase, "on"));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        ShowOnNetworkStateHandler$doHandle$1 showOnNetworkStateHandler$doHandle$1;
        int i;
        AdPlansHitResponse adPlansHitResponse;
        if (continuation instanceof ShowOnNetworkStateHandler$doHandle$1) {
            showOnNetworkStateHandler$doHandle$1 = (ShowOnNetworkStateHandler$doHandle$1) continuation;
            int i2 = showOnNetworkStateHandler$doHandle$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                showOnNetworkStateHandler$doHandle$1.label = i2 - Integer.MIN_VALUE;
                Object obj = showOnNetworkStateHandler$doHandle$1.result;
                Object f = IntrinsicsKt.f();
                i = showOnNetworkStateHandler$doHandle$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    Boolean g = g(mbAdDbPlans);
                    boolean e = l.a.e();
                    if (!e ? g == null || Intrinsics.c(g, Boxing.a(false)) : g == null || Intrinsics.c(g, Boxing.a(true))) {
                        return new AdPlansHitResponse(false, "当前网络状态 = " + e + " -- isShowOnNetwork = " + g);
                    }
                    a c = c();
                    if (c != null) {
                        showOnNetworkStateHandler$doHandle$1.label = 1;
                        obj = c.b(str, mbAdDbPlans, map, showOnNetworkStateHandler$doHandle$1);
                        if (obj == f) {
                            return f;
                        }
                    }
                    return e();
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                adPlansHitResponse = (AdPlansHitResponse) obj;
                if (adPlansHitResponse != null) {
                    return adPlansHitResponse;
                }
                return e();
            }
        }
        showOnNetworkStateHandler$doHandle$1 = new ShowOnNetworkStateHandler$doHandle$1(this, continuation);
        Object obj2 = showOnNetworkStateHandler$doHandle$1.result;
        Object f2 = IntrinsicsKt.f();
        i = showOnNetworkStateHandler$doHandle$1.label;
        if (i != 0) {
        }
        adPlansHitResponse = (AdPlansHitResponse) obj2;
        if (adPlansHitResponse != null) {
        }
        return e();
    }
}
