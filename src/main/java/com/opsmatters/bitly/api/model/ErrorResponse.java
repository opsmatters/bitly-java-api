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

import java.util.List;

/**
 * Represents an error response.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class ErrorResponse
{
    private String message;
    private String resource;
    private String description;
    private List<Error> errors;

    /**
     * Default constructor.
     */
    public ErrorResponse()
    {
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
     * Returns the resource for the error.
     * @return The resource for the error
     */
    public String getResource()
    {
        return resource;
    }

    /**
     * Returns the description for the error.
     * @return The description for the error
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Returns the list of errors.
     * @return The list of errors
     */
    public List<Error> getErrors()
    {
        return errors;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "ErrorResponse ["
            +"message="+message
            +", resource="+resource
            +", description="+description
            +", errors="+errors
            +"]";
    }

}