package com.leanvienna.studentlife.server;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
    private static final EntityManagerFactory emfInstance =
        Persistence.createEntityManagerFactory("default");

    private EMF() {}

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}