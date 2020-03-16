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

package com.opsmatters.bitly.api.model.v4;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a request to create a webhook.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class CreateWebhookRequest
{
    private String name;
    private String url;
    private String event;

    @SerializedName("group_guid")
    private String groupGuid;

    @SerializedName("organization_guid")
    private String organizationGuid;

    @SerializedName("is_active")
    private boolean isActive;

    /**
     * Default constructor.
     */
    public CreateWebhookRequest()
    {
    }
    
    /**
     * Returns the name of the webhook.
     * @return The name of the webhook
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the webhook.
     * @param name The name of the webhook
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the url of the webhook.
     * @return The url of the webhook
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Sets the url of the webhook.
     * @param url The url of the webhook
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Returns the event of the webhook.
     * @return The event of the webhook
     */
    public String getEvent()
    {
        return event;
    }

    /**
     * Sets the event of the webhook.
     * @param event The event of the webhook
     */
    public void setEvent(String event)
    {
        this.event = event;
    }

    /**
     * Returns the group GUID of the webhook.
     * @return The group GUID of the webhook
     */
    public String getGroupGuid()
    {
        return groupGuid;
    }

    /**
     * Sets the group GUID of the webhook.
     * @param groupGuid The group GUID of the webhook
     */
    public void setGroupGuid(String groupGuid)
    {
        this.groupGuid = groupGuid;
    }

    /**
     * Returns the organization GUID of the webhook.
     * @return The organization GUID of the webhook
     */
    public String getOrganizationGuid()
    {
        return organizationGuid;
    }

    /**
     * Sets the organization GUID of the webhook.
     * @param organizationGuid The organization GUID of the webhook
     */
    public void setOrganizationGuid(String organizationGuid)
    {
        this.organizationGuid = organizationGuid;
    }

    /**
     * Returns <CODE>true</CODE> if the webhook is active.
     * @return <CODE>true</CODE> if the webhook is active
     */
    public boolean isActive()
    {
        return isActive;
    }

    /**
     * Set to <CODE>true</CODE> if the webhook is active.
     * @param isActive <CODE>true</CODE> if the webhook is active
     */
    public void setActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "CreateWebhookRequest ["
            +"name="+name
            +", url="+url
            +", event="+event
            +", groupGuid="+groupGuid
            +", organizationGuid="+organizationGuid
            +", isActive="+isActive
            +"]";
    }

    /**
     * Returns a builder for the request.
     * @return The builder instance.
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to make request construction easier.
     */
    public static class Builder
    {
        private CreateWebhookRequest request = new CreateWebhookRequest();

        /**
         * Sets the name of the request.
         * @param name The name of the request
         * @return This object
         */
        public Builder name(String name)
        {
            request.setName(name);
            return this;
        }

        /**
         * Sets the url of the request.
         * @param url The url of the request
         * @return This object
         */
        public Builder url(String url)
        {
            request.setUrl(url);
            return this;
        }

        /**
         * Sets the event of the request.
         * @param event The event of the request
         * @return This object
         */
        public Builder event(String event)
        {
            request.setEvent(event);
            return this;
        }

        /**
         * Sets the group GUID of the request.
         * @param groupGuid The group GUID of the request
         * @return This object
         */
        public Builder groupGuid(String groupGuid)
        {
            request.setGroupGuid(groupGuid);
            return this;
        }

        /**
         * Sets the organization GUID of the request.
         * @param organizationGuid The organization GUID of the request
         * @return This object
         */
        public Builder organizationGuid(String organizationGuid)
        {
            request.setOrganizationGuid(organizationGuid);
            return this;
        }

        /**
         * Set to <CODE>true</CODE> if the webhook is active.
         * @param active <CODE>true</CODE> if the webhook is active
         * @return This object
         */
        public Builder active(boolean active)
        {
            request.setActive(active);
            return this;
        }

        /**
         * Returns the configured request
         * @return The request instance
         */
        public CreateWebhookRequest build()
        {
            return request;
        }
    }
}