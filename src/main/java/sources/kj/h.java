package kj;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.w;
import com.blankj.utilcode.util.y;
import com.transsion.baseui.R;
import com.transsion.baseui.R$color;
import com.transsion.baseui.R$style;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h extends w {
    private ProgressBar a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context, R$style.BaseTranslucentDialogStyle);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void cancel() {
        super/*android.app.Dialog*/.cancel();
        ProgressBar progressBar = this.a;
        if (progressBar != null) {
            uf.c.g(progressBar);
        }
    }

    public void dismiss() {
        super.dismiss();
        ProgressBar progressBar = this.a;
        if (progressBar != null) {
            uf.c.g(progressBar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_dialog_loading);
        this.a = (ProgressBar) findViewById(R.id.load_view);
        com.transsion.baseui.util.a aVar = com.transsion.baseui.util.a.a;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        int a = (int) aVar.a(context, 28.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a, a);
        layoutParams.gravity = 49;
        int a2 = (y.a() / 2) - com.blankj.utilcode.util.d.c();
        Context context2 = getContext();
        Intrinsics.g(context2, "getContext(...)");
        layoutParams.topMargin = a2 - ((int) aVar.a(context2, 54.0f));
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(17);
            window.setWindowAnimations(0);
            window.setBackgroundDrawableResource(R$color.base_transparent);
            window.setDimAmount(0.0f);
            window.clearFlags(2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = y.e();
            attributes.height = y.a();
            window.setAttributes(attributes);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        super/*android.app.Dialog*/.show();
        ProgressBar progressBar = this.a;
        if (progressBar != null) {
            uf.c.k(progressBar);
        }
    }
}
