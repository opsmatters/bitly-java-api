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
import com.opsmatters.bitly.Bitly;
import com.google.common.base.Optional;
import com.opsmatters.bitly.api.services.HttpContext;
import com.opsmatters.bitly.api.services.v4.BitlyV4Service;
import com.opsmatters.bitly.api.model.v4.ShortenRequest;
import com.opsmatters.bitly.api.model.v4.ShortenResponse;
import com.opsmatters.bitly.api.model.v4.ExpandRequest;
import com.opsmatters.bitly.api.model.v4.ExpandResponse;

/**
 * The set of operations used for bitlinks.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class BitlinksService extends BitlyV4Service
{
    /**
     * Constructor that takes a http context and API client.
     * @param accessToken The access token used to authenticate the operations
     * @param httpContext The set of HTTP operations
     */
    public BitlinksService(String accessToken, HttpContext httpContext)
    {
        super(accessToken, httpContext);
    }

    /**
     * Shortens the given long url.
     * @param longUrl The long url to be shortened
     * @return The response object
     */
    public Optional<ShortenResponse> shorten(String longUrl) throws IOException
    {
        return shorten(ShortenRequest.builder().longUrl(longUrl).build());
    }

    /**
     * Shortens the given long url.
     * @param request The request containing the long url to be shortened
     * @return The response object
     */
    public Optional<ShortenResponse> shorten(ShortenRequest request) throws IOException
    {
        return HTTP.POST("/v4/shorten", request, getHeaders(), SHORTEN);
    }

    /**
     * Returns the long url for the given bitlink id.
     * @param id The id of the bitlink to be expanded
     * @return The response object
     */
    public Optional<ExpandResponse> expand(String id) throws IOException
    {
        return expand(ExpandRequest.builder().id(id).build());
    }

    /**
     * Returns the long url for the given bitlink id.
     * @param request The request containing the id of the bitlink to be expanded
     * @return The response object
     */
    public Optional<ExpandResponse> expand(ExpandRequest request) throws IOException
    {
        return HTTP.POST("/v4/expand", request, getHeaders(), EXPAND);
    }
}