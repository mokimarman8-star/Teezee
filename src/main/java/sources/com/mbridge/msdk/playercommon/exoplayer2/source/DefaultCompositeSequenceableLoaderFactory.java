package com.mbridge.msdk.playercommon.exoplayer2.source;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class DefaultCompositeSequenceableLoaderFactory implements CompositeSequenceableLoaderFactory {
    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.CompositeSequenceableLoaderFactory
    public SequenceableLoader createCompositeSequenceableLoader(SequenceableLoader... sequenceableLoaderArr) {
        return new CompositeSequenceableLoader(sequenceableLoaderArr);
    }
}
