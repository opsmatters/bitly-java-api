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
 * Represents the attributes of a user.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class User
{
    private String name;
    private String login;
    private String created;
    private String modified;
    private List<Email> emails;

    @SerializedName("default_group_guid")
    private String defaultGroupGuid;

    @SerializedName("is_active")
    private boolean isActive;

    @SerializedName("is_sso_user")
    private boolean isSsoUser;

    @SerializedName("is_2fa_enabled")
    private boolean is2faEnabled;

    /**
     * Default constructor.
     */
    public User()
    {
    }

    /**
     * Returns the name of the user.
     * @return The name of the user
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the login for the user.
     * @return The login for the user
     */
    public String getLogin()
    {
        return login;
    }

    /**
     * Returns the default group GUID for the user.
     * @return The default group GUID for the user
     */
    public String getDefaultGroupGuid()
    {
        return defaultGroupGuid;
    }

    /**
     * Returns the created date for the user.
     * @return The created date for the user
     */
    public String getCreated()
    {
        return created;
    }

    /**
     * Returns the modified date for the user.
     * @return The modified date for the user
     */
    public String getModified()
    {
        return modified;
    }

    /**
     * Returns <CODE>true</CODE> if the user is active.
     * @return <CODE>true</CODE> if the user is active
     */
    public boolean isActive()
    {
        return isActive;
    }

    /**
     * Returns <CODE>true</CODE> if SSO is enabled for the user.
     * @return <CODE>true</CODE> if SSO is enabled for the user
     */
    public boolean isSsoUser()
    {
        return isSsoUser;
    }

    /**
     * Returns <CODE>true</CODE> if 2-factor authentication is enabled for the user.
     * @return <CODE>true</CODE> if 2-factor authentication is enabled for the user
     */
    public boolean is2faEnabled()
    {
        return is2faEnabled;
    }

    /**
     * Returns the email addresses for the user.
     * @return The email addresses for the user
     */
    public List<Email> getEmails()
    {
        return emails;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "User ["
            +"name="+name
            +", login="+login
            +", defaultGroupGuid="+defaultGroupGuid
            +", created="+created
            +", modified="+modified
            +", isActive="+isActive
            +", isSsoUser="+isSsoUser
            +", is2faEnabled="+is2faEnabled
            +", emails="+emails
            +"]";
    }
}