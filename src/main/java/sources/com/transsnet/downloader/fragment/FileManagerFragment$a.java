package com.transsnet.downloader.fragment;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class FileManagerFragment$a {
    private FileManagerFragment$a() {
    }

    public /* synthetic */ FileManagerFragment$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final FileManagerFragment a(int i) {
        FileManagerFragment fileManagerFragment = new FileManagerFragment();
        fileManagerFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("extra_page_index", Integer.valueOf(i))}));
        return fileManagerFragment;
    }
}
