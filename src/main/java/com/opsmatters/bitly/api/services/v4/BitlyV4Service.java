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

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import com.opsmatters.bitly.api.services.BitlyService;
import com.opsmatters.bitly.api.services.HttpContext;
import com.opsmatters.bitly.api.services.QueryParameterList;
import com.opsmatters.bitly.api.model.v4.UnitQuery;
import com.opsmatters.bitly.api.model.v4.BitlinkQuery;
import com.opsmatters.bitly.api.model.v4.GetBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.ExpandBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.UpdateBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.GetBitlinkClicksResponse;
import com.opsmatters.bitly.api.model.v4.GetBitlinkClicksSummaryResponse;
import com.opsmatters.bitly.api.model.v4.GetBitlinkQrCodeResponse;
import com.opsmatters.bitly.api.model.v4.GetBitlinksByGroupResponse;
import com.opsmatters.bitly.api.model.v4.GetSortedBitlinksByGroupResponse;
import com.opsmatters.bitly.api.model.v4.GetCustomBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.CreateCustomBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.UpdateCustomBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.GetGroupResponse;
import com.opsmatters.bitly.api.model.v4.UpdateGroupResponse;
import com.opsmatters.bitly.api.model.v4.ListGroupsResponse;
import com.opsmatters.bitly.api.model.v4.GetGroupTagsResponse;
import com.opsmatters.bitly.api.model.v4.GetShortenCountsResponse;
import com.opsmatters.bitly.api.model.v4.GetGroupPreferencesResponse;
import com.opsmatters.bitly.api.model.v4.UpdateGroupPreferencesResponse;
import com.opsmatters.bitly.api.model.v4.GetOrganizationResponse;
import com.opsmatters.bitly.api.model.v4.ListOrganizationsResponse;
import com.opsmatters.bitly.api.model.v4.GetCampaignResponse;
import com.opsmatters.bitly.api.model.v4.CreateCampaignResponse;
import com.opsmatters.bitly.api.model.v4.UpdateCampaignResponse;
import com.opsmatters.bitly.api.model.v4.ListCampaignsResponse;
import com.opsmatters.bitly.api.model.v4.GetChannelResponse;
import com.opsmatters.bitly.api.model.v4.CreateChannelResponse;
import com.opsmatters.bitly.api.model.v4.UpdateChannelResponse;
import com.opsmatters.bitly.api.model.v4.ListChannelsResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByCountriesResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferrersResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferrersByDomainResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferringDomainsResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferringNetworksResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByDestinationResponse;
import com.opsmatters.bitly.api.model.v4.GetUserResponse;
import com.opsmatters.bitly.api.model.v4.UpdateUserResponse;
import com.opsmatters.bitly.api.model.v4.ListBsdsResponse;
import com.opsmatters.bitly.api.model.v4.GetWebhookResponse;
import com.opsmatters.bitly.api.model.v4.CreateWebhookResponse;
import com.opsmatters.bitly.api.model.v4.UpdateWebhookResponse;
import com.opsmatters.bitly.api.model.v4.ListWebhooksResponse;
import com.opsmatters.bitly.api.model.v4.GetOAuthAppResponse;

/**
 * Provides the types of objects to be used with v4 API calls.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class BitlyV4Service extends BitlyService
{
    protected static final Type GET_BITLINK = new TypeToken<GetBitlinkResponse>(){}.getType();
    protected static final Type CREATE_BITLINK = new TypeToken<CreateBitlinkResponse>(){}.getType();
    protected static final Type EXPAND_BITLINK = new TypeToken<ExpandBitlinkResponse>(){}.getType();
    protected static final Type UPDATE_BITLINK = new TypeToken<UpdateBitlinkResponse>(){}.getType();
    protected static final Type GET_BITLINK_CLICKS = new TypeToken<GetBitlinkClicksResponse>(){}.getType();
    protected static final Type GET_BITLINK_CLICKS_SUMMARY = new TypeToken<GetBitlinkClicksSummaryResponse>(){}.getType();
    protected static final Type GET_BITLINK_QR_CODE = new TypeToken<GetBitlinkQrCodeResponse>(){}.getType();
    protected static final Type GET_BITLINKS_BY_GROUP = new TypeToken<GetBitlinksByGroupResponse>(){}.getType();
    protected static final Type GET_SORTED_BITLINKS_BY_GROUP = new TypeToken<GetSortedBitlinksByGroupResponse>(){}.getType();
    protected static final Type GET_CUSTOM_BITLINK = new TypeToken<GetCustomBitlinkResponse>(){}.getType();
    protected static final Type CREATE_CUSTOM_BITLINK = new TypeToken<CreateCustomBitlinkResponse>(){}.getType();
    protected static final Type UPDATE_CUSTOM_BITLINK = new TypeToken<UpdateCustomBitlinkResponse>(){}.getType();
    protected static final Type GET_GROUP = new TypeToken<GetGroupResponse>(){}.getType();
    protected static final Type UPDATE_GROUP = new TypeToken<UpdateGroupResponse>(){}.getType();
    protected static final Type LIST_GROUPS = new TypeToken<ListGroupsResponse>(){}.getType();
    protected static final Type GET_GROUP_TAGS = new TypeToken<GetGroupTagsResponse>(){}.getType();
    protected static final Type GET_SHORTEN_COUNTS = new TypeToken<GetShortenCountsResponse>(){}.getType();
    protected static final Type GET_GROUP_PREFERENCES = new TypeToken<GetGroupPreferencesResponse>(){}.getType();
    protected static final Type UPDATE_GROUP_PREFERENCES = new TypeToken<UpdateGroupPreferencesResponse>(){}.getType();
    protected static final Type GET_ORGANIZATION = new TypeToken<GetOrganizationResponse>(){}.getType();
    protected static final Type LIST_ORGANIZATIONS = new TypeToken<ListOrganizationsResponse>(){}.getType();
    protected static final Type GET_CAMPAIGN = new TypeToken<GetCampaignResponse>(){}.getType();
    protected static final Type CREATE_CAMPAIGN = new TypeToken<CreateCampaignResponse>(){}.getType();
    protected static final Type UPDATE_CAMPAIGN = new TypeToken<UpdateCampaignResponse>(){}.getType();
    protected static final Type LIST_CAMPAIGNS = new TypeToken<ListCampaignsResponse>(){}.getType();
    protected static final Type GET_CHANNEL = new TypeToken<GetChannelResponse>(){}.getType();
    protected static final Type CREATE_CHANNEL = new TypeToken<CreateChannelResponse>(){}.getType();
    protected static final Type UPDATE_CHANNEL = new TypeToken<UpdateChannelResponse>(){}.getType();
    protected static final Type LIST_CHANNELS = new TypeToken<ListChannelsResponse>(){}.getType();
    protected static final Type GET_METRICS_BY_COUNTRIES = new TypeToken<GetMetricsByCountriesResponse>(){}.getType();
    protected static final Type GET_METRICS_BY_REFERRERS = new TypeToken<GetMetricsByReferrersResponse>(){}.getType();
    protected static final Type GET_METRICS_BY_REFERRERS_BY_DOMAIN = new TypeToken<GetMetricsByReferrersByDomainResponse>(){}.getType();
    protected static final Type GET_METRICS_BY_REFERRING_DOMAINS = new TypeToken<GetMetricsByReferringDomainsResponse>(){}.getType();
    protected static final Type GET_METRICS_BY_REFERRING_NETWORKS = new TypeToken<GetMetricsByReferringNetworksResponse>(){}.getType();
    protected static final Type GET_METRICS_BY_DESTINATION = new TypeToken<GetMetricsByDestinationResponse>(){}.getType();
    protected static final Type GET_USER = new TypeToken<GetUserResponse>(){}.getType();
    protected static final Type UPDATE_USER = new TypeToken<UpdateUserResponse>(){}.getType();
    protected static final Type LIST_BSDS = new TypeToken<ListBsdsResponse>(){}.getType();
    protected static final Type GET_WEBHOOK = new TypeToken<GetWebhookResponse>(){}.getType();
    protected static final Type CREATE_WEBHOOK = new TypeToken<CreateWebhookResponse>(){}.getType();
    protected static final Type UPDATE_WEBHOOK = new TypeToken<UpdateWebhookResponse>(){}.getType();
    protected static final Type LIST_WEBHOOKS = new TypeToken<ListWebhooksResponse>(){}.getType();
    protected static final Type GET_OAUTH_APP = new TypeToken<GetOAuthAppResponse>(){}.getType();

    /**
     * Constructor that takes a http context and API client.
     * @param accessToken The access token used to authenticate API operations
     * @param httpContext The set of HTTP operations
     */
    public BitlyV4Service(String accessToken, HttpContext httpContext)
    {
        super(accessToken, httpContext);
    }

    /**
     * Returns the query parameter list for the given query.
     * @param query The attributes of the units to use for the query
     * @return The list of query parameters
     */
    public QueryParameterList getQueryParameterList(UnitQuery query)
    {
        QueryParameterList queryParams = new QueryParameterList();
        if(query.getUnit() != null)
            queryParams.add("unit", query.getUnit().value());
        if(query.getUnits() > 0)
            queryParams.add("units", Integer.toString(query.getUnits()));
        if(query.getUnitReference() != null)
            queryParams.add("unit_reference", query.getUnitReference());
        if(query.getSize() > 0)
            queryParams.add("size", Integer.toString(query.getSize()));
        return queryParams;
    }

    /**
     * Returns the query parameter list for the given query.
     * @param query The attributes of the bitlinks to use for the query
     * @return The list of query parameters
     */
    public QueryParameterList getQueryParameterList(BitlinkQuery query)
    {
        QueryParameterList queryParams = new QueryParameterList();
        if(query.getSize() > 0)
            queryParams.add("size", Integer.toString(query.getSize()));
        if(query.getPage() > 0)
            queryParams.add("page", Integer.toString(query.getPage()));
        if(query.getKeyword() != null)
            queryParams.add("keyword", query.getKeyword());
        if(query.getQuery() != null)
            queryParams.add("query", query.getQuery());
        if(query.getCreatedBefore() > 0)
            queryParams.add("created_before", Integer.toString(query.getCreatedBefore()));
        if(query.getCreatedAfter() > 0)
            queryParams.add("created_after", Integer.toString(query.getCreatedAfter()));
        if(query.getModifiedAfter() > 0)
            queryParams.add("modified_after", Integer.toString(query.getModifiedAfter()));
        if(query.getArchived() != null)
            queryParams.add("archived", query.getArchived().value());
        if(query.getDeeplinks() != null)
            queryParams.add("deeplinks", query.getDeeplinks().value());
        if(query.getDomainDeeplinks() != null)
            queryParams.add("domain_deeplinks", query.getDomainDeeplinks().value());
        if(query.getCustomBitlink() != null)
            queryParams.add("custom_bitlink", query.getCustomBitlink().value());
        if(query.getCampaignGuid() != null)
            queryParams.add("campaign_guid", query.getCampaignGuid());
        if(query.getChannelGuid() != null)
            queryParams.add("channel_guid", query.getChannelGuid());
        if(query.getTags() != null)
            queryParams.add("tags", StringUtils.join(query.getTags(), ','));
        if(query.getEncodingLogin() != null)
            queryParams.add("encoding_login", StringUtils.join(query.getEncodingLogin(), ','));
        return queryParams;
    }
}