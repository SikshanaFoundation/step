package com.sikshana;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GyanSethuApplication extends Application<GyanSethuConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GyanSethuApplication().run(args);
    }

    @Override
    public String getName() {
        return "GyanSethu";
    }

    @Override
    public void initialize(final Bootstrap<GyanSethuConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final GyanSethuConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
