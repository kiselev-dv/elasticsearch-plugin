package org.elasticsearch.PeliasPlugin;

import org.elasticsearch.ElasticSearchException;
import org.elasticsearch.common.component.AbstractLifecycleComponent;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.SettingsFilter;

public class PeliasPluginService extends AbstractLifecycleComponent<PeliasPluginService>{
    @Inject
    public PeliasPluginService(Settings settings, SettingsFilter settingsFilter){
        super(settings);
    }

    @Override
    protected void doStart() throws ElasticSearchException {
        String host = componentSettings.get("host", "localhost");
        int port = componentSettings.getAsInt("port", 9200);
    }

    @Override
    protected void doStop() throws ElasticSearchException {

    }

    @Override
    protected void doClose() throws ElasticSearchException {

    }
}
