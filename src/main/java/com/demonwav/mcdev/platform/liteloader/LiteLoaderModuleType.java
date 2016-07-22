package com.demonwav.mcdev.platform.liteloader;

import com.demonwav.mcdev.asset.PlatformAssets;
import com.demonwav.mcdev.platform.AbstractModuleType;
import com.demonwav.mcdev.platform.PlatformType;
import com.demonwav.mcdev.platform.forge.ForgeModuleType;

import com.intellij.openapi.module.Module;
import org.jetbrains.annotations.NotNull;

import java.awt.Color;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;

public class LiteLoaderModuleType extends AbstractModuleType<LiteLoaderModule> {

    private static final String ID = "LITELOADER_MODULE_TYPE";
    private static final LiteLoaderModuleType instance = new LiteLoaderModuleType();

    private final LinkedHashMap<String, Color> colorMap = new LinkedHashMap<>();

    private LiteLoaderModuleType() {
        super("", "");
    }

    public static LiteLoaderModuleType getInstance() {
        return instance;
    }

    @Override
    public PlatformType getPlatformType() {
        return PlatformType.LITELOADER;
    }

    @Override
    public Icon getBigIcon() {
        return PlatformAssets.LITELOADER_ICON_2X;
    }

    @Override
    public Icon getIcon() {
        return PlatformAssets.LITELOADER_ICON;
    }

    @Override
    public String getId() {
        return ID;
    }

    @NotNull
    @Override
    public List<String> getIgnoredAnnotations() {
        return Collections.emptyList();
    }

    @NotNull
    @Override
    public List<String> getListenerAnnotations() {
        return Collections.emptyList();
    }

    @NotNull
    @Override
    public Map<String, Color> getClassToColorMappings() {
        ForgeModuleType.addMinecraftColors(colorMap);

        return colorMap;
    }

    @NotNull
    @Override
    public LiteLoaderModule generateModule(Module module) {
        return new LiteLoaderModule(module);
    }
}