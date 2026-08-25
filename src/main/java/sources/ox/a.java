package ox;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a extends PasswordTransformationMethod {

    /* renamed from: ox.a$a, reason: collision with other inner class name */
    private final class C0095a implements CharSequence {
        private final CharSequence a;
        final /* synthetic */ a b;

        public C0095a(a aVar, CharSequence mSource) {
            Intrinsics.h(mSource, "mSource");
            this.b = aVar;
            this.a = mSource;
        }

        public char a(int i) {
            return '*';
        }

        public int b() {
            return this.a.length();
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ char charAt(int i) {
            return a(i);
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ int length() {
            return b();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            return this.a.subSequence(i, i2);
        }
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence source, View view) {
        Intrinsics.h(source, "source");
        Intrinsics.h(view, "view");
        return new C0095a(this, source);
    }
}
