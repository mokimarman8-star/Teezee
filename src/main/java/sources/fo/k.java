package fo;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.flow.bean.MediaType;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.ninegridview.video.NineGridVideoViewAdapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k extends i {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(NineGridVideoView nineGridVideoView) {
        nineGridVideoView.loadImage();
    }

    @Override // fo.i
    public void A(AppCompatImageView appCompatImageView, PostSubjectItem postSubjectItem) {
        Intrinsics.h(appCompatImageView, "ivCenterIcon");
        Intrinsics.h(postSubjectItem, "item");
        appCompatImageView.setVisibility(8);
    }

    @Override // fo.i
    public void B(final NineGridVideoView nineGridVideoView, PostSubjectItem postSubjectItem) {
        List image;
        Intrinsics.h(nineGridVideoView, "nineGridView");
        Intrinsics.h(postSubjectItem, "item");
        Media media = postSubjectItem.getMedia();
        if (media == null || (image = media.getImage()) == null) {
            return;
        }
        nineGridVideoView.setAdapter(new NineGridVideoViewAdapter(image));
        nineGridVideoView.post(new Runnable() { // from class: fo.j
            @Override // java.lang.Runnable
            public final void run() {
                k.F(NineGridVideoView.this);
            }
        });
    }

    @Override // fo.i
    public void C(AppCompatTextView appCompatTextView, PostSubjectItem postSubjectItem) {
        Intrinsics.h(appCompatTextView, "tvTime");
        Intrinsics.h(postSubjectItem, "item");
        appCompatTextView.setVisibility(8);
    }

    public int l() {
        return MediaType.IMAGE.ordinal();
    }
}
