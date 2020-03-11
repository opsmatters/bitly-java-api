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
 * Represents a group of bitlinks. 
 * 
 * @author Gerald Curley (opsmatters)
 */
public class GetBitlinksByGroupResponse
{
    private Pagination pagination;
    private List<Bitlink> links;

    /**
     * Default constructor.
     */
    public GetBitlinksByGroupResponse()
    {
    }

    /**
     * Returns the pagination.
     * @return The pagination
     */
    public Pagination getPagination()
    {
        return pagination;
    }

    /**
     * Returns the bitlinks.
     * @return The bitlinks
     */
    public List<Bitlink> getLinks()
    {
        return links;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "GetBitlinksByGroupResponse ["
            +super.toString()
            +" pagination="+pagination
            +" links="+links
            +"]";
    }
}