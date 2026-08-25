package androidx.coroutines.util;

import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y3.e;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract /* synthetic */ class k {
    public static final int a(e eVar, String str) {
        Intrinsics.h(eVar, "<this>");
        Intrinsics.h(str, "name");
        int b5 = i.b(eVar, str);
        if (b5 >= 0) {
            return b5;
        }
        int b6 = i.b(eVar, '`' + str + '`');
        return b6 >= 0 ? b6 : b(eVar, str);
    }

    private static final int b(e eVar, String str) {
        if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
            int columnCount = eVar.getColumnCount();
            String str2 = '.' + str;
            String str3 = '.' + str + '`';
            for (int i5 = 0; i5 < columnCount; i5++) {
                String columnName = eVar.getColumnName(i5);
                if (columnName.length() >= str.length() + 2) {
                    if (StringsKt.G(columnName, str2, false, 2, (Object) null)) {
                        return i5;
                    }
                    if (columnName.charAt(0) == '`' && StringsKt.G(columnName, str3, false, 2, (Object) null)) {
                        return i5;
                    }
                }
            }
        }
        return -1;
    }
}
