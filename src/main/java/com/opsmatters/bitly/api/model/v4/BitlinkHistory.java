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
 * Represents the attributes of an bitlink history.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class BitlinkHistory
{
    private String hash;
    private String uuid;
    private String keyword;
    private String created;
    private String deactivated;
    private String bsd;
    private String login;

    @SerializedName("group_guid")
    private String groupGuid;

    @SerializedName("first_created")
    private String firstCreated;

    @SerializedName("is_active")
    private boolean isActive;

    @SerializedName("long_url")
    private String longUrl;

    /**
     * Default constructor.
     */
    public BitlinkHistory()
    {
    }

    /**
     * Returns the hash of the bitlink.
     * @return The hash of the bitlink
     */
    public String getHash()
    {
        return hash;
    }

    /**
     * Returns the uuid of the bitlink.
     * @return The uuid of the bitlink
     */
    public String getUuid()
    {
        return uuid;
    }

    /**
     * Returns the keyword of the bitlink.
     * @return The keyword of the bitlink
     */
    public String getKeyword()
    {
        return keyword;
    }

    /**
     * Returns the created date for the bitlink.
     * @return The created date for the bitlink
     */
    public String getCreated()
    {
        return created;
    }

    /**
     * Returns the GUID of the bitlink.
     * @return The GUID of the bitlink
     */
    public String getGroupGuid()
    {
        return groupGuid;
    }

    /**
     * Returns the first created date for the bitlink.
     * @return The first created date for the bitlink
     */
    public String getFirstCreated()
    {
        return firstCreated;
    }

    /**
     * Returns <CODE>true</CODE> if the bitlink is active.
     * @return <CODE>true</CODE> if the bitlink is active
     */
    public boolean isActive()
    {
        return isActive;
    }

    /**
     * Returns the long url for the bitlink.
     * @return The long url for the bitlink
     */
    public String getLongUrl()
    {
        return longUrl;
    }

    /**
     * Returns the deactivated date for the bitlink.
     * @return The deactivated date for the bitlink
     */
    public String getDeactivated()
    {
        return deactivated;
    }

    /**
     * Returns the branded short domain (BSD) for the bitlink.
     * @return The branded short domain (BSD) for the bitlink
     */
    public String getBsd()
    {
        return bsd;
    }

    /**
     * Returns the login for the bitlink.
     * @return The login for the bitlink
     */
    public String getLogin()
    {
        return login;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "BitlinkHistory ["
            +"hash="+hash
            +", uuid="+uuid
            +", keyword="+keyword
            +", created="+created
            +", groupGuid="+groupGuid
            +", firstCreated="+firstCreated
            +", isActive="+isActive
            +", longUrl="+longUrl
            +", deactivated="+deactivated
            +", bsd="+bsd
            +", login="+login
            +"]";
    }
}