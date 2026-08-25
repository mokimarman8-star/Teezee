package kotlin.ranges;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000e¨\u0006\u0017"}, d2 = {"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", HttpUrl.FRAGMENT_ENCODE_SET, "first", "last", HttpUrl.FRAGMENT_ENCODE_SET, "step", "<init>", "(CCI)V", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", "()Z", "a", "()C", "I", "getStep", "()I", "b", "finalElement", "c", "Z", "d", "next", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class CharProgressionIterator extends CharIterator {

    /* renamed from: a, reason: from kotlin metadata */
    private final int step;

    /* renamed from: b, reason: from kotlin metadata */
    private final int finalElement;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean hasNext;

    /* renamed from: d, reason: from kotlin metadata */
    private int next;

    public CharProgressionIterator(char c, char c2, int i) {
        this.step = i;
        this.finalElement = c2;
        boolean z = false;
        if (i <= 0 ? Intrinsics.j(c, c2) >= 0 : Intrinsics.j(c, c2) <= 0) {
            z = true;
        }
        this.hasNext = z;
        this.next = z ? c : c2;
    }

    @Override // kotlin.collections.CharIterator
    public char a() {
        int i = this.next;
        if (i != this.finalElement) {
            this.next = this.step + i;
        } else {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        }
        return (char) i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }
}
