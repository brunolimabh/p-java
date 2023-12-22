package org.example;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class LogBackend {

    private static Logger log = LogManager.getLogger(LogBackend.class);

    public static void main(String[] args) {

        // System.out.println("Programa iniciado");
        Configurator.setRootLevel(Level.ERROR);

        log.info("Programa iniciado");
        log.error("Deu ruim :(");
        log.debug("debug");
        log.trace("trace");
        log.warn("warn");


    }
}
