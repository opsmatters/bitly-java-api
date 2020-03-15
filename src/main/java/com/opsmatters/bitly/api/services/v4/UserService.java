/*
 * Copyright 2020 Gerald Curley
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.opsmatters.bitly.api.services.v4;

import java.io.IOException;
import java.net.URISyntaxException;
import com.google.common.base.Optional;
import com.opsmatters.bitly.api.services.HttpContext;
import com.opsmatters.bitly.api.model.v4.GetUserResponse;
import com.opsmatters.bitly.api.model.v4.UpdateUserRequest;
import com.opsmatters.bitly.api.model.v4.UpdateUserResponse;

/**
 * The set of operations used for bitly users.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class UserService extends BitlyV4Service
{
    /**
     * Constructor that takes a http context and API client.
     * @param accessToken The access token used to authenticate the operations
     * @param httpContext The set of HTTP operations
     */
    public UserService(String accessToken, HttpContext httpContext)
    {
        super(accessToken, httpContext);
    }

    /**
     * Returns the attributes of the current authenticated user.
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetUserResponse> get() throws IOException, URISyntaxException
    {
        return HTTP.GET("/v4/user", getHeaders(), null, GET_USER);
    }

    /**
     * Updates the attributes of the current authenticated user.
     * @param request The request containing the attributes of the user to be updated
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<UpdateUserResponse> update(UpdateUserRequest request)
        throws IOException, URISyntaxException
    {
        return HTTP.PATCH("/v4/user", request, getHeaders(), null, UPDATE_USER);
    }
}