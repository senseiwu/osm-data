package com.senseiwu.osmdata

/**
 * Created by tomek on 8/16/15.
 */

import com.mongodb.casbah.Imports._
import com.senseiwu.osmdata.poi.{common, substance, amenity}


object mongo {
  def conn = MongoConnection()("poi")
  def accessCollection(collection:String) = conn(collection)
  def drop = conn.dropDatabase()


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
    MongoDBObject(
      "hamlet" -> hamlet,
      "suburb" -> suburb,
      "subdistrict" -> subdistrict,
      "district" -> district,
      "province" -> province,
      "state" -> state
    )

}

object amenityTest extends App {
  mongo.drop
  val col = mongo.accessCollection("amenity")
  col.createIndex(MongoDBObject("loc" -> "2d"))
  val point1 = common.node(50.223, 19.1234, common.address(123, "", "Brozka", "Krakow", "Poland", ""), substance.bar("A"))
  val point2 = common.node(50.023, 19.1234, common.address(123, "", "Brozka", "Krakow", "Poland", ""), substance.bar("B"))
  val point3 = common.node(50.123, 19.1234, common.address(123, "", "Brozka", "Krakow", "Poland", ""), substance.bar("C"))
  val point4 = common.node(75.123, -75.1234, common.address(123, "", "Brozka", "Krakow", "Poland", ""), substance.bar("D"))
  col += point1
  col += point2
  col += point3
  col += point4
  //println("NAME: " + col.find("name" $eq "Re").mkString)
  println("LOCATION  " + col.find("loc" $near (50.023, 19.1234) $maxDistance(0.1)).limit(10).mkString)
  val cur = col.find("loc" $near (75.01, -75.15) $maxDistance(5))
  //for { x <- cur} yield println("C: " + x)
  //for { x <- col} yield println(x)
  //println(col.find(MongoDBObject("loc" -> MongoDBObject("$geometry" -> MongoDBObject("$type" -> "point", "coordinates" -> GeoCoords(50.01, 19.11))))))
}

object mongotest extends App {
  val mongoConn = MongoConnection()
  val mongoDB = mongoConn("casbah_test")("test_data")
  println(mongoDB.getName)

  val newObj = MongoDBObject("foo" -> "bar",
    "x" -> "y",
    "pie" -> 3.14,
    "spam" -> "eggs")
  mongoDB += newObj
}

object populate extends App {
  //val mongoColl = MongoConnection() ("casbah_test")("test_data")
  MongoConnection()("casbah_test").dropDatabase()
  val mongoColl = MongoConnection() ("casbah_test")("test_data")
  val user1 = MongoDBObject(
    "user" -> "bwmcadams",
    "email" -> "~~brendan~~<AT>10genDOTcom")
  val user2 = MongoDBObject("user" -> "someOtherUser")
  val u1contact = MongoDBObject("phone" -> "1234-899",
    "city" -> "Montreal")
  val user3 = MongoDBObject("user" -> "bwmcadams1",
    "email" -> "~~brendan~~<AT>10genDOTcom")
  user3.put("address", u1contact)
  mongoColl += user1
  mongoColl += user2
  mongoColl += user3
  mongoColl.find()
  // com.mongodb.casbah.MongoCursor =
  // MongoCursor{Iterator[DBObject] with 2 objects.}

  for { x <- mongoColl} yield x

  val q = MongoDBObject("user" -> "bwmcadams1")
  val cursor = mongoColl.find(q)
  println("User: " + cursor.one())
}

object query extends App {
  val mongoColl = MongoConnection() ("casbah_test")("test_data")
  mongoColl.find()
  for { x <- mongoColl} yield println(x)
}
