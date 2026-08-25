package com.amazonaws.services.s3.internal;

import java.util.Date;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface ObjectRestoreResult {
    void setOngoingRestore(boolean z);

    void setRestoreExpirationTime(Date date);
}
