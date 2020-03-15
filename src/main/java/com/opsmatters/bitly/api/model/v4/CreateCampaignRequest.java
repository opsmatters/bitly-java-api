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

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * Represents a request to create a campaign.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class CreateCampaignRequest
{
    private String name;
    private String description;

    @SerializedName("group_guid")
    private String groupGuid;

    @SerializedName("channel_guids")
    private List<String> channelGuids;

    /**
     * Default constructor.
     */
    public CreateCampaignRequest()
    {
    }
    
    /**
     * Returns the name of the campaign.
     * @return The name of the campaign
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the campaign.
     * @param name The name of the campaign
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the description of the campaign.
     * @return The description of the campaign
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets the description of the campaign.
     * @param description The description of the campaign
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Returns the group GUID of the campaign.
     * @return The group GUID of the campaign
     */
    public String getGroupGuid()
    {
        return groupGuid;
    }

    /**
     * Sets the group GUID of the campaign.
     * @param groupGuid The group GUID of the campaign
     */
    public void setGroupGuid(String groupGuid)
    {
        this.groupGuid = groupGuid;
    }

    /**
     * Returns the channel GUIDs of the campaign.
     * @return The channel GUIDs of the campaign
     */
    public List<String> getChannelGuids()
    {
        return channelGuids;
    }

    /**
     * Sets the channel GUIDs of the campaign.
     * @param channelGuids The channel GUIDs of the campaign
     */
    public void setChannelGuids(List<String> channelGuids)
    {
        this.channelGuids = channelGuids;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "CreateCampaignRequest ["
            +"name="+name
            +", description="+description
            +", groupGuid="+groupGuid
            +", channelGuids="+channelGuids
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
        private CreateCampaignRequest request = new CreateCampaignRequest();

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
         * Sets the description of the request.
         * @param description The description of the request
         * @return This object
         */
        public Builder description(String description)
        {
            request.setDescription(description);
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
         * Sets the channel GUIDs of the request.
         * @param channelGuids The channel GUIDs of the request
         * @return This object
         */
        public Builder channelGuids(List<String> channelGuids)
        {
            request.setChannelGuids(channelGuids);
            return this;
        }

        /**
         * Returns the configured request
         * @return The request instance
         */
        public CreateCampaignRequest build()
        {
            return request;
        }
    }
}