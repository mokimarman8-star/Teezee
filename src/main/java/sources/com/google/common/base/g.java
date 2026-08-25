package com.google.common.base;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class g {
    private final String a;

    class a extends g {
        final /* synthetic */ String b;
        final /* synthetic */ g c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g gVar, g gVar2, String str) {
            super(gVar2, null);
            this.b = str;
            this.c = gVar;
        }

        @Override // com.google.common.base.g
        CharSequence i(Object obj) {
            return obj == null ? this.b : this.c.i(obj);
        }

        @Override // com.google.common.base.g
        public g j(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    private g(g gVar) {
        this.a = gVar.a;
    }

    /* synthetic */ g(g gVar, a aVar) {
        this(gVar);
    }

    private g(String str) {
        this.a = (String) m.o(str);
    }

    public static g g(char c) {
        return new g(String.valueOf(c));
    }

    public static g h(String str) {
        return new g(str);
    }

    public Appendable a(Appendable appendable, Iterator it) {
        m.o(appendable);
        if (it.hasNext()) {
            appendable.append(i(it.next()));
            while (it.hasNext()) {
                appendable.append(this.a);
                appendable.append(i(it.next()));
            }
        }
        return appendable;
    }

    public final StringBuilder b(StringBuilder sb2, Iterable iterable) {
        return c(sb2, iterable.iterator());
    }

    public final StringBuilder c(StringBuilder sb2, Iterator it) {
        try {
            a(sb2, it);
            return sb2;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final String d(Iterable iterable) {
        return e(iterable.iterator());
    }

    public final String e(Iterator it) {
        return c(new StringBuilder(), it).toString();
    }

    public final String f(Object[] objArr) {
        return d(Arrays.asList(objArr));
    }

    CharSequence i(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public g j(String str) {
        m.o(str);
        return new a(this, this, str);
    }
}
