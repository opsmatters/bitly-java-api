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
 * Represents a request to shorten a bitlink.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class CreateBitlinkRequest
{
    private String domain;

    @SerializedName("group_guid")
    private String groupGuid;

    @SerializedName("long_url")
    private String longUrl;

    /**
     * Default constructor.
     */
    public CreateBitlinkRequest()
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
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "CreateBitlinkRequest ["
            +"groupGuid="+groupGuid
            +", domain="+domain
            +", longUrl="+longUrl
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
    public static class Builder<T extends CreateBitlinkRequest, B extends Builder<T,B>>
    {
        private CreateBitlinkRequest request = new CreateBitlinkRequest();

        /**
         * Sets the request.
         * @param request The request
         * @return This object
         */
        public B request(CreateBitlinkRequest request)
        {
            this.request = request;
            return self();
        }

        /**
         * Sets the group guid of the request.
         * @param groupGuid The group guid of the request
         * @return This object
         */
        public B groupGuid(String groupGuid)
        {
            request.setGroupGuid(groupGuid);
            return self();
        }

        /**
         * Sets the domain of the request.
         * @param domain The domain of the request
         * @return This object
         */
        public B domain(String domain)
        {
            request.setDomain(domain);
            return self();
        }

        /**
         * Sets the long url of the request.
         * @param longUrl The long url of the request
         * @return This object
         */
        public B longUrl(String longUrl)
        {
            request.setLongUrl(longUrl);
            return self();
        }

        /**
         * Returns this object.
         * @return This object
         */
        protected B self()
        {
            return (B)this;
        }

        /**
         * Returns the configured request
         * @return The request instance
         */
        public T build()
        {
            return (T)request;
        }
    }
}