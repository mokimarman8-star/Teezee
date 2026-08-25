package kotlin.collections.builders;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00028\u00032\u0006\u0010\r\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010!\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 ¨\u0006$"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/collections/builders/MapBuilder;", "map", HttpUrl.FRAGMENT_ENCODE_SET, "index", "<init>", "(Lkotlin/collections/builders/MapBuilder;I)V", HttpUrl.FRAGMENT_ENCODE_SET, "a", "()V", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "()Ljava/lang/String;", "Lkotlin/collections/builders/MapBuilder;", "b", "I", "c", "expectedModCount", "getKey", "()Ljava/lang/Object;", "key", "getValue", "value", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class MapBuilder$EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

    /* renamed from: a, reason: from kotlin metadata */
    private final MapBuilder map;

    /* renamed from: b, reason: from kotlin metadata */
    private final int index;

    /* renamed from: c, reason: from kotlin metadata */
    private final int expectedModCount;

    public MapBuilder$EntryRef(MapBuilder map, int i) {
        Intrinsics.h(map, "map");
        this.map = map;
        this.index = i;
        this.expectedModCount = MapBuilder.access$getModCount$p(map);
    }

    private final void a() {
        if (MapBuilder.access$getModCount$p(this.map) != this.expectedModCount) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object other) {
        if (other instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) other;
            if (Intrinsics.c(entry.getKey(), getKey()) && Intrinsics.c(entry.getValue(), getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public Object getKey() {
        a();
        return MapBuilder.access$getKeysArray$p(this.map)[this.index];
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        a();
        Object[] access$getValuesArray$p = MapBuilder.access$getValuesArray$p(this.map);
        Intrinsics.e(access$getValuesArray$p);
        return access$getValuesArray$p[this.index];
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        Object key = getKey();
        int hashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return hashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object newValue) {
        a();
        this.map.checkIsMutable$kotlin_stdlib();
        Object[] access$allocateValuesArray = MapBuilder.access$allocateValuesArray(this.map);
        int i = this.index;
        Object obj = access$allocateValuesArray[i];
        access$allocateValuesArray[i] = newValue;
        return obj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
