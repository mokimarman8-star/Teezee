package org.mvel2.util;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class i extends ClassLoader implements k {
    public i(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override // org.mvel2.util.k
    public Class a(String str, byte[] bArr, int i, int i2) {
        return super.defineClass(str, bArr, i, i2);
    }
}
