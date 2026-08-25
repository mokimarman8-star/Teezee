package androidx.coroutines.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {
    public static final Cursor a(Cursor cursor) {
        Intrinsics.h(cursor, "c");
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                int columnCount = cursor.getColumnCount();
                for (int i5 = 0; i5 < columnCount; i5++) {
                    int type = cursor.getType(i5);
                    if (type == 0) {
                        objArr[i5] = null;
                    } else if (type == 1) {
                        objArr[i5] = Long.valueOf(cursor.getLong(i5));
                    } else if (type == 2) {
                        objArr[i5] = Double.valueOf(cursor.getDouble(i5));
                    } else if (type == 3) {
                        objArr[i5] = cursor.getString(i5);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i5] = cursor.getBlob(i5);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            CloseableKt.a(cursor, (Throwable) null);
            return matrixCursor;
        } finally {
        }
    }

    private static final int b(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        Intrinsics.e(columnNames);
        return c(columnNames, str);
    }

    public static final int c(String[] strArr, String str) {
        Intrinsics.h(strArr, "columnNames");
        Intrinsics.h(str, "name");
        String str2 = '.' + str;
        String str3 = '.' + str + '`';
        int length = strArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            String str4 = strArr[i5];
            int i7 = i6 + 1;
            if (str4.length() >= str.length() + 2) {
                if (StringsKt.G(str4, str2, false, 2, (Object) null)) {
                    return i6;
                }
                if (str4.charAt(0) == '`' && StringsKt.G(str4, str3, false, 2, (Object) null)) {
                    return i6;
                }
            }
            i5++;
            i6 = i7;
        }
        return -1;
    }

    public static final int d(Cursor cursor, String str) {
        Intrinsics.h(cursor, "c");
        Intrinsics.h(str, "name");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex('`' + str + '`');
        return columnIndex2 >= 0 ? columnIndex2 : b(cursor, str);
    }

    public static final int e(Cursor cursor, String str) {
        String str2;
        Intrinsics.h(cursor, "c");
        Intrinsics.h(str, "name");
        int d5 = d(cursor, str);
        if (d5 >= 0) {
            return d5;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            Intrinsics.g(columnNames, "getColumnNames(...)");
            str2 = ArraysKt.m0(columnNames, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        } catch (Exception unused) {
            str2 = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }
}
