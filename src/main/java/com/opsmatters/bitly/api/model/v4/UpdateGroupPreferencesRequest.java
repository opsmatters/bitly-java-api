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
 * Represents a request to update a group's preference.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class UpdateGroupPreferencesRequest
{
    @SerializedName("group_guid")
    private String groupGuid;

    @SerializedName("domain_preference")
    private String domainPreference;

    /**
     * Default constructor.
     */
    public UpdateGroupPreferencesRequest()
    {
    }

    /**
     * Returns the GUID of the group.
     * @return The GUID of the group
     */
    public String getGroupGuid()
    {
        return groupGuid;
    }

    /**
     * Sets the GUID of the group.
     * @param groupGuid The GUID of the group
     */
    public void setGroupGuid(String groupGuid)
    {
        this.groupGuid = groupGuid;
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
     * Sets the domain preference of the group.
     * @param domainPreference The domain preference of the group
     */
    public void setDomainPreferences(String domainPreference)
    {
        this.domainPreference = domainPreference;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "UpdateGroupPreferencesRequest ["
            +"groupGuid="+groupGuid
            +", domainPreference="+domainPreference
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
        private UpdateGroupPreferencesRequest request = new UpdateGroupPreferencesRequest();

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
         * Sets the domain preference of the request.
         * @param domainPreference The domain preference of the request
         * @return This object
         */
        public Builder domainPreference(String domainPreference)
        {
            request.setDomainPreferences(domainPreference);
            return this;
        }

        /**
         * Returns the configured request
         * @return The request instance
         */
        public UpdateGroupPreferencesRequest build()
        {
            return request;
        }
    }
}