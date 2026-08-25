package l1;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class e implements KeyListener {

    /* renamed from: a, reason: collision with root package name */
    private final KeyListener f16389a;

    /* renamed from: b, reason: collision with root package name */
    private final a f16390b;

    public static class a {
        public boolean a(Editable editable, int i5, KeyEvent keyEvent) {
            return EmojiCompat.g(editable, i5, keyEvent);
        }
    }

    e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    e(KeyListener keyListener, a aVar) {
        this.f16389a = keyListener;
        this.f16390b = aVar;
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i5) {
        this.f16389a.clearMetaKeyState(view, editable, i5);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f16389a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i5, KeyEvent keyEvent) {
        return this.f16390b.a(editable, i5, keyEvent) || this.f16389a.onKeyDown(view, editable, i5, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f16389a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i5, KeyEvent keyEvent) {
        return this.f16389a.onKeyUp(view, editable, i5, keyEvent);
    }
}
