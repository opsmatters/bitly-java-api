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
 * Represents the QR code for a bitlink.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class GetBitlinkQrCodeResponse
{
    private String id;
    private String link;

    @SerializedName("qr_code")
    private String qrCode;

    /**
     * Default constructor.
     */
    public GetBitlinkQrCodeResponse()
    {
    }

    /**
     * Returns the bitlink id.
     * @return The bitlink id
     */
    public String getId()
    {
        return id;
    }

    /**
     * Returns the link.
     * @return The link
     */
    public String getLink()
    {
        return link;
    }

    /**
     * Returns the QR code.
     * @return The QR code
     */
    public String getQrCode()
    {
        return qrCode;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "GetBitlinkQrCodeResponse ["
            +" id="+id
            +" link="+link
            +" qrCode="+qrCode
            +"]";
    }
}