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
 * Represents the attributes of a group.
 * 
 * @author Gerald Curley (opsmatters)
 */
public abstract class Group
{
    private String guid;
    private String name;
    private List<String> bsds;
    private String created;
    private String modified;
    private String role;
    private Map<String,String> references;

    @SerializedName("is_active")
    private boolean isActive;

    @SerializedName("organization_guid")
    private String organizationGuid;

    /**
     * Returns the GUID of the group.
     * @return The GUID of the group
     */
    public String getGuid()
    {
        return guid;
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
     * Returns the list of BSDs.
     * @return The list of BSDs
     */
    public List<String> getBsds()
    {
        return bsds;
    }

    /**
     * Returns the created date for the group.
     * @return The created date for the group
     */
    public String getCreated()
    {
        return created;
    }

    /**
     * Returns the modified date for the group.
     * @return The modified date for the group
     */
    public String getModified()
    {
        return modified;
    }

    /**
     * Returns <CODE>true</CODE> if the group is active.
     * @return <CODE>true</CODE> if the group is active
     */
    public boolean isActive()
    {
        return isActive;
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
     * Returns the role of the group.
     * @return The role of the group
     */
    public String getRole()
    {
        return role;
    }

    /**
     * Returns the references for the group.
     * @return The references for the group
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
        return "Group ["
            +"guid="+guid
            +", name="+name
            +", bsds="+bsds
            +", role="+role
            +", created="+created
            +", modified="+modified
            +", isActive="+isActive
            +", organizationGuid="+organizationGuid
            +", references="+references
            +"]";
    }
}