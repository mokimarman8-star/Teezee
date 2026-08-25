package androidx.media3.common.util;

import android.os.Bundle;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class h {
    public static ImmutableList a(com.google.common.base.f fVar, List list) {
        ImmutableList.a builder = ImmutableList.builder();
        for (int i5 = 0; i5 < list.size(); i5++) {
            builder.j(fVar.apply((Bundle) a.e((Bundle) list.get(i5))));
        }
        return builder.n();
    }

    public static ArrayList b(Collection collection, com.google.common.base.f fVar) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add((Bundle) fVar.apply(it.next()));
        }
        return arrayList;
    }
}
