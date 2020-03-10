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
 * Represents the referrers for a network.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class NetworkReferrers
{
    private String network;
    private List<Referrer> referrers;

    /**
     * Default constructor.
     */
    public NetworkReferrers()
    {
    }

    /**
     * Returns the network for the referrers.
     * @return The network for the referrers
     */
    public String getNetwork()
    {
        return network;
    }

    /**
     * Returns the list of referrers.
     * @return The list of referrers
     */
    public List<Referrer> getReferrers()
    {
        return referrers;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "NetworkReferrers ["
            +"network="+network
            +", referrers="+referrers
            +"]";
    }

}