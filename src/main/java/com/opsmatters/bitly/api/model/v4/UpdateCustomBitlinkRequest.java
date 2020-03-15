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
 * Represents a request to update a custom bitlink.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class UpdateCustomBitlinkRequest
{
    @SerializedName("bitlink_id")
    private String bitlinkId;

    /**
     * Default constructor.
     */
    public UpdateCustomBitlinkRequest()
    {
    }
    
    /**
     * Returns the id of the bitlink.
     * @return The id of the bitlink
     */
    public String getBitlinkId()
    {
        return bitlinkId;
    }

    /**
     * Sets the id of the bitlink.
     * @param bitlinkId The id of the bitlink
     */
    public void setBitlinkId(String bitlinkId)
    {
        this.bitlinkId = bitlinkId;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "UpdateCustomBitlinkRequest ["
            +"bitlinkId="+bitlinkId
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
        private UpdateCustomBitlinkRequest request = new UpdateCustomBitlinkRequest();

        /**
         * Sets the bitlink id of the request.
         * @param bitlinkId The bitlink id of the request
         * @return This object
         */
        public Builder bitlinkId(String bitlinkId)
        {
            request.setBitlinkId(bitlinkId);
            return this;
        }

        /**
         * Returns the configured request
         * @return The request instance
         */
        public UpdateCustomBitlinkRequest build()
        {
            return request;
        }
    }
}