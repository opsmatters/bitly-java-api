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
import java.util.logging.Logger;
import org.junit.Test;
import junit.framework.Assert;
import com.google.common.base.Optional;
import com.opsmatters.bitly.Bitly;
import com.opsmatters.bitly.api.model.v4.ShortenResponse;
import com.opsmatters.bitly.api.model.v4.ExpandResponse;

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

    private final String URL = "https://google.com";

    @Test
    public void testBitlinksServices()
    {
        String testName = "BitlinksServicesTest";
        logger.info("Starting test: "+testName);

        // Initialise the clients
        logger.info("Initialise the client");
        Bitly client = new Bitly(accessToken);
        Assert.assertNotNull(client);

        String id = null;

        try
        {
            Optional<ShortenResponse> response = client.bitlinks().shorten(URL);
            Assert.assertTrue(response.isPresent());
            logger.info("Shortened bitlink: "+response.get().getLink());
            id = response.get().getId();
            Assert.assertNotNull(id);
        }
        catch(IOException e)
        {
            logger.warning("Error in shorten: "+e.getMessage());
        }

        try
        {
            Optional<ExpandResponse> response = client.bitlinks().expand(id);
            Assert.assertTrue(response.isPresent());
            logger.info("Expanded bitlink: "+response.get().getLongUrl());
        }
        catch(IOException e)
        {
            logger.warning("Error in expand: "+e.getMessage());
        }

        logger.info("Completed test: "+testName);
    }
}