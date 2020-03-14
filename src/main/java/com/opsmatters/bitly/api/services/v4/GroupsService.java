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
import com.opsmatters.bitly.api.model.v4.BitlinkQuery;
import com.opsmatters.bitly.api.model.v4.Sort;
import com.opsmatters.bitly.api.model.v4.GetGroupResponse;
import com.opsmatters.bitly.api.model.v4.UpdateGroupRequest;
import com.opsmatters.bitly.api.model.v4.UpdateGroupResponse;
import com.opsmatters.bitly.api.model.v4.ListGroupsResponse;
import com.opsmatters.bitly.api.model.v4.GetGroupTagsResponse;
import com.opsmatters.bitly.api.model.v4.GetShortenCountsResponse;
import com.opsmatters.bitly.api.model.v4.GetGroupPreferencesResponse;
import com.opsmatters.bitly.api.model.v4.UpdateGroupPreferencesRequest;
import com.opsmatters.bitly.api.model.v4.UpdateGroupPreferencesResponse;
import com.opsmatters.bitly.api.model.v4.GetBitlinksByGroupResponse;
import com.opsmatters.bitly.api.model.v4.GetSortedBitlinksByGroupResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByCountriesResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferringNetworksResponse;

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
     * Returns the attributes of the given group.
     * @param groupGuid The GUID of the group to be retrieved
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetGroupResponse> get(String groupGuid) throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/groups/%s", groupGuid), getHeaders(), null, GET_GROUP);
    }

    /**
     * Updates the attributes of the given group.
     * @param groupGuid The GUID of the group to be updated
     * @param request The request containing the attributes of the group to be updated
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<UpdateGroupResponse> update(String groupGuid, UpdateGroupRequest request)
        throws IOException, URISyntaxException
    {
        return HTTP.PATCH(String.format("/v4/groups/%s", groupGuid), request, getHeaders(), null, UPDATE_GROUP);
    }

    /**
     * Returns the groups for the given organization GUID.
     * @param organizationGuid The GUID of the organization for the groups to be retrieved
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<ListGroupsResponse> list(String organizationGuid) throws IOException, URISyntaxException
    {
        QueryParameterList queryParams = new QueryParameterList();
        if(organizationGuid != null)
            queryParams.add("organization_guid", organizationGuid);
        return HTTP.GET("/v4/groups", getHeaders(), queryParams, LIST_GROUPS);
    }

    /**
     * Deletes the given group.
     * @param groupGuid The GUID of the group to be deleted
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public void delete(String groupGuid) throws IOException, URISyntaxException
    {
        HTTP.DELETE(String.format("/v4/groups/%s", groupGuid), getHeaders(), null);
    }

    /**
     * Returns the tags for the given group.
     * @param groupGuid The GUID of the group with the tags
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetGroupTagsResponse> getTags(String groupGuid) throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/groups/%s/tags", groupGuid), getHeaders(), null, GET_GROUP_TAGS);
    }

    /**
     * Returns the shorten counts for the given group.
     * @param groupGuid The guid for the group
     * @param query The attributes of the units to use for the query
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetShortenCountsResponse> getShortenCounts(String groupGuid, UnitQuery query)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/groups/%s/shorten_counts", groupGuid), 
            getHeaders(), getQueryParameterList(query), GET_SHORTEN_COUNTS);
    }

    /**
     * Returns the preferences for the given group.
     * @param groupGuid The GUID of the group with the preferences
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetGroupPreferencesResponse> getPreferences(String groupGuid) throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/groups/%s/preferences", groupGuid),
            getHeaders(), null, GET_GROUP_PREFERENCES);
    }

    /**
     * Updates the preferences of the given group.
     * @param groupGuid The GUID of the group to be updated
     * @param request The request containing the preferences of the group to be updated
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<UpdateGroupPreferencesResponse> updatePreferences(String groupGuid, UpdateGroupPreferencesRequest request)
        throws IOException, URISyntaxException
    {
        return HTTP.PATCH(String.format("/v4/groups/%s/preferences", groupGuid), request,
            getHeaders(), null, UPDATE_GROUP_PREFERENCES);
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

    /**
     * Returns the metrics for the given group by countries.
     * @param groupGuid The GUID of the group for the metrics
     * @param query The attributes of the units to use for the query
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetMetricsByCountriesResponse> getMetricsByCountries(String groupGuid, UnitQuery query)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/groups/%s/countries", groupGuid), 
            getHeaders(), getQueryParameterList(query), GET_METRICS_BY_COUNTRIES);
    }

    /**
     * Returns the metrics for the given group by referring networks.
     * @param groupGuid The GUID of the group for the metrics
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetMetricsByReferringNetworksResponse> getMetricsByReferringNetworks(String groupGuid)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/groups/%s/referring_networks", groupGuid), 
            getHeaders(), null, GET_METRICS_BY_REFERRING_NETWORKS);
    }
}