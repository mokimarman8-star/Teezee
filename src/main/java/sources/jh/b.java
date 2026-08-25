package jh;

import com.tn.tranpay.bean.QueryOrderResultContent;
import com.tn.tranpay.bean.QueryStatus;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b {
    private final QueryOrderResultContent a;
    private final QueryStatus b;

    public b(QueryOrderResultContent queryOrderResultContent, QueryStatus queryStatus) {
        Intrinsics.h(queryStatus, "status");
        this.a = queryOrderResultContent;
        this.b = queryStatus;
    }

    public final QueryOrderResultContent a() {
        return this.a;
    }

    public final QueryStatus b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.a, bVar.a) && this.b == bVar.b;
    }

    public int hashCode() {
        QueryOrderResultContent queryOrderResultContent = this.a;
        return ((queryOrderResultContent == null ? 0 : queryOrderResultContent.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "QueryOrderResult(content=" + this.a + ", status=" + this.b + ")";
    }
}
