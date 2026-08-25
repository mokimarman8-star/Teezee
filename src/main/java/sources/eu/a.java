package eu;

import com.transsion.transfer.impl.entity.FileData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final a a = new a();
    private static final List b = new ArrayList();

    private a() {
    }

    private final List c(int i) {
        List list = b;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((FileData) obj).getState() == i) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.U0(arrayList);
    }

    public final void a(List data) {
        Object obj;
        Intrinsics.h(data, "data");
        Iterator it = data.iterator();
        while (it.hasNext()) {
            FileData fileData = (FileData) it.next();
            Iterator it2 = b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it2.next();
                    if (Intrinsics.c(((FileData) obj).getFileRemotePath(), fileData.getFileRemotePath())) {
                        break;
                    }
                }
            }
            if (obj == null) {
                b.add(fileData);
            }
        }
    }

    public final void b() {
        b.clear();
    }

    public final List d() {
        return b;
    }

    public final List e() {
        return CollectionsKt.U0(CollectionsKt.B0(c(3), c(5)));
    }

    public final List f() {
        return CollectionsKt.U0(c(2));
    }

    public final List g() {
        return CollectionsKt.U0(c(0));
    }

    public final boolean h() {
        return b.isEmpty();
    }
}
