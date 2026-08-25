package mo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.w;
import com.blankj.utilcode.util.KeyboardUtils;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$style;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ro.j;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends w {
    private j a;
    private InterfaceC0085b b;
    private View c;

    public static final class a {
        private final Context a;

        public a(Context context) {
            Intrinsics.h(context, "context");
            this.a = context;
        }

        public final b a(InterfaceC0085b interfaceC0085b, View view) {
            Intrinsics.h(interfaceC0085b, "listener");
            return new b(this.a, interfaceC0085b, view, null);
        }
    }

    /* renamed from: mo.b$b, reason: collision with other inner class name */
    public interface InterfaceC0085b {
        void completeLoad();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private b(Context context, InterfaceC0085b interfaceC0085b, View view) {
        super(context, R$style.CommentEditInputDialogTheme);
        this.b = interfaceC0085b;
        this.c = view;
        setContentView(R$layout.dialog_link_input_edit);
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
        this.a = new j(null, this, interfaceC0085b, this.c, true, 1, null);
        ro.b bVar = new ro.b();
        j jVar = this.a;
        if (jVar != null) {
            jVar.k(bVar);
        }
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: mo.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean g;
                g = b.g(b.this, dialogInterface, i, keyEvent);
                return g;
            }
        });
    }

    public /* synthetic */ b(Context context, InterfaceC0085b interfaceC0085b, View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, interfaceC0085b, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(b bVar, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        bVar.dismiss();
        return false;
    }

    private final void h() {
    }

    private final void i() {
    }

    public void dismiss() {
        View j;
        super.dismiss();
        this.c = null;
        j jVar = this.a;
        if (jVar == null || (j = jVar.j()) == null) {
            return;
        }
        KeyboardUtils.e(j);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onStart() {
        super/*androidx.activity.q*/.onStart();
        h();
    }

    protected void onStop() {
        super.onStop();
        i();
    }
}
