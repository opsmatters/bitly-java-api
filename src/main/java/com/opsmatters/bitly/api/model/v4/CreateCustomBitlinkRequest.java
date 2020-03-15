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
 * Represents a request to create a custom bitlink.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class CreateCustomBitlinkRequest
{
    @SerializedName("bitlink_id")
    private String bitlinkId;

    @SerializedName("custom_bitlink")
    private String customBitlink;

    /**
     * Default constructor.
     */
    public CreateCustomBitlinkRequest()
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
     * Returns the custom bitlink for the bitlink.
     * @return The custom bitlink for the bitlink
     */
    public String getCustomBitlink()
    {
        return customBitlink;
    }

    /**
     * Sets the custom bitlink for the bitlink.
     * @param customBitlink The custom bitlink for the bitlink
     */
    public void setCustomBitlink(String customBitlink)
    {
        this.customBitlink = customBitlink;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "CreateCustomBitlinkRequest ["
            +"bitlinkId="+bitlinkId
            +", customBitlink="+customBitlink
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
        private CreateCustomBitlinkRequest request = new CreateCustomBitlinkRequest();

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
         * Sets the custom bitlink of the request.
         * @param customBitlink The custom bitlink of the request
         * @return This object
         */
        public Builder customBitlink(String customBitlink)
        {
            request.setCustomBitlink(customBitlink);
            return this;
        }

        /**
         * Returns the configured request
         * @return The request instance
         */
        public CreateCustomBitlinkRequest build()
        {
            return request;
        }
    }
}