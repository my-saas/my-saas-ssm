package com.stef.ssm.utils;

import java.net.InetAddress;

public final class NetworkUtil {
    public static String getLocalIp() throws Exception {
        return InetAddress.getLocalHost().getHostAddress();
    }

}
