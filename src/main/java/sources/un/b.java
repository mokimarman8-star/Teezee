package un;

import com.transsion.postdetail.bean.CommentListBean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    private a a;
    private CommentListBean b;

    public b(a aVar, CommentListBean commentListBean) {
        Intrinsics.h(aVar, "commentBean");
        this.a = aVar;
        this.b = commentListBean;
    }

    public final a a() {
        return this.a;
    }

    public final CommentListBean b() {
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
        return Intrinsics.c(this.a, bVar.a) && Intrinsics.c(this.b, bVar.b);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        CommentListBean commentListBean = this.b;
        return hashCode + (commentListBean == null ? 0 : commentListBean.hashCode());
    }

    public String toString() {
        return "SubCommentData(commentBean=" + this.a + ", commentListBean=" + this.b + ")";
    }
}
