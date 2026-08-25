package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class TransferDBBase {
    private static final Log f = LogFactory.b(TransferDBBase.class);
    private static final Object g = new Object();
    private final Context a;
    private final Uri b;
    private final UriMatcher c;
    private final TransferDatabaseHelper d;
    private SQLiteDatabase e;

    public TransferDBBase(Context context) {
        this.a = context;
        String packageName = context.getApplicationContext().getPackageName();
        TransferDatabaseHelper transferDatabaseHelper = new TransferDatabaseHelper(context);
        this.d = transferDatabaseHelper;
        this.e = transferDatabaseHelper.getWritableDatabase();
        this.b = Uri.parse("content://" + packageName + "/transfers");
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.c = uriMatcher;
        uriMatcher.addURI(packageName, "transfers", 10);
        uriMatcher.addURI(packageName, "transfers/#", 20);
        uriMatcher.addURI(packageName, "transfers/part/#", 30);
        uriMatcher.addURI(packageName, "transfers/state/*", 40);
    }

    private void c() {
        synchronized (g) {
            try {
                if (!this.e.isOpen()) {
                    this.e = this.d.getWritableDatabase();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int a(Uri uri, ContentValues[] contentValuesArr) {
        int match = this.c.match(uri);
        c();
        if (match != 10) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        int i = 0;
        try {
            try {
                this.e.beginTransaction();
                i = (int) this.e.insertOrThrow("awstransfer", null, contentValuesArr[0]);
                for (int i2 = 1; i2 < contentValuesArr.length; i2++) {
                    contentValuesArr[i2].put("main_upload_id", Integer.valueOf(i));
                    this.e.insertOrThrow("awstransfer", null, contentValuesArr[i2]);
                }
                this.e.setTransactionSuccessful();
            } catch (Exception e) {
                f.e("bulkInsert error : ", e);
            }
            this.e.endTransaction();
            return i;
        } catch (Throwable th) {
            this.e.endTransaction();
            throw th;
        }
    }

    public int b(Uri uri, String str, String[] strArr) {
        int match = this.c.match(uri);
        c();
        if (match == 10) {
            return this.e.delete("awstransfer", str, strArr);
        }
        if (match != 20) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (TextUtils.isEmpty(str)) {
            return this.e.delete("awstransfer", "_id=" + lastPathSegment, null);
        }
        return this.e.delete("awstransfer", "_id=" + lastPathSegment + " and " + str, strArr);
    }

    public Uri d() {
        return this.b;
    }

    public Uri e(Uri uri, ContentValues contentValues) {
        int match = this.c.match(uri);
        c();
        if (match != 10) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        return Uri.parse("transfers/" + this.e.insertOrThrow("awstransfer", null, contentValues));
    }

    public Cursor f(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("awstransfer");
        int match = this.c.match(uri);
        if (match == 10) {
            sQLiteQueryBuilder.appendWhere("part_num=0");
        } else if (match == 20) {
            sQLiteQueryBuilder.appendWhere("_id=" + uri.getLastPathSegment());
        } else if (match == 30) {
            sQLiteQueryBuilder.appendWhere("main_upload_id=" + uri.getLastPathSegment());
        } else {
            if (match != 40) {
                throw new IllegalArgumentException("Unknown URI: " + uri);
            }
            sQLiteQueryBuilder.appendWhere("state=");
            sQLiteQueryBuilder.appendWhereEscapeString(uri.getLastPathSegment());
        }
        c();
        return sQLiteQueryBuilder.query(this.e, strArr, str, strArr2, null, null, str2);
    }

    public synchronized int g(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int update;
        try {
            int match = this.c.match(uri);
            c();
            if (match == 10) {
                update = this.e.update("awstransfer", contentValues, str, strArr);
            } else {
                if (match != 20) {
                    throw new IllegalArgumentException("Unknown URI: " + uri);
                }
                String lastPathSegment = uri.getLastPathSegment();
                if (TextUtils.isEmpty(str)) {
                    update = this.e.update("awstransfer", contentValues, "_id=" + lastPathSegment, null);
                } else {
                    update = this.e.update("awstransfer", contentValues, "_id=" + lastPathSegment + " and " + str, strArr);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return update;
    }
}
