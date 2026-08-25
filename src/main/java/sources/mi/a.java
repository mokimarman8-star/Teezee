package mi;

import com.transsion.gslb.BuildConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    public static String a(long j) {
        long j2;
        long j3;
        Object valueOf;
        Object valueOf2;
        String str;
        long j4 = j / 1000;
        try {
            long j5 = j4 % 3600;
            if (j4 > 3600) {
                j3 = j4 / 3600;
                if (j5 == 0) {
                    j2 = 0;
                    j5 = 0;
                } else if (j5 > 60) {
                    j2 = j5 / 60;
                    j5 = j5 % 60 != 0 ? j5 % 60 : 0L;
                } else {
                    j2 = 0;
                }
            } else {
                j2 = j4 / 60;
                if (j4 % 60 != 0) {
                    j5 = j4 % 60;
                    j3 = 0;
                } else {
                    j3 = 0;
                    j5 = 0;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (j3 < 10) {
                valueOf = "0" + j3;
            } else {
                valueOf = Long.valueOf(j3);
            }
            sb.append(valueOf);
            sb.append(":");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            if (j2 < 10) {
                valueOf2 = "0" + j2;
            } else {
                valueOf2 = Long.valueOf(j2);
            }
            sb3.append(valueOf2);
            sb3.append(":");
            String sb4 = sb3.toString();
            if (j5 < 10) {
                str = "0" + j5;
            } else {
                str = j5 + BuildConfig.FLAVOR;
            }
            if (j3 == 0) {
                sb2 = BuildConfig.FLAVOR;
            }
            if (j3 == 0 && j2 == 60) {
                sb2 = "01:";
                sb4 = "00:";
            }
            return sb2 + sb4 + str;
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }
}
