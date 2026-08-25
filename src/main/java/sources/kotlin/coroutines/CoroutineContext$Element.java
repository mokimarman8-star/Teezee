package kotlin.coroutines;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J*\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "get", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface CoroutineContext$Element extends CoroutineContext {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    public static final class DefaultImpls {
        public static Object a(CoroutineContext$Element coroutineContext$Element, Object obj, Function2 operation) {
            Intrinsics.h(operation, "operation");
            return operation.invoke(obj, coroutineContext$Element);
        }

        public static CoroutineContext$Element b(CoroutineContext$Element coroutineContext$Element, CoroutineContext$Key key) {
            Intrinsics.h(key, "key");
            if (!Intrinsics.c(coroutineContext$Element.getKey(), key)) {
                return null;
            }
            Intrinsics.f(coroutineContext$Element, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
            return coroutineContext$Element;
        }

        public static CoroutineContext c(CoroutineContext$Element coroutineContext$Element, CoroutineContext$Key key) {
            Intrinsics.h(key, "key");
            return Intrinsics.c(coroutineContext$Element.getKey(), key) ? EmptyCoroutineContext.INSTANCE : coroutineContext$Element;
        }

        public static CoroutineContext d(CoroutineContext$Element coroutineContext$Element, CoroutineContext context) {
            Intrinsics.h(context, "context");
            return CoroutineContext.DefaultImpls.b(coroutineContext$Element, context);
        }
    }

    CoroutineContext$Element get(CoroutineContext$Key key);

    CoroutineContext$Key getKey();
}
