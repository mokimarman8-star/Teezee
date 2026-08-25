package kotlin.collections.builders;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ConcurrentModificationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000f\u0010\nR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0016\u0010\u001f\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015¨\u0006 "}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", HttpUrl.FRAGMENT_ENCODE_SET, "h", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", "()Z", "remove", "a", "Lkotlin/collections/builders/MapBuilder;", "f", "()Lkotlin/collections/builders/MapBuilder;", HttpUrl.FRAGMENT_ENCODE_SET, "b", "I", "c", "()I", "i", "(I)V", "index", "e", "j", "lastIndex", "d", "expectedModCount", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class MapBuilder$Itr<K, V> {

    /* renamed from: a, reason: from kotlin metadata */
    private final MapBuilder map;

    /* renamed from: b, reason: from kotlin metadata */
    private int index;

    /* renamed from: c, reason: from kotlin metadata */
    private int lastIndex;

    /* renamed from: d, reason: from kotlin metadata */
    private int expectedModCount;

    public MapBuilder$Itr(MapBuilder map) {
        Intrinsics.h(map, "map");
        this.map = map;
        this.lastIndex = -1;
        this.expectedModCount = MapBuilder.access$getModCount$p(map);
        h();
    }

    public final void a() {
        if (MapBuilder.access$getModCount$p(this.map) != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: c, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: e, reason: from getter */
    public final int getLastIndex() {
        return this.lastIndex;
    }

    /* renamed from: f, reason: from getter */
    public final MapBuilder getMap() {
        return this.map;
    }

    public final void h() {
        while (this.index < MapBuilder.access$getLength$p(this.map)) {
            int[] access$getPresenceArray$p = MapBuilder.access$getPresenceArray$p(this.map);
            int i = this.index;
            if (access$getPresenceArray$p[i] >= 0) {
                return;
            } else {
                this.index = i + 1;
            }
        }
    }

    public final boolean hasNext() {
        return this.index < MapBuilder.access$getLength$p(this.map);
    }

    public final void i(int i) {
        this.index = i;
    }

    public final void j(int i) {
        this.lastIndex = i;
    }

    public final void remove() {
        a();
        if (this.lastIndex == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        this.map.checkIsMutable$kotlin_stdlib();
        MapBuilder.access$removeEntryAt(this.map, this.lastIndex);
        this.lastIndex = -1;
        this.expectedModCount = MapBuilder.access$getModCount$p(this.map);
    }
}
