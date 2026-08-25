package androidx.coroutines;

import java.util.List;

/* renamed from: androidx.work.g, reason: case insensitive filesystem */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class AbstractC0213g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13929a = AbstractC0216j.i("InputMerger");

    public static AbstractC0213g a(String str) {
        try {
            return (AbstractC0213g) Class.forName(str).getDeclaredConstructor(null).newInstance(null);
        } catch (Exception e5) {
            AbstractC0216j.e().d(f13929a, "Trouble instantiating + " + str, e5);
            return null;
        }
    }

    public abstract C0210d b(List list);
}
