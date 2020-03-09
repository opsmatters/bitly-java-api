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
 * Represents a deeplink.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class Deeplink
{
    private String bitlink;
    private String guid;
    private String os;
    private String created;
    private String modified;

    @SerializedName("app_uri_path")
    private String appUriPath;

    @SerializedName("install_type")
    private String installType;

    @SerializedName("install_url")
    private String installUrl;

    @SerializedName("app_id")
    private String appId;

    @SerializedName("app_guid")
    private String appGuid;

    @SerializedName("brand_guid")
    private String brandGuid;

    /**
     * Default constructor.
     */
    public Deeplink()
    {
    }

    /**
     * Returns the bitlink of the deeplink.
     * @return The bitlink path of the deeplink
     */
    public String getBitlink()
    {
        return bitlink;
    }

    /**
     * Returns the created date of the deeplink.
     * @return The created date of the deeplink
     */
    public String getCreated()
    {
        return created;
    }

    /**
     * Returns the modified date of the deeplink.
     * @return The modified date of the deeplink
     */
    public String getModified()
    {
        return modified;
    }
    
    /**
     * Returns the app uri path of the deeplink.
     * @return The app uri path of the deeplink
     */
    public String getAppUriPath()
    {
        return appUriPath;
    }

    /**
     * Returns the install type of the deeplink.
     * @return The install type of the deeplink
     */
    public String getInstallType()
    {
        return installType;
    }

    /**
     * Returns the install url of the deeplink.
     * @return The install url of the deeplink
     */
    public String getInstallUrl()
    {
        return installUrl;
    }

    /**
     * Returns the app id of the deeplink.
     * @return The app id of the deeplink
     */
    public String getAppId()
    {
        return appId;
    }

    /**
     * Returns the app guid of the deeplink.
     * @return The app guid of the deeplink
     */
    public String getAppGuid()
    {
        return appGuid;
    }

    /**
     * Returns the guid of the deeplink.
     * @return The guid of the deeplink
     */
    public String getGuid()
    {
        return guid;
    }

    /**
     * Returns the os of the deeplink.
     * @return The os of the deeplink
     */
    public String getOs()
    {
        return os;
    }

    /**
     * Returns the brand guid of the deeplink.
     * @return The brand guid of the deeplink
     */
    public String getBrandGuid()
    {
        return brandGuid;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "Deeplink ["
            +"bitlink="+bitlink
            +", appUriPath="+appUriPath
            +", installType="+installType
            +", installUrl="+installUrl
            +", appId="+appId
            +", appGuid="+appGuid
            +", guid="+guid
            +", os="+os
            +", brandGuid="+brandGuid
            +", created="+created
            +", modified="+modified
            +"]";
    }

}