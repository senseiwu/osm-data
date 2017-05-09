package com.senseiwu.osmdata.serializer

import java.io.InputStream

import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.io.xml.StaxDriver

/**
  * Created by tomek on 5/8/17.
  */
object xstream {
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

}
