package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class y {
    public static Set a(Set builder) {
        Intrinsics.h(builder, "builder");
        return ((SetBuilder) builder).build();
    }

    public static Set b() {
        return new SetBuilder();
    }

    public static Set c(int i) {
        return new SetBuilder(i);
    }

    public static Set d(Object obj) {
        Set singleton = Collections.singleton(obj);
        Intrinsics.g(singleton, "singleton(...)");
        return singleton;
    }

    public static TreeSet e(Object... elements) {
        Intrinsics.h(elements, "elements");
        return (TreeSet) g.D0(elements, new TreeSet());
    }
}
