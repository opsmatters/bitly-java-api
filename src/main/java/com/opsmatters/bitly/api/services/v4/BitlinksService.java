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
import com.opsmatters.bitly.api.model.v4.UnitQuery;
import com.opsmatters.bitly.api.model.v4.GetBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkRequest;
import com.opsmatters.bitly.api.model.v4.CreateFullBitlinkRequest;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
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
import com.opsmatters.bitly.api.model.v4.GetBitlinkQrCodeResponse;

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
    public Optional<CreateBitlinkResponse> create(CreateFullBitlinkRequest request) throws IOException
    {
        return HTTP.POST("/v4/bitlinks", request, getHeaders(), CREATE_BITLINK);
    }

    /**
     * Shortens the given long url.
     * @param longUrl The long url to be shortened
     * @return The response object
     * @throws IOException if there is a communication error.
     */
    public Optional<CreateBitlinkResponse> shorten(String longUrl) throws IOException
    {
        return shorten(CreateBitlinkRequest.builder().longUrl(longUrl).build());
    }

    /**
     * Shortens the given long url.
     * @param request The request containing the long url to be shortened
     * @return The response object
     * @throws IOException if there is a communication error.
     */
    public Optional<CreateBitlinkResponse> shorten(CreateBitlinkRequest request) throws IOException
    {
        return HTTP.POST("/v4/shorten", request, getHeaders(), CREATE_BITLINK);
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
     * Returns the clicks for the given bitlink.
     * @param bitlink The bitlink for the metrics
     * @param query The attributes of the units to use for the query
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetBitlinkClicksResponse> getClicks(String bitlink, UnitQuery query)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/bitlinks/%s/clicks", bitlink), getHeaders(), getQueryParameterList(query), GET_BITLINK_CLICKS);
    }

    /**
     * Returns the clicks summary for the given bitlink.
     * @param bitlink The bitlink for the metrics
     * @param query The attributes of the units to use for the query
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetBitlinkClicksSummaryResponse> getClicksSummary(String bitlink, UnitQuery query)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/bitlinks/%s/clicks/summary", bitlink), getHeaders(), getQueryParameterList(query), GET_BITLINK_CLICKS_SUMMARY);
    }

    /**
     * Returns the metrics for the given bitlink by countries.
     * @param bitlink The bitlink for the metrics
     * @param query The attributes of the units to use for the query
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetMetricsByCountriesResponse> getMetricsByCountries(String bitlink, UnitQuery query)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/bitlinks/%s/countries", bitlink), getHeaders(), getQueryParameterList(query), GET_METRICS_BY_COUNTRIES);
    }

    /**
     * Returns the metrics for the given bitlink by referrers.
     * @param bitlink The bitlink for the metrics
     * @param query The attributes of the units to use for the query
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetMetricsByReferrersResponse> getMetricsByReferrers(String bitlink, UnitQuery query)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/bitlinks/%s/referrers", bitlink), getHeaders(), getQueryParameterList(query), GET_METRICS_BY_REFERRERS);
    }

    /**
     * Returns the metrics for the given bitlink by referring domains.
     * @param bitlink The bitlink for the metrics
     * @param query The attributes of the units to use for the query
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetMetricsByReferringDomainsResponse> getMetricsByReferringDomains(String bitlink, UnitQuery query)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/bitlinks/%s/referring_domains", bitlink), getHeaders(), getQueryParameterList(query), GET_METRICS_BY_REFERRING_DOMAINS);
    }

    /**
     * Returns the metrics for the given bitlink by referrers by domain.
     * @param bitlink The bitlink for the metrics
     * @param query The attributes of the units to use for the query
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetMetricsByReferrersByDomainResponse> getMetricsByReferrersByDomain(String bitlink, UnitQuery query)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/bitlinks/%s/referrers_by_domains", bitlink), getHeaders(), getQueryParameterList(query), GET_METRICS_BY_REFERRERS_BY_DOMAIN);
    }

    /**
     * Returns the QR code for the given bitlin.
     * @param bitlink The bitlink for the QR code
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetBitlinkQrCodeResponse> getQrCode(String bitlink)
        throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/bitlinks/%s/qr", bitlink), getHeaders(), null, GET_BITLINK_QR_CODE);
    }
}