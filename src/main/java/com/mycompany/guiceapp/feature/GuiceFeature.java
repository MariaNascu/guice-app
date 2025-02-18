package com.mycompany.guiceapp.feature;

import com.google.inject.Injector;
import org.glassfish.jersey.inject.hk2.AbstractBinder;

public class GuiceFeature extends AbstractBinder {
    private final Injector injector;

    public GuiceFeature(Injector injector) {
        this.injector = injector;
    }

    @Override
    protected void configure() {
        bindFactory(() -> injector).to(Injector.class);
    }
}
