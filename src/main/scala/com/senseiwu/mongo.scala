package com.senseiwu

/**
 * Created by tomek on 8/16/15.
 */

import com.mongodb.casbah.Imports._

object mongo extends App {
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
  val mongoColl = MongoConnection() ("casbah_test")("test_data")
  val user1 = MongoDBObject(
    "user" -> "bwmcadams",
    "email" -> "~~brendan~~<AT>10genDOTcom")
  val user2 = MongoDBObject("user" -> "someOtherUser")
  mongoColl += user1
  mongoColl += user2
  mongoColl.find()
  // com.mongodb.casbah.MongoCursor =
  // MongoCursor{Iterator[DBObject] with 2 objects.}

  for { x <- mongoColl} yield x

  val q = MongoDBObject("user" -> "someOtherUser")
  val cursor = mongoColl.find(q)
  println("User: " + cursor.one().get("user"))
}

object query extends App {
  val mongoColl = MongoConnection() ("casbah_test")("test_data")
  mongoColl.find()
  for { x <- mongoColl} yield println(x)
}
