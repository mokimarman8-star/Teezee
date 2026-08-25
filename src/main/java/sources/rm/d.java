package rm;

import com.transsion.flow.bean.PreVideoAddress;
import com.transsion.moviedetailapi.bean.Video;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class d {
    public static final Video a(PreVideoAddress preVideoAddress) {
        Intrinsics.h(preVideoAddress, "<this>");
        Integer bitrate = preVideoAddress.getBitrate();
        String definition = preVideoAddress.getDefinition();
        Integer valueOf = definition != null ? Integer.valueOf(Integer.parseInt(definition)) : null;
        Integer duration = preVideoAddress.getDuration();
        Integer fps = preVideoAddress.getFps();
        Integer height = preVideoAddress.getHeight();
        Long size = preVideoAddress.getSize();
        return new Video(bitrate, valueOf, duration, fps, height, size != null ? Integer.valueOf((int) size.longValue()) : null, preVideoAddress.getUrl(), preVideoAddress.getWidth());
    }
}
