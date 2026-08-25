package kotlin.coroutines.jvm.internal;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Ljava/lang/StackTraceElement;", "d", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Ljava/lang/StackTraceElement;", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "b", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Lkotlin/coroutines/jvm/internal/DebugMetadata;", HttpUrl.FRAGMENT_ENCODE_SET, "c", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)I", "expected", "actual", HttpUrl.FRAGMENT_ENCODE_SET, "a", "(II)V", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* renamed from: kotlin.coroutines.jvm.internal.DebugMetadataKt, reason: from Kotlin metadata */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class BaseContinuationImpl {
    private static final void a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }

    private static final DebugMetadata b(kotlin.coroutines.jvm.internal.BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int c(kotlin.coroutines.jvm.internal.BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(kotlin.coroutines.jvm.internal.BaseContinuationImpl baseContinuationImpl) {
        String str;
        Intrinsics.h(baseContinuationImpl, "<this>");
        DebugMetadata b = b(baseContinuationImpl);
        if (b == null) {
            return null;
        }
        a(1, b.v());
        int c = c(baseContinuationImpl);
        int i = c < 0 ? -1 : b.l()[c];
        String b2 = a.a.b(baseContinuationImpl);
        if (b2 == null) {
            str = b.c();
        } else {
            str = b2 + '/' + b.c();
        }
        return new StackTraceElement(str, b.m(), b.f(), i);
    }
}
