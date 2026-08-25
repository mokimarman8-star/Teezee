package com.transsion.postdetail.shorttv.factory;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k implements ur.k {
    private ShareDialogFragment a;

    public static final class a implements com.transsion.share.share.a {
        a() {
        }

        @Override // com.transsion.share.share.a
        public void a(String str, PostType postType) {
            Intrinsics.h(str, "id");
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
        }

        @Override // com.transsion.share.share.a
        public void c(String str, String str2, String str3, String str4) {
            Intrinsics.h(str, "url");
            Intrinsics.h(str2, "fileName");
            Intrinsics.h(str3, "fileSize");
            Intrinsics.h(str4, "fileImage");
        }

        @Override // com.transsion.share.share.a
        public void d(String str) {
            Intrinsics.h(str, "id");
        }

        @Override // com.transsion.share.share.a
        public void e(String str) {
            a.C0056a.c(this, str);
        }
    }

    private final ShareDialogFragment b(String str, String str2, String str3) {
        ShareDialogFragment a2;
        a2 = ShareDialogFragment.INSTANCE.a(PostType.SHORT_TV_TYPE, str, BuildConfig.FLAVOR, "TYPE_SUBJECT", (r29 & 16) != 0 ? BuildConfig.FLAVOR : str2, (r29 & 32) != 0 ? BuildConfig.FLAVOR : null, (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : false, (r29 & 256) != 0 ? false : false, str3, (r29 & 1024) != 0 ? BuildConfig.FLAVOR : null, (r29 & 2048) != 0 ? BuildConfig.FLAVOR : null);
        return a2;
    }

    @Override // ur.k
    public void a(Fragment fragment, String str, String str2, String str3) {
        ShareDialogFragment shareDialogFragment;
        Intrinsics.h(str3, "pageName");
        if (this.a == null) {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            ShareDialogFragment b = b(str, str2, str3);
            this.a = b;
            if (b != null) {
                b.G0(new a());
            }
        }
        if (fragment != null) {
            try {
                if (fragment.isAdded()) {
                    FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                    childFragmentManager.g0();
                    ShareDialogFragment shareDialogFragment2 = this.a;
                    if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.k0("share") == null && (shareDialogFragment = this.a) != null) {
                        shareDialogFragment.show(childFragmentManager, "share");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
