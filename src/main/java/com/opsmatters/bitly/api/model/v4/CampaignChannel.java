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

import java.util.Map;
import com.google.gson.annotations.SerializedName;

/**
 * Represents the attributes of a campaign channel.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class CampaignChannel
{
    private String guid;
    private String name;
    private String created;
    private String modified;
    private Map<String,String> references;

    @SerializedName("group_guid")
    private String groupGuid;

    /**
     * Default constructor.
     */
    public CampaignChannel()
    {
    }

    /**
     * Returns the GUID of the campaign channel.
     * @return The GUID of the campaign channel
     */
    public String getGuid()
    {
        return guid;
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
     * Returns the created date for the campaign channel.
     * @return The created date for the campaign channel
     */
    public String getCreated()
    {
        return created;
    }

    /**
     * Returns the modified date for the campaign channel.
     * @return The modified date for the campaign channel
     */
    public String getModified()
    {
        return modified;
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
     * Returns the references for the campaign channel.
     * @return The references for the campaign channel
     */
    public Map<String,String> getReferences()
    {
        return references;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "CampaignChannel ["
            +"guid="+guid
            +", name="+name
            +", groupGuid="+groupGuid
            +", created="+created
            +", modified="+modified
            +", references="+references
            +"]";
    }
}