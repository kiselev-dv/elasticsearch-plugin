package org.elasticsearch.PeliasPlugin;

import org.elasticsearch.common.inject.AbstractModule;
import org.elasticsearch.common.settings.Settings;

/**
 * Created by franciscodans on 29/09/2014.
 */
public class PeliasPluginModule extends AbstractModule {
    private final Settings settings;

    public PeliasPluginModule(Settings settings){
        this.settings = settings;
    }

    @Override
    protected void configure() {

    }
}
