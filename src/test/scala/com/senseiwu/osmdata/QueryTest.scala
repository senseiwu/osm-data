package com.senseiwu.osmdata

import com.mongodb.casbah.Imports._
import com.mongodb.util.JSON
import com.senseiwu.osmdata.poi.{amenity, common, substance}
import org.scalatest.FunSuite

/**
 * Created by tomek on 8/25/15.
 */
class QueryTest extends FunSuite {

  val mongo = Mongo(MongoClient(), "poi")
  val db = mongo.getdb
  db.dropDatabase()
  val col = mongo.collection("test")
  col.createIndex(MongoDBObject("loc" -> "2d"))

  val point1 =
    common.node(
      50.01, 19.7234,
      common.address(123, "", "Brozka", "Krakow", "Poland", ""),
      substance.bar("A"))

  val point2 =
    common.node(
      50.02, 19.7234,
      common.address(234, "", "A", "Krakow", "Poland", ""),
      substance.bbq("",""))

  val point3 =
    common.node(
      50.03, 19.7234,
      common.address(345, "", "B", "Krakow", "Poland", ""),
      substance.bar("C"))

  val point4 =
    common.node(
      50.04, 19.7234,
      common.address(567, "", "C", "Chicago", "USA", ""),
      substance.restaurant("Sun"))

  col += point1
  col += point2
  col += point3
  col += point4

  test("Check amenity type query") {
    assert(4 == col.size)
    assert(4 == mongo.findForType(col, amenity.Key).size)
    assert(2 == mongo.findForSubtype(amenity.Key, amenity.ValBar).length)
    assert(1 == mongo.findForSubtype(amenity.Key, amenity.ValRestaurant).length)
    assert(1 == mongo.findForSubtype(amenity.Key, amenity.ValBbq).length)
    assert(0 == mongo.findForSubtype(amenity.Key, amenity.ValBrothel).length)
  }

  test("Check distance search") {
    assert(1 == mongo.findNear(amenity.Key, amenity.ValBar, 50.005, 19.7234, 1000).length, "Bar not found")
    assert(0 == mongo.findNear(amenity.Key, amenity.ValBbq, 50.005, 19.7234, 1000).length, "BBQ found")
    assert(2 == mongo.findNear(amenity.Key, amenity.ValBar, 50.005, 19.7234, 4000).length, "Bar not found")
    assert(1 == mongo.findNear(amenity.Key, amenity.ValBbq, 50.005, 19.7234, 4000).length, "BBQ not found")
  }

  test("Query for city") {
    val cityKey = keys.buildKey(keys.KeyAddr, keys.KeyCity)

    assert(1 == mongo.findForKey(col, cityKey, "Chicago").size)
    assert(3 == mongo.findForKey(col, cityKey, "Krakow").size)
    assert(0 == mongo.findForKey(col, cityKey, "New York").size)
  }

  test("Check coutry name") {
    val cityKey = keys.buildKey(keys.KeyAddr, keys.KeyCity)
    val countryKey = keys.buildKey(keys.KeyAddr, keys.KeyCountry)
    val addr:BasicDBObject = mongo.findForKey(col, cityKey, "Chicago").next().get("addr").asInstanceOf[BasicDBObject]
    val cntr = addr.get("country")
    println(cntr)

    val lista = mongo.findForKey(col, cityKey, "Krakow")

//    var lstr:List[String] = List()
//    while (lista.hasNext) {
//      lstr = lista.next().get("addr").asInstanceOf[BasicDBObject].get("street").toString :: lstr
//    }
//
//    println("Streets: " + lstr)


    lazy val aa = parse(lista)
    println("Attr: " + aa)

    case class Coordinate(lat:String, lon:String)
    case class Attraction(name:String, img:String, loc:Coordinate)

    def parse(obj:MongoCursor):List[Attraction] = {

      def getItem(key:String, obj:DBObject) = {
        val value = obj.get(key)
        if (value == null) ""
        else value.toString
      }

      def getItemIx(key:Int, obj:BasicDBList) = obj.get(key).toString

      def getLoc(obj:DBObject):Coordinate = {
        val value:BasicDBList = obj.get("loc").asInstanceOf[BasicDBList]
        if(value == null) Coordinate("", "")
        else Coordinate(getItemIx(0, value), getItemIx(1, value))
      }

      var ll:List[Attraction] = List()
      while(obj.hasNext) {
        val item = obj.next()
        println("item: " + item)
        val loc:BasicDBList = item.get("loc").asInstanceOf[BasicDBList]
        val lat = loc.get(0).toString
        val lon = loc.get(1).toString
        ll = Attraction(getItem("name", item), getItem("img", item), Coordinate(lat, lon)) :: ll
      }
      ll
    }
  }

  test("s") {
    val tcol = mongo.collection("topic")
    val obj1 = MongoDBObject("topic" -> "amenity", "subtopics" -> MongoDBList("a","b","c"))
    val obj2 = MongoDBObject("topic" -> "park", "subtopics" -> MongoDBList("aa","bb","cc"))
    val obj3 = MongoDBObject("topic" -> "history", "subtopics" -> MongoDBList("aaa","bbb","ccc"))

    val list = MongoDBList(obj1, obj2, obj3)

//    tcol.insert(obj1)
//    tcol.insert(obj2)
//    tcol.insert(obj3)
    tcol.insert(MongoDBObject("topics" -> list))
    println("type " + tcol.find("topics" $exists(true)).next().getClass)
    //BasicDBObject
    val v = tcol.find("topics" $exists(true)).next()
    //tcol.foreach(println)
    JSON.serialize(v)
    //println(tcol.find("topics" $exists(true)).next().get("topics"))
    case class Topics(topics:List[(Topic, List[String])])
    case class Topic(topic:String)

//    val t = JSON.parse(tcol.find("topics" $exists(true)).next().get("topics").toString)
//
//   println(t)
    val t = tcol.find("topics" $exists true)
    println(t)
    val topics = t.next().getAs[MongoDBList]("topics")
    println(topics.get)
    topics.get.foreach(println)
    val tt = topics.get

    for(t <- tt) {
      convert(t)
    }

    def convert(obj:MongoDBObject): Unit = {
      val topic = obj.getAs[String]("topic")
      val subtop = obj.getAs[List[String]]("subtopics")
      println(topic + ", " + subtop)
    }

  }

}
