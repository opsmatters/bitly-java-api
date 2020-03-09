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

package com.opsmatters.bitly.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents an individual error in a response.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class Error
{
    private String field;
    private String message;

    @SerializedName("error_code")
    private String errorCode;

    /**
     * Default constructor.
     */
    public Error()
    {
    }

    /**
     * Returns the field for the error.
     * @return The field for the error
     */
    public String getField()
    {
        return field;
    }

    /**
     * Returns the message for the error.
     * @return The message for the error
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Returns the code for the error.
     * @return The code for the error
     */
    public String getErrorCode()
    {
        return errorCode;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "Error ["
            +"field="+field
            +", errorCode="+errorCode
            +", message="+message
            +"]";
    }

}