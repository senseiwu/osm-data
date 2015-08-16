package com.senseiwu

/**
 * Created by tomek on 8/16/15.
 */

import java.io.{FileInputStream, InputStream}
import java.util
import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.io.xml.StaxDriver
import com.thoughtworks.xstream.io.xml.{StaxDriver}


object osm {

  case class Osm(version:String, generator:String, copyright:String, attribution:String, licence:String, bounds:Bounds, nodes:util.ArrayList[Node], ways:util.ArrayList[Way], relations:util.ArrayList[Relation])
  case class Bounds(minlat:String, minlon:String, maxlat:String, maxlon:String)
  case class Node(id:String,visible:String,version:String,changeset:String,timestamp:String,user:String, uid:String,lat:String,lon:String, tags:util.ArrayList[Tag])
  case class Tag(k:String, v:String)
  case class Way(id:Int, visible:Boolean, version:Int, changeset:Int, timestamp:String, user:String, uid:Int, nds:util.ArrayList[Nd], tags:util.ArrayList[Tag])
  case class Nd(ref:String)
  case class Relation(id:Int, visible:Boolean, version:Int, changeset:Int, timestamp:String, user:String, uid:Int, members:util.ArrayList[Member], tags:util.ArrayList[Tag])
  case class Member(mtype:String, ref:Int, role:String)

  private val xstream = new XStream(new StaxDriver)
  xstream.alias("osm", classOf[Osm])
  xstream.useAttributeFor(classOf[Osm], "version")
  xstream.useAttributeFor(classOf[Osm], "generator")
  xstream.useAttributeFor(classOf[Osm], "copyright")
  xstream.useAttributeFor(classOf[Osm], "attribution")
  xstream.useAttributeFor(classOf[Osm], "licence")

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

  xstream.addImplicitCollection(classOf[Osm], "nodes")
  xstream.addImplicitCollection(classOf[Osm], "relations")
  xstream.addImplicitCollection(classOf[Osm], "ways")
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
      if(mmaxlat>maxlat && mmaxlon>maxlon) return
      if(mmaxlon <= maxlon) loop(name, mminlat,mmaxlat,mminlon+STEP,mmaxlon+STEP)
      else loop(name, mminlat+STEPINT,mmaxlat+STEP,minlat,minlat+STEP)
    }
    loop(name, minlat, minlat+STEP, minlon, minlon+STEP)
  }
}

object Applic extends App {
  osm.downloadOsm("krk", 50.05, 50.08, 19.88, 19.98)
}

class OsmUnmarshall {

}


