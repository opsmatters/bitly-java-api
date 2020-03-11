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
import com.opsmatters.bitly.api.model.v4.UnitQuery;
import com.opsmatters.bitly.api.model.v4.BitlinkQuery;
import com.opsmatters.bitly.api.model.v4.Sort;
import com.opsmatters.bitly.api.model.v4.GetBitlinksByGroupResponse;
import com.opsmatters.bitly.api.model.v4.GetSortedBitlinksByGroupResponse;

/**
 * The set of operations used for bitlink groups.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class GroupsService extends BitlyV4Service
{
    /**
     * Constructor that takes a http context and API client.
     * @param accessToken The access token used to authenticate the operations
     * @param httpContext The set of HTTP operations
     */
    public GroupsService(String accessToken, HttpContext httpContext)
    {
        super(accessToken, httpContext);
    }

    /**
     * Returns the bitlinks for the given group.
     * @param groupGuid The guid for the group
     * @param query The attributes of the bitlinks to use for the query
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetBitlinksByGroupResponse> getBitlinks(String groupGuid, BitlinkQuery query)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/groups/%s/bitlinks", groupGuid),
            getHeaders(), getQueryParameterList(query), GET_BITLINKS_BY_GROUP);
    }

    /**
     * Returns the sorted bitlinks for the given group.
     * @param groupGuid The guid for the group
     * @param sort The sort for the group
     * @param query The attributes of the units to use for the query
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetSortedBitlinksByGroupResponse> getSortedBitlinks(String groupGuid, Sort sort, UnitQuery query)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/groups/%s/bitlinks/%s", groupGuid, sort.value()), 
            getHeaders(), getQueryParameterList(query), GET_SORTED_BITLINKS_BY_GROUP);
    }
}