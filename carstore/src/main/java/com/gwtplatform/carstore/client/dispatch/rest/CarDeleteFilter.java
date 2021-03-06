/*
 * Copyright 2014 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.carstore.client.dispatch.rest;

import com.gwtplatform.carstore.shared.api.ApiPaths;
import com.gwtplatform.dispatch.client.ExecuteCommand;
import com.gwtplatform.dispatch.rest.client.RestCallback;
import com.gwtplatform.dispatch.rest.client.context.RestContext;
import com.gwtplatform.dispatch.rest.client.filter.RestFilter;
import com.gwtplatform.dispatch.rest.client.filter.RestFilterChain;
import com.gwtplatform.dispatch.rest.shared.HttpMethod;
import com.gwtplatform.dispatch.rest.shared.RestAction;
import com.gwtplatform.dispatch.shared.DispatchRequest;

public class CarDeleteFilter implements RestFilter {
    private final RestContext restContext;

    CarDeleteFilter() {
        restContext = new RestContext.Builder()
                .path(ApiPaths.CARS)
                .httpMethod(HttpMethod.DELETE)
                .transcendent(true)
                .build();
    }

    @Override
    public <R> DispatchRequest filter(
            RestAction<R> action,
            RestCallback<R> callback,
            ExecuteCommand<RestAction<R>, RestCallback<R>> command,
            RestFilterChain chain) {
        return chain.doFilter(action, callback, command);
    }

    @Override
    public RestContext getRestContext() {
        return restContext;
    }
}
