package vz;

import com.transsion.baselib.report.recent_event.ActionEvent;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public abstract class a0 {
    static void a(int i, d dVar) {
        int i2 = i >>> 24;
        if (i2 != 0 && i2 != 1) {
            switch (i2) {
                case 16:
                case ActionEvent.want_to_see_cancel /* 17 */:
                case 18:
                case 23:
                    break;
                case ActionEvent.search_cover_expose /* 19 */:
                case ActionEvent.search_cover_click /* 20 */:
                case 21:
                    dVar.g(i2);
                    return;
                case 22:
                    break;
                default:
                    switch (i2) {
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                            break;
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            dVar.i(i);
                            return;
                        default:
                            throw new IllegalArgumentException();
                    }
            }
            dVar.e(i2, (i & 16776960) >> 8);
            return;
        }
        dVar.k(i >>> 16);
    }
}
