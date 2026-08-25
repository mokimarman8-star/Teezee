package com.amazonaws.util.json;

import java.io.Reader;
import java.io.Writer;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface AwsJsonFactory {
    AwsJsonWriter a(Writer writer);

    AwsJsonReader b(Reader reader);
}
