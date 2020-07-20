/*
 * Copyright 2019 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.grpc.client;

import io.grpc.ClientInterceptor;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;


/**
 * @author Woonduk Kang(emeroad)
 */
public interface ChannelFactoryBuilder {


    void setExecutorQueueSize(int executorQueueSize);

    void setHeaderFactory(HeaderFactory headerFactory);

    void addFirstClientInterceptor(ClientInterceptor clientInterceptor);

    void addClientInterceptor(ClientInterceptor clientInterceptor);

    void setClientOption(ClientOption clientOption);

    void setNameResolverProvider(NameResolver.Factory nameResolverProvider);

    ChannelFactory build();

}
