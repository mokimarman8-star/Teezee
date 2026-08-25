package k0;

import java.text.CharacterIterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b0 implements CharacterIterator {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f15996a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15997b;

    /* renamed from: c, reason: collision with root package name */
    private final int f15998c;

    /* renamed from: d, reason: collision with root package name */
    private int f15999d;

    public b0(CharSequence charSequence, int i5, int i6) {
        this.f15996a = charSequence;
        this.f15997b = i5;
        this.f15998c = i6;
        this.f15999d = i5;
    }

    @Override // java.text.CharacterIterator
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.text.CharacterIterator
    public char current() {
        int i5 = this.f15999d;
        if (i5 == this.f15998c) {
            return (char) 65535;
        }
        return this.f15996a.charAt(i5);
    }

    @Override // java.text.CharacterIterator
    public char first() {
        this.f15999d = this.f15997b;
        return current();
    }

    @Override // java.text.CharacterIterator
    public int getBeginIndex() {
        return this.f15997b;
    }

    @Override // java.text.CharacterIterator
    public int getEndIndex() {
        return this.f15998c;
    }

    @Override // java.text.CharacterIterator
    public int getIndex() {
        return this.f15999d;
    }

    @Override // java.text.CharacterIterator
    public char last() {
        int i5 = this.f15997b;
        int i6 = this.f15998c;
        if (i5 == i6) {
            this.f15999d = i6;
            return (char) 65535;
        }
        int i7 = i6 - 1;
        this.f15999d = i7;
        return this.f15996a.charAt(i7);
    }

    @Override // java.text.CharacterIterator
    public char next() {
        int i5 = this.f15999d + 1;
        this.f15999d = i5;
        int i6 = this.f15998c;
        if (i5 < i6) {
            return this.f15996a.charAt(i5);
        }
        this.f15999d = i6;
        return (char) 65535;
    }

    @Override // java.text.CharacterIterator
    public char previous() {
        int i5 = this.f15999d;
        if (i5 <= this.f15997b) {
            return (char) 65535;
        }
        int i6 = i5 - 1;
        this.f15999d = i6;
        return this.f15996a.charAt(i6);
    }

    @Override // java.text.CharacterIterator
    public char setIndex(int i5) {
        int i6 = this.f15997b;
        if (i5 > this.f15998c || i6 > i5) {
            throw new IllegalArgumentException("invalid position");
        }
        this.f15999d = i5;
        return current();
    }
}
