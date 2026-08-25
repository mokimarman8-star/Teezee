package k1;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class d extends a {

    /* renamed from: b, reason: collision with root package name */
    private Context f16084b;

    /* renamed from: c, reason: collision with root package name */
    private Uri f16085c;

    d(a aVar, Context context, Uri uri) {
        super(aVar);
        this.f16084b = context;
        this.f16085c = uri;
    }

    private static void m(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception unused) {
            }
        }
    }

    private static Uri n(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // k1.a
    public boolean a() {
        return b.a(this.f16084b, this.f16085c);
    }

    @Override // k1.a
    public a b(String str) {
        Uri n5 = n(this.f16084b, this.f16085c, "vnd.android.document/directory", str);
        if (n5 != null) {
            return new d(this, this.f16084b, n5);
        }
        return null;
    }

    @Override // k1.a
    public a c(String str, String str2) {
        Uri n5 = n(this.f16084b, this.f16085c, str, str2);
        if (n5 != null) {
            return new d(this, this.f16084b, n5);
        }
        return null;
    }

    @Override // k1.a
    public boolean d() {
        try {
            return DocumentsContract.deleteDocument(this.f16084b.getContentResolver(), this.f16085c);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // k1.a
    public boolean e() {
        return b.c(this.f16084b, this.f16085c);
    }

    @Override // k1.a
    public String i() {
        return b.d(this.f16084b, this.f16085c);
    }

    @Override // k1.a
    public Uri j() {
        return this.f16085c;
    }

    @Override // k1.a
    public long k() {
        return b.f(this.f16084b, this.f16085c);
    }

    @Override // k1.a
    public a[] l() {
        ContentResolver contentResolver = this.f16084b.getContentResolver();
        Uri uri = this.f16085c;
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
                while (cursor.moveToNext()) {
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.f16085c, cursor.getString(0)));
                }
            } catch (Exception e5) {
                Log.w("DocumentFile", "Failed query: " + e5);
            }
            Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
            a[] aVarArr = new a[uriArr.length];
            for (int i5 = 0; i5 < uriArr.length; i5++) {
                aVarArr[i5] = new d(this, this.f16084b, uriArr[i5]);
            }
            return aVarArr;
        } finally {
            m(cursor);
        }
    }
}
