![opsmatters](https://i.imgur.com/VoLABc1.png)

## How to use the [Bitly V4 API](https://dev.bitly.com/v4_documentation.html)

### Initialisation

#### REST API

To obtain a client instance to carry out operations with the Bitly V4 REST API use the constructor:
```
Bitly client = new Bitly("<YOUR_ACCESS_TOKEN>");
```

### Bitlinks

To shorten a URL and create a bitlink, first instantiate the request object and then pass it to the "shorten" operation:
```
CreateBitlinkRequest request = CreateBitlinkRequest.builder().longUrl(longUrl).build();
CreateBitlinkResponse response = client.bitlinks().shorten(request).get();
String link = response.getLink();
```
Alternatively if the request is using the default domain, this can be simplified to:
```
CreateBitlinkResponse response = client.bitlinks().shorten(longUrl).get();
String link = response.getLink();
```

Other operations have also been included for bitlinks:
* create(object): creates a new bitlink.
* get(bitlink): returns the attributes of the given bitlink.
* expand(bitlink): returns a summary of the given bitlink, including the long url.
* update(bitlink, object): updates the attributes of the given bitlink using the given object.
* getClicks(bitlink, query): returns the clicks for the given bitlink and query parameters.
* getClicksSummary(bitlink, query): returns the clicks summary for the given bitlink and query parameters.
* getMetricsByCountries(bitlink, query): returns the clicks for the given bitlink and query parameters.
* getMetricsByReferrers(bitlink, query): returns the clicks for the given bitlink and query parameters.
* getMetricsByReferringDomains(bitlink, query): returns the clicks for the given bitlink and query parameters.
* getMetricsByReferrersByDomain(bitlink, query): returns the network metrics for the given bitlink and query parameters.
* getQrCode(bitlink): returns the QR code for the given bitlink.

### Custom Bitlinks

* create(object): creates a new custom bitlink.
* get(bitlink): returns the attributes of the given custom bitlink.
* update(bitlink, object): updates the attributes of the given custom bitlink using the given object.
* getMetricsByDestination(bitlink): returns the clicks for the given custom bitlink.

### Groups

* get(groupGuid): returns the attributes of the given group.
* update(groupGuid, object): updates the attributes of the given group.
* list(organizationGuid): returns the groups for the given organization.
* delete(groupGuid): deletes the given group.
* getTags(groupGuid): returns the tags for the given group.
* getShortenCounts(groupGuid, query): returns the counts of shortened links for the given group.
* getPreferences(groupGuid): returns the preferences for the given group.
* updatePreferences(groupGuid, object): updates the preferences for the given group.
* getBitlinks(groupGuid, query): returns the group and query parameters.
* getSortedBitlinks(groupGuid, sort, query): returns the group and query parameters, sorted by clicks.
* getMetricsByCountries(group, query): returns the clicks for the given group and query parameters.
* getMetricsByReferringNetworks(group): returns the clicks for the given group.

### Organizations

* get(organizationGuid): returns the attributes of the given organization.
* list(): returns the list of organizations.
* getShortenCounts(organizationGuid, query): returns the counts of shortened links for the given organization.

### Campaigns

* get(campaignGuid): returns the attributes of the given campaign.
* create(object): creates a new campaign.
* update(campaignGuid, object): updates the attributes of the given campaign.
* list(groupGuid): returns the list of campaigns for the given group.

### Campaign Channels

* get(channelGuid): returns the attributes of the given campaign channel.
* create(object): creates a new campaign channel.
* update(channelGuid, object): updates the attributes of the given campaign channel.
* list(groupGuid, campaignGuid): returns the list of campaign channels for the given group and campaign.

### Users

* get(): returns the attributes of the current authenticated user.
* update(object): updates the attributes of the current authenticated user.

### Branded Short Domains (BSDs)

* list(): returns the list of BSDs.

<sub>Copyright (c) 2020 OpsMatters</sub>