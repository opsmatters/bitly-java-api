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
 * Represents a request to create a campaign channel.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class CreateChannelRequest
{
    private String name;
    private List<CampaignBitlink> bitlinks;

    @SerializedName("group_guid")
    private String groupGuid;

    /**
     * Default constructor.
     */
    public CreateChannelRequest()
    {
    }
    
    /**
     * Returns the name of the campaign channel.
     * @return The name of the campaign channel
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the campaign channel.
     * @param name The name of the campaign channel
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the group GUID of the campaign channel.
     * @return The group GUID of the campaign channel
     */
    public String getGroupGuid()
    {
        return groupGuid;
    }

    /**
     * Sets the group GUID of the campaign channel.
     * @param groupGuid The group GUID of the campaign channel
     */
    public void setGroupGuid(String groupGuid)
    {
        this.groupGuid = groupGuid;
    }

    /**
     * Returns the bitlinks for the campaign channel.
     * @return The bitlinks for the campaign channel
     */
    public List<CampaignBitlink> getBitlinks()
    {
        return bitlinks;
    }

    /**
     * Sets the bitlinks for the campaign channel.
     * @param bitlinks The bitlinks for the campaign channel
     */
    public void setBitlinks(List<CampaignBitlink> bitlinks)
    {
        this.bitlinks = bitlinks;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "CreateChannelRequest ["
            +"name="+name
            +", groupGuid="+groupGuid
            +", bitlinks="+bitlinks
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
        private CreateChannelRequest request = new CreateChannelRequest();

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
         * Sets the bitlinks for the request.
         * @param bitlinks The bitlinks for the request
         * @return This object
         */
        public Builder bitlinks(List<CampaignBitlink> bitlinks)
        {
            request.setBitlinks(bitlinks);
            return this;
        }

        /**
         * Returns the configured request
         * @return The request instance
         */
        public CreateChannelRequest build()
        {
            return request;
        }
    }
}