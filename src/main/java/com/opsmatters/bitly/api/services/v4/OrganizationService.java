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
import com.opsmatters.bitly.api.services.QueryParameterList;
import com.opsmatters.bitly.api.model.v4.UnitQuery;
import com.opsmatters.bitly.api.model.v4.GetOrganizationResponse;
import com.opsmatters.bitly.api.model.v4.ListOrganizationsResponse;
import com.opsmatters.bitly.api.model.v4.GetShortenCountsResponse;

/**
 * The set of operations used for bitly organizations.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class OrganizationService extends BitlyV4Service
{
    /**
     * Constructor that takes a http context and API client.
     * @param accessToken The access token used to authenticate the operations
     * @param httpContext The set of HTTP operations
     */
    public OrganizationService(String accessToken, HttpContext httpContext)
    {
        super(accessToken, httpContext);
    }

    /**
     * Returns the attributes of the given organization.
     * @param organizationGuid The GUID of the organization to be retrieved
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetOrganizationResponse> get(String organizationGuid) throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/organizations/%s", organizationGuid), getHeaders(), null, GET_ORGANIZATION);
    }

    /**
     * Returns the list of organizations.
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<ListOrganizationsResponse> list() throws IOException, URISyntaxException
    {
        return HTTP.GET("/v4/organizations", getHeaders(), null, LIST_ORGANIZATIONS);
    }

    /**
     * Returns the shorten counts for the given organization.
     * @param organizationGuid The guid for the organization
     * @param query The attributes of the units to use for the query
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetShortenCountsResponse> getShortenCounts(String organizationGuid, UnitQuery query)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/organizations/%s/shorten_counts", organizationGuid), 
            getHeaders(), getQueryParameterList(query), GET_SHORTEN_COUNTS);
    }
}