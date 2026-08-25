package g2;

import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f15439a = new a();

    class a implements n {
        a() {
        }

        @Override // g2.n
        public long a() {
            throw new NoSuchElementException();
        }

        @Override // g2.n
        public long b() {
            throw new NoSuchElementException();
        }

        @Override // g2.n
        public boolean next() {
            return false;
        }
    }

    long a();

    long b();

    boolean next();
}
