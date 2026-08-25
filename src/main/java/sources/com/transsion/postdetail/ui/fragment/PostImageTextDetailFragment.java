package com.transsion.postdetail.ui.fragment;

import android.os.Bundle;
import androidx.appcompat.widget.AppCompatImageView;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u0003¨\u0006\r"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/PostImageTextDetailFragment;", "Lcom/transsion/postdetail/ui/fragment/PostDetailCommonFragment;", "<init>", "()V", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", BuildConfig.FLAVOR, "G0", "initAudioListener", "F0", "k", "a", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostImageTextDetailFragment extends PostDetailCommonFragment {

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.transsion.postdetail.ui.fragment.PostImageTextDetailFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PostImageTextDetailFragment a(String str, boolean z, String str2, PostSubjectItem postSubjectItem, String str3) {
            PostImageTextDetailFragment postImageTextDetailFragment = new PostImageTextDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putBoolean("from_comment", z);
            bundle.putString("rec_ops", str2);
            postImageTextDetailFragment.setArguments(bundle);
            return postImageTextDetailFragment;
        }
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public void F0() {
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public void G0() {
        AppCompatImageView appCompatImageView;
        wn.m mVar = (wn.m) getMViewBinding();
        if (mVar == null || (appCompatImageView = mVar.o) == null) {
            return;
        }
        appCompatImageView.setImageResource(R.drawable.libui_ic_base_left);
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public String getPageName() {
        return "postdetail_image_text";
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public void initAudioListener() {
    }
}
