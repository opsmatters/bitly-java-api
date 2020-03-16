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
 * Represents a campaign bitlink.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class CampaignBitlink
{
    @SerializedName("bitlink_id")
    private String bitlinkId;

    @SerializedName("campaign_guid")
    private String campaignGuid;

    /**
     * Default constructor.
     */
    public CampaignBitlink()
    {
    }

    /**
     * Constructor that takes a campaign GUID and bitlink id.
     * @param campaignGuid The GUID of the campaign
     * @param bitlinkId The id of the bitlink
     */
    public CampaignBitlink(String campaignGuid, String bitlinkId)
    {
        setCampaignGuid(campaignGuid);
        setBitlinkId(bitlinkId);
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
     * Returns the GUID of the campaign.
     * @return The GUID of the campaign
     */
    public String getCampaignGuid()
    {
        return campaignGuid;
    }

    /**
     * Sets the GUID of the campaign.
     * @param campaignGuid The GUID of the campaign
     */
    public void setCampaignGuid(String campaignGuid)
    {
        this.campaignGuid = campaignGuid;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "CampaignBitlink ["
            +"bitlinkId="+bitlinkId
            +", campaignGuid="+campaignGuid
            +"]";
    }
}