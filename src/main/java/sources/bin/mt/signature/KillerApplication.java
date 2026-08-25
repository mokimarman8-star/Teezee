package bin.mt.signature;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.lsposed.hiddenapibypass.HiddenApiBypass;

/* loaded from: /home/user/Teezee-git/app_source/classes9.dex */
public class KillerApplication extends Application {
    public static final String URL = "https://github.com/L-JINBIN/ApkSignatureKillerEx";

    static {
        killPM("com.community.oneroom", "MIIDcTCCAlmgAwIBAgIEHfgaIzANBgkqhkiG9w0BAQsFADBoMQswCQYDVQQGEwJDTjERMA8GA1UE\nCBMIc2hhbmdoYWkxETAPBgNVBAcTCHNoYW5naGFpMQswCQYDVQQKEwJtaTESMBAGA1UECxMJdHJh\nbnNzaW9uMRIwEAYDVQQDEwl0c29uZXJvb20wIBcNMjIwNzE1MDYxMjM5WhgPMjEyMTA2MjEwNjEy\nMzlaMGgxCzAJBgNVBAYTAkNOMREwDwYDVQQIEwhzaGFuZ2hhaTERMA8GA1UEBxMIc2hhbmdoYWkx\nCzAJBgNVBAoTAm1pMRIwEAYDVQQLEwl0cmFuc3Npb24xEjAQBgNVBAMTCXRzb25lcm9vbTCCASIw\nDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJNGGRDEkB7PAdQiWEsFPHyCFbhADX7i8/XbiELN\nMV7DmdtodVkISEXRxWbWqu2CKxnvK1Aq5Qbn50AJGpdkJx6DWEPtHQzl2OZvvldmdtVRgX0MujL7\nv0rK4NFlJGyQ7KKvmY1f8ymg3jSal9zj7SQ0yTvuo+xxzvzNly1f4BZC8spU1LMquQEUEWSdaH4b\nwfi85mmI4SIjnXHExY3cOtQ+dJpAQ07hKYb0Tp/Gc7h2Er+CI/rHBOVds7hdwN0dUK7Dr1nrcfhD\nb8sVTSfWGog6bVbQMgXMUHySYXI6hhEE7Ww9g7NJlVLzgjawiqQmXU1AFKIGkAOLqxGc3LO7licC\nAwEAAaMhMB8wHQYDVR0OBBYEFPhF9NTKPS53Ky1VpHlJ9A7KtgZIMA0GCSqGSIb3DQEBCwUAA4IB\nAQBU4giovyh8cOLL864VVyErzONrMBKKOyaGCa2z3OqPm1d5NwVWvhxO1ct/3z6hjhGj5GtgUOjg\n1IqpVPOdkSS9rYgAso/RJ3Ed7/09WapKQ51drchzOV8qEpVruQ7YHwbcYb9ebcibPxKG+7P9EdXw\nhn55/cbZ+/eyqTIw3BGWEgF93JiHY8E32rAf8OnHZVXENaxAVBTSVoallVLrYDf+6yh1XNFU9SHL\nh6xd1k46u83XIJ1e8jCvRdmPfGZgmsvRywz2CHsg1R6UHFNQYsCDN1ivtAbEWdBGcMKZpIyM8stL\n7Y4NX7g27EhoYeo+cXCbT29mwyWkrK7BpSr1h8Vj\n");
        killOpen("com.community.oneroom");
    }

    private static Field findField(Class<?> cls, String str) throws NoSuchFieldException {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException e) {
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null || cls.equals(Object.class)) {
                    break;
                }
                try {
                    Field declaredField2 = cls.getDeclaredField(str);
                    declaredField2.setAccessible(true);
                    return declaredField2;
                } catch (NoSuchFieldException unused) {
                }
            }
            throw e;
        }
    }

    private static String getApkPath(String str) {
        String str2;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
            do {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedReader.close();
                        return null;
                    }
                    str2 = readLine.split("\\s+")[r1.length - 1];
                } finally {
                }
            } while (!isApkPath(str, str2));
            bufferedReader.close();
            return str2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static File getDataFile(String str) {
        String name = Environment.getExternalStorageDirectory().getName();
        if (name.matches("\\d+")) {
            File file = new File("/data/user/" + name + "/" + str);
            if (file.canWrite()) {
                return file;
            }
        }
        return new File("/data/data/" + str);
    }

    private static native void hookApkPath(String str, String str2);

    private static boolean isApkPath(String str, String str2) {
        if (str2.startsWith("/") && str2.endsWith(".apk")) {
            String[] split = str2.substring(1).split("/", 6);
            int length = split.length;
            if (length == 4 || length == 5) {
                if (split[0].equals("data") && split[1].equals("app") && split[length - 1].equals("base.apk")) {
                    return split[length - 2].startsWith(str);
                }
                if (split[0].equals("mnt") && split[1].equals("asec") && split[length - 1].equals("pkg.apk")) {
                    return split[length - 2].startsWith(str);
                }
            } else if (length == 3) {
                if (split[0].equals("data") && split[1].equals("app")) {
                    return split[2].startsWith(str);
                }
            } else if (length == 6 && split[0].equals("mnt") && split[1].equals("expand") && split[3].equals("app") && split[5].equals("base.apk")) {
                return split[4].endsWith(str);
            }
        }
        return false;
    }

    private static void killOpen(String str) {
        try {
            System.loadLibrary("SignatureKiller");
            String apkPath = getApkPath(str);
            if (apkPath == null) {
                System.err.println("Get apk path failed");
                return;
            }
            File file = new File(apkPath);
            File file2 = new File(getDataFile(str), "origin.apk");
            try {
                ZipFile zipFile = new ZipFile(file);
                try {
                    ZipEntry entry = zipFile.getEntry("assets/SignatureKiller/origin.apk");
                    if (entry == null) {
                        System.err.println("Entry not found: assets/SignatureKiller/origin.apk");
                        zipFile.close();
                        return;
                    }
                    if (!file2.exists() || file2.length() != entry.getSize()) {
                        InputStream inputStream = zipFile.getInputStream(entry);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            try {
                                byte[] bArr = new byte[102400];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                }
                                fileOutputStream.close();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } finally {
                            }
                        } finally {
                        }
                    }
                    zipFile.close();
                    hookApkPath(file.getAbsolutePath(), file2.getAbsolutePath());
                } finally {
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable unused) {
            System.err.println("Load SignatureKiller library failed");
        }
    }

    private static void killPM(final String str, String str2) {
        final Signature signature = new Signature(Base64.decode(str2, 0));
        final Parcelable.Creator creator = PackageInfo.CREATOR;
        try {
            findField(PackageInfo.class, "CREATOR").set(null, new Parcelable.Creator<PackageInfo>() { // from class: bin.mt.signature.KillerApplication.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public PackageInfo createFromParcel(Parcel parcel) {
                    Signature[] apkContentsSigners;
                    PackageInfo packageInfo = (PackageInfo) creator.createFromParcel(parcel);
                    if (packageInfo.packageName.equals(str)) {
                        if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                            packageInfo.signatures[0] = signature;
                        }
                        if (Build.VERSION.SDK_INT >= 28 && packageInfo.signingInfo != null && (apkContentsSigners = packageInfo.signingInfo.getApkContentsSigners()) != null && apkContentsSigners.length > 0) {
                            apkContentsSigners[0] = signature;
                        }
                    }
                    return packageInfo;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public PackageInfo[] newArray(int i) {
                    return (PackageInfo[]) creator.newArray(i);
                }
            });
            if (Build.VERSION.SDK_INT >= 28) {
                HiddenApiBypass.addHiddenApiExemptions("Landroid/os/Parcel;", "Landroid/content/pm", "Landroid/app");
            }
            try {
                Object obj = findField(PackageManager.class, "sPackageInfoCache").get(null);
                obj.getClass().getMethod("clear", new Class[0]).invoke(obj, new Object[0]);
            } catch (Throwable unused) {
            }
            try {
                ((Map) findField(Parcel.class, "mCreators").get(null)).clear();
            } catch (Throwable unused2) {
            }
            try {
                ((Map) findField(Parcel.class, "sPairedCreators").get(null)).clear();
            } catch (Throwable unused3) {
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
