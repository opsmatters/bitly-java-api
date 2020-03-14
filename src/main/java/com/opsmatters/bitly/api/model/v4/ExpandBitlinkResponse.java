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
 * Represents a response to expand a bitlink.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class ExpandBitlinkResponse
{
    private String id;
    private String link;

    @SerializedName("long_url")
    private String longUrl;

    @SerializedName("created_at")
    private String createdAt;

    /**
     * Default constructor.
     */
    public ExpandBitlinkResponse()
    {
    }
    
    /**
     * Returns the id of the bitlink.
     * @return The id of the bitlink
     */
    public String getId()
    {
        return id;
    }

    /**
     * Returns the short url of the bitlink.
     * @return The short url of the bitlink
     */
    public String getLink()
    {
        return link;
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
     * Returns the created date of the bitlink.
     * @return The created date of the bitlink
     */
    public String getCreatedAt()
    {
        return createdAt;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "ExpandBitlinkResponse ["
            +"id="+id
            +", link="+link
            +", longUrl="+longUrl
            +", createdAt="+createdAt
            +"]";
    }
}