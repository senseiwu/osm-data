package com.senseiwu.osmdata.poi

import com.mongodb.casbah.Imports._

/**
 * Created by tomek on 8/23/15.
 */
object common {

  def node(lat:Double,lon:Double, obj:MongoDBObject) =
    obj ++ MongoDBObject("loc" -> GeoCoords(lat,lon))

  def node(lat:Double,lon:Double, addr:MongoDBObject, obj:MongoDBObject) =
    obj ++ MongoDBObject("addr" -> addr, "loc" -> GeoCoords(lat,lon))

  def osmType(name:String, subtype:String, obj:MongoDBObject) =
    obj ++ MongoDBObject("type" -> name, "subtype" -> subtype)

  def amenityType(name:String, obj:MongoDBObject) =
    osmType("amenity", name, obj)

  def loc(lat:String,lon:String) =
    MongoDBObject("loc" ->
      MongoDBObject(
        "lat" -> lat, "lon" -> lat)
    )

  def address(number:Int, name:String, street:String, city:String, country:String, full:String) =
    MongoDBObject(
      "number" -> number,
      "name" -> name,
      "street" -> street,
      "city" -> city,
      "country" -> country,
      "full" -> full
    )

  def area(hamlet:String, suburb:String, subdistrict:String, district:String, province:String, state:String) =
    MongoDBObject("area" ->
      MongoDBObject(
        "hamlet" -> hamlet,
        "suburb" -> suburb,
        "subdistrict" -> subdistrict,
        "district" -> district,
        "province" -> province,
        "state" -> state)
    )
}
