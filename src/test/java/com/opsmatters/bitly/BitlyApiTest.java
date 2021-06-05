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

package com.opsmatters.bitly;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;
import org.junit.Test;
import junit.framework.Assert;
import com.google.common.base.Optional;
import com.opsmatters.bitly.Bitly;
import com.opsmatters.bitly.api.model.v4.Unit;
import com.opsmatters.bitly.api.model.v4.UnitQuery;
import com.opsmatters.bitly.api.model.v4.GetBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.CreateFullBitlinkRequest;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.ExpandBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.UpdateBitlinkRequest;
import com.opsmatters.bitly.api.model.v4.UpdateBitlinkResponse;
import com.opsmatters.bitly.api.model.v4.GetBitlinkClicksResponse;
import com.opsmatters.bitly.api.model.v4.GetBitlinkClicksSummaryResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByCountriesResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferrersResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferringDomainsResponse;
import com.opsmatters.bitly.api.model.v4.GetMetricsByReferrersByDomainResponse;

/**
 * The set of tests used for Bitly API services.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class BitlyApiTest
{
    private static final Logger logger = Logger.getLogger(BitlyApiTest.class.getName());

    // Get the properties
    private String accessToken = System.getProperty("bitly.access_token");

    private final String URL1 = "https://google.com";
    private final String URL2 = "https://opsmatters.com";
    private final String TITLE = "Bitly API Test";
    private final String TITLE2 = "Bitly API Test Update";

    @Test
    public void testBitlinksServices()
    {
        String testName = "BitlinksServicesTest";
        logger.info("Starting test: "+testName);

        // Initialise the clients
        logger.info("Initialise the client");
        Assert.assertNotNull(accessToken);
        Bitly client = new Bitly(accessToken);
        Assert.assertNotNull(client);

        String bitlink = null;
        UnitQuery units = UnitQuery.builder()
            .unit(Unit.DAY)
            .units(7)
            .unitReference(toStringUTC(Instant.now()))
            .size(20)
            .build();

        try
        {
            Optional<CreateBitlinkResponse> response = client.bitlinks().shorten(URL1);
            Assert.assertTrue(response.isPresent());
            logger.info("Shortened bitlink: "+response.get().getLink());
            Assert.assertNotNull(response.get().getLink());
            bitlink = response.get().getId();
        }
        catch(IOException e)
        {
            logger.warning("Error in shorten bitlink: "+e.getMessage());
        }

        try
        {
            Optional<ExpandBitlinkResponse> response = client.bitlinks().expand(bitlink);
            Assert.assertTrue(response.isPresent());
            logger.info("Expanded bitlink: "+response.get().getLongUrl());
            Assert.assertNotNull(response.get().getLongUrl());
        }
        catch(IOException e)
        {
            logger.warning("Error in expand bitlink: "+e.getMessage());
        }

        try
        {
            CreateFullBitlinkRequest request = CreateFullBitlinkRequest.builder().title(TITLE).longUrl(URL2).build();
            Optional<CreateBitlinkResponse> response = client.bitlinks().create(request);
            Assert.assertTrue(response.isPresent());
            logger.info("Created bitlink: "+response.get().getLink());
            Assert.assertNotNull(response.get().getLink());
            bitlink = response.get().getId();
        }
        catch(IOException e)
        {
            logger.warning("Error in create bitlink: "+e.getMessage());
        }

        try
        {
            Optional<GetBitlinkResponse> response = client.bitlinks().get(bitlink);
            Assert.assertTrue(response.isPresent());
            logger.info("Get bitlink: "+response.get().getLink());
            Assert.assertNotNull(response.get().getLink());
        }
        catch(IOException | URISyntaxException e)
        {
            logger.warning("Error in get bitlink: "+e.getMessage());
        }

        try
        {
            UpdateBitlinkRequest request = UpdateBitlinkRequest.builder().title(TITLE2).build();
            Optional<UpdateBitlinkResponse> response = client.bitlinks().update(bitlink, request);
            Assert.assertTrue(response.isPresent());
            logger.info("Update bitlink: "+response.get().getTitle());
            Assert.assertEquals(response.get().getTitle(), TITLE2);
        }
        catch(IOException | URISyntaxException e)
        {
            logger.warning("Error in update bitlink: "+e.getMessage());
        }

        try
        {
            Optional<GetBitlinkClicksResponse> response = client.bitlinks().getClicks(bitlink, units);
            Assert.assertTrue(response.isPresent());
            logger.info("Get bitlink clicks: "+response.get().getLinkClicks().size());
            Assert.assertTrue(response.get().getLinkClicks().size() > 0);
        }
        catch(IOException | URISyntaxException e)
        {
            logger.warning("Error in get bitlink clicks: "+e.getMessage());
        }

        try
        {
            Optional<GetBitlinkClicksSummaryResponse> response = client.bitlinks().getClicksSummary(bitlink, units);
            Assert.assertTrue(response.isPresent());
            logger.info("Get bitlink clicks summary: "+response.get().getTotalClicks());
            Assert.assertTrue(response.get().getTotalClicks() > 0);
        }
        catch(IOException | URISyntaxException e)
        {
            logger.warning("Error in get bitlink clicks summary: "+e.getMessage());
        }

        try
        {
            Optional<GetMetricsByCountriesResponse> response = client.bitlinks().getMetricsByCountries(bitlink, units);
            Assert.assertTrue(response.isPresent());
            logger.info("Get bitlink metrics by countries: "+response.get().getMetrics().size());
            Assert.assertTrue(response.get().getMetrics().size() > 0);
        }
        catch(IOException | URISyntaxException e)
        {
            logger.warning("Error in get bitlink clicks: "+e.getMessage());
        }

        try
        {
            Optional<GetMetricsByReferrersResponse> response = client.bitlinks().getMetricsByReferrers(bitlink, units);
            Assert.assertTrue(response.isPresent());
            logger.info("Get bitlink metrics by referrers: "+response.get().getMetrics().size());
            Assert.assertTrue(response.get().getMetrics().size() > 0);
        }
        catch(IOException | URISyntaxException e)
        {
            logger.warning("Error in get bitlink clicks: "+e.getMessage());
        }

        try
        {
            Optional<GetMetricsByReferringDomainsResponse> response = client.bitlinks().getMetricsByReferringDomains(bitlink, units);
            Assert.assertTrue(response.isPresent());
            logger.info("Get bitlink metrics by referring domains: "+response.get().getMetrics().size());
            Assert.assertTrue(response.get().getMetrics().size() > 0);
        }
        catch(IOException | URISyntaxException e)
        {
            logger.warning("Error in get bitlink clicks: "+e.getMessage());
        }

        try
        {
            Optional<GetMetricsByReferrersByDomainResponse> response = client.bitlinks().getMetricsByReferrersByDomain(bitlink, units);
            Assert.assertTrue(response.isPresent());
            logger.info("Get bitlink metrics by referrers by domain: "+response.get().getReferrersByDomain().size());
            Assert.assertTrue(response.get().getReferrersByDomain().size() > 0);
        }
        catch(IOException | URISyntaxException e)
        {
            logger.warning("Error in get bitlink clicks: "+e.getMessage());
        }

        logger.info("Completed test: "+testName);
    }

    /**
     * Returns the given instant as a string in UTC.
     */
    public static String toStringUTC(Instant dt)
    {
        return LocalDateTime.ofInstant(dt, ZoneOffset.UTC).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+"+0000";
    }
}