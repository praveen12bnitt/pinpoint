package com.navercorp.pinpoint.profiler.context.provider.grpc;

import com.google.inject.Inject;
import com.google.inject.Provider;
import io.grpc.NameResolver;
import io.grpc.NameResolverRegistry;

public class NameResolverFactoryProvider implements Provider<NameResolver.Factory> {

    @Inject
    public NameResolverFactoryProvider() {
    }


    @Override
    public NameResolver.Factory get() {
        return NameResolverRegistry.getDefaultRegistry().asFactory();
    }
}
