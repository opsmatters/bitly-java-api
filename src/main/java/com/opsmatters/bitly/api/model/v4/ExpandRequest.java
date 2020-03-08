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
 * Represents a request to expand a bitlink.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class ExpandRequest
{
    @SerializedName("bitlink_id")
    private String id;

    /**
     * Default constructor.
     */
    public ExpandRequest()
    {
    }
    
    /**
     * Returns the id of the bitlink.
     * @return The id of the bitlink
     */
    public String getId()
    {
        return id;
    }

    /**
     * Sets the id of the bitlink.
     * @param id The id of the bitlink
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "ExpandRequest ["
            +"id="+id
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
        private ExpandRequest request = new ExpandRequest();

        /**
         * Sets the id of the request.
         * @param id The id of the request
         * @return This object
         */
        public Builder id(String id)
        {
            request.setId(id);
            return this;
        }

        /**
         * Returns the configured request
         * @return The request instance
         */
        public ExpandRequest build()
        {
            return request;
        }
    }
}