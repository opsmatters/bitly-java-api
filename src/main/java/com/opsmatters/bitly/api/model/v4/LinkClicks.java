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
 * Represents the link clicks for a bitlink, date or metric value.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class LinkClicks
{
    private String id;
    private String date;
    private String value;
    private int clicks;

    /**
     * Default constructor.
     */
    public LinkClicks()
    {
    }

    /**
     * Returns the bitlink for the clicks.
     * @return The bitlink for the clicks
     */
    public String getId()
    {
        return id;
    }

    /**
     * Returns the date for the clicks.
     * @return The date for the clicks
     */
    public String getDate()
    {
        return date;
    }

    /**
     * Returns the metric value for the clicks.
     * @return The metric value for the clicks
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Returns the clicks for the link.
     * @return The clicks for the link
     */
    public int getClicks()
    {
        return clicks;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "LinkClicks ["
            +"date="+date
            +", value="+value
            +", id="+id
            +", clicks="+clicks
            +"]";
    }

}