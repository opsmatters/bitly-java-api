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
import com.opsmatters.bitly.api.model.v4.GetChannelResponse;
import com.opsmatters.bitly.api.model.v4.CreateChannelRequest;
import com.opsmatters.bitly.api.model.v4.CreateChannelResponse;
import com.opsmatters.bitly.api.model.v4.UpdateChannelRequest;
import com.opsmatters.bitly.api.model.v4.UpdateChannelResponse;
import com.opsmatters.bitly.api.model.v4.ListChannelsResponse;

/**
 * The set of operations used for bitly campaign channels.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class CampaignChannelService extends BitlyV4Service
{
    /**
     * Constructor that takes a http context and API client.
     * @param accessToken The access token used to authenticate the operations
     * @param httpContext The set of HTTP operations
     */
    public CampaignChannelService(String accessToken, HttpContext httpContext)
    {
        super(accessToken, httpContext);
    }

    /**
     * Returns the attributes of the given campaign channel.
     * @param channelGuid The GUID of the channel to be retrieved
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetChannelResponse> get(String channelGuid) throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/channels/%s", channelGuid), getHeaders(), null, GET_CHANNEL);
    }

    /**
     * Creates a campaign channel.
     * @param request The request containing the attributes of the campaign channel to be created
     * @return The response object
     * @throws IOException if there is a communication error.
     */
    public Optional<CreateChannelResponse> create(CreateChannelRequest request) throws IOException
    {
        return HTTP.POST("/v4/channels", request, getHeaders(), CREATE_CHANNEL);
    }

    /**
     * Updates the attributes of the given campaign channel.
     * @param channelGuid The GUID of the campaign channel to be updated
     * @param request The request containing the attributes of the campaign channel to be updated
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<UpdateChannelResponse> update(String channelGuid, UpdateChannelRequest request)
        throws IOException, URISyntaxException
    {
        return HTTP.PATCH(String.format("/v4/channels/%s", channelGuid), request, getHeaders(), null, UPDATE_CHANNEL);
    }

    /**
     * Returns the list of campaign channels for the given group and campaign.
     * @param groupGuid The GUID of the group for the campaign channels
     * @param campaignGuid The GUID of the campaign for the campaign channels
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<ListChannelsResponse> list(String groupGuid, String campaignGuid)
        throws IOException, URISyntaxException
    {
        QueryParameterList queryParams = new QueryParameterList();
        if(groupGuid != null)
            queryParams.add("group_guid", groupGuid);
        if(campaignGuid != null)
            queryParams.add("campaign_guid", campaignGuid);
        return HTTP.GET("/v4/channels", getHeaders(), queryParams, LIST_CHANNELS);
    }
}