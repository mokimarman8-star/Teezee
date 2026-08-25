package com.transsion.ad.monopoly.intercept;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Locale;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SceneInWhitelistHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        SceneInWhitelistHandler$doHandle$1 sceneInWhitelistHandler$doHandle$1;
        int i;
        AdPlansHitResponse adPlansHitResponse;
        if (continuation instanceof SceneInWhitelistHandler$doHandle$1) {
            sceneInWhitelistHandler$doHandle$1 = (SceneInWhitelistHandler$doHandle$1) continuation;
            int i2 = sceneInWhitelistHandler$doHandle$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                sceneInWhitelistHandler$doHandle$1.label = i2 - Integer.MIN_VALUE;
                Object obj = sceneInWhitelistHandler$doHandle$1.result;
                Object f = IntrinsicsKt.f();
                i = sceneInWhitelistHandler$doHandle$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    String[] strArr = (String[]) o.d(mbAdDbPlans != null ? mbAdDbPlans.getScenes() : null, String[].class);
                    if (strArr == null || strArr.length == 0) {
                        booleanRef.element = true;
                    } else {
                        for (String str2 : strArr) {
                            Locale locale = Locale.ROOT;
                            String lowerCase = str2.toLowerCase(locale);
                            Intrinsics.g(lowerCase, "toLowerCase(...)");
                            String lowerCase2 = str.toLowerCase(locale);
                            Intrinsics.g(lowerCase2, "toLowerCase(...)");
                            if (TextUtils.equals(lowerCase, lowerCase2)) {
                                booleanRef.element = true;
                            }
                        }
                    }
                    if (!booleanRef.element) {
                        return new AdPlansHitResponse(false, "当前场景不在白名单中");
                    }
                    a c = c();
                    if (c != null) {
                        sceneInWhitelistHandler$doHandle$1.label = 1;
                        obj = c.b(str, mbAdDbPlans, map, sceneInWhitelistHandler$doHandle$1);
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
        sceneInWhitelistHandler$doHandle$1 = new SceneInWhitelistHandler$doHandle$1(this, continuation);
        Object obj2 = sceneInWhitelistHandler$doHandle$1.result;
        Object f2 = IntrinsicsKt.f();
        i = sceneInWhitelistHandler$doHandle$1.label;
        if (i != 0) {
        }
        adPlansHitResponse = (AdPlansHitResponse) obj2;
        if (adPlansHitResponse != null) {
        }
        return e();
    }
}
