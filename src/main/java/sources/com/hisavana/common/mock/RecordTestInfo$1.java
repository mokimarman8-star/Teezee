package com.hisavana.common.mock;

import com.cloud.sdk.commonutil.util.Preconditions;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class RecordTestInfo$1 implements Preconditions.a {
    final /* synthetic */ int val$code;
    final /* synthetic */ String val$msg;

    RecordTestInfo$1(String str, int i) {
        this.val$msg = str;
        this.val$code = i;
    }

    public void onRun() {
        RecordTestInfo.access$000().log(this.val$msg, this.val$code);
    }
}
