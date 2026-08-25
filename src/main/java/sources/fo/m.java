package fo;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.flow.bean.MediaType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.ninegridview.video.NineGridVideoViewAdapter;
import com.transsion.postdetail.R$drawable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m extends i {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(NineGridVideoView nineGridVideoView) {
        nineGridVideoView.loadImage();
    }

    @Override // fo.i
    public void A(AppCompatImageView appCompatImageView, PostSubjectItem postSubjectItem) {
        Intrinsics.h(appCompatImageView, "ivCenterIcon");
        Intrinsics.h(postSubjectItem, "item");
        appCompatImageView.setImageResource(R$drawable.post_video_play);
    }

    @Override // fo.i
    public void B(final NineGridVideoView nineGridVideoView, PostSubjectItem postSubjectItem) {
        Cover cover;
        Intrinsics.h(nineGridVideoView, "nineGridView");
        Intrinsics.h(postSubjectItem, "item");
        ArrayList arrayList = new ArrayList();
        Media media = postSubjectItem.getMedia();
        if (media != null && (cover = media.getCover()) != null) {
            arrayList.add(new Image(cover.getHeight(), cover.getSize(), cover.getUrl(), cover.getWidth(), cover.getFormat(), cover.getThumbnail(), cover.getGifBean(), cover.getAverageHueLight(), cover.getAverageHueDark(), 0.0f, 0.0f, 0, 0, 0, 15872, (DefaultConstructorMarker) null));
        }
        nineGridVideoView.setAdapter(new NineGridVideoViewAdapter(arrayList));
        nineGridVideoView.post(new Runnable() { // from class: fo.l
            @Override // java.lang.Runnable
            public final void run() {
                m.F(NineGridVideoView.this);
            }
        });
    }

    @Override // fo.i
    public void C(AppCompatTextView appCompatTextView, PostSubjectItem postSubjectItem) {
        List video;
        Intrinsics.h(appCompatTextView, "tvTime");
        Intrinsics.h(postSubjectItem, "item");
        Media media = postSubjectItem.getMedia();
        if (media == null || (video = media.getVideo()) == null) {
            appCompatTextView.setVisibility(8);
        } else {
            if (video.isEmpty()) {
                return;
            }
            Number duration = ((Video) video.get(0)).getDuration();
            if (duration == null) {
                duration = 0L;
            }
            appCompatTextView.setText(TimeUtilKt.p(duration.longValue()));
        }
    }

    public int l() {
        return MediaType.VIDEO.ordinal();
    }
}
