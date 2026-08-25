package com.cloud.hisavana.sdk.common.util;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.R$style;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class v extends Dialog {
    private a a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private View g;

    public interface a {

        /* renamed from: com.cloud.hisavana.sdk.common.util.v$a$a, reason: collision with other inner class name */
        public static final class C0126a {
            public static void a(a aVar) {
            }

            public static void b(a aVar) {
            }

            public static void c(a aVar) {
            }
        }

        void a();

        void b();

        void c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(Context context, a aVar) {
        super(context, R$style.HSDialogTheme);
        Intrinsics.h(context, "context");
        this.a = aVar;
        View inflate = LayoutInflater.from(context).inflate(R$layout.hs_confirm_dialog_layout, (ViewGroup) null);
        setContentView(inflate);
        setCancelable(false);
        this.b = (TextView) inflate.findViewById(R$id.title);
        this.c = (TextView) inflate.findViewById(R$id.content);
        TextView textView = (TextView) inflate.findViewById(R$id.positive);
        this.d = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.util.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.d(v.this, view);
                }
            });
        }
        TextView textView2 = (TextView) inflate.findViewById(R$id.negative);
        this.e = textView2;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.util.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.e(v.this, view);
                }
            });
        }
        this.g = inflate.findViewById(R$id.separator_v);
        TextView textView3 = (TextView) inflate.findViewById(R$id.confirm);
        this.f = textView3;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.util.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.f(v.this, view);
                }
            });
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(v vVar, View view) {
        Intrinsics.h(vVar, "this$0");
        a aVar = vVar.a;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(v vVar, View view) {
        Intrinsics.h(vVar, "this$0");
        a aVar = vVar.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(v vVar, View view) {
        Intrinsics.h(vVar, "this$0");
        a aVar = vVar.a;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void g(String str) {
        Intrinsics.h(str, "text");
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void h(String str) {
        Intrinsics.h(str, "content");
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void i(String str) {
        Intrinsics.h(str, "text");
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void j(boolean z) {
        TextView textView = this.f;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setVisibility(z ? 8 : 0);
        }
        TextView textView3 = this.e;
        if (textView3 != null) {
            textView3.setVisibility(z ? 8 : 0);
        }
        View view = this.g;
        if (view == null) {
            return;
        }
        view.setVisibility(z ? 8 : 0);
    }

    public final void k(String str) {
        Intrinsics.h(str, "title");
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void l() {
        float f = getContext().getResources().getConfiguration().orientation == 2 ? 0.5f : 0.9f;
        Window window = getWindow();
        if (window != null) {
            window.setLayout((int) (getContext().getResources().getDisplayMetrics().widthPixels * f), -2);
        }
    }
}
