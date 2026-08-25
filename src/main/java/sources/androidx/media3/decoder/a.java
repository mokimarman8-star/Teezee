package androidx.media3.decoder;

import androidx.core.view.accessibility.AccessibilityEventCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {
    private int flags;

    public final void addFlag(int i5) {
        this.flags = i5 | this.flags;
    }

    public void clear() {
        this.flags = 0;
    }

    public final void clearFlag(int i5) {
        this.flags = (~i5) & this.flags;
    }

    protected final boolean getFlag(int i5) {
        return (this.flags & i5) == i5;
    }

    public final boolean hasSupplementalData() {
        return getFlag(268435456);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isFirstSample() {
        return getFlag(134217728);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final boolean isLastSample() {
        return getFlag(536870912);
    }

    public final boolean notDependedOn() {
        return getFlag(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    }

    public final void setFlags(int i5) {
        this.flags = i5;
    }
}
