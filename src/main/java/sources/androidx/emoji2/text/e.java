package androidx.emoji2.text;

import android.text.TextPaint;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class e implements EmojiCompat$e {

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f7879b = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    private final TextPaint f7880a;

    e() {
        TextPaint textPaint = new TextPaint();
        this.f7880a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal threadLocal = f7879b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat$e
    public boolean a(CharSequence charSequence, int i5, int i6, int i7) {
        StringBuilder b5 = b();
        b5.setLength(0);
        while (i5 < i6) {
            b5.append(charSequence.charAt(i5));
            i5++;
        }
        return z0.d.a(this.f7880a, b5.toString());
    }
}
