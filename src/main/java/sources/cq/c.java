package cq;

import com.google.gson.JsonObject;
import com.transsion.search.net.RequestJoinGroupEntity;
import com.transsion.search.net.RequestSearchEntity;
import cq.a;
import io.reactivex.rxjava3.core.j;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final a b = new a(null);
    private final Lazy a = LazyKt.b(new Function0() { // from class: cq.b
        public final Object invoke() {
            a i;
            i = c.i();
            return i;
        }
    });

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String b() {
        return gg.a.a.a();
    }

    private final cq.a e() {
        return (cq.a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cq.a i() {
        return (cq.a) kg.c.e.a().h(cq.a.class);
    }

    public final j c() {
        return a.C0065a.a(e(), 1, 0, 2, null);
    }

    public final j d(String str) {
        Intrinsics.h(str, "keyword");
        return a.C0065a.b(e(), str, 0, 0, 6, null);
    }

    public final j f(RequestJoinGroupEntity requestJoinGroupEntity) {
        Intrinsics.h(requestJoinGroupEntity, "entity");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("groupId", requestJoinGroupEntity.getGroupId());
        RequestBody.Companion companion = RequestBody.Companion;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        return e().b(b(), companion.create(jsonElement, MediaType.Companion.parse("application/json")));
    }

    public final j g(RequestSearchEntity requestSearchEntity) {
        Intrinsics.h(requestSearchEntity, "entity");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("page", Integer.valueOf(requestSearchEntity.getPage()));
        jsonObject.addProperty("keyword", requestSearchEntity.getKeyword());
        RequestBody.Companion companion = RequestBody.Companion;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        companion.create(jsonElement, MediaType.Companion.parse("application/json"));
        return e().a(b(), requestSearchEntity.getPage(), requestSearchEntity.getKeyword());
    }

    public final Object h(RequestSearchEntity requestSearchEntity, Continuation continuation) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("page", Boxing.d(requestSearchEntity.getPage()));
        jsonObject.addProperty("perPage", Boxing.d(requestSearchEntity.getPerPage()));
        jsonObject.addProperty("keyword", requestSearchEntity.getKeyword());
        jsonObject.addProperty("subjectType", Boxing.d(requestSearchEntity.getSubjectType()));
        jsonObject.addProperty("resultMode", Boxing.d(1));
        RequestBody.Companion companion = RequestBody.Companion;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        return e().e(b(), companion.create(jsonElement, MediaType.Companion.parse("application/json")), continuation);
    }
}
