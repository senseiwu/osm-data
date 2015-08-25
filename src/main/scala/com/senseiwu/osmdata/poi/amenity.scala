package com.senseiwu.osmdata.poi

import com.mongodb.casbah.Imports._
import common.amenityType

object amenity {
  val Key = "amenity"

  // Substance
  val ValBar = "bar"
  val ValBbq = "bbq"
  val ValBiergarten = "biergarten"
  val ValCafe = "cafe"
  val ValDrinkingWater = "drinking_water"
  val ValFastFoodVal = "fast_food"
  val ValFoodCourtVal = "food_court"
  val ValIceCreamVal = "ice_cream"
  val ValPub = "pub"
  val ValRestaurant = "restaurant"

  // Transportation
  val ValBicycleParking = "bicycle_parking"
  val ValBicycleRepairStation = "bicycle_repair_station"
  val ValBicycleRental = "bicycle_rental"
  val ValBoatSharing = "boat_sharing"
  val ValBusStation = "bus_station"
  val ValCarRental = "car_rental"
  val ValCarSharing = "car_sharing"
  val ValCarWash = "car_wash"
  val ValChargingStation = "charging_station"
  val ValFerryTerminal = "ferry_terminal"
  val ValFuel = "fuel"
  val ValGritBin = "grit_bin"
  val ValMotorcycleParking = "motorcycle_parking"
  val ValParking = "parking"
  val ValParkingEntrance = "parking_entrance"
  val ValParkingSpace = "parking_space"
  val ValTaxi = "taxi"

  // Entertainment, Arts & Culture
  val ValArtsCentre = "arts_centre"
  val ValBrothel = "brothel"
  val ValCasino = "brothel"
  val ValCinema = "cinema"
  val ValCommunityCentre = "community_centre"
  val ValFountain = "fountain"
  val ValGambling = "gambling"
  val ValNightclub = "nightclub"
  val ValPlanetarium = "planetarium"
  val ValSocialCentre = "social_centre"
  val ValStripclub = "stripclub"
  val ValStudio = "studio"
  val ValSwingerclub = "swingerclub"
  val ValTheatre = "theatre"

  def base(subtype:String) = MongoDBObject("type" -> "amenity", "subtype" -> substance)
}

/**
 * Created by tomek on 8/22/15.
 */
object substance {

 /**
  * @param name=*	bar's name.
  */
  def bar(name:String) = amenityType(amenity.ValBar, MongoDBObject("name" -> name))

  /**
   * @param covered yes/no -- default is no.
   * @param fuel wood/electric/charcoal
   * @return mongodb object
   */
  def bbq(covered:String, fuel:String) = amenityType(amenity.ValBbq, MongoDBObject("name" -> "", "covered" -> covered, "fual" -> fuel))

  /**
   * Use these possible tags to expand the feature further.
   * cuisine=* - The cuisine tag is for the type of food served.
   * capacity=* - The capacity tag is for indicting the volume of people allowed.
   * brewery=* - The brewery tag is for a location name that sells beer from a brewery.
   *
   * To map further about a specific biergarten here are some examples.
   *
   * addr=* - The addr tag is the prefix for several addr:* keys to describe the address of a biergarten.
   * operator=* - The operator tag is used to name a company, corporation, person or any other entity who is in charge of the operation of a biergarten.
   * ref:vatin=* - The ref:vatin is a tag to add the VAT identification number to a biergarten. See the wikipedia page about Wikipedia VAT identification numbers.
   * opening_hours=* - The opening hours tag describes the hours when the biergarten is open or closed.
   * wikipedia=* - The wikipedia tag provides a link to Wikipedia's article about the biergarten.
   * phone=* - The phone tag is for a telephone number associated with the biergarten.
   *
   * @param name
   * @param website
   * @return
   */
  def biergarten(name:String, website:String) =
    amenityType("biergarten", MongoDBObject("name" -> name, "website" -> website))

  /**
   * Examples
   * First:
   *  amenity=cafe
   *  name=Barista
   *  cuisine=coffee_shop
   * Second:

    amenity=cafe
    name=San Marco
    cuisine=italian

Other suggested cuisine types:

    donut e.g. Dunkin' Donuts
    bagle e.g. Bagel Brothers in German
   * @param name
   * @param cuisine
   * @return
   */
  def cafe(name:String, cuisine:String) =
    amenityType("cafe", MongoDBObject("name" -> name, "cuisine" -> cuisine))

  /**
   * Possible combinations:
   * description=*
   * indoor=yes
   * name=*
   * operator=*
   * access=*
   * bottle=*
   */
  def drinking_water() = amenityType("drinking_water", MongoDBObject())

  /**
   * Examples:
   * First:
   *   amenity=fast_food
   *   name=McDonald's
   *   cuisine=burger
   *   drive_through=yes
   * Second:
   *   amenity=fast_food
   *   name=Westgate Fisheries
   *   cuisine=fish_and_chips
   *
   * @param name
   * @param operator
   * @param cuisine
   * @param diet
   * @param drive_through yes/no
   */
  def fast_food(name:String, operator:String, cuisine:String, diet:String, drive_through:String) = ???

  /**
   *
   * @param name
   * @return
   */
  def food_court(name:String) = MongoDBObject("name" -> name)

  /**
   *
   * @param name
   * @return
   */
  def ice_cream(name:String) = MongoDBObject("name" -> name)


  /**
   * Base attributes:
   * name=*
   * addr:street=*
   * addr:housenumber=*
   * addr:postcode=*
   * operator=*
   * contact:phone=*
   * phone=*
   * contact:website=*
   * website=*
   * opening_hours=*
   * cuisine=*
   * drink=*
   * brewery=*
   * smoking=yes/no
   *
   * Additional attribs:
   * food=yes - If the pub serves food, or type of food thereof
   * cuisine=<style> - type of food offered (usage as amenity=restaurant)
   * beer_garden=yes - The pub has a garden where customers can sit outside. You may wish to add an additional node describing the garden's location if you have decent imagery or GPS data
   * outdoor_seating=yes - The pub has outside seating, possibly café-style. Useful for urban situations where one can't really describe the seating as garden-like
   * old_name=* - former name of premises
   * operator=* - Operator of the pub, normally the chain or brewery concerned
   * real_ale=yes/<style> - real ale offered or type thereof
   * real_cider=yes - real cider/perry offered
   * microbrewery=yes - pub has a microbrewery on the premises
   * smoking=yes/no - whether smoking is allowed (usage as amenity=restaurant)
   * accommodation=yes/<style> - Accommodation offered, or type thereof
   * camra=yes - Listed in the CAMRA Good Beer Guide (UK only). Note that there is a Points-of-Interest file distributed by CAMRA, but the terms seem to prohibit importing this data into OpenStreetMap
   * brewery=<name>[;<name>]* - name(s) of breweries whose beer is sold here
   * @param name
   * @return
   */
  def pub(name:String) = MongoDBObject("name" -> name)

  /**
   * name=*
   * operator=*
   * cuisine=*
   * diet=*
   * opening_hours=*
   * contact:website=*
   * contact:phone=*
   * smoking=yes/no
   * drive_in=yes/no
   * organic=yes/only/no
   *
   * Examples
   * First:
   *   amenity=restaurant
   *   name=Peking Garden
   *   cuisine=chinese - see OpenGastroMap.de
   *   smoking=yes/no/separated - see OpenGastroMap.org
   *   internet_access=wlan
   *   addr:housenumber=22
   *   addr:street=Hafenstrasse
   *   addr:postcode=20000
   *   addr:city=Hamburg
   *   addr:country=DE
   * Second:
   *   amenity=restaurant
   *   name=Doyles Seafood Restaurant
   *   cuisine=fish_and_chip
   *
   * NOTE: in most cases just 'name' sometimes address
   * @return
   */
  def restaurant(name:String) = amenityType(amenity.ValRestaurant, MongoDBObject("name" -> name))
}

object transportation {
  /**
   * name=* 	Larger areas of bike parking may be named.
   * operator=* 	Cycle parking may be operated by some organisation.
   * covered=* 	Parked bikes are protected from rain.
   * access=* 	Public access is implied in most roadside cases. Some bike racks can be private to a university, company, or other organisation, possibly requiring keys or codes to access.
   * capacity=* 	The number of bikes that can be parked here.
   * fee=* 	In some places, one must pay to park one's bike. (paid is a less widespread alias for this.)
   * bicycle_parking=* 	Details the type of bicycle parking (e.g. stands, wall loops...).
   * cyclestreets_id=* 	A link to the ID (e.g. 12345) of the location describing a photo of the cycle parking in CycleStreets. Multiple IDs should be separated by semi-colons.
   * maxstay=* 	Maximum time the bicycle is allowed to be parked at that place - given sometimes at covered parking-places.
   * surveillance=* 	Closed-circuit television (CCTV) security cameras can be marked with this. See the linked page for details of the values in use. Depending on the layout, a separate node nearby may be enough.
  * */
  def bicycle_parking(capacity:Int, covered:String, access:String, fee:String, operator:String, name:String,
                     bicycle_parking:String, cyclestreets_id:Int, maxstay:Int, surveillance:String) = ???

  /**
   * service:bicycle:pump 	yes/no 	unknown 	there is an air pump with both Presta and Schrader style valves.
   * service:bicycle:chain_tool 	yes/no 	unknown 	there is a tool for repairing broken links in a bicycle chain.
   * opening_hours=* 	<value> 	24/7 	Usually 24/7 (can be different if it is indoor)
   * operator=* 	[name] 		The party responsible for maintenance (usually the property owner, but not always).
   * brand=* 	[name] 		The manufacturer of the station, if it is a standard design (e.g. "Dero" or "Bike Fixstation", or "RepairSTAN"). For a list of vendors see this guide.
   */
  def bicycle_repair_station() = ???

  /**
   * amenity=bicycle_rental 	Generic tag for a bike rental parking station.
   * name=* 	Name of the station.
   * ref=* 	Station reference.
   * capacity=* 	Number of parking spaces available.
   * network=* 	Name of the station network (Vélo'v in Lyon/France, Vélib' in Paris/France,Vélocité in Besançon, le vélo in Marseille/France, "Villo" in Brussels/Belgium, bixi in Montréal/Québec and Toronto, dublinbikes in Dublin/Ireland, Barclays Cycle Hire in London, etc.)
   * operator=* 	Name of the operating company (optional). example : JCDecaux in Paris for Vélib'
   * payment:credit_cards=* 	payment:credit_cards=yes when payement is possible with credits cards.
   */
  def bicycle_rental(name:String, network:String, operator:String, ref:String, capacity:Int) = ???

  /**
   * optional 	capacity=* 	integer 	The number of boats present. Should be used if several boats are side by side an not everyone is individually tagged.
   * mandatory 	operator=* 	string 	The boat sharing operator
   * optional 	website=* 	string 	operators website, if possible direct link to the boat description
   * optional 	name=* 	string 	the name of the boat (if there is only 1 boat)
   * optional 	boattype=* 	string 	the type of boat, e.g. manufacturer, series number etc.
   * optional 	ref=* 	integer 	The operator ref for the boat
   * optional 	number_plate=* 	string 	the official boat immatriculation number which is on the number plate - in the picture above, this will be "ZH 9733"
   */
  def boat_sharing() = ???

  /**
   * Rent a car
   *
   * operator=* 	Name of the rental network, if appropriate (e.g. "Sixt", "Europcar", "Hertz", "National", etc.).
   * name=* 	Name of the station (e.g. "Nuremberg Airport", "Timmy's car rental", etc.).
   */
  def car_rental() = ???

  /**
   * Share a car
   *
   * amenity=car_sharing 	Generic tag for a car sharing station / area.
   * operator=* 	Name of Operator (e.g. "StreetCar", "Zipcar")
   * network=* 	Network, where the operator belongs to (e.g. network=Flinkster for operator=teilAuto or operator=book-n-drive). Inside a network it is possible to use the cars from an other network member - e.g. a consumer from "book-n-drive" can use cars from "teilAuto" as the ones belonging to his own operator.
   * capacity=number 	Number of cars (for multiple cars at one location)
   * website=* 	website of car sharing operator, or their sub page about this location
   * @return
   */
  def car_sharing() = ???

  /**
   * Wash a car
   *
   * name=*
   * operator=*
   * opening_hours=*
   * self_service=yes/no
   * automated=yes/no
   * @return
   */
  def car_wash() = ???

  /**
   * Charging facility for electric vehicles
   *
   * operator=*
   * capacity=* (The number of vehicles which can be charged at the same time. The total number of sockets can be higher.)
   * ref=*
   * amperage=* (The maximum current rating.)
   * voltage=*
   * fee=yes/no (Yes if some or all customers have to pay a fee for using the station.)
   * opening_hours=*
   *
   * see: http://wiki.openstreetmap.org/wiki/Tag:amenity%3Dcharging_station
   *
   * @return
   */
  def charging_station() = ???

  /**
   * Ferry terminal/stop. A place where people/cars/etc. can board and leave a ferry.
   *
   * amenity=ferry_terminal
   * name=*
   * operator=*
   * cargo=* passengers/vehicle/passengers;vehicle
   *
   * @return
   */
  def ferry_terminal() = ???

  /**
   *  Petrol station; gas station; marine fuel; … Streets to petrol stations are often tagged highway=service.
   *
   * addr=*
   * brand=*
   * maxheight=*
   * name=*
   * opening_hours=*
   * operator=*
   * payment=*
   * tenant=*
   * phone=*
   * website=*
   *
   * fuel info: http://wiki.openstreetmap.org/wiki/Key:fuel
   *
   * @return
   */
  def fuel() = ???

  /**
   * A container that holds grit or a mixture of salt and grit.
   *
   * In some countries and/or towns the access to the content of the grit bin may be restricted. So an additional access=* may be necessary. The access my be one of:
   *
   * access=public everyone is free to use the grit / salt
   * access=permissive only a selected group is free to use; i.e. residents, local authorities
   * access=private the bin is owned by i.e. a company or a school
   *
   * @return
   */
  def grit_bin() = ???

  /**
   * Parking for motorcycles
   *
   * @name 	* 	Name of parking.
   * @operator 	* 	Operator of the parking.
   * @ref 	* 	Reference number of the parking lot if any (e.g. "P01").
   * @covered 	yes/no 	If parking if covered.
   * @access 	yes/customer/permissive/private 	Distinction between public parking lots, customers parking lots (such as at cinemas etc.), and private parking lots (such as for staff in a business park). In this case, yes denotes a public parking lot. Ambox warning pn.svg Recent addition of "customer" with disputed applicability. Discuss.
   * @capacity 	* 	The number of motorcycles that can be parked here.
   * @fee 	yes/no 	Whether you have to pay a parking fee or not. Default value is no. If the fee must be paid only on certain hours, the same syntax can be used as for opening hours (see the discussion page).
   * @parking:
   *   surface
   *   multi-storey
   *   underground
   *   sheds 	Private hangars for vehicles, located close to owner's home. Usually constructed of profiled metal.
   *   carports 	Structure used to offer limited protection to vehicles, primarily cars, from the elements (wikipedia article).
   *   garage_boxes 	One level buildings for motorcycles, usually made of brick and metal. Usually this area belong to garage cooperative with own name, chairman, budget, rules, security, etc.
   *   lane 	A parking lane next to a road. Please consider using the parking:lane scheme instead.
   * @maxstay 	2h or 2 hours 	Time limit for parking (e.g. customer parking for 2 hours) .
   *
   * @return
   */
  def motorcycle_parking() = ???

  /**
   * Car park. Nodes and areas (without access tag) will get a parking symbol. Areas will be coloured. Streets on car parking are often tagged highway=service and service=parking_aisle.
   *
   * access=*
   * capacity=*
   * fee=*
   * name=*
   * maxstay=*
   * operator=*
   *
   * @return
   */
  def parking() = ???

  /**
   * An entrance or exit to an underground or multi-storey parking facility. Group multiple parking entrances together with a relation using the tags type=site and site=parking. Do not mix with amenity=parking.
   *
   * @return
   */
  def parking_entrance() = ???

  def parking_space() = ???

  /**
   * capacity=* 	Maximum number of taxis that can wait here (rough estimation).
   * contact:phone=* 	Phone number to contact the taxi stand.
   * name=* 	Name of taxi stand.
   * operator=* 	Operator of taxi stand.
   * presence=* 	Hours and/or weekdays when you usually can expect a taxi to be present.
   *    See opening_hours=* for valid patterns.
   * motorcycle=yes 	If the stand also provides motorcycle taxis, add motorcycle=yes.
   * motorcar=no 	If the stand does not provide car taxis, then add motorcar=no.
   * @return
   */
  def taxi() = ???


}

object entertainment {
  /**
   * name=*
   * description=*
   * operator=*
   * @return
   */
  def arts_centre() = ???
  def brothel() = ???
  def casino() = ???
  def cinema() = ???
  def community_centre() = ???
  def fountain() = ???
  def gambling() = ???
  def nightclub() = ???
  def planetarium() = ???
  def social_centre() = ???
  def stripclub() = ???
  def studio() = ???
  def swingerclub() = ???
  def theatre() = ???
}

