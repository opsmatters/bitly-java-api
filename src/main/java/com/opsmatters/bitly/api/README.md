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
ShortenRequest request = ShortenRequest.builder().longUrl(longUrl).build();
ShortenResponse response = client.bitlinks().shorten(request).get();
String link = response.getLink();
```
Alternatively if the request is using the default domain, this can be simplified to:
```
ShortenResponse response = client.bitlinks().shorten(longUrl).get();
String link = response.getLink();
```

Other operations have also been included for bitlinks:
* get(bitlink): returns the attributes of the given bitlink.
* create(object): creates a new bitlink.
* expand(bitlink): returns the long url for the given bitlink.
* update(bitlink, object): updates the attributes of the given bitlink.
* getClicks(bitlink, units, unit, unitReference, size): returns the clicks for the given bitlink.
* getClicksSummary(bitlink, units, unit, unitReference, size): returns the clicks summary for the given bitlink.
* getMetricsByCountries(bitlink, units, unit, unitReference, size): returns the metrics for the given bitlink.
* getMetricsByReferrers(bitlink, units, unit, unitReference, size): returns the metrics for the given bitlink.
* getMetricsByReferringDomains(bitlink, units, unit, unitReference, size): returns the metrics for the given bitlink.
* getMetricsByReferrersByDomain(bitlink, units, unit, unitReference, size): returns the metrics for the given bitlink.
* getQrCode(bitlink): returns the QR code for the given bitlink.

<sub>Copyright (c) 2020 OpsMatters</sub>