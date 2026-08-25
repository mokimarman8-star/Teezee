package kotlin.collections.builders;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0004B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\u00132\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "l", "()Lkotlin/collections/builders/MapBuilder$EntryRef;", HttpUrl.FRAGMENT_ENCODE_SET, "n", "()I", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", HttpUrl.FRAGMENT_ENCODE_SET, "m", "(Ljava/lang/StringBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class MapBuilder$EntriesItr<K, V> extends MapBuilder$Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapBuilder$EntriesItr(MapBuilder map) {
        super(map);
        Intrinsics.h(map, "map");
    }

    @Override // java.util.Iterator
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public MapBuilder$EntryRef next() {
        a();
        if (getIndex() >= MapBuilder.access$getLength$p(getMap())) {
            throw new NoSuchElementException();
        }
        int index = getIndex();
        i(index + 1);
        j(index);
        MapBuilder$EntryRef mapBuilder$EntryRef = new MapBuilder$EntryRef(getMap(), getLastIndex());
        h();
        return mapBuilder$EntryRef;
    }

    public final void m(StringBuilder sb) {
        Intrinsics.h(sb, "sb");
        if (getIndex() >= MapBuilder.access$getLength$p(getMap())) {
            throw new NoSuchElementException();
        }
        int index = getIndex();
        i(index + 1);
        j(index);
        Object obj = MapBuilder.access$getKeysArray$p(getMap())[getLastIndex()];
        if (obj == getMap()) {
            sb.append("(this Map)");
        } else {
            sb.append(obj);
        }
        sb.append('=');
        Object[] access$getValuesArray$p = MapBuilder.access$getValuesArray$p(getMap());
        Intrinsics.e(access$getValuesArray$p);
        Object obj2 = access$getValuesArray$p[getLastIndex()];
        if (obj2 == getMap()) {
            sb.append("(this Map)");
        } else {
            sb.append(obj2);
        }
        h();
    }

    public final int n() {
        if (getIndex() >= MapBuilder.access$getLength$p(getMap())) {
            throw new NoSuchElementException();
        }
        int index = getIndex();
        i(index + 1);
        j(index);
        Object obj = MapBuilder.access$getKeysArray$p(getMap())[getLastIndex()];
        int hashCode = obj != null ? obj.hashCode() : 0;
        Object[] access$getValuesArray$p = MapBuilder.access$getValuesArray$p(getMap());
        Intrinsics.e(access$getValuesArray$p);
        Object obj2 = access$getValuesArray$p[getLastIndex()];
        int hashCode2 = hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        h();
        return hashCode2;
    }
}
