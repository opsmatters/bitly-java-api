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
 * Represents a request to update a user.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class UpdateUserRequest
{
    private String name;

    @SerializedName("default_group_guid")
    private String defaultGroupGuid;

    /**
     * Default constructor.
     */
    public UpdateUserRequest()
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
     * Sets the name of the user.
     * @param name The name of the user
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the default group GUID of the user.
     * @return The default group GUID of the user
     */
    public String getDefaultGroupGuid()
    {
        return defaultGroupGuid;
    }

    /**
     * Sets the default group GUID of the user.
     * @param defaultGroupGuid The default group GUID of the user
     */
    public void setDefaultGroupGuid(String defaultGroupGuid)
    {
        this.defaultGroupGuid = defaultGroupGuid;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "UpdateUserRequest ["
            +"name="+name
            +", defaultGroupGuid="+defaultGroupGuid
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
        private UpdateUserRequest request = new UpdateUserRequest();

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
         * Sets the default group GUID of the request.
         * @param defaultGroupGuid The default group GUID of the request
         * @return This object
         */
        public Builder defaultGroupGuid(String defaultGroupGuid)
        {
            request.setDefaultGroupGuid(defaultGroupGuid);
            return this;
        }

        /**
         * Returns the configured request
         * @return The request instance
         */
        public UpdateUserRequest build()
        {
            return request;
        }
    }
}