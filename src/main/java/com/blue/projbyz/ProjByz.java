package com.blue.projbyz;

import net.minecraftforge.fml.common.Mod;

import static com.blue.projbyz.ProjByz.Info.*;

@Mod(modid = MOD_ID, name = MOD_NAME, version = MOD_VERSION, dependencies = DEPENDANCIES, acceptedMinecraftVersions = MC_VERSION)
public class ProjByz {



    public static class Info {
        public static final String MOD_ID = "projbyz";
        public static final String MOD_NAME = "Project Byzantine";
        public static final String MOD_VERSION = "0.0.1-pre";
        public static final String DEPENDANCIES = "required-after:forge@[14.23.2.2624,);";
        public static final String MC_VERSION = "[1.12,1.13)";
        public static final String TOP_LEVEL_PACKAGE = "com.blue.projbyz";
        public static final String MOD_PREFIX = MOD_ID + ":";
    }
}
