package com.mbridge.msdk.mbsignalcommon.mapping;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a extends Throwable {
    private Class<?> a;
    private String b;

    public a(Exception exc) {
        super(exc);
    }

    public a(String str) {
        super(str);
    }

    public void a(Class<?> cls) {
        this.a = cls;
    }

    public void a(String str) {
        this.b = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        if (getCause() == null) {
            return super.toString();
        }
        return getClass().getName() + ": " + getCause();
    }
}
