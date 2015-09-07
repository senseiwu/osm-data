package com.senseiwu.osmdata.poi

import com.mongodb.casbah.Imports._

/**
 * Created by tomek on 8/29/15.
 */
object historic {
  val Key = "historic"

  val ValMuseum = "museum"
  val ValArchaeologicalSite = ("archaeological_site", "A place in which evidence of past activity is preserved ")
  val ValAircraft = ("aircraft", "A decommissioned aircraft which generally remains in one place")
  val ValBattlefield = ("battlefield", "The site of a battle or military skirmish in the past. This could be on land or at sea.")
  val ValBoundaryStone = ("boundary_stone", "A historic boundary stone usually found along the way.")
  val ValCastle = ("", "")
  val ValCastleTypeDefensive = ("defensive", "Defensive castle. Fortified, defensible dwelling or military stronghold")
  val ValCastleTypePalace = ("palace", "A palace is a grand residence, especially a royal residence or the home of a head of state or some other high-ranking dignitary, such as a bishop or archbishop.")
  val ValCastleTypeStately = ("stately", "Stately home. Representative building without functional defenses. Sometimes rebuilt from former defensive structures.")
  val ValCastleTypeManor = ("manor", "A manor house is a country house which was historically the capital residence or messuage within a manor, the basic unit of territorial organisation in the feudal system in Europe, in which dwelled the lord of the manor.")
  val ValCastleTypeFortress = ("fortress", "Fortress. Heavily fortified structure with military use.")
  val ValCastleTypeCastrum = ("castrum", "Roman fort")
  val ValCastleTypeShiro = ("shiro", "Shiro Japanese castle ")
  val ValCastleTypeKremlin = ("kremlin", "A kremlin is a major fortified central complex found in historic Russian cities. ")


  /**
   * An archeological site is mapped as a node or an area with historic=archaeological_site.
      In addition, the following parameters should be given to describe the details of the object.
    name=Name The name of the archeological site, e.g. Wikipedia Brutkamp
    site_type=bigstone - Natural stones that have been treated by humans are also listed here. Undecorated stones, even when they have mystic backgrounds or meanings, are not archaeological objects, and are mapped as natural=stone.
    site_type=petroglyph - Rock carving
    site_type=tumulus - Tumulus, a mound of earth and stones raised over a grave or graves. Tumuli are also known as barrows, burial mounds, Hügelgrab or kurgans. Examples: Wikipedia Tumulus and Wikipedia Tumulus. See also historic=tomb with tomb=tumulus.
            field=yes - Some graveyards consist of a number of tumuli. To avoid mapping all of them, the field tag can be used as an option.
            Please note that at least some tumuli are also megalith structures and that there is a proposal for mapping them as tombs as well (see below).
    site_type=megalith - Megalith (as in English, German), mégalithe (French) = one or more stone boulders, decorated or undecorated, e.g. Wikipedia Megalith or Wikipedia Megalith.
            In many cases the Megaliths can be further differentiated, as in:
            megalith_type=dolmen - Dolmen (as in French, English), Großsteingrab (German) - single-chamber megalithic tomb, see Wikipedia dolmen, Wikipedia dolmen
            megalith_type=menhir - Menhir (as in French, English), Hinkelstein (German) = large upright standing stone, see Wikipedia menhir, Wikipedia menhir and Wikipedia Menhir
            megalith_type=alignment - megalithic alignment or stone row (English), alignement mégalithique (French), Steinreihe (German); see Wikipedia stone row, Wikipedia alignement mégalithique and Wikipedia Steinreihe
            megalith_type=stone_circle - stone circle (Ger. Steinkreis, Engl. stone circle, Fr. cromlech), see Wikipedia Steinkreis
            proposed icon
            megalith_type=grosssteingrab - Avoid. Prefer the English word: dolmen , single-chamber megalithic tomb, best known as dolmen (French, English), or Großsteingrab, aka Hünengrab (German) – not to be confused with a hill tomb, or tumulus (French), aka Hügelgrab (German) ! — see Wikipedia dolmen and Wikipedia Großsteingrab
            megalith_type=passage_grave - passage grave (Ger. Ganggrab): Wikipedia Ganggrab - also called (Ger.) Langbett = long bed.
            megalith_type=chamber - only fragments of the grave are visible and the type can no longer be identified.
            moved=yes - optional - there are graves that have been moved. [1]
            When naming the megaliths, there is no avoiding the use the regional terms that have been coined in the different historical records and the varied history of the archaeological research. A unified English terminology is not possible, because for specific types of megaliths either no English word exists, or the established localised terminology is in use.
    site_type=necropolis - Necropolis
    site_type=fortification - moats or mounds as remains of former fortifications
            fortification_type=hill_fort - mounds (incl. Ger. Burgwälle, Wallburgen, Ringwälle etc., En. hill fort, Fr. castro): Wikipedia Wallburg and Wikipedia Hill fort
            fortification_type=limes - Roman Limes: Wikipedia Limes (Grenzwall) and Wikipedia Limes
            fortification_type=sconce - Sconce, small protective fortification since the 19th century: Wikipedia Schanze (Festungsbau) and Wikipedia Sconce (fortification)
            fortification_type=ring_ditch - concentric circular ditches: Wikipedia Kreisgrabenanlagen
    site_type=settlement - places where humans (or hominins like neanderthals) lived. Such sites contains manmade tools, weapons, pottery and various houseware, which form cultural layers. Usually those sites has no buildings or only foundations of buildings left. If there is some buildings or walls left, use historic=ruins or other appropriate tags instead.
The following optional tags may also be useful on complement.
    historic:civilization=* (or more precise subtags) - for the civilization (culture) that originally created the feature
    sprockhoff=number - many graveyards are listed in the German Atlas der Megalithgräber by Wikipedia Ernst Sprockhoff and can be referenced by this number.
    ref:mhs=number - most archeological sites in France (even the smallest ones notably all prehistoric sites, unless their discovery is extremely recent) are classified as Monuments historiques in the public Merimée database, the number usually starting by "PA followed by digits brings details about the site, its approximate location and dmensions, its approximative date of construction, its state of conservation, a possible restauration, its level of protection, and accessibility (or not) to the public
   */
  def archaeological_site() = ???


  /**
   * How to Map
    Tag 	Notes
    historic=aircraft 	for the node or the outline of the aircraft
    name=* 	name of the aircraft (possibly it's type, e.g., B-747)
    tourism=attraction 	to mark it as a tourist attraction
    Additonal tags
    Tag 	Notes
    operator=* 	for the operator of the aircraft
    start_date=* 	for the construction date of the aircraft
    wikipedia=* 	museum aircraft often have a Wikipedia page which can be tagged here
   * @return
   */
  def aircraft() = ???

  /**
   * Tags to use in combination

    historic=battlefield
    name=<name of the battle> (optional)
    date=<date of the battle> (optional) (or documented tag start_date=*)
   * @return
   */
  def battlefield() = ???


  /**
   * name=*
    inscription=* - inscriptions on the sides of the marker could be separated by a sign "/"
    year=#### (year) (or documented tag start_date=*)
    moved=yes - indicates that the marker is not on its original position
    format=* - describes the shape of the marker
    format:top=* - describes the shape of the marker's top
    height=* - height of the marker
    moved=yes - the marked is not on its original position
    collection=yes - the marker is a part of the collection of historical markers
    ref=* - the number written on the marker
    old_ref=* - the (old, changed) number written on the marker
   * @return
   */
  def boundary_stone() = ???

  /**
   * name=Name - name of the site, for example Windsor Castle.
    castle_type=type - classification of the castle. Currently under discussion. See section below for details
    wikipedia=name of article - for most of the castles in Central Europe an article in Wikipedia exists. You should tag articles linking to one of the different languages available, e.g.
        German: wikipedia=de:Schloss_Pillnitz
          or
        English : wikipedia=en:Pillnitz
    ruins=yes - set this tag when the castle is a ruin, that means if only remains of buildings without roof or at least some walls exist. (don't use historic=ruins anymore).
    building:condition=* - for a larger scale of building conditions
   * @return
   */
  def castle() = ???

  def museum(name:String):MongoDBObject = common.historicType(ValMuseum, MongoDBObject("name" -> name))
}
