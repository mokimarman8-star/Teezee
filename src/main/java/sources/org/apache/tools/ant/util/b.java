package org.apache.tools.ant.util;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class b {

    private static final class a implements Enumeration {
        private final Enumeration a;
        private final Enumeration b;

        public a(Enumeration enumeration, Enumeration enumeration2) {
            this.a = enumeration;
            this.b = enumeration2;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.a.hasMoreElements() || this.b.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return this.a.hasMoreElements() ? this.a.nextElement() : this.b.nextElement();
        }
    }

    /* renamed from: org.apache.tools.ant.util.b$b, reason: collision with other inner class name */
    public static final class C0086b implements Enumeration {
        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            throw new NoSuchElementException();
        }
    }

    public static Enumeration a(Enumeration enumeration, Enumeration enumeration2) {
        return new a(enumeration, enumeration2);
    }
}
