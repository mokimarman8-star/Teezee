package androidx.coroutines.util;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import y3.e;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract /* synthetic */ class j {
    public static final int a(e eVar, String str) {
        Intrinsics.h(eVar, "<this>");
        Intrinsics.h(str, "name");
        int columnCount = eVar.getColumnCount();
        for (int i5 = 0; i5 < columnCount; i5++) {
            if (Intrinsics.c(str, eVar.getColumnName(i5))) {
                return i5;
            }
        }
        return -1;
    }

    public static final int b(e eVar, String str) {
        Intrinsics.h(eVar, "stmt");
        Intrinsics.h(str, "name");
        int a5 = i.a(eVar, str);
        if (a5 >= 0) {
            return a5;
        }
        int columnCount = eVar.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i5 = 0; i5 < columnCount; i5++) {
            arrayList.add(eVar.getColumnName(i5));
        }
        throw new IllegalArgumentException("Column '" + str + "' does not exist. Available columns: [" + CollectionsKt.s0(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ']');
    }
}
