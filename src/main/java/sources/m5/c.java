package m5;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class c {
    public int a;

    public c(String str, String str2) {
        int parseInt;
        int i;
        int i2;
        int i3;
        if (str.equalsIgnoreCase("hh:mm:ss,ms")) {
            int parseInt2 = Integer.parseInt(str2.substring(0, 2));
            this.a = Integer.parseInt(str2.substring(9, 12)) + (Integer.parseInt(str2.substring(6, 8)) * 1000) + (Integer.parseInt(str2.substring(3, 5)) * 60000) + (parseInt2 * 3600000);
            return;
        }
        if (!str.equalsIgnoreCase("h:mm:ss.cs")) {
            if (str.equalsIgnoreCase("h:m:s:f/fps")) {
                String[] split = str2.split("/");
                float parseFloat = Float.parseFloat(split[1]);
                String[] split2 = split[0].split(":");
                int parseInt3 = Integer.parseInt(split2[0]);
                this.a = ((int) ((Integer.parseInt(split2[3]) * 1000) / parseFloat)) + (Integer.parseInt(split2[2]) * 1000) + (Integer.parseInt(split2[1]) * 60000) + (parseInt3 * 3600000);
                return;
            }
            return;
        }
        String[] split3 = str2.split(":");
        if (split3.length == 4) {
            i2 = Integer.parseInt(split3[0]);
            parseInt = Integer.parseInt(split3[1]);
            i = Integer.parseInt(split3[2]);
            i3 = Integer.parseInt(split3[3]);
        } else {
            int parseInt4 = Integer.parseInt(str2.substring(0, 1));
            parseInt = Integer.parseInt(str2.substring(2, 4));
            int parseInt5 = Integer.parseInt(str2.substring(5, 7));
            int parseInt6 = Integer.parseInt(str2.substring(8, 10));
            i = parseInt5;
            i2 = parseInt4;
            i3 = parseInt6;
        }
        this.a = (i3 * 10) + (i * 1000) + (parseInt * 60000) + (i2 * 3600000);
    }
}
