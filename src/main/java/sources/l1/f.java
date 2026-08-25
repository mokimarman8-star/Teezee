package l1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.core.util.i;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final b f16391a;

    private static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f16392a;

        /* renamed from: b, reason: collision with root package name */
        private final d f16393b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f16394c = true;

        a(TextView textView) {
            this.f16392a = textView;
            this.f16393b = new d(textView);
        }

        private InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f16393b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f16393b;
            return inputFilterArr2;
        }

        private SparseArray g(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i5 = 0; i5 < inputFilterArr.length; i5++) {
                InputFilter inputFilter = inputFilterArr[i5];
                if (inputFilter instanceof d) {
                    sparseArray.put(i5, inputFilter);
                }
            }
            return sparseArray;
        }

        private InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray g5 = g(inputFilterArr);
            if (g5.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - g5.size()];
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                if (g5.indexOfKey(i6) < 0) {
                    inputFilterArr2[i5] = inputFilterArr[i6];
                    i5++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        private void k() {
            this.f16392a.setFilters(a(this.f16392a.getFilters()));
        }

        private TransformationMethod m(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }

        @Override // l1.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f16394c ? h(inputFilterArr) : f(inputFilterArr);
        }

        @Override // l1.f.b
        public boolean b() {
            return this.f16394c;
        }

        @Override // l1.f.b
        void c(boolean z5) {
            if (z5) {
                l();
            }
        }

        @Override // l1.f.b
        void d(boolean z5) {
            this.f16394c = z5;
            l();
            k();
        }

        @Override // l1.f.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            return this.f16394c ? m(transformationMethod) : j(transformationMethod);
        }

        void i(boolean z5) {
            this.f16394c = z5;
        }

        void l() {
            this.f16392a.setTransformationMethod(e(this.f16392a.getTransformationMethod()));
        }
    }

    static class b {
        b() {
        }

        abstract InputFilter[] a(InputFilter[] inputFilterArr);

        public abstract boolean b();

        abstract void c(boolean z5);

        abstract void d(boolean z5);

        abstract TransformationMethod e(TransformationMethod transformationMethod);
    }

    private static class c extends b {

        /* renamed from: a, reason: collision with root package name */
        private final a f16395a;

        c(TextView textView) {
            this.f16395a = new a(textView);
        }

        private boolean f() {
            return !EmojiCompat.i();
        }

        @Override // l1.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.f16395a.a(inputFilterArr);
        }

        @Override // l1.f.b
        public boolean b() {
            return this.f16395a.b();
        }

        @Override // l1.f.b
        void c(boolean z5) {
            if (f()) {
                return;
            }
            this.f16395a.c(z5);
        }

        @Override // l1.f.b
        void d(boolean z5) {
            if (f()) {
                this.f16395a.i(z5);
            } else {
                this.f16395a.d(z5);
            }
        }

        @Override // l1.f.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.f16395a.e(transformationMethod);
        }
    }

    public f(TextView textView, boolean z5) {
        i.h(textView, "textView cannot be null");
        if (z5) {
            this.f16391a = new a(textView);
        } else {
            this.f16391a = new c(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f16391a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f16391a.b();
    }

    public void c(boolean z5) {
        this.f16391a.c(z5);
    }

    public void d(boolean z5) {
        this.f16391a.d(z5);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f16391a.e(transformationMethod);
    }
}
