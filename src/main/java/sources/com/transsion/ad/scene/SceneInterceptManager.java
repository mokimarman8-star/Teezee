package com.transsion.ad.scene;

import android.text.TextUtils;
import com.transsion.ad.strategy.u;
import com.transsion.ad.strategy.v;
import com.transsion.gslb.BuildConfig;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import rh.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SceneInterceptManager {
    public static final SceneInterceptManager a = new SceneInterceptManager();

    private SceneInterceptManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(String str, Continuation continuation) {
        SceneInterceptManager$intercept$1 sceneInterceptManager$intercept$1;
        int i;
        if (continuation instanceof SceneInterceptManager$intercept$1) {
            sceneInterceptManager$intercept$1 = (SceneInterceptManager$intercept$1) continuation;
            int i2 = sceneInterceptManager$intercept$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                sceneInterceptManager$intercept$1.label = i2 - Integer.MIN_VALUE;
                Object obj = sceneInterceptManager$intercept$1.result;
                Object f = IntrinsicsKt.f();
                i = sceneInterceptManager$intercept$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (TextUtils.isEmpty(str)) {
                        return new Pair(Boxing.a(true), "sceneId is empty");
                    }
                    if (f.a.b()) {
                        return new Pair(Boxing.a(true), "客户端 全局关闭广告");
                    }
                    if (d.a.b(str) == null) {
                        return new Pair(Boxing.a(true), "场景配置为空");
                    }
                    if (!b.a.k()) {
                        return new Pair(Boxing.a(true), "全局场景关闭");
                    }
                    c cVar = c.a;
                    if (cVar.c(str)) {
                        return new Pair(Boxing.a(true), "当前场景关闭");
                    }
                    if (u.a.c()) {
                        return new Pair(Boxing.a(true), "新用户保护期，不展示广告");
                    }
                    if (cVar.d(str)) {
                        return new Pair(Boxing.a(true), "当前是会员,不展示广告");
                    }
                    AdSceneDisplayLimitManager adSceneDisplayLimitManager = AdSceneDisplayLimitManager.a;
                    if (str == null) {
                        str = BuildConfig.FLAVOR;
                    }
                    sceneInterceptManager$intercept$1.label = 1;
                    obj = adSceneDisplayLimitManager.a(str, sceneInterceptManager$intercept$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                Pair pair = (Pair) obj;
                return ((Boolean) pair.getFirst()).booleanValue() ? new Pair(Boxing.a(true), pair.getSecond()) : v.a.a() ? new Pair(Boxing.a(true), "青少年模式，不展示广告") : new Pair(Boxing.a(false), "默认不拦截");
            }
        }
        sceneInterceptManager$intercept$1 = new SceneInterceptManager$intercept$1(this, continuation);
        Object obj2 = sceneInterceptManager$intercept$1.result;
        Object f2 = IntrinsicsKt.f();
        i = sceneInterceptManager$intercept$1.label;
        if (i != 0) {
        }
        Pair pair2 = (Pair) obj2;
        if (((Boolean) pair2.getFirst()).booleanValue()) {
        }
    }
}
