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
 * Represents the attributes of an organization.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class Organization
{
    private String guid;
    private String name;
    private List<String> bsds;
    private String created;
    private String modified;
    private String tier;
    private String role;
    private Map<String,String> references;

    @SerializedName("is_active")
    private boolean isActive;

    @SerializedName("tier_display_name")
    private String tierDisplayName;

    @SerializedName("tier_family")
    private String tierFamily;

    /**
     * Returns the GUID of the organization.
     * @return The GUID of the organization
     */
    public String getGuid()
    {
        return guid;
    }

    /**
     * Returns the name of the organization.
     * @return The name of the organization
     */
    public String getName()
    {
        return name;
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
     * Returns the created date for the organization.
     * @return The created date for the organization
     */
    public String getCreated()
    {
        return created;
    }

    /**
     * Returns the modified date for the organization.
     * @return The modified date for the organization
     */
    public String getModified()
    {
        return modified;
    }

    /**
     * Returns <CODE>true</CODE> if the organization is active.
     * @return <CODE>true</CODE> if the organization is active
     */
    public boolean isActive()
    {
        return isActive;
    }

    /**
     * Returns the tier display name for the organization.
     * @return The tier display name for the organization
     */
    public String getTierDisplayName()
    {
        return tierDisplayName;
    }

    /**
     * Returns the tier family for the organization.
     * @return The tier family for the organization
     */
    public String getTierFamily()
    {
        return tierFamily;
    }

    /**
     * Returns the tier for the organization.
     * @return The tier for the organization
     */
    public String getTier()
    {
        return tier;
    }

    /**
     * Returns the role of the organization.
     * @return The role of the organization
     */
    public String getRole()
    {
        return role;
    }

    /**
     * Returns the references for the organization.
     * @return The references for the organization
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
        return "Organization ["
            +"guid="+guid
            +", name="+name
            +", bsds="+bsds
            +", role="+role
            +", created="+created
            +", modified="+modified
            +", isActive="+isActive
            +", tierDisplayName="+tierDisplayName
            +", tierFamily="+tierFamily
            +", tier="+tier
            +", references="+references
            +"]";
    }
}