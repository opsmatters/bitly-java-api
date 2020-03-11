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
import com.opsmatters.bitly.api.model.v4.GetMetricsByCountriesResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferrersResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferrersByDomainResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferringDomainsResponse;
import com.opsmatters.bitly.api.model.v4.GetBitlinkQrCodeResponse;
import com.opsmatters.bitly.api.model.v4.GetBitlinksByGroupResponse;
import com.opsmatters.bitly.api.model.v4.GetSortedBitlinksByGroupResponse;

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
    protected static final Type GET_METRICS_BY_COUNTRIES = new TypeToken<GetMetricsByCountriesResponse>(){}.getType();
    protected static final Type GET_METRICS_BY_REFERRERS = new TypeToken<GetMetricsByReferrersResponse>(){}.getType();
    protected static final Type GET_METRICS_BY_REFERRERS_BY_DOMAIN = new TypeToken<GetMetricsByReferrersByDomainResponse>(){}.getType();
    protected static final Type GET_METRICS_BY_REFERRING_DOMAINS = new TypeToken<GetMetricsByReferringDomainsResponse>(){}.getType();
    protected static final Type GET_BITLINK_QR_CODE = new TypeToken<GetBitlinkQrCodeResponse>(){}.getType();
    protected static final Type GET_BITLINKS_BY_GROUP = new TypeToken<GetBitlinksByGroupResponse>(){}.getType();
    protected static final Type GET_SORTED_BITLINKS_BY_GROUP = new TypeToken<GetSortedBitlinksByGroupResponse>(){}.getType();

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