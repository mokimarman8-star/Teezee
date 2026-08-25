package com.apm.insight;

import androidx.annotation.Nullable;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface AttachUserData {
    @Nullable
    Map<? extends String, ? extends String> getUserData(CrashType crashType);
}
