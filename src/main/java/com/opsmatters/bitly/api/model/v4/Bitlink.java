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
import java.util.Map;
import com.google.gson.annotations.SerializedName;

/**
 * Represents the attributes of a bitlink.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class Bitlink
{
    private String id;
    private String link;
    private String title;
    private Map<String,String> references;
    private List<String> tags;
    private List<Deeplink> deeplinks;
    private Boolean archived;

    @SerializedName("long_url")
    private String longUrl;

    @SerializedName("client_id")
    private String clientId;

    @SerializedName("custom_bitlinks")
    private List<String> customBitlinks;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("created_by")
    private String createdBy;

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
     * Returns the title of the bitlink.
     * @return The title of the bitlink
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Returns the references for the bitlink.
     * @return The references for the bitlink
     */
    public Map<String,String> getReferences()
    {
        return references;
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
     * Returns the deeplinks for the bitlink.
     * @return The deeplinks for the bitlink
     */
    public List<Deeplink> getDeeplinks()
    {
        return deeplinks;
    }

    /**
     * Returns the custom bitlinks for the bitlink.
     * @return The custom bitlinks for the bitlink
     */
    public List<String> getCustomBitlinks()
    {
        return customBitlinks;
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
     * Returns the created by of the bitlink.
     * @return The created by of the bitlink
     */
    public String getCreatedBy()
    {
        return createdBy;
    }

    /**
     * Returns the client id of the bitlink.
     * @return The client id of the bitlink
     */
    public String getClientId()
    {
        return clientId;
    }

    /**
     * Returns <CODE>true</CODE> if the bitlink has been archived.
     * @return <CODE>true</CODE> if the bitlink has been archived
     */
    public Boolean isArchived()
    {
        return archived;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "Bitlink ["
            +"id="+id
            +", link="+link
            +", longUrl="+longUrl
            +", title="+title
            +", clientId="+clientId
            +", tags="+tags
            +", references="+references
            +", deeplinks="+deeplinks
            +", customBitlinks="+customBitlinks
            +", archived="+archived
            +", createdAt="+createdAt
            +", createdBy="+createdBy
            +"]";
    }
}