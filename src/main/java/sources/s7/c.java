package s7;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class c {
    public static String a(int i) {
        if (i == 2) {
            return "VERBOSE";
        }
        if (i == 3) {
            return "DEBUG";
        }
        if (i == 4) {
            return "INFO";
        }
        if (i == 5) {
            return "WARN";
        }
        if (i == 6) {
            return "ERROR";
        }
        if (i < 2) {
            return "VERBOSE-" + (2 - i);
        }
        return "ERROR+" + (i - 6);
    }

    public static String b(int i) {
        if (i == 2) {
            return "V";
        }
        if (i == 3) {
            return "D";
        }
        if (i == 4) {
            return "I";
        }
        if (i == 5) {
            return "W";
        }
        if (i == 6) {
            return "E";
        }
        if (i < 2) {
            return "V-" + (2 - i);
        }
        return "E+" + (i - 6);
    }
}
