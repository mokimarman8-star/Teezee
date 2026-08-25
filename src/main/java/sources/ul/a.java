package ul;

import com.transsion.lib_web.download_render.task.compare.CompareRequest;
import com.transsion.lib_web.download_render.task.compare.CompareResponse;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ul.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements b.a {
    private final List a;
    private int b;

    public a(List list, int i) {
        Intrinsics.h(list, "steps");
        this.a = list;
        this.b = i;
    }

    public /* synthetic */ a(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? 0 : i);
    }

    @Override // ul.b.a
    public CompareResponse a(CompareRequest compareRequest) {
        Intrinsics.h(compareRequest, "request");
        if (this.b >= this.a.size()) {
            return new CompareResponse(CollectionsKt.l(), CollectionsKt.l(), CollectionsKt.l(), 0L);
        }
        b bVar = (b) this.a.get(this.b);
        this.b++;
        return bVar.a(compareRequest, this);
    }
}
