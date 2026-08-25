package k1;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class c extends a {

    /* renamed from: b, reason: collision with root package name */
    private Context f16082b;

    /* renamed from: c, reason: collision with root package name */
    private Uri f16083c;

    c(a aVar, Context context, Uri uri) {
        super(aVar);
        this.f16082b = context;
        this.f16083c = uri;
    }

    @Override // k1.a
    public boolean a() {
        return b.a(this.f16082b, this.f16083c);
    }

    @Override // k1.a
    public a b(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // k1.a
    public a c(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // k1.a
    public boolean d() {
        try {
            return DocumentsContract.deleteDocument(this.f16082b.getContentResolver(), this.f16083c);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // k1.a
    public boolean e() {
        return b.c(this.f16082b, this.f16083c);
    }

    @Override // k1.a
    public String i() {
        return b.d(this.f16082b, this.f16083c);
    }

    @Override // k1.a
    public Uri j() {
        return this.f16083c;
    }

    @Override // k1.a
    public long k() {
        return b.f(this.f16082b, this.f16083c);
    }

    @Override // k1.a
    public a[] l() {
        throw new UnsupportedOperationException();
    }
}
