package androidx.emoji2.text;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class o extends SpannableStringBuilder {

    /* renamed from: a, reason: collision with root package name */
    private final Class f7944a;

    /* renamed from: b, reason: collision with root package name */
    private final List f7945b;

    private static class a implements TextWatcher, SpanWatcher {

        /* renamed from: a, reason: collision with root package name */
        final Object f7946a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f7947b = new AtomicInteger(0);

        a(Object obj) {
            this.f7946a = obj;
        }

        private boolean b(Object obj) {
            return obj instanceof i;
        }

        final void a() {
            this.f7947b.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f7946a).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            ((TextWatcher) this.f7946a).beforeTextChanged(charSequence, i5, i6, i7);
        }

        final void c() {
            this.f7947b.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i5, int i6) {
            if (this.f7947b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f7946a).onSpanAdded(spannable, obj, i5, i6);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i5, int i6, int i7, int i8) {
            int i9;
            int i10;
            if (this.f7947b.get() <= 0 || !b(obj)) {
                if (Build.VERSION.SDK_INT < 28) {
                    if (i5 > i6) {
                        i5 = 0;
                    }
                    if (i7 > i8) {
                        i9 = i5;
                        i10 = 0;
                        ((SpanWatcher) this.f7946a).onSpanChanged(spannable, obj, i9, i6, i10, i8);
                    }
                }
                i9 = i5;
                i10 = i7;
                ((SpanWatcher) this.f7946a).onSpanChanged(spannable, obj, i9, i6, i10, i8);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i5, int i6) {
            if (this.f7947b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f7946a).onSpanRemoved(spannable, obj, i5, i6);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            ((TextWatcher) this.f7946a).onTextChanged(charSequence, i5, i6, i7);
        }
    }

    o(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f7945b = new ArrayList();
        androidx.core.util.i.h(cls, "watcherClass cannot be null");
        this.f7944a = cls;
    }

    o(Class cls, CharSequence charSequence, int i5, int i6) {
        super(charSequence, i5, i6);
        this.f7945b = new ArrayList();
        androidx.core.util.i.h(cls, "watcherClass cannot be null");
        this.f7944a = cls;
    }

    private void b() {
        for (int i5 = 0; i5 < this.f7945b.size(); i5++) {
            ((a) this.f7945b.get(i5)).a();
        }
    }

    public static o c(Class cls, CharSequence charSequence) {
        return new o(cls, charSequence);
    }

    private void e() {
        for (int i5 = 0; i5 < this.f7945b.size(); i5++) {
            ((a) this.f7945b.get(i5)).onTextChanged(this, 0, length(), length());
        }
    }

    private a f(Object obj) {
        for (int i5 = 0; i5 < this.f7945b.size(); i5++) {
            a aVar = (a) this.f7945b.get(i5);
            if (aVar.f7946a == obj) {
                return aVar;
            }
        }
        return null;
    }

    private boolean g(Class cls) {
        return this.f7944a == cls;
    }

    private boolean h(Object obj) {
        return obj != null && g(obj.getClass());
    }

    private void i() {
        for (int i5 = 0; i5 < this.f7945b.size(); i5++) {
            ((a) this.f7945b.get(i5)).c();
        }
    }

    public void a() {
        b();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char c5) {
        super.append(c5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence, int i5, int i6) {
        super.append(charSequence, i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i5) {
        super.append(charSequence, obj, i5);
        return this;
    }

    public void d() {
        i();
        e();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int i5, int i6) {
        super.delete(i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        a f5;
        if (h(obj) && (f5 = f(obj)) != null) {
            obj = f5;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        a f5;
        if (h(obj) && (f5 = f(obj)) != null) {
            obj = f5;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        a f5;
        if (h(obj) && (f5 = f(obj)) != null) {
            obj = f5;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public Object[] getSpans(int i5, int i6, Class cls) {
        if (!g(cls)) {
            return super.getSpans(i5, i6, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i5, i6, a.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, aVarArr.length);
        for (int i7 = 0; i7 < aVarArr.length; i7++) {
            objArr[i7] = aVarArr[i7].f7946a;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i5, CharSequence charSequence) {
        super.insert(i5, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i5, CharSequence charSequence, int i6, int i7) {
        super.insert(i5, charSequence, i6, i7);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i5, int i6, Class cls) {
        if (cls == null || g(cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i5, i6, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        a aVar;
        if (h(obj)) {
            aVar = f(obj);
            if (aVar != null) {
                obj = aVar;
            }
        } else {
            aVar = null;
        }
        super.removeSpan(obj);
        if (aVar != null) {
            this.f7945b.remove(aVar);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence) {
        b();
        super.replace(i5, i6, charSequence);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence, int i7, int i8) {
        b();
        super.replace(i5, i6, charSequence, i7, i8);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i5, int i6, int i7) {
        if (h(obj)) {
            a aVar = new a(obj);
            this.f7945b.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i5, i6, i7);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i5, int i6) {
        return new o(this.f7944a, this, i5, i6);
    }
}
