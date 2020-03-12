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
 * Represents a request to update a group.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class UpdateGroupRequest
{
    private String name;
    private List<String> bsds;

    @SerializedName("organization_guid")
    private String organizationGuid;

    /**
     * Default constructor.
     */
    public UpdateGroupRequest()
    {
    }

    /**
     * Returns the name of the group.
     * @return The name of the group
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the group.
     * @param name The name of the group
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the list of BSDs.
     * @return The list of BSDs
     */
    public List<String> getBsds()
    {
        return bsds;
    }

    /**
     * Sets the list of BSDs.
     * @param bsds The list of BSDs
     */
    public void setBsds(List<String> bsds)
    {
        this.bsds = bsds;
    }

    /**
     * Returns the organization GUID of the group.
     * @return The organization GUID of the group
     */
    public String getOrganizationGuid()
    {
        return organizationGuid;
    }

    /**
     * Sets the organization GUID of the group.
     * @param organizationGuid The organization GUID of the group
     */
    public void setOrganizationGuid(String organizationGuid)
    {
        this.organizationGuid = organizationGuid;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "UpdateGroupRequest ["
            +"name="+name
            +", bsds="+bsds
            +", organizationGuid="+organizationGuid
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
        private UpdateGroupRequest request = new UpdateGroupRequest();

        /**
         * Sets the name of the request.
         * @param name The name of the request
         * @return This object
         */
        public Builder name(String name)
        {
            request.setName(name);
            return this;
        }

        /**
         * Sets the organization GUID of the request.
         * @param organizationGuid The organization GUID of the request
         * @return This object
         */
        public Builder organizationGuid(String organizationGuid)
        {
            request.setOrganizationGuid(organizationGuid);
            return this;
        }

        /**
         * Sets the BSDs for the request.
         * @param bsds The bsds for the request
         * @return This object
         */
        public Builder bsds(List<String> bsds)
        {
            request.setBsds(bsds);
            return this;
        }

        /**
         * Returns the configured request
         * @return The request instance
         */
        public UpdateGroupRequest build()
        {
            return request;
        }
    }
}