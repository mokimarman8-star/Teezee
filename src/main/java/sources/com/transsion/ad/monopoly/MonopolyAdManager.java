package com.transsion.ad.monopoly;

import com.transsion.ad.monopoly.manager.AdPlansAssetsManager;
import com.transsion.ad.monopoly.manager.AdPlansRequestManager;
import com.transsion.ad.monopoly.manager.AdSceneAssetsManager;
import com.transsion.ad.ps.activate.PSActivateManager;
import com.transsion.ad.ps.attribution.AttributionConsumeManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MonopolyAdManager {
    public static final MonopolyAdManager a = new MonopolyAdManager();

    private MonopolyAdManager() {
    }

    public static /* synthetic */ Object b(MonopolyAdManager monopolyAdManager, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return monopolyAdManager.a(str, function1, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(String str, Function1 function1, Continuation continuation) {
        MonopolyAdManager$init$1 monopolyAdManager$init$1;
        Object f;
        int i;
        AdSceneAssetsManager adSceneAssetsManager;
        String str2;
        Function1 function12;
        AdPlansRequestManager adPlansRequestManager;
        if (continuation instanceof MonopolyAdManager$init$1) {
            monopolyAdManager$init$1 = (MonopolyAdManager$init$1) continuation;
            int i2 = monopolyAdManager$init$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                monopolyAdManager$init$1.label = i2 - Integer.MIN_VALUE;
                Object obj = monopolyAdManager$init$1.result;
                f = IntrinsicsKt.f();
                i = monopolyAdManager$init$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    AdPlansAssetsManager adPlansAssetsManager = AdPlansAssetsManager.b;
                    monopolyAdManager$init$1.L$0 = str;
                    monopolyAdManager$init$1.L$1 = function1;
                    monopolyAdManager$init$1.label = 1;
                    if (adPlansAssetsManager.a(monopolyAdManager$init$1) == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            PSActivateManager.a.e();
                            return Unit.a;
                        }
                        function12 = (Function1) monopolyAdManager$init$1.L$1;
                        str2 = (String) monopolyAdManager$init$1.L$0;
                        ResultKt.b(obj);
                        AttributionConsumeManager.c.n();
                        adPlansRequestManager = AdPlansRequestManager.a;
                        monopolyAdManager$init$1.L$0 = null;
                        monopolyAdManager$init$1.L$1 = null;
                        monopolyAdManager$init$1.label = 3;
                        if (adPlansRequestManager.t(str2, function12, monopolyAdManager$init$1) == f) {
                            return f;
                        }
                        PSActivateManager.a.e();
                        return Unit.a;
                    }
                    function1 = (Function1) monopolyAdManager$init$1.L$1;
                    str = (String) monopolyAdManager$init$1.L$0;
                    ResultKt.b(obj);
                }
                adSceneAssetsManager = AdSceneAssetsManager.b;
                monopolyAdManager$init$1.L$0 = str;
                monopolyAdManager$init$1.L$1 = function1;
                monopolyAdManager$init$1.label = 2;
                if (adSceneAssetsManager.a(monopolyAdManager$init$1) != f) {
                    return f;
                }
                Function1 function13 = function1;
                str2 = str;
                function12 = function13;
                AttributionConsumeManager.c.n();
                adPlansRequestManager = AdPlansRequestManager.a;
                monopolyAdManager$init$1.L$0 = null;
                monopolyAdManager$init$1.L$1 = null;
                monopolyAdManager$init$1.label = 3;
                if (adPlansRequestManager.t(str2, function12, monopolyAdManager$init$1) == f) {
                }
                PSActivateManager.a.e();
                return Unit.a;
            }
        }
        monopolyAdManager$init$1 = new MonopolyAdManager$init$1(this, continuation);
        Object obj2 = monopolyAdManager$init$1.result;
        f = IntrinsicsKt.f();
        i = monopolyAdManager$init$1.label;
        if (i != 0) {
        }
        adSceneAssetsManager = AdSceneAssetsManager.b;
        monopolyAdManager$init$1.L$0 = str;
        monopolyAdManager$init$1.L$1 = function1;
        monopolyAdManager$init$1.label = 2;
        if (adSceneAssetsManager.a(monopolyAdManager$init$1) != f) {
        }
    }
}
