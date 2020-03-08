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

package com.opsmatters.bitly.api.services;

import java.util.Map;
import java.util.HashMap;
import java.util.logging.Logger;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

/**
 * Provides the types of objects to be used with the API calls.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class BitlyService
{
    private static final Logger logger = Logger.getLogger(BitlyService.class.getName());

    private String accessToken;
    protected HttpContext HTTP;

    /**
     * Constructor that takes a http context and API client.
     * @param accessToken The access token used to authenticate API operations
     * @param httpContext The set of HTTP operations
     */
    public BitlyService(String accessToken, HttpContext httpContext)
    {    
        this.accessToken = accessToken;
        this.HTTP = httpContext;
    }
    
    /**
     * Encode special character in query string to the URL encoded representation.
     * @param str The input string
     * @return The encoded String
     */
    public static String encode(String str)
    {
        String encodedValue = str;

        try
        {
            encodedValue = URLEncoder.encode(encodedValue, "UTF-8");

            // Spaces in NRQL queries expected to be encoded as "%20" instead of "+".
            encodedValue = encodedValue.replace("+", "%20");
        }
        catch(UnsupportedEncodingException e)
        {
            logger.severe("Failed to encode value: "+str);
        }

        return encodedValue;
    }

    /**
     * Returns the default headers for an OAuth request.
     * @return The encoded String
     */
    public Map<String,String> getHeaders()
    {
        Map<String,String> ret = new HashMap<String,String>();
        ret.put("Authorization", "Bearer "+accessToken);
        ret.put("Content-Type","application/json");
        return ret;
    }
}