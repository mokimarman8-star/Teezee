package com.transsion.base.infras_config;

import com.google.gson.Gson;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.base.infras_config.api.InfraInitApi;
import com.transsion.base.infras_config.model.ConfigInitData;
import com.transsion.base.infras_config.model.ConfigInitDataItem;
import com.transsion.base.infras_config.model.ConfigInitMobileInfraReq;
import com.transsion.base.infras_config.model.ConfigInitRspCode;
import com.transsion.base.infras_config.model.InfrasSourceType;
import io.reactivex.rxjava3.core.j;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.y0;
import wf.a;
import yx.d;
import yx.f;
import yx.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class InfraInitManager {
    public static final InfraInitManager a = new InfraInitManager();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.base.infras_config.a
        public final Object invoke() {
            InfraInitApi b2;
            b2 = InfraInitManager.b();
            return b2;
        }
    });

    static final class a implements d {
        public static final a a = new a();

        a() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final boolean a(Integer num, Throwable th2) {
            Intrinsics.h(num, "count");
            Intrinsics.h(th2, "<unused var>");
            return num.intValue() <= 1;
        }
    }

    static final class b implements h {
        final /* synthetic */ long a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[ConfigInitRspCode.values().length];
                try {
                    iArr[ConfigInitRspCode.IRC_MODIFIED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ConfigInitRspCode.IRC_NOT_MODIFIED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ConfigInitRspCode.IRC_UNKNOWN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        b(long j) {
            this.a = j;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConfigInitData apply(BaseDto baseDto) {
            Intrinsics.h(baseDto, "response");
            ConfigInitData configInitData = (ConfigInitData) baseDto.getData();
            if (configInitData == null) {
                throw new IllegalStateException("init response data is null");
            }
            ConfigInitRspCode code = configInitData.getCode();
            int i = code == null ? -1 : a.a[code.ordinal()];
            if (i != -1 && i != 1 && i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalStateException("init failed, code=" + configInitData.getCode());
            }
            long currentTimeMillis = System.currentTimeMillis();
            pi.b.a.j(configInitData, currentTimeMillis);
            long j = currentTimeMillis - this.a;
            a.a aVar = wf.a.a;
            StringBuilder sb = new StringBuilder();
            sb.append("initRx() success, code=");
            sb.append(configInitData.getCode());
            sb.append(", items=");
            List<ConfigInitDataItem> items = configInitData.getItems();
            sb.append(items != null ? items.size() : 0);
            sb.append(", version=");
            sb.append(configInitData.getVersion());
            sb.append(", cost=");
            sb.append(j);
            sb.append("ms");
            a.a.f(aVar, "InfraInitManager", sb.toString(), false, 4, (Object) null);
            return configInitData;
        }
    }

    static final class c implements f {
        final /* synthetic */ long a;

        c(long j) {
            this.a = j;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Throwable th2) {
            Intrinsics.h(th2, "t");
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            a.a aVar = wf.a.a;
            StringBuilder sb = new StringBuilder();
            sb.append("initRx() failed, cost=");
            sb.append(currentTimeMillis);
            sb.append("ms, msg=");
            String message = th2.getMessage();
            if (message == null) {
                message = th2.getClass().getSimpleName();
            }
            sb.append(message);
            a.a.k(aVar, "InfraInitManager", sb.toString(), th2, false, 8, (Object) null);
        }
    }

    private InfraInitManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InfraInitApi b() {
        return (InfraInitApi) kg.c.e.a().h(InfraInitApi.class);
    }

    private final InfraInitApi c() {
        return (InfraInitApi) b.getValue();
    }

    public final ConfigInitDataItem d(InfrasSourceType infrasSourceType) {
        Intrinsics.h(infrasSourceType, "sourceType");
        return pi.b.a.c(infrasSourceType);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(List list, String str, String str2, Continuation continuation) {
        InfraInitManager$init$1 infraInitManager$init$1;
        int i;
        if (continuation instanceof InfraInitManager$init$1) {
            infraInitManager$init$1 = (InfraInitManager$init$1) continuation;
            int i2 = infraInitManager$init$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                infraInitManager$init$1.label = i2 - Integer.MIN_VALUE;
                Object obj = infraInitManager$init$1.result;
                Object f = IntrinsicsKt.f();
                i = infraInitManager$init$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    i0 b2 = y0.b();
                    InfraInitManager$init$2 infraInitManager$init$2 = new InfraInitManager$init$2(list, str, str2, null);
                    infraInitManager$init$1.label = 1;
                    obj = i.g(b2, infraInitManager$init$2, infraInitManager$init$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return ((Result) obj).unbox-impl();
            }
        }
        infraInitManager$init$1 = new InfraInitManager$init$1(this, continuation);
        Object obj2 = infraInitManager$init$1.result;
        Object f2 = IntrinsicsKt.f();
        i = infraInitManager$init$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).unbox-impl();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(List list, String str, long j, String str2, Continuation continuation) {
        InfraInitManager$initIfNeeded$1 infraInitManager$initIfNeeded$1;
        int i;
        if (continuation instanceof InfraInitManager$initIfNeeded$1) {
            infraInitManager$initIfNeeded$1 = (InfraInitManager$initIfNeeded$1) continuation;
            int i2 = infraInitManager$initIfNeeded$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                infraInitManager$initIfNeeded$1.label = i2 - Integer.MIN_VALUE;
                Object obj = infraInitManager$initIfNeeded$1.result;
                Object f = IntrinsicsKt.f();
                i = infraInitManager$initIfNeeded$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    i0 b2 = y0.b();
                    InfraInitManager$initIfNeeded$2 infraInitManager$initIfNeeded$2 = new InfraInitManager$initIfNeeded$2(j, list, str, str2, null);
                    infraInitManager$initIfNeeded$1.label = 1;
                    obj = i.g(b2, infraInitManager$initIfNeeded$2, infraInitManager$initIfNeeded$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return ((Result) obj).unbox-impl();
            }
        }
        infraInitManager$initIfNeeded$1 = new InfraInitManager$initIfNeeded$1(this, continuation);
        Object obj2 = infraInitManager$initIfNeeded$1.result;
        Object f2 = IntrinsicsKt.f();
        i = infraInitManager$initIfNeeded$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).unbox-impl();
    }

    public final j h(List list, String str, String str2) {
        Intrinsics.h(list, "sourceVersions");
        long currentTimeMillis = System.currentTimeMillis();
        a.a.f(wf.a.a, "InfraInitManager", "initRx() start, sourceCount=" + list.size() + ", version=" + str + ", baseUrl=" + str2, false, 4, (Object) null);
        List list2 = list;
        pi.b.a.l(list2.isEmpty() ? null : list2);
        if (list2.isEmpty()) {
            list2 = null;
        }
        ConfigInitMobileInfraReq configInitMobileInfraReq = new ConfigInitMobileInfraReq(list2, str);
        new Gson().toJson(configInitMobileInfraReq);
        j j = c().initMobileInfra(str2, configInitMobileInfraReq).f(dg.d.a.e()).y(a.a).u(new b(currentTimeMillis)).j(new c(currentTimeMillis));
        Intrinsics.g(j, "doOnError(...)");
        return j;
    }
}
