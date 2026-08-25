package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class f1 extends c2 {
    protected String d0(String parentName, String childName) {
        Intrinsics.h(parentName, "parentName");
        Intrinsics.h(childName, "childName");
        if (parentName.length() == 0) {
            return childName;
        }
        return parentName + '.' + childName;
    }

    protected String e0(kotlinx.serialization.descriptors.f descriptor, int i) {
        Intrinsics.h(descriptor, "descriptor");
        return descriptor.f(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.c2
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final String a0(kotlinx.serialization.descriptors.f fVar, int i) {
        Intrinsics.h(fVar, "<this>");
        return g0(e0(fVar, i));
    }

    protected final String g0(String nestedName) {
        Intrinsics.h(nestedName, "nestedName");
        String str = (String) Z();
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return d0(str, nestedName);
    }
}
