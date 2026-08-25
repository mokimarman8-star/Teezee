package com.transsion.usercenter.setting.labelsfeedback.sender;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.work.WorkInfo;
import com.transsion.usercenter.R$string;
import fh.b;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class FBSender$a implements c0 {
    final /* synthetic */ LiveData a;
    final /* synthetic */ String b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[WorkInfo.State.values().length];
            try {
                iArr[WorkInfo.State.SUCCEEDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkInfo.State.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    FBSender$a(LiveData liveData, String str) {
        this.a = liveData;
        this.b = str;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onChanged(WorkInfo workInfo) {
        WorkInfo.State a2 = workInfo != null ? workInfo.a() : null;
        int i = a2 == null ? -1 : a.a[a2.ordinal()];
        if (i == 1) {
            b.a.d(R$string.feedback_tips_suceess);
            this.a.o(this);
            FBSender.c(FBSender.a, (String) null);
        } else {
            if (i != 2) {
                return;
            }
            b.a.d(R$string.feedback_tips_failed);
            this.a.o(this);
            FBSender.c(FBSender.a, this.b);
        }
    }
}
