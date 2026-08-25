package nr;

import com.transsion.shorttv.bean.Media;
import com.transsion.shorttv.bean.ShortTVItem;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class l {
    public static final boolean a(e eVar) {
        ShortTVItem d;
        Media video;
        return ((eVar == null || (d = eVar.d()) == null || (video = d.getVideo()) == null) ? null : video.getVideoAddress()) != null;
    }

    public static final boolean b(e eVar) {
        Media video;
        if (eVar != null) {
            ShortTVItem d = eVar.d();
            if (((d == null || (video = d.getVideo()) == null) ? null : video.getVideoAddress()) != null) {
                return false;
            }
        }
        return true;
    }
}
