package kotlin.collections.builders;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", HttpUrl.FRAGMENT_ENCODE_SET, "map", "Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class MapBuilder$KeysItr<K, V> extends MapBuilder$Itr<K, V> implements Iterator<K>, KMutableIterator {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapBuilder$KeysItr(MapBuilder map) {
        super(map);
        Intrinsics.h(map, "map");
    }

    @Override // java.util.Iterator
    public Object next() {
        a();
        if (getIndex() >= MapBuilder.access$getLength$p(getMap())) {
            throw new NoSuchElementException();
        }
        int index = getIndex();
        i(index + 1);
        j(index);
        Object obj = MapBuilder.access$getKeysArray$p(getMap())[getLastIndex()];
        h();
        return obj;
    }
}
