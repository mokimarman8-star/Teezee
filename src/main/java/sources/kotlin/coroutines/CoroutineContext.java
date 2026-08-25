package kotlin.coroutines;

import jy.c;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@SinceKotlin
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H¦\u0002¢\u0006\u0002\u0010\u0007J5\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\rJ\u0011\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0096\u0002J\u0014\u0010\u0010\u001a\u00020\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H&¨\u0006\u0013"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "", "get", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "plus", "context", "minusKey", "Key", "Element", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface CoroutineContext {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static CoroutineContext b(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            Intrinsics.h(coroutineContext2, "context");
            return coroutineContext2 == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, new c());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CoroutineContext c(CoroutineContext coroutineContext, Element element) {
            CombinedContext combinedContext;
            Intrinsics.h(coroutineContext, "acc");
            Intrinsics.h(element, "element");
            CoroutineContext minusKey = coroutineContext.minusKey(element.getKey());
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            if (minusKey == emptyCoroutineContext) {
                return element;
            }
            ContinuationInterceptor.Key key = ContinuationInterceptor.k1;
            ContinuationInterceptor continuationInterceptor = minusKey.get(key);
            if (continuationInterceptor == null) {
                combinedContext = new CombinedContext(minusKey, element);
            } else {
                CoroutineContext minusKey2 = minusKey.minusKey(key);
                if (minusKey2 == emptyCoroutineContext) {
                    return new CombinedContext(element, continuationInterceptor);
                }
                combinedContext = new CombinedContext(new CombinedContext(minusKey2, element), continuationInterceptor);
            }
            return combinedContext;
        }
    }

    Object fold(Object initial, Function2 operation);

    Element get(Key key);

    CoroutineContext minusKey(Key key);

    CoroutineContext plus(CoroutineContext context);
}
