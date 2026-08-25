package oo;

import com.blankj.utilcode.util.o;
import com.transsion.publish.api.bean.RequestPostEntity;
import io.reactivex.rxjava3.core.j;
import kg.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    private final Lazy a = LazyKt.b(new Function0() { // from class: oo.a
        public final Object invoke() {
            po.a g;
            g = b.g();
            return g;
        }
    });

    private final String b() {
        return gg.a.a.a();
    }

    private final RequestBody c(String str) {
        return RequestBody.Companion.create(str, MediaType.Companion.parse("application/json"));
    }

    private final po.a d() {
        return (po.a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final po.a g() {
        return (po.a) c.e.a().h(po.a.class);
    }

    public final j e(RequestPostEntity requestPostEntity) {
        Intrinsics.h(requestPostEntity, "entity");
        String j = o.j(requestPostEntity);
        Intrinsics.g(j, "toJson(...)");
        return d().b(b(), c(j));
    }

    public final j f(RequestPostEntity requestPostEntity) {
        Intrinsics.h(requestPostEntity, "entity");
        String j = o.j(requestPostEntity);
        Intrinsics.g(j, "toJson(...)");
        return d().c(b(), c(j));
    }
}
