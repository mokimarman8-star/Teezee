package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class ImageHeaderParserRegistry {
    private final List<ImageHeaderParser> parsers = new ArrayList();

    public synchronized void add(@NonNull ImageHeaderParser imageHeaderParser) {
        this.parsers.add(imageHeaderParser);
    }

    @NonNull
    public synchronized List<ImageHeaderParser> getParsers() {
        return this.parsers;
    }
}
