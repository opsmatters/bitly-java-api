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
* getMetricsByCountries(bitlink, query): returns the metrics for the given bitlink and query parameters.
* getMetricsByReferrers(bitlink, query): returns the metrics for the given bitlink and query parameters.
* getMetricsByReferringDomains(bitlink, query): returns the metrics for the given bitlink and query parameters.
* getMetricsByReferrersByDomain(bitlink, query): returns the metrics for the given bitlink and query parameters.
* getQrCode(bitlink): returns the QR code for the given bitlink.

### Groups

* get(groupGuid): returns the attributes of the given group.
* update(groupGuid): updates the attributes of the given group.
* list(organizationGuid): returns the groups for the given organization.
* delete(groupGuid): deletes the given group.
* getBitlinks(groupGuid, query): returns the group and query parameters.
* getSortedBitlinks(groupGuid, sort, query): returns the group and query parameters, sorted by clicks.

<sub>Copyright (c) 2020 OpsMatters</sub>