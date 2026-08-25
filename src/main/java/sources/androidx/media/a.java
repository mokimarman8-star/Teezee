package androidx.media;

import android.os.Bundle;
import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {
    public static boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        return bundle == null ? bundle2.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1 : bundle2 == null ? bundle.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1 : bundle.getInt("android.media.browse.extra.PAGE", -1) == bundle2.getInt("android.media.browse.extra.PAGE", -1) && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    }

    public static boolean b(Bundle bundle, Bundle bundle2) {
        int i5;
        int i6;
        int i7;
        int i8 = bundle == null ? -1 : bundle.getInt("android.media.browse.extra.PAGE", -1);
        int i9 = bundle2 == null ? -1 : bundle2.getInt("android.media.browse.extra.PAGE", -1);
        int i10 = bundle == null ? -1 : bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        int i11 = bundle2 == null ? -1 : bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        int i12 = DescriptorProtos$Edition.EDITION_MAX_VALUE;
        if (i8 == -1 || i10 == -1) {
            i5 = Integer.MAX_VALUE;
            i6 = 0;
        } else {
            i6 = i8 * i10;
            i5 = (i10 + i6) - 1;
        }
        if (i9 == -1 || i11 == -1) {
            i7 = 0;
        } else {
            i7 = i9 * i11;
            i12 = (i11 + i7) - 1;
        }
        return i5 >= i7 && i12 >= i6;
    }
}
