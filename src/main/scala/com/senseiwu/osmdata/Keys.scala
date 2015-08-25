package com.senseiwu.osmdata

/**
 * Created by tomek on 8/17/15.
 */
case class Addr(housenumber:String, housename:String, street:String, place:String, postcode:String,
                 flats:Int, city:String, country:String, full:String)

object keys {
  val KeyAddr = "addr"
  val KeyCity = "city"
  val KeyStreet = "street"
  val KeyCountry = "country"

  def buildKey(keys:String*):String = keys.filter(_.nonEmpty) mkString "."
}
