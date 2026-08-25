package com.google.firebase.crashlytics.ndk;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class CrashpadMain {
    public static native void crashpadMain(String[] strArr);

    public static void main(String[] strArr) {
        try {
            String str = strArr[1];
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Path to shared objects is ");
            sb2.append(str);
            System.load(str + "libcrashlytics-handler.so");
            crashpadMain(strArr);
        } catch (UnsatisfiedLinkError e) {
            throw new RuntimeException(e);
        }
    }
}
