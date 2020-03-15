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
import com.opsmatters.bitly.api.model.v4.GetCampaignResponse;
import com.opsmatters.bitly.api.model.v4.CreateCampaignRequest;
import com.opsmatters.bitly.api.model.v4.CreateCampaignResponse;
import com.opsmatters.bitly.api.model.v4.UpdateCampaignRequest;
import com.opsmatters.bitly.api.model.v4.UpdateCampaignResponse;
import com.opsmatters.bitly.api.model.v4.ListCampaignsResponse;

/**
 * The set of operations used for bitly campaigns.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class CampaignService extends BitlyV4Service
{
    /**
     * Constructor that takes a http context and API client.
     * @param accessToken The access token used to authenticate the operations
     * @param httpContext The set of HTTP operations
     */
    public CampaignService(String accessToken, HttpContext httpContext)
    {
        super(accessToken, httpContext);
    }

    /**
     * Returns the attributes of the given campaign.
     * @param campaignGuid The GUID of the campaign to be retrieved
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetCampaignResponse> get(String campaignGuid) throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/campaigns/%s", campaignGuid), getHeaders(), null, GET_CAMPAIGN);
    }

    /**
     * Creates a campaign.
     * @param request The request containing the attributes of the campaign to be created
     * @return The response object
     * @throws IOException if there is a communication error.
     */
    public Optional<CreateCampaignResponse> create(CreateCampaignRequest request) throws IOException
    {
        return HTTP.POST("/v4/campaigns", request, getHeaders(), CREATE_CAMPAIGN);
    }

    /**
     * Updates the attributes of the given campaign.
     * @param campaignGuid The GUID of the campaign to be updated
     * @param request The request containing the attributes of the campaign to be updated
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<UpdateCampaignResponse> update(String campaignGuid, UpdateCampaignRequest request)
        throws IOException, URISyntaxException
    {
        return HTTP.PATCH(String.format("/v4/campaigns/%s", campaignGuid), request, getHeaders(), null, UPDATE_CAMPAIGN);
    }

    /**
     * Returns the list of campaigns for the given group.
     * @param groupGuid The GUID of the group for the campaigns
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<ListCampaignsResponse> list(String groupGuid) throws IOException, URISyntaxException
    {
        QueryParameterList queryParams = new QueryParameterList();
        if(groupGuid != null)
            queryParams.add("group_guid", groupGuid);
        return HTTP.GET("/v4/campaigns", getHeaders(), queryParams, LIST_CAMPAIGNS);
    }
}