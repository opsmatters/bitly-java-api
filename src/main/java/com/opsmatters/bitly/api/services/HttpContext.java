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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.common.base.Optional;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.ContentType;
import com.opsmatters.bitly.BitlyException;

/**
 * Base class for HTTP operations using API calls.  
 * 
 * @author Gerald Curley (opsmatters)
 */
public class HttpContext
{
    private static final Logger logger = Logger.getLogger(HttpContext.class.getName());
    
    private String protocol;
    private String hostname;
    private int port;

    private Gson gson = new Gson();

    private static CloseableHttpClient client;
    
    /**
     * Constructor that takes a protocol, hostname and port.
     * @param protocol The protocol used to connect to the server
     * @param hostname The hostname of the server
     * @param port The port of the server
     */
    public HttpContext(String protocol, String hostname, int port)
    {
        this.protocol = protocol;
        this.hostname = hostname;
        this.port = port;

        if(client == null)
            client = HttpClients.custom().setConnectionManager(new PoolingHttpClientConnectionManager()).build();
    }
    
    /**
     * Build the URL from the protocol://hostname:port + relativePath
     * @param relativePath The path of the resource (should always start with a "/")
     * @return The URL to call
     */
    String buildUrl(String relativePath)
    {
        return String.format("%s://%s:%d%s", protocol, hostname, port, relativePath);
    }
    
    /**
     * Build the URI from the protocol://hostname:port + relativePath.
     * @param relativePath The path of the resource (should always start with a "/")
     * @return The URI to call
     */
    URI buildUri(String relativePath)
    {    
        URI uri = null;
        
        try
        {    
            uri = new URI(buildUrl(relativePath));   
        }
        catch(URISyntaxException e)
        {           
            logger.severe("Problem constructing URI: "+e.getClass().getName()+e.getMessage());
        }

        return uri;
    }
    
    /**
     * Execute a GET call against the partial URL and deserialize the results.
     * @param <T> The type parameter used for the return object
     * @param partialUrl The partial URL to build
     * @param returnType The expected return type
     * @return The return type
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public <T> Optional<T> GET(String partialUrl, Type returnType) throws IOException, URISyntaxException
    {    
        URI uri = buildUri(partialUrl);   
        return executeGetRequest(uri, returnType);
    }

    /**
     * Execute a GET call against the partial URL and deserialize the results.
     * @param <T> The type parameter used for the return object
     * @param partialUrl The partial URL to build
     * @param returnType The expected return type
     * @param headers A set of headers to add to the request
     * @param queryParams A set of query parameters to add to the request
     * @return The return type
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public <T> Optional<T> GET(String partialUrl, Map<String,String> headers, List<String> queryParams, Type returnType)
        throws IOException, URISyntaxException
    {
        URI uri = buildUri(partialUrl);
        return executeGetRequest(uri, headers, queryParams, returnType);
    }

    /**
     * Execute a POST call against the partial URL.
     * @param partialUrl The partial URL to build
     * @param payload The object to use for the POST
     * @return The response to the POST
     * @throws IOException if there is a communication error.
     */
    public Optional<HttpResponse> POST(String partialUrl, Object payload) throws IOException
    {    
        URI uri = buildUri(partialUrl);   
        return executePostRequest(uri, payload);
    }

    /**
     * Execute a POST call against the partial URL.
     * @param partialUrl The partial URL to build
     * @param payload The object to use for the POST
     * @param headers A set of headers to add to the request
     * @return The response to the POST
     * @throws IOException if there is a communication error.
     */
    public Optional<HttpResponse> POST(String partialUrl, Object payload, Map<String,String> headers) throws IOException
    {
        URI uri = buildUri(partialUrl);
        return executePostRequest(uri, payload, headers);
    }

    /**
     * Execute a POST call against the partial URL.
     * @param <T> The type parameter used for the return object
     * @param partialUrl The partial URL to build
     * @param payload The object to use for the POST
     * @param returnType The expected return type
     * @return The return type
     * @throws IOException if there is a communication error.
     */
    public <T> Optional<T> POST(String partialUrl, Object payload, Type returnType) throws IOException
    {
        URI uri = buildUri(partialUrl);
        return executePostRequest(uri, payload, returnType);
    }

    /**
     * Execute a POST call against the partial URL.
     * @param <T> The type parameter used for the return object
     * @param partialUrl The partial URL to build
     * @param payload The object to use for the POST
     * @param headers A set of headers to add to the request
     * @param returnType The expected return type
     * @return The return type
     * @throws IOException if there is a communication error.
     */
    public <T> Optional<T> POST(String partialUrl, Object payload, Map<String,String> headers, Type returnType) throws IOException
    {
        URI uri = buildUri(partialUrl);
        return executePostRequest(uri, payload, headers, returnType);
    }

    /**
     * Execute a PATCH call against the partial URL.
     * @param partialUrl The partial URL to build
     * @param payload The object to use for the PATCH
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public void PATCH(String partialUrl, Object payload) throws IOException, URISyntaxException
    {
        URI uri = buildUri(partialUrl);   
        executePatchRequest(uri, payload);
    }

    /**
     * Execute a PATCH call against the partial URL.
     * @param partialUrl The partial URL to build
     * @param payload The object to use for the PATCH
     * @param headers A set of headers to add to the request
     * @param queryParams A set of query parameters to add to the request
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public void PATCH(String partialUrl, Object payload, Map<String,String> headers, List<String> queryParams)
        throws IOException, URISyntaxException
    {
        URI uri = buildUri(partialUrl);
        executePatchRequest(uri, payload, headers, queryParams);
    }

    /**
     * Execute a PATCH call against the partial URL.
     * @param <T> The type parameter used for the return object
     * @param partialUrl The partial URL to build
     * @param payload The object to use for the PATCH
     * @param returnType The expected return type
     * @return The return type
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public <T> Optional<T> PATCH(String partialUrl, Object payload, Type returnType)
        throws IOException, URISyntaxException
    {
        URI uri = buildUri(partialUrl);   
        return executePatchRequest(uri, payload, null, null, returnType);
    }

    /**
     * Execute a PATCH call against the partial URL.
     * @param <T> The type parameter used for the return object
     * @param partialUrl The partial URL to build
     * @param payload The object to use for the PATCH
     * @param headers A set of headers to add to the request
     * @param queryParams A set of query parameters to add to the request
     * @param returnType The expected return type
     * @return The return type
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public <T> Optional<T> PATCH(String partialUrl, Object payload, Map<String,String> headers,
        List<String> queryParams, Type returnType)
        throws IOException, URISyntaxException
    {
        URI uri = buildUri(partialUrl);
        return executePatchRequest(uri, payload, headers, queryParams, returnType);
    }

    /**
     * Execute a DELETE call against the partial URL.
     * @param partialUrl The partial URL to build
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public void DELETE(String partialUrl) throws IOException, URISyntaxException
    {    
        URI uri = buildUri(partialUrl);   
        executeDeleteRequest(uri);
    }

    /**
     * Execute a DELETE call against the partial URL.
     * @param partialUrl The partial URL to build
     * @param headers A set of headers to add to the request
     * @param queryParams A set of query parameters to add to the request
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    public void DELETE(String partialUrl, Map<String,String> headers, List<String> queryParams)
        throws IOException, URISyntaxException
    {
        URI uri = buildUri(partialUrl);
        executeDeleteRequest(uri, headers, queryParams);
    }

    /**
     * Execute a GET request and return the result.
     * @param <T> The type parameter used for the return object
     * @param uri The URI to call
     * @param returnType The type to marshall the result back into
     * @return The return type
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    protected <T> Optional<T> executeGetRequest(URI uri, Type returnType) throws IOException, URISyntaxException
    {
        return executeGetRequest(uri, null, null, returnType);
    }

    /**
     * Execute a GET request and return the result.
     * @param <T> The type parameter used for the return object
     * @param uri The URI to call
     * @param returnType The type to marshall the result back into
     * @param headers A set of headers to add to the request
     * @param queryParams A set of query parameters to add to the request
     * @return The return type
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    protected <T> Optional<T> executeGetRequest(URI uri, Map<String,String> headers, List<String> queryParams, Type returnType)
        throws IOException, URISyntaxException
    {
        URIBuilder builder = new URIBuilder(uri);
        builder = applyQueryParams(builder, queryParams);
        HttpGet request = new HttpGet(builder.build());
        applyHeaders(request, headers);
        HttpResponse response = client.execute(request);
        handleResponseError("GET", uri, response);
        logResponse(uri, response);
        return extractEntityFromResponse(response, returnType);
    }

    /**
     * Execute a POST request.
     * @param uri The URI to call
     * @param obj The object to use for the POST
     * @return The response to the POST
     * @throws IOException if there is a communication error.
     */
    protected Optional<HttpResponse> executePostRequest(URI uri, Object obj) throws IOException
    {    
        return executePostRequest(uri, obj, (Map<String,String>)null);
    }

    /**
     * Execute a POST request.
     * @param uri The URI to call
     * @param obj The object to use for the POST
     * @param headers A set of headers to add to the request
     * @return The response to the POST
     * @throws IOException if there is a communication error.
     */
    protected Optional<HttpResponse> executePostRequest(URI uri, Object obj, Map<String,String> headers) throws IOException
    {
        HttpPost request = new HttpPost(uri);
        applyHeaders(request, headers);
        request.setEntity(new StringEntity(gson.toJson(obj), ContentType.APPLICATION_JSON));
        HttpResponse response = client.execute(request);
        handleResponseError("POST", uri, response);
        logResponse(uri, response);
        return Optional.of(response);
    }

    /**
     * Execute a POST request with a return object.
     * @param <T> The type parameter used for the return object
     * @param uri The URI to call
     * @param obj The object to use for the POST
     * @param returnType The type to marshall the result back into
     * @return The return type
     * @throws IOException if there is a communication error.
     */
    protected <T> Optional<T> executePostRequest(URI uri, Object obj, Type returnType) throws IOException
    {
        return executePostRequest(uri, obj, null, returnType);
    }

    /**
     * Execute a POST request with a return object.
     * @param <T> The type parameter used for the return object
     * @param uri The URI to call
     * @param obj The object to use for the POST
     * @param headers A set of headers to add to the request
     * @param returnType The type to marshall the result back into
     * @return The return type
     * @throws IOException if there is a communication error.
     */
    protected <T> Optional<T> executePostRequest(URI uri, Object obj, Map<String,String> headers, Type returnType)
        throws IOException
    {
        HttpPost request = new HttpPost(uri);
        applyHeaders(request, headers);
        request.setEntity(new StringEntity(gson.toJson(obj), ContentType.APPLICATION_JSON));
        HttpResponse response = client.execute(request);
        handleResponseError("POST", uri, response);
        logResponse(uri, response);
        return extractEntityFromResponse(response, returnType);
    }

    /**
     * Execute a PATCH request.
     * @param uri The URI to call
     * @param obj The object to use for the PATCH
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    protected void executePatchRequest(URI uri, Object obj) throws IOException, URISyntaxException
    {
        executePatchRequest(uri, obj, null, null);
    }

    /**
     * Execute a PATCH request.
     * @param uri The URI to call
     * @param obj The object to use for the PATCH
     * @param headers A set of headers to add to the request
     * @param queryParams A set of query parameters to add to the request
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    protected void executePatchRequest(URI uri, Object obj, Map<String,String> headers, List<String> queryParams)
        throws IOException, URISyntaxException
    {
        URIBuilder builder = new URIBuilder(uri);
        builder = applyQueryParams(builder, queryParams);
        HttpPatch request = new HttpPatch(builder.build());
        applyHeaders(request, headers);
        request.setEntity(new StringEntity(gson.toJson(obj), ContentType.APPLICATION_JSON));
        HttpResponse response = client.execute(request);
        handleResponseError("PATCH", uri, response);
        logResponse(uri, response);
    }

    /**
     * Execute a PATCH request with a return object.
     * @param <T> The type parameter used for the return object
     * @param uri The URI to call
     * @param obj The object to use for the PATCH
     * @param headers A set of headers to add to the request
     * @param queryParams A set of query parameters to add to the request
     * @param returnType The type to marshall the result back into
     * @return The return type
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    protected <T> Optional<T> executePatchRequest(URI uri, Object obj, Map<String,String> headers, 
        List<String> queryParams, Type returnType)
        throws IOException, URISyntaxException
    {
        URIBuilder builder = new URIBuilder(uri);
        builder = applyQueryParams(builder, queryParams);
        HttpPatch request = new HttpPatch(builder.build());
        applyHeaders(request, headers);
        request.setEntity(new StringEntity(gson.toJson(obj), ContentType.APPLICATION_JSON));
        HttpResponse response = client.execute(request);
        handleResponseError("PATCH", uri, response);
        logResponse(uri, response);
        return extractEntityFromResponse(response, returnType);
    }

    /**
     * Execute a DELETE request.
     * @param uri The URI to call
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    protected void executeDeleteRequest(URI uri) throws IOException, URISyntaxException
    {
        executeDeleteRequest(uri, null, null);
    }

    /**
     * Execute a DELETE request.
     * @param uri The URI to call
     * @param headers A set of headers to add to the request
     * @param queryParams A set of query parameters to add to the request
     * @throws IOException if there is a communication error.
     * @throws URISyntaxException if there is a format error in the URL.
     */
    protected void executeDeleteRequest(URI uri, Map<String,String> headers, List<String> queryParams)
        throws IOException, URISyntaxException
    {
        URIBuilder builder = new URIBuilder(uri);
        builder = applyQueryParams(builder, queryParams);
        HttpDelete request = new HttpDelete(builder.build());
        applyHeaders(request, headers);
        HttpResponse response = client.execute(request);
        handleResponseError("DELETE", uri, response);
        logResponse(uri, response);
    }

    /**
     * Extract the entity from the HTTP response.
     * @param <T> The type parameter used for the return object
     * @param response The HTTP response to extract the entity from
     * @param returnType The type to marshall the result back into
     * @return The extracted entity
     * @throws IOException if there is a communication error.
     */
    private <T> Optional<T> extractEntityFromResponse(HttpResponse response, Type returnType) throws IOException
    {
        int statusCode = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        if(entity != null && (statusCode == 200 || statusCode == 201))
            return Optional.of(readEntity(entity, returnType));
        return Optional.absent();
    }

    /**
     * Add the given set of headers to the message.
     * @param message The message to add the headers to
     * @param headers The headers to add
     */
    private void applyHeaders(HttpMessage message, Map<String,String> headers)
    {
        if(headers != null)
        {
            for (Map.Entry<String,String> e : headers.entrySet())
            {
                message.setHeader(e.getKey(), e.getValue());
            }
        }
    }

    /**
     * Add the given set of query parameters to the given URI.
     * @param builder The URI builder to add the parameters to
     * @param queryParams The query parameters to add
     * @return The updated builder
     */
    private URIBuilder applyQueryParams(URIBuilder builder, List<String> queryParams)
    {
        if(queryParams != null)
        {
            for(int i = 0; i < queryParams.size(); i += 2)
                builder = builder.setParameter(queryParams.get(i), queryParams.get(i+1));
        }

        return builder;
    }

    /**
     * Log a HTTP error response.
     * @param uri The URI used for the HTTP call
     * @param response The HTTP call response
     */
    private void logResponse(URI uri, HttpResponse response)
    {
        if(logger.isLoggable(Level.FINE))
            logger.fine(uri.toString()+" => "+response.getStatusLine());
        if(response.getStatusLine().getStatusCode() > 300)
            logger.warning(response.toString());
    }

    /**
     * Handle HTTP error responses if {@link #throwExceptions() throwExceptions} returns <CODE>true</CODE>.
     * @param method The HTTP method type
     * @param uri The URI used for the HTTP call
     * @param response The HTTP call response
     */
    private void handleResponseError(String method, URI uri, HttpResponse response) throws IOException
    {
        int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode != 200 && statusCode != 201 && statusCode != 204)
        {
            throw new BitlyException(method, statusCode, 
                response.getStatusLine().getReasonPhrase());
        }
    }

    /**
     * Marshalls the given HTTP response message into an object of the given type.
     * @param entity The entity to be ready
     * @param returnType The type to marshall the result back into
     * @param response The result object
     */
    private <T> T readEntity(HttpEntity entity, Type type) throws IOException
    {
        T ret;
        InputStream is = null;
        try
        {
            is = entity.getContent();
            ret = gson.fromJson(new InputStreamReader(is, "UTF-8"), type);
        }
        finally
        {
            if(is != null)
                is.close();
        }

        return ret;
    }
}
