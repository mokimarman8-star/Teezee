package com.amazonaws.services.s3.internal;

import java.util.Date;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface ObjectExpirationResult {
    void setExpirationTime(Date date);

    void setExpirationTimeRuleId(String str);
}
