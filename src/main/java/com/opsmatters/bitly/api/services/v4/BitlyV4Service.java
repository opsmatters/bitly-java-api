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
import com.opsmatters.bitly.api.services.BitlyService;
import com.opsmatters.bitly.api.services.HttpContext;
import com.opsmatters.bitly.api.model.v4.GetBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.ShortenBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.ExpandBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.UpdateBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.GetBitlinkClicksResponse;
import com.opsmatters.bitly.api.model.v4.GetBitlinkClicksSummaryResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByCountriesResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferrersResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferrersByDomainResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferringDomainsResponse;

/**
 * Provides the types of objects to be used with v4 API calls.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class BitlyV4Service extends BitlyService
{
    protected static final Type GET_BITLINK = new TypeToken<GetBitlinkResponse>(){}.getType();
    protected static final Type CREATE_BITLINK = new TypeToken<CreateBitlinkResponse>(){}.getType();
    protected static final Type SHORTEN_BITLINK = new TypeToken<ShortenBitlinkResponse>(){}.getType();
    protected static final Type EXPAND_BITLINK = new TypeToken<ExpandBitlinkResponse>(){}.getType();
    protected static final Type UPDATE_BITLINK = new TypeToken<UpdateBitlinkResponse>(){}.getType();
    protected static final Type GET_BITLINK_CLICKS = new TypeToken<GetBitlinkClicksResponse>(){}.getType();
    protected static final Type GET_BITLINK_CLICKS_SUMMARY = new TypeToken<GetBitlinkClicksSummaryResponse>(){}.getType();
    protected static final Type GET_METRICS_BY_COUNTRIES = new TypeToken<GetMetricsByCountriesResponse>(){}.getType();
    protected static final Type GET_METRICS_BY_REFERRERS = new TypeToken<GetMetricsByReferrersResponse>(){}.getType();
    protected static final Type GET_METRICS_BY_REFERRERS_BY_DOMAIN = new TypeToken<GetMetricsByReferrersByDomainResponse>(){}.getType();
    protected static final Type GET_METRICS_BY_REFERRING_DOMAINS = new TypeToken<GetMetricsByReferringDomainsResponse>(){}.getType();

    /**
     * Constructor that takes a http context and API client.
     * @param accessToken The access token used to authenticate API operations
     * @param httpContext The set of HTTP operations
     */
    public BitlyV4Service(String accessToken, HttpContext httpContext)
    {
        super(accessToken, httpContext);
    }
}
