package com.senseiwu.osmdata

/**
 * Created by tomek on 8/16/15.
 */

import java.io.{FileInputStream, InputStream}
import java.util

import com.mongodb.casbah.Imports._
import com.senseiwu.osmdata.osm.Node
import com.senseiwu.osmdata.poi.{amenity, substance, common}
import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.io.xml.StaxDriver


object osm {

  case class Osm(
                  version:String,
                  generator:String,
                  copyright:String,
                  attribution:String,
                  license:String,
                  bounds:Bounds,
                  nodes:util.ArrayList[Node],
                  ways:util.ArrayList[Way],
                  relations:util.ArrayList[Relation]
                  )

  case class Bounds(
                     minlat:String,
                     minlon:String,
                     maxlat:String,
                     maxlon:String)

  case class Node(
                   id:String,
                   visible:String,
                   version:String,
                   changeset:String,
                   timestamp:String,
                   user:String,
                   uid:String,
                   lat:String,
                   lon:String,
                   tags:util.ArrayList[Tag]) {
    import scala.collection.JavaConversions._
    def asScala = NodeScala(id, visible, version, changeset, timestamp, user, uid, lat, lon, tags.toList)
  }

  case class NodeScala(
                   id:String,
                   visible:String,
                   version:String,
                   changeset:String,
                   timestamp:String,
                   user:String,
                   uid:String,
                   lat:String,
                   lon:String,
                   tags:List[Tag])

  case class Tag(
                  k:String,
                  v:String)

  case class Way(
                  id:Int,
                  visible:Boolean,
                  version:Int,
                  changeset:Int,
                  timestamp:String,
                  user:String,
                  uid:Int,
                  nds:util.ArrayList[Nd],
                  tags:util.ArrayList[Tag])

  case class Nd(
                 ref:String)

  case class Relation(
                       id:Int,
                       visible:Boolean,
                       version:Int,
                       changeset:Int,
                       timestamp:String,
                       user:String,
                       uid:Int,
                       members:util.ArrayList[Member],
                       tags:util.ArrayList[Tag])

  case class Member(
                     mtype:String,
                     ref:Int,
                     role:String)

  private val xstream = new XStream(new StaxDriver)
  xstream.alias("osm", classOf[Osm])
  xstream.useAttributeFor(classOf[Osm], "version")
  xstream.useAttributeFor(classOf[Osm], "generator")
  xstream.useAttributeFor(classOf[Osm], "copyright")
  xstream.useAttributeFor(classOf[Osm], "attribution")
  xstream.useAttributeFor(classOf[Osm], "license")

  xstream.alias("bounds", classOf[Bounds])
  xstream.useAttributeFor(classOf[Bounds], "minlat")
  xstream.useAttributeFor(classOf[Bounds], "minlon")
  xstream.useAttributeFor(classOf[Bounds], "maxlon")
  xstream.useAttributeFor(classOf[Bounds], "maxlat")

  xstream.alias("node", classOf[Node])
  xstream.useAttributeFor(classOf[Node], "id")
  xstream.useAttributeFor(classOf[Node], "visible")
  xstream.useAttributeFor(classOf[Node], "changeset")
  xstream.useAttributeFor(classOf[Node], "timestamp")
  xstream.useAttributeFor(classOf[Node], "user")
  xstream.useAttributeFor(classOf[Node], "uid")
  xstream.useAttributeFor(classOf[Node], "lat")
  xstream.useAttributeFor(classOf[Node], "lon")

  xstream.alias("tag", classOf[Tag])
  xstream.useAttributeFor(classOf[Tag], "k")
  xstream.useAttributeFor(classOf[Tag], "v")

  xstream.alias("way", classOf[Way])
  xstream.useAttributeFor(classOf[Way], "id")
  xstream.useAttributeFor(classOf[Way], "visible")
  xstream.useAttributeFor(classOf[Way], "changeset")
  xstream.useAttributeFor(classOf[Way], "timestamp")
  xstream.useAttributeFor(classOf[Way], "user")
  xstream.useAttributeFor(classOf[Way], "uid")

  xstream.alias("nd", classOf[Nd])

  // <relation id="215787" visible="true" version="1" changeset="2256316" timestamp="2009-08-25T14:15:52Z" user="Mala" uid="123700">
  //<member type="way" ref="39393949" role="inner"/>
  xstream.alias("relation", classOf[Relation])
  xstream.useAttributeFor(classOf[Relation], "id")
  xstream.useAttributeFor(classOf[Relation], "visible")
  xstream.useAttributeFor(classOf[Relation], "version")
  xstream.useAttributeFor(classOf[Relation], "changeset")
  xstream.useAttributeFor(classOf[Relation], "timestamp")
  xstream.useAttributeFor(classOf[Relation], "user")
  xstream.useAttributeFor(classOf[Relation], "uid")

  xstream.alias("member", classOf[Member])
  xstream.aliasField("type", classOf[Member], "mtype")
  xstream.useAttributeFor(classOf[Member], "mtype")
  xstream.useAttributeFor(classOf[Member], "ref")
  xstream.useAttributeFor(classOf[Member], "role")

  xstream.addImplicitCollection(classOf[Osm], "nodes", classOf[Node])
  xstream.addImplicitCollection(classOf[Osm], "relations", classOf[Relation])
  xstream.addImplicitCollection(classOf[Osm], "ways", classOf[Way])
  xstream.addImplicitCollection(classOf[Node], "tags")
  xstream.addImplicitCollection(classOf[Way], "nds")
  xstream.addImplicitCollection(classOf[Relation], "members")

  def fromXML(xmls: InputStream): Osm = {
    xstream.fromXML(xmls).asInstanceOf[Osm]
  }

  val STEP:Double = 0.01
  val STEPINT:Int = 1

  def fun2(minlat:Int,maxlat:Int,minlon:Int,maxlon:Int) = {
    def loop(mminlat:Int,mmaxlat:Int,mminlon:Int,mmaxlon:Int):Unit = {
      if(mmaxlat>maxlat && mmaxlon>maxlon) return
      println("-- osm data get ", mminlat, mmaxlat, mminlon, mmaxlon)
      if(mmaxlon <= maxlon) loop(mminlat,mmaxlat,mminlon+STEPINT,mmaxlon+STEPINT)
      else loop(mminlat+STEPINT,mmaxlat+STEPINT,minlon,minlon+STEPINT)
    }
    loop(minlat, minlat+STEPINT, minlon, minlon+STEPINT)
  }

  def downloadOsm(name:String, minlat:Double, maxlat:Double, minlon:Double, maxlon:Double):Unit = {
    import sys.process._
    def loop(name:String, mminlat:Double,mmaxlat:Double,mminlon:Double,mmaxlon:Double):Unit = {
      val namegoo = name + "LON" + mminlat+"-"+mmaxlat+"_LAT"+mminlon+"-"+mmaxlon
      "wget -O %s.osm http://api.openstreetmap.org/api/0.6/map?bbox=%s,%s,%s,%s".format(namegoo, mminlon, mminlat, mmaxlon, mmaxlat).!
      // TODO write to getdb here
      if(mmaxlat>maxlat && mmaxlon>maxlon) return
      if(mmaxlon <= maxlon) loop(name, mminlat,mmaxlat,mminlon+STEP,mmaxlon+STEP)
      else loop(name, mminlat+STEP,mmaxlat+STEP,minlon,minlon+STEP)
    }
    loop(name, minlat, minlat+STEP, minlon, minlon+STEP)
  }

  def allNodesWithTags(file:String):List[Node] = {
    import scala.collection.JavaConversions._
    val d:osm.Osm = osm.fromXML(new FileInputStream(file))
    d.nodes.toList.filter(_.tags != null)
  }

  def filterAmenityForSubtype(subtype:String, nodes:List[Node]):List[Node] = {
    import scala.collection.JavaConversions._
    for (
      node <- nodes;
      tag <- node.tags if tag.k.equals("amenity") && tag.v.equals(subtype)
      //tag2 <- node.asScala.tags if tag2.k.equals("name")
    ) yield (node)
  }

  def getSubtypeObj(subtype:String, name:String):MongoDBObject = subtype match {
    case amenity.ValBar => substance.bar(name)
  }

  def buildMongoObject(nodes:List[Node]):List[MongoDBObject] = {
    for (
      node <- nodes;
      tag1 <- node.asScala.tags if tag1.k.equals("name")
    ) yield common.node(node.asScala.lat.toDouble, node.asScala.lon.toDouble, substance.bar(tag1.v))
  }
}

object mongoStore {
  import scala.collection.JavaConversions._
  def insertBars(list:List[Node]) = {
    val bars = for (
      aa <- list;
      tt <- aa.tags;
      if tt.k.equals("amenity") && tt.v.equals("bar")
    ) yield aa
  }
}

object Applic extends App {
  import scala.collection.JavaConversions._
  val d:osm.Osm = osm.fromXML(new FileInputStream("krkLON50.05-50.059999999999995_LAT19.94000000000001-19.95000000000001.osm"))
  val filtered = d.nodes.toList.filter(_.tags != null)
  val a = for (
    f <- filtered;
    t <- f.tags;
    if t.k.equals("amenity")
  ) yield f
  println(d.nodes.size() + " >> " + filtered.size + " >> " + a.size)

  val am_bar = for (
    aa <- a;
    tt <- aa.tags
    if tt.k.equals("amenity") && tt.v.equals("bar")
  ) yield aa

  println("Bars: " + am_bar.size)

  am_bar.foreach(println)

//  def nodeTranform(n:Node):MongoDBObject =
//    common.node(
//      50.01, 19.7234,
//      common.address(123, "", "Brozka", "Krakow", "Poland", ""),
//      substance.bar("A"))
//    common.node(
//      50.01, 19.7234,
//      substance.bar("d"))
  //n.tags.find(_.k.equals("name")).get.v

//  val p1 = common.node(
//    50.01, 19.7234,
//    substance.bar("d"))

//  println(" >> " + d)


}



