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

package com.opsmatters.bitly.api.services.v4;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.opsmatters.bitly.api.services.BitlyService;
import com.opsmatters.bitly.api.services.HttpContext;
import com.opsmatters.bitly.api.model.v4.ShortenResponse;
import com.opsmatters.bitly.api.model.v4.ExpandResponse;

/**
 * Provides the types of objects to be used with v4 API calls.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class BitlyV4Service extends BitlyService
{
    protected static final Type SHORTEN = new TypeToken<ShortenResponse>(){}.getType();
    protected static final Type EXPAND = new TypeToken<ExpandResponse>(){}.getType();

    /**
     * Constructor that takes a http context and API client.
     * @param accessToken The access token used to authenticate API operations
     * @param httpContext The set of HTTP operations
     */
    public BitlyV4Service(String accessToken, HttpContext httpContext)
    {
        super(accessToken, httpContext);
    }
}
