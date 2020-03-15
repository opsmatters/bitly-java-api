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
 * Represents a response to get a bitlink.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class ListOrganizationsResponse
{
    private List<Organization> organizations;

    /**
     * Default constructor.
     */
    public ListOrganizationsResponse()
    {
    }

    /**
     * Returns the list of organizations.
     * @return The list of organizations
     */
    public List<Organization> getOrganizations()
    {
        return organizations;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "ListOrganizationsResponse ["
            +"organizations="+organizations
            +"]";
    }
}