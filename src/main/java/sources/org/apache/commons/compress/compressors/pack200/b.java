package org.apache.commons.compress.compressors.pack200;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class b extends FilterOutputStream {
    private final Object a;

    protected b() {
        this(null);
    }

    protected b(OutputStream outputStream) {
        super(outputStream);
        this.a = new Object();
    }
}
