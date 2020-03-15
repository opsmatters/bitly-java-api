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
 * Represents a response to get a list of Branded Short Domains (BSDs).
 * 
 * @author Gerald Curley (opsmatters)
 */
public class ListBsdsResponse
{
    private List<String> bsds;

    /**
     * Default constructor.
     */
    public ListBsdsResponse()
    {
    }

    /**
     * Returns the list of BSDs.
     * @return The list of BSDs
     */
    public List<String> getBsds()
    {
        return bsds;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "ListBsdsResponse ["
            +"bsds="+bsds
            +"]";
    }
}