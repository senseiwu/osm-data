package com.senseiwu.osmdata.poi

import com.mongodb.casbah.Imports._

/**
 * Created by tomek on 8/23/15.
 */

case class Coordinate(lat:Double, lon:Double)
case class NearQuery(loc: Coordinate, range:Int)
//case class NearQuery(loc: Coordinate, range:Int, query:String)

object common {

  def Key = "common"

  def node(lat:Double,lon:Double, obj:MongoDBObject):MongoDBObject =
    obj ++ MongoDBObject("loc" -> GeoCoords(lat,lon))

  def node(lat:Double,lon:Double, addr:MongoDBObject, obj:MongoDBObject):MongoDBObject =
    obj ++ MongoDBObject("addr" -> addr, "loc" -> GeoCoords(lat,lon))

  def osmType(name:String, subtype:String, obj:MongoDBObject):MongoDBObject = obj ++ MongoDBObject("type" -> name, "subtype" -> subtype)

  def amenityType(name:String, obj:MongoDBObject):MongoDBObject = osmType(amenity.Key, name, obj)

  def shopType(name:String, obj:MongoDBObject):MongoDBObject = osmType(shop.Key, name, obj)

  def historicType(name:String, obj:MongoDBObject):MongoDBObject = osmType(historic.Key, name, obj)

  def leisureType(name:String, obj:MongoDBObject):MongoDBObject = osmType(leisure.Key, name, obj)

  def loc(lat:String,lon:String):MongoDBObject =
    MongoDBObject("loc" ->
      MongoDBObject(
        "lat" -> lat, "lon" -> lat)
    )

  def address(number:Int, name:String, street:String, city:String, country:String, full:String):MongoDBObject =
    MongoDBObject(
      "number" -> number,
      "name" -> name,
      "street" -> street,
      "city" -> city,
      "country" -> country,
      "full" -> full
    )

  def info(web:String, imgUrl:String, desc:String):MongoDBObject =
    MongoDBObject(
      "web" -> web,
      "img" -> imgUrl,
      "desc" -> desc
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
