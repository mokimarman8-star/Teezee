package com.mbridge.msdk.thrid.okhttp.internal.http2;

import java.io.IOException;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface l {
    public static final l a = new a();

    static class a implements l {
        a() {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.l
        public void a(int i, b bVar) {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.l
        public boolean a(int i, com.mbridge.msdk.thrid.okio.e eVar, int i2, boolean z) throws IOException {
            eVar.skip(i2);
            return true;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.l
        public boolean a(int i, List<c> list) {
            return true;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.l
        public boolean a(int i, List<c> list, boolean z) {
            return true;
        }
    }

    void a(int i, b bVar);

    boolean a(int i, com.mbridge.msdk.thrid.okio.e eVar, int i2, boolean z) throws IOException;

    boolean a(int i, List<c> list);

    boolean a(int i, List<c> list, boolean z);
}
