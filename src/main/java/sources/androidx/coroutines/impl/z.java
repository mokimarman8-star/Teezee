package androidx.coroutines.impl;

import android.content.Context;
import androidx.coroutines.AbstractC0216j;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public static final z f14141a = new z();

    private z() {
    }

    private final File c(Context context) {
        return new File(a.f13947a.a(context), "androidx.work.workdb");
    }

    public static final void d(Context context) {
        String str;
        String str2;
        String str3;
        Intrinsics.h(context, "context");
        z zVar = f14141a;
        if (zVar.b(context).exists()) {
            AbstractC0216j e5 = AbstractC0216j.e();
            str = a0.f13948a;
            e5.a(str, "Migrating WorkDatabase to the no-backup directory");
            for (Map.Entry entry : zVar.e(context).entrySet()) {
                File file = (File) entry.getKey();
                File file2 = (File) entry.getValue();
                if (file.exists()) {
                    if (file2.exists()) {
                        AbstractC0216j e6 = AbstractC0216j.e();
                        str3 = a0.f13948a;
                        e6.k(str3, "Over-writing contents of " + file2);
                    }
                    String str4 = file.renameTo(file2) ? "Migrated " + file + "to " + file2 : "Renaming " + file + " to " + file2 + " failed";
                    AbstractC0216j e7 = AbstractC0216j.e();
                    str2 = a0.f13948a;
                    e7.a(str2, str4);
                }
            }
        }
    }

    public final File a(Context context) {
        Intrinsics.h(context, "context");
        return c(context);
    }

    public final File b(Context context) {
        Intrinsics.h(context, "context");
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        Intrinsics.g(databasePath, "context.getDatabasePath(WORK_DATABASE_NAME)");
        return databasePath;
    }

    public final Map e(Context context) {
        String[] strArr;
        Intrinsics.h(context, "context");
        File b5 = b(context);
        File a5 = a(context);
        strArr = a0.f13949b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.e(MapsKt.e(strArr.length), 16));
        for (String str : strArr) {
            Pair a6 = TuplesKt.a(new File(b5.getPath() + str), new File(a5.getPath() + str));
            linkedHashMap.put(a6.getFirst(), a6.getSecond());
        }
        return MapsKt.p(linkedHashMap, TuplesKt.a(b5, a5));
    }
}
