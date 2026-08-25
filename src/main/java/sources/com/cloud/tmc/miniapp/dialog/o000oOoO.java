package com.cloud.tmc.miniapp.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.dialog.OooO0O0;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class o000oOoO extends OooO0O0.OooO00o<o000oOoO> {
    public final Lazy OooO00o;
    public final Lazy OooO0O0;
    public final Lazy OooO0OO;
    public final Lazy OooO0Oo;
    public o0OoOo0 OooO0o;
    public final Lazy OooO0o0;

    public static final class OooO extends Lambda implements Function0<TextView> {
        public OooO() {
            super(0);
        }

        public Object invoke() {
            return (TextView) o000oOoO.this.findViewById(R.id.txt_common_dialog_title);
        }
    }

    public static final class OooO00o extends Lambda implements Function0<TextView> {
        public OooO00o() {
            super(0);
        }

        public Object invoke() {
            return (TextView) o000oOoO.this.findViewById(R.id.btn_common_dialog_left);
        }
    }

    public static final class OooO0O0 extends Lambda implements Function0<TextView> {
        public OooO0O0() {
            super(0);
        }

        public Object invoke() {
            return (TextView) o000oOoO.this.findViewById(R.id.btn_common_dialog_right);
        }
    }

    public static final class OooO0OO extends Lambda implements Function0<TextView> {
        public OooO0OO() {
            super(0);
        }

        public Object invoke() {
            return (TextView) o000oOoO.this.findViewById(R.id.tv_download_size);
        }
    }

    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        public Object invoke() {
            return (TextView) o000oOoO.this.findViewById(R.id.txt_common_dialog_describe);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o000oOoO(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.OooO00o = LazyKt.b(new OooO());
        this.OooO0O0 = LazyKt.b(new OooO0o());
        this.OooO0OO = LazyKt.b(new OooO00o());
        this.OooO0Oo = LazyKt.b(new OooO0O0());
        this.OooO0o0 = LazyKt.b(new OooO0OO());
        setContentView(R.layout.layout_fw_update_tips);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        setAnimStyle(-1);
        TextView OooO00o2 = OooO00o();
        if (OooO00o2 != null) {
            OooO00o2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o000oOoO.OooO00o(o000oOoO.this, view);
                }
            });
        }
        TextView OooO0O02 = OooO0O0();
        if (OooO0O02 != null) {
            OooO0O02.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o000oOoO.OooO0O0(o000oOoO.this, view);
                }
            });
        }
    }

    public static final void OooO00o(o000oOoO o000oooo, View view) {
        Intrinsics.h(o000oooo, "this$0");
        o0OoOo0 o0oooo0 = o000oooo.OooO0o;
        if (o0oooo0 != null) {
            Intrinsics.g(view, "it");
            o0oooo0.OooO00o(view);
        }
    }

    public static final void OooO0O0(o000oOoO o000oooo, View view) {
        Intrinsics.h(o000oooo, "this$0");
        o0OoOo0 o0oooo0 = o000oooo.OooO0o;
        if (o0oooo0 != null) {
            Intrinsics.g(view, "it");
            o0oooo0.OooO0O0(view);
        }
    }

    public final TextView OooO00o() {
        return (TextView) this.OooO0OO.getValue();
    }

    public final String OooO00o(long j) {
        float f = j / 1000.0f;
        if (f < 1000.0f) {
            return ((int) f) + " KB";
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        String format = decimalFormat.format(f / 1000.0f);
        Intrinsics.g(format, "format.format(number)");
        return format + " MB";
    }

    public final TextView OooO0O0() {
        return (TextView) this.OooO0Oo.getValue();
    }

    public final TextView OooO0OO() {
        return (TextView) this.OooO0O0.getValue();
    }

    public final TextView OooO0Oo() {
        return (TextView) this.OooO00o.getValue();
    }
}
