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
* expand(id): returns the long url for a bitlink id.

<sub>Copyright (c) 2020 OpsMatters</sub>