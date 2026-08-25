package com.google.common.hash;

import java.nio.charset.Charset;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface d {
    HashCode hashObject(Object obj, Funnel funnel);

    HashCode hashString(CharSequence charSequence, Charset charset);

    e newHasher();
}
