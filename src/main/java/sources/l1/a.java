package l1;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.i;
import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f16375a;

    /* renamed from: b, reason: collision with root package name */
    private int f16376b = DescriptorProtos$Edition.EDITION_MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    private int f16377c = 0;

    /* renamed from: l1.a$a, reason: collision with other inner class name */
    private static class C0157a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final EditText f16378a;

        /* renamed from: b, reason: collision with root package name */
        private final g f16379b;

        C0157a(EditText editText, boolean z5) {
            this.f16378a = editText;
            g gVar = new g(editText, z5);
            this.f16379b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(l1.b.getInstance());
        }

        @Override // l1.a.b
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // l1.a.b
        boolean b() {
            return this.f16379b.b();
        }

        @Override // l1.a.b
        InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f16378a, inputConnection, editorInfo);
        }

        @Override // l1.a.b
        void d(boolean z5) {
            this.f16379b.d(z5);
        }
    }

    static class b {
        b() {
        }

        abstract KeyListener a(KeyListener keyListener);

        abstract boolean b();

        abstract InputConnection c(InputConnection inputConnection, EditorInfo editorInfo);

        abstract void d(boolean z5);
    }

    public a(EditText editText, boolean z5) {
        i.h(editText, "editText cannot be null");
        this.f16375a = new C0157a(editText, z5);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f16375a.a(keyListener);
    }

    public boolean b() {
        return this.f16375a.b();
    }

    public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f16375a.c(inputConnection, editorInfo);
    }

    public void d(boolean z5) {
        this.f16375a.d(z5);
    }
}
