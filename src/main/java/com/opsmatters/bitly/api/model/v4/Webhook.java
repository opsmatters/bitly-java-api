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
 * Represents the attributes of a webhook.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class Webhook
{
    private String guid;
    private String name;
    private String url;
    private String status;
    private String created;
    private String modified;
    private String deactivated;
    private String event;
    private Map<String,String> references;

    @SerializedName("organization_guid")
    private String organizationGuid;

    @SerializedName("group_guid")
    private String groupGuid;

    @SerializedName("modified_by")
    private String modifiedBy;

    @SerializedName("is_active")
    private boolean isActive;

    /**
     * Default constructor.
     */
    public Webhook()
    {
    }

    /**
     * Returns the GUID of the webhook.
     * @return The GUID of the webhook
     */
    public String getGuid()
    {
        return guid;
    }

    /**
     * Returns the name of the webhook.
     * @return The name of the webhook
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the url of the webhook.
     * @return The url of the webhook
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Returns the status of the webhook.
     * @return The status of the webhook
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * Returns the created date for the webhook.
     * @return The created date for the webhook
     */
    public String getCreated()
    {
        return created;
    }

    /**
     * Returns the modified date for the webhook.
     * @return The modified date for the webhook
     */
    public String getModified()
    {
        return modified;
    }

    /**
     * Returns the user that modified the webhook.
     * @return The user that modified the webhook
     */
    public String getModifiedBy()
    {
        return modifiedBy;
    }

    /**
     * Returns the deactivated date for the webhook.
     * @return The deactivated date for the webhook
     */
    public String getDeactivated()
    {
        return deactivated;
    }

    /**
     * Returns <CODE>true</CODE> if the webhook is active.
     * @return <CODE>true</CODE> if the webhook is active
     */
    public boolean isActive()
    {
        return isActive;
    }

    /**
     * Returns the group GUID of the webhook.
     * @return The group GUID of the webhook
     */
    public String getGroupGuid()
    {
        return groupGuid;
    }

    /**
     * Returns the organization GUID of the webhook.
     * @return The organization GUID of the webhook
     */
    public String getOrganizationGuid()
    {
        return organizationGuid;
    }

    /**
     * Returns the event of the webhook.
     * @return The event of the webhook
     */
    public String getEvent()
    {
        return event;
    }

    /**
     * Returns the references for the webhook.
     * @return The references for the webhook
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
        return "Webhook ["
            +"guid="+guid
            +", name="+name
            +", url="+url
            +", status="+status
            +", created="+created
            +", modified="+modified
            +", modifiedBy="+modifiedBy
            +", deactivated="+deactivated
            +", isActive="+isActive
            +", groupGuid="+groupGuid
            +", organizationGuid="+organizationGuid
            +", event="+event
            +", references="+references
            +"]";
    }
}