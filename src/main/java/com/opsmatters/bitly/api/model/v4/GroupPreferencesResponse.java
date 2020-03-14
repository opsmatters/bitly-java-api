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
 * Represents a response containing preferences for a group.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class GroupPreferencesResponse
{
    @SerializedName("group_guid")
    private String groupGuid;

    @SerializedName("domain_preference")
    private String domainPreference;

    /**
     * Returns the GUID of the group.
     * @return The GUID of the group
     */
    public String getGroupGuid()
    {
        return groupGuid;
    }

    /**
     * Returns the domain preference of the group.
     * @return The domain preference of the group
     */
    public String getDomainPreference()
    {
        return domainPreference;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "GroupPreferencesResponse ["
            +" groupGuid="+groupGuid
            +", domainPreference="+domainPreference
            +"]";
    }
}