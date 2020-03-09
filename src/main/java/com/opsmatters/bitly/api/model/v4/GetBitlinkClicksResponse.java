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
 * Represents a response with the clicks for a bitlink.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class GetBitlinkClicksResponse
{
    private int units;
    private String unit;

    @SerializedName("unit_reference")
    private String unitReference;

    @SerializedName("link_clicks")
    private List<LinkClicks> linkClicks;

    /**
     * Default constructor.
     */
    public GetBitlinkClicksResponse()
    {
    }

    /**
     * Returns the unit of the clicks.
     * @return The unit of the clicks
     */
    public String getUnit()
    {
        return unit;
    }

    /**
     * Returns the unit reference of the clicks.
     * @return The unit reference of the clicks
     */
    public String getUnitReference()
    {
        return unitReference;
    }

    /**
     * Returns the units of the clicks.
     * @return The units of the clicks
     */
    public int getUnits()
    {
        return units;
    }

    /**
     * Returns the link clicks for the bitlink.
     * @return The link clicks for the bitlink
     */
    public List<LinkClicks> getLinkClicks()
    {
        return linkClicks;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "GetBitlinkClicksResponse ["
            +", linkClicks="+linkClicks
            +", units="+units
            +", unit="+unit
            +", unitReference="+unitReference
            +"]";
    }
}