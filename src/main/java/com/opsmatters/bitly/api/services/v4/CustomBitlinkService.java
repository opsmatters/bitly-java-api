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
import com.opsmatters.bitly.api.services.v4.BitlyV4Service;
import com.opsmatters.bitly.api.model.v4.GetCustomBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.CreateCustomBitlinkRequest;
import com.opsmatters.bitly.api.model.v4.CreateCustomBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.UpdateCustomBitlinkRequest;
import com.opsmatters.bitly.api.model.v4.UpdateCustomBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByDestinationResponse;

/**
 * The set of operations used for custom bitlinks.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class CustomBitlinkService extends BitlyV4Service
{
    /**
     * Constructor that takes a http context and API client.
     * @param accessToken The access token used to authenticate the operations
     * @param httpContext The set of HTTP operations
     */
    public CustomBitlinkService(String accessToken, HttpContext httpContext)
    {
        super(accessToken, httpContext);
    }

    /**
     * Returns the details and history of a custom bitlink.
     * @param customBitlink The custom bitlink made of the domain and keyword
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetCustomBitlinkResponse> get(String customBitlink) throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/custom_bitlinks/%s", customBitlink), getHeaders(), null, GET_CUSTOM_BITLINK);
    }

    /**
     * Add a keyword to a bitlink.
     * @param request The request containing the bitlink and keyword to be added
     * @return The response object
     * @throws IOException if there is a communication error.
     */
    public Optional<CreateCustomBitlinkResponse> create(CreateCustomBitlinkRequest request) throws IOException
    {
        return HTTP.POST("/v4/custom_bitlinks", request, getHeaders(), CREATE_CUSTOM_BITLINK);
    }

    /**
     * Move a keyword to a different bitlink.
     * @param customBitlink The custom bitlink made of the domain and keyword
     * @param request The request containing the attributes of the bitlink to be updated
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<UpdateCustomBitlinkResponse> update(String customBitlink, UpdateCustomBitlinkRequest request)
        throws IOException, URISyntaxException
    {
        return HTTP.PATCH(String.format("/v4/custom_bitlinks/%s", customBitlink),
            request, getHeaders(), null, UPDATE_CUSTOM_BITLINK);
    }

    /**
     * Returns the clicks for the given custom bitlink by destination.
     * @param customBitlink The custom bitlink made of the domain and keyword
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetMetricsByDestinationResponse> getMetricsByDestination(String customBitlink)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/custom_bitlinks/%s/clicks_by_destination", customBitlink), 
            getHeaders(), null, GET_METRICS_BY_DESTINATION);
    }
}