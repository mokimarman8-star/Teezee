package vn;

import android.text.Editable;
import com.transsion.flow.bean.CommentBean;
import com.transsion.postdetail.comment.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private int a = 300;
    private i0 b;
    private Editable c;
    private CommentBean d;

    public final i0 a() {
        return this.b;
    }

    public final Editable b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }

    public final CommentBean d() {
        return this.d;
    }

    public final void e() {
        this.d = null;
        this.c = null;
    }

    public final void f(i0 i0Var) {
        this.b = i0Var;
    }

    public final void g(Editable editable) {
        this.c = editable;
    }

    public final void h(int i) {
        this.a = i;
    }

    public final void i(CommentBean commentBean) {
        this.d = commentBean;
    }
}
