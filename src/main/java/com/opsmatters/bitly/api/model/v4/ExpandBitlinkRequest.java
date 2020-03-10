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
public class ExpandBitlinkRequest
{
    @SerializedName("bitlink_id")
    private String bitlink;

    /**
     * Default constructor.
     */
    public ExpandBitlinkRequest()
    {
    }
    
    /**
     * Returns the bitlink.
     * @return The bitlink
     */
    public String getBitlink()
    {
        return bitlink;
    }

    /**
     * Sets the bitlink.
     * @param bitlink The bitlink
     */
    public void setBitlink(String bitlink)
    {
        this.bitlink = bitlink;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "ExpandBitlinkRequest ["
            +"bitlink="+bitlink
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
        private ExpandBitlinkRequest request = new ExpandBitlinkRequest();

        /**
         * Sets the bitlink for the request.
         * @param bitlink The bitlink for the request
         * @return This object
         */
        public Builder bitlink(String bitlink)
        {
            request.setBitlink(bitlink);
            return this;
        }

        /**
         * Returns the configured request
         * @return The request instance
         */
        public ExpandBitlinkRequest build()
        {
            return request;
        }
    }
}