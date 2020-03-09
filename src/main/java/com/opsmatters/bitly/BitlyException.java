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

package com.opsmatters.bitly;

import com.opsmatters.bitly.api.model.ErrorResponse;

/**
 * Exception thrown when a REST API returns an error response.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class BitlyException extends RuntimeException
{
    private String method;
    private int status;
    private String reason;
    private ErrorResponse error;

    /**
     * Constructor that takes a method, status and reason.
     * @param method The HTTP method
     * @param status The HTTP status code
     * @param reason The HTTP reason phrase
     * @param error The error response
     */
    public BitlyException(String method, int status, String reason, ErrorResponse error)
    {
        this(method+" returned response "+status+" "+reason+": "+error);

        this.method = method;
        this.status = status;
        this.reason = reason;
        this.error = error;
    }

    /**
     * Constructor that takes an error message.
     * @param message The error message
     */
    public BitlyException(String message)
    {
        super(message);
    }

    /**
     * Returns the HTTP method.
     * @return The HTTP method
     */
    public String getMethod()
    {
        return method;
    }

    /**
     * Returns the HTTP status code.
     * @return The HTTP status code
     */
    public int getStatus()
    {
        return status;
    }

    /**
     * Returns the HTTP reason phrase.
     * @return The HTTP reason phrase
     */
    public String getReasonPhrase()
    {
        return reason;
    }

    /**
     * Returns the error response.
     * @return The error response
     */
    public ErrorResponse getErrorResponse()
    {
        return error;
    }
}