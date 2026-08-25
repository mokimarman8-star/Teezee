package org.chromium.net;

import java.util.concurrent.RejectedExecutionException;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class InlineExecutionProhibitedException extends RejectedExecutionException {
    public InlineExecutionProhibitedException() {
        super("Inline execution is prohibited for this request");
    }
}
