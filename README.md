![opsmatters](https://i.imgur.com/VoLABc1.png)

# Bitly Java API 
[![Build Status](https://travis-ci.org/opsmatters/bitly-java-api.svg?branch=master)](https://travis-ci.org/opsmatters/bitly-java-api)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.opsmatters/bitly-java-api/badge.svg?style=blue)](https://maven-badges.herokuapp.com/maven-central/com.opsmatters/bitly-java-api)
[![Javadocs](http://javadoc.io/badge/com.opsmatters/bitly-java-api.svg)](http://javadoc.io/doc/com.opsmatters/bitly-java-api)

Java client library to execute operations on URLs using the [Bitly V4 API](https://dev.bitly.com/v4_documentation.html).

The following Bitly APIs are currently supported:

### Bitlinks

- [x] [Shorten a Bitlink (`POST /v4/shorten`)](https://dev.bitly.com/v4/#operation/createBitlink)
- [x] [Expand a Bitlink (`POST /v4/expand`)](https://dev.bitly.com/v4/#operation/expandBitlink)
- [x] [Retrieve a Bitlink (`GET /v4/bitlink/{bitlink}`)](https://dev.bitly.com/v4/#operation/getBitlink)
- [x] [Create a Bitlink (`POST /v4/bitlinks`)](https://dev.bitly.com/v4/#operation/createFullBitlink)
- [x] [Update a Bitlink (`PATCH /v4/bitlink/{bitlink}`)](https://dev.bitly.com/v4/#operation/updateBitlink)
- [x] [Get Clicks for a Bitlink (`GET /v4/bitlink/{bitlink}/clicks`)](https://dev.bitly.com/v4/#operation/getClicksForBitlink)
- [x] [Get Clicks Summary for a Bitlink (`GET /v4/bitlink/{bitlink}/clicks/summary`)](https://dev.bitly.com/v4/#operation/getClicksSummaryForBitlink)
- [x] [Get Metrics for a Bitlink by Countries (`GET /v4/bitlinks/{bitlink}/countries`)](https://dev.bitly.com/v4/#operation/getMetricsForBitlinkByCountries)
- [x] [Get Metrics for a Bitlink by Referrers (`GET /v4/bitlinks/{bitlink}/referrers`)](https://dev.bitly.com/v4/#operation/getMetricsForBitlinkByReferrers)
- [x] [Get Metrics for a Bitlink by Referring Domains (`GET /v4/bitlinks/{bitlink}/referring_domains`)](https://dev.bitly.com/v4/#operation/getMetricsForBitlinkByReferringDomains)
- [x] [Get Metrics for a Bitlink by Referrers by Domain (`GET /v4/bitlinks/{bitlink}/referrers_by_domains`)](https://dev.bitly.com/v4/#operation/getMetricsForBitlinkByReferrersByDomains)
- [x] **PREMIUM** [Get a QR Code for a Bitlink (`GET /v4/{bitlink}/qr`)](https://dev.bitly.com/v4/#operation/getBitlinkQRCode)

### Custom Bitlinks

- [x] [Create Custom Bitlink (`POST /v4/custom_bitlinks`)](https://dev.bitly.com/v4/#operation/addCustomBitlink)
- [x] **PREMIUM** [Retrieve Custom Bitlink (`GET /v4/custom_bitlinks/{custom_bitlink}`)](https://dev.bitly.com/v4/#operation/getCustomBitlink)
- [x] **PREMIUM** [Update Custom Bitlink (`PATCH /v4/custom_bitlink/{custom_bitlink}`)](https://dev.bitly.com/v4/#operation/updateCustomBitlink)
- [x] **PREMIUM** [Get Metrics for a Custom Bitlink by Destination (`GET /v4/custom_bitlinks/{custom_bitlink}/clicks_by_destination`)](https://dev.bitly.com/v4/#operation/getCustomBitlinkMetricsByDestination)

### Groups

- [x] [Retrieve Group (`GET /v4/groups/{group_guid}`)](https://dev.bitly.com/v4/#operation/getGroup)
- [x] [Update Group (`PATCH /v4/groups/{group_guid}`)](https://dev.bitly.com/v4/#operation/updateGroup)
- [x] [Retrieve Groups (`GET /v4/groups`)](https://dev.bitly.com/v4/#operation/getGroups)
- [x] [Delete Group (`DELETE /v4/groups/{group_guid}`)](https://dev.bitly.com/v4/#operation/deleteGroup)
- [x] [Retrieve Tags by Group (`GET /v4/groups/{group_guid}/tags`)](https://dev.bitly.com/v4/#operation/getGroupTags)
- [x] [Retrieve Group Shorten Counts (`GET /v4/groups/{group_guid}/shorten_counts`)](https://dev.bitly.com/v4/#operation/getGroupShortenCounts)
- [x] [Retrieve Group Preferences (`GET /v4/groups/{group_guid}/preferences`)](https://dev.bitly.com/v4/#operation/getGroupPreferences)
- [x] [Update Group Preferences (`PATCH /v4/groups/{group_guid}/preferences`)](https://dev.bitly.com/v4/#operation/updateGroupPreferences)
- [x] [Retrieve Bitlinks by Group (`GET /v4/groups/{group_guid}/bitlinks`)](https://dev.bitly.com/v4/#operation/getBitlinksByGroup)
- [x] [Retrieve Sorted Bitlinks by Group (`GET /v4/groups/{group_guid}/bitlinks/{sort}`)](https://dev.bitly.com/v4/#operation/getSortedBitlinks)
- [x] [Get Click Metrics for a Group by Countries (`GET /v4/groups/{group_guid}/countries`)](https://dev.bitly.com/v4/#operation/getGroupMetricsByCountries)
- [x] [Get Click Metrics for a Group by Referring Networks (`GET /v4/groups/{group_guid}/referring_networks`)](https://dev.bitly.com/v4/#operation/GetGroupMetricsByReferringNetworks)

### Organizations

- [x] [Retrieve Organizations (`GET /v4/organizations`)](https://dev.bitly.com/v4/#operation/getOrganizations)
- [x] [Retrieve Organization (`GET /v4/organizations/{organization_guid}`)](https://dev.bitly.com/v4/#operation/getOrganization)
- [x] [Retrieve Organization Shorten Counts (`GET /v4/organizations/{organization_guid}/shorten_counts`)](https://dev.bitly.com/v4/#operation/getOrganizationShortenCounts)

### Campaigns

- [x] **PREMIUM** [Retrieve Campaign (`GET /v4/campaigns/{campaign_guid}`)](https://dev.bitly.com/v4/#operation/getCampaign)
- [x] **PREMIUM** [Create Campaign (`POST /v4/campaigns`)](https://dev.bitly.com/v4/#operation/createCampaign)
- [x] **PREMIUM** [Update Campaign (`PATCH /v4/campaigns/{campaign_guid}`)](https://dev.bitly.com/v4/#operation/updateCampaign)
- [x] **PREMIUM** [Retrieve Campaigns (`GET /v4/campaigns`)](https://dev.bitly.com/v4/#operation/getCampaigns)

### Campaign Channels

- [x] **PREMIUM** [Retrieve Channel (`GET /v4/channels/{channel_guid}`)](https://dev.bitly.com/v4/#operation/getChannel)
- [x] **PREMIUM** [Create Channel (`POST /v4/channels`)](https://dev.bitly.com/v4/#operation/createChannel)
- [x] **PREMIUM** [Update Channel (`PATCH /v4/channels/{channel_guid}`)](https://dev.bitly.com/v4/#operation/updateChannel)
- [x] **PREMIUM** [Retrieve Channels (`GET /v4/channels`)](https://dev.bitly.com/v4/#operation/getChannels)

### Users

- [x] [Retrieve User (`GET /v4/user`)](https://dev.bitly.com/v4/#operation/getUser)
- [x] [Update User (`PATCH /v4/user`)](https://dev.bitly.com/v4/#operation/updateUser)

### Webhooks

- [x] **PREMIUM** [Retrieve a Webhook (`GET /v4/webhooks/{webhook_guid}`)](https://dev.bitly.com/v4/#operation/getWebhook)
- [x] **PREMIUM** [Create a Webhook (`POST /v4/webhooks`)](https://dev.bitly.com/v4/#operation/createWebhook)
- [x] **PREMIUM** [Update a Webhook (`PATCH /v4/webhooks/{webhook_guid}`)](https://dev.bitly.com/v4/#operation/updateWebhook)
- [x] **PREMIUM** [Fetch all Webhooks for an Organization (`GET /v4/organizations/{organization_guid}/webhooks`)](https://dev.bitly.com/v4/#operation/getWebhooks)
- [x] **PREMIUM** [Delete a Webhook (`DELETE /v4/webhooks/{webhook_guid}`)](https://dev.bitly.com/v4/#operation/deleteWebhook)

### BSDs (Branded Short Domains)

- [x] [Retrieve BSDs (`GET /v4/bsds`)](https://dev.bitly.com/v4/#operation/getBSDs)

### OAuth Apps

- [x] [Retrieve OAuth App (`GET /v4/apps/{client_id}`)](https://dev.bitly.com/v4/#operation/getOAuthApp)

## Examples

A detailed set of examples of the usage of each of the APIs can be found on [the API site](src/main/java/com/opsmatters/bitly/api).

## Prerequisites

A Bitly account with an access token.
The user needs to generate an [Access Token](https://support.bitly.com/hc/en-us/articles/230647907-How-do-I-find-my-OAuth-access-token-) 
to provide access via the [Bitly V4 API](https://dev.bitly.com/v4_documentation.html).
The Access Token is referenced in the documentation as the parameter "YOUR_ACCESS_TOKEN".

## Installing

First clone the repository using:
```
>$ git clone https://github.com/opsmatters/bitly-java-api.git
>$ cd bitly-java-api
```

To compile the source code, run all tests, and generate all artefacts (including sources, javadoc, etc):
```
mvn package -Dbitly.access_token="<YOUR_ACCESS_TOKEN>"
```

## Running the tests

To execute the unit tests:
```
mvn clean test -Dbitly.access_token="<YOUR_ACCESS_TOKEN>"
```

The following tests are included:

* testBitlinksServices: Operations on bitlinks such as shorten and expand.

## Deployment

The build artefacts are hosted in The Maven Central Repository. 

Add the following dependency to include the artefact within your project:
```
<dependency>
  <groupId>com.opsmatters</groupId>
  <artifactId>bitly-java-api</artifactId>
  <version>1.0.2</version>
</dependency>
```

## Built With

* [HttpComponents](https://hc.apache.org/httpcomponents-client-ga/) - RESTful Web Services in Java using HttpClient and HttpCore
* [Gson](https://github.com/google/gson) - Java serialization/deserialization library
* [Guava](https://github.com/google/guava/wiki) - An open-source set of common libraries for Java
* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](http://junit.org/) - Unit testing framework

## Contributing

Please read [CONTRIBUTING.md](https://www.contributor-covenant.org/version/1/4/code-of-conduct.html) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

This project use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/opsmatters/bitly-java-api/tags). 

## Authors

* **Gerald Curley** - *Initial work* - [opsmatters](https://github.com/opsmatters)

See also the list of [contributors](https://github.com/opsmatters/bitly-java-api/contributors) who participated in this project.

## License

This project is licensed under the terms of the [Apache license 2.0](https://www.apache.org/licenses/LICENSE-2.0.html).

<sub>Copyright (c) 2020 OpsMatters</sub>