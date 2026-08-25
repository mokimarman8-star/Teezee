package kotlin.text;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\t¨\u0006\u000b"}, d2 = {"kotlin/text/StringsKt__StringsKt$iterator$1", "Lkotlin/collections/CharIterator;", HttpUrl.FRAGMENT_ENCODE_SET, "a", "()C", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", "()Z", HttpUrl.FRAGMENT_ENCODE_SET, "I", "index", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class StringsKt__StringsKt$iterator$1 extends CharIterator {

    /* renamed from: a, reason: from kotlin metadata */
    private int index;
    final /* synthetic */ CharSequence b;

    StringsKt__StringsKt$iterator$1(CharSequence charSequence) {
        this.b = charSequence;
    }

    @Override // kotlin.collections.CharIterator
    public char a() {
        CharSequence charSequence = this.b;
        int i = this.index;
        this.index = i + 1;
        return charSequence.charAt(i);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.b.length();
    }
}
