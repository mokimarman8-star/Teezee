package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.OnFileDelete;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class PartCreationEvent {
    private final File a;
    private final int b;
    private final boolean c;
    private final OnFileDelete d;

    PartCreationEvent(File file, int i, boolean z, OnFileDelete onFileDelete) {
        if (file == null) {
            throw new IllegalArgumentException("part must not be specified");
        }
        this.a = file;
        this.b = i;
        this.c = z;
        this.d = onFileDelete;
    }

    public OnFileDelete a() {
        return this.d;
    }

    public File b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        return this.c;
    }
}
