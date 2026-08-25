package ik;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.i;
import com.blankj.utilcode.util.y;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends Dialog {
    private hk.b a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Intrinsics.h(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(b bVar, View view) {
        bVar.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hk.b c = hk.b.c(getLayoutInflater());
        this.a = c;
        hk.b bVar = null;
        if (c == null) {
            Intrinsics.y("viewBinding");
            c = null;
        }
        setContentView(c.getRoot());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(null);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.gravity = 17;
            }
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            if (attributes2 != null) {
                attributes2.width = y.e() - i.e(70.0f);
            }
        }
        float e = i.e(8.0f);
        hk.b bVar2 = this.a;
        if (bVar2 == null) {
            Intrinsics.y("viewBinding");
            bVar2 = null;
        }
        LinearLayout root = bVar2.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        jk.a.a(root, e);
        hk.b bVar3 = this.a;
        if (bVar3 == null) {
            Intrinsics.y("viewBinding");
            bVar3 = null;
        }
        AppCompatTextView appCompatTextView = bVar3.b;
        Intrinsics.g(appCompatTextView, "btnOk");
        jk.a.a(appCompatTextView, e);
        hk.b bVar4 = this.a;
        if (bVar4 == null) {
            Intrinsics.y("viewBinding");
        } else {
            bVar = bVar4;
        }
        bVar.b.setOnClickListener(new View.OnClickListener() { // from class: ik.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.b(b.this, view);
            }
        });
    }
}
