package com.navercorp.pinpoint.common.hbase;

import com.google.cloud.bigtable.hbase.BigtableOptionsFactory;
import org.apache.hadoop.conf.Configuration;

import java.util.Properties;

public class CloudBigTableProperties
{
    private boolean enabled;
    private String projectId;
    private String instanceId;

    private Properties properties = new Properties();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void configure(Configuration configuration)
    {
        configuration.set("hbase.client.connection.impl", "com.google.cloud.bigtable.hbase1_x.BigtableConnection");
        configuration.set(BigtableOptionsFactory.PROJECT_ID_KEY, projectId);
        configuration.set(BigtableOptionsFactory.INSTANCE_ID_KEY, instanceId);


        configuration.set(BigtableOptionsFactory.BIGTABLE_USE_CACHED_DATA_CHANNEL_POOL, "true");
        configuration.set(BigtableOptionsFactory.ENABLE_GRPC_RETRIES_KEY, "true");
        configuration.set(BigtableOptionsFactory.BIGTABLE_USE_TIMEOUTS_KEY, "true");
        configuration.set(BigtableOptionsFactory.BIGTABLE_RPC_TIMEOUT_MS_KEY, "10000");
        configuration.set(BigtableOptionsFactory.BIGTABLE_LONG_RPC_TIMEOUT_MS_KEY, "600000");
        configuration.set(BigtableOptionsFactory.MAX_ELAPSED_BACKOFF_MILLIS_KEY, "60000");


        for(String key : properties.stringPropertyNames())
        {
            String value = properties.getProperty(key);
            configuration.set(key, value);
        }

    }
}
