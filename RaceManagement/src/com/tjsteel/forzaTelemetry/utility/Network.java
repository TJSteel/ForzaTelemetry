package com.tjsteel.forzaTelemetry.utility;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.List;

public class Network {
    /**
     * Get IP address of device
     * @param useIPv4 true=return ipv4, false=return ipv6
     * @param getLocal=return ipv4, false=return ipv6
     * @return address or "No Address Found"
     */
    public static String getIPAddress(boolean useIPv4, boolean getLocal) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface networkInterface : interfaces) {
                for (InetAddress address : Collections.list(networkInterface.getInetAddresses())) {
                    if (!address.isLoopbackAddress()){
                        String foundAddress = address.getHostAddress();
                        boolean isIPv4 = foundAddress.indexOf(':')<0;
                        if (useIPv4 && isIPv4) {
                            if ((getLocal && address.isSiteLocalAddress()) || (!getLocal && !address.isSiteLocalAddress())){
                                return foundAddress;
                            }
                        } else if (!useIPv4 && !isIPv4) {
                            int delimiter = foundAddress.indexOf('%'); // drop ip6 zone suffix
                            if ((getLocal && address.isSiteLocalAddress()) || (!getLocal && !address.isSiteLocalAddress())){
                                return delimiter<0 ? foundAddress.toUpperCase() : foundAddress.substring(0, delimiter).toUpperCase();
                            }
                        }
                    }
                }
            }
            return "No Address Found";
        } catch (SocketException e) {
            return "Error fetching interfaces";
        }
    }
}