package com.senseiwu.osmdata.poi

import com.mongodb.casbah.Imports._

/**
 * Created by tomek on 8/23/15.
 */
object common {

  def osmType(name:String) = MongoDBObject("type" -> name)
  def amenityType(name:String) = osmType("amenity") ++ MongoDBObject("subtype" -> name)

  def loc(lat:String,lon:String) =
    MongoDBObject("loc" ->
      MongoDBObject(
        "lat" -> lat, "lon" -> lat)
    )

  def address(number:Int, name:String, street:String, city:String, country:String, full:String) =
    MongoDBObject("address" ->
      MongoDBObject(
        "number" -> number,
        "name" -> name,
        "street" -> street,
        "city" -> city,
        "country" -> country,
        "full" -> full)
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
