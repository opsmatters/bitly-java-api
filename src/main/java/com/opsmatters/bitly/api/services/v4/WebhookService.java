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
import com.opsmatters.bitly.api.model.v4.GetWebhookResponse;
import com.opsmatters.bitly.api.model.v4.CreateWebhookRequest;
import com.opsmatters.bitly.api.model.v4.CreateWebhookResponse;
import com.opsmatters.bitly.api.model.v4.UpdateWebhookRequest;
import com.opsmatters.bitly.api.model.v4.UpdateWebhookResponse;
import com.opsmatters.bitly.api.model.v4.ListWebhooksResponse;

/**
 * The set of operations used for bitly webhooks.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class WebhookService extends BitlyV4Service
{
    /**
     * Constructor that takes a http context and API client.
     * @param accessToken The access token used to authenticate the operations
     * @param httpContext The set of HTTP operations
     */
    public WebhookService(String accessToken, HttpContext httpContext)
    {
        super(accessToken, httpContext);
    }

    /**
     * Returns the attributes of the given webhook.
     * @param webhookGuid The GUID of the webhook to be retrieved
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<GetWebhookResponse> get(String webhookGuid) throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/webhooks/%s", webhookGuid), getHeaders(), null, GET_WEBHOOK);
    }

    /**
     * Creates a webhook.
     * @param request The request containing the attributes of the webhook to be created
     * @return The response object
     * @throws IOException if there is a communication error.
     */
    public Optional<CreateWebhookResponse> create(CreateWebhookRequest request) throws IOException
    {
        return HTTP.POST("/v4/webhooks", request, getHeaders(), CREATE_WEBHOOK);
    }

    /**
     * Updates the attributes of the given webhook.
     * @param webhookGuid The GUID of the webhook to be updated
     * @param request The request containing the attributes of the webhook to be updated
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<UpdateWebhookResponse> update(String webhookGuid, UpdateWebhookRequest request)
        throws IOException, URISyntaxException
    {
        return HTTP.PATCH(String.format("/v4/webhooks/%s", webhookGuid), request, getHeaders(), null, UPDATE_WEBHOOK);
    }

    /**
     * Returns the webooks for the given organization GUID.
     * @param organizationGuid The GUID of the organization for the webhooks to be retrieved
     * @return The response object
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public Optional<ListWebhooksResponse> list(String organizationGuid) throws IOException, URISyntaxException
    {
        return HTTP.GET(String.format("/v4/organizations/%s/webhooks", organizationGuid), getHeaders(), null, LIST_WEBHOOKS);
    }

    /**
     * Deletes the given webhook.
     * @param webhookGuid The GUID of the webhook to be deleted
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public void delete(String webhookGuid) throws IOException, URISyntaxException
    {
        HTTP.DELETE(String.format("/v4/webhooks/%s", webhookGuid), getHeaders(), null);
    }
}