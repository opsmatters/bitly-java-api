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
 * Represents the attributes of an OAuth app.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class OAuthApp
{
    private String name;
    private String link;
    private String description;

    @SerializedName("client_id")
    private String clientId;

    /**
     * Default constructor.
     */
    public OAuthApp()
    {
    }

    /**
     * Returns the name of the app.
     * @return The name of the app
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the description of the app.
     * @return The description of the app
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Returns the link for the app.
     * @return The link for the app
     */
    public String getLink()
    {
        return link;
    }

    /**
     * Returns the client id of the app.
     * @return The client id of the app
     */
    public String getClientId()
    {
        return clientId;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "OAuthApp ["
            +"name="+name
            +", description="+description
            +", link="+link
            +", clientId="+clientId
            +"]";
    }
}