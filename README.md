# osm-data

### Note: this library hasn't beed developed for long time, and could be a little bit out of date. Anyway, basic functionality works.

### Overview
Library was created to fetch map data from OpenStreetMap server, seriazlize it to files and/or store in MongoDB.

### API

#### openstreetmap data fetching and serialization

Library includes fetching map data from OpenStreetMap data server based on API 0.6: http://wiki.openstreetmap.org/wiki/API_v0.6#Retrieving_map_data_by_bounding_box:_GET_.2Fapi.2F0.6.2Fmap

According to OSM API: ```GET /api/0.6/map?bbox=left,bottom,right,top``` where
* ```left``` is the longitude of the left (westernmost) side of the bounding box.
* ```bottom``` is the latitude of the bottom (southernmost) side of the bounding box.
* ```right``` is the longitude of the right (easternmost) side of the bounding box.
* ```top``` is the latitude of the top (northernmost) side of the bounding box.

osm-data library exposes function:
```scala
def downloadOsm(name:String, minlat:Double, maxlat:Double, minlon:Double, maxlon:Double):Unit
```
where parameters corespond to OSM API WS call. Function calls OSM and stores data to file. Because of OSM data complexity, what causes HTTP.509 response, data from OSM server are fetched in steps.

I didn't consider [Osmosis](http://wiki.openstreetmap.org/wiki/Osmosis) as it requires download planet data (~50G). Fetching data for certain region is faster and process this data is quite easy.

Depends on what type of data you need, you can use hepler functions for filter data return list of nodes.

Node defines a place like highway, road, turism, amenity etc. Example of node:
* Highway
```xml
<node id="2" visible="true" version="2" changeset="24392179" timestamp="2014-07-27T21:21:01Z" user="Władysław Komorek" uid="693154" lat="50.0526518" lon="19.9420254">
        <tag k="bus_numbers" v="614;904"/>
        <tag k="highway" v="bus_stop"/>
        <tag k="name" v="Stradom"/>
    </node>
```

* Restaurant
```xml
<node id="16" visible="true" version="4" changeset="24373456" timestamp="2014-07-26T20:12:51Z" user="Władysław Komorek" uid="693154" lat="50.0522822" lon="19.9401857">
        <tag k="addr:city" v="Kraków"/>
        <tag k="addr:country" v="PL"/>
        <tag k="addr:housenumber" v="2"/>
        <tag k="addr:street" v="Koletek"/>
        <tag k="amenity" v="restaurant"/>
        <tag k="name" v="Chlopskie Jadlo"/>
    </node>
```

#### oms data processing
* List of all nodes read from file
```scala
def allNodesWithTags(file:String):List[Node]
```

* Function filters given list of nodes for Ameniteis only
```scala
def filterAmenity(nodes:List[Node]):List[Node]
```

* Function filters given list of nodes for Ameniteis and for given type eg "Bar", "Pub", "Museum" etc
```scala
def filterAmenityForSubtype(subtype:String, nodes:List[Node]):List[Node]
```

* Function filters given list for type, subtype
```scala
def filterNodes(nodeType:String, nodeSubtype:String, nodes:List[Node]):List[Node]
```

* Build feed data for MongoDB
```scala
def buildMongoObject(nodes:List[Node]):List[MongoDBObject]
```

### TODO
1. Ubdate to latest mongo lib, it has nice features
2. sort out osm API, make it more purpose agnostic
3. To run UT internal mongodb is needed, mock this layer

### Contribution
If you are interested to contribute, just create PR or Issue or mail me. I would be happy to have someone else here.


