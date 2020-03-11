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
import com.google.gson.annotations.SerializedName;

/**
 * Represents a query based on bitlinks.
 * 
 * @author Gerald Curley (opsmatters)
 */
public class BitlinkQuery
{
    private int size = 50;
    private int page = 1;
    private String keyword;
    private String query;
    private Switch archived = Switch.OFF;
    private Switch deeplinks = Switch.BOTH;
    private List<String> tags;

    @SerializedName("created_before")
    private int createdBefore;

    @SerializedName("created_after")
    private int createdAfter;

    @SerializedName("modified_after")
    private int modifiedAfter;

    @SerializedName("domain_deeplinks")
    private Switch domainDeeplinks = Switch.BOTH;

    @SerializedName("custom_bitlink")
    private Switch customBitlink = Switch.BOTH;

    @SerializedName("campaign_guid")
    private String campaignGuid;

    @SerializedName("channel_guid")
    private String channelGuid;

    @SerializedName("encoding_login")
    private List<String> encodingLogin;

    /**
     * Default constructor.
     */
    public BitlinkQuery()
    {
    }

    /**
     * Returns the quantity of items to be returned.
     * @return The size for the query
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Sets the quantity of items to be returned. Defaults to 50.
     * @param size The size for the query
     */
    public void setSize(int size)
    {
        this.size = size;
    }

    /**
     * Returns the start page.
     * @return The start page
     */
    public int getPage()
    {
        return page;
    }

    /**
     * Sets the start page. Defaults to 1.
     * @param page The page for the query
     */
    public void setPage(int page)
    {
        this.page = page;
    }

    /**
     * Returns the custom keyword to filter on history entries.
     * @return The custom keyword
     */
    public String getKeyword()
    {
        return keyword;
    }

    /**
     * Sets the custom keyword to filter on history entries.
     * @param keyword The custom keyword
     */
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    /**
     * Returns the value that you would like to search.
     * @return The search query
     */
    public String getQuery()
    {
        return query;
    }

    /**
     * Sets the value that you would like to search.
     * @param query The search query
     */
    public void setQuery(String query)
    {
        this.query = query;
    }

    /**
     * Returns the timestamp as an integer unix epoch.
     * @return The timestamp
     */
    public int getCreatedBefore()
    {
        return createdBefore;
    }

    /**
     * Sets the timestamp as an integer unix epoch.
     * @param createdBefore The timestamp
     */
    public void setCreatedBefore(int createdBefore)
    {
        this.createdBefore = createdBefore;
    }

    /**
     * Returns the timestamp as an integer unix epoch.
     * @return The timestamp
     */
    public int getCreatedAfter()
    {
        return createdAfter;
    }

    /**
     * Sets the timestamp as an integer unix epoch.
     * @param createdAfter The timestamp
     */
    public void setCreatedAfter(int createdAfter)
    {
        this.createdAfter = createdAfter;
    }

    /**
     * Returns the timestamp as an integer unix epoch.
     * @return The timestamp
     */
    public int getModifiedAfter()
    {
        return modifiedAfter;
    }

    /**
     * Sets the timestamp as an integer unix epoch.
     * @param modifiedAfter The timestamp
     */
    public void setModifiedAfter(int modifiedAfter)
    {
        this.modifiedAfter = modifiedAfter;
    }

    /**
     * Returns whether or not to include archived bitlinks.
     * @return Whether or not to include archived bitlinks
     */
    public Switch getArchived()
    {
        return archived;
    }

    /**
     * Sets whether or not to include archived bitlinks.
     * @param archived whether or not to include archived bitlinks
     */
    public void setArchived(Switch archived)
    {
        this.archived = archived;
    }

    /**
     * Returns whether to filter to only bitlinks that contain deeplinks.
     * @return Whether to filter to only bitlinks that contain deeplinks
     */
    public Switch getDeeplinks()
    {
        return deeplinks;
    }

    /**
     * Sets whether to filter to only bitlinks that contain deeplinks.
     * @param deeplinks whether to filter to only bitlinks that contain deeplinks
     */
    public void setDeeplinks(Switch deeplinks)
    {
        this.deeplinks = deeplinks;
    }

    /**
     * Returns whether to filter to only bitlinks that contain deeplinks configured with a custom domain.
     * @return Whether to filter to only bitlinks that contain deeplinks configured with a custom domain
     */
    public Switch getDomainDeeplinks()
    {
        return domainDeeplinks;
    }

    /**
     * Sets whether to filter to only bitlinks that contain deeplinks configured with a custom domain.
     * @param domainDeeplinks whether to filter to only bitlinks that contain deeplinks configured with a custom domain
     */
    public void setDomainDeeplinks(Switch domainDeeplinks)
    {
        this.domainDeeplinks = domainDeeplinks;
    }

    /**
     * Returns whether to filter to only bitlinks that are custom bitlinks.
     * @return Whether to filter to only bitlinks that are custom bitlinks
     */
    public Switch getCustomBitlink()
    {
        return customBitlink;
    }

    /**
     * Sets whether to filter to only bitlinks that are custom bitlinks.
     * @param customBitlink whether to filter to only bitlinks that are custom bitlinks
     */
    public void setCustomBitlink(Switch customBitlink)
    {
        this.customBitlink = customBitlink;
    }

    /**
     * Returns filter to return only links for the given campaign GUID.
     * @return Filter to return only links for the given campaign GUID
     */
    public String getCampaignGuid()
    {
        return campaignGuid;
    }

    /**
     * Sets filter to return only links for the given campaign GUID.
     * @param campaignGuid Filter to return only links for the given campaign GUID
     */
    public void setCampaignGuid(String campaignGuid)
    {
        this.campaignGuid = campaignGuid;
    }

    /**
     * Returns filter to return only links for the given channel GUID, overrides all other parameters.
     * @return Filter to return only links for the given channel GUID
     */
    public String getChannelGuid()
    {
        return channelGuid;
    }

    /**
     * Sets filter to return only links for the given channel GUID, overrides all other parameters.
     * @param channelGuid Filter to return only links for the given channel GUID
     */
    public void setChannelGuid(String channelGuid)
    {
        this.channelGuid = channelGuid;
    }

    /**
     * Returns filter on the bitlink tags.
     * @return Filter on the bitlink tags
     */
    public List<String> getTags()
    {
        return tags;
    }

    /**
     * Sets filter on the bitlink tags.
     * @param tags Filter on the bitlink tags
     */
    public void setTags(List<String> tags)
    {
        this.tags = tags;
    }

    /**
     * Returns filter by the login of the authenticated user that created the bitlink.
     * @return Filter by the login of the authenticated user that created the bitlink
     */
    public List<String> getEncodingLogin()
    {
        return encodingLogin;
    }

    /**
     * Sets filter by the login of the authenticated user that created the bitlink.
     * @param encodingLogin Filter by the login of the authenticated user that created the bitlink
     */
    public void setEncodingLogin(List<String> encodingLogin)
    {
        this.encodingLogin = encodingLogin;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "BitlinkQuery ["
            +"size="+size
            +", page="+page
            +", keyword="+keyword
            +", query="+query
            +", createdBefore="+createdBefore
            +", createdAfter="+createdAfter
            +", modifiedAfter="+modifiedAfter
            +", archived="+archived
            +", deeplinks="+deeplinks
            +", domainDeeplinks="+domainDeeplinks
            +", customBitlink="+customBitlink
            +", campaignGuid="+campaignGuid
            +", channelGuid="+channelGuid
            +", tags="+tags
            +", encodingLogin="+encodingLogin
            +"]";
    }

    /**
     * Returns a builder for the query.
     * @return The builder instance.
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to make query construction easier.
     */
    public static class Builder
    {
        private BitlinkQuery query = new BitlinkQuery();

        /**
         * Sets the size for the query.
         * @param size The size for the query
         * @return This object
         */
        public Builder size(int size)
        {
            query.setSize(size);
            return this;
        }

        /**
         * Sets the start page for the query.
         * @param page The start page for the query
         * @return This object
         */
        public Builder page(int page)
        {
            query.setPage(page);
            return this;
        }

        /**
         * Sets the custom keyword for the query.
         * @param keyword The custom keyword for the query
         * @return This object
         */
        public Builder keyword(String keyword)
        {
            query.setKeyword(keyword);
            return this;
        }

        /**
         * Sets the search value for the query.
         * @param value The search value for the query
         * @return This object
         */
        public Builder query(String value)
        {
            query.setQuery(value);
            return this;
        }

        /**
         * Sets the timestamp as an integer unix epoch.
         * @param createdBefore The timestamp
         * @return This object
         */
        public Builder createdBefore(int createdBefore)
        {
            query.setCreatedBefore(createdBefore);
            return this;
        }

        /**
         * Sets the timestamp as an integer unix epoch.
         * @param createdAfter The timestamp
         * @return This object
         */
        public Builder createdAfter(int createdAfter)
        {
            query.setCreatedAfter(createdAfter);
            return this;
        }

        /**
         * Sets the timestamp as an integer unix epoch.
         * @param modifiedAfter The timestamp
         * @return This object
         */
        public Builder modifiedAfter(int modifiedAfter)
        {
            query.setModifiedAfter(modifiedAfter);
            return this;
        }

        /**
         * Sets whether or not to include archived bitlinks.
         * @param archived whether or not to include archived bitlinks
         * @return This object
         */
        public Builder archived(Switch archived)
        {
            query.setArchived(archived);
            return this;
        }

        /**
         * Sets whether to filter to only bitlinks that contain deeplinks.
         * @param deeplinks whether to filter to only bitlinks that contain deeplinks
         * @return This object
         */
        public Builder deeplinks(Switch deeplinks)
        {
            query.setDeeplinks(deeplinks);
            return this;
        }

        /**
         * Sets whether to filter to only bitlinks that contain deeplinks configured with a custom domain.
         * @param domainDeeplinks whether to filter to only bitlinks that contain deeplinks configured with a custom domain
         * @return This object
         */
        public Builder domainDeeplinks(Switch domainDeeplinks)
        {
            query.setDomainDeeplinks(domainDeeplinks);
            return this;
        }

        /**
         * Sets whether to filter to only bitlinks that are custom bitlinks.
         * @param customBitlink whether to filter to only bitlinks that are custom bitlinks
         * @return This object
         */
        public Builder customBitlink(Switch customBitlink)
        {
            query.setCustomBitlink(customBitlink);
            return this;
        }

        /**
         * Sets filter to return only links for the given campaign GUID.
         * @param campaignGuid filter to return only links for the given campaign GUID
         * @return This object
         */
        public Builder campaignGuid(String campaignGuid)
        {
            query.setCampaignGuid(campaignGuid);
            return this;
        }

        /**
         * Sets filter to return only links for the given channel GUID, overrides all other parameters.
         * @param channelGuid filter to return only links for the given channel GUID
         * @return This object
         */
        public Builder channelGuid(String channelGuid)
        {
            query.setChannelGuid(channelGuid);
            return this;
        }

        /**
         * Sets filter on the bitlink tags.
         * @param tags filter on the bitlink tags
         * @return This object
         */
        public Builder tags(List<String> tags)
        {
            query.setTags(tags);
            return this;
        }

        /**
         * Sets filter by the login of the authenticated user that created the bitlink.
         * @param encodingLogin filter by the login of the authenticated user that created the bitlink
         * @return This object
         */
        public Builder encodingLogin(List<String> encodingLogin)
        {
            query.setEncodingLogin(encodingLogin);
            return this;
        }

        /**
         * Returns the configured query
         * @return The query instance
         */
        public BitlinkQuery build()
        {
            return query;
        }
    }
}