package com.blue.projbyz.util;

import com.blue.projbyz.ProjByz;
import net.minecraft.nbt.NBTTagCompound;

public final class NBTUtils {

    private NBTUtils() {
    }


    public static int getInt(NBTTagCompound nbt, String key) {
        if (!nbt.hasKey(key)) {
            try {
                throw new IllegalStateException(String.format("The key %s did not exist in the tag %s. Beware if this is not intentional", key, nbt.toString()));
            } catch (IllegalStateException e) {
                ProjByz.LOGGER.warn(e);
                return 0;
            }
        }
        return nbt.getInteger(key);
    }

    public static NBTTagCompound getTag(NBTTagCompound nbt, String key) {
        if (!nbt.hasKey(key)) {
            try {
                throw new IllegalStateException(String.format("The key %s did not exist in the tag %s. Beware if this is not intentional", key, nbt.toString()));
            } catch (IllegalStateException e) {
                ProjByz.LOGGER.warn(e);
                return new NBTTagCompound();
            }
        }
        return (NBTTagCompound) nbt.getTag(key);
    }
}
