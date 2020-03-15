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

/**
 * Represents a response to get a list of campaigns.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class ListCampaignsResponse
{
    private List<Campaign> campaigns;

    /**
     * Default constructor.
     */
    public ListCampaignsResponse()
    {
    }

    /**
     * Returns the list of campaigns.
     * @return The list of campaigns
     */
    public List<Campaign> getCampaigns()
    {
        return campaigns;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "ListCampaignsResponse ["
            +"campaigns="+campaigns
            +"]";
    }
}