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

/**
 * Represents a referrer for a bitlink.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class Referrer
{
    private String key;
    private String value;

    /**
     * Default constructor.
     */
    public Referrer()
    {
    }

    /**
     * Returns the key for the referrer.
     * @return The key for the referrer
     */
    public String getKey()
    {
        return key;
    }

    /**
     * Returns the value for the referrer.
     * @return The value for the referrer
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "Referrer ["
            +"key="+key
            +", value="+value
            +"]";
    }

}