package u5;

import android.os.Build;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    private static final String[] a = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
    private static final String[] b = {"android.permission.CAMERA"};
    private static final String[] c = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};
    private static final String[] d = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"};
    private static final String[] e = {"android.permission.RECORD_AUDIO"};
    private static final String[] f = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};
    private static final String[] g = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};
    private static final String[] h = {"android.permission.BODY_SENSORS"};
    private static final String[] i = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
    private static final String[] j = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final String[] k = {"android.permission.ACTIVITY_RECOGNITION"};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x007d, code lost:
    
        if (r3.equals("LOCATION") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] a(String str) {
        char c2 = 0;
        if (str == null) {
            return new String[0];
        }
        switch (str.hashCode()) {
            case -1611296843:
                break;
            case -1596608551:
                if (str.equals("SENSORS")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1166291365:
                if (str.equals("STORAGE")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 82233:
                if (str.equals("SMS")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 76105038:
                if (str.equals("PHONE")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 140654183:
                if (str.equals("ACTIVITY_RECOGNITION")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 215175251:
                if (str.equals("CONTACTS")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 604302142:
                if (str.equals("CALENDAR")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 1856013610:
                if (str.equals("MICROPHONE")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1980544805:
                if (str.equals("CAMERA")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return d;
            case 1:
                return h;
            case 2:
                return j;
            case 3:
                return i;
            case 4:
                return Build.VERSION.SDK_INT < 26 ? g : f;
            case 5:
                return k;
            case 6:
                return c;
            case 7:
                return a;
            case '\b':
                return e;
            case '\t':
                return b;
            default:
                return new String[]{str};
        }
    }
}
