package com.transsion.athena.hatnea;

import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ehatna {
    public String a;
    public byte[] b;
    public int c;
    public List<Integer> d;
    public String e;
    public String f;

    private ehatna(String str, byte[] bArr, int i, List<Integer> list, String str2, String str3) {
        this.a = str;
        this.b = bArr;
        this.c = i;
        this.d = list;
        this.e = str2;
        this.f = str3;
    }

    public static ehatna a(String str, byte[] bArr, int i, List<Integer> list, String str2, String str3) {
        return new ehatna(str, bArr, i, list, str2, str3);
    }

    public String toString() {
        return "UploadEventsRequest{host='" + this.a + "', data=" + Arrays.toString(this.b) + ", lineNumber=" + this.c + ", appidList=" + this.d + ", packetUid='" + this.e + "', dupid='" + this.f + "'}";
    }
}
