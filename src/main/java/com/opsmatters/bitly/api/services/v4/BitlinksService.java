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
import com.opsmatters.bitly.Bitly;
import com.google.common.base.Optional;
import com.opsmatters.bitly.api.services.HttpContext;
import com.opsmatters.bitly.api.services.QueryParameterList;
import com.opsmatters.bitly.api.services.v4.BitlyV4Service;
import com.opsmatters.bitly.api.model.v4.Unit;
import com.opsmatters.bitly.api.model.v4.GetBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkRequest;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.ShortenBitlinkRequest;
import com.opsmatters.bitly.api.model.v4.ShortenBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.ExpandBitlinkRequest;
import com.opsmatters.bitly.api.model.v4.ExpandBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.UpdateBitlinkRequest;
import com.opsmatters.bitly.api.model.v4.UpdateBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.GetBitlinkClicksResponse;
import com.opsmatters.bitly.api.model.v4.GetBitlinkClicksSummaryResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByCountriesResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferrersResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferrersByDomainResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferringDomainsResponse;

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
     * Returns the attributes of the given bitlink.
     * @param bitlink The bitlink to be retrieved
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetBitlinkResponse> get(String bitlink) throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/bitlinks/%s", bitlink), getHeaders(), null, GET_BITLINK);
    }

    /**
     * Creates a bitlink.
     * @param request The request containing the attributes of the bitlink to be created
     * @return The response object
     * @throws IOException if there is a communication error.
     */
    public Optional<CreateBitlinkResponse> create(CreateBitlinkRequest request) throws IOException
    {
        return HTTP.POST("/v4/bitlinks", request, getHeaders(), CREATE_BITLINK);
    }

    /**
     * Shortens the given long url.
     * @param longUrl The long url to be shortened
     * @return The response object
     * @throws IOException if there is a communication error.
     */
    public Optional<ShortenBitlinkResponse> shorten(String longUrl) throws IOException
    {
        return shorten(ShortenBitlinkRequest.builder().longUrl(longUrl).build());
    }

    /**
     * Shortens the given long url.
     * @param request The request containing the long url to be shortened
     * @return The response object
     * @throws IOException if there is a communication error.
     */
    public Optional<ShortenBitlinkResponse> shorten(ShortenBitlinkRequest request) throws IOException
    {
        return HTTP.POST("/v4/shorten", request, getHeaders(), SHORTEN_BITLINK);
    }

    /**
     * Returns the long url for the given bitlink.
     * @param bitlink The bitlink to be expanded
     * @return The response object
     * @throws IOException if there is a communication error.
     */
    public Optional<ExpandBitlinkResponse> expand(String bitlink) throws IOException
    {
        return expand(ExpandBitlinkRequest.builder().bitlink(bitlink).build());
    }

    /**
     * Returns the long url for the given bitlink.
     * @param request The request containing the bitlink to be expanded
     * @return The response object
     * @throws IOException if there is a communication error.
     */
    public Optional<ExpandBitlinkResponse> expand(ExpandBitlinkRequest request) throws IOException
    {
        return HTTP.POST("/v4/expand", request, getHeaders(), EXPAND_BITLINK);
    }

    /**
     * Updates the given bitlink.
     * @param bitlink The bitlink to be updated
     * @param request The request containing the attributes of the bitlink to be updated
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<UpdateBitlinkResponse> update(String bitlink, UpdateBitlinkRequest request)
        throws IOException, URISyntaxException
    {
        return HTTP.PATCH(String.format("/v4/bitlinks/%s", bitlink), request, getHeaders(), null, UPDATE_BITLINK);
    }

    /**
     * Returns the query parameter list for the given units.
     * @param unit The unit of time for the clicks (either "minute", "hour", "day", "week", "month")
     * @param units The time units to query data for. A value of -1 returns all units available.
     * @param unitReference The most recent time for to pull metrics for (ISO-8601 timestamp). Defaults to current time.
     * @param size The quantity of items to be returned. Defaults to 50.
     * @return The list of query parameters
     */
    public QueryParameterList getQueryParameterList(Unit unit, int units, String unitReference, int size)
    {
        QueryParameterList queryParams = new QueryParameterList();
        if(unit != null)
            queryParams.add("unit", unit.value());
        if(units > 0)
            queryParams.add("units", Integer.toString(units));
        if(unitReference != null)
            queryParams.add("unit_reference", unitReference);
        if(size > 0)
            queryParams.add("size", Integer.toString(size));
        return queryParams;
    }

    /**
     * Returns the clicks for the given bitlink.
     * @param bitlink The bitlink for the metrics
     * @param unit The unit of time for the clicks (either "minute", "hour", "day", "week", "month")
     * @param units The time units to query data for. A value of -1 returns all units available.
     * @param unitReference The most recent time for to pull metrics for (ISO-8601 timestamp). Defaults to current time.
     * @param size The quantity of items to be returned. Defaults to 50.
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetBitlinkClicksResponse> getClicks(String bitlink, Unit unit, int units, String unitReference, int size)
        throws IOException, URISyntaxException
    {
        QueryParameterList queryParams = getQueryParameterList(unit, units, unitReference, size);
        return HTTP.GET(String.format("/v4/bitlinks/%s/clicks", bitlink), getHeaders(), queryParams, GET_BITLINK_CLICKS);
    }

    /**
     * Returns the clicks summary for the given bitlink.
     * @param bitlink The bitlink for the metrics
     * @param unit The unit of time for the clicks (either "minute", "hour", "day", "week", "month")
     * @param units The time units to query data for. A value of -1 returns all units available.
     * @param unitReference The most recent time for to pull metrics for (ISO-8601 timestamp). Defaults to current time.
     * @param size The quantity of items to be returned. Defaults to 50.
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetBitlinkClicksSummaryResponse> getClicksSummary(String bitlink, Unit unit, int units, String unitReference, int size)
        throws IOException, URISyntaxException
    {
        QueryParameterList queryParams = getQueryParameterList(unit, units, unitReference, size);
        return HTTP.GET(String.format("/v4/bitlinks/%s/clicks/summary", bitlink), getHeaders(), queryParams, GET_BITLINK_CLICKS_SUMMARY);
    }

    /**
     * Returns the metrics for the given bitlink by countries.
     * @param bitlink The bitlink for the metrics
     * @param unit The unit of time for the clicks (either "minute", "hour", "day", "week", "month")
     * @param units The time units to query data for. A value of -1 returns all units available.
     * @param unitReference The most recent time for to pull metrics for (ISO-8601 timestamp). Defaults to current time.
     * @param size The quantity of items to be returned. Defaults to 50.
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetMetricsByCountriesResponse> getMetricsByCountries(String bitlink, Unit unit, int units, String unitReference, int size)
        throws IOException, URISyntaxException
    {
        QueryParameterList queryParams = getQueryParameterList(unit, units, unitReference, size);
        return HTTP.GET(String.format("/v4/bitlinks/%s/countries", bitlink), getHeaders(), queryParams, GET_METRICS_BY_COUNTRIES);
    }

    /**
     * Returns the metrics for the given bitlink by referrers.
     * @param bitlink The bitlink for the metrics
     * @param unit The unit of time for the clicks (either "minute", "hour", "day", "week", "month")
     * @param units The time units to query data for. A value of -1 returns all units available.
     * @param unitReference The most recent time for to pull metrics for (ISO-8601 timestamp). Defaults to current time.
     * @param size The quantity of items to be returned. Defaults to 50.
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetMetricsByReferrersResponse> getMetricsByReferrers(String bitlink, Unit unit, int units, String unitReference, int size)
        throws IOException, URISyntaxException
    {
        QueryParameterList queryParams = getQueryParameterList(unit, units, unitReference, size);
        return HTTP.GET(String.format("/v4/bitlinks/%s/referrers", bitlink), getHeaders(), queryParams, GET_METRICS_BY_REFERRERS);
    }

    /**
     * Returns the metrics for the given bitlink by referring domains.
     * @param bitlink The bitlink for the metrics
     * @param unit The unit of time for the clicks (either "minute", "hour", "day", "week", "month")
     * @param units The time units to query data for. A value of -1 returns all units available.
     * @param unitReference The most recent time for to pull metrics for (ISO-8601 timestamp). Defaults to current time.
     * @param size The quantity of items to be returned. Defaults to 50.
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetMetricsByReferringDomainsResponse> getMetricsByReferringDomains(String bitlink, Unit unit, int units, String unitReference, int size)
        throws IOException, URISyntaxException
    {
        QueryParameterList queryParams = getQueryParameterList(unit, units, unitReference, size);
        return HTTP.GET(String.format("/v4/bitlinks/%s/referring_domains", bitlink), getHeaders(), queryParams, GET_METRICS_BY_REFERRING_DOMAINS);
    }

    /**
     * Returns the metrics for the given bitlink by referrers by domain.
     * @param bitlink The bitlink for the metrics
     * @param unit The unit of time for the clicks (either "minute", "hour", "day", "week", "month")
     * @param units The time units to query data for. A value of -1 returns all units available.
     * @param unitReference The most recent time for to pull metrics for (ISO-8601 timestamp). Defaults to current time.
     * @param size The quantity of items to be returned. Defaults to 50.
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetMetricsByReferrersByDomainResponse> getMetricsByReferrersByDomain(String bitlink, Unit unit, int units, String unitReference, int size)
        throws IOException, URISyntaxException
    {
        QueryParameterList queryParams = getQueryParameterList(unit, units, unitReference, size);
        return HTTP.GET(String.format("/v4/bitlinks/%s/referrers_by_domains", bitlink), getHeaders(), queryParams, GET_METRICS_BY_REFERRERS_BY_DOMAIN);
    }
}