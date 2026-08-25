package wm;

import com.transsion.flow.bean.MediaType;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class b {
    public static final boolean a(Media media) {
        List<Image> image;
        GifBean gifBean;
        String videoUrl;
        if (!Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.IMAGE.getValue()) || (image = media.getImage()) == null) {
            return false;
        }
        for (Image image2 : image) {
            if (image2.getGifBean() != null && (gifBean = image2.getGifBean()) != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                return true;
            }
        }
        return false;
    }
}
