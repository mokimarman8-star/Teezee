package x9;

import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface o {
    public static final o a = new a();

    class a implements o {
        a() {
        }

        @Override // x9.o
        public long a() {
            throw new NoSuchElementException();
        }

        @Override // x9.o
        public long b() {
            throw new NoSuchElementException();
        }

        @Override // x9.o
        public boolean next() {
            return false;
        }
    }

    long a();

    long b();

    boolean next();
}
