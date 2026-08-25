package kotlin.text;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class RegexKt$fromInt$1$1 implements Function1<Enum<Object>, Boolean> {
    final /* synthetic */ int a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(Enum r3) {
        d dVar = (d) r3;
        return Boolean.valueOf((this.a & dVar.getMask()) == dVar.getValue());
    }
}
