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

import java.util.logging.Logger;
import com.opsmatters.bitly.api.services.HttpContext;
import com.opsmatters.bitly.api.services.v4.BitlinkService;
import com.opsmatters.bitly.api.services.v4.CustomBitlinkService;
import com.opsmatters.bitly.api.services.v4.GroupService;
import com.opsmatters.bitly.api.services.v4.OrganizationService;
import com.opsmatters.bitly.api.services.v4.CampaignService;
import com.opsmatters.bitly.api.services.v4.CampaignChannelService;
import com.opsmatters.bitly.api.services.v4.UserService;
import com.opsmatters.bitly.api.services.v4.BsdService;
import com.opsmatters.bitly.api.services.v4.WebhookService;
import com.opsmatters.bitly.api.services.v4.AppService;

/**
 * Client used to invoke Bitly operations using the v4 REST API.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class Bitly
{
    private static final Logger logger = Logger.getLogger(Bitly.class.getName());

    private String protocol = "https";
    private String hostname = "api-ssl.bitly.com";
    private int port = 443;
    private String accessToken;
    private HttpContext httpContext;

    /**
     * Constructor that takes an access token.
     * @param accessToken The access token used to authenticate requests
     */
    public Bitly(String accessToken)
    {
        this.accessToken = accessToken;
        httpContext = new HttpContext(protocol, hostname, port);
    }
    
    /**
     * Returns the bitlink service.
     * @return The bitlink service
     */
    public BitlinkService bitlinks()
    {
        return new BitlinkService(accessToken, httpContext);
    }

    /**
     * Returns the custom bitlink service.
     * @return The custom bitlink service
     */
    public CustomBitlinkService customBitlinks()
    {
        return new CustomBitlinkService(accessToken, httpContext);
    }

    /**
     * Returns the group service.
     * @return The group service
     */
    public GroupService groups()
    {
        return new GroupService(accessToken, httpContext);
    }

    /**
     * Returns the organization service.
     * @return The organization service
     */
    public OrganizationService organizations()
    {
        return new OrganizationService(accessToken, httpContext);
    }

    /**
     * Returns the campgaign service.
     * @return The campgaign service
     */
    public CampaignService campaigns()
    {
        return new CampaignService(accessToken, httpContext);
    }

    /**
     * Returns the campgaign channel service.
     * @return The campgaign channel service
     */
    public CampaignChannelService channels()
    {
        return new CampaignChannelService(accessToken, httpContext);
    }

    /**
     * Returns the user service.
     * @return The user service
     */
    public UserService users()
    {
        return new UserService(accessToken, httpContext);
    }

    /**
     * Returns the BSD service.
     * @return The BSD service
     */
    public BsdService bsds()
    {
        return new BsdService(accessToken, httpContext);
    }

    /**
     * Returns the webhook service.
     * @return The webhook service
     */
    public WebhookService webhooks()
    {
        return new WebhookService(accessToken, httpContext);
    }

    /**
     * Returns the app service.
     * @return The app service
     */
    public AppService apps()
    {
        return new AppService(accessToken, httpContext);
    }
}