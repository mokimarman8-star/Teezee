package qo;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g {
    public static final g a = new g();

    private g() {
    }

    public final int a(Context context, float f) {
        Intrinsics.h(context, "context");
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final ko.a b(Context context, Uri uri) {
        Intrinsics.h(context, "context");
        if (uri == null) {
            return null;
        }
        String[] strArr = {"_data", "title", "artist", "_size", "height", "width", "duration"};
        ko.a aVar = new ko.a();
        try {
            Cursor query = context.getContentResolver().query(uri, strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        aVar.j(query.getString(query.getColumnIndex("_data")));
                        aVar.l(query.getString(query.getColumnIndex("title")));
                        aVar.h(query.getLong(query.getColumnIndex("duration")));
                        aVar.g(query.getString(query.getColumnIndex("artist")));
                        aVar.k(query.getLong(query.getColumnIndex("_size")));
                        aVar.m(query.getInt(query.getColumnIndex("width")));
                        aVar.i(query.getInt(query.getColumnIndex("height")));
                        String e = aVar.e();
                        long a2 = aVar.a();
                        String c = aVar.c();
                        StringBuilder sb = new StringBuilder();
                        sb.append("ContentUri:title-");
                        sb.append(e);
                        sb.append(" duration:");
                        sb.append(a2);
                        sb.append(" ");
                        sb.append(c);
                        sb.append(" \n uri:");
                        sb.append(uri);
                    }
                } finally {
                }
            }
            Unit unit = Unit.a;
            CloseableKt.a(query, (Throwable) null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar;
    }
}
