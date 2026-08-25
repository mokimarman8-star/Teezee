package androidx.coroutines;

/* renamed from: androidx.work.h, reason: case insensitive filesystem */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class AbstractC0214h {

    /* renamed from: androidx.work.h$a */
    class a extends AbstractC0214h {
        a() {
        }

        @Override // androidx.coroutines.AbstractC0214h
        public AbstractC0213g a(String str) {
            return null;
        }
    }

    public static AbstractC0214h c() {
        return new a();
    }

    public abstract AbstractC0213g a(String str);

    public final AbstractC0213g b(String str) {
        AbstractC0213g a5 = a(str);
        return a5 == null ? AbstractC0213g.a(str) : a5;
    }
}
