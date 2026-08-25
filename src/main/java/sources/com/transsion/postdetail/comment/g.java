package com.transsion.postdetail.comment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.Window;
import android.view.WindowManager;
import com.transsion.flow.bean.CommentBean;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$style;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g extends androidx.appcompat.app.w {
    private m a;
    private vn.a b;

    public static final class a {
        private final Context a;
        private vn.a b;

        public a(Context context) {
            Intrinsics.h(context, "context");
            this.a = context;
            this.b = new vn.a();
        }

        public final g a() {
            g gVar = new g(this.a, null);
            gVar.k(this.b);
            return gVar;
        }

        public final a b(Editable editable) {
            vn.a aVar = this.b;
            if (aVar != null) {
                aVar.g(editable);
            }
            return this;
        }

        public final a c(i0 i0Var) {
            vn.a aVar = this.b;
            if (aVar != null) {
                aVar.f(i0Var);
            }
            return this;
        }

        public final a d(int i) {
            vn.a aVar = this.b;
            if (aVar != null) {
                aVar.h(i);
            }
            return this;
        }

        public final a e(CommentBean commentBean) {
            vn.a aVar = this.b;
            if (aVar != null) {
                aVar.i(commentBean);
            }
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private g(Context context) {
        super(context, R$style.CommentEditInputDialogTheme);
        setContentView(R$layout.dialog_comment_input_edit);
        setCancelable(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                if (attributes.width != -1) {
                    attributes.width = -1;
                }
                if (attributes.height != -2) {
                    attributes.height = -2;
                }
                window.setAttributes(attributes);
                window.setSoftInputMode(4);
            }
        }
        this.a = new m(null, this, null, true, 5, null);
    }

    public /* synthetic */ g(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final void i() {
        m mVar = this.a;
        if (mVar != null) {
            mVar.k(this.b);
        }
        m mVar2 = this.a;
        if (mVar2 != null) {
            mVar2.B();
        }
    }

    private final void m() {
        m mVar = this.a;
        if (mVar != null) {
            mVar.z();
        }
    }

    public final void f() {
        m mVar = this.a;
        if (mVar != null) {
            mVar.g();
        }
    }

    public final vn.a g() {
        return this.b;
    }

    public final m h() {
        return this.a;
    }

    public final void j(Editable editable) {
        vn.a aVar = this.b;
        if (aVar != null) {
            aVar.g(editable);
        }
    }

    public final void k(vn.a aVar) {
        this.b = aVar;
    }

    public final void l() {
        m mVar = this.a;
        if (mVar != null) {
            mVar.y();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onStart() {
        super/*androidx.activity.q*/.onStart();
        i();
    }

    protected void onStop() {
        super.onStop();
        m();
    }
}
