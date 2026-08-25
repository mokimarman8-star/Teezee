package com.cloud.tmc.kernel.extension.registry;

import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.extension.Extension;
import com.cloud.tmc.kernel.extension.ExtensionRegistry;
import com.cloud.tmc.kernel.extension.ExtensionType;
import com.cloud.tmc.kernel.extension.action.ActionMeta;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Scope;
import com.cloud.tmc.kernel.utils.ClassLoaderUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class DefaultExtensionRegistry implements ExtensionRegistry {
    private static final String TAG = "TmcKernel:DefaultExtensionRegistry";
    private final Set<Class<? extends Extension>> mExtensionClassRegisteredSet = new HashSet();
    private final Map<String, List<ExtensionMetaInfo>> mPointToMetaInfoMap = new HashMap();
    private final Map<String, List<Class<? extends Extension>>> mPointToExtensionClazzMap = new HashMap();
    private final Map<String, Class<? extends Scope>> mClassNameScopeMap = new HashMap();
    private final List<ExtensionMetaInfo> mExtensionMetaInfoList = new LinkedList();
    private BridgeExtensionRegistry mBridgeExtensionRegistry = new BridgeExtensionRegistry();

    /* JADX WARN: Multi-variable type inference failed */
    private List<Class<? extends Extension>> collectExtensionPoint(Class<? extends Extension> cls, List<Class<? extends Extension>> list) {
        List<Class<? extends Extension>> list2 = list;
        if (list == null) {
            list2 = new LinkedList();
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (Extension.class.isAssignableFrom(cls2)) {
                list2.add(cls2);
            }
        }
        return Extension.class.isAssignableFrom(cls.getSuperclass()) ? collectExtensionPoint(cls.getSuperclass(), list2) : list2;
    }

    private void putScope(Class<? extends Extension> cls, Class<? extends Scope> cls2) {
        putScope(cls.getName(), cls2);
    }

    private void putScope(String str, Class<? extends Scope> cls) {
        if (this.mClassNameScopeMap.containsKey(str)) {
            return;
        }
        this.mClassNameScopeMap.put(str, cls);
    }

    protected Extension createExtensionInstance(Class<? extends Extension> cls) throws IllegalAccessException, InstantiationException {
        return cls.newInstance();
    }

    @Override // com.cloud.tmc.kernel.extension.ExtensionRegistry
    public ActionMeta findActionMeta(String str) {
        return this.mBridgeExtensionRegistry.findActionMeta(str);
    }

    @Override // com.cloud.tmc.kernel.extension.ExtensionRegistry
    @Nullable
    public List<Class<? extends Extension>> findExtensions(String str) {
        List<ExtensionMetaInfo> list = this.mPointToMetaInfoMap.get(str);
        if (list != null) {
            for (ExtensionMetaInfo extensionMetaInfo : list) {
                Class<? extends Extension> loadClass = ClassLoaderUtils.loadClass(extensionMetaInfo.bundleName, extensionMetaInfo.extensionClass);
                if (loadClass == null) {
                    TmcLogger.e(TAG, "load meta " + extensionMetaInfo.extensionClass + " error!");
                } else {
                    synchronized (this.mExtensionClassRegisteredSet) {
                        try {
                            if (!this.mExtensionClassRegisteredSet.contains(loadClass)) {
                                register(loadClass, extensionMetaInfo.scope);
                            }
                        } finally {
                        }
                    }
                }
            }
            this.mPointToMetaInfoMap.remove(str);
        }
        return this.mPointToExtensionClazzMap.get(str);
    }

    @Override // com.cloud.tmc.kernel.extension.ExtensionRegistry
    public int getActionCount() {
        return this.mBridgeExtensionRegistry.getRegisteredActionCount();
    }

    @Override // com.cloud.tmc.kernel.extension.ExtensionRegistry
    public Class<? extends Extension> getExtensionClass(String str) {
        for (Class<? extends Extension> cls : this.mExtensionClassRegisteredSet) {
            if (cls.getName().equals(str)) {
                return cls;
            }
        }
        for (ExtensionMetaInfo extensionMetaInfo : this.mExtensionMetaInfoList) {
            if (str.equals(extensionMetaInfo.extensionClass)) {
                return ClassLoaderUtils.loadClass(extensionMetaInfo.bundleName, extensionMetaInfo.extensionClass);
            }
        }
        return null;
    }

    @Override // com.cloud.tmc.kernel.extension.ExtensionRegistry
    public Class<? extends Scope> getScope(Class<? extends Extension> cls) {
        return getScope(cls.getName());
    }

    @Override // com.cloud.tmc.kernel.extension.ExtensionRegistry
    public Class<? extends Scope> getScope(String str) {
        return this.mClassNameScopeMap.get(str);
    }

    @Override // com.cloud.tmc.kernel.extension.ExtensionRegistry
    public synchronized void register(ExtensionMetaInfo extensionMetaInfo) {
        try {
            ExtensionType extensionType = extensionMetaInfo.type;
            ExtensionType extensionType2 = ExtensionType.BRIDGE;
            if (extensionType == extensionType2) {
                TmcLogger.d(TAG, "register meta: " + extensionMetaInfo.extensionClass);
            } else {
                TmcLogger.debug(TAG, "register meta: " + extensionMetaInfo.extensionClass);
            }
            if (!extensionMetaInfo.isLazy) {
                ClassLoaderUtils.loadClass(extensionMetaInfo.bundleName, extensionMetaInfo.extensionClass);
            }
            ExtensionType extensionType3 = ExtensionType.NORMAL;
            ExtensionType extensionType4 = extensionMetaInfo.type;
            if (extensionType3 == extensionType4) {
                List<String> list = extensionMetaInfo.filter;
                if (list != null && list.size() > 0) {
                    for (String str : extensionMetaInfo.filter) {
                        List<ExtensionMetaInfo> list2 = this.mPointToMetaInfoMap.get(str);
                        if (list2 == null) {
                            list2 = new LinkedList<>();
                        }
                        list2.add(extensionMetaInfo);
                        this.mPointToMetaInfoMap.put(str, list2);
                    }
                }
            } else if (extensionType2 == extensionType4) {
                this.mBridgeExtensionRegistry.register(extensionMetaInfo);
            }
            putScope(extensionMetaInfo.extensionClass, extensionMetaInfo.scope);
            this.mExtensionMetaInfoList.add(extensionMetaInfo);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.cloud.tmc.kernel.extension.ExtensionRegistry
    public synchronized void register(Class<? extends Extension> cls) {
        register(cls, null);
    }

    @Override // com.cloud.tmc.kernel.extension.ExtensionRegistry
    public synchronized void register(Class<? extends Extension> cls, Class<? extends Scope> cls2) {
        try {
            if (BridgeExtension.class.isAssignableFrom(cls)) {
                try {
                    this.mBridgeExtensionRegistry.register((Class<? extends BridgeExtension>) cls);
                    putScope(cls, cls2);
                    return;
                } catch (Throwable th) {
                    TmcLogger.w(TAG, cls.getSimpleName(), th);
                }
            }
            if (!Extension.class.isAssignableFrom(cls)) {
                TmcLogger.e(TAG, "Class " + cls + " is not valid extension");
                return;
            }
            synchronized (this.mExtensionClassRegisteredSet) {
                if (this.mExtensionClassRegisteredSet.contains(cls)) {
                    TmcLogger.e(TAG, "Extension " + cls + " is already registered");
                    return;
                }
                this.mExtensionClassRegisteredSet.add(cls);
                for (Class<? extends Extension> cls3 : collectExtensionPoint(cls, null)) {
                    List<Class<? extends Extension>> list = this.mPointToExtensionClazzMap.get(cls3.getName());
                    if (list == null) {
                        list = new LinkedList<>();
                    }
                    list.add(cls);
                    this.mPointToExtensionClazzMap.put(cls3.getName(), list);
                }
                putScope(cls, cls2);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.cloud.tmc.kernel.extension.ExtensionRegistry
    public void unRegister(List<String> list) {
        this.mBridgeExtensionRegistry.unRegister(list);
    }
}
