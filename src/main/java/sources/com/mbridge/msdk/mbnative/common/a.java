package com.mbridge.msdk.mbnative.common;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    public static String a(Exception exc) {
        if (exc == null) {
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
