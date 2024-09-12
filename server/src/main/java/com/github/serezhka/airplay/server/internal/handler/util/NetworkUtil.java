package com.github.serezhka.airplay.server.internal.handler.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NetworkUtil {
    // 查找可用端口
    public static int findAvailablePort() {
        for (var port = 1024; port < 65536; port++) {
            try (ServerSocket socket = new ServerSocket()) {
                // socket.setReuseAddress(true);
                socket.bind(new InetSocketAddress(port));
                return port;
            } catch (IOException ignored) {
                log.info("Port " + port + " is not available.");
            }
        }

        return 0;
    }
}
