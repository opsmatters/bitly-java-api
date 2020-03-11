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
 * Represents the attributes of a page of results.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class Pagination
{
    private int total;
    private int size;
    private String prev;
    private int page;
    private String next;

    /**
     * Default constructor.
     */
    public Pagination()
    {
    }

    /**
     * Returns the total number of pages.
     * @return The total number of pages
     */
    public int getTotal()
    {
        return total;
    }

    /**
     * Returns the page size.
     * @return The page size
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Returns the previous page.
     * @return The previous page
     */
    public String getPrev()
    {
        return prev;
    }

    /**
     * Returns the page number.
     * @return The page number
     */
    public int getPage()
    {
        return page;
    }

    /**
     * Returns the next page.
     * @return The next page
     */
    public String getNext()
    {
        return next;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "Pagination ["
            +"total="+total
            +", size="+size
            +", prev="+prev
            +", page="+page
            +", next="+next
            +"]";
    }

}