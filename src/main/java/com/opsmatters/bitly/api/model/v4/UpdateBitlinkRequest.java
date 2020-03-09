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
 * Represents a request to update a bitlink.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class UpdateBitlinkRequest
{
    private String domain;
    private String title;
    private List<String> tags;
    private List<Deeplink> deeplinks;

    @SerializedName("group_guid")
    private String groupGuid;

    @SerializedName("long_url")
    private String longUrl;

    /**
     * Default constructor.
     */
    public UpdateBitlinkRequest()
    {
    }
    
    /**
     * Returns the group guid of the bitlink.
     * @return The group guid of the bitlink
     */
    public String getGroupGuid()
    {
        return groupGuid;
    }

    /**
     * Sets the group guid of the bitlink.
     * @param groupGuid The group guid of the bitlink
     */
    public void setGroupGuid(String groupGuid)
    {
        this.groupGuid = groupGuid;
    }

    /**
     * Returns the domain of the bitlink.
     * @return The domain of the bitlink
     */
    public String getDomain()
    {
        return domain;
    }

    /**
     * Sets the domain of the bitlink.
     * @param domain The domain of the bitlink
     */
    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    /**
     * Returns the title of the bitlink.
     * @return The title of the bitlink
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets the title of the bitlink.
     * @param title The title of the bitlink
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Returns the long url of the bitlink.
     * @return The long url of the bitlink
     */
    public String getLongUrl()
    {
        return longUrl;
    }

    /**
     * Sets the long url of the bitlink.
     * @param longUrl The long url of the bitlink
     */
    public void setLongUrl(String longUrl)
    {
        this.longUrl = longUrl;
    }

    /**
     * Returns the tags for the bitlink.
     * @return The tags for the bitlink
     */
    public List<String> getTags()
    {
        return tags;
    }

    /**
     * Sets the tags for the bitlink.
     * @param tags The tags for the bitlink
     */
    public void setTags(List<String> tags)
    {
        this.tags = tags;
    }

    /**
     * Returns the deeplinks for the bitlink.
     * @return The deeplinks for the bitlink
     */
    public List<Deeplink> getDeeplinks()
    {
        return deeplinks;
    }

    /**
     * Sets the deeplinks for the bitlink.
     * @param deeplinks The deeplinks for the bitlink
     */
    public void setDeeplinks(List<Deeplink> deeplinks)
    {
        this.deeplinks = deeplinks;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "UpdateBitlinkRequest ["
            +"groupGuid="+groupGuid
            +", domain="+domain
            +", title="+title
            +", longUrl="+longUrl
            +", tags="+tags
            +", deeplinks="+deeplinks
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
        private UpdateBitlinkRequest request = new UpdateBitlinkRequest();

        /**
         * Sets the group guid of the request.
         * @param groupGuid The group guid of the request
         * @return This object
         */
        public Builder groupGuid(String groupGuid)
        {
            request.setGroupGuid(groupGuid);
            return this;
        }

        /**
         * Sets the domain of the request.
         * @param domain The domain of the request
         * @return This object
         */
        public Builder domain(String domain)
        {
            request.setDomain(domain);
            return this;
        }

        /**
         * Sets the title of the request.
         * @param title The title of the request
         * @return This object
         */
        public Builder title(String title)
        {
            request.setTitle(title);
            return this;
        }

        /**
         * Sets the long url of the request.
         * @param longUrl The long url of the request
         * @return This object
         */
        public Builder longUrl(String longUrl)
        {
            request.setLongUrl(longUrl);
            return this;
        }

        /**
         * Sets the tags for the request.
         * @param tags The tags for the request
         * @return This object
         */
        public Builder tags(List<String> tags)
        {
            request.setTags(tags);
            return this;
        }

        /**
         * Sets the deeplinks for the request.
         * @param deeplinks The deeplinks for the request
         * @return This object
         */
        public Builder deeplinks(List<Deeplink> deeplinks)
        {
            request.setDeeplinks(deeplinks);
            return this;
        }

        /**
         * Returns the configured request
         * @return The request instance
         */
        public UpdateBitlinkRequest build()
        {
            return request;
        }
    }
}