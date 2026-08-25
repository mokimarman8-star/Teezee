package com.cloud.tmc.kernel.extension;

import com.cloud.tmc.kernel.extension.Extension;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface ExtensionFilter<T extends Extension> {
    List<T> filter(List<T> list);
}
